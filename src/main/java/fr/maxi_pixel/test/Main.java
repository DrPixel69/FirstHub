package fr.maxi_pixel.test;

import fr.maxi_pixel.test.Command.*;
import fr.maxi_pixel.test.Managers.RegisterManager;
import fr.maxi_pixel.test.Gestion.Account;
import fr.maxi_pixel.test.database.MySQL;
import org.apache.commons.dbcp2.BasicDataSource;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Main extends JavaPlugin {

    public static Main INSTANCE;

    private MySQL mysql;

    private final List<Account> accounts = new ArrayList<>();



    @Override
    public void onEnable() {
        INSTANCE = this;
        System.out.println("==========================");
        System.out.println("Lancement du plugin de dev");
        System.out.println("==========================");

        new RegisterManager().register();
        registerCommand();
        initConnection();




    }

    @Override
    public void onDisable() {
        System.out.println("==========================");
        System.out.println("Extinction du plugin");
        System.out.println("==========================");
    }

    public static Main getInstance() {
        return INSTANCE;
    }


    public void registerCommand() {
        Objects.requireNonNull(getCommand("bc")).setExecutor(new BcCommand());
        Objects.requireNonNull(getCommand("ec")).setExecutor(new EcCommand());
        Objects.requireNonNull(getCommand("invsee")).setExecutor(new InvCommand());
        Objects.requireNonNull(getCommand("spawn")).setExecutor(new SpawnCommand());
        Objects.requireNonNull(getCommand("sb")).setExecutor(new OpenScoreboardCommand());
    }

    private void initConnection(){
        Bukkit.getConsoleSender().sendMessage("§e[Hub] §a Connexion a MySQL en cours...");
        BasicDataSource connectionPool = new BasicDataSource();
        connectionPool.setDriverClassName("com.mysql.jdbc.Driver");
        connectionPool.setUsername("root");
        connectionPool.setPassword("");
        connectionPool.setUrl("jdbc:mysql://localhost:3306/hubdev?autoReconnect=true");
        connectionPool.setInitialSize(1);
        connectionPool.setMaxTotal(10);
        mysql = new MySQL(connectionPool);
        mysql.createTables();
    }

    public MySQL getMySQL() {
        return mysql;
    }

    public List<Account> getAccounts() {
        return accounts;
    }



}
