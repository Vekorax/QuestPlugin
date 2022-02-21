package qc.veko.quest.manager;

import lombok.Getter;
import org.bukkit.entity.Player;
import qc.veko.quest.QuestPlugin;
import qc.veko.quest.engine.PlayerInformations;
import qc.veko.quest.engine.Quest;

import java.util.ArrayList;
import java.util.List;

public class QuestManager {
    private List<PlayerInformations> playersInformations = new ArrayList<>();
    @Getter private Quest quest;

    public QuestManager(Quest quest) {
        this.quest = quest;
    }

    public void print(Player player) {
        String[] items = new String[quest.getItemList().size()];
        for (int i = 0; i <= quest.getItemList().size() - 1; ++i)
            items[i] = quest.getItemList().get(i).getType().name();
        player.sendMessage("-----------------------QUEST-----------------------");
        player.sendMessage("NAME : " + quest.getName());
        player.sendMessage("DESC : " + quest.getDesc());
        player.sendMessage("POINTS : " + quest.getPoints());
        player.sendMessage("ACTION : " + quest.getAction().name());
        player.sendMessage("ITEMS : ");
        player.sendMessage(items);
        player.sendMessage("-----------------------QUEST-----------------------");
    }

    public void addPlayer(PlayerInformations playerInformations) {
        this.playersInformations.add(playerInformations);
        playerInformations.addPoints(quest.getPoints());
    }

    public List<PlayerInformations> getPlayers() {
        return playersInformations;
    }

    public static QuestManager getQuest(int id) {
        QuestManager quest = QuestPlugin.getInstance().getQuests().get(id-1);
        return quest;
    }


}
