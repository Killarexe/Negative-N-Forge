
package net.killarexe.negativen.block;

import net.minecraftforge.registries.ObjectHolder;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.World;
import net.minecraft.world.IBlockReader;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.Hand;
import net.minecraft.util.Direction;
import net.minecraft.util.ActionResultType;
import net.minecraft.loot.LootContext;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.item.BlockItem;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.client.renderer.RenderTypeLookup;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.block.material.Material;
import net.minecraft.block.SoundType;
import net.minecraft.block.BlockState;
import net.minecraft.block.Block;

import net.killarexe.negativen.procedures.CakeNOnBlockRightClickedProcedure;
import net.killarexe.negativen.itemgroup.NegativeNFoodItemGroup;
import net.killarexe.negativen.NegativeNModElements;

import java.util.Map;
import java.util.List;
import java.util.HashMap;
import java.util.Collections;

@NegativeNModElements.ModElement.Tag
public class CakeNBlock extends NegativeNModElements.ModElement {
	@ObjectHolder("negative_n:cake_n")
	public static final Block block = null;
	public CakeNBlock(NegativeNModElements instance) {
		super(instance, 79);
	}

	@Override
	public void initElements() {
		elements.blocks.add(() -> new CustomBlock());
		elements.items
				.add(() -> new BlockItem(block, new Item.Properties().group(NegativeNFoodItemGroup.tab)).setRegistryName(block.getRegistryName()));
	}

	@Override
	@OnlyIn(Dist.CLIENT)
	public void clientLoad(FMLClientSetupEvent event) {
		RenderTypeLookup.setRenderLayer(block, RenderType.getCutoutMipped());
	}
	public static class CustomBlock extends Block {
		public CustomBlock() {
			super(Block.Properties.create(Material.CAKE).sound(SoundType.CLOTH).hardnessAndResistance(1.2f, 10f).setLightLevel(s -> 0).notSolid()
					.setOpaque((bs, br, bp) -> false));
			setRegistryName("cake_n");
		}

		@Override
		public boolean propagatesSkylightDown(BlockState state, IBlockReader reader, BlockPos pos) {
			return true;
		}

		@Override
		public List<ItemStack> getDrops(BlockState state, LootContext.Builder builder) {
			List<ItemStack> dropsOriginal = super.getDrops(state, builder);
			if (!dropsOriginal.isEmpty())
				return dropsOriginal;
			return Collections.singletonList(new ItemStack(this, 1));
		}

		@Override
		public ActionResultType onBlockActivated(BlockState state, World world, BlockPos pos, PlayerEntity entity, Hand hand,
				BlockRayTraceResult hit) {
			super.onBlockActivated(state, world, pos, entity, hand, hit);
			int x = pos.getX();
			int y = pos.getY();
			int z = pos.getZ();
			Direction direction = hit.getFace();
			{
				Map<String, Object> $_dependencies = new HashMap<>();
				$_dependencies.put("entity", entity);
				$_dependencies.put("x", x);
				$_dependencies.put("y", y);
				$_dependencies.put("z", z);
				$_dependencies.put("world", world);
				CakeNOnBlockRightClickedProcedure.executeProcedure($_dependencies);
			}
			return ActionResultType.SUCCESS;
		}
	}
}
