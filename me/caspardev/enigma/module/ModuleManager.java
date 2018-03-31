package me.caspardev.enigma.module;

import me.caspardev.enigma.module.combat.AntiBot;
import me.caspardev.enigma.module.combat.AutoArmor;
import me.caspardev.enigma.module.combat.Criticals;
import me.caspardev.enigma.module.combat.KillAura;
import me.caspardev.enigma.module.movement.*;
import me.caspardev.enigma.module.player.NoFall;
import me.caspardev.enigma.module.render.ClickGUI;
import me.caspardev.enigma.module.render.Fullbright;

import java.util.ArrayList;

public class ModuleManager {
    private ArrayList<Module> modules = new ArrayList<Module>();

    public ModuleManager() {

        // COMBAT
        modules.add(new KillAura());
        modules.add(new AntiBot());
        modules.add(new AutoArmor());
        modules.add(new Criticals());

        // MOVEMENT
        modules.add(new Sprint());
        modules.add(new Fly());
        modules.add(new Step());
        modules.add(new LongJump());
        modules.add(new Speed());
        modules.add(new NoSlowdown());

        // RENDER
        modules.add(new Fullbright());
        modules.add(new ClickGUI());

        // PLAYER
        modules.add(new NoFall());


    }

    public ArrayList<Module> getModules() {
        return modules;
    }
    public Module getModuleByName(String name) {
        return modules.stream().filter(module -> module.getName().equalsIgnoreCase(name)).findFirst().orElse(null);
    }
}
