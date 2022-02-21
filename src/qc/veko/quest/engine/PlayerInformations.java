package qc.veko.quest.engine;

import lombok.Getter;
import org.bukkit.entity.Player;
import qc.veko.quest.QuestPlugin;

import java.util.UUID;

public class PlayerInformations {

    @Getter private Player player;
    @Getter private int points;
    @Getter private UUID id;

    public PlayerInformations(Player player) {
        this.player = player;
        this.points = 0;
        this.id = player.getUniqueId();
    }

    public void addPoints(int points) {
        this.points += points;
    }



}
