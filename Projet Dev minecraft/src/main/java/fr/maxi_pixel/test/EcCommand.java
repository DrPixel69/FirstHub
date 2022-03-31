package fr.maxi_pixel.test;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class EcCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String str, String[] args) {

        if(sender instanceof Player) {
            Player player = (Player) sender;
            if(args.length == 0) {
                player.openInventory(player.getEnderChest());
            }

            else if (args.length == 1) {
                if (player.isOp()) {
                    Player target = Bukkit.getPlayer(args[0]);
                    if (target != null) {
                        player.sendMessage(ChatColor.BLUE + "Vous avez accès à l'ender chest du joueur car vous êtes op");
                        player.openInventory(target.getEnderChest());
                    }
                    else player.sendMessage(ChatColor.RED + "Le joueur n'est pas connect�");
                }
                else {
                    player.sendMessage(ChatColor.RED + "Vous n'avez pas accès à l'ender chest du joueur car vous n'êtes pas op");
                }
            }
            else player.sendMessage(ChatColor.RED + "La commande est /ec <pleudo>");
        }

        return false;
    }

}
