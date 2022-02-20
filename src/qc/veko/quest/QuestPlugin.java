package qc.veko.quest;

import lombok.Getter;
import org.bukkit.plugin.java.JavaPlugin;
import qc.veko.quest.commands.QuestCommand;
import qc.veko.quest.commands.engine.CommandFramework;
import qc.veko.quest.engine.Quest;

import java.util.ArrayList;
import java.util.List;

public class QuestPlugin extends JavaPlugin {

    @Getter private List<Quest> quests = new ArrayList<Quest>();
    @Getter public static QuestPlugin instance;

    public void onEnable() {
        instance = this;

        final CommandFramework commandFramework = new CommandFramework(this);
        commandFramework.registerCommands(new QuestCommand());
    }

}