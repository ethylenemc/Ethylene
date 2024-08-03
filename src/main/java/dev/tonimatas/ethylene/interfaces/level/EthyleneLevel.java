package dev.tonimatas.ethylene.interfaces.level;

import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.dimension.LevelStem;
import org.bukkit.craftbukkit.CraftServer;
import org.bukkit.craftbukkit.CraftWorld;
import org.bukkit.craftbukkit.block.CapturedBlockState;
import org.bukkit.entity.SpawnCategory;

import java.util.Map;

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
    Map<BlockPos, CapturedBlockState> ethylene$capturedBlockStates();
    it.unimi.dsi.fastutil.objects.Object2LongOpenHashMap<SpawnCategory> ethylene$ticksPerSpawnCategory();
}
