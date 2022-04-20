package fr.maxi_pixel.test.Listeners;

import fr.maxi_pixel.test.Gestion.Account;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Arrays;
import java.util.Objects;

public class PlayerJoin implements Listener {

    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        Account account = new Account(player);
        account.setup();

        event.setJoinMessage(account.getRank().getPrefix() + player.getName() + " §fa rejoint le hub !");


        player.getInventory().clear();
        Objects.requireNonNull(player.getEquipment()).clear();
        player.setHealth(20);
        player.setFoodLevel(20);
        player.setLevel(0);
        player.setExp(0);
        player.teleport(Bukkit.getWorlds().get(0).getSpawnLocation());
        player.playSound(player.getLocation(), Sound.ENTITY_EXPERIENCE_BOTTLE_THROW, 1f, 1f);

        player.sendTitle("§6§lServeur de dev", "Bienvenue sur le serveur", 10, 100, 20);

        player.sendMessage("§bBienvenue sur le serveur\n\n§cLe serveur est en cours de développement...");





        ItemStack customMenu = new ItemStack(Material.TOTEM_OF_UNDYING,1);
        ItemMeta customM = customMenu.getItemMeta();
        assert customM != null;
        customM.setDisplayName("§cMenu des mondes");
        customM.setLore(Arrays.asList("Cet objet permet de se déplacer de monde en monde.","Fais un clic droit dessus, tu verras."));
        customM.addEnchant(Enchantment.DAMAGE_ALL, 200, true);
        customM.setUnbreakable(true);
        customM.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        customMenu.setItemMeta(customM);

        ItemStack customPlayer = new ItemStack(Material.CHEST,1);
        ItemMeta customM2 = customPlayer.getItemMeta();
        assert customM2 != null;
        customM2.setDisplayName("§cMenu des cosmetiques");
        customM2.setLore(Arrays.asList("Cet objet permet de choisir l'apparence du joueur.","Fais un clic droit dessus, tu verras."));
        customM2.addEnchant(Enchantment.DAMAGE_ALL, 200, true);
        customM2.setUnbreakable(true);
        customM2.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        customPlayer.setItemMeta(customM2);


        player.getInventory().setItem(0, customMenu);
        player.getInventory().setItem(8, customPlayer);
        player.updateInventory();


    }

}
