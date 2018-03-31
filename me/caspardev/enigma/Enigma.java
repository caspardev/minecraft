package me.caspardev.enigma;

import me.caspardev.enigma.event.EventManager;
import me.caspardev.enigma.event.EventTarget;
import me.caspardev.enigma.event.events.EventKey;
import me.caspardev.enigma.module.ModuleManager;
import de.Hero.clickgui.ClickGUI;
import de.Hero.settings.SettingsManager;
import org.lwjgl.opengl.Display;

public class Enigma {
    public String name = "Enigma", version = "1";

    public static Enigma instance = new Enigma();

    public SettingsManager settingsManager;
    public EventManager eventManager;
    public ModuleManager moduleManager;
    public ClickGUI clickGui;

    public void startClient() {
        settingsManager = new SettingsManager();
        eventManager = new EventManager();
        moduleManager = new ModuleManager();
        clickGui = new ClickGUI();

        System.out.println("[" + name + "] Starting client, b" + version);
        Display.setTitle(name + " b" + version);

        eventManager.register(this);
    }

    public void stopClient() {
        eventManager.unregister(this);
    }

    @EventTarget
    public void onKey(EventKey event) {
        moduleManager.getModules().stream().filter(module -> module.getKey() == event.getKey()).forEach(module -> module.toggle());
    }
}
