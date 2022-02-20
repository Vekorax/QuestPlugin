package qc.veko.quest.utils;

import org.bukkit.entity.Player;
import qc.veko.quest.QuestPlugin;
import qc.veko.quest.engine.Action;
import qc.veko.quest.engine.Quest;

import java.util.ArrayList;
import java.util.List;

public class QuestsUtil {
    public static Quest getQuest(String name) {
        for (Quest quest : QuestPlugin.getInstance().getQuests()) {
            if(quest.getName().equals(name))
                return quest;
        }
        return null;
    }
    public static Quest getQuest(int id) {
        for (Quest quest : QuestPlugin.getInstance().getQuests()) {
            if(quest.getId() == id)
                return quest;
        }
        return null;
    }
    public static List<Quest> getAllQuestWithAction(Action action) {
        List<Quest> quests= new ArrayList<Quest>();
        for (Quest quest : QuestPlugin.getInstance().getQuests()) {
            if(quest.getAction() == action)
                quests.add(quest);
        }
        return quests;
    }

    public static void printQuest(Quest quest, Player player) {
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


}
