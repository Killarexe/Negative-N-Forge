
package net.killarexe.negativen.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.item.crafting.Ingredient;
import net.minecraft.item.PickaxeItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.item.IItemTier;

import net.killarexe.negativen.itemgroup.NeagtiveNOuilsItemGroup;
import net.killarexe.negativen.NegativenModElements;

@NegativenModElements.ModElement.Tag
public class Iron_NPickaxeItem extends NegativenModElements.ModElement {
	@ObjectHolder("negativen:iron_npickaxe")
	public static final Item block = null;
	public Iron_NPickaxeItem(NegativenModElements instance) {
		super(instance, 196);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new PickaxeItem(new IItemTier() {
			public int getMaxUses() {
				return 500;
			}

			public float getEfficiency() {
				return 12f;
			}

			public float getAttackDamage() {
				return 0.5f;
			}

			public int getHarvestLevel() {
				return 4;
			}

			public int getEnchantability() {
				return 14;
			}

			public Ingredient getRepairMaterial() {
				return Ingredient.fromStacks(new ItemStack(Iron_NIngotItem.block, (int) (1)));
			}
		}, 1, -3f, new Item.Properties().group(NeagtiveNOuilsItemGroup.tab)) {
		}.setRegistryName("iron_npickaxe"));
	}
}
