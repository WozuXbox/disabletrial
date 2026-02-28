package de.wozuxbox.disabletrial;

import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.util.ActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.block.Blocks;

public class SpawnerKeyItem extends Item {
    public SpawnerKeyItem(Settings settings) {
        super(settings);
    }
    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        World world = context.getWorld();
        BlockPos blockPos = context.getBlockPos();
        PlayerEntity playerEntity = context.getPlayer();
        BlockState blockstate = world.getBlockState(blockPos);
        //Block block = blockstate.getBlock();
        if(!blockstate.isOf(Blocks.TRIAL_SPAWNER)) {
            return ActionResult.FAIL;
        };
        return ActionResult.SUCCESS;
    }
    private static void shouldCancelDisabling(ItemUsageContext context) {}
}