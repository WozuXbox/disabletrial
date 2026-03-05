package  de.wozuxbox.disabletrial;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

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
		new SpawnerKeyItem(new Item.Settings()
			.maxDamage(2)
			.component(DataComponentTypes.ENCHANTMENT_GLINT_OVERRIDE, true)),
		"copper_spawner_key"
	);
	public static final Item DIAMOND_SPAWNER_KEY = register(
		new SpawnerKeyItem(new Item.Settings()
			.maxDamage(10)
			.component(DataComponentTypes.ENCHANTMENT_GLINT_OVERRIDE, true)),
		"diamond_spawner_key"
	);
	public static final Item NETHERITE_SPAWNER_KEY = register(
		new SpawnerKeyItem(new Item.Settings()
			.maxDamage(40)
			.component(DataComponentTypes.ENCHANTMENT_GLINT_OVERRIDE, true)),
		"netherite_spawner_key"
	);
	public static void initialize() {
		//Not currently needed as Items shouldn't appear in Creative Inventory right now
		//ItemGroupEvents.modifyEntriesEvent(ItemGroups.TOOLS).register((itemGroup) -> itemGroup.add(ModItems.COPPER_SPAWNER_KEY));
	}
}