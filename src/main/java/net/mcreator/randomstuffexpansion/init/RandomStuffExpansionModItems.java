
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.randomstuffexpansion.init;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.RegistryEvent;

import net.minecraft.world.item.Item;

import net.mcreator.randomstuffexpansion.item.ManaBerryItem;
import net.mcreator.randomstuffexpansion.item.MagicItem;

import java.util.List;
import java.util.ArrayList;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class RandomStuffExpansionModItems {
	private static final List<Item> REGISTRY = new ArrayList<>();
	public static final Item MANA_BERRY = register(new ManaBerryItem());
	public static final Item MAGIC = register(new MagicItem());

	private static Item register(Item item) {
		REGISTRY.add(item);
		return item;
	}

	@SubscribeEvent
	public static void registerItems(RegistryEvent.Register<Item> event) {
		event.getRegistry().registerAll(REGISTRY.toArray(new Item[0]));
	}
}
