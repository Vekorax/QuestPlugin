package qc.veko.quest.commands;

import net.minecraft.server.v1_8_R3.Item;
import net.minecraft.server.v1_8_R3.Items;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import qc.veko.quest.commands.engine.Command;
import qc.veko.quest.commands.engine.CommandArgs;
import qc.veko.quest.engine.Action;
import qc.veko.quest.engine.Quest;
import qc.veko.quest.utils.QuestsUtil;

import java.util.ArrayList;
import java.util.List;

public class QuestCommand {
    @Command(name = "quest", aliases = {"ranking", "topfaction"}, inGameOnly = true)
    public void commandRanking(CommandArgs commandArgs){
        Player player = commandArgs.getPlayer();
        if (commandArgs.getArgs().length > 1 && commandArgs.getArgs()[0].equalsIgnoreCase("add"))
            if (player.hasPermission("quest.add") || player.isOp()) {
                String name = "";
                for (int i = 1; i <= commandArgs.getArgs().length - 1; ++i)
                    name += " " + commandArgs.getArgs()[i];
                List<ItemStack> items = new ArrayList<ItemStack>();
                items.add(new ItemStack(Material.APPLE));

                Quest quest = new Quest(name, "", 25, Action.BREAK, items);
                QuestsUtil.printQuest(quest, player);
                return;
            }
    }
}
