package dev.asyncbanana.better_keepinventory;

import net.fabricmc.api.ModInitializer;

import net.minecraft.world.GameRules;
import net.minecraft.world.GameRules.Category;

import net.fabricmc.fabric.api.gamerule.v1.GameRuleFactory;
import net.fabricmc.fabric.api.gamerule.v1.GameRuleRegistry;

public class BetterKeepinventory implements ModInitializer {
    public static final GameRules.Key<GameRules.BooleanRule> BETTER_KEEPINVENTORY = GameRuleRegistry
            .register("betterKeepInventory", Category.MISC, GameRuleFactory.createBooleanRule(true));

    @Override
    public void onInitialize() {
    }
}
