package fr.maxi_pixel.test.Command;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SpawnCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        if(sender instanceof Player) {
            Player player = (Player) sender;
            Location spawn = new Location(player.getWorld(),15.500, 77, 280.500, -179.9f, 9.4f);
            player.teleport(spawn);
            player.sendMessage(ChatColor.BLUE + "Vous avez été téléporté au spawn");
        }

        return false;
    }

}

