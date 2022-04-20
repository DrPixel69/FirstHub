package fr.maxi_pixel.test.Managers;

import fr.maxi_pixel.test.Listeners.*;
import fr.maxi_pixel.test.Main;
import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;


public class RegisterManager {
    private final Main instance = Main.getInstance();

    public void register(){
        /**
         * LISTERNERS
         */
        PluginManager pm = Bukkit.getPluginManager();
        pm.registerEvents(new PlayerJoin(), instance);
        pm.registerEvents(new PlayerInteract(),instance);
        pm.registerEvents(new PlayerClic(),instance);
        pm.registerEvents(new PlayerQuit(),instance);
        pm.registerEvents(new PlayerChat(),instance);

        /**
         * COMMANDS
         */

    }
}
