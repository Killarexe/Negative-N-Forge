
package net.killarexe.negativen.block;

import net.minecraftforge.registries.ObjectHolder;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.common.MinecraftForge;

import net.minecraft.world.gen.feature.template.IRuleTestType;
import net.minecraft.world.gen.feature.template.BlockMatchRuleTest;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraft.world.gen.feature.OreFeature;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.World;
import net.minecraft.world.ISeedReader;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.RegistryKey;
import net.minecraft.loot.LootContext;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.item.BlockItem;
import net.minecraft.block.material.Material;
import net.minecraft.block.SoundType;
import net.minecraft.block.BlockState;
import net.minecraft.block.Block;

import net.killarexe.negativen.itemgroup.NegativeNBlocksItemGroup;
import net.killarexe.negativen.NegativenModElements;

import java.util.Random;
import java.util.List;
import java.util.Collections;

@NegativenModElements.ModElement.Tag
public class AncientDebrisNBlock extends NegativenModElements.ModElement {
	@ObjectHolder("negativen:ancient_debris_n")
	public static final Block block = null;
	public AncientDebrisNBlock(NegativenModElements instance) {
		super(instance, 189);
		MinecraftForge.EVENT_BUS.register(this);
	}

	@Override
	public void initElements() {
		elements.blocks.add(() -> new CustomBlock());
		elements.items
				.add(() -> new BlockItem(block, new Item.Properties().group(NegativeNBlocksItemGroup.tab)).setRegistryName(block.getRegistryName()));
	}
	public static class CustomBlock extends Block {
		public CustomBlock() {
			super(Block.Properties.create(Material.ROCK).sound(SoundType.ANCIENT_DEBRIS).hardnessAndResistance(3f, 50f).setLightLevel(s -> 0)
					.harvestLevel(6).harvestTool(ToolType.PICKAXE));
			setRegistryName("ancient_debris_n");
		}

		@Override
		public List<ItemStack> getDrops(BlockState state, LootContext.Builder builder) {
			List<ItemStack> dropsOriginal = super.getDrops(state, builder);
			if (!dropsOriginal.isEmpty())
				return dropsOriginal;
			return Collections.singletonList(new ItemStack(this, 1));
		}
	}
	@SubscribeEvent
	public void addFeatureToBiomes(BiomeLoadingEvent event) {
		event.getGeneration().getFeatures(GenerationStage.Decoration.UNDERGROUND_ORES).add(() -> new OreFeature(OreFeatureConfig.CODEC) {
			@Override
			public boolean generate(ISeedReader world, ChunkGenerator generator, Random rand, BlockPos pos, OreFeatureConfig config) {
				RegistryKey<World> dimensionType = world.getWorld().getDimensionKey();
				boolean dimensionCriteria = false;
				if (dimensionType == RegistryKey.getOrCreateKey(Registry.WORLD_KEY, new ResourceLocation("negativen:netherndim")))
					dimensionCriteria = true;
				if (dimensionType == RegistryKey.getOrCreateKey(Registry.WORLD_KEY, new ResourceLocation("negativen:mineingdim")))
					dimensionCriteria = true;
				if (dimensionType == World.OVERWORLD)
					dimensionCriteria = true;
				if (!dimensionCriteria)
					return false;
				return super.generate(world, generator, rand, pos, config);
			}
		}.withConfiguration(new OreFeatureConfig(new BlockMatchRuleTest(StoneNBlock.block.getDefaultState().getBlock()) {
			public boolean test(BlockState blockAt, Random random) {
				boolean blockCriteria = false;
				if (blockAt.getBlock() == StoneNBlock.block.getDefaultState().getBlock())
					blockCriteria = true;
				if (blockAt.getBlock() == NetherrackNBlock.block.getDefaultState().getBlock())
					blockCriteria = true;
				return blockCriteria;
			}

			protected IRuleTestType<?> getType() {
				return IRuleTestType.BLOCK_MATCH;
			}
		}, block.getDefaultState(), 2)).range(17).square().func_242731_b(2));
	}
}
