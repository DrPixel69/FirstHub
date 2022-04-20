package fr.maxi_pixel.test.Gestion.ranks;

import java.util.Arrays;

public enum RankUnit {

    ADMINISTRATEUR("Admin", 0, "§c[Admin] "),
    DEVELOPPEUR("Développeur", 1, "§9[Développeur] "),
    MODERATEUR("Modérateur", 2, "§6[Modérateur] "),
    VIP("VIP", 3, "§e[VIP] "),
    JOUEUR("Joueur", 4, "§7");

    private final String name;
    private final int power;
    private final String prefix;

    RankUnit(String name, int power, String prefix) {
        this.name = name;
        this.power = power;
        this.prefix = prefix;
    }

    public String getName() {
        return name;
    }

    public int getPower() {
        return power;
    }

    public String getPrefix() {
        return prefix;
    }

    public static RankUnit getByName(String name){
        return Arrays.stream(values()).filter(r -> r.getName().equalsIgnoreCase(name)).findAny().orElse(RankUnit.JOUEUR);
    }

    public static RankUnit getByPower(int power){
        return Arrays.stream(values()).filter(r -> r.getPower() == power).findAny().orElse(RankUnit.JOUEUR);
    }
}
