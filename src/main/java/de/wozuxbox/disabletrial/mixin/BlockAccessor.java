package de.wozuxbox.disabletrial.mixin;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.state.StateManager;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;
import org.spongepowered.asm.mixin.gen.Invoker;


@Mixin(Block.class)
public interface BlockAccessor {
    @Invoker("setDefaultState")
    void invokeSetDefaultState(BlockState state);
}
