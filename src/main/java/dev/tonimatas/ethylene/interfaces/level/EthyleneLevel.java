package dev.tonimatas.ethylene.interfaces.level;

import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.dimension.LevelStem;
import org.bukkit.craftbukkit.CraftServer;
import org.bukkit.craftbukkit.CraftWorld;

public interface EthyleneLevel {
    CraftWorld getWorld();
    CraftServer getCraftServer();
    ResourceKey<LevelStem> getTypeKey();
    boolean ethylene$pvpMode();
    void ethylene$pvpMode(boolean value);
    boolean ethylene$captureBlockStates();
    void ethylene$captureBlockStates(boolean value);
    boolean ethylene$captureTreeGeneration();
    void ethylene$captureTreeGeneration(boolean value);
}
