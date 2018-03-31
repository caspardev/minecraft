package me.caspardev.enigma.module.render;

import de.Hero.settings.Setting;
import me.caspardev.enigma.Enigma;
import me.caspardev.enigma.module.Category;
import me.caspardev.enigma.module.Module;
import org.lwjgl.input.Keyboard;

import java.util.ArrayList;

public class ClickGUI extends Module {
    public ClickGUI() {
        super("ClickGUI", Keyboard.KEY_RSHIFT, Category.RENDER);
    }

    @Override
    public void setup() {
        ArrayList<String> options = new ArrayList<>();
        options.add("New");
        options.add("JellyLike");
        Enigma.instance.settingsManager.rSetting(new Setting("Design", this, "JellyLike", options));
        Enigma.instance.settingsManager.rSetting(new Setting("Sound", this, false));
        Enigma.instance.settingsManager.rSetting(new Setting("GuiRed", this, 255, 0, 255, true));
        Enigma.instance.settingsManager.rSetting(new Setting("GuiGreen", this, 0, 0, 255, true));
        Enigma.instance.settingsManager.rSetting(new Setting("GuiBlue", this, 0, 0, 255, true));
    }

    @Override
    public void onEnable() {
        super.onEnable();

        mc.displayGuiScreen(Enigma.instance.clickGui);
        toggle();
    }
}
