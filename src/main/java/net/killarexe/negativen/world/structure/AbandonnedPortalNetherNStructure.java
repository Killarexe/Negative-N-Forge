
package net.killarexe.negativen.world.structure;

import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.common.MinecraftForge;

import net.minecraft.world.gen.placement.Placement;
import net.minecraft.world.gen.placement.IPlacementConfig;
import net.minecraft.world.gen.feature.template.Template;
import net.minecraft.world.gen.feature.template.PlacementSettings;
import net.minecraft.world.gen.feature.template.BlockIgnoreStructureProcessor;
import net.minecraft.world.gen.feature.NoFeatureConfig;
import net.minecraft.world.gen.feature.IFeatureConfig;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.Heightmap;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.World;
import net.minecraft.world.ISeedReader;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.Rotation;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.RegistryKey;
import net.minecraft.util.Mirror;

import net.killarexe.negativen.NegativeNModElements;

import java.util.Random;

@NegativeNModElements.ModElement.Tag
public class AbandonnedPortalNetherNStructure extends NegativeNModElements.ModElement {
	public AbandonnedPortalNetherNStructure(NegativeNModElements instance) {
		super(instance, 640);
		MinecraftForge.EVENT_BUS.register(this);
	}

	@SubscribeEvent
	public void addFeatureToBiomes(BiomeLoadingEvent event) {
		Feature<NoFeatureConfig> feature = new Feature<NoFeatureConfig>(NoFeatureConfig.field_236558_a_) {
			@Override
			public boolean generate(ISeedReader world, ChunkGenerator generator, Random random, BlockPos pos, NoFeatureConfig config) {
				int ci = (pos.getX() >> 4) << 4;
				int ck = (pos.getZ() >> 4) << 4;
				RegistryKey<World> dimensionType = world.getWorld().getDimensionKey();
				boolean dimensionCriteria = false;
				if (dimensionType == World.OVERWORLD)
					dimensionCriteria = true;
				if (dimensionType == World.THE_END)
					dimensionCriteria = true;
				if (dimensionType == RegistryKey.getOrCreateKey(Registry.WORLD_KEY, new ResourceLocation("negative_n:overworld_n")))
					dimensionCriteria = true;
				if (dimensionType == RegistryKey.getOrCreateKey(Registry.WORLD_KEY, new ResourceLocation("negative_n:mineingdim")))
					dimensionCriteria = true;
				if (dimensionType == RegistryKey.getOrCreateKey(Registry.WORLD_KEY, new ResourceLocation("negative_n:startdim")))
					dimensionCriteria = true;
				if (dimensionType == RegistryKey.getOrCreateKey(Registry.WORLD_KEY, new ResourceLocation("negative_n:nonedim")))
					dimensionCriteria = true;
				if (dimensionType == RegistryKey.getOrCreateKey(Registry.WORLD_KEY, new ResourceLocation("negative_n:classic_dim")))
					dimensionCriteria = true;
				if (dimensionType == RegistryKey.getOrCreateKey(Registry.WORLD_KEY, new ResourceLocation("negative_n:classic_n_dim")))
					dimensionCriteria = true;
				if (!dimensionCriteria)
					return false;
				if ((random.nextInt(1000000) + 1) <= 750) {
					int count = random.nextInt(1) + 1;
					for (int a = 0; a < count; a++) {
						int i = ci + random.nextInt(16);
						int k = ck + random.nextInt(16);
						int j = world.getHeight(Heightmap.Type.OCEAN_FLOOR_WG, i, k);
						j -= 1;
						Rotation rotation = Rotation.values()[random.nextInt(3)];
						Mirror mirror = Mirror.values()[random.nextInt(2)];
						BlockPos spawnTo = new BlockPos(i + 0, j + 0, k + 0);
						int x = spawnTo.getX();
						int y = spawnTo.getY();
						int z = spawnTo.getZ();
						Template template = world.getWorld().getStructureTemplateManager()
								.getTemplateDefaulted(new ResourceLocation("negative_n", "abandonned_portal_5"));
						if (template == null)
							return false;
						template.func_237144_a_(world, spawnTo, new PlacementSettings().setRotation(rotation).setRandom(random).setMirror(mirror)
								.addProcessor(BlockIgnoreStructureProcessor.STRUCTURE_BLOCK).setChunk(null).setIgnoreEntities(false), random);
					}
				}
				return true;
			}
		};
		event.getGeneration().getFeatures(GenerationStage.Decoration.SURFACE_STRUCTURES).add(() -> feature
				.withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG).withPlacement(Placement.NOPE.configure(IPlacementConfig.NO_PLACEMENT_CONFIG)));
	}
}
