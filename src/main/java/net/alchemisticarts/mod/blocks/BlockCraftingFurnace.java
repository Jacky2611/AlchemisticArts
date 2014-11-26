package net.alchemisticarts.mod.blocks;

import net.alchemisticarts.mod.AlchemisticArts;
import net.alchemisticarts.mod.tileentity.TileEntityCraftingFurnace;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class BlockCraftingFurnace extends BlockContainer {

	public BlockCraftingFurnace(Material material, String name) {
			super(material);
			this.setBlockName(name);
			this.textureName = AlchemisticArts.MODID + ":" + name;
			this.setCreativeTab(AlchemisticArts.tabAlchemisticArts);
	}

    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, float p_149727_7_, float p_149727_8_, float p_149727_9_)
    {
    	player.openGui(AlchemisticArts.instance, AlchemisticArts.guiCraftingFurnaceId, world, x, y, z);
        return true;
    }

	public static void updateBlockType(boolean active, World worldObj,
			int xCoord, int yCoord, int zCoord) {
		// TODO Auto-generated method stub
		
	}
	
    @Override
    public TileEntity createNewTileEntity(World world, int p_149915_2_) {
            return new TileEntityCraftingFurnace();
    }



}
