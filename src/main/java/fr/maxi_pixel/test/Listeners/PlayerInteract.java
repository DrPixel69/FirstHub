package fr.maxi_pixel.test.Listeners;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Arrays;
import java.util.Objects;

public class PlayerInteract implements Listener{

    @EventHandler
    public void onInteract(PlayerInteractEvent event) {
        Player player = event.getPlayer();
        Action action = event.getAction();
        ItemStack it = event.getItem();

        if(it == null) return;

        if(it.getType() == Material.CREEPER_HEAD) {
            if(action == Action.RIGHT_CLICK_AIR || action == Action.RIGHT_CLICK_BLOCK) {
                player.sendMessage(ChatColor.GREEN + "Vous venez de faire un clic");

            }

        }
        if(it.getType() == Material.TOTEM_OF_UNDYING && it.hasItemMeta() && Objects.requireNonNull(it.getItemMeta()).hasDisplayName() && it.getItemMeta().getDisplayName().equalsIgnoreCase("§cMenu des mondes")) {
            player.sendMessage(ChatColor.GREEN + "Vous venez d'ouvrir le menu des mondes");
            Inventory inv = Bukkit.createInventory(null, 27, "§8Mon menu des mondes");
            ItemStack customDirt = new ItemStack(Material.GRASS_BLOCK,1);
            ItemMeta customD = customDirt.getItemMeta();
            assert customD != null;
            customD.setDisplayName("§cTéléportation dans le monde skyblock");
            customD.setLore(Arrays.asList("Cet objet permet de se téléporter dans le skyblock.","Fais un clic droit dessus, tu verras."));
            customD.addEnchant(Enchantment.DAMAGE_ALL, 200, true);
            customD.addItemFlags(ItemFlag.HIDE_ENCHANTS);
            customDirt.setItemMeta(customD);
            inv.setItem(13, customDirt);
            player.openInventory(inv);
        }
        if(it.getType() == Material.CHEST && it.hasItemMeta() && Objects.requireNonNull(it.getItemMeta()).hasDisplayName() && it.getItemMeta().getDisplayName().equalsIgnoreCase("§cMenu des cosmetiques")) {
            player.sendMessage(ChatColor.GREEN + "Vous venez d'ouvrir le menu des cosmetiques");
            Inventory inv2 = Bukkit.createInventory(null, 27, "§8Mon menu consmetiques");
            ItemStack customDirt = new ItemStack(Material.LIME_DYE,1);
            ItemMeta customD = customDirt.getItemMeta();
            assert customD != null;
            customD.setDisplayName("§cAffichage des autres joueurs");
            customD.setLore(Arrays.asList("Cet objet permet de faire disparaitre","et apparaitre les autres joueurs.","Fais un clic droit dessus, tu verras."));
            customD.addEnchant(Enchantment.DAMAGE_ALL, 200, true);
            customD.addItemFlags(ItemFlag.HIDE_ENCHANTS);
            customDirt.setItemMeta(customD);

            inv2.setItem(13, customDirt);
            player.openInventory(inv2);
        }
    }
}
