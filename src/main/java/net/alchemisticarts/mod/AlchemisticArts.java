package net.alchemisticarts.mod;

import net.alchemisticarts.mod.blocks.BlockBasic;
import net.alchemisticarts.mod.items.ItemBasic;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@Mod(modid = AlchemisticArts.MODID, version = AlchemisticArts.VERSION)
public class AlchemisticArts
{
    public static final String MODID = "alchemisticarts";
    public static final String VERSION = "0.0.1";
    @Instance(MODID)
	public static AlchemisticArts instance;
    
	public static CreativeTabs tabAlchemisticArts = new CreativeTabs("tabAlchemisticArts") {
		@Override
		@SideOnly(Side.CLIENT)
		public ItemStack getIconItemStack() {
			return new ItemStack(Items.ender_eye, 1, 0);
		}

		@Override
		public Item getTabIconItem() {
			return null;
		}

	};
	
	
	//ITEMS:
		public static Item itemShinyCrystal;
		
		public static Item itemIngotWolfram;
		
		public static Item itemIngotSilber;
		
	
	
	//BLOCKS:
		public static Block blockHardStone;
		
		public static Block blockOreWolfram;
		public static Block blockWolfram;
		
		public static Block blockSilber;
		public static Block blockOreSilber;
	
	
	
    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
    	//ITEMS:
    	itemShinyCrystal = new ItemBasic(64, "itemShinyCrystal");
    	GameRegistry.registerItem(itemShinyCrystal, "itemShinyCrystal");
    	
    	itemIngotWolfram = new ItemBasic(64, "itemIngotWolfram");
    	GameRegistry.registerItem(itemIngotWolfram, "itemIngotWolfram");
    	
    	
    	itemIngotSilber = new ItemBasic(64, "itemIngotSilber");
    	GameRegistry.registerItem(itemIngotSilber, "itemIngotSilber");
    	
    	
    	//BLOCKS:
    	blockHardStone = new BlockBasic(Material.rock, "blockHardStone");
    	GameRegistry.registerBlock(blockHardStone, "blockHardStone");
    	
    	blockWolfram = new BlockBasic(Material.rock, "blockWolfram");
    	GameRegistry.registerBlock(blockWolfram, "blockWolfram");
    	blockOreWolfram = new BlockBasic(Material.rock, "blockOreWolfram");
    	GameRegistry.registerBlock(blockOreWolfram, "blockOreWolfram");
    	
    	blockSilber = new BlockBasic(Material.rock, "blockSilber");
    	GameRegistry.registerBlock(blockSilber, "blockSilber");
    	blockOreSilber= new BlockBasic(Material.rock, "blockOreSilber");
    	GameRegistry.registerBlock(blockOreSilber, "blockOreSilber");
    	
    	
    	
    	//CRAFTING:
    	GameRegistry.addRecipe(new ItemStack(Blocks.end_stone), "xxx","xyx" , "xxx", 
    	        'x', new ItemStack(Blocks.stone),
    	        'y', new ItemStack(Items.ender_pearl));
    	
    	//SMELTING:
    	
    	
    }    
    
    @EventHandler
    public void init(FMLInitializationEvent event)
    {
		// some example code
    	
    	
        System.out.println("DIRT BLOCK >> "+Blocks.dirt.getUnlocalizedName());
        System.out.println("DIRT BLOCK LALA>> "+Blocks.dirt.getUnlocalizedName());
    }
    
    @EventHandler
    public void postInit(FMLPostInitializationEvent event)
    {
		
    }
}
