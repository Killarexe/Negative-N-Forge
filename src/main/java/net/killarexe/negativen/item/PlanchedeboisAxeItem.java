
package net.killarexe.negativen.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.world.World;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.item.IItemTier;
import net.minecraft.item.AxeItem;
import net.minecraft.entity.LivingEntity;

import net.killarexe.negativen.procedures.PoisonusProccedProcedure;
import net.killarexe.negativen.itemgroup.NeagtiveNOuilsItemGroup;
import net.killarexe.negativen.block.SprucePlanksNBlock;
import net.killarexe.negativen.block.PlanchedeboisNBlock;
import net.killarexe.negativen.block.JunglePlanksNBlock;
import net.killarexe.negativen.block.DarkoakplanksNBlock;
import net.killarexe.negativen.block.BirchplanksnBlock;
import net.killarexe.negativen.block.AcaciaplanksnBlock;
import net.killarexe.negativen.NegativenModElements;

import java.util.Map;
import java.util.HashMap;

@NegativenModElements.ModElement.Tag
public class PlanchedeboisAxeItem extends NegativenModElements.ModElement {
	@ObjectHolder("negativen:wood_n_axe")
	public static final Item block = null;
	public PlanchedeboisAxeItem(NegativenModElements instance) {
		super(instance, 267);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new AxeItem(new IItemTier() {
			public int getMaxUses() {
				return 118;
			}

			public float getEfficiency() {
				return 4f;
			}

			public float getAttackDamage() {
				return 1.5f;
			}

			public int getHarvestLevel() {
				return 1;
			}

			public int getEnchantability() {
				return 30;
			}

			public Ingredient getRepairMaterial() {
				return Ingredient.fromStacks(new ItemStack(PlanchedeboisNBlock.block, (int) (1)), new ItemStack(AcaciaplanksnBlock.block, (int) (1)),
						new ItemStack(BirchplanksnBlock.block, (int) (1)), new ItemStack(DarkoakplanksNBlock.block, (int) (1)),
						new ItemStack(JunglePlanksNBlock.block, (int) (1)), new ItemStack(SprucePlanksNBlock.block, (int) (1)));
			}
		}, 1, -1f, new Item.Properties().group(NeagtiveNOuilsItemGroup.tab)) {
			@Override
			public boolean hitEntity(ItemStack itemstack, LivingEntity entity, LivingEntity sourceentity) {
				boolean retval = super.hitEntity(itemstack, entity, sourceentity);
				double x = entity.getPosX();
				double y = entity.getPosY();
				double z = entity.getPosZ();
				World world = entity.world;
				{
					Map<String, Object> $_dependencies = new HashMap<>();
					$_dependencies.put("entity", entity);
					$_dependencies.put("itemstack", itemstack);
					PoisonusProccedProcedure.executeProcedure($_dependencies);
				}
				return retval;
			}
		}.setRegistryName("wood_n_axe"));
	}
}
