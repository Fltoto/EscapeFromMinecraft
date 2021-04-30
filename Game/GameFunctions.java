package Game;

import java.io.File;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerRespawnEvent;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Scoreboard;

import Tools.IOFUNCTIONS;
import me.clip.Fltoto.EscapeFromMinecraft.Builder;
import me.clip.Fltoto.EscapeFromMinecraft.Main;

public class GameFunctions extends JavaPlugin{
	static Main Main = (Main)Bukkit.getPluginManager().getPlugin("EscapeFromMinecraft");
	public static File file = new File(Main.getDataFolder(), "config.yml");
	public static FileConfiguration list =load(file);
	public static FileConfiguration config;
	
	public static void PlayerQuitWar_Respawn(Player p,PlayerRespawnEvent event) {
		  p.sendMessage(Main.t+"§3您已退出战局");
		  Builder.setbackinglocation(p, null);
		  Builder.setdead(p, false);
		  Builder.setinwar(p, false);
		  Builder.setfallprotect(p, false);
		  event.setRespawnLocation(Builder.getspawnlocation());
		  Builder.setpchatarea(p, 0);
		  ScoreBoard.clean(p);
		  Tasks.removebacking(p);
	}
	public static void PlayerQuirWar_normal(Player p) {
		  p.sendMessage(Main.t+"§3您已退出战局");
		  Builder.setbackinglocation(p, null);
		  Builder.setdead(p, false);
		  Builder.setinwar(p, false);
		  Builder.setfallprotect(p, false);
		  ScoreBoard.clean(p);
		  Builder.setpchatarea(p, 0);
		  p.teleport(Builder.getspawnlocation());
		  Tasks.removebacking(p);
	}
	public static void rebuildGame() {
		  Tasks.freshbacking();
		  if(!Builder.getworldmode()) {
			  Builder.creategamemap_normal();
			  Builder.creategamemap_end();  
		  }else {
			  Builder.copyworld();
		  }
		  Builder.setisok(true);
		  Builder.setremain(Builder.getminute());
	}
	
	
	public static FileConfiguration load(File file) {
	  	  if(!file.exists()) {
	  		  try {
	  			  file.createNewFile();
	  		  }catch (Exception e) {
	  			e.printStackTrace();
	  		}
	  	  }
	  	  return org.bukkit.configuration.file.YamlConfiguration.loadConfiguration(file);
	  }

}
