package dev.tonimatas.ethylene.interfaces.network.synched;

public interface EthyleneSynchedEntityData {
    <T> void markDirty(net.minecraft.network.syncher.EntityDataAccessor<T> datawatcherobject);
}
