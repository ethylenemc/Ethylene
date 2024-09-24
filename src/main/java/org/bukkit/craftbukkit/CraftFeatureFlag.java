package org.bukkit.craftbukkit;

import java.util.HashSet;
import java.util.Set;
import org.bukkit.FeatureFlag;
import org.bukkit.NamespacedKey;
import org.bukkit.craftbukkit.util.CraftNamespacedKey;
import org.jetbrains.annotations.NotNull;

public class CraftFeatureFlag implements FeatureFlag {

    private final NamespacedKey namespacedKey;
    private final net.minecraft.world.flag.FeatureFlag featureFlag;

    public CraftFeatureFlag(net.minecraft.resources.ResourceLocation minecraftKey, net.minecraft.world.flag.FeatureFlag featureFlag) {
        this.namespacedKey = CraftNamespacedKey.fromMinecraft(minecraftKey);
        this.featureFlag = featureFlag;
    }

    public net.minecraft.world.flag.FeatureFlag getHandle() {
        return this.featureFlag;
    }

    @NotNull
    @Override
    public NamespacedKey getKey() {
        return this.namespacedKey;
    }

    @Override
    public String toString() {
        return "CraftFeatureFlag{key=" + this.getKey() + ",keyUniverse=" + this.getHandle().universe.toString() + "}";
    }

    public static Set<CraftFeatureFlag> getFromNMS(net.minecraft.world.flag.FeatureFlagSet featureFlagSet) {
        Set<CraftFeatureFlag> set = new HashSet<>();
        net.minecraft.world.flag.FeatureFlags.REGISTRY.names.forEach((minecraftkey, featureflag) -> {
            if (featureFlagSet.contains(featureflag)) {
                set.add(new CraftFeatureFlag(minecraftkey, featureflag));
            }
        });
        return set;
    }

    public static CraftFeatureFlag getFromNMS(NamespacedKey namespacedKey) {
        return net.minecraft.world.flag.FeatureFlags.REGISTRY.names.entrySet().stream().filter(entry -> CraftNamespacedKey.fromMinecraft(entry.getKey()).equals(namespacedKey)).findFirst().map(entry -> new CraftFeatureFlag(entry.getKey(), entry.getValue())).orElse(null);
    }
}