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
        Objective Mainboard_obj=Mainboard.registerNewObjective("��8��l[��cEFM��8��l]", "InGameBoard");
        Scoreboard board=manager.getNewScoreboard();
        Score score1=Mainboard_obj.getScore("��8ʣ��ʱ��:");
        Score score2=Mainboard_obj.getScore("��c"+(float)Math.round(((float)Tasks.remain/60))+"��8����");
        Score score3=Mainboard_obj.getScore("��8ʹ��.b�ص�����");
		Mainboard_obj.setDisplaySlot(DisplaySlot.SIDEBAR);
		score1=Mainboard_obj.getScore("��8ʣ��ʱ��:");
		score2=Mainboard_obj.getScore("��c"+(float)Math.round(((float)Tasks.remain/60))+"��8����");
		score3=Mainboard_obj.getScore("��8ʹ��.b�ص�����");
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
