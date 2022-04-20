package fr.maxi_pixel.test.Command;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class BcCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String str, String[] args) {


        if(sender instanceof Player) {
            Player player = (Player) sender;
            if(args.length == 0) player.sendMessage(ChatColor.GOLD + "La commande est /bc <message>");

            else {
                if (args[0].equals("info")) {
                    player.sendMessage(ChatColor.GREEN + "La commande est /bc <message>\nElle permet d'envoyer un message sur le serveur afin que tous les joueurs le recoivent dans le chat.");
                }
                else {
                    StringBuilder bc = new StringBuilder();

                    for(String arguments : args) {
                        bc.append(arguments).append(" ");
                    }
                    Bukkit.getServer().broadcastMessage(ChatColor.DARK_BLUE + "[BROADCAST] " + ChatColor.DARK_AQUA + "Le joueur "+ player.getName() + " dit : " + bc);

                }
            }
        }

        return false;
    }

}

