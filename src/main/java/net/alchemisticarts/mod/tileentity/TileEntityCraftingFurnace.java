package net.alchemisticarts.mod.tileentity;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntity;

public class TileEntityCraftingFurnace extends TileEntity implements IInventory {

        private ItemStack[] inv;



        public TileEntityCraftingFurnace(){
                inv = new ItemStack[1];
                
        }
        
        @Override
        public int getSizeInventory() {
                return inv.length;
        }

        @Override
        public ItemStack getStackInSlot(int slot) {
                return inv[slot];
        }
        
        @Override
        public void setInventorySlotContents(int slot, ItemStack stack) {
                inv[slot] = stack;
                if (stack != null && stack.stackSize > getInventoryStackLimit()) {
                        stack.stackSize = getInventoryStackLimit();
                }               
        }

        @Override
        public ItemStack decrStackSize(int slot, int amt) {
                ItemStack stack = getStackInSlot(slot);
                if (stack != null) {
                        if (stack.stackSize <= amt) {
                                setInventorySlotContents(slot, null);
                        } else {
                                stack = stack.splitStack(amt);
                                if (stack.stackSize == 0) {
                                        setInventorySlotContents(slot, null);
                                }
                        }
                }
                return stack;
        }

        @Override
        public ItemStack getStackInSlotOnClosing(int slot) {
                ItemStack stack = getStackInSlot(slot);
                if (stack != null) {
                        setInventorySlotContents(slot, null);
                }
                return stack;
        }
        
        @Override
        public int getInventoryStackLimit() {
                return 64;
        }

        @Override
        public boolean isUseableByPlayer(EntityPlayer player) {
                return worldObj.getTileEntity(xCoord, yCoord, zCoord) == this &&
                player.getDistanceSq(xCoord + 0.5, yCoord + 0.5, zCoord + 0.5) < 64;
        }


        @Override
        public void readFromNBT(NBTTagCompound tagCompound) {
                super.readFromNBT(tagCompound);
                
                NBTTagList tagList = tagCompound.getTagList("Inventory",0);
                for (int i = 0; i < tagList.tagCount(); i++) {
                        NBTTagCompound tag = (NBTTagCompound) tagList.getCompoundTagAt(i);
                        byte slot = tag.getByte("Slot");
                        if (slot >= 0 && slot < inv.length) {
                                inv[slot] = ItemStack.loadItemStackFromNBT(tag);
                        }
                }
                
        }

        @Override
        public void writeToNBT(NBTTagCompound tagCompound) {
                super.writeToNBT(tagCompound);
                                
                NBTTagList itemList = new NBTTagList();
                for (int i = 0; i < inv.length; i++) {
                        ItemStack stack = inv[i];
                        if (stack != null) {
                                NBTTagCompound tag = new NBTTagCompound();
                                tag.setByte("Slot", (byte) i);
                                stack.writeToNBT(tag);
                                itemList.appendTag(tag);
                        }
                }
                tagCompound.setTag("Inventory", itemList);

        }
        





				@Override
				public String getInventoryName() {
					 return "tco.tileentitytiny";
				}

				@Override
				public boolean hasCustomInventoryName() {
					// TODO Auto-generated method stub
					return false;
				}

				@Override
				public void openInventory() {
					// TODO Auto-generated method stub
					
				}

				@Override
				public void closeInventory() {
					// TODO Auto-generated method stub
					
				}

				@Override
				public boolean isItemValidForSlot(int p_94041_1_,
						ItemStack p_94041_2_) {
					// TODO Auto-generated method stub
					return true;
				}
}





/*



package net.alchemisticarts.mod.tileentity;

import net.alchemisticarts.mod.blocks.BlockCraftingFurnace;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntity;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class TileEntityCraftingFurnace extends TileEntity implements ISidedInventory {

	private String localizedName;

	// What slots can be accesed from which side?
	private static final int[] slots_top = new int[] { 0 };
	// first take out items from slot 1, than from slot number 0
	private static final int[] slots_bottom = new int[] { 1, 0 };
	private static final int[] slots_sides = new int[] {};

	// How many Slots does Block have
	private ItemStack[] slots = new ItemStack[27];

	// stored Dimension Energy
	public int fire;

	// needed to check if status has changed...
	public boolean activeLastTick = false;

	@Override
	public void updateEntity() {

		// Will be set to true if anything has been done this round. Otherwise
		// it will be false
		boolean active = false;

		// getting rid of stack with size 0
		if (this.slots[1] != null) {
			if (this.slots[1].stackSize == 0) {
				this.slots[1] = this.slots[1].getItem().getContainerItem(this.slots[1]);
			}
		}
		
		//this.slots[1]=new ItemStack(Items.diamond);
		//this.slots[0]=new ItemStack(Items.diamond);

		// checking if status has changed
		if (active != this.activeLastTick) {
			BlockCraftingFurnace.updateBlockType(active, this.worldObj, this.xCoord, this.yCoord, this.zCoord);
			this.activeLastTick = active;
		}

	}

	@Override
	public int getSizeInventory() {
		return this.slots.length;
	}

	public boolean isInvNameLocalized() {
		return this.localizedName != null && this.localizedName.length() > 0;
	}

	public String getInvName() {
		return this.isInvNameLocalized() ? this.localizedName : "container.craftingFurnace";
	}

	public void setGuiDisplayName(String displayName) {
		this.localizedName = displayName;

	}

	@Override
	public ItemStack getStackInSlot(int i) {
		return this.slots[i];
	}

	@Override
	public ItemStack decrStackSize(int i, int j) {
		if (this.slots[i] != null) {
			ItemStack itemstack;

			if (this.slots[i].stackSize <= j) {
				itemstack = this.slots[i];

				this.slots[i] = null;
				return itemstack;
			} else {
				itemstack = this.slots[i].splitStack(j);

				if (this.slots[i].stackSize == 0) {
					this.slots[i] = null;
				}
				return itemstack;
			}
		}
		return null;
	}

	@Override
	public ItemStack getStackInSlotOnClosing(int i) {
		if (this.slots[i] != null) {
			ItemStack itemstack = this.slots[i];
			this.slots[i] = null;
			return itemstack;
		}
		return null;
	}

	@Override
	public void setInventorySlotContents(int i, ItemStack itemstack) {
		this.slots[i] = itemstack;

		if (itemstack != null && itemstack.stackSize > this.getInventoryStackLimit()) {
			itemstack.stackSize = this.getInventoryStackLimit();
		}
	}

	@Override
	public String getInventoryName() {
		return null;
	}

	@Override
	public boolean hasCustomInventoryName() {
		return false;
	}

	@Override
	public int getInventoryStackLimit() {
		return 64;
	}

	@Override
	public boolean isUseableByPlayer(EntityPlayer player) {
		return this.worldObj.getTileEntity(this.xCoord, this.yCoord, this.zCoord) != this ? false : player.getDistanceSq(this.xCoord + 0.5D, this.yCoord + 0.5D, this.zCoord + 0.5D) <= 64.0D;
	}

	@Override
	public void openInventory() {

	}

	@Override
	public void closeInventory() {

	}

	@Override
	public boolean isItemValidForSlot(int i, ItemStack item) {

		return true;
		//TO-DO

	}

	@Override
	public void writeToNBT(NBTTagCompound nbt) {
		super.writeToNBT(nbt);

		nbt.setShort("FireEnergy", (short) this.fire);

		// items
		NBTTagList list = new NBTTagList();
		for (int i = 0; i < slots.length; i++) {
			if (this.slots[i] != null) {
				NBTTagCompound compound = new NBTTagCompound();
				compound.setByte("Slot", (byte) i);
				this.slots[i].writeToNBT(compound);
				list.appendTag(compound);
			}
		}
		nbt.setTag("Items", list);

		if (this.isInvNameLocalized()) {
			nbt.setString("CustomName", this.localizedName);
		}
		nbt.setBoolean("ActiveLastTick", this.activeLastTick);
	}

	@Override
	public void readFromNBT(NBTTagCompound nbt) {
		super.readFromNBT(nbt);

		// items
		NBTTagList list = nbt.getTagList("Items", 10);
		this.slots = new ItemStack[this.getSizeInventory()];

		for (int i = 0; i < list.tagCount(); i++) {
			NBTTagCompound compound = list.getCompoundTagAt(i);
			byte b = compound.getByte("Slot");
			if (b >= 0 && b < this.slots.length) {
				this.slots[b] = ItemStack.loadItemStackFromNBT(compound);
			}

		}

		this.fire = nbt.getShort("FireEnergy");

		if (nbt.hasKey("CustomName")) {
			this.localizedName = nbt.getString("CustomName");
		}
		this.activeLastTick = nbt.getBoolean("ActiveLastTick");

	}

	@Override
	public int[] getAccessibleSlotsFromSide(int side) {
		return side == 0 ? slots_bottom : (side == 1 ? slots_top : slots_sides);
	}

	@Override
	public boolean canInsertItem(int i, ItemStack item, int side) {
		return this.isItemValidForSlot(i, item);
	}

	@Override
	public boolean canExtractItem(int i, ItemStack item, int side) {
		// if extracts from down slot 1(fuel) than true
		return side == 0 || i == 1;
	}

	/*
	@SideOnly(Side.CLIENT)
	public int getDimensionEnergyScaled(int heightDimensionEnergyBar) {
		return this.dimensionEnergy * heightDimensionEnergyBar / this.requiredDimensionEnergy;

	}
	*//*
	public int getFireEnergy() {
		return this.fire;
	}

	public void setFireEnergy(int energy) {
		this.fire = energy;
	}



}
*/