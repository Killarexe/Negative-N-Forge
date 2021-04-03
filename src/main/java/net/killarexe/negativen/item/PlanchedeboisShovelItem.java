
package net.killarexe.negativen.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.item.crafting.Ingredient;
import net.minecraft.item.ShovelItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.item.IItemTier;

import net.killarexe.negativen.itemgroup.NeagtiveNOuilsItemGroup;
import net.killarexe.negativen.block.SprucePlanksNBlock;
import net.killarexe.negativen.block.PlanchedeboisNBlock;
import net.killarexe.negativen.block.JunglePlanksNBlock;
import net.killarexe.negativen.block.DarkoakplanksNBlock;
import net.killarexe.negativen.block.BirchplanksnBlock;
import net.killarexe.negativen.block.AcaciaplanksnBlock;
import net.killarexe.negativen.NegativeNModElements;

@NegativeNModElements.ModElement.Tag
public class PlanchedeboisShovelItem extends NegativeNModElements.ModElement {
	@ObjectHolder("negative_n:wood_n_shovel")
	public static final Item block = null;
	public PlanchedeboisShovelItem(NegativeNModElements instance) {
		super(instance, 290);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ShovelItem(new IItemTier() {
			public int getMaxUses() {
				return 118;
			}

			public float getEfficiency() {
				return 4f;
			}

			public float getAttackDamage() {
				return -0.5f;
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
		}, 1, -3f, new Item.Properties().group(NeagtiveNOuilsItemGroup.tab)) {
		}.setRegistryName("wood_n_shovel"));
	}
}
