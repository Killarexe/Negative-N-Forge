
package net.killarexe.negativen.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.world.World;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.item.IItemTier;
import net.minecraft.entity.LivingEntity;

import net.killarexe.negativen.procedures.PoisonusProccedProcedure;
import net.killarexe.negativen.itemgroup.NegativeNCombatItemGroup;
import net.killarexe.negativen.NegativeNModElements;

import java.util.Map;
import java.util.HashMap;

@NegativeNModElements.ModElement.Tag
public class CobblestoneSwordItem extends NegativeNModElements.ModElement {
	@ObjectHolder("negative_n:cobblestone_n_sword")
	public static final Item block = null;
	public CobblestoneSwordItem(NegativeNModElements instance) {
		super(instance, 353);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new SwordItem(new IItemTier() {
			public int getMaxUses() {
				return 262;
			}

			public float getEfficiency() {
				return 8f;
			}

			public float getAttackDamage() {
				return 8f;
			}

			public int getHarvestLevel() {
				return 2;
			}

			public int getEnchantability() {
				return 10;
			}

			public Ingredient getRepairMaterial() {
				return Ingredient.EMPTY;
			}
		}, 3, -0.8f, new Item.Properties().group(NegativeNCombatItemGroup.tab)) {
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
					$_dependencies.put("sourceentity", sourceentity);
					PoisonusProccedProcedure.executeProcedure($_dependencies);
				}
				return retval;
			}
		}.setRegistryName("cobblestone_n_sword"));
	}
}
