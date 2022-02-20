package qc.veko.quest.commands;

import org.bukkit.entity.Player;
import qc.veko.quest.commands.engine.Command;
import qc.veko.quest.commands.engine.CommandArgs;

public class ProfileCommand {

    @Command(name = "profil", aliases = {"ranking", "topfaction"}, inGameOnly = true)
    public void commandRanking(CommandArgs commandArgs){
        Player player = commandArgs.getPlayer();
        if (commandArgs.getArgs().length == 1 && commandArgs.getArgs()[0].equalsIgnoreCase("reload"))
            if (player.hasPermission("ranking.reload") || player.isOp()) {

                return;
            }
    }
}
