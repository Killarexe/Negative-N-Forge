/**
 * This mod element is always locked. Enter your code in the methods below.
 * If you don't need some of these methods, you can remove them as they
 * are overrides of the base class NegativenModElements.ModElement.
 *
 * You can register new events in this class too.
 *
 * As this class is loaded into mod element list, it NEEDS to extend
 * ModElement class. If you remove this extend statement or remove the
 * constructor, the compilation will fail.
 *
 * If you want to make a plain independent class, create it using
 * Project Browser - New... and make sure to make the class
 * outside net.killarexe.negativen as this package is managed by MCreator.
 *
 * If you change workspace package, modid or prefix, you will need
 * to manually adapt this file to these changes or remake it.
*/
package net.killarexe.negativen;

import mezz.jei.api.registration.*;
import mezz.jei.api.runtime.IJeiRuntime;
import net.killarexe.negativen.block.*;
import net.killarexe.negativen.item.*;
import mezz.jei.api.IModPlugin;
import mezz.jei.api.constants.VanillaTypes;
import mezz.jei.api.gui.IRecipeLayout;
import mezz.jei.api.gui.drawable.IDrawable;
import mezz.jei.api.gui.ingredient.IGuiItemStackGroup;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.helpers.IJeiHelpers;
import mezz.jei.api.ingredients.IIngredients;
import mezz.jei.api.recipe.category.IRecipeCategory;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.ResourceLocation;

import java.util.ArrayList;
import java.util.List;

@mezz.jei.api.JeiPlugin
@NegativenModElements.ModElement.Tag
public class JeiPlugin implements IModPlugin{

	public static IJeiHelpers jeiHelper;

	@Override
	public ResourceLocation getPluginUid(){
		return new ResourceLocation("negativen", "default");
	}

	@Override
	public void registerItemSubtypes(ISubtypeRegistration registration) {

	}

	@Override
	public void registerIngredients(IModIngredientRegistration registration) {

	}

	@Override
	public void registerCategories(IRecipeCategoryRegistration registration){
		
		jeiHelper = registration.getJeiHelpers();
		registration.addRecipeCategories(new FusonatorBlockJeiCategory(jeiHelper.getGuiHelper()));
	}

	@Override
	public void registerVanillaCategoryExtensions(IVanillaCategoryExtensionRegistration registration) {

	}

	@Override
	public void registerRecipes(IRecipeRegistration registration) {
		registration.addRecipes(generateFusonatorBlockRecipes(), FusonatorBlockJeiCategory.Uid);
	}

	private List<FusonatorBlockJeiCategory.FusonatorBlockRecipeWrapper> generateFusonatorBlockRecipes(){
		List<FusonatorBlockJeiCategory.FusonatorBlockRecipeWrapper> recipes = new ArrayList<>();
		ArrayList<ItemStack> inputs = new ArrayList<>();
		ArrayList<ItemStack> outputs = new ArrayList<>();
		inputs.add(new ItemStack(Items.TNT));
		outputs.add(new ItemStack(new NegativeDustItem.ItemCustom()));
		recipes.add(new FusonatorBlockJeiCategory.FusonatorBlockRecipeWrapper(inputs, outputs));
		return recipes;
	}

	@Override
	public void registerRecipeTransferHandlers(IRecipeTransferRegistration registration) {

	}

	@Override
	public void registerRecipeCatalysts(IRecipeCatalystRegistration registration) {

	}

	public static class FusonatorBlockJeiCategory implements IRecipeCategory<FusonatorBlockJeiCategory.FusonatorBlockRecipeWrapper>{

		private static ResourceLocation Uid = new ResourceLocation("negativen", "tnt_n_category");

		private static final int input1 = 0;
		private static final int input2 = 1;
		private static final int output1 = 2;

		private final String title;
		private final IDrawable background;
		public FusonatorBlockJeiCategory(IGuiHelper guiHelper){
			this.title = "Fusonator";
			this.background = guiHelper.createDrawable(new ResourceLocation("negativen", "textures/fusionator.png"), 0, 0, 256, 256);
		}

		@Override
		public ResourceLocation getUid() {
			return Uid;
		}

		@Override
		public Class<? extends FusonatorBlockRecipeWrapper> getRecipeClass() {
			return FusonatorBlockJeiCategory.FusonatorBlockRecipeWrapper.class;
		}

		@Override
		public String getTitle() {
			return title;
		}

		@Override
		public IDrawable getBackground() {
			return background;
		}

		@Override
		public IDrawable getIcon() {
			return null;
		}

		@Override
		public void setIngredients(FusonatorBlockRecipeWrapper fusonatorBlockRecipeWrapper, IIngredients iIngredients) {
			iIngredients.setInputs(VanillaTypes.ITEM, fusonatorBlockRecipeWrapper.getInput());
			iIngredients.setOutputs(VanillaTypes.ITEM, fusonatorBlockRecipeWrapper.getOutput());
		}

		@Override
		public void setRecipe(IRecipeLayout iRecipeLayout, FusonatorBlockRecipeWrapper fusonatorBlockRecipeWrapper, IIngredients iIngredients) {
			IGuiItemStackGroup stacks = iRecipeLayout.getItemStacks();
			stacks.init(input1, true, 37, 32);
			stacks.init(input2, true, 118, 28);
			stacks.set(input1, iIngredients.getInputs(VanillaTypes.ITEM).get(0));
			stacks.set(input2, iIngredients.getInputs(VanillaTypes.ITEM).get(1));

			stacks.init(output1, false, 60, 32);
			stacks.set(output1, iIngredients.getOutputs(VanillaTypes.ITEM).get(0));
		}

		public static class FusonatorBlockRecipeWrapper{
			private ArrayList input;
			private ArrayList output;

			public FusonatorBlockRecipeWrapper(ArrayList input, ArrayList output){
				this.input = input;
				this.output = output;
			}

			public ArrayList getInput() {
				return input;
			}

			public ArrayList getOutput() {
				return output;
			}
		}

		@Override
		public void draw(FusonatorBlockRecipeWrapper recipe, double mouseX, double mouseY) {
			FontRenderer fontRenderer = Minecraft.getInstance().fontRenderer;
			ItemStack recipeOutput = (ItemStack) recipe.output.get(0);
			System.out.println(recipeOutput.getItem() == Items.DIAMOND);
		}

		@Override
		public List<String> getTooltipStrings(FusonatorBlockRecipeWrapper recipe, double mouseX, double mouseY) {
			return null;
		}

		@Override
		public boolean handleClick(FusonatorBlockRecipeWrapper recipe, double mouseX, double mouseY, int mouseButton) {
			return false;
		}
	}

	@Override
	public void registerGuiHandlers(IGuiHandlerRegistration registration) {

	}

	@Override
	public void registerAdvanced(IAdvancedRegistration registration) {

	}

	@Override
	public void onRuntimeAvailable(IJeiRuntime jeiRuntime) {

	}

}