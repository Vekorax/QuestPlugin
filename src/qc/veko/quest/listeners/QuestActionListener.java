package qc.veko.quest.listeners;

import lombok.Getter;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.player.PlayerPickupItemEvent;
import org.bukkit.inventory.ItemStack;
import qc.veko.quest.QuestPlugin;
import qc.veko.quest.engine.Action;
import qc.veko.quest.engine.PlayerInformations;
import qc.veko.quest.manager.QuestManager;

public class QuestActionListener implements Listener {

    private QuestManager questManager;
    @Getter private Action action;

    public QuestActionListener(QuestManager questManager) {
        this.questManager = questManager;
        this.action = questManager.getQuest().getAction();
    }


    @EventHandler
    public void onBreak(BlockBreakEvent e) {
        if (this.getAction() != Action.BREAK || !questManager.isActiveState())
            return;
        PlayerInformations playerInformations = QuestPlugin.getInstance().getPlayerInformations(e.getPlayer());
        if (questFinished(playerInformations))
            return;
        ItemStack block = new ItemStack(e.getBlock().getType());
        if (questManager.getQuest().getItemList().contains(block))
            questManager.addAdvancementToQuest(playerInformations);
    }

    @EventHandler
    public void onPlace(BlockPlaceEvent e) {
        if (this.getAction() != Action.PLACE || !questManager.isActiveState())
            return;
        PlayerInformations playerInformations = QuestPlugin.getInstance().getPlayerInformations(e.getPlayer());
        if (questFinished(playerInformations))
            return;
    }

    @EventHandler
    public void onCollect(PlayerPickupItemEvent e) {
        if (this.getAction() != Action.COLLECT || !questManager.isActiveState())
            return;
        PlayerInformations playerInformations = QuestPlugin.getInstance().getPlayerInformations(e.getPlayer());
        if (questFinished(playerInformations))
            return;
    }

    private boolean questFinished(PlayerInformations playerInformations) {
        boolean verify = questManager.getQuestAdvancement().get(playerInformations) >= questManager.getQuest().getAmount();
        return verify;
    }


}
