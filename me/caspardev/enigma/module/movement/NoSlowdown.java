package me.caspardev.enigma.module.movement;

import me.caspardev.enigma.event.EventTarget;
import me.caspardev.enigma.event.events.EventPostTick;
import me.caspardev.enigma.event.events.EventPreTick;
import me.caspardev.enigma.event.events.EventSendPacket;
import me.caspardev.enigma.event.events.EventUpdate;
import me.caspardev.enigma.module.Category;
import me.caspardev.enigma.module.Module;
import net.minecraft.client.Minecraft;
import net.minecraft.item.ItemSword;
import net.minecraft.network.play.client.C02PacketUseEntity;
import net.minecraft.network.play.client.C07PacketPlayerDigging;
import net.minecraft.network.play.client.C08PacketPlayerBlockPlacement;
import net.minecraft.network.play.client.C0BPacketEntityAction;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import org.lwjgl.input.Keyboard;

public class NoSlowdown extends Module{

    public static boolean enabled;

    public NoSlowdown() {

        super("NoSlowdown", Keyboard.KEY_B, Category.MOVEMENT);

    }

    @Override
    public void onEnable() {
        super.onEnable();
        NoSlowdown.enabled = true;
    }

    @Override
    public void onDisable() {
        super.onDisable();
        NoSlowdown.enabled = false;
    }




    @EventTarget
    public void preTick(final EventPreTick e) {
        if (this.isToggled() && Minecraft.getMinecraft().thePlayer.isBlocking() &&Minecraft.getMinecraft().thePlayer.inventory.getCurrentItem().getItem() instanceof ItemSword) {
            Minecraft.getMinecraft().thePlayer.sendQueue.addToSendQueue(new C07PacketPlayerDigging(C07PacketPlayerDigging.Action.RELEASE_USE_ITEM, new BlockPos(-1, -1, -1), EnumFacing.fromAngle(-1.0)));
        }
    }

    @EventTarget
    public void postTick(final EventPostTick e) {
        if (this.isToggled() && Minecraft.getMinecraft().thePlayer.isBlocking() && Minecraft.getMinecraft().thePlayer.inventory.getCurrentItem().getItem() instanceof ItemSword) {
            Minecraft.getMinecraft().thePlayer.sendQueue.addToSendQueue(new C08PacketPlayerBlockPlacement(Minecraft.getMinecraft().thePlayer.inventory.getCurrentItem()));
        }
    }
}



