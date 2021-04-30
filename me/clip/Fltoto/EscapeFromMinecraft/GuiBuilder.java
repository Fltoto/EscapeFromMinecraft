package me.clip.Fltoto.EscapeFromMinecraft;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.SkullType;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;
import org.bukkit.plugin.java.JavaPlugin;

import com.mysql.jdbc.Buffer;


public class GuiBuilder extends JavaPlugin{
	 static Main Main = (Main)Bukkit.getPluginManager().getPlugin("EscapeFromMinecraft");
	 public static void createguinolore(Inventory inv , String name , Material material , int place) {
		    ItemStack buff = new ItemStack(material, 1);
		    ItemMeta buffim = buff.getItemMeta();
		    buffim.setDisplayName(name);
		    buff.setItemMeta(buffim);
		    inv.setItem(place, buff);
	  }
	  public static void creategui(Inventory inv , String name , Material material , String lore , int place) {
		    ItemStack buff = new ItemStack(material, 1);
		    ItemMeta buffim = buff.getItemMeta();
		    buffim.setDisplayName(name);
		    List<String> bufflore = new ArrayList();
		    bufflore.add(lore);
		    buffim.setLore(bufflore);
		    buff.setItemMeta(buffim);
		    inv.setItem(place, buff);
	  }
	  public static void creategui2Lore(Inventory inv , String name , Material material , String lore,String lore2 , int place) {
		    ItemStack buff = new ItemStack(material, 1);
		    ItemMeta buffim = buff.getItemMeta();
		    buffim.setDisplayName(name);
		    List<String> bufflore = new ArrayList();
		    bufflore.add(lore);
		    bufflore.add(lore2);
		    buffim.setLore(bufflore);
		    buff.setItemMeta(buffim);
		    inv.setItem(place, buff);
	  }
	  public static void creategui3Lore(Inventory inv , String name , Material material , String lore,String lore2,String lore3 , int place) {
		    ItemStack buff = new ItemStack(material, 1);
		    ItemMeta buffim = buff.getItemMeta();
		    buffim.setDisplayName(name);
		    List<String> bufflore = new ArrayList();
		    bufflore.add(lore);
		    bufflore.add(lore2);
		    bufflore.add(lore3);
		    buffim.setLore(bufflore);
		    buff.setItemMeta(buffim);
		    inv.setItem(place, buff);
	  }
	  public static void creategui4Lore(Inventory inv , String name , Material material , String lore,String lore2,String lore3 ,String lore4, int place) {
		    ItemStack buff = new ItemStack(material, 1);
		    ItemMeta buffim = buff.getItemMeta();
		    buffim.setDisplayName(name);
		    List<String> bufflore = new ArrayList();
		    bufflore.add(lore);
		    bufflore.add(lore2);
		    bufflore.add(lore3);
		    bufflore.add(lore4);
		    buffim.setLore(bufflore);
		    buff.setItemMeta(buffim);
		    inv.setItem(place, buff);
	  }
	  public static void creategui5Lore(Inventory inv , String name , Material material , String lore,String lore2,String lore3 ,String lore4, String lore5,int place) {
		    ItemStack buff = new ItemStack(material, 1);
		    ItemMeta buffim = buff.getItemMeta();
		    buffim.setDisplayName(name);
		    List<String> bufflore = new ArrayList();
		    bufflore.add(lore);
		    bufflore.add(lore2);
		    bufflore.add(lore3);
		    bufflore.add(lore4);
		    bufflore.add(lore5);
		    buffim.setLore(bufflore);
		    buff.setItemMeta(buffim);
		    inv.setItem(place, buff);
	  }
	  public static void creategui6Lore(Inventory inv , String name , Material material , String lore,String lore2,String lore3 ,String lore4, String lore5,String lore6,int place) {
		    ItemStack buff = new ItemStack(material, 1);
		    ItemMeta buffim = buff.getItemMeta();
		    buffim.setDisplayName(name);
		    List<String> bufflore = new ArrayList();
		    bufflore.add(lore);
		    bufflore.add(lore2);
		    bufflore.add(lore3);
		    bufflore.add(lore4);
		    bufflore.add(lore5);
		    bufflore.add(lore6);
		    buffim.setLore(bufflore);
		    buff.setItemMeta(buffim);
		    inv.setItem(place, buff);
	  }
	public static void setitem(Inventory inv,ItemStack item,int place) {
	    inv.setItem(place, item);
	}
	public static void setoffshopitem(Inventory inv,ItemStack item,int place) {
	    inv.setItem(place, item);
	}
	public static void divide(Inventory buff) {
	    ItemStack g1 = new ItemStack(Material.BLACK_STAINED_GLASS_PANE, 1);
	    ItemMeta g1im = g1.getItemMeta();
	    g1im.setDisplayName("¡ì8-");
	    g1.setItemMeta(g1im);
	    for(int i=45;i<=53;i++) {
	    	buff.setItem(i, g1);
	    }
	}
	public static void backgroud_54(Inventory inv) {
		ItemStack g1 = new ItemStack(Material.WHITE_STAINED_GLASS_PANE, 1);
	    ItemMeta g1im = g1.getItemMeta();
	    g1im.setDisplayName("¡ì8-");
	    g1.setItemMeta(g1im);
	    for(int i=0;i<20;i++) {
	    	inv.setItem(i, g1);
	    }
	    for(int i=21;i<22;i++) {
	    	inv.setItem(i, g1);
	    }
	    for(int i=23;i<24;i++) {
	    	inv.setItem(i, g1);
	    }
	    for(int i=25;i<=53;i++) {
	    	inv.setItem(i, g1);
	    }
	}
	public static void buildskull(Inventory inv, String name,String title,String lore1,String lore2,int place) {
	       Player g = Bukkit.getPlayer(name);
	       ItemStack skull = new ItemStack(Material.LEGACY_SKULL_ITEM, 1, (short)3);
	       SkullMeta skullMeta = (SkullMeta)skull.getItemMeta();
	       skullMeta.setOwner(name);
	       skullMeta.setDisplayName(title);
	       List<String> skulllore = new ArrayList();
	       skulllore.add("¡ì6" + name);       
	       skulllore.add(lore1);
	       skulllore.add(lore2);
	       skullMeta.setLore(skulllore);
	       skull.setItemMeta(skullMeta);
	       inv.setItem(place, skull);            
	}
	public static void buildskull2(Inventory inv, String name,String Tile,String lore,int place) {
       Player g = Bukkit.getPlayer(name);
       ItemStack skull = new ItemStack(Material.WITHER_SKELETON_SKULL, 1, (short)SkullType.PLAYER.ordinal());
       SkullMeta skullMeta = (SkullMeta)skull.getItemMeta();
       skullMeta.setDisplayName(Tile);
       List<String> skulllore = new ArrayList();
       skulllore.add(lore);
       skullMeta.setLore(skulllore);
       skull.setItemMeta(skullMeta);
       inv.setItem(place, skull);            
}

	public static void divid_2(Inventory buff) {
	    ItemStack g1 = new ItemStack(Material.WITHER_SKELETON_SKULL, 1);
	    ItemMeta g1im = g1.getItemMeta();
	    g1im.setDisplayName(Main.lang[32]);
	    g1.setItemMeta(g1im);
	    for(int i=0;i<=45;i=i+9) {
	    	buff.setItem(i, g1);
	    }
	    for(int i=2;i<=6;i=i+1) {
	    	buff.setItem(i, g1);
	    }
	    for(int i=38;i<=43;i=i+1) {
	    	buff.setItem(i, g1);
	    }
	    for(int i=1;i<=46;i=i+9) {
	    	buff.setItem(i, g1);
	    }
	    for(int i=8;i<=53;i=i+9) {
	    	buff.setItem(i, g1);
	    }
	    for(int i=7;i<=52;i=i+9) {
	    	buff.setItem(i, g1);
	    }
	    for(int i=11;i<=15;i++) {
	    	buff.setItem(i, g1);
	    }
	    for(int i=29;i<=33;i++) {
	    	buff.setItem(i, g1);
	    }
	    for(int i=47;i<=51;i++) {
	    	buff.setItem(i, g1);
	    }
}
}
