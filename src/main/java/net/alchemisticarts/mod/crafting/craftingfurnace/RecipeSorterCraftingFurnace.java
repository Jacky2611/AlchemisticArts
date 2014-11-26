package net.alchemisticarts.mod.crafting.craftingfurnace;

import java.util.Comparator;
import net.minecraft.item.crafting.IRecipe;

public class RecipeSorterCraftingFurnace implements Comparator
{
final CraftingManagerCraftingFurnace craftingManagerCraftingFurnace;

public RecipeSorterCraftingFurnace(CraftingManagerCraftingFurnace par1craftingManagerCraftingFurnace)
{
	 this.craftingManagerCraftingFurnace = par1craftingManagerCraftingFurnace;
}

public int compareRecipes(IRecipe par1IRecipe, IRecipe par2IRecipe)
{
	 return par1IRecipe instanceof ShapelessRecipesCraftingFurnace && par2IRecipe instanceof ShapedRecipesCraftingFurnace ? 1 : (par2IRecipe instanceof ShapelessRecipesCraftingFurnace && par1IRecipe instanceof ShapedRecipesCraftingFurnace ? -1 : (par2IRecipe.getRecipeSize() < par1IRecipe.getRecipeSize() ? -1 : (par2IRecipe.getRecipeSize() > par1IRecipe.getRecipeSize() ? 1 : 0)));
}

public int compare(Object par1Obj, Object par2Obj)
{
	 return this.compareRecipes((IRecipe)par1Obj, (IRecipe)par2Obj);
}
}