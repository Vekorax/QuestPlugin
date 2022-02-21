package qc.veko.quest;

import lombok.Getter;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import qc.veko.quest.commands.QuestCommand;
import qc.veko.quest.commands.engine.CommandFramework;
import qc.veko.quest.engine.PlayerInformations;
import qc.veko.quest.manager.QuestManager;

import java.util.*;

public class QuestPlugin extends JavaPlugin {
    @Getter private List<QuestManager> quests = new ArrayList<QuestManager>();
    @Getter private Map<UUID, PlayerInformations> playerInformationsMap = new HashMap<>();
    @Getter public static QuestPlugin instance;

    public void onEnable() {
        instance = this;

        CommandFramework commandFramework = new CommandFramework(this);
        commandFramework.registerCommands(new QuestCommand());
    }

    public PlayerInformations getPlayerInformations(Player player) {
        PlayerInformations playerInformations = this.getPlayerInformationsMap().get(player.getUniqueId());
        return playerInformations;
    }

    public QuestManager getQuest(int id) {
        QuestManager quest = this.getQuests().get(id-1);
        return quest;
    }
}
