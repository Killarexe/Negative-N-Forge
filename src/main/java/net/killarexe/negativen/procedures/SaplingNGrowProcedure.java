package net.killarexe.negativen.procedures;

import net.minecraft.world.server.ServerWorld;
import net.minecraft.world.gen.feature.template.Template;
import net.minecraft.world.gen.feature.template.PlacementSettings;
import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.Rotation;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Mirror;

import net.killarexe.negativen.block.SpruceSaplingNBlock;
import net.killarexe.negativen.block.OakSaplingNBlock;
import net.killarexe.negativen.block.JungleSaplingNBlock;
import net.killarexe.negativen.block.DarkOakSaplingNBlock;
import net.killarexe.negativen.block.BirchSaplingNBlock;
import net.killarexe.negativen.block.AcaciaSaplingNBlock;
import net.killarexe.negativen.NegativeNModElements;
import net.killarexe.negativen.NegativeNMod;

import java.util.Map;

@NegativeNModElements.ModElement.Tag
public class SaplingNGrowProcedure extends NegativeNModElements.ModElement {
	public SaplingNGrowProcedure(NegativeNModElements instance) {
		super(instance, 1047);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				NegativeNMod.LOGGER.warn("Failed to load dependency x for procedure SaplingNGrow!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				NegativeNMod.LOGGER.warn("Failed to load dependency y for procedure SaplingNGrow!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				NegativeNMod.LOGGER.warn("Failed to load dependency z for procedure SaplingNGrow!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				NegativeNMod.LOGGER.warn("Failed to load dependency world for procedure SaplingNGrow!");
			return;
		}
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		double chance = 0;
		double structure = 0;
		boolean is4 = false;
		if ((((world.getBlockState(new BlockPos((int) (x + 1), (int) y, (int) z)))
				.getBlock() == (world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock())
				&& (((world.getBlockState(new BlockPos((int) x, (int) y, (int) (z + 1))))
						.getBlock() == (world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock())
						&& ((world.getBlockState(new BlockPos((int) (x + 1), (int) y, (int) (z + 1))))
								.getBlock() == (world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock())))) {
			is4 = (boolean) (true);
		}
		if (((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock() == OakSaplingNBlock.block.getDefaultState().getBlock())) {
			chance = (double) Math.random();
			structure = (double) Math.random();
			if (((chance) <= 0.25)) {
				if (((structure) <= 0.25)) {
					if (world instanceof ServerWorld) {
						Template template = ((ServerWorld) world).getStructureTemplateManager()
								.getTemplateDefaulted(new ResourceLocation("negative_n", "oak_n_tree_var1"));
						if (template != null) {
							template.func_237144_a_((ServerWorld) world, new BlockPos((int) (x - 6), (int) y, (int) (z - 4)),
									new PlacementSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE).setChunk(null).setIgnoreEntities(false),
									((World) world).rand);
						}
					}
				} else if (((structure) >= 0.25)) {
					if (world instanceof ServerWorld) {
						Template template = ((ServerWorld) world).getStructureTemplateManager()
								.getTemplateDefaulted(new ResourceLocation("negative_n", "oak_n_tree_var2"));
						if (template != null) {
							template.func_237144_a_((ServerWorld) world, new BlockPos((int) (x - 3), (int) y, (int) (z - 4)),
									new PlacementSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE).setChunk(null).setIgnoreEntities(false),
									((World) world).rand);
						}
					}
				} else if (((structure) >= 0.5)) {
					if (world instanceof ServerWorld) {
						Template template = ((ServerWorld) world).getStructureTemplateManager()
								.getTemplateDefaulted(new ResourceLocation("negative_n", "oak_n_tree_var3"));
						if (template != null) {
							template.func_237144_a_((ServerWorld) world, new BlockPos((int) (x - 4), (int) y, (int) (z - 4)),
									new PlacementSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE).setChunk(null).setIgnoreEntities(false),
									((World) world).rand);
						}
					}
				}
			}
		} else if (((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock() == DarkOakSaplingNBlock.block.getDefaultState()
				.getBlock())) {
			chance = (double) Math.random();
			if ((((is4) == (true)) && ((chance) <= 0.25))) {
				if (world instanceof ServerWorld) {
					Template template = ((ServerWorld) world).getStructureTemplateManager()
							.getTemplateDefaulted(new ResourceLocation("negative_n", "dark_oak_n_tree_var1"));
					if (template != null) {
						template.func_237144_a_((ServerWorld) world, new BlockPos((int) (x - 4), (int) y, (int) (z - 4)),
								new PlacementSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE).setChunk(null).setIgnoreEntities(false),
								((World) world).rand);
					}
				}
			}
		} else if (((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock() == BirchSaplingNBlock.block.getDefaultState()
				.getBlock())) {
			chance = (double) Math.random();
			if (((chance) <= 0.25)) {
				if (world instanceof ServerWorld) {
					Template template = ((ServerWorld) world).getStructureTemplateManager()
							.getTemplateDefaulted(new ResourceLocation("negative_n", "birch_n_tree_var1"));
					if (template != null) {
						template.func_237144_a_((ServerWorld) world, new BlockPos((int) (x - 3), (int) y, (int) (z - 3)),
								new PlacementSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE).setChunk(null).setIgnoreEntities(false),
								((World) world).rand);
					}
				}
			}
		} else if (((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock() == AcaciaSaplingNBlock.block.getDefaultState()
				.getBlock())) {
			chance = (double) Math.random();
			structure = (double) Math.random();
			if (((chance) <= 0.25)) {
				if (((structure) <= 0.25)) {
					if (world instanceof ServerWorld) {
						Template template = ((ServerWorld) world).getStructureTemplateManager()
								.getTemplateDefaulted(new ResourceLocation("negative_n", "acacia_n_tree_var1"));
						if (template != null) {
							template.func_237144_a_((ServerWorld) world, new BlockPos((int) (x - 6), (int) y, (int) (z - 4)),
									new PlacementSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE).setChunk(null).setIgnoreEntities(false),
									((World) world).rand);
						}
					}
				} else if (((structure) >= 0.25)) {
					if (world instanceof ServerWorld) {
						Template template = ((ServerWorld) world).getStructureTemplateManager()
								.getTemplateDefaulted(new ResourceLocation("negative_n", "acacia_n_tree_var2"));
						if (template != null) {
							template.func_237144_a_((ServerWorld) world, new BlockPos((int) (x - 3), (int) y, (int) (z - 4)),
									new PlacementSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE).setChunk(null).setIgnoreEntities(false),
									((World) world).rand);
						}
					}
				}
			}
		} else if (((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock() == JungleSaplingNBlock.block.getDefaultState()
				.getBlock())) {
			chance = (double) Math.random();
			structure = (double) Math.random();
			if (((chance) <= 0.25)) {
				if (((structure) <= 0.25)) {
					if (world instanceof ServerWorld) {
						Template template = ((ServerWorld) world).getStructureTemplateManager()
								.getTemplateDefaulted(new ResourceLocation("negative_n", "jungle_n_tree_var1"));
						if (template != null) {
							template.func_237144_a_((ServerWorld) world, new BlockPos((int) (x - 3), (int) y, (int) (z - 3)),
									new PlacementSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE).setChunk(null).setIgnoreEntities(false),
									((World) world).rand);
						}
					}
				} else if ((((structure) >= 0.5) && ((is4) == (true)))) {
					if (world instanceof ServerWorld) {
						Template template = ((ServerWorld) world).getStructureTemplateManager()
								.getTemplateDefaulted(new ResourceLocation("negative_n", "jungle_n_tree_var2"));
						if (template != null) {
							template.func_237144_a_((ServerWorld) world, new BlockPos((int) (x - 6), (int) y, (int) (z - 6)),
									new PlacementSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE).setChunk(null).setIgnoreEntities(false),
									((World) world).rand);
						}
					}
				} else if ((((structure) >= 0.25) && ((is4) == (true)))) {
					if (world instanceof ServerWorld) {
						Template template = ((ServerWorld) world).getStructureTemplateManager()
								.getTemplateDefaulted(new ResourceLocation("negative_n", "jungle_n_tree_var3"));
						if (template != null) {
							template.func_237144_a_((ServerWorld) world, new BlockPos((int) (x - 6), (int) y, (int) (z - 6)),
									new PlacementSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE).setChunk(null).setIgnoreEntities(false),
									((World) world).rand);
						}
					}
				}
			}
		} else if (((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock() == SpruceSaplingNBlock.block.getDefaultState()
				.getBlock())) {
			chance = (double) Math.random();
			structure = (double) Math.random();
			if (((chance) <= 0.25)) {
				if (((structure) <= 0.25)) {
					if (world instanceof ServerWorld) {
						Template template = ((ServerWorld) world).getStructureTemplateManager()
								.getTemplateDefaulted(new ResourceLocation("negative_n", "spruce_n_tree_var1"));
						if (template != null) {
							template.func_237144_a_((ServerWorld) world, new BlockPos((int) (x - 3), (int) y, (int) (z - 3)),
									new PlacementSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE).setChunk(null).setIgnoreEntities(false),
									((World) world).rand);
						}
					}
				} else if ((((structure) >= 0.5) && ((is4) == (true)))) {
					if (world instanceof ServerWorld) {
						Template template = ((ServerWorld) world).getStructureTemplateManager()
								.getTemplateDefaulted(new ResourceLocation("negative_n", "spruce_n_tree_var2"));
						if (template != null) {
							template.func_237144_a_((ServerWorld) world, new BlockPos((int) (x - 5), (int) y, (int) (z - 5)),
									new PlacementSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE).setChunk(null).setIgnoreEntities(false),
									((World) world).rand);
						}
					}
				} else if ((((structure) >= 0.25) && ((is4) == (true)))) {
					if (world instanceof ServerWorld) {
						Template template = ((ServerWorld) world).getStructureTemplateManager()
								.getTemplateDefaulted(new ResourceLocation("negative_n", "spruce_n_tree_var3"));
						if (template != null) {
							template.func_237144_a_((ServerWorld) world, new BlockPos((int) (x - 4), (int) y, (int) (z - 4)),
									new PlacementSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE).setChunk(null).setIgnoreEntities(false),
									((World) world).rand);
						}
					}
				}
			}
		}
	}
}
