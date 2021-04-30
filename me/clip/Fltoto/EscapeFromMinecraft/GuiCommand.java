package me.clip.Fltoto.EscapeFromMinecraft;

import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;


public class GuiCommand extends JavaPlugin{
	public static void offshop(Player p,int slot) {
		int a=slot+1;
		if(Builder.getoffshopitem(a)!=null && slot!=49) {
			Gui.offshopsell(p, a);
			p.closeInventory();
			p.openInventory(Gui.offshopsell);
		}else if(slot==49) {
			Gui.mgui(p);
			p.closeInventory();
			p.openInventory(Gui.gui);
		}
	}
	public static void sell(Player p,int slot,int a) {
		ItemStack item=Builder.getoffshopitem(a);
		int max=item.getMaxStackSize();
		double money =Builder.getoffshopmoney(a);
		if(slot ==0) {
			int b=0;
			for(int i=0;i<=45;i++) {
				if(p.getInventory().getItem(i) !=null && p.getInventory().getItem(i).getType().equals(item.getType())) {
					b=1;
				    p.getInventory().getItem(i).setAmount(p.getInventory().getItem(i).getAmount()-1);
				    break;
				}
			}
			if(b==0) {
				p.sendMessage(Main.t+"§c库存不足!");
			}else {
				p.sendMessage(Main.t+"§6成功出售!");
				Money.addmoney(p.getName(), money*b);
			}
		}
		if(slot ==1) {
			for(int i=0;i<=45;i++) {
				if(p.getInventory().getItem(i) !=null && p.getInventory().getItem(i).getType().equals(item.getType())) {
					if(p.getInventory().getItem(i).getAmount() ==max) {
						p.getInventory().setItem(i, null);
						Money.addmoney(p.getName(), money*max);
						p.sendMessage(Main.t+"§6成功出售!");
						break;	
					}
				}
			}
		}
		if(slot ==2) {
			int b=0;
			for(int i=0;i<=45;i++) {
				if(p.getInventory().getItem(i) !=null && p.getInventory().getItem(i).getType().equals(item.getType())) {
					b=b+p.getInventory().getItem(i).getAmount();
				    p.getInventory().setItem(i, null);					
				}
			}
			if(b==0) {
				p.sendMessage(Main.t+"§c库存不足!");
			}else {
				p.sendMessage(Main.t+"§6成功出售!");
				Money.addmoney(p.getName(), money*b);
			}
		}
		
	}
    public static void buy(Player p,int slot,int a,ItemStack checkitem) {
		if(Builder.getplayershopitem(a).equals(checkitem)) {
			if(slot == 0) {
				p.chat("/efm buy "+a+" 1");
			}
			if(slot == 1) {
				p.chat("/efm buy "+a+" "+checkitem.getAmount());
             }
		}
    }

}
