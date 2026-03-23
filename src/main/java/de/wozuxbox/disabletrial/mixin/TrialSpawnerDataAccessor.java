package de.wozuxbox.disabletrial.mixin;

import net.minecraft.block.spawner.TrialSpawnerData;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(TrialSpawnerData.class)
public interface TrialSpawnerDataAccessor {
    @Accessor("cooldownEnd")
    void setCooldownEnd(long cooldownEnd);
}
