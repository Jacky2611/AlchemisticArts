package net.alchemisticarts.mod.client.gui;

import net.alchemisticarts.mod.AlchemisticArts;
import net.alchemisticarts.mod.container.ContainerCraftingFurnace;
import net.alchemisticarts.mod.tileentity.TileEntityCraftingFurnace;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import cpw.mods.fml.common.network.IGuiHandler;

public class GuiHandler implements IGuiHandler {
	
        //returns an instance of the Container you made earlier
        @Override
        public Object getServerGuiElement(int id, EntityPlayer player, World world, int x, int y, int z) {
                TileEntity tileEntity = world.getTileEntity(x, y, z);
                
            	switch(id){
            	case AlchemisticArts.guiCraftingFurnaceId: return new ContainerCraftingFurnace(player.inventory, (TileEntityCraftingFurnace)tileEntity,world, x, y, z);
            	default: return null;
            	}

        }

        //returns an instance of the Gui you made earlier
        @Override
        public Object getClientGuiElement(int id, EntityPlayer player, World world,int x, int y, int z) {
            TileEntity tileEntity = world.getTileEntity(x, y, z);
        	
        	switch(id){
        	case AlchemisticArts.guiCraftingFurnaceId: return new GuiCraftingFurnace(player.inventory, (TileEntityCraftingFurnace)tileEntity,world, x, y, z);
        	default: return null;
        	}

        }
        
}