package dev.asyncbanana.better_keepinventory.mixin;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.world.GameRules;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

import dev.asyncbanana.better_keepinventory.BetterKeepinventory;

@Mixin(PlayerEntity.class)
public abstract class PlayerEntityMixin {
	@Redirect(method = "dropInventory", at = @At(value = "INVOKE", target = "net/minecraft/world/GameRules.getBoolean(Lnet/minecraft/world/GameRules$Key;)Z"))
	public boolean checkPlayerKillInventory(GameRules rules, GameRules.Key<GameRules.BooleanRule> key) {
		if (rules.getBoolean(BetterKeepinventory.BETTER_KEEPINVENTORY)) {
			return (((PlayerEntity) (Object) this).getAttacker() == null
					|| ((PlayerEntity) (Object) this).getAttacker().getType() != EntityType.ZOMBIE);
		}
		return rules.getBoolean(key);
	}

	@Redirect(method = "getXpToDrop", at = @At(value = "INVOKE", target = "net/minecraft/world/GameRules.getBoolean(Lnet/minecraft/world/GameRules$Key;)Z"))
	public boolean checkPlayerKillXP(GameRules rules, GameRules.Key<GameRules.BooleanRule> key) {
		if (rules.getBoolean(BetterKeepinventory.BETTER_KEEPINVENTORY)) {
			return (((PlayerEntity) (Object) this).getAttacker() == null
					|| ((PlayerEntity) (Object) this).getAttacker().getType() != EntityType.ZOMBIE);
		}
		return rules.getBoolean(key);
	}
}
