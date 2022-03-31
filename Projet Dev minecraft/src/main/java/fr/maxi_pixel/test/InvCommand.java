package fr.maxi_pixel.test;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class InvCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String str, String[] args) {
        if(args.length == 1) {
            if(sender.hasPermission("inv.other")) {
                Player target = Bukkit.getPlayer(args[0]);
                if(target != null) {
                    if(target.getName().equals(sender.getName())) {
                        sender.sendMessage("§cVous ne pouvez pas regarder votre propre inventaire !");
                    } else {
                        ((Player)sender).openInventory(target.getInventory());
                        sender.sendMessage("§aL'inventaire de §6 " + target.getDisplayName() + " §a été ouvert !");
                    }


                } else {
                    sender.sendMessage("§cLe joueur ne semble pas être connecté !");
                }
            }
        } else {
            sender.sendMessage(ChatColor.GOLD + "La commande est /invsee <pleudo>!");
        }
        return false;
    }

}

