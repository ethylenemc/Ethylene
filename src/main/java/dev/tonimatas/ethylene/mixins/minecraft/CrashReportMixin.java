package dev.tonimatas.ethylene.mixins.minecraft;

import net.minecraft.CrashReport;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(CrashReport.class)
public class CrashReportMixin {
    @Inject(method = "<init>", at = @At("RETURN"))
    private void ethylene$init(String string, Throwable throwable, CallbackInfo ci) {
        ((CrashReport) (Object) this).systemReport.setDetail("CraftBukkit Information", new org.bukkit.craftbukkit.CraftCrashReport()); // CraftBukkit
    }
}
