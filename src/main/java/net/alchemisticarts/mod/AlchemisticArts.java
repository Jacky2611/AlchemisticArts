package src.main.java.net.alchemisticarts.mod;

import net.minecraft.init.Blocks;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;

@Mod(modid = ExampleMod.MODID, version = ExampleMod.VERSION)
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
