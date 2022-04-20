package fr.maxi_pixel.test.Gestion;

import fr.maxi_pixel.test.Main;
import fr.maxi_pixel.test.Gestion.ranks.RankUnit;
import org.bukkit.entity.Player;

import java.sql.SQLException;

public class Account {
    private static final String TABLE = "accounts";
    private final Player player;
    private final String uuid;

    public Account(Player player) {
        this.player = player;
        uuid = player.getUniqueId().toString();
    }

    public Player getPlayer() {
        return player;
    }

    public static Account getAccount(Player player){
        return Main.getInstance().getAccounts().stream().filter(a -> a.getPlayer() == player).findFirst().get();
    }

    public void setup(){
        Main.getInstance().getAccounts().add(this);
        Main.getInstance().getMySQL().query("SELECT * FROM " + TABLE + " WHERE uuid='" + uuid + "'", rs -> {
            try {
                if(!rs.next()){
                    Main.getInstance().getMySQL().update("INSERT INTO " + TABLE + " (uuid, grade, grade_end, coins) VALUES ('" + uuid + "', '" + RankUnit.JOUEUR.getName() + "', '-1', '0')");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        });

        if(rankIsExceeded()){
            setRank(RankUnit.JOUEUR);
        }
    }

    public void delete(){
        Main.getInstance().getAccounts().remove(this);
    }

    public RankUnit getRank(){
        return (RankUnit) Main.getInstance().getMySQL().query("SELECT * FROM " + TABLE + " WHERE uuid='" + uuid + "'", rs -> {
            try {
                if(rs.next()){
                    return RankUnit.getByName(rs.getString("grade"));
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return RankUnit.JOUEUR;
        });
    }

    public boolean hasTempRank(){
        return (boolean) Main.getInstance().getMySQL().query("SELECT * FROM " + TABLE + " WHERE uuid='" + uuid + "'", rs -> {
            try {
                if(rs.next()){
                    return rs.getLong("grade_end") != -1;
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return false;
        });
    }

    public boolean rankIsExceeded(){
        return (boolean) Main.getInstance().getMySQL().query("SELECT * FROM " + TABLE + " WHERE uuid='" + uuid + "'", rs -> {
            try {
                if(rs.next()){
                    return rs.getLong("grade_end") != -1 && rs.getLong("grade_end") < System.currentTimeMillis();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return false;
        });
    }

    public void setRank(RankUnit rank){
        Main.getInstance().getMySQL().update("UPDATE " + TABLE + " SET grade='" + rank.getName() + "', grade_end='-1' WHERE uuid='" + uuid + "'");
    }

    public void setRank(RankUnit rank, long endInSeconds){
        Main.getInstance().getMySQL().update("UPDATE " + TABLE + " SET grade='" + rank.getName() + "', grade_end='" + (endInSeconds * 1000 + System.currentTimeMillis()) + "' WHERE uuid='" + uuid + "'");
    }
}
