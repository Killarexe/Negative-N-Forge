
package net.killarexe.negativen.world.biome;

import net.minecraftforge.registries.ObjectHolder;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;

import net.minecraft.world.gen.surfacebuilders.SurfaceBuilderConfig;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;
import net.minecraft.world.biome.DefaultBiomeFeatures;
import net.minecraft.world.biome.Biome;

import net.killarexe.negativen.block.GrassBlockCaveGameBlock;
import net.killarexe.negativen.block.CobblestoneCaveGameBlock;
import net.killarexe.negativen.NegativenModElements;

@NegativenModElements.ModElement.Tag
public class CaveGameBiomeBiome extends NegativenModElements.ModElement {
	@ObjectHolder("negativen:cave_game_biome")
	public static final CustomBiome biome = null;
	public CaveGameBiomeBiome(NegativenModElements instance) {
		super(instance, 667);
	}

	@Override
	public void initElements() {
		elements.biomes.add(() -> new CustomBiome());
	}

	@Override
	public void init(FMLCommonSetupEvent event) {
	}
	static class CustomBiome extends Biome {
		public CustomBiome() {
			super(new Biome.Builder().downfall(0f).depth(0f).scale(0f).temperature(0.5f).precipitation(Biome.RainType.NONE)
					.category(Biome.Category.NONE).waterColor(4159204).waterFogColor(329011)
					.surfaceBuilder(SurfaceBuilder.DEFAULT, new SurfaceBuilderConfig(GrassBlockCaveGameBlock.block.getDefaultState(),
							CobblestoneCaveGameBlock.block.getDefaultState(), CobblestoneCaveGameBlock.block.getDefaultState())));
			setRegistryName("cave_game_biome");
			DefaultBiomeFeatures.addStructures(this);
		}
	}
}
