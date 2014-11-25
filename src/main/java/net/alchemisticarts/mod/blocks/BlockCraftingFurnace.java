package net.alchemisticarts.mod.blocks;

import net.alchemisticarts.mod.AlchemisticArts;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class BlockCraftingFurnace extends Block {

	public BlockCraftingFurnace(Material material, String name) {
			super(material);
			this.setBlockName(name);
			this.textureName = AlchemisticArts.MODID + ":" + name;
			this.setCreativeTab(AlchemisticArts.tabAlchemisticArts);
	}



}
