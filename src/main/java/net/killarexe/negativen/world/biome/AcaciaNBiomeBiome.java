
package net.killarexe.negativen.world.biome;

import net.minecraftforge.registries.ObjectHolder;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.gen.surfacebuilders.SurfaceBuilderConfig;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;
import net.minecraft.world.biome.DefaultBiomeFeatures;
import net.minecraft.world.biome.Biome;
import net.minecraft.entity.EntityClassification;

import net.killarexe.negativen.entity.ZombieNEntity;
import net.killarexe.negativen.entity.SpiderNEntity;
import net.killarexe.negativen.entity.PigNEntity;
import net.killarexe.negativen.entity.EndermanNEntity;
import net.killarexe.negativen.entity.CreeperNEntity;
import net.killarexe.negativen.entity.CowNEntity;
import net.killarexe.negativen.entity.ChickenNEntity;
import net.killarexe.negativen.block.StoneNBlock;
import net.killarexe.negativen.block.BlockherbeNBlock;
import net.killarexe.negativen.NegativenModElements;

@NegativenModElements.ModElement.Tag
public class AcaciaNBiomeBiome extends NegativenModElements.ModElement {
	@ObjectHolder("negativen:acacia_n_biome")
	public static final CustomBiome biome = null;
	public AcaciaNBiomeBiome(NegativenModElements instance) {
		super(instance, 550);
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
			super(new Biome.Builder().downfall(0f).depth(0.1f).scale(0.2f).temperature(0.5f).precipitation(Biome.RainType.NONE)
					.category(Biome.Category.NONE).waterColor(-256).waterFogColor(-256).parent("negativen:desert_n")
					.surfaceBuilder(SurfaceBuilder.DEFAULT, new SurfaceBuilderConfig(BlockherbeNBlock.block.getDefaultState(),
							StoneNBlock.block.getDefaultState(), StoneNBlock.block.getDefaultState())));
			setRegistryName("acacia_n_biome");
			DefaultBiomeFeatures.addCarvers(this);
			DefaultBiomeFeatures.addStructures(this);
			DefaultBiomeFeatures.addMonsterRooms(this);
			DefaultBiomeFeatures.addOres(this);
			this.addSpawn(EntityClassification.MONSTER, new Biome.SpawnListEntry(ZombieNEntity.entity, 20, 1, 4));
			this.addSpawn(EntityClassification.CREATURE, new Biome.SpawnListEntry(CowNEntity.entity, 20, 4, 5));
			this.addSpawn(EntityClassification.CREATURE, new Biome.SpawnListEntry(PigNEntity.entity, 20, 4, 5));
			this.addSpawn(EntityClassification.MONSTER, new Biome.SpawnListEntry(CreeperNEntity.entity, 20, 1, 4));
			this.addSpawn(EntityClassification.MONSTER, new Biome.SpawnListEntry(SpiderNEntity.entity, 20, 1, 4));
			this.addSpawn(EntityClassification.MONSTER, new Biome.SpawnListEntry(EndermanNEntity.entity, 20, 1, 4));
			this.addSpawn(EntityClassification.CREATURE, new Biome.SpawnListEntry(ChickenNEntity.entity, 20, 4, 5));
		}

		@OnlyIn(Dist.CLIENT)
		@Override
		public int getGrassColor(double posX, double posZ) {
			return -3407668;
		}

		@OnlyIn(Dist.CLIENT)
		@Override
		public int getFoliageColor() {
			return -3407668;
		}

		@OnlyIn(Dist.CLIENT)
		@Override
		public int getSkyColor() {
			return -6710785;
		}
	}
}
