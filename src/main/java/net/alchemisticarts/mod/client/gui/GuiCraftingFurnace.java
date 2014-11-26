package net.alchemisticarts.mod.client.gui;

import net.alchemisticarts.mod.AlchemisticArts;
import net.alchemisticarts.mod.container.ContainerCraftingFurnace;
import net.alchemisticarts.mod.tileentity.TileEntityCraftingFurnace;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;

import org.lwjgl.opengl.GL11;

public class GuiCraftingFurnace extends GuiContainer
{
private ResourceLocation resourceLocation = new ResourceLocation(AlchemisticArts.MODID, "textures/gui/crafting_furnace.png");
public GuiCraftingFurnace(InventoryPlayer inventoryplayer, TileEntityCraftingFurnace tileEntity, World world, int i, int j, int k)
{
	 super(new ContainerCraftingFurnace(inventoryplayer, tileEntity,world, i, j, k));
}

public void onGuiClosed()
{
	 super.onGuiClosed();
}

protected void drawGuiContainerForegroundLayer(int par1, int par2)
{
	 //FONTS!
}

protected void drawGuiContainerBackgroundLayer(float f, int i, int j)
{
	int x;
	int y=205;
	
	
	GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
	mc.renderEngine.bindTexture(resourceLocation);
	int l = (width - xSize) / 2;
	int i1 = (height - y) / 2;
	drawTexturedModalRect(l, i1, 0, 0, xSize, y);
}
}