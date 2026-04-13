package de.wozuxbox.disabletrial.mixin;

import net.minecraft.state.StateManager;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.TrialSpawnerBlock;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.World;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import de.wozuxbox.disabletrial.DisableTrialBlockProperties;

@Mixin(TrialSpawnerBlock.class)
public abstract class TrialSpawnerBlockMixin extends Block {
	protected TrialSpawnerBlockMixin(Settings settings) {
		super(settings);
	}

	@Inject(at = @At("RETURN"), method = "appendProperties(Lnet/minecraft/state/StateManager$Builder;)V")
	private void onAppendProperties(StateManager.Builder<Block, BlockState> builder, CallbackInfo ci) {
		builder.add(DisableTrialBlockProperties.DISABLED);
	}

	@Inject(at= @At(value = "RETURN"),method="<init>")
	private void onTrialSpawnerBlock(AbstractBlock.Settings settings, CallbackInfo ci) {
		Block block = (Block)(Object)this;
		BlockAccessor accessor = (BlockAccessor)block;
		accessor.invokeSetDefaultState(block.getDefaultState().with(DisableTrialBlockProperties.DISABLED, false));
	}
}
