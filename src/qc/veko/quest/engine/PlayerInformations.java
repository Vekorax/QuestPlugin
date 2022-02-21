package qc.veko.quest.engine;

import lombok.Data;
import lombok.Getter;
import org.bukkit.entity.Player;

public class PlayerInformations {

    @Getter private Player player;
    @Getter private int points;

    public PlayerInformations(Player player) {
        this.player = player;
        this.points = 0;
    }

    public void addPoints(int points) {
        this.points += points;
    }



}
