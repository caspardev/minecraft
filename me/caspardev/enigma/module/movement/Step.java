package me.caspardev.enigma.module.movement;

import me.caspardev.enigma.event.EventTarget;
import me.caspardev.enigma.event.events.EventUpdate;
import me.caspardev.enigma.module.Category;
import me.caspardev.enigma.module.Module;
import org.lwjgl.input.Keyboard;

public class Step extends Module {
    public Step() {
        super("Step", Keyboard.KEY_L, Category.MOVEMENT);
    }

    @EventTarget
    public void onUpdate(EventUpdate event) {

        if(mc.thePlayer.isCollidedHorizontally) {

            mc.thePlayer.sendQueue.addToSendQueue(new );

        }

    }

    @Override
    public void onDisable() {
        super.onDisable();


    }
}
