package dev.tonimatas.ethylene.mixins.minecraft.world.inventory;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.ItemCombinerMenu;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(ItemCombinerMenu.class)
public class ItemCombinerMenuMixin {
    @Inject(method = "stillValid", at = @At("HEAD"), cancellable = true)
    private void ethylene$stillValid(Player player, CallbackInfoReturnable<Boolean> cir) {
        if (!((ItemCombinerMenu) (Object) this).checkReachable) cir.setReturnValue(true); // CraftBukkit
    }
}
