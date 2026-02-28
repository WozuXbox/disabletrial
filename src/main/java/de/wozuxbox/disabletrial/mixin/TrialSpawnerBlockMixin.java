package de.wozuxbox.disabletrial.mixin;

import net.minecraft.state.StateManager;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.TrialSpawnerBlock;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.Shadow;

import de.wozuxbox.disabletrial.DisableTrialBlockProperties;
import de.wozuxbox.disabletrial.BlockAccessor;

@Mixin(TrialSpawnerBlock.class)
public abstract class TrialSpawnerBlockMixin {


	@Inject(at = @At("RETURN"), method = "appendProperties(Lnet/minecraft/state/StateManager$Builder;)V")
	private void onAppendProperties(StateManager.Builder<Block, BlockState> builder, CallbackInfo ci) {
		builder.add(DisableTrialBlockProperties.DISABLED);
	}
	@Inject(at=@At("RETURN"),method="<init>")
	private void onTrialSpawnerBlock(AbstractBlock.Settings settings, CallbackInfo ci) {
		BlockAccessor accessor = (BlockAccessor)(Object)this;
		accessor.invokeSetDefaultState(accessor.getStateManager().getDefaultState().with(DisableTrialBlockProperties.DISABLED, false));

	}
}