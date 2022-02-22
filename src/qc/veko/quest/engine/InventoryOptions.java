package qc.veko.quest.engine;

import qc.veko.quest.inventory.CreateQuestInventory;

public enum InventoryOptions {
    CREATE(new CreateQuestInventory()),
    REMOVE(null),
    MANAGE(null),
    VIEW(null);


    InventoryOptions(Object inventory) {

    }

    static {

    }
}
