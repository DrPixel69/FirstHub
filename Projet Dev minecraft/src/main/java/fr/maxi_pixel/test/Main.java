package fr.maxi_pixel.test;

import org.bukkit.plugin.java.JavaPlugin;

import java.util.Objects;

public class Main extends JavaPlugin {

    public static Main INSTANCE;

    @Override
    public void onEnable() {
        // Plugin startup logic
        INSTANCE = this;
        System.out.println("Lancement du plugin de dev");
        registerListeners();
        registerCommand();
        super.onEnable();
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        System.out.println("Extinction du plugin");
        super.onDisable();
    }

    public void registerListeners() {
        getServer().getPluginManager().registerEvents(new PluginListener(),this);
    }

    public void registerCommand() {
        Objects.requireNonNull(getCommand("bc")).setExecutor(new BcCommand());
        Objects.requireNonNull(getCommand("ec")).setExecutor(new EcCommand());
        Objects.requireNonNull(getCommand("invsee")).setExecutor(new InvCommand());
        Objects.requireNonNull(getCommand("spawn")).setExecutor(new SpawnCommand());
    }
}
