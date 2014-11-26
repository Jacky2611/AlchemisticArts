package net.alchemisticarts.mod;

import net.alchemisticarts.mod.blocks.BlockBasic;
import net.alchemisticarts.mod.blocks.BlockCraftingFurnace;
import net.alchemisticarts.mod.client.gui.GuiHandler;
import net.alchemisticarts.mod.crafting.craftingfurnace.CraftingFurnace;
import net.alchemisticarts.mod.items.ItemBasic;
import net.alchemisticarts.mod.tileentity.TileEntityCraftingFurnace;
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
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@Mod(modid = AlchemisticArts.MODID, version = AlchemisticArts.VERSION)
public class AlchemisticArts
{
    public static final String MODID = "alchemisticarts";
    public static final String VERSION = "0.0.2";
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
		
		public static Item itemIngotCopper;
		
		public static Item itemIngotTin;
		
		public static Item itemIngotNickel;
		
		public static Item itemIngotCobalt;
		
	
	
	//BLOCKS:
		public static Block blockCraftingFurnace;
		
		public static Block blockOreWolfram;
		public static Block blockWolfram;
		
		public static Block blockSilber;
		public static Block blockOreSilber;
		
		public static Block blockCopper;
		public static Block blockOreCopper;
	
		public static Block blockTin;
		public static Block blockOreTin;

		public static Block blockNickel;
		public static Block blockOreNickel;
		
		public static Block blockCobalt;
		public static Block blockOreCobalt;
		
		
	//Gui
		public static final int guiCraftingFurnaceId = 0;
		
	
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
    	
    	itemIngotCopper = new ItemBasic(64, "itemIngotCopper");
    	GameRegistry.registerItem(itemIngotCopper, "itemIngotCopper");
    	
    	itemIngotTin = new ItemBasic(64, "itemIngotTin");
    	GameRegistry.registerItem(itemIngotTin, "itemIngotTin");
    	
    	itemIngotNickel = new ItemBasic(64, "itemIngotNickel");
    	GameRegistry.registerItem(itemIngotNickel, "itemIngotNickel");
    	
    	itemIngotCobalt = new ItemBasic(64, "itemIngotCobalt");
    	GameRegistry.registerItem(itemIngotCobalt, "itemIngotCobalt");
    	
    	
    	//BLOCKS:
    	blockCraftingFurnace = new BlockCraftingFurnace(Material.rock, "blockCraftingFurnace");
    	GameRegistry.registerTileEntity(TileEntityCraftingFurnace.class, "craftingFurnace");
    	GameRegistry.registerBlock(blockCraftingFurnace, "blockCraftingFurnace");
    	
    	
    	
    	blockWolfram = new BlockBasic(Material.rock, "blockWolfram");
    	GameRegistry.registerBlock(blockWolfram, "blockWolfram");
    	blockOreWolfram = new BlockBasic(Material.rock, "blockOreWolfram");
    	GameRegistry.registerBlock(blockOreWolfram, "blockOreWolfram");
    	
    	blockSilber = new BlockBasic(Material.rock, "blockSilber");
    	GameRegistry.registerBlock(blockSilber, "blockSilber");
    	blockOreSilber= new BlockBasic(Material.rock, "blockOreSilber");
    	GameRegistry.registerBlock(blockOreSilber, "blockOreSilber");
    	
    	blockCopper = new BlockBasic(Material.rock, "blockCopper");
    	GameRegistry.registerBlock(blockCopper , "blockCopper");
    	blockOreCopper = new BlockBasic(Material.rock, "blockOreCopper");
    	GameRegistry.registerBlock(blockOreCopper, "blockOreCopper");
    	
    	blockTin = new BlockBasic(Material.rock, "blockTin");
    	GameRegistry.registerBlock(blockTin , "blockTin");
    	blockOreTin = new BlockBasic(Material.rock, "blockOreTin");
    	GameRegistry.registerBlock(blockOreTin, "blockOreTin");
    	
    	blockNickel = new BlockBasic(Material.rock, "blockNickel");
    	GameRegistry.registerBlock(blockNickel , "blockNickel");
    	blockOreNickel = new BlockBasic(Material.rock, "blockOreNickel");
    	GameRegistry.registerBlock(blockOreNickel, "blockOreNickel");
    	
    	blockCobalt = new BlockBasic(Material.rock, "blockCobalt");
    	GameRegistry.registerBlock(blockCobalt , "blockCobalt");
    	blockOreCobalt = new BlockBasic(Material.rock, "blockOreCobalt");
    	GameRegistry.registerBlock(blockOreCobalt, "blockOreCobalt");
    	
    	
    	
    	//CRAFTING:
    	
    	/*		EXAMPLE
    	 * 
    	   public RecipesWeapons()
    {
        recipeItems = (new Object[][] {
            new Object[] {
                Block.planks, Block.cobblestone, Item.ingotIron, Item.diamond, Item.ingotGold
            }, new Object[] {
                Item.swordWood, Item.swordStone, Item.swordSteel, Item.swordDiamond, Item.swordGold
            }
        });
    }

    public void addRecipes(CraftingManager craftingmanager)
    {
        for(int i = 0; i < recipeItems[0].length; i++)
        {
            Object obj = recipeItems[0][i];
            for(int j = 0; j < recipeItems.length - 1; j++)
            {
                Item item = (Item)recipeItems[j + 1][i];
                craftingmanager.addRecipe(new ItemStack(item), new Object[] {
                    recipePatterns[j], Character.valueOf('#'), Item.stick, Character.valueOf('X'), obj
                });
            }

        }

        craftingmanager.addRecipe(new ItemStack(Item.bow, 1), new Object[] {
            " #X", "# X", " #X", Character.valueOf('X'), Item.silk, Character.valueOf('#'), Item.stick
        });
        craftingmanager.addRecipe(new ItemStack(Item.arrow, 4), new Object[] {
            "X", "#", "Y", Character.valueOf('Y'), Item.feather, Character.valueOf('X'), Item.flint, Character.valueOf('#'), Item.stick
        });
    	}

    		private String recipePatterns[][] = {
        {
            "X", "X", "#"
        }
    	};
    	private Object recipeItems[][];
    	*/
    	GameRegistry.addSmelting(new ItemStack(AlchemisticArts.blockOreCobalt), new ItemStack(AlchemisticArts.itemIngotCobalt), 0.5f);
    	
    	GameRegistry.addSmelting(new ItemStack(AlchemisticArts.blockOreWolfram), new ItemStack(AlchemisticArts.itemIngotWolfram), 0.5f);
    	
    	GameRegistry.addSmelting(new ItemStack(AlchemisticArts.blockOreSilber), new ItemStack(AlchemisticArts.itemIngotSilber), 0.5f);
    	
    	GameRegistry.addSmelting(new ItemStack(AlchemisticArts.blockOreCopper), new ItemStack(AlchemisticArts.itemIngotCopper), 0.5f);
    	
    	GameRegistry.addSmelting(new ItemStack(AlchemisticArts.blockOreTin), new ItemStack(AlchemisticArts.itemIngotTin), 0.5f);
    	
    	GameRegistry.addSmelting(new ItemStack(AlchemisticArts.blockOreNickel), new ItemStack(AlchemisticArts.itemIngotNickel), 0.5f);
    	
	
    	GameRegistry.addShapelessRecipe(new ItemStack(AlchemisticArts.itemIngotCobalt, 9), new ItemStack(AlchemisticArts.blockCobalt));
    	
    	GameRegistry.addShapelessRecipe(new ItemStack(AlchemisticArts.itemIngotWolfram, 9), new ItemStack(AlchemisticArts.blockWolfram));
    	
    	GameRegistry.addShapelessRecipe(new ItemStack(AlchemisticArts.itemIngotSilber, 9), new ItemStack(AlchemisticArts.blockSilber));
    	
    	GameRegistry.addShapelessRecipe(new ItemStack(AlchemisticArts.itemIngotCopper, 9), new ItemStack(AlchemisticArts.blockCopper));
    	
    	GameRegistry.addShapelessRecipe(new ItemStack(AlchemisticArts.itemIngotTin, 9), new ItemStack(AlchemisticArts.blockTin));
    	
    	GameRegistry.addShapelessRecipe(new ItemStack(AlchemisticArts.itemIngotNickel, 9), new ItemStack(AlchemisticArts.blockNickel));
    	
    	GameRegistry.addRecipe(new ItemStack(AlchemisticArts.blockCobalt), "xxx", "xxx" , "xxx", 
    	        'x', new ItemStack(AlchemisticArts.itemIngotCobalt));
    	
    	GameRegistry.addRecipe(new ItemStack(AlchemisticArts.blockWolfram), "xxx", "xxx" , "xxx", 
    	        'x', new ItemStack(AlchemisticArts.itemIngotWolfram));
    	
    	GameRegistry.addRecipe(new ItemStack(AlchemisticArts.blockSilber), "xxx", "xxx" , "xxx", 
    	        'x', new ItemStack(AlchemisticArts.itemIngotSilber));
    	
    	GameRegistry.addRecipe(new ItemStack(AlchemisticArts.blockCopper), "xxx", "xxx" , "xxx", 
    	        'x', new ItemStack(AlchemisticArts.itemIngotCopper));
    	
    	GameRegistry.addRecipe(new ItemStack(AlchemisticArts.blockTin), "xxx", "xxx" , "xxx", 
    	        'x', new ItemStack(AlchemisticArts.itemIngotTin));
    	
    	GameRegistry.addRecipe(new ItemStack(AlchemisticArts.blockNickel), "xxx", "xxx" , "xxx", 
    	        'x', new ItemStack(AlchemisticArts.itemIngotNickel));   		
    	
    	CraftingFurnace.addRecipe(new ItemStack(AlchemisticArts.blockNickel), "xxx ", "xxxx" , "xxx ", 
    	        'x', new ItemStack(AlchemisticArts.itemIngotNickel));;
    	
    	//GUI
    	NetworkRegistry.INSTANCE.registerGuiHandler(this, new GuiHandler());
    	
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
