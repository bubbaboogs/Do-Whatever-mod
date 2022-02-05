package net.mcreator.randomstuffexpansion.procedures;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.projectile.Arrow;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;

import net.mcreator.randomstuffexpansion.network.RandomStuffExpansionModVariables;

import java.util.Random;

public class ManaUsageProcedure {
	public static void execute(Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		if ((entity.getCapability(RandomStuffExpansionModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new RandomStuffExpansionModVariables.PlayerVariables())).Mana > 19) {
			{
				double _setval = (entity.getCapability(RandomStuffExpansionModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new RandomStuffExpansionModVariables.PlayerVariables())).Mana - 25;
				entity.getCapability(RandomStuffExpansionModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.Mana = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			if (entity instanceof LivingEntity _ent_sa && !_ent_sa.level.isClientSide()) {
				Arrow entityToSpawn = new Arrow(_ent_sa.level, _ent_sa);
				entityToSpawn.shoot(entity.getLookAngle().x, entity.getLookAngle().y, entity.getLookAngle().z, 2, 0);
				entityToSpawn.setBaseDamage(5);
				entityToSpawn.setKnockback(5);
				_ent_sa.level.addFreshEntity(entityToSpawn);
			}
			{
				ItemStack _ist = itemstack;
				if (_ist.hurt(1, new Random(), null)) {
					_ist.shrink(1);
					_ist.setDamageValue(0);
				}
			}
		}
	}
}
