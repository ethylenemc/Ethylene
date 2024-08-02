package org.bukkit.craftbukkit.inventory.view;

import net.minecraft.world.inventory.StonecutterMenu;
import net.minecraft.world.item.crafting.RecipeHolder;
import net.minecraft.world.item.crafting.StonecutterRecipe;
import org.bukkit.craftbukkit.inventory.CraftInventoryView;
import org.bukkit.entity.HumanEntity;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.StonecuttingRecipe;
import org.bukkit.inventory.view.StonecutterView;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class CraftStonecutterView extends CraftInventoryView<StonecutterMenu> implements StonecutterView {

    public CraftStonecutterView(final HumanEntity player, final Inventory viewing, final StonecutterMenu container) {
        super(player, viewing, container);
    }

    @Override
    public int getSelectedRecipeIndex() {
        return container.getSelectedRecipeIndex();
    }

    @NotNull
    @Override
    public List<StonecuttingRecipe> getRecipes() {
        final List<StonecuttingRecipe> recipes = new ArrayList<>();
        for (final RecipeHolder<StonecutterRecipe> recipe : container.getRecipes()) {
            recipes.add((StonecuttingRecipe) recipe.toBukkitRecipe());
        }
        return recipes;
    }

    @Override
    public int getRecipeAmount() {
        return container.getNumRecipes();
    }
}
