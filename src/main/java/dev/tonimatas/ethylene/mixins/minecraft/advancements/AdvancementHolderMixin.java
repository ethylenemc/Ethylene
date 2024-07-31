package dev.tonimatas.ethylene.mixins.minecraft.advancements;

import dev.tonimatas.ethylene.interfaces.advancements.EthyleneAdvancementHolder;
import net.minecraft.advancements.AdvancementHolder;
import org.bukkit.advancement.Advancement;
import org.bukkit.craftbukkit.advancement.CraftAdvancement;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;

@Mixin(AdvancementHolder.class)
public class AdvancementHolderMixin implements EthyleneAdvancementHolder {
    // CraftBukkit start
    @Unique
    @Override
    public final Advancement toBukkit() {
        return new CraftAdvancement((AdvancementHolder) (Object) this);
    }
    // CraftBukkit end
}
