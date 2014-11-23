package net.alchemisticarts.mod.blocks;

import net.alchemisticarts.mod.AlchemisticArts;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;


//Basic Block Class used for Blocks without special properties
public class BlockBasic extends Block {

	public BlockBasic(Material material, String name) {
		super(material);
		this.setBlockName(name);
		this.textureName = AlchemisticArts.MODID + ":" + name;
		this.setCreativeTab(AlchemisticArts.tabAlchemisticArts);
	}

}
