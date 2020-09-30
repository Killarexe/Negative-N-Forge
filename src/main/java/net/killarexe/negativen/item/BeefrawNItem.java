
package net.killarexe.negativen.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.world.World;
import net.minecraft.item.UseAction;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.item.Food;
import net.minecraft.entity.LivingEntity;

import net.killarexe.negativen.procedures.BeefrawNFoodEatenProcedure;
import net.killarexe.negativen.itemgroup.NegativeNFoodItemGroup;
import net.killarexe.negativen.NegativenModElements;

import java.util.Map;
import java.util.HashMap;

@NegativenModElements.ModElement.Tag
public class BeefrawNItem extends NegativenModElements.ModElement {
	@ObjectHolder("negativen:beefrawn")
	public static final Item block = null;
	public BeefrawNItem(NegativenModElements instance) {
		super(instance, 220);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new FoodItemCustom());
	}
	public static class FoodItemCustom extends Item {
		public FoodItemCustom() {
			super(new Item.Properties().group(NegativeNFoodItemGroup.tab).maxStackSize(64)
					.food((new Food.Builder()).hunger(5).saturation(0.5f).meat().build()));
			setRegistryName("beefrawn");
		}

		@Override
		public UseAction getUseAction(ItemStack par1ItemStack) {
			return UseAction.EAT;
		}

		@Override
		public ItemStack onItemUseFinish(ItemStack itemStack, World world, LivingEntity entity) {
			ItemStack retval = super.onItemUseFinish(itemStack, world, entity);
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
