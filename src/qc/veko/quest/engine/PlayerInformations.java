package qc.veko.quest.engine;

import lombok.Getter;
import lombok.Setter;
import org.bukkit.entity.Player;
import qc.veko.quest.QuestPlugin;
import qc.veko.quest.manager.InventoryManager;

import java.util.UUID;

public class PlayerInformations {

    @Getter private Player player;
    @Getter private int points;
    @Getter private UUID id;
    @Getter @Setter private int inventoryId = -1;
    @Setter InventoryManager inventoryManager;

    public PlayerInformations(Player player) {
        this.player = player;
        this.points = 0;
        this.id = player.getUniqueId();
    }

    public void addPoints(int points) {
        this.points += points;
    }

    public InventoryManager getInventoryManager() {
        if (inventoryManager == null)
            inventoryManager = new InventoryManager(this, null);
        return inventoryManager;
    }



}
