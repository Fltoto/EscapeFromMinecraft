package me.clip.Fltoto.EscapeFromMinecraft;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

import com.sun.javafx.tk.Toolkit.Task;

import Game.Tasks;
import net.minecraft.server.v1_16_R3.World;


public class Gui extends JavaPlugin{
	static Main Main = (Main)Bukkit.getPluginManager().getPlugin("EscapeFromMinecraft");
	public static Inventory gui;
	public static Inventory joinmenu;
    public static Inventory getitem;
    public static Inventory offshop;
    public static Inventory offshopsell;
    public static Inventory playershop;
    public static Inventory playershopsell;
	public static Inventory pregui;
    public static Inventory usepregui;
    
    public static void musepregui(Player p,int id) {
		  usepregui=Main.getServer().createInventory(null, 9,"§9称号设置");	
		  if(Builder.getplayerpre(p.getName())==id) {
			  GuiBuilder.creategui(usepregui, "§c§l卸载称号", Material.RED_STAINED_GLASS_PANE, String.valueOf(id), 0);
		  }else {
			  GuiBuilder.creategui(usepregui, "§9§l使用称号", Material.BLUE_STAINED_GLASS_PANE, String.valueOf(id), 0);
		  }
			GuiBuilder.createguinolore(usepregui, "§4§l返回", Material.RED_STAINED_GLASS_PANE,8);
	  }
	  public static void mpregui(Player p) {
		  int num =Builder.getprenum();
		  pregui=Main.getServer().createInventory(null, 54,"§9称号");	
		  for(int i=1;i<=num;i++) {
			  if(Builder.getpre(i)!=null) {
				  if(Builder.isprehave(p.getName(), i)) {
					  GuiBuilder.createguinolore(pregui,Builder.getpre(i), Material.BLUE_STAINED_GLASS, i-1);
				  }else {
					  GuiBuilder.creategui(pregui,Builder.getpre(i), Material.WHITE_STAINED_GLASS,"§4未获得", i-1);
				  }
			  }
		  }
			GuiBuilder.divide(pregui);
			GuiBuilder.createguinolore(pregui, "§4§l返回", Material.RED_STAINED_GLASS_PANE,49);
	  }
    public static void mgetitem(ItemStack item) {
		  getitem=Main.getServer().createInventory(null, 9,"§b拿取你的物品!");
		  GuiBuilder.setitem(getitem, item, 0);
	  }
    public static void moffshop(Player p) {
		offshop=Main.getServer().createInventory(null, 54,"§e收购商城");	
		int num=Builder.getoffshopitemnum();
		for(int a =0;a<=num;a++) {
			if(Builder.getoffshopitem(a)!=null) {
				GuiBuilder.setoffshopitem(offshop,Builder.getoffshopitem(a),a-1);
			}
		}
		GuiBuilder.divide(offshop);
		GuiBuilder.createguinolore(offshop, "§4§l返回", Material.RED_STAINED_GLASS_PANE,49);
	}
	public static void offshopsell(Player p,int a) {
		offshopsell=Main.getServer().createInventory(null, 9,"§b出售");
		double money =Builder.getoffshopmoney(a);
		ItemStack item=Builder.getoffshopitem(a);
		GuiBuilder.creategui2Lore(offshopsell, "§a§l出售一个", Material.DIAMOND,"§2单价:"+money,String.valueOf(a), 0);
		GuiBuilder.creategui2Lore(offshopsell, "§a§l出售一组", Material.DIAMOND,"§2单价:"+money,String.valueOf(a), 1);
		GuiBuilder.creategui2Lore(offshopsell, "§a§l出售全部", Material.DIAMOND_BLOCK,"§2单价:"+money,String.valueOf(a), 2);
		GuiBuilder.createguinolore(offshopsell, "§4§l返回", Material.RED_STAINED_GLASS_PANE,8);
	}
	
	public static void mplayershop(Player p,int page) {
		playershop=Main.getServer().createInventory(null, 54,"全球市场页码:"+String.valueOf(page));	
		for(int a =1+45*(page-1);a<=45+45*(page-1);a++) {
			//一页只有45物品
			if(Builder.getplayershopitem(a)!=null) {
				GuiBuilder.setoffshopitem(playershop,Builder.getplayershopitem(a),a-1-45*(page-1));
			}
		}
		GuiBuilder.divide(playershop);
		GuiBuilder.createguinolore(playershop, "§4§l返回", Material.RED_STAINED_GLASS_PANE,49);
		if(page != 1) {
			GuiBuilder.createguinolore(playershop, "§9§l上一页", Material.YELLOW_STAINED_GLASS_PANE, 48);
		}
		GuiBuilder.createguinolore(playershop, "§9§l下一页", Material.YELLOW_STAINED_GLASS_PANE, 50);
	}
	public static void playershopsell(Player p,int a) {
		playershopsell=Main.getServer().createInventory(null, 9,"§9购买");
		double money =Builder.getplayershopmoney(a);
		ItemStack item=Builder.getplayershopitem(a);
		GuiBuilder.creategui2Lore(playershopsell, "§a§l购买一个", Material.BOOK,"§2单价:"+money,String.valueOf(a), 0);
		GuiBuilder.creategui2Lore(playershopsell, "§a§l购买全部", Material.BOOKSHELF,"§2单价:"+money,String.valueOf(a), 1);		
		GuiBuilder.creategui(playershopsell, item.getItemMeta().getDisplayName(),item.getType(),"§e目标货物", 6);
		if(Builder.getplayershopplayer(a)!=null) {
			GuiBuilder.creategui(playershopsell, "§e§l卖家", Material.WITHER_SKELETON_SKULL, Builder.getplayershopplayer(a).getName(), 7);	
		}else {
			GuiBuilder.creategui(playershopsell, "§e§l卖家", Material.WITHER_SKELETON_SKULL, Builder.getplayershopofflineplayer(a).getName(), 7);
		}
		GuiBuilder.createguinolore(playershopsell, "§4§l返回", Material.RED_STAINED_GLASS_PANE,8);
	}
	
	public static void mgui(Player p) {
		gui =Main.getServer().createInventory(null, 9,"§8[§cEscapeFromMinecraft§8]");
		GuiBuilder.buildskull(gui,"§c§l"+p.getName(), "§a个人信息", "§cEFM§a币:"+Math.round(Money.getmoney(p.getName())), "§8§l-EFM", 0);
		GuiBuilder.creategui(gui, "§c§l加入战局", Material.DIAMOND_SWORD,"§8§l-EFM", 1);
		GuiBuilder.creategui(gui, "§c§l全球市场", Material.DIAMOND_BLOCK,"§8§l-EFM", 2);
		GuiBuilder.creategui(gui, "§c§l官方收购", Material.LAVA_BUCKET,"§8§l-EFM", 3);
		GuiBuilder.creategui(gui, "§c§l称号", Material.BOOK,"§8§l-EFM", 4);
		GuiBuilder.creategui(gui, "§c§lMCMMO", Material.DIAMOND_AXE,"§8§l-EFM", 5);
	}
	public static void mjoinmenu(Player p) {
		if(!Builder.getworldmode()) {
			joinmenu =Main.getServer().createInventory(null, 9,"§8[§c加入战局§8]");	
			GuiBuilder.creategui(joinmenu,"§c§l返回", Material.RED_STAINED_GLASS_PANE, "§8§l-EFM", 8);
		}else {
			joinmenu =Main.getServer().createInventory(null, 54,"§8[§c加入战局§8]");	
			GuiBuilder.creategui(joinmenu,"§c§l返回", Material.RED_STAINED_GLASS_PANE, "§8§l-EFM", 49);
		}
		if(!Builder.getworldmode()) {
			if(Builder.isstart) {
				GuiBuilder.creategui2Lore(joinmenu,"§c§l普通世界", Material.GRASS,"§e剩余时间 §c"+(float)Math.round(((float)Tasks.remain/60))+"§e分钟","§8§l-EFM", 0);
				GuiBuilder.creategui2Lore(joinmenu,"§c§l地狱世界", Material.CRIMSON_HYPHAE, "§e剩余时间 §c"+(float)Math.round(((float)Tasks.remain/60))+"§e分钟","§8§l-EFM", 1);	
			}else {
				GuiBuilder.creategui2Lore(joinmenu,"§c§l普通世界", Material.GRASS,"§e未开始","§8§l-EFM", 0);
				GuiBuilder.creategui2Lore(joinmenu,"§c§l地狱世界", Material.CRIMSON_HYPHAE,"§e未开始","§8§l-EFM", 1);
			}	
		}else {
			int num=Builder.getworldsnum();
			for(int i=1;i<=num;i++) {
				if(Builder.isstart) {
					GuiBuilder.creategui2Lore(joinmenu,"§c§l世界:"+i, Material.MAP,"§e剩余时间 §c"+(float)Math.round(((float)Tasks.remain/60))+"§e分钟","§8§l-EFM", i-1);
				}else {
					GuiBuilder.creategui2Lore(joinmenu,"§c§l世界:"+i, Material.MAP,"§e未开始","§8§l-EFM", i-1);
				}
			}
		}
		
	}
}
