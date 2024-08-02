package dev.tonimatas.ethylene.mixins.minecraft.level;

import dev.tonimatas.ethylene.interfaces.level.EthyleneLevelAccessor;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.LevelAccessor;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;

@Mixin(LevelAccessor.class)
public interface LevelAccessorMixin extends EthyleneLevelAccessor {
    @Override
    @Unique
    ServerLevel getMinecraftWorld();
}
