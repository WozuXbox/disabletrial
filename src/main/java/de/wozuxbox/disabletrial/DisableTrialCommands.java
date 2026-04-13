package de.wozuxbox.disabletrial;

import com.mojang.brigadier.context.CommandContext;
import net.minecraft.block.BlockState;
import net.minecraft.server.command.CommandManager;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.text.Text;
import net.minecraft.world.World;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;

public class DisableTrialCommands {
    public static int executeMarkerMigrateCommand(CommandContext<ServerCommandSource> context) {
        World world = context.getSource().getWorld();
        BlockPos blockPos = BlockPos.ofFloored(context.getSource().getPosition());
        BlockState blockState = world.getBlockState(blockPos);
        world.setBlockState(blockPos, blockState.with(DisableTrialBlockProperties.DISABLED, true));
        world.markDirty(blockPos);
        return 1;
    }
}
