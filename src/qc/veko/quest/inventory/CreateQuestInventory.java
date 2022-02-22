package qc.veko.quest.inventory;

import lombok.Getter;
import org.bukkit.inventory.Inventory;
import qc.veko.quest.manager.InventoryManager;

public class CreateQuestInventory {

    @Getter InventoryManager inventoryManager;

    public CreateQuestInventory(InventoryManager inventoryManager) {
        this.inventoryManager = inventoryManager;
    }
    public CreateQuestInventory() { }

    public Inventory createQuest() {
        return null;
    }
}
