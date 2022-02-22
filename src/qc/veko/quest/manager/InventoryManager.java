package qc.veko.quest.manager;

import lombok.Getter;
import org.bukkit.inventory.Inventory;
import qc.veko.quest.engine.InventoryOptions;
import qc.veko.quest.engine.PlayerInformations;

public class InventoryManager {

    @Getter PlayerInformations playerInformations;
    @Getter InventoryOptions inventoryOptions;
    @Getter Inventory inventory;

    public InventoryManager(PlayerInformations playerInformations, InventoryOptions inventoryOptions) {
        this.playerInformations = playerInformations;
        this.inventoryOptions = inventoryOptions;
    }

    public void openSavedInventory() {
        playerInformations.getPlayer().openInventory(inventory);
    }

    public void openNewInventory(InventoryOptions inventoryOptions) {

    }

    public void openInventory(InventoryOptions inventoryOptions) {
        if (this.inventoryOptions == inventoryOptions)
            openSavedInventory();
        else
            openNewInventory(inventoryOptions);
    }

}
