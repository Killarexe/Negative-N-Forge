
package net.killarexe.negativen.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.world.World;
import net.minecraft.item.UseAction;
import net.minecraft.item.Rarity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.item.Food;
import net.minecraft.entity.LivingEntity;

import net.killarexe.negativen.procedures.BeefrawNFoodEatenProcedure;
import net.killarexe.negativen.itemgroup.NegativeNFoodItemGroup;
import net.killarexe.negativen.NegativeNModElements;

import java.util.Map;
import java.util.HashMap;

@NegativeNModElements.ModElement.Tag
public class BeefrawNItem extends NegativeNModElements.ModElement {
	@ObjectHolder("negative_n:beefrawn")
	public static final Item block = null;
	public BeefrawNItem(NegativeNModElements instance) {
		super(instance, 63);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new FoodItemCustom());
	}
	public static class FoodItemCustom extends Item {
		public FoodItemCustom() {
			super(new Item.Properties().group(NegativeNFoodItemGroup.tab).maxStackSize(64).rarity(Rarity.COMMON)
					.food((new Food.Builder()).hunger(5).saturation(0.5f).meat().build()));
			setRegistryName("beefrawn");
		}

		@Override
		public UseAction getUseAction(ItemStack itemstack) {
			return UseAction.EAT;
		}

		@Override
		public ItemStack onItemUseFinish(ItemStack itemstack, World world, LivingEntity entity) {
			ItemStack retval = super.onItemUseFinish(itemstack, world, entity);
			double x = entity.getPosX();
			double y = entity.getPosY();
			double z = entity.getPosZ();
			{
				Map<String, Object> $_dependencies = new HashMap<>();
				$_dependencies.put("entity", entity);
				BeefrawNFoodEatenProcedure.executeProcedure($_dependencies);
			}
			return retval;
		}
	}
}
