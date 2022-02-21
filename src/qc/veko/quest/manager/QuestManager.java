package qc.veko.quest.manager;

import lombok.Getter;
import lombok.Setter;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import qc.veko.quest.QuestPlugin;
import qc.veko.quest.engine.PlayerInformations;
import qc.veko.quest.engine.Quest;
import qc.veko.quest.listeners.QuestActionListener;

import java.util.HashMap;
import java.util.Map;

public class QuestManager {
    @Getter private Map<PlayerInformations, Integer> questAdvancement = new HashMap<>();
    private QuestActionListener questActionListener;
    @Getter private Quest quest;
    @Getter @Setter private boolean activeState = true;

    public QuestManager(Quest quest) {
        this.quest = quest;
        this.questActionListener = new QuestActionListener(this);

        Bukkit.getPluginManager().registerEvents(questActionListener, QuestPlugin.getInstance());
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

    public void startQuest(PlayerInformations playerInformations) {
        this.getQuestAdvancement().put(playerInformations, 0);
    }

    public void addAdvancementToQuest(PlayerInformations playerInformations, int amount) {
        int originalAmount = this.getQuestAdvancement().get(playerInformations);
        this.getQuestAdvancement().put(playerInformations, originalAmount + amount);
    }

    public static QuestManager getQuest(int id) {
        QuestManager quest = QuestPlugin.getInstance().getQuests().get(id-1);
        return quest;
    }


}
