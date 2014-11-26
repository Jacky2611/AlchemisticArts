package net.alchemisticarts.mod.generation;

import java.util.Random;
import net.minecraft.src.WorldGenMinable;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import cpw.mods.fml.common.IWorldGenerator;


	public class AlchemisticArtsGeneration implements IWorldGenerator {
		@Override
			public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider){
			switch(world.provider.dimensionId){
	        case -1:
	            generateNether(world, random, chunkX * 16, chunkZ * 16);
	            break;
	        case 0:
	            generateSurface(world, random, chunkX * 16, chunkZ * 16);
	            break;
	        case 1:
	            generateEnd(world, random, chunkX * 16, chunkZ * 16);
	            break;
	        }
		}

		private void generateEnd(World world, Random rand, int chunkX, int chunkZ) {}

		private void generateSurface(World world, Random rand, int chunkX, int chunkZ) {
	        for(int k = 0; k < 10; k++){
	        	int firstBlockXCoord = chunkX + rand.nextInt(16);
	        	int firstBlockYCoord = rand.nextInt(64);
	        	int firstBlockZCoord = chunkZ + rand.nextInt(16);
	        	
	        	(new WorldGenMinable(TutorialMain.myFirstBlock.blockID, 13)).generate(world, rand, firstBlockXCoord, firstBlockYCoord, firstBlockZCoord);
	        }
		}

		private void generateNether(World world, Random rand, int chunkX, int chunkZ) {}
	}
	