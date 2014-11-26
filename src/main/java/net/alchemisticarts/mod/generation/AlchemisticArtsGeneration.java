package net.alchemisticarts.mod.generation;

import java.util.Random;

import net.alchemisticarts.mod.AlchemisticArts;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;
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
			
			generateOre(AlchemisticArts.blockOreCobalt, world, rand, chunkX, chunkZ, 30, 10, 0, 50, Blocks.stone);
		
		}

		private void generateNether(World world, Random rand, int chunkX, int chunkZ) {
			
		}
		
		
		
		public void generateOre(Block block, World world, Random random, int chunk_x, int chunk_z, int maxVeinSize, int chancesToSpawn, int minY, int maxY, Block generateIn) {

			int heightRange = maxY - minY;

			WorldGenMinable worldgenminable = new WorldGenMinable(block, 13, generateIn);
			for (int k1 = 0; k1 < chancesToSpawn; ++k1) {
				int xrand = random.nextInt(16);
				int yrand = random.nextInt(heightRange) + minY;
				int zrand = random.nextInt(16);
				worldgenminable.generate(world, random, chunk_x + xrand, yrand, chunk_z + zrand);
			}
		}
	}
	