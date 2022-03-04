package net.mcreator.randomstuffexpansion.procedures;

import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.common.MinecraftForge;

import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.core.BlockPos;

import net.mcreator.randomstuffexpansion.init.RandomStuffExpansionModBlocks;

public class SoulVinesUpdateTickProcedure {
	public static void execute(LevelAccessor world, double x, double z) {
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
				if ((world.getBlockState(new BlockPos((int) x, (int) (-1), (int) z))).getBlock() == Blocks.AIR) {
					{
						BlockPos _bp = new BlockPos((int) x, (int) (-1), (int) z);
						BlockState _bs = RandomStuffExpansionModBlocks.SOUL_VINES.defaultBlockState();
						world.setBlock(_bp, _bs, 3);
					}
				}
				MinecraftForge.EVENT_BUS.unregister(this);
			}
		}.start(world, 1200);
	}
}
