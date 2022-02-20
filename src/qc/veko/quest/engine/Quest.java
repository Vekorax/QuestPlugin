package qc.veko.quest.engine;

import lombok.Data;
import org.bukkit.inventory.ItemStack;
import qc.veko.quest.QuestPlugin;

import java.util.List;

@Data
public class Quest {

    private String name;
    private String desc;
    private int points;
    private Action action;
    private List<ItemStack> itemList;
    private int id;

    public Quest(String name, String desc, int points, Action action, List<ItemStack> itemList) {
        this.name = name;
        this.desc = desc;
        this.points = points;
        this.action = action;
        this.itemList = itemList;
        id = QuestPlugin.getInstance().getQuests().size() + 1;
        QuestPlugin.getInstance().getQuests().add(this);
    }
}
