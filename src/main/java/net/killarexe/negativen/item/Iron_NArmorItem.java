
package net.killarexe.negativen.item;

import net.minecraftforge.registries.ObjectHolder;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.util.ResourceLocation;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.ArmorItem;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.entity.Entity;

import net.killarexe.negativen.itemgroup.NegativeNCombatItemGroup;
import net.killarexe.negativen.NegativeNModElements;

@NegativeNModElements.ModElement.Tag
public class Iron_NArmorItem extends NegativeNModElements.ModElement {
	@ObjectHolder("negative_n:iron_n_helmet")
	public static final Item helmet = null;
	@ObjectHolder("negative_n:iron_n_chestplate")
	public static final Item body = null;
	@ObjectHolder("negative_n:iron_n_leggings")
	public static final Item legs = null;
	@ObjectHolder("negative_n:iron_n_boots")
	public static final Item boots = null;
	public Iron_NArmorItem(NegativeNModElements instance) {
		super(instance, 347);
	}

	@Override
	public void initElements() {
		IArmorMaterial armormaterial = new IArmorMaterial() {
			@Override
			public int getDurability(EquipmentSlotType slot) {
				return new int[]{13, 15, 16, 11}[slot.getIndex()] * 250;
			}

			@Override
			public int getDamageReductionAmount(EquipmentSlotType slot) {
				return new int[]{3, 7, 6, 3}[slot.getIndex()];
			}

			@Override
			public int getEnchantability() {
				return 14;
			}

			@Override
			public net.minecraft.util.SoundEvent getSoundEvent() {
				return (net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.wool.place"));
			}

			@Override
			public Ingredient getRepairMaterial() {
				return Ingredient.fromStacks(new ItemStack(Iron_NIngotItem.block, (int) (1)));
			}

			@OnlyIn(Dist.CLIENT)
			@Override
			public String getName() {
				return "iron_n";
			}

			@Override
			public float getToughness() {
				return 2f;
			}

			@Override
			public float getKnockbackResistance() {
				return 0f;
			}
		};
		elements.items.add(() -> new ArmorItem(armormaterial, EquipmentSlotType.HEAD, new Item.Properties().group(NegativeNCombatItemGroup.tab)) {
			@Override
			public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlotType slot, String type) {
				return "negative_n:textures/models/armor/iron_n__layer_" + (slot == EquipmentSlotType.LEGS ? "2" : "1") + ".png";
			}
		}.setRegistryName("iron_n_helmet"));
		elements.items.add(() -> new ArmorItem(armormaterial, EquipmentSlotType.CHEST, new Item.Properties().group(NegativeNCombatItemGroup.tab)) {
			@Override
			public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlotType slot, String type) {
				return "negative_n:textures/models/armor/iron_n__layer_" + (slot == EquipmentSlotType.LEGS ? "2" : "1") + ".png";
			}
		}.setRegistryName("iron_n_chestplate"));
		elements.items.add(() -> new ArmorItem(armormaterial, EquipmentSlotType.LEGS, new Item.Properties().group(NegativeNCombatItemGroup.tab)) {
			@Override
			public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlotType slot, String type) {
				return "negative_n:textures/models/armor/iron_n__layer_" + (slot == EquipmentSlotType.LEGS ? "2" : "1") + ".png";
			}
		}.setRegistryName("iron_n_leggings"));
		elements.items.add(() -> new ArmorItem(armormaterial, EquipmentSlotType.FEET, new Item.Properties().group(NegativeNCombatItemGroup.tab)) {
			@Override
			public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlotType slot, String type) {
				return "negative_n:textures/models/armor/iron_n__layer_" + (slot == EquipmentSlotType.LEGS ? "2" : "1") + ".png";
			}
		}.setRegistryName("iron_n_boots"));
	}
}
