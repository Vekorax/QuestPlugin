package qc.veko.quest.engine;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.bukkit.inventory.ItemStack;
import qc.veko.quest.QuestPlugin;
import qc.veko.quest.manager.QuestManager;

import java.util.List;

public class Quest {


    @Getter @Setter private String name;
    @Getter @Setter private String desc;
    @Getter @Setter private int points;
    @Getter @Setter private Action action;
    @Getter @Setter private List<ItemStack> itemList;
    @Getter @Setter private int amount;
    @Getter private int id;
    @Getter private QuestManager questManager;

    public Quest(String name, String desc, int points, Action action, List<ItemStack> itemList, int amount) {
        this.name = name;
        this.desc = desc;
        this.points = points;
        this.action = action;
        this.itemList = itemList;
        this.id = QuestPlugin.getInstance().getQuests().size() + 1;
        this.questManager = new QuestManager(this);
        this.amount = amount;

        QuestPlugin.getInstance().getQuests().add(questManager);
    }
}
