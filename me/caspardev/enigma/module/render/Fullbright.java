package me.caspardev.enigma.module.render;

import me.caspardev.enigma.event.EventTarget;
import me.caspardev.enigma.event.events.EventUpdate;
import me.caspardev.enigma.module.Category;
import me.caspardev.enigma.module.Module;
import org.lwjgl.input.Keyboard;

public class Fullbright extends Module {
    private float oldBrightness;

    public Fullbright() {
        super("Fullbright", Keyboard.KEY_C, Category.RENDER);
    }

    @Override
    public void onEnable() {
        super.onEnable();

        oldBrightness = mc.gameSettings.gammaSetting;
    }

    @EventTarget
    public void onUpdate(EventUpdate event) {
        mc.gameSettings.gammaSetting = 10F;
    }

    @Override
    public void onDisable() {
        super.onDisable();

        mc.gameSettings.gammaSetting = oldBrightness;
    }
}
