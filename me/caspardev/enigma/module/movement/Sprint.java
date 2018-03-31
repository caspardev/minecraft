package me.caspardev.enigma.module.movement;

import me.caspardev.enigma.event.EventTarget;
import me.caspardev.enigma.event.events.EventUpdate;
import me.caspardev.enigma.module.Category;
import me.caspardev.enigma.module.Module;
import org.lwjgl.input.Keyboard;

public class Sprint extends Module {
    public Sprint() {
        super("Sprint", Keyboard.KEY_G, Category.MOVEMENT);
    }

    @EventTarget
    public void onUpdate(EventUpdate event) {
        if(!mc.thePlayer.isCollidedHorizontally && mc.thePlayer.moveForward > 0)
            mc.thePlayer.setSprinting(true);
    }

    @Override
    public void onDisable() {
        super.onDisable();

        mc.thePlayer.setSprinting(false);
    }
}
