
package net.killarexe.negativen.item;

@NegativeNModElements.ModElement.Tag
public class UTitleScreenItem extends NegativeNModElements.ModElement {

	@ObjectHolder("negative_n:easter_egg")
	public static final Item block = null;

	public UTitleScreenItem(NegativeNModElements instance) {
		super(instance, 415);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new MusicDiscItemCustom());
	}

	public static class MusicDiscItemCustom extends MusicDiscItem {

		public MusicDiscItemCustom() {
			super(0, NegativeNModElements.sounds.get(new ResourceLocation("negative_n:easter_egg")),
					new Item.Properties().group(null).maxStackSize(1).rarity(Rarity.RARE));
			setRegistryName("easter_egg");
		}

		@Override
		@OnlyIn(Dist.CLIENT)
		public boolean hasEffect(ItemStack itemstack) {
			return true;
		}

	}

}
