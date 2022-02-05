package net.mcreator.randomstuffexpansion.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.common.MinecraftForge;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;

import net.mcreator.randomstuffexpansion.network.RandomStuffExpansionModVariables;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class ManaRegenProcedure {
	@SubscribeEvent
	public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
		if (event.phase == TickEvent.Phase.END) {
			Entity entity = event.player;
			execute(event, entity.level, entity);
		}
	}

	public static void execute(LevelAccessor world, Entity entity) {
		execute(null, world, entity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		if ((entity.getCapability(RandomStuffExpansionModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new RandomStuffExpansionModVariables.PlayerVariables())).Mana < (entity
						.getCapability(RandomStuffExpansionModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new RandomStuffExpansionModVariables.PlayerVariables())).MaxMana) {
			new Object() {
				private int ticks = 0;
				private float waitTicks;
				private LevelAccessor world;

				public void start(LevelAccessor world, int waitTicks) {
					this.waitTicks = waitTicks;
					MinecraftForge.EVENT_BUS.register(this);
					this.world = world;
				}

				@SubscribeEvent
				public void tick(TickEvent.ServerTickEvent event) {
					if (event.phase == TickEvent.Phase.END) {
						this.ticks += 1;
						if (this.ticks >= this.waitTicks)
							run();
					}
				}

				private void run() {
					{
						double _setval = (entity.getCapability(RandomStuffExpansionModVariables.PLAYER_VARIABLES_CAPABILITY, null)
								.orElse(new RandomStuffExpansionModVariables.PlayerVariables())).Mana + 1;
						entity.getCapability(RandomStuffExpansionModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.Mana = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					MinecraftForge.EVENT_BUS.unregister(this);
				}
			}.start(world, 1);
		}
	}
}
