package net.alchemisticarts.mod;

import net.minecraft.init.Blocks;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;

@Mod(modid = AlchemisticArts.MODID, version = AlchemisticArts.VERSION)
public class AlchemisticArts
{
    public static final String MODID = "examplemod";
    public static final String VERSION = "1.0";
    
    @EventHandler
    public void init(FMLInitializationEvent event)
    {
		// some example code
    	
    	
        System.out.println("DIRT BLOCK >> "+Blocks.dirt.getUnlocalizedName());
        System.out.println("DIRT BLOCK LALA>> "+Blocks.dirt.getUnlocalizedName());
    }
}
