package Game;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scoreboard.Scoreboard;

import me.clip.Fltoto.EscapeFromMinecraft.Builder;
import sun.net.www.content.text.plain;

public class Tasks extends BukkitRunnable{
   public static String t="��8��l[��cEFM��8��l]��f";
   public static String t1 ="[EscapeFromMinecraft]";
   public static int remain=1;
   public static int backremain[] =new int[301];
   public static Player backingplayers[]=new Player[301];

	@Override
	public void run() {
		if(Builder.isstart) {
			if((remain-1)<=0) {
				Bukkit.broadcastMessage(t+"��b��һ����Ϸ�Ѿ�����!��Ϸ����1s֮���ؿ�!");
				Builder.setisok(false);
				Builder.setgamestart(false);
				for(Player p : Bukkit.getOnlinePlayers()) {
					if(Builder.isinwar(p)) {
						GameFunctions.PlayerQuirWar_normal(p);
						p.sendMessage(t+"��3���ɹ�������MC,�����Դ�������ս��Ʒ��!");
					}
				}
			}else {
				remain= (remain-1);
				Builder.setremain((double)remain/60);
				for(Player p : Bukkit.getOnlinePlayers()) {
					if(Builder.isinwar(p)) {
						ScoreBoard.SetPlayerMainText(p);
					}
				}
			}
			if(remain ==30) {
				for(Player p : Bukkit.getOnlinePlayers()) {
					if(Builder.isinwar(p)) {
						p.sendMessage(t+"��c����"+remain+"����Ϸ����!");
					}
				}
			}
			if(remain ==20) {
				for(Player p : Bukkit.getOnlinePlayers()) {
					if(Builder.isinwar(p)) {
						p.sendMessage(t+"��c����"+remain+"����Ϸ����!");
					}
				}
			}
			if(remain <=10) {
				for(Player p : Bukkit.getOnlinePlayers()) {
					if(Builder.isinwar(p)) {
						p.sendMessage(t+"��c����"+remain+"����Ϸ����!");
					}
				}
			}
		}
		if(!Builder.isok) {
			  Bukkit.broadcastMessage(t+"��b������������!");
			  GameFunctions.rebuildGame();
			  Bukkit.broadcastMessage(t+"��b��һ��������Ϸ�Ѿ�׼������!������Я���κ�������Я������Ʒ������Ϸ!");
		}
		for(int i=1;i<=300;i++) {
			if((backremain[i]-1)>0) {
				backremain[i]=backremain[i]-1;
			}else if((backremain[i]-1)<=0 && backingplayers[i]!=null) {
				backremain[i]=0;
				GameFunctions.PlayerQuirWar_normal(backingplayers[i]);
			}
		}
	}
	
	public static boolean setbacking(Player p) {
		for(int i=1;i<=300;i++) {
			if(backingplayers[i]==null) {
				backingplayers[i]=p;
				backremain[i]=Builder.getbackingtime();
				return true;
			}
		}
		return false;
	}
	public static boolean removebacking(Player p) {
		for(int i=1;i<=300;i++) {
			if(backingplayers[i]!=null) {
				if(backingplayers[i].equals(p)) {
					backingplayers[i]=null;
					backremain[i]=0;
					Builder.setback(p, false);
					return true;
				}
			}
		}
		return false;
	}
	public static void freshbacking() {
		for(int i=1;i<=300;i++) {
			backingplayers[i]=null;
			backremain[i]=0;
		}
	}
}
