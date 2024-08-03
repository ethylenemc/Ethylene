package dev.tonimatas.ethylene.mixins.minecraft.stats;

import net.minecraft.stats.Stat;
import net.minecraft.stats.StatsCounter;
import net.minecraft.world.entity.player.Player;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.LocalCapture;

@Mixin(StatsCounter.class)
public class StatsCounterMixin {
    @Inject(method = "increment", at = @At(value = "INVOKE", target = "Lnet/minecraft/stats/StatsCounter;setValue(Lnet/minecraft/world/entity/player/Player;Lnet/minecraft/stats/Stat;I)V", shift = At.Shift.BEFORE), locals = LocalCapture.CAPTURE_FAILHARD, cancellable = true)
    private void ethylene$increment(Player player, Stat<?> stat, int i, CallbackInfo ci, int j) {
        // CraftBukkit start - fire Statistic events
        org.bukkit.event.Cancellable cancellable = org.bukkit.craftbukkit.event.CraftEventFactory.handleStatisticsIncrease(player, stat, ((StatsCounter) (Object) this).getValue(stat), j);
        if (cancellable != null && cancellable.isCancelled()) {
            ci.cancel();
        }
        // CraftBukkit end
    }
}
