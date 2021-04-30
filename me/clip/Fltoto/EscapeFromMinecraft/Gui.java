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
		  usepregui=Main.getServer().createInventory(null, 9,"��9�ƺ�����");	
		  if(Builder.getplayerpre(p.getName())==id) {
			  GuiBuilder.creategui(usepregui, "��c��lж�سƺ�", Material.RED_STAINED_GLASS_PANE, String.valueOf(id), 0);
		  }else {
			  GuiBuilder.creategui(usepregui, "��9��lʹ�óƺ�", Material.BLUE_STAINED_GLASS_PANE, String.valueOf(id), 0);
		  }
			GuiBuilder.createguinolore(usepregui, "��4��l����", Material.RED_STAINED_GLASS_PANE,8);
	  }
	  public static void mpregui(Player p) {
		  int num =Builder.getprenum();
		  pregui=Main.getServer().createInventory(null, 54,"��9�ƺ�");	
		  for(int i=1;i<=num;i++) {
			  if(Builder.getpre(i)!=null) {
				  if(Builder.isprehave(p.getName(), i)) {
					  GuiBuilder.createguinolore(pregui,Builder.getpre(i), Material.BLUE_STAINED_GLASS, i-1);
				  }else {
					  GuiBuilder.creategui(pregui,Builder.getpre(i), Material.WHITE_STAINED_GLASS,"��4δ���", i-1);
				  }
			  }
		  }
			GuiBuilder.divide(pregui);
			GuiBuilder.createguinolore(pregui, "��4��l����", Material.RED_STAINED_GLASS_PANE,49);
	  }
    public static void mgetitem(ItemStack item) {
		  getitem=Main.getServer().createInventory(null, 9,"��b��ȡ�����Ʒ!");
		  GuiBuilder.setitem(getitem, item, 0);
	  }
    public static void moffshop(Player p) {
		offshop=Main.getServer().createInventory(null, 54,"��e�չ��̳�");	
		int num=Builder.getoffshopitemnum();
		for(int a =0;a<=num;a++) {
			if(Builder.getoffshopitem(a)!=null) {
				GuiBuilder.setoffshopitem(offshop,Builder.getoffshopitem(a),a-1);
			}
		}
		GuiBuilder.divide(offshop);
		GuiBuilder.createguinolore(offshop, "��4��l����", Material.RED_STAINED_GLASS_PANE,49);
	}
	public static void offshopsell(Player p,int a) {
		offshopsell=Main.getServer().createInventory(null, 9,"��b����");
		double money =Builder.getoffshopmoney(a);
		ItemStack item=Builder.getoffshopitem(a);
		GuiBuilder.creategui2Lore(offshopsell, "��a��l����һ��", Material.DIAMOND,"��2����:"+money,String.valueOf(a), 0);
		GuiBuilder.creategui2Lore(offshopsell, "��a��l����һ��", Material.DIAMOND,"��2����:"+money,String.valueOf(a), 1);
		GuiBuilder.creategui2Lore(offshopsell, "��a��l����ȫ��", Material.DIAMOND_BLOCK,"��2����:"+money,String.valueOf(a), 2);
		GuiBuilder.createguinolore(offshopsell, "��4��l����", Material.RED_STAINED_GLASS_PANE,8);
	}
	
	public static void mplayershop(Player p,int page) {
		playershop=Main.getServer().createInventory(null, 54,"ȫ���г�ҳ��:"+String.valueOf(page));	
		for(int a =1+45*(page-1);a<=45+45*(page-1);a++) {
			//һҳֻ��45��Ʒ
			if(Builder.getplayershopitem(a)!=null) {
				GuiBuilder.setoffshopitem(playershop,Builder.getplayershopitem(a),a-1-45*(page-1));
			}
		}
		GuiBuilder.divide(playershop);
		GuiBuilder.createguinolore(playershop, "��4��l����", Material.RED_STAINED_GLASS_PANE,49);
		if(page != 1) {
			GuiBuilder.createguinolore(playershop, "��9��l��һҳ", Material.YELLOW_STAINED_GLASS_PANE, 48);
		}
		GuiBuilder.createguinolore(playershop, "��9��l��һҳ", Material.YELLOW_STAINED_GLASS_PANE, 50);
	}
	public static void playershopsell(Player p,int a) {
		playershopsell=Main.getServer().createInventory(null, 9,"��9����");
		double money =Builder.getplayershopmoney(a);
		ItemStack item=Builder.getplayershopitem(a);
		GuiBuilder.creategui2Lore(playershopsell, "��a��l����һ��", Material.BOOK,"��2����:"+money,String.valueOf(a), 0);
		GuiBuilder.creategui2Lore(playershopsell, "��a��l����ȫ��", Material.BOOKSHELF,"��2����:"+money,String.valueOf(a), 1);		
		GuiBuilder.creategui(playershopsell, item.getItemMeta().getDisplayName(),item.getType(),"��eĿ�����", 6);
		if(Builder.getplayershopplayer(a)!=null) {
			GuiBuilder.creategui(playershopsell, "��e��l����", Material.WITHER_SKELETON_SKULL, Builder.getplayershopplayer(a).getName(), 7);	
		}else {
			GuiBuilder.creategui(playershopsell, "��e��l����", Material.WITHER_SKELETON_SKULL, Builder.getplayershopofflineplayer(a).getName(), 7);
		}
		GuiBuilder.createguinolore(playershopsell, "��4��l����", Material.RED_STAINED_GLASS_PANE,8);
	}
	
	public static void mgui(Player p) {
		gui =Main.getServer().createInventory(null, 9,"��8[��cEscapeFromMinecraft��8]");
		GuiBuilder.buildskull(gui,"��c��l"+p.getName(), "��a������Ϣ", "��cEFM��a��:"+Math.round(Money.getmoney(p.getName())), "��8��l-EFM", 0);
		GuiBuilder.creategui(gui, "��c��l����ս��", Material.DIAMOND_SWORD,"��8��l-EFM", 1);
		GuiBuilder.creategui(gui, "��c��lȫ���г�", Material.DIAMOND_BLOCK,"��8��l-EFM", 2);
		GuiBuilder.creategui(gui, "��c��l�ٷ��չ�", Material.LAVA_BUCKET,"��8��l-EFM", 3);
		GuiBuilder.creategui(gui, "��c��l�ƺ�", Material.BOOK,"��8��l-EFM", 4);
		GuiBuilder.creategui(gui, "��c��lMCMMO", Material.DIAMOND_AXE,"��8��l-EFM", 5);
	}
	public static void mjoinmenu(Player p) {
		if(!Builder.getworldmode()) {
			joinmenu =Main.getServer().createInventory(null, 9,"��8[��c����ս�֡�8]");	
			GuiBuilder.creategui(joinmenu,"��c��l����", Material.RED_STAINED_GLASS_PANE, "��8��l-EFM", 8);
		}else {
			joinmenu =Main.getServer().createInventory(null, 54,"��8[��c����ս�֡�8]");	
			GuiBuilder.creategui(joinmenu,"��c��l����", Material.RED_STAINED_GLASS_PANE, "��8��l-EFM", 49);
		}
		if(!Builder.getworldmode()) {
			if(Builder.isstart) {
				GuiBuilder.creategui2Lore(joinmenu,"��c��l��ͨ����", Material.GRASS,"��eʣ��ʱ�� ��c"+(float)Math.round(((float)Tasks.remain/60))+"��e����","��8��l-EFM", 0);
				GuiBuilder.creategui2Lore(joinmenu,"��c��l��������", Material.CRIMSON_HYPHAE, "��eʣ��ʱ�� ��c"+(float)Math.round(((float)Tasks.remain/60))+"��e����","��8��l-EFM", 1);	
			}else {
				GuiBuilder.creategui2Lore(joinmenu,"��c��l��ͨ����", Material.GRASS,"��eδ��ʼ","��8��l-EFM", 0);
				GuiBuilder.creategui2Lore(joinmenu,"��c��l��������", Material.CRIMSON_HYPHAE,"��eδ��ʼ","��8��l-EFM", 1);
			}	
		}else {
			int num=Builder.getworldsnum();
			for(int i=1;i<=num;i++) {
				if(Builder.isstart) {
					GuiBuilder.creategui2Lore(joinmenu,"��c��l����:"+i, Material.MAP,"��eʣ��ʱ�� ��c"+(float)Math.round(((float)Tasks.remain/60))+"��e����","��8��l-EFM", i-1);
				}else {
					GuiBuilder.creategui2Lore(joinmenu,"��c��l����:"+i, Material.MAP,"��eδ��ʼ","��8��l-EFM", i-1);
				}
			}
		}
		
	}
}
