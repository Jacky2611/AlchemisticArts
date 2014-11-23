package net.alchemisticarts.mod.items;

import net.alchemisticarts.mod.AlchemisticArts;
import net.minecraft.item.Item;


//Basic Item Class used for items without special properties
public class ItemBasic extends Item {

	public ItemBasic(int maxStackSize, String name) {
		setMaxStackSize(maxStackSize);
		setCreativeTab(AlchemisticArts.tabAlchemisticArts);
		setUnlocalizedName(name);
		setTextureName(AlchemisticArts.MODID + ":" + name);

	}

}