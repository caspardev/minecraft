package de.Hero.clickgui.util;

import java.awt.Color;

import me.caspardev.enigma.Enigma;

/**
 *  Made by HeroCode
 *  it's free to use
 *  but you have to credit me
 *
 *  @author HeroCode
 */
public class ColorUtil {
	
	public static Color getClickGUIColor(){
		return new Color((int) Enigma.instance.settingsManager.getSettingByName("GuiRed").getValDouble(), (int) Enigma.instance.settingsManager.getSettingByName("GuiGreen").getValDouble(), (int) Enigma.instance.settingsManager.getSettingByName("GuiBlue").getValDouble());
	}
}
