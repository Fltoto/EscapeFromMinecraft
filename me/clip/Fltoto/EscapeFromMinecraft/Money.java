package me.clip.Fltoto.EscapeFromMinecraft;


import java.io.File;
import java.io.IOException;

import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;


public class Money extends JavaPlugin{
	
	
    public static void reducemoney(String name, double money) {
    	Builder.reducemoney(name, money);
    }

    public static void addmoney(String name, double money) {
    	Builder.addmoney(name, money);
    }
    public static double getmoney(String name) {
    	return Builder.getmoney(name);
    }
}
