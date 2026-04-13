package de.wozuxbox.disabletrial;

import net.fabricmc.api.ModInitializer;
import de.wozuxbox.disabletrial.ModItems;
import com.mojang.brigadier.CommandDispatcher;

import net.fabricmc.fabric.api.command.v2.CommandRegistrationCallback;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.MarkerEntity;
import net.minecraft.server.command.CommandManager;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.text.Text;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DisableTrialSpawners implements ModInitializer {
	public static final String MOD_ID = "disabletrial";

	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution. serverCommandSource -> serverCommandSource.getEntity() != null && serverCommandSource.getEntity().getType() == EntityType.MARKER
		ModItems.initialize();
		LOGGER.info("Disabletrial activated");
		CommandRegistrationCallback.EVENT.register((dispatcher, registryAccess, environment) -> {
			dispatcher.register(CommandManager.literal("disabletrialmarkermigratetomodcommand_no_random_uuid_before").requires(source -> !source.isExecutedByPlayer()).executes(DisableTrialCommands::executeMarkerMigrateCommand));
		});
	}
}