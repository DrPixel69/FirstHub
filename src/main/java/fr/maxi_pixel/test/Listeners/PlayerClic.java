package fr.maxi_pixel.test.Listeners;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

public class PlayerClic implements Listener {

    @EventHandler
    public void onClic(InventoryClickEvent event) {
        Player player = (Player) event.getWhoClicked();
        ItemStack current = event.getCurrentItem();
        if (current == null) return;
        if(player.isOp()) {



            switch (current.getType()) {

                case GRASS_BLOCK:
                    player.closeInventory();
                    player.sendMessage(ChatColor.YELLOW + "Vous venez d'être téléporté sur le serveur skyblock.");


                    break;
                case LIME_DYE:
                    player.closeInventory();
                    player.sendMessage(ChatColor.YELLOW + "Vous venez d'afficher ou de faire disparaitre les joueurs.");

                    break;
            }
        }
        else{


            event.setCancelled(true);
            player.closeInventory();

            switch (current.getType()) {

                case GRASS_BLOCK:
                    player.sendMessage(ChatColor.YELLOW + "Vous venez d'être téléporté sur le serveur skyblock.");

                    player.updateInventory();
                    break;
                case LIME_DYE:
                    player.sendMessage(ChatColor.YELLOW + "Vous venez d'afficher ou de faire disparaitre les joueurs.");
                    player.updateInventory();
                    break;
            }
        }

    }


}
