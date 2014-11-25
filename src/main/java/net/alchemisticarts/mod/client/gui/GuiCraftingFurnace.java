package net.alchemisticarts.mod.client.gui;

import net.alchemisticarts.mod.container.ContainerCraftingFurnace;
import net.alchemisticarts.mod.tileentity.TileEntityCraftingFurnace;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.world.World;

public class GuiCraftingFurnace extends GuiContainer{

	public GuiCraftingFurnace(InventoryPlayer inventory,TileEntityCraftingFurnace tileEntity, World world, int x, int y, int z) {
		super(new ContainerCraftingFurnace(inventory, tileEntity, world, x, y, z));
		
	}

	@Override
	protected void drawGuiContainerBackgroundLayer(float p_146976_1_,int p_146976_2_, int p_146976_3_) {
		// TODO Auto-generated method stub
		
	}

}
