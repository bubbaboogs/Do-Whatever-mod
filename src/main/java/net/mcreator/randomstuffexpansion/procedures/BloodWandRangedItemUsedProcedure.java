package net.mcreator.randomstuffexpansion.procedures;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;

import net.mcreator.randomstuffexpansion.network.RandomStuffExpansionModVariables;
import net.mcreator.randomstuffexpansion.entity.BloodWandEntity;

import java.util.Random;

public class BloodWandRangedItemUsedProcedure {
	public static void execute(Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		if ((entity.getCapability(RandomStuffExpansionModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new RandomStuffExpansionModVariables.PlayerVariables())).Mana > 39) {
			{
				double _setval = (entity.getCapability(RandomStuffExpansionModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new RandomStuffExpansionModVariables.PlayerVariables())).Mana - 50;
				entity.getCapability(RandomStuffExpansionModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.Mana = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			if (entity instanceof LivingEntity _ent_sa && !_ent_sa.level.isClientSide()) {
				BloodWandEntity.shoot(_ent_sa.level, _ent_sa, _ent_sa.level.getRandom(), 2, 5, 5);
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
