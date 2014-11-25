package net.alchemisticarts.mod.container;

import net.alchemisticarts.mod.tileentity.TileEntityCraftingFurnace;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.world.World;

public class ContainerCraftingFurnace extends Container{


	public ContainerCraftingFurnace(InventoryPlayer inventory, TileEntityCraftingFurnace tileEntity, World world,int x, int y, int z) {
		
	}

	@Override
	public boolean canInteractWith(EntityPlayer p_75145_1_) {
		// TODO Auto-generated method stub
		return false;
	}

}
