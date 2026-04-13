package de.wozuxbox.disabletrial;

import de.wozuxbox.disabletrial.mixin.TrialSpawnerDataAccessor;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.TrialSpawnerBlock;
import net.minecraft.block.entity.TrialSpawnerBlockEntity;
import net.minecraft.block.enums.TrialSpawnerState;
import net.minecraft.block.spawner.TrialSpawnerData;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class SpawnerKeyItem extends Item {
    public SpawnerKeyItem(Settings settings) {
        super(settings);
    }
    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        World world = context.getWorld();
        BlockPos blockPos = context.getBlockPos();
        BlockState blockState = world.getBlockState(blockPos);

        if (!blockState.isOf(Blocks.TRIAL_SPAWNER)) {
            return ActionResult.PASS;
        }

        if (!world.isClient() && context.getPlayer() != null) {
            context.getPlayer().getItemCooldownManager().set(this, 20);
            boolean disabled = blockState.get(DisableTrialBlockProperties.DISABLED);
            TrialSpawnerState spawnerState = blockState.get(TrialSpawnerBlock.TRIAL_SPAWNER_STATE);

            ItemStack stack = context.getStack();
            PlayerEntity player = context.getPlayer();
            EquipmentSlot slot = context.getHand() == Hand.MAIN_HAND ? EquipmentSlot.MAINHAND : EquipmentSlot.OFFHAND;

            if (disabled) {
                // Reenable the spawner with 5 minute cooldown
                world.setBlockState(blockPos, blockState
                        .with(DisableTrialBlockProperties.DISABLED, false)
                        .with(TrialSpawnerBlock.TRIAL_SPAWNER_STATE, TrialSpawnerState.COOLDOWN));

                if (world.getBlockEntity(blockPos) instanceof TrialSpawnerBlockEntity spawnerEntity) {
                    TrialSpawnerData data = spawnerEntity.getSpawner().getData();
                    ((TrialSpawnerDataAccessor) (Object) data).setCooldownEnd(world.getTime() + 6000);
                }

                world.playSound(null, blockPos, SoundEvents.BLOCK_TRIAL_SPAWNER_EJECT_ITEM, SoundCategory.BLOCKS, 1.0f, 1.0f);
                stack.damage(1, player, slot);
            } else if (spawnerState == TrialSpawnerState.INACTIVE || spawnerState == TrialSpawnerState.COOLDOWN) {
                // Disable the spawner
                world.setBlockState(blockPos, blockState.with(DisableTrialBlockProperties.DISABLED, true));
                world.playSound(null, blockPos, SoundEvents.BLOCK_TRIAL_SPAWNER_PLACE, SoundCategory.BLOCKS, 1.0f, 1.0f);
                stack.damage(1, player, slot);
            } else {
                // Spawner is active — deny with hit sound
                world.playSound(null, blockPos, SoundEvents.BLOCK_TRIAL_SPAWNER_HIT, SoundCategory.BLOCKS, 1.0f, 1.0f);
            }
        }


        return ActionResult.SUCCESS;
    }
}
