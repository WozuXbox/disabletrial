package  de.wozuxbox.disabletrial;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.component.Component;
import net.minecraft.item.Items;

public class ModItems {
	public static Item register(Item item, String id) {
		// Create the identifier for the item.
		Identifier itemID = Identifier.of(DisableTrialSpawners.MOD_ID, id);

		// Register the item.
		Item registeredItem = Registry.register(Registries.ITEM, itemID, item);

		// Return the registered item!
		return registeredItem;
	}
	public static final Item COPPER_SPAWNER_KEY = register(
		new Item(new Item.Settings()),
		"copper_spawner_key"
	);
	public static final Item DIAMOND_SPAWNER_KEY = register(
		new Item(new Item.Settings()),
		"diamond_spawner_key"
	);
	public static final Item NETHERITE_SPAWNER_KEY = register(
		new Item(new Item.Settings()),
		"netherite_spawner_key"
	);
	public static void initialize() {
		//Not currently needed as Items shouldn't appear in Creative Inventory right now
		//ItemGroupEvents.modifyEntriesEvent(ItemGroups.TOOLS).register((itemGroup) -> itemGroup.add(ModItems.COPPER_SPAWNER_KEY));
	}
}