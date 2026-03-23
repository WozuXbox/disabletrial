package de.wozuxbox.disabletrial.mixin;

import net.minecraft.block.BlockState;
import net.minecraft.block.spawner.TrialSpawnerLogic;
import net.minecraft.block.enums.TrialSpawnerState;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import de.wozuxbox.disabletrial.DisableTrialBlockProperties;

@Mixin(TrialSpawnerState.class)
public class TrialSpawnerStateMixin {
    
    @Inject(at = @At("HEAD"), method = "tick", cancellable = true)
    private void onTick(BlockPos pos, TrialSpawnerLogic logic, ServerWorld world, CallbackInfoReturnable<TrialSpawnerState> cir) {
        BlockState blockState = world.getBlockState(pos);
        if (blockState.contains(DisableTrialBlockProperties.DISABLED) && 
            blockState.get(DisableTrialBlockProperties.DISABLED)) {

            cir.setReturnValue(TrialSpawnerState.INACTIVE);
        }
    }
}
