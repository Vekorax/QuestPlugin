package qc.veko.quest.engine;

import lombok.Data;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

@Data
public class PlayerInformations {

    private Player player;
    private List<Quest> quests;
    int points;

    public PlayerInformations(Player player, List<Quest> quests) {
        this.player = player;
        this.quests = quests;
        this.points = quests.get(0).getPoints();
    }

    public PlayerInformations(Player player) {
        this.player = player;
        this.quests = new ArrayList<Quest>();
        this.points = 0;
    }

    public void addPoints(int points) {
        this.points += points;
    }

    public void AddQuest(Quest quest) {
        quests.add(quest);
    }



}
