package dev.tonimatas.ethylene.mixins.minecraft.network.syncher;

import dev.tonimatas.ethylene.interfaces.network.synched.EthyleneSynchedEntityData;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.SynchedEntityData;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;

@Mixin(SynchedEntityData.class)
public class SynchedEntityDataMixin implements EthyleneSynchedEntityData {

    // CraftBukkit start - add method from above
    @Override
    @Unique
    public <T> void markDirty(EntityDataAccessor<T> datawatcherobject) {
        ((SynchedEntityData) (Object) this).getItem(datawatcherobject).setDirty(true);
        ((SynchedEntityData) (Object) this).isDirty = true;
    }
    // CraftBukkit end
}
