package fr.maxi_pixel.test.Listeners;

import fr.maxi_pixel.test.Gestion.Account;
import fr.maxi_pixel.test.Gestion.ranks.RankUnit;
import fr.maxi_pixel.test.Main;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import java.util.ArrayList;
import java.util.List;

public class PlayerChat implements Listener {
    private final List<Player> cooldown = new ArrayList<>();

    @EventHandler
    public void onChat(AsyncPlayerChatEvent e){
        Player player = e.getPlayer();
        RankUnit rank = Account.getAccount(player).getRank();

        e.setFormat(rank.getPrefix() + "%1$s §7» " + (rank == RankUnit.JOUEUR ? "§7" : "§f") + "%2$s");

        if(cooldown.contains(player)){
            e.setCancelled(true);
            player.sendMessage("§cMerci de patienter entre chaque message !");
            return;
        }

        if(rank.getPower() > RankUnit.MODERATEUR.getPower()){
            cooldown.add(player);
            Bukkit.getScheduler().runTaskLater(Main.getInstance(), () -> cooldown.remove(player), 2 * 20L);
        }
    }
}
