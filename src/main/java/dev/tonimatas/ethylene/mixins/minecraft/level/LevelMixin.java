package dev.tonimatas.ethylene.mixins.minecraft.level;

import dev.tonimatas.ethylene.interfaces.level.EthyleneLevel;
import net.minecraft.core.BlockPos;
import net.minecraft.core.RegistryAccess;
import net.minecraft.resources.ResourceKey;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.dimension.LevelStem;
import org.bukkit.Bukkit;
import org.bukkit.craftbukkit.CraftServer;
import org.bukkit.craftbukkit.CraftWorld;
import org.bukkit.craftbukkit.block.CapturedBlockState;
import org.bukkit.craftbukkit.util.CraftSpawnCategory;
import org.bukkit.entity.SpawnCategory;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Mixin(Level.class)
public abstract class LevelMixin implements EthyleneLevel {
    // CraftBukkit start Added the following
    @Unique @Final private CraftWorld world;
    @Unique public boolean pvpMode;

    @Override
    @Unique
    public boolean ethylene$pvpMode() {
        return this.pvpMode;
    }

    @Override
    @Unique
    public void ethylene$pvpMode(boolean value) {
        this.pvpMode = value;
    }

    @Unique public org.bukkit.generator.ChunkGenerator generator;

    @Unique public boolean preventPoiUpdated = false; // CraftBukkit - SPIGOT-5710

    @Unique public boolean captureBlockStates = false;

    @Override
    @Unique
    public boolean ethylene$captureBlockStates() {
        return this.captureBlockStates;
    }

    @Override
    @Unique
    public void ethylene$captureBlockStates(boolean value) {
        this.captureBlockStates = value;
    }

    @Unique public boolean captureTreeGeneration = false;

    @Override
    @Unique
    public boolean ethylene$captureTreeGeneration() {
        return this.captureTreeGeneration;
    }

    @Override
    @Unique
    public void ethylene$captureTreeGeneration(boolean value) {
        this.captureTreeGeneration = value;
    }

    @Unique public Map<BlockPos, CapturedBlockState> capturedBlockStates = new java.util.LinkedHashMap<>();
    
    @Unique public Map<BlockPos, BlockEntity> capturedTileEntities = new HashMap<>();
    
    @Unique public List<ItemEntity> captureDrops;
    
    @Unique public final it.unimi.dsi.fastutil.objects.Object2LongOpenHashMap<SpawnCategory> ticksPerSpawnCategory = new it.unimi.dsi.fastutil.objects.Object2LongOpenHashMap<>();
    
    @Unique public boolean populating;

    @Override
    @Unique
    public CraftWorld getWorld() {
        return this.world;
    }

    @Override
    @Unique
    public CraftServer getCraftServer() {
        return (CraftServer) Bukkit.getServer();
    }

    @Override
    @Unique
    public abstract ResourceKey<LevelStem> getTypeKey();

    //protected World(WorldDataMutable worlddatamutable, ResourceKey<Level> resourcekey, RegistryAccess iregistrycustom, Holder<DimensionManager> holder, Supplier<GameProfilerFiller> supplier, boolean flag, boolean flag1, long i, int j, org.bukkit.generator.ChunkGenerator gen, org.bukkit.generator.BiomeProvider biomeProvider, org.bukkit.World.Environment env) {
    //    this.generator = gen;
    //    this.world = new CraftWorld((ServerLevel) (Object) this, gen, biomeProvider, env);
//
    //    // CraftBukkit Ticks things
    //    for (SpawnCategory spawnCategory : SpawnCategory.values()) {
    //        if (CraftSpawnCategory.isValidForLimits(spawnCategory)) {
    //            this.ticksPerSpawnCategory.put(spawnCategory, (long) this.getCraftServer().getTicksPerSpawns(spawnCategory));
    //        }
    //    }

        // CraftBukkit end
}
