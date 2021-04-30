package me.clip.Fltoto.EscapeFromMinecraft;

import java.io.File;
import java.io.IOException;

import org.bukkit.Bukkit;
import org.bukkit.Difficulty;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.OfflinePlayer;
import org.bukkit.World;
import org.bukkit.World.Environment;
import org.bukkit.WorldCreator;
import org.bukkit.block.Block;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.craftbukkit.v1_16_R3.block.CraftBlock;
import org.bukkit.craftbukkit.v1_16_R3.block.data.CraftBlockData;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

import com.mysql.fabric.Server;
import com.onarandombox.MultiverseCore.api.MVPlugin;
import com.onarandombox.MultiverseCore.api.MVWorldManager;
import com.onarandombox.MultiverseCore.api.MultiverseWorld;
import com.sun.javafx.geom.Matrix3f;
import com.sun.org.apache.bcel.internal.generic.LSTORE;

import Game.ScoreBoard;
import Game.Tasks;
import Tools.IOFUNCTIONS;
import Tools.Zips;
import jdk.nashorn.internal.ir.ReturnNode;

public class Builder extends JavaPlugin{
	static Main Main = (Main)Bukkit.getPluginManager().getPlugin("EscapeFromMinecraft");
	public static File file = new File(Main.getDataFolder(), "config.yml");
	public static FileConfiguration list =load(file);
	public static FileConfiguration config;
	public static boolean isstart;
	public static boolean isok;
	
	public static boolean getback(Player p) {
		return list.getBoolean("backing."+p.getName());
	}
	public static void setback(Player p,boolean t) {
		list.set("backing."+p.getName(), t);
		try {
			list.save(file);
		} catch (IOException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}
	public static int getbackingtime() {
		return list.getInt("backingtime");
	}
	public static void setbackingtime(int t) {
		list.set("backingtime", t);
		try {
			list.save(file);
		} catch (IOException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}
	public static void reload() {
		file = new File(Main.getDataFolder(), "config.yml");
        list =load(file);
	}
	  public static int getpchatarea(Player p) {
		  return list.getInt("chat."+p.getName());
	  }
	  public static void setpchatarea(Player p,int a) {
		  list.set("chat."+p.getName(), a);
		  try {
			list.save(file);
		} catch (IOException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	  }
	  public static int getstringint(String str) {
		    str = str.trim();
		    String str2 = "";
		    if (str != null && !"".equals(str)) {
		        for (int i = 0; i < str.length(); i ++) {
		            if (str.charAt(i) >= 48 && str.charAt(i) <= 57) {
		                str2 += str.charAt(i);
		            }
		        }
		    }
		    return Integer.valueOf(str2);
	  }
	  public static boolean getworldmode() {
		  return list.getBoolean("worlds.mode");
	  }
	  public static void setworldmode(Boolean t) {
		  list.set("worlds.mode", t);
		  try {
			list.save(file);
		} catch (IOException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	  }
	  public static void copyworld() {
		  MVPlugin mv = (MVPlugin)Bukkit.getPluginManager().getPlugin("Multiverse-Core");
	      MVWorldManager manager=mv.getCore().getMVWorldManager();
		  int num =getworldsnum();
		  String folder = System.getProperty("user.dir");
		  for(int i=1;i<=num;i++) {
			 File fa=new File(folder+"\\efm_world_"+i);
			 if(fa.exists() && fa.isDirectory()) {	
				 Main.getLogger().severe(Main.t1+"正在删除:efm_world_"+i);
				 Bukkit.unloadWorld("efm_world_"+i, false);
				 manager.unloadWorld("efm_world_"+i);
				 IOFUNCTIONS.deleteDirectory(fa);
				 Main.getLogger().severe(Main.t1+"已删除:efm_world_"+i);
			 }
			 File zip=new File(folder+"\\efm_world_"+i+".zip");
			 Main.getLogger().severe(Main.t1+"正在解压:efm_world_"+i);
			 Zips.unZip(zip, folder+"\\");
			 Main.getLogger().severe(Main.t1+"已经解压:efm_world_"+i);
			 manager.loadWorld("efm_world_"+i);
	         MultiverseWorld world=manager.getMVWorld("efm_world_"+i);
	         world.setPVPMode(true);
	         world.setDifficulty(Difficulty.HARD);
	         world.setGameMode(GameMode.SURVIVAL);
	         world.setAllowAnimalSpawn(true);
	         world.setAllowMonsterSpawn(true);
			 setworldspawn(Bukkit.getWorld("efm_world_"+i));
		  }
	  }
	  
	  public static void setworldsnum(int num) {
		  list.set("worlds.num", num);
		  try {
			list.save(file);
		} catch (IOException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	  }
	  public static int getworldsnum() {
		  return list.getInt("worlds.num");
	  }
	  
	  public static double getremain() {
		return list.getInt("remaintime");
	  }
	  public static void setremain(double time) {
		  list.set("remaintime", time);
		  try {
			list.save(file);
		} catch (IOException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	  }
	  public static void freshisok() {
		  isok=list.getBoolean("isok");
	  }
	  public static void setisok(boolean t) {
		list.set("isok", t);
		isok =t;
		try {
			list.save(file);
		} catch (IOException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	  }
	  public static int getminute() {
		  int time =list.getInt("time");
		  if(time==0) {
			  return 10;
		  }else{
			  return time;
		  }
	  }
	  public static void settime(int minute) {
		  list.set("time", minute);
		  try {
			list.save(file);
		} catch (IOException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	  }
	  public static boolean isgamestart() {
		  return isstart;
	  }
	  public static void freshisstart() {
		  isstart =list.getBoolean("isstart");
	  }
	  public static void setgamestart(boolean t) {
		  list.set("isstart", t);
		  isstart =t;
		  try {
			list.save(file);
		} catch (IOException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	  }
	  public static Location getspawnlocation() {
		return list.getLocation("spawnlocation");
	  }
	  public static void setspawnlocation(Location a) {
		  list.set("spawnlocation",a);
		  try {
			list.save(file);
		} catch (IOException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	  }
	  public static boolean isinwar(Player p) {
		  return list.getBoolean("Player."+p.getName()+".isinwar");
	  }
	  public static void setinwar(Player p,boolean t) {
		  list.set("Player."+p.getName()+".isinwar", t);
		  try {
			list.save(file);
		} catch (IOException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	  }
	  public static void setdead(Player p,boolean t) {
		  list.set("Player."+p.getName()+".isdead", t);
		  try {
			list.save(file);
		} catch (IOException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	  }
	  public static boolean isdead(Player p) {
		  return list.getBoolean("Player."+p.getName()+".isdead");
	  }
	  public static void creategamemap_normal() {
		  MVPlugin mv = (MVPlugin)Bukkit.getPluginManager().getPlugin("Multiverse-Core");
		  MVWorldManager manager= (MVWorldManager)mv.getCore().getMVWorldManager();
		  Bukkit.unloadWorld("efm_world_normal", false);
		  manager.unloadWorld("efm_world_normal");
		  String folder =System.getProperty("user.dir");
		  File a=new File(folder+"\\efm_world_normal");
		  
		 if(a.exists()) {
			  IOFUNCTIONS.deleteDirectory(a);  
		  }
		  WorldCreator creator=new WorldCreator("efm_world_normal");
		  creator.environment(Environment.NORMAL);
		  Bukkit.createWorld(creator);
		  manager.loadWorld("efm_world_normal");
		  setworldspawn(Bukkit.getWorld("efm_world_normal"));
		  MultiverseWorld world=manager.getMVWorld("efm_world_normal");
	      world.setPVPMode(true);
	      world.setDifficulty(Difficulty.HARD);
	      world.setGameMode(GameMode.SURVIVAL);
	      world.setAllowAnimalSpawn(true);
	      world.setAllowMonsterSpawn(true);
	      world.setTime("Night");
		  isok=true;
	  }
	  public static void creategamemap_end() {
		  MVPlugin mv = (MVPlugin)Bukkit.getPluginManager().getPlugin("Multiverse-Core");
			 MVWorldManager manager= (MVWorldManager)mv.getCore().getMVWorldManager();
		  Bukkit.unloadWorld("efm_world_nether", false);
		  manager.unloadWorld("efm_world_nether");
		  String folder =System.getProperty("user.dir");
		  File a=new File(folder+"\\efm_world_nether");
		  if(a.exists()) {
			  IOFUNCTIONS.deleteDirectory(a);  
		  }
		  WorldCreator creator=new WorldCreator("efm_world_nether");
		  creator.environment(Environment.NETHER);
		  Bukkit.createWorld(creator);
		  manager.loadWorld("efm_world_nether");
		  setworldspawn(Bukkit.getWorld("efm_world_nether"));
		  MultiverseWorld world=manager.getMVWorld("efm_world_nether");
	      world.setPVPMode(true);
	      world.setDifficulty(Difficulty.HARD);
	      world.setGameMode(GameMode.SURVIVAL);
	      world.setAllowAnimalSpawn(true);
	      world.setAllowMonsterSpawn(true);
		  isok=true;
	  }
	  public static void randomteleport(Player p,World world) {
		  Location spawn=getworldspawn(world);
		  spawn.setX(spawn.getX()+Math.random()*20);
		  spawn.setY(spawn.getY()+Math.random()*10);
		  spawn.setZ(spawn.getZ()+Math.random()*20);
		  Location spawn2 =spawn;
		  spawn2.setY(spawn2.getY()+2);
		  Location spawn3 =spawn;
		  spawn3.setY(spawn3.getY()-1);
		  if(world.getBlockAt(spawn2).getType().equals(Material.AIR)){
			 p.teleport(spawn);
		     Builder.setinwar(p,true);
			 Builder.setdead(p,false);
			 Builder.setpchatarea(p, 1);
			 if(!Builder.isgamestart()) {
				 Builder.setgamestart(true);
				 Builder.setremain(Builder.getminute());
				 Bukkit.broadcastMessage(Main.t+"§b玩家"+p.getName()+"开启了逃离战争！记时:§c"+Builder.getminute()+"§b分钟");
				 Tasks.remain = Builder.getminute()*60;
			 }
			 ScoreBoard.SetPlayerMainText(p);
		  if(world.getBlockAt(spawn3).getType().equals(Material.AIR)) {
			 setfallprotect(p, true);  
				  }
		  }else {
			  randomteleport(p, world);  
		  }  
	  }
	  public static void setfallprotect(Player p,boolean t) {
		  list.set("Player."+p.getName()+".fallprotect", t);
		  try {
			list.save(file);
		} catch (IOException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	  }
	  public static boolean getfallprotect(Player p) {
		  return list.getBoolean("Player."+p.getName()+".fallprotect");
	  }
	  public static Location getworldspawn(World world) {
		  if(list.get("world."+world.getName()+".spawn")!=null) {
			  return list.getLocation("world."+world.getName()+".spawn");
		  }else {
			  setworldspawn(world);
			  return getworldspawn(world);
		  }
	  }
	  public static void setworldspawn(World world) {
		  list.set("world."+world.getName()+".spawn", jisuanworldspawn(world));
		  try {
			list.save(file);
		} catch (IOException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	  }
	  public static Location jisuanworldspawn(World world) {
		double X =Math.random()*1000;
		double Y =Math.random()*100;
		double Z =Math.random()*1000;
		Location a=new Location(world, X, Y, Z);
		if(!world.getBlockAt(a).getType().equals(Material.AIR)) {
			return a;
		}else {
			return jisuanworldspawn(world);	
		}
	}
	  
	  public static void setitem(ItemStack item) {
          list.set("gui", item);
          try {
			list.save(file);
		} catch (IOException e) {
			e.printStackTrace();
		}
	  }
	  public static ItemStack getitem() {
          if(list.getItemStack("gui")!=null) {
        	  return list.getItemStack("gui");
          }
          return null;
	  }
	  
	  public static String getplayerbuyingname(Player p) {
		  if(list.get("buying."+p.getName())!=null) {
			  return list.getString("buying."+p.getName()+".name");
		  }
		  return null;
	  }
	  public static double getplayerbuyingmoney(Player p) {
		  return list.getDouble("buying."+p.getName()+".money");
	  }
	  public static void removeplyaerbuying(Player p) {
		  list.set("buying."+p.getName(),null);
		  try {
			list.save(file);
		} catch (IOException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	  }
	  public static void setplayerbuying(Player p,String name,double money) {
		  list.set("buying."+p.getName()+".name", name);
		  list.set("buying."+p.getName()+".money", money);
		  try {
			list.save(file);
		} catch (IOException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	  }
	  public static void setplayershopitemnum(int a) {
	      list.set("playershop.num", a);  	  
		  try {
			list.save(file);
		} catch (IOException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	  }
	  public static boolean getplayerable(Player p) {
		  return list.getBoolean("ables."+p.getName());
	  }
	  public static void setplayerabledrag(Player p,boolean a) {
		  list.set("ables."+p.getName(),a);
		  try {
			list.save(file);
		} catch (IOException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	  }
	  public static int getplayershopitemnum() {
		  return list.getInt("playershop.num");
	  }
	  public static void addplayershopitem(ItemStack item,double money,Player p) {
		  list.set("playershop."+Math.addExact(getplayershopitemnum(),1)+".item", item);
		  list.set("playershop."+Math.addExact(getplayershopitemnum(),1)+".money", money);
		  list.set("playershop."+Math.addExact(getplayershopitemnum(),1)+".player", p.getName());
		  list.set("playershop.num", Math.addExact(getplayershopitemnum(),1));
		  try {
			list.save(file);
		} catch (IOException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	  }
	  public static void addofflineplayershopitem(ItemStack item,double money,OfflinePlayer p) {
		  list.set("playershop."+Math.addExact(getplayershopitemnum(),1)+".item", item);
		  list.set("playershop."+Math.addExact(getplayershopitemnum(),1)+".money", money);
		  list.set("playershop."+Math.addExact(getplayershopitemnum(),1)+".player", p.getName());
		  list.set("playershop.num", Math.addExact(getplayershopitemnum(),1));
		  try {
			list.save(file);
		} catch (IOException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	  }
	  public static void checkplayershopnext(int a) {
			  if(list.get("playershop."+(a+1))!=null) {
				  list.set("playershop."+a,list.get("playershop."+(a+1)));
				  list.set("playershop."+(a+1), null);
				  try {
					list.save(file);
				} catch (IOException e) {
					// TODO 自动生成的 catch 块
					e.printStackTrace();
				}
				  checkplayershopnext(a+1);
			  } 
	  }
	  public static void removeplayershopitem(int a) {
		  list.set("playershop."+a, null);
		  list.set("playershop.num", getplayershopitemnum()-1);
		  try {
			list.save(file);
		} catch (IOException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		  checkplayershopnext(a);
	  }	  
	  public static double getplayershopmoney(int a) {
		  return list.getDouble("playershop."+a+".money");
	  }
      public static ItemStack getplayershopitem(int a) {
    	  if(list.get("playershop."+a+".item")!=null) {
    		  return list.getItemStack("playershop."+a+".item");
    	  }
    	  return null;
      }
	  public static Player getplayershopplayer(int a) {
		  if(list.get("playershop."+a)!=null) {
			  String name=list.getString("playershop."+a+".player");
			  if(Bukkit.getPlayer(name)==null) {
				  return null;
			  }else {
				  return Bukkit.getPlayer(name);
			  }
		  }
		  return null;
	  }
	  public static OfflinePlayer getplayershopofflineplayer(int a) {
		  if(list.get("playershop."+a)!=null) {
			  String name=list.getString("playershop."+a+".player");
			  if(Bukkit.getPlayer(name)!=null) {
				  return null;
			  }else {
				  return Bukkit.getOfflinePlayer(name);
			  }
		  }
		  return null;
	  }
	  public static int getplayershopitemremain(int a) {
		  if(getplayershopitem(a)!=null) {
			  return getplayershopitem(a).getAmount();
		  }
		  return 0;
	  }
      public static void setplayershopitemremain(int a,int num) {
		  if(list.getItemStack("playershop."+a+".item")!=null) {
			  ItemStack item = list.getItemStack("playershop."+a+".item");
			  if(num<=0) {
				  removeplayershopitem(a);
			  }else {
				  item.setAmount(num);
				  list.set("playershop."+a+".item", item);
				  try {
					list.save(file);
				} catch (IOException e) {
					// TODO 自动生成的 catch 块
					e.printStackTrace();
				}
			  }
		  }
      }
	  
	  public static void setoffshopitemnum(int a) {
		  list.set("offshop.num", a);
		  try {
			list.save(file);
		} catch (IOException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	  }
	  public static int getoffshopitemnum() {
		  return list.getInt("offshop.num");
	  }
	  public static void addoffshopitem(ItemStack item,double money) {
		  list.set("offshop."+Math.addExact(getoffshopitemnum(),1)+".item", item);
		  list.set("offshop."+Math.addExact(getoffshopitemnum(),1)+".money", money);
		  list.set("offshop.num", Math.addExact(getoffshopitemnum(),1));
		  try {
			list.save(file);
		} catch (IOException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	  }
	  public static void checkoffshopnext(int a) {
			  if(list.get("offshop."+(a+1))!=null) {
				  list.set("offshop."+a,list.get("offshop."+(a+1)));
				  list.set("offshop."+(a+1), null);
				  try {
					list.save(file);
				} catch (IOException e) {
					// TODO 自动生成的 catch 块
					e.printStackTrace();
				}
				  checkoffshopnext(a+1);
			  } 
	  }
	  public static void removeoffshopitem(int a) {
		  list.set("offshop."+a, null);
		  list.set("offshop.num", getoffshopitemnum()-1);
		  try {
			list.save(file);
		} catch (IOException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		  checkoffshopnext(a);
	  }	  
	  public static double getoffshopmoney(int a) {
		  return list.getDouble("offshop."+a+".money");
	  }
      public static ItemStack getoffshopitem(int a) {
    	  if(list.get("offshop."+a+".item")!=null) {
    		  return list.getItemStack("offshop."+a+".item");
    	  }
    	  return null;
      }
      public static void reducemoney(String name, double money) {
      	list.set("Money."+name, (float)(getmoney(name)-money));
      	try {
  			list.save(file);
  		} catch (IOException e) {
  			// TODO 自动生成的 catch 块
  			e.printStackTrace();
  		}
      }

      public static void addmoney(String name, double money) {
      	list.set("Money."+name, (float)(getmoney(name)+money));
      	try {
  			list.save(file);
  		} catch (IOException e) {
  			// TODO 自动生成的 catch 块
  			e.printStackTrace();
  		}
      }
      public static double getmoney(String name) {
      	return list.getDouble("Money."+name);
      }
      public static int getplayerprenum(String p) {
          return list.getInt("Player."+p+".pre.num");
	  }
	  public static void setplayerownPre(String p,int ID) {
          int num=getplayerprenum(p);
          list.set("Player."+p+".pre"+"."+ID, true);
          try {
			list.save(file);
		} catch (IOException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
          setplayerprenum(p, num);
	  }
	  public static void createpre(String name , int ID) {
          int num=getprenum();
          list.set("pre."+Math.addExact(num, 1)+".name", name);
          list.set("pre."+Math.addExact(num, 1)+".ID", ID);
          list.set("pre.num", getprenum()+1);
          try {
			list.save(file);
		} catch (IOException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	  }
	  public static void checkprenext(int ID) {
          int num =getprenum();
          for(int i=0;i<=(num+1);i++) {
        	  if(list.getString("pre."+ID)!=null) {
        		  list.set("pre."+Math.abs(Math.addExact(ID, -1)), list.get("pre."+ID));
        		  try {
					list.save(file);
				} catch (IOException e) {
					// TODO 自动生成的 catch 块
					e.printStackTrace();
				}
        		  delpre(ID);
        	  }
          }
	  }
	  public static void delpre(int ID) {
          int uID=getdID(ID);
          int num=getprenum();
          setprenum(num-1);
          list.set("pre."+uID, null);
          try {
			list.save(file);
		} catch (IOException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
          checkprenext(ID+1);
	  }
	  public static int getdID(int ID) {
          int num=getprenum();
          for(int i=0;i<=num;i++) {
        	  if(list.getInt("pre."+i+".ID")==ID) {
        		  return i;
        	  }
          }
          return 0;
	  }
	  public static String getpre(int ID) {
          if(list.getString("pre."+ID)!=null){
        	  return list.getString("pre."+ID+".name");
          }
          return null;
	  }
	  public static void setprenum(int num) {
          list.set("pre.num", num);
          try {
			list.save(file);
		} catch (IOException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	  }
	  public static int getprenum() {
          return list.getInt("pre.num");
	  }
	  public static boolean isprehave(String p,int ID) {
    	  if(list.getBoolean("Player."+p+".pre."+ID)==true) {
    		  return true;       	  
      }
      return false;
      
  }
  public static int getplayerpre(String p) {
      return list.getInt("Player."+p+".use");
  }
  public static void setplayerpre(String p,int ID) {
      list.set("Player."+p+".use", ID);
      try {
		list.save(file);
	} catch (IOException e) {
		// TODO 自动生成的 catch 块
		e.printStackTrace();
	}
  }
  public static void setplayerprenum(String p,int num) {
      list.set("Player."+p+".pre.num", num);
      try {
		list.save(file);
	} catch (IOException e) {
		// TODO 自动生成的 catch 块
		e.printStackTrace();
	}
  }
  public static void setisquit(Player p,boolean t) {
	  list.set(p.getName()+".isquit", t);
	  try {
		list.save(file);
	} catch (IOException e) {
		// TODO 自动生成的 catch 块
		e.printStackTrace();
	}
  }
  public static boolean getisquit(Player p) {
	 return list.getBoolean(p.getName()+".isquit");
  }
  public static void setbackinglocation(Player p,Location a) {
	  list.set("Player."+p.getName()+".backinglocation",a);
	  try {
		list.save(file);
	} catch (IOException e) {
		// TODO 自动生成的 catch 块
		e.printStackTrace();
	}
  }
  public static Location getbackinglocation(Player p) {
	  if(list.get("Player."+p.getName()+".backinglocation")!=null) {
		  return list.getLocation("Player."+p.getName()+".backinglocation");
	  }
	  return null;
  }
	public static boolean isInteger(String string)
	  {
	    try
	    {
	      Integer.parseInt(string);
	      return true;
	    }
	    catch (NumberFormatException localNumberFormatException) {}
	    return false;
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
