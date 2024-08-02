package org.bukkit.craftbukkit.inventory;

import net.minecraft.server.MinecraftServer;
import net.minecraft.world.item.crafting.RecipeHolder;
import org.bukkit.inventory.Recipe;

import java.util.Iterator;
import java.util.Map;

public class RecipeIterator implements Iterator<Recipe> {
    private final Iterator<Map.Entry<net.minecraft.world.item.crafting.Recipe<?>, RecipeHolder<?>>> recipes;

    public RecipeIterator() {
        this.recipes = MinecraftServer.getServer().getRecipeManager().byType.entries().iterator();
    }

    @Override
    public boolean hasNext() {
        return recipes.hasNext();
    }

    @Override
    public Recipe next() {
        return recipes.next().getValue().toBukkitRecipe();
    }

    @Override
    public void remove() {
        recipes.remove();
    }
}
