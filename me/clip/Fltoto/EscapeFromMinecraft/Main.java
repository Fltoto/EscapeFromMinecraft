package me.clip.Fltoto.EscapeFromMinecraft;

import java.io.File;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.OfflinePlayer;
import org.bukkit.WorldCreator;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByBlockEvent;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntitySpawnEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.entity.EntityDamageEvent.DamageCause;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.player.PlayerChatEvent;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.event.player.PlayerCommandSendEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.event.player.PlayerRespawnEvent;
import org.bukkit.event.player.PlayerTeleportEvent;
import org.bukkit.event.player.PlayerTeleportEvent.TeleportCause;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.BlockDataMeta;
import org.bukkit.material.MaterialData;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitTask;
import org.spigotmc.event.player.PlayerSpawnLocationEvent;

import com.mojang.brigadier.Message;import com.sun.org.apache.xerces.internal.parsers.IntegratedParserConfiguration;
import com.sun.swing.internal.plaf.metal.resources.metal;

import Game.GameFunctions;
import Game.Region;
import Game.ScoreBoard;
import Game.Tasks;
import io.netty.util.TimerTask;
import net.minecraft.server.v1_16_R3.BlockAir;
import net.minecraft.server.v1_16_R3.BlockBase.BlockData;
import sun.net.www.content.text.plain;
import net.minecraft.server.v1_16_R3.World;
import net.minecraft.server.v1_16_R3.WorldChunkManager;


public class Main extends JavaPlugin implements Listener{
	public static File file;
	  public static FileConfiguration list;
	  public static FileConfiguration config;
	  public static String t="??8??l[??cEFM??8??l]??f";
	  public static String t1 ="[EscapeFromMinecraft]";
	  public static String [] lang;
	  
	  public void onLoad() {
			saveDefaultConfig();
			config = getConfig();
			super.onLoad();
		}
		  public void onEnable() {
			  getLogger().severe("??cEscapeFromMinecraft????????------------????:Fltoto_LRFI");
			  getServer().getPluginManager().registerEvents((Listener) this, this);
			    if (!getDataFolder().exists()) {
				      getDataFolder().mkdir();
				    }
			    @SuppressWarnings("unused")
				File file;
			    if (!(file = new File(getDataFolder(), "config.yml")).exists()) {
			      saveDefaultConfig();
			    }
			    reloadConfig();	
			    super.onEnable();
			    Builder.freshisstart();
			    Builder.freshisok();
			    Tasks.remain=(int) Builder.getremain();
			    BukkitTask mainround=new Game.Tasks().runTaskTimer(this, 0, 20);
			    getLogger().severe("??6EscapeFromMinecraft??????????????");
			    getLogger().severe("??6EscapeFromMinecraft????????????????????");
			    getLogger().severe("??6EscapeFromMinecraft??????????????????");
			    	
		}
		 
			  //-=-=-=-=-=-=-=-=-=-=--=-=-=-=-=-=-=-=--=-=-=-=-=-=-=-=--=-=-=-=-=-=-=-=-=-=-=-=--=-=-=-=-=-=-=-=-=-=-=--=-=-=-=-=--------------------------------------------------
			  @SuppressWarnings("unlikely-arg-type")
			  
			@Override
			public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
				if(args.length ==0) {
					sender.sendMessage("??8-=-=-=-=-=-??cEFM??8=-=-=-=-=-=-=");
					sender.sendMessage("??7/efm gui ??c- ??7????EFM????");
					sender.sendMessage("??7/efm store <????> ??c- ??7??????????????????????");
					sender.sendMessage("??7/efm getgui ??c- ??7????????????");
					sender.sendMessage("??7/efm ophelp ??c- ??7????OP????");
					sender.sendMessage("??7/efm usepre <ID> ??c- ??7??????????????");
					sender.sendMessage("??8-=-=-=-=-=-??cEFM??8=-=-=-=-=-=-=");
					return true;
				}
				if(args[0].equalsIgnoreCase("help")) {
					sender.sendMessage("??8-=-=-=-=-=-??cEFM??8=-=-=-=-=-=-=");
					sender.sendMessage("??7/efm gui ??c- ??7????EFM????");
					sender.sendMessage("??7/efm store <????> ??c- ??7??????????????????????");
					sender.sendMessage("??7/efm getgui ??c- ??7????????????");
					sender.sendMessage("??7/efm ophelp ??c- ??7????OP????");
					sender.sendMessage("??7/efm usepre <ID> ??c- ??7??????????????");
					sender.sendMessage("??8-=-=-=-=-=-??cEFM??8=-=-=-=-=-=-=");
					return true;
				}
				if(args[0].equalsIgnoreCase("ophelp")) {
					sender.sendMessage("??8-=-=-=-=-=-??cEFM??8=-=-=-=-=-=-=");
					sender.sendMessage("??7/efm creategame ??c- ??7????????????????");
					sender.sendMessage("??7/efm setspawnlocation ??c- ??7??????????????????");
					sender.sendMessage("??7/efm settime <minute> ??c- ??7??????????????????");
					sender.sendMessage("??7/efm setworldsnum <num> ??c- ??7????????????????????,??????54");
					sender.sendMessage("??7/efm setworldsmode <t/f> ??c- ??7????????????????,f-????????????,t-??????????????????");
					sender.sendMessage("??7/efm releaseworlds ??c- ??7????????????");
					sender.sendMessage("??7/efm forceremake ??c- ??7????????????");
					sender.sendMessage("??7/efm addoffshop <????> ??c- ??7??????????????????????");
					sender.sendMessage("??7/efm give <ID> <PLAYER> ??c- ??7??????????????????");	
					sender.sendMessage("??7/efm create <name> <ID> ??c- ??7????????");
					sender.sendMessage("??7/efm reload ??c- ??7????????????");
					sender.sendMessage("??7/efm setbackingtime <time> ??c- ??7????????????????-??");
					sender.sendMessage("??8-=-=-=-=-=-??cEFM??8=-=-=-=-=-=-=");
					return true;
				}
				if(args[0].equalsIgnoreCase("setbackingtime")) {
					if(!sender.isOp()) {
						  sender.sendMessage(t+"??c??OP!");
						  return true;
					  }  
					  if(args.length!=2) {
						  sender.sendMessage(t+"??c??????????!");
						  return true;
					  }
					  Builder.setbackingtime(Integer.valueOf(args[1]));
					  sender.sendMessage(t+"??c????!");
					  return true;
				}
				if(args[0].equalsIgnoreCase("reload")) {
					  if(!sender.isOp()) {
						  sender.sendMessage(t+"??c??OP!");
						  return true;
					  }  
					  Builder.reload();
					  sender.sendMessage(t+"??6????????!");
					  return true;
				}
				  if(args[0].equalsIgnoreCase("getgui")) {
					  if(!(sender instanceof Player)) {
						  sender.sendMessage(t+"??c????????????!");
						  return true;
					  }
					  Player p=(Player)sender;
					  p.getInventory().addItem(Builder.getitem());
					  sender.sendMessage(t+"??6????????");
					  return true;
				  }
				  if(args[0].equalsIgnoreCase("store")) {
					  if(args.length!=2) {
						  sender.sendMessage(t+"??c??????????!");
						  return true;
					  }
					  if(!(sender instanceof Player)) {
						  sender.sendMessage(t+"??c????????????!");
						  return true;
					  }
					  Player p=(Player)sender;
					  if(p.getInventory().getItemInMainHand().getAmount() <=0) {
						  p.sendMessage(t+"??c????????????!??????????????");
						  return true;
					  }
					  ItemStack item=p.getInventory().getItemInMainHand();
					  Builder.addplayershopitem(item,Double.valueOf(args[1]), p);
					  p.setItemInHand(null);
					  Bukkit.broadcastMessage(t+"??e"+p.getName()+"????????????????????????:"+item.getType().name());			  
					  return true;
				  }
				  if(args[0].equalsIgnoreCase("addoffshop")) {
					  if(!sender.isOp()) {
						  sender.sendMessage(t+"??c??OP!");
						  return true;
					  }  
					  if(args.length!=2) {
						  sender.sendMessage(t+"??c??????????!");
						  return true;
					  }
					  if(!(sender instanceof Player)) {
						  sender.sendMessage(t+"??c????????????!");
						  return true;
					  }
					  Player p=(Player)sender;
					  if(p.getInventory().getItemInMainHand() ==null) {
						  sender.sendMessage(t+"??c??????????????!");
						  return true;
					  }
					  double money =Double.valueOf(args[1]);
					  Builder.addoffshopitem(p.getInventory().getItemInMainHand(), money);
					  p.sendMessage(t+"??6????!");
					  return true;
				  }
				if(args[0].equalsIgnoreCase("releaseworlds")) {
					if(!sender.isOp()) {
						  sender.sendMessage(t+"??c????????");
						  return true;
					  }
					Builder.copyworld();
					sender.sendMessage(t+"??6????????!");
					return true;
				}
				if(args[0].equalsIgnoreCase("forceremake")) {
					if(!sender.isOp()) {
						  sender.sendMessage(t+"??c????????");
						  return true;
					  }
					Tasks.remain =0;
					Builder.isok =false;
					sender.sendMessage(t+"??6????????????!");
					Bukkit.broadcastMessage(t+"??????????????????????????!");
					return true;
				}
				if(args[0].equalsIgnoreCase("setworldsmode")) {
					 if(!sender.isOp()) {
						  sender.sendMessage(t+"??c????????");
						  return true;
					  }
					  if(args.length!=2) {
						  sender.sendMessage(t+"??c??????????!");
						  return true;
					  }
					  if(!args[1].equalsIgnoreCase("t") && !args[1].equalsIgnoreCase("f")) {
						  sender.sendMessage(t+"??c??????????t????f!");
						  return true;
					  }
					  if(args[1].equalsIgnoreCase("t")) {
						  Builder.setworldmode(true);
						  sender.sendMessage(t+"??6????????????????????");
						  return true;
					  }else {
						  Builder.setworldmode(false);
						  sender.sendMessage(t+"??6????????????????????");
						  return true;
					  }
				}
				if(args[0].equalsIgnoreCase("setworldsnum")) {
					  if(!sender.isOp()) {
						  sender.sendMessage(t+"??c????????");
						  return true;
					  }
					  if(args.length!=2) {
						  sender.sendMessage(t+"??c??????????!");
						  return true;
					  }
					  if(!isInteger(args[1])) {
						  sender.sendMessage(t+"??c??????????!");
						  return true;
					  }
					  int num =Integer.valueOf(args[1]);
					  if(num>54) {
						  sender.sendMessage(t+"??c??????????54!");
						  return true;
					  }
					  Builder.setworldsnum(num);
					  sender.sendMessage(t+"??6????!");
					  return true;
				}
				if(args[0].equalsIgnoreCase("settime")) {
					  if(!sender.isOp()) {
						  sender.sendMessage(t+"??c????????");
						  return true;
					  }
					  if(args.length!=2) {
						  sender.sendMessage(t+"??c??????????!");
						  return true;
					  }
					  if(!isInteger(args[1])) {
						  sender.sendMessage(t+"??c??????????!");
						  return true;
					  }
					  Builder.settime(Integer.valueOf(args[1]));
					  sender.sendMessage(t+"??6????!");
					  return true;
				}
				if(args[0].equalsIgnoreCase("setspawnlocation")) {
					if(!(sender instanceof Player)) {
						  sender.sendMessage(t+"??c????????????");
						  return true;
					  }
					  Player p=(Player)sender;
					  if(!p.isOp()) {
						  sender.sendMessage(t+"??c????????");
						  return true;
					  }
					  Builder.setspawnlocation(p.getLocation());
					  sender.sendMessage(t+"??6????!");
					  return true;
				}
				if(args[0].equalsIgnoreCase("creategame")) {
					if(!(sender instanceof Player)) {
						  sender.sendMessage(t+"??c????????????");
						  return true;
					  }
					  Player p=(Player)sender;
					  if(!p.isOp()) {
						  sender.sendMessage(t+"??c????????");
						  return true;
					  }
					  Builder.creategamemap_normal();
					  Builder.creategamemap_end();
					  sender.sendMessage(t+"??6????!");
					  return true;
				}
				if(args[0].equalsIgnoreCase("setgui")) {
					  if(!(sender instanceof Player)) {
						  sender.sendMessage(t+"??c????????????");
						  return true;
					  }
					  Player p=(Player)sender;
					  if(!p.isOp()) {
						  sender.sendMessage(t+"??c????????");
						  return true;
					  }
					  if(p.getInventory().getItemInMainHand() ==null) {
						  sender.sendMessage(t+"??c????????!");
						  return true;
					  }
					  Builder.setitem(p.getInventory().getItemInMainHand());
					  sender.sendMessage(t+"??6????!");
					  return true;
				  }
				if(args[0].equalsIgnoreCase("gui")) {
					if(!(sender instanceof Player)) {
					   sender.sendMessage(t+"??c????????????!");
					   return true;
					}
					Player p=(Player)sender;
					p.closeInventory();
					Gui.mgui(p);
					p.openInventory(Gui.gui);
					return true;
				}
				 if(args[0].equalsIgnoreCase("buy")) {
					  if(args.length!=3) {
						  sender.sendMessage(t+"??c??????????!");
						  return true;
					  }
					  if(!(sender instanceof Player)) {
						  sender.sendMessage(t+"??c????????????!");
						  return true;
					  }
					  Player p=(Player)sender;
					  int a=Integer.valueOf(args[1]);
					  int num=Integer.valueOf(args[2]);
					  if(Builder.getplayershopitem(a)==null) {
						  sender.sendMessage(t+"??c??????????!");
						  return true;
					  }
					  double money =Builder.getplayershopmoney(a);
					  if(Money.getmoney(p.getName())<num*money) {
						  sender.sendMessage(t+"??c????????!");
						  return true;
					  }
					  Money.reducemoney(p.getName(), money*num);
					  p.closeInventory();
					  ItemStack item=Builder.getplayershopitem(a);
					  ItemStack ni =item;
					  int amount =item.getAmount();
					  ni.setAmount(num);
					  Gui.mgetitem(ni);
					  if(Builder.getplayershopplayer(a)==null) {
						  OfflinePlayer b=Builder.getplayershopofflineplayer(a);
						  Money.addmoney(b.getName(), money*num);
						  Builder.setplayerbuying(p, b.getName(), money);
					  }else {
						  Player b=Builder.getplayershopplayer(a);
						  Money.addmoney(b.getName(), money*num);
						  b.sendMessage(t+"??6"+p.getName()+"????????:"+item.getType().name()+amount+"??,????:"+money*num+"??!");  
						  Builder.setplayerbuying(p, b.getName(), money);
					  }
					  Builder.setplayershopitemremain(a, amount-num);
					  p.closeInventory();
					  p.openInventory(Gui.getitem);
					  return true;
				  }
				 if(args[0].equalsIgnoreCase("give")) {
					  if(args.length !=3) {
						  sender.sendMessage(t+"??c??????????");
						  return true;
					  }
					  if(!sender.isOp()) {
						  sender.sendMessage(t+"??c??OP!");
						  return true;
					  }
					  if(Builder.isprehave(args[2], Integer.valueOf(args[1]))) {
						  sender.sendMessage(t+"??c????????????!");
						  return true;
					  }
					  Builder.setplayerownPre(args[2], Integer.valueOf(args[1]));
					  sender.sendMessage(t+"??5????!");
					  if(Bukkit.getPlayer(args[2])!=null) {
						  Bukkit.getPlayer(args[2]).sendMessage(t+"??6??????????????!ID:"+args[1]);
						  Bukkit.getPlayer(args[2]).sendMessage(t+"??6/oasis usepre <ID>??????????????,????????GUI??????????????????!");
					  }
					  return true;
				  }
				  if(args[0].equalsIgnoreCase("create")) {
					  if(args.length !=3) {
						  sender.sendMessage(t+"??c??????????");
						  return true;
					  }
					  if(!sender.isOp()) {
						  sender.sendMessage(t+"??c??OP!");
						  return true;
					  }
					  Builder.createpre(args[1],Integer.valueOf(args[2]));
					  sender.sendMessage(t+"??5????!");
					  return true;
				  }
				  if(args[0].equalsIgnoreCase("usepre")) {
					  if(!(sender instanceof Player)) {
						  sender.sendMessage(t+"??c????????????");
						  return true;
					  }
					  if(args.length !=2) {
						  sender.sendMessage(t+"??c??????????");
						  return true;
					  }
					  Player p=(Player)sender;
					  if(!Builder.isprehave(p.getName(), Integer.valueOf(args[1]))) {
						  sender.sendMessage(t+"??c????????????!");
						  return true;
					  }
					  Builder.setplayerpre(p.getName(), Integer.valueOf(args[1]));
					  sender.sendMessage(t+"??5????!");
					  return true;
				  }
				if(args[0].equalsIgnoreCase("test")) {
					if(!(sender instanceof Player)) {
						   sender.sendMessage(t+"??c????????????!");
						   return true;
						}
						Player p=(Player)sender;
					if(!p.isOp()) {
					       sender.sendMessage(t+"??c????????");
						   return true;
					  }
					Builder.copyworld();
					return true;
				}
				sender.sendMessage(t+"??c??????????!");
				return false;
			  }
			  
			  @EventHandler
			  public static void Inventory(InventoryClickEvent event) {
				  Player p =(Player) event.getWhoClicked();
				  if(event.getView().getTitle().equalsIgnoreCase("??8[??cEscapeFromMinecraft??8]")) {
					  int slot = event.getSlot();
					  if(slot==1) {
						  p.closeInventory();
						  Gui.mjoinmenu(p);
						  p.openInventory(Gui.joinmenu);
					  }
					  if(slot ==2) {
						  p.closeInventory();
						  Gui.mplayershop(p, 1);
						  p.openInventory(Gui.playershop);
					  }
					  if(slot==3) {
						  p.closeInventory();
						  Gui.moffshop(p);
						  p.openInventory(Gui.offshop);
					  }
					  if(slot==4) {
						  p.closeInventory();
						  Gui.mpregui(p);;
						  p.openInventory(Gui.pregui);
					  }
					  if(slot ==5) {
						  p.closeInventory();
						  p.chat("/stats");
					  }
					  event.setCancelled(true);
				  }
				  if(event.getView().getTitle().equalsIgnoreCase("??8[??c??????????8]")) {
					  int slot = event.getSlot();
					  event.setCancelled(true);
					  if(!Builder.getworldmode()) {
						  if(slot==0) {
							  p.closeInventory();
							  Builder.randomteleport(p, Bukkit.getWorld("efm_world_normal"));
						  }
						  if(slot==1) {
							  p.closeInventory();
							  Builder.randomteleport(p, Bukkit.getWorld("efm_world_nether"));
						  }
						  if(slot==8) {
							  p.closeInventory();
							  Gui.mgui(p);
							  p.openInventory(Gui.gui);
						  }  
					  }else {
						  if(slot ==49) {
							  p.closeInventory();
							  Gui.mgui(p);
							  p.openInventory(Gui.gui);
						  }
						  if(slot!=49 &&slot<=Builder.getworldsnum()) {
							  p.closeInventory();
							  Builder.randomteleport(p, Bukkit.getWorld("efm_world_"+Math.addExact(slot, 1)));
						  }
					  }
				  }
				  if(event.getView().getTitle().equalsIgnoreCase("??9????")) {
					  event.setCancelled(true);
					  int slot =event.getSlot();
					  if(event.getView().getItem(slot)!=null && slot<45) {
						  if(event.getView().getItem(slot).getItemMeta().getLore()==null) {
							  Gui.musepregui(p, slot+1);
							  p.closeInventory();
							  p.openInventory(Gui.usepregui);
						  }
					  }
					  if(slot==49) {
						  Gui.mgui(p);
						  p.closeInventory();
						  p.openInventory(Gui.gui);
					  }
				  }
				  if(event.getView().getTitle().equalsIgnoreCase("??9????????")) {
					  event.setCancelled(true);
					  int slot =event.getSlot();
					  if(event.getView().getItem(slot)!=null) {
						  if(event.getView().getItem(slot).getItemMeta().getDisplayName().equalsIgnoreCase("??c??l????????")) {
							  Builder.setplayerpre(p.getName(), 0);
							  p.sendMessage(t+"??6????!");
							  p.closeInventory();
						  }
						  if(event.getView().getItem(slot).getItemMeta().getDisplayName().equalsIgnoreCase("??9??l????????")) {
							  Builder.setplayerpre(p.getName(),Integer.valueOf(event.getView().getItem(slot).getItemMeta().getLore().get(0)));
							  p.sendMessage(t+"??6????!");
							  p.closeInventory();
						  }
					  }
					  if(slot ==8) {
						  p.closeInventory();
						  Gui.mpregui(p);
						  p.openInventory(Gui.pregui);
					  }
				  }
				  if(event.getView().getTitle().equalsIgnoreCase("??b????????????!")) {
					  boolean a=Builder.getplayerable(p);
					  if(event.getRawSlot()>8 && !a) {
						  event.setCancelled(true);
					  }
					  if(event.getRawSlot()<8 && !a){
						  Builder.setplayerabledrag(p, true);
					  }
					  if(event.getRawSlot()>8 && a){
						  Builder.setplayerabledrag(p, false);
					  }
				  }
				  if(event.getView().getTitle().equalsIgnoreCase("??e????????")) {
					  event.setCancelled(true);
					  GuiCommand.offshop(p, event.getSlot());
				  }
				  if(event.getView().getTitle().equalsIgnoreCase("??b????")) {
					  event.setCancelled(true);
					  int slot =event.getSlot();
						if(slot ==8) {
							Gui.moffshop(p);
							p.closeInventory();
							p.openInventory(Gui.offshop);
						} else {
							if(event.getView().getItem(slot).getItemMeta().getLore().get(1)!=null) {
								GuiCommand.sell(p, event.getSlot(), Integer.valueOf(event.getView().getItem(slot).getItemMeta().getLore().get(1))); 	
							}
							
						}
				  }
				  if(event.getView().getTitle().substring(0, 4).equalsIgnoreCase("????????")) {
					  event.setCancelled(true);
					  int page =Builder.getstringint(event.getView().getTitle());
					  int slot=event.getSlot();
					  if(slot == 49) {
						  Gui.mgui(p);
						  p.closeInventory();
						  p.openInventory(Gui.gui);
					  }else if(slot !=48 &&slot!=50 && slot<=44){
						  Gui.playershopsell(p, slot+1+45*(page-1));
						  p.closeInventory();
						  p.openInventory(Gui.playershopsell);
					  }
					  if(slot ==48) {
						  if(page!=1) {
							  Gui.mplayershop(p, page-1);
							  p.closeInventory();
							  p.openInventory(Gui.playershop);
						  }
					  }
					  if(slot ==50) {
						  Gui.mplayershop(p, page+1);
						  p.closeInventory();
						  p.openInventory(Gui.playershop);
					  }
				  }
				  if(event.getView().getTitle().equalsIgnoreCase("??9????")) {
					  event.setCancelled(true);
					  int slot =event.getSlot();
						if(slot ==8) {
							Gui.mplayershop(p,1);
							p.closeInventory();
							p.openInventory(Gui.playershop);
						} else {
							if(event.getView().getItem(slot).getItemMeta().getLore().get(1)!=null) {
								int a=Integer.valueOf(event.getView().getItem(slot).getItemMeta().getLore().get(1));
								GuiCommand.buy(p, event.getSlot(),a,Builder.getplayershopitem(a)); 	
							}
						}
				  }

			  }
			  @EventHandler
			  public static void PlayerMoveEvent(PlayerMoveEvent event) {
				  Player p=(Player)event.getPlayer();
				  if(Builder.getback(p)) {
					  Location a=Builder.getbackinglocation(p);
					  Location pa=p.getLocation();
					  if(a.getX()!=pa.getX() || a.getY()!=pa.getY()||a.getZ()!=pa.getZ()) {
						  Builder.setback(p, false);
						  Tasks.removebacking(p);
						  Builder.setbackinglocation(p, null);
						  p.sendMessage(t+"??c????????????????????????????!");  
					  }
				  }
				  if(p.isInWater()) {
					  if(Builder.getfallprotect(p)) {
						  Builder.setfallprotect(p, false);
					  }
				  }
			  }
			  @EventHandler(priority = EventPriority.HIGHEST)
			  public static void PlayerChatEvent(PlayerChatEvent event) {
				  Player p=event.getPlayer();
				  event.setCancelled(true);
				  int chat=Builder.getpchatarea(p);
				  if(event.getMessage().equalsIgnoreCase(".b")) {
					  Tasks.setbacking(p);
					  Builder.setback(p, true);
					  Builder.setbackinglocation(p, p.getLocation());
					  p.sendMessage(t+"??3??????????:"+Builder.getbackingtime()+"??!");
				  }else {
				  for(Player e:Bukkit.getOnlinePlayers()) {
					  if(Builder.getpchatarea(e)==chat) {
						  if(Builder.getplayerpre(p.getName())!=0) {
							  Bukkit.broadcastMessage("??l??b[??3"+Builder.getpre(Builder.getplayerpre(p.getName()))+"??l??b]??f["+p.getName()+"]??7??:??l??f"+event.getMessage());
						  }else {
							  Bukkit.broadcastMessage("["+p.getName()+"]??7??:??l??f"+event.getMessage());
						  }  
					  }
				  }
				  }
			  }
			  @EventHandler
			  public static void PlayerDamage(EntityDamageEvent event) {
				  if(event.getEntity() instanceof Player) {
					  Player p =(Player)event.getEntity();
					  if(event.getCause().equals(DamageCause.FALL)) {
						  if(Builder.getfallprotect(p)) {
							  event.setCancelled(true);
							  Builder.setfallprotect(p, false);
						  }
					  }
				  }
			  }
			  @EventHandler
			  public static void playerdead(PlayerDeathEvent event) {
				  Player p=event.getEntity();
				  Builder.setdead(p, true);
			  }
			  @EventHandler(priority = EventPriority.HIGHEST)
			  public static void fuhuo(PlayerRespawnEvent event) {
					  Player p=(Player)event.getPlayer();
					  if(Builder.isdead(p)) {
						  GameFunctions.PlayerQuitWar_Respawn(p, event);
					  }			
					  if(Builder.getisquit(p)) {
						  Builder.setisquit(p, false);
						  p.sendMessage(t+"??c????????????????????????????????????.");
					  }
			  }
			  @EventHandler
			  public static void comamnd(PlayerCommandPreprocessEvent event){
				  Player p=event.getPlayer();
				  if(!p.isOp()) {
					  if(Builder.isinwar(p)) {
						  p.sendMessage(t+"??c??????????????????????!");
						  event.setCancelled(true);
					  }
				  }
			  }
			  @EventHandler
			  public static void Teleport(PlayerTeleportEvent event) {
				  Player p=event.getPlayer();
				  System.out.println("1");
				  if(!p.isOp() && Builder.isinwar(p)) {
					  System.out.println("2");
					  if(!event.getTo().getWorld().equals(p.getWorld())) {
						  p.sendMessage(t+"??c????????????????????????!");
						  event.setCancelled(true);
					  }  
				  }
				  if(Builder.isinwar(p) && Builder.getfallprotect(p)) {
					  Location a=p.getLocation();
					  a.setY(a.getY()-1);
					  if(!p.getWorld().getBlockAt(a).getType().equals(Material.AIR)) {
						  Builder.setfallprotect(p, false);
					  }
				  }
			  }
			  @EventHandler
			  public static void Use(PlayerInteractEvent event) {
					Player p =event.getPlayer();
					if(event.getItem()!=null) {
						ItemStack item=p.getInventory().getItemInMainHand();
						if(item.getType().equals(Builder.getitem().getType())) {
							p.chat("/efm gui");	
						}
					}
			  }
			  @EventHandler
			  public static void PlayerQuitEvent(PlayerQuitEvent event) {
				  Player p=event.getPlayer();
				  if(Builder.isinwar(p)) {
					  p.setHealth(0);
					  Builder.setisquit(p, true);
				  }
			  }
			  @EventHandler
			  public static void playercloseinventory(InventoryCloseEvent event) {
				  Player p=(Player) event.getPlayer();
				  if(event.getView().getTitle().equalsIgnoreCase("??b????????????!")) {
					  Inventory inv = event.getInventory();
					  boolean iscancel=false;
					  ItemStack[] items=new ItemStack[9];
					  for(int i=0;i<=8;i++) {
						  if(inv.getItem(i)!=null && !iscancel) {
							  iscancel =true;
							  items[i]=inv.getItem(i);
						  }
					  }
					  ItemStack newitem = new ItemStack(Material.AIR);
					  if(iscancel) {
						  iscancel =false;
						  int amount =0;
						  for(int i =0;i<=8;i++) {
							  if(items[i]!=null) {
								  amount =amount+items[i].getAmount();
								  newitem =items[i];
							  }
						  }
						  double money =Builder.getplayerbuyingmoney(p);
						  String name=Builder.getplayerbuyingname(p);
						  Money.addmoney(p.getName(), money*amount);
						  p.sendMessage(Main.t+"??c??????????!??????????????!");
						  newitem.setAmount(amount);
						  if(Bukkit.getPlayer(name)!=null) {
							  Player b=Bukkit.getPlayer(name);
							  Builder.addplayershopitem(newitem, money, b);
							  Money.reducemoney(b.getName(), money*amount);
							  b.sendMessage(t+"??c????????:"+newitem.getType().name()+"*"+amount+"????????!??????????????!??????????????!");
						  }else {
							  OfflinePlayer b=Bukkit.getOfflinePlayer(name);
							  Money.reducemoney(b.getName(), money*amount);
							  Builder.addofflineplayershopitem(newitem, money, b);
						  }
						  Builder.removeplyaerbuying(p);
					  }else {
						   Builder.removeplyaerbuying(p);
					  }
				  }
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
