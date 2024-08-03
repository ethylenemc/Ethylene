package dev.tonimatas.ethylene.mixins.minecraft.level.redstone;

import dev.tonimatas.ethylene.interfaces.level.EthyleneLevel;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.redstone.NeighborUpdater;
import org.bukkit.craftbukkit.CraftWorld;
import org.bukkit.craftbukkit.block.CraftBlock;
import org.bukkit.craftbukkit.block.data.CraftBlockData;
import org.bukkit.event.block.BlockPhysicsEvent;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(NeighborUpdater.class)
public class NeighborUpdaterMixin {
    @Inject(method = "executeUpdate", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/level/block/state/BlockState;handleNeighborChanged(Lnet/minecraft/world/level/Level;Lnet/minecraft/core/BlockPos;Lnet/minecraft/world/level/block/Block;Lnet/minecraft/core/BlockPos;Z)V", shift = At.Shift.BEFORE))
    private static void ethylene$executeUpdate(Level level, BlockState blockState, BlockPos blockPos, Block block, BlockPos blockPos2, boolean bl, CallbackInfo ci) {
        // CraftBukkit start
        CraftWorld cworld = ((EthyleneLevel) level).getWorld();
        if (cworld != null) {
            BlockPhysicsEvent event = new BlockPhysicsEvent(CraftBlock.at(level, blockPos), CraftBlockData.fromData(blockState), CraftBlock.at(level, blockPos2));
            ((EthyleneLevel) level).getCraftServer().getPluginManager().callEvent(event);

            if (event.isCancelled()) {
                return;
            }
        }
        // CraftBukkit end
    }
}
