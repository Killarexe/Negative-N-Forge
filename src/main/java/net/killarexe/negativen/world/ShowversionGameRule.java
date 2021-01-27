package net.killarexe.negativen.world;

import net.minecraftforge.fml.common.ObfuscationReflectionHelper;

import net.minecraft.world.GameRules;

import net.killarexe.negativen.NegativenModElements;

import java.lang.reflect.Method;

@NegativenModElements.ModElement.Tag
public class ShowversionGameRule extends NegativenModElements.ModElement {
	public static final GameRules.RuleKey<GameRules.BooleanValue> gamerule = GameRules.register("showversion", GameRules.Category.PLAYER,
			create(false));
	public ShowversionGameRule(NegativenModElements instance) {
		super(instance, 958);
	}

	public static GameRules.RuleType<GameRules.BooleanValue> create(boolean defaultValue) {
		try {
			Method createGameruleMethod = ObfuscationReflectionHelper.findMethod(GameRules.BooleanValue.class, "func_223568_b", boolean.class);
			createGameruleMethod.setAccessible(true);
			return (GameRules.RuleType<GameRules.BooleanValue>) createGameruleMethod.invoke(null, defaultValue);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
