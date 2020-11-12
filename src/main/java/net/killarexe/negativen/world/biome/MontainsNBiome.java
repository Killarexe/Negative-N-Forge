
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
import net.killarexe.negativen.block.SnowBlockNBlock;
import net.killarexe.negativen.NegativenModElements;

@NegativenModElements.ModElement.Tag
public class MontainsNBiome extends NegativenModElements.ModElement {
	@ObjectHolder("negativen:montains_n")
	public static final CustomBiome biome = null;
	public MontainsNBiome(NegativenModElements instance) {
		super(instance, 635);
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
			super(new Biome.Builder().downfall(0.5f).depth(1f).scale(0.5f).temperature(0.5f).precipitation(Biome.RainType.RAIN)
					.category(Biome.Category.NONE).waterColor(-256).waterFogColor(-256)
					.surfaceBuilder(SurfaceBuilder.DEFAULT, new SurfaceBuilderConfig(SnowBlockNBlock.block.getDefaultState(),
							StoneNBlock.block.getDefaultState(), StoneNBlock.block.getDefaultState())));
			setRegistryName("montains_n");
			DefaultBiomeFeatures.addCarvers(this);
			DefaultBiomeFeatures.addStructures(this);
			DefaultBiomeFeatures.addMonsterRooms(this);
			DefaultBiomeFeatures.addOres(this);
			this.addSpawn(EntityClassification.MONSTER, new Biome.SpawnListEntry(ZombieNEntity.entity, 20, 1, 4));
			this.addSpawn(EntityClassification.MONSTER, new Biome.SpawnListEntry(CreeperNEntity.entity, 20, 1, 4));
			this.addSpawn(EntityClassification.MONSTER, new Biome.SpawnListEntry(SpiderNEntity.entity, 20, 1, 4));
			this.addSpawn(EntityClassification.CREATURE, new Biome.SpawnListEntry(CowNEntity.entity, 20, 4, 4));
			this.addSpawn(EntityClassification.CREATURE, new Biome.SpawnListEntry(PigNEntity.entity, 20, 4, 4));
			this.addSpawn(EntityClassification.MONSTER, new Biome.SpawnListEntry(EndermanNEntity.entity, 10, 1, 1));
			this.addSpawn(EntityClassification.CREATURE, new Biome.SpawnListEntry(ChickenNEntity.entity, 20, 1, 4));
		}

		@OnlyIn(Dist.CLIENT)
		@Override
		public int getGrassColor(double posX, double posZ) {
			return -6749953;
		}

		@OnlyIn(Dist.CLIENT)
		@Override
		public int getFoliageColor() {
			return -6749953;
		}

		@OnlyIn(Dist.CLIENT)
		@Override
		public int getSkyColor() {
			return -6684673;
		}
	}
}
