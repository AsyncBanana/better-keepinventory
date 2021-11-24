package dev.asyncbanana.better_keepinventory.mixin;

import net.minecraft.entity.EntityType;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.world.GameRules;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(ServerPlayerEntity.class)
public abstract class ServerPlayerEntityMixin {
    @Redirect(method = "copyFrom", at = @At(value = "INVOKE", target = "net/minecraft/world/GameRules.getBoolean(Lnet/minecraft/world/GameRules$Key;)Z"))
    public boolean onCopyFrom(GameRules rules, GameRules.Key<GameRules.BooleanRule> key, ServerPlayerEntity oldPlayer) {
        return rules.getBoolean(key) && (oldPlayer.getAttacker() == null || oldPlayer.getAttacker().getType() != EntityType.PLAYER);
    }
}
