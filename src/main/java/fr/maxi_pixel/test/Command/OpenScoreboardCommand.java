package fr.maxi_pixel.test.Command;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.*;


public class OpenScoreboardCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String str, String[] args) {
        if(sender instanceof Player) {
            Player player = (Player) sender;
            ScoreboardManager manager = Bukkit.getScoreboardManager();

            assert manager != null;

            Scoreboard scoreboard = manager.getNewScoreboard();

            Objective objective = scoreboard.registerNewObjective("Title", "dummy",ChatColor.BLUE + "Serveur dev");
            objective.setDisplaySlot(DisplaySlot.SIDEBAR);

            Score score = objective.getScore(ChatColor.GOLD + "Money: $" + ChatColor.GREEN + 1); //create a line for the board
            Score s2 = objective.getScore(""); //blank space
            Score s3 = objective.getScore(ChatColor.DARK_PURPLE + "https://google.com");

            score.setScore(3);
            s2.setScore(2);
            s3.setScore(1);


            player.setScoreboard(scoreboard);
            player.sendMessage(ChatColor.YELLOW + "ScoreBoard mis à jour !");
        }
        return true;
    }
}
