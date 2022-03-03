
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.randomstuffexpansion.init;

import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.level.block.Block;

import net.mcreator.randomstuffexpansion.block.ShadowGrassBlock;
import net.mcreator.randomstuffexpansion.block.ManaBerryBushBlock;
import net.mcreator.randomstuffexpansion.block.DarkWoodBlock;
import net.mcreator.randomstuffexpansion.block.DarkStairsBlock;
import net.mcreator.randomstuffexpansion.block.DarkSlabBlock;
import net.mcreator.randomstuffexpansion.block.DarkPressurePlateBlock;
import net.mcreator.randomstuffexpansion.block.DarkPlanksBlock;
import net.mcreator.randomstuffexpansion.block.DarkLogBlock;
import net.mcreator.randomstuffexpansion.block.DarkLeavesBlock;
import net.mcreator.randomstuffexpansion.block.DarkFenceGateBlock;
import net.mcreator.randomstuffexpansion.block.DarkFenceBlock;
import net.mcreator.randomstuffexpansion.block.DarkButtonBlock;

import java.util.List;
import java.util.ArrayList;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class RandomStuffExpansionModBlocks {
	private static final List<Block> REGISTRY = new ArrayList<>();
	public static final Block MANA_BERRY_BUSH = register(new ManaBerryBushBlock());
	public static final Block SHADOW_GRASS = register(new ShadowGrassBlock());
	public static final Block DARK_WOOD = register(new DarkWoodBlock());
	public static final Block DARK_LOG = register(new DarkLogBlock());
	public static final Block DARK_PLANKS = register(new DarkPlanksBlock());
	public static final Block DARK_LEAVES = register(new DarkLeavesBlock());
	public static final Block DARK_STAIRS = register(new DarkStairsBlock());
	public static final Block DARK_SLAB = register(new DarkSlabBlock());
	public static final Block DARK_FENCE = register(new DarkFenceBlock());
	public static final Block DARK_FENCE_GATE = register(new DarkFenceGateBlock());
	public static final Block DARK_PRESSURE_PLATE = register(new DarkPressurePlateBlock());
	public static final Block DARK_BUTTON = register(new DarkButtonBlock());

	private static Block register(Block block) {
		REGISTRY.add(block);
		return block;
	}

	@SubscribeEvent
	public static void registerBlocks(RegistryEvent.Register<Block> event) {
		event.getRegistry().registerAll(REGISTRY.toArray(new Block[0]));
	}

	@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
	public static class ClientSideHandler {
		@SubscribeEvent
		public static void clientSetup(FMLClientSetupEvent event) {
			ManaBerryBushBlock.registerRenderLayer();
		}
	}
}
