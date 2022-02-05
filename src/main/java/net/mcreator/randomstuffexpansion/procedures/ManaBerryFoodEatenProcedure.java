package net.mcreator.randomstuffexpansion.procedures;

import net.minecraft.world.entity.Entity;

import net.mcreator.randomstuffexpansion.network.RandomStuffExpansionModVariables;

public class ManaBerryFoodEatenProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		{
			double _setval = (entity.getCapability(RandomStuffExpansionModVariables.PLAYER_VARIABLES_CAPABILITY, null)
					.orElse(new RandomStuffExpansionModVariables.PlayerVariables())).MaxMana + 25;
			entity.getCapability(RandomStuffExpansionModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.MaxMana = _setval;
				capability.syncPlayerVariables(entity);
			});
		}
		{
			double _setval = (entity.getCapability(RandomStuffExpansionModVariables.PLAYER_VARIABLES_CAPABILITY, null)
					.orElse(new RandomStuffExpansionModVariables.PlayerVariables())).MaxMana + 1;
			entity.getCapability(RandomStuffExpansionModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.MaxMana = _setval;
				capability.syncPlayerVariables(entity);
			});
		}
	}
}
