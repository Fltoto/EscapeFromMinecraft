package Game;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Score;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.ScoreboardManager;

import me.clip.Fltoto.EscapeFromMinecraft.Builder;
import me.clip.Fltoto.EscapeFromMinecraft.Main;

public class ScoreBoard extends JavaPlugin{
	static Main Main = (Main)Bukkit.getPluginManager().getPlugin("EscapeFromMinecraft");
	public static Main message;
	
	public static void SetPlayerMainText(Player p) {
        ScoreboardManager manager =Bukkit.getScoreboardManager();
        Scoreboard Mainboard=manager.getNewScoreboard();
        Objective Mainboard_obj=Mainboard.registerNewObjective("§8§l[§cEFM§8§l]", "InGameBoard");
        Scoreboard board=manager.getNewScoreboard();
        Score score1=Mainboard_obj.getScore("§8剩余时间:");
        Score score2=Mainboard_obj.getScore("§c"+(float)Math.round(((float)Tasks.remain/60))+"§8分钟");
        Score score3=Mainboard_obj.getScore("§8使用.b回到主城");
		Mainboard_obj.setDisplaySlot(DisplaySlot.SIDEBAR);
		score1=Mainboard_obj.getScore("§8剩余时间:");
		score2=Mainboard_obj.getScore("§c"+(float)Math.round(((float)Tasks.remain/60))+"§8分钟");
		score3=Mainboard_obj.getScore("§8使用.b回到主城");
		score2.setScore(1);
		score1.setScore(2);
		score3.setScore(3);
		p.setScoreboard(Mainboard);
	}
	public static void clean(Player p) {
        ScoreboardManager manager =Bukkit.getScoreboardManager();
        Scoreboard board=manager.getNewScoreboard();
        p.setScoreboard(board);
	}
}
