package net.alchemisticarts.mod.container;

import net.alchemisticarts.mod.AlchemisticArts;
import net.alchemisticarts.mod.crafting.craftingfurnace.CraftingManagerCraftingFurnace;
import net.alchemisticarts.mod.tileentity.TileEntityCraftingFurnace;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.InventoryCraftResult;
import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.inventory.Slot;
import net.minecraft.inventory.SlotCrafting;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class ContainerCraftingFurnace extends Container
{

public InventoryCrafting craftMatrix;
public IInventory craftResult;
public TileEntityCraftingFurnace tileEntity;
private World worldObj;
private int posX;
private int posY;
private int posZ;

public ContainerCraftingFurnace(InventoryPlayer inventoryplayer, TileEntityCraftingFurnace tileEntity, World world, int i, int j, int k)
{
	/*
	TileEntity te = world.getTileEntity(posX, posY, posZ);
	TileEntityCraftingFurnace tileEntity = null;
	if (te!=null || (te instanceof TileEntityCraftingFurnace)){
		tileEntity=(TileEntityCraftingFurnace)te;
	} else {
		world.setTileEntity(posX, posY, posZ, new TileEntityCraftingFurnace());
	}
	*/
	
	 craftMatrix = new InventoryCrafting(this, 5, 5);
	 craftResult = new InventoryCraftResult();
	 worldObj = world;
	 this.tileEntity=tileEntity;
	 posX = i;
	 posY = j;
	 posZ = k;
	 

	 //Output
	 this.addSlotToContainer(new SlotCrafting(inventoryplayer.player, craftMatrix, craftResult, 0, 146, 15));

	 //Fuel
	 this.addSlotToContainer(new Slot(tileEntity, 0, 112, 60));
	 
	 
	 
	 //Crafting input
	 
	 for(int l = 0; l < 5; l++)
	 {
		 for(int k1 = 0; k1 < 5; k1++)
		 {
		 this.addSlotToContainer(new Slot(craftMatrix, k1 + l * 5, 11 + k1 * 18, -3 + l * 18));
		 }

	 }


	 //Inventory
	 for(int i1 = 0; i1 < 3; i1++)
	 {
		 for(int l1 = 0; l1 < 9; l1++)
		 {
		 this.addSlotToContainer(new Slot(inventoryplayer, l1 + i1 * 9 + 9, 8 + l1 * 18, 103 + i1 * 18));
		 }

	 }
	 
	 //hotbar
	 for(int j1 = 0; j1 < 9; j1++)
	 {
	 this.addSlotToContainer(new Slot(inventoryplayer, j1, 8 + j1 * 18, 161));
	 }

	 
	 
	 onCraftMatrixChanged(craftMatrix);
}


	public void onCraftMatrixChanged(IInventory iinventory){
	
		craftResult.setInventorySlotContents(0, CraftingManagerCraftingFurnace.getInstance().findMatchingRecipe(craftMatrix, worldObj));
	
	}

@Override	
public void onContainerClosed(EntityPlayer entityplayer)
{
	 super.onContainerClosed(entityplayer);

	 if(worldObj.isRemote)
	 {
		 return;
	 }
	 for(int i = 0; i < 25; i++)
	 {
		 ItemStack itemstack = craftMatrix.getStackInSlot(i);
		 if(itemstack != null)
		 {
			 entityplayer.dropItem(itemstack.getItem(), itemstack.stackSize);
			 //entityplayer.dropPlayerItem(itemstack);
		 }
	 }
	
}


public boolean canInteractWith(EntityPlayer entityplayer)
{
	 if(worldObj.getBlock(posX, posY, posZ) != AlchemisticArts.blockCraftingFurnace)
	 {
		 return false;
	 } else{
		 return entityplayer.getDistanceSq((double)posX + 0.5D, (double)posY + 0.5D, (double)posZ + 0.5D) <= 64D;
	 }
}

public ItemStack transferStackInSlot(EntityPlayer par1EntityPlayer, int par2)
{
	 ItemStack itemstack = null;
	 Slot slot = (Slot)inventorySlots.get(par2);
	 if(slot != null && slot.getHasStack())
	 {
		 ItemStack itemstack1 = slot.getStack();
		 itemstack = itemstack1.copy();
		 if(par2 == 0)
		 {
			 if(!mergeItemStack(itemstack1, 10, 46, true))
			 {
				 return null;
			 }
		 } else
		 if(par2 >= 10 && par2 < 37)
		 {
			 if(!mergeItemStack(itemstack1, 37, 46, false))
			 {
				 return null;
			 }
		 } else
		 if(par2 >= 37 && par2 < 46)
		 {
			 if(!mergeItemStack(itemstack1, 10, 37, false))
			 {
				 return null;
			 }
		 } else
		 if(!mergeItemStack(itemstack1, 10, 46, false))
		 {
			 return null;
		 }
		 if(itemstack1.stackSize == 0)
		 {
			 slot.putStack(null);
		 } else
		 {
			 slot.onSlotChanged();
		 }
		 if(itemstack1.stackSize != itemstack.stackSize)
		 {
			 slot.onPickupFromSlot(par1EntityPlayer, itemstack1);
		 } else
		 {
			 return null;
		 }
	 }
	 return itemstack;
}
}