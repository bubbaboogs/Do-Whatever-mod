
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.randomstuffexpansion.init;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.RegistryEvent;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.item.SpawnEggItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.BlockItem;

import net.mcreator.randomstuffexpansion.item.SacrificialKnifeItem;
import net.mcreator.randomstuffexpansion.item.MysticalSwordItem;
import net.mcreator.randomstuffexpansion.item.MysticalShovelItem;
import net.mcreator.randomstuffexpansion.item.MysticalPickaxeItem;
import net.mcreator.randomstuffexpansion.item.MysticalHoeItem;
import net.mcreator.randomstuffexpansion.item.MysticalAxeItem;
import net.mcreator.randomstuffexpansion.item.MysticalArmorItem;
import net.mcreator.randomstuffexpansion.item.MysticItem;
import net.mcreator.randomstuffexpansion.item.ManaBerryItem;
import net.mcreator.randomstuffexpansion.item.MagicItem;
import net.mcreator.randomstuffexpansion.item.DriedBloodItem;
import net.mcreator.randomstuffexpansion.item.DreamCatcherItem;
import net.mcreator.randomstuffexpansion.item.BloodWandItem;

import java.util.List;
import java.util.ArrayList;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class RandomStuffExpansionModItems {
	private static final List<Item> REGISTRY = new ArrayList<>();
	public static final Item MANA_BERRY = register(new ManaBerryItem());
	public static final Item MAGIC = register(new MagicItem());
	public static final Item MANA_BERRY_BUSH = register(RandomStuffExpansionModBlocks.MANA_BERRY_BUSH, CreativeModeTab.TAB_DECORATIONS);
	public static final Item BLOOD_WAND = register(new BloodWandItem());
	public static final Item DRIED_BLOOD = register(new DriedBloodItem());
	public static final Item SACRIFICIAL_KNIFE = register(new SacrificialKnifeItem());
	public static final Item SHADOW_GRASS = register(RandomStuffExpansionModBlocks.SHADOW_GRASS, CreativeModeTab.TAB_BUILDING_BLOCKS);
	public static final Item DARK_WOOD = register(RandomStuffExpansionModBlocks.DARK_WOOD, CreativeModeTab.TAB_BUILDING_BLOCKS);
	public static final Item DARK_LOG = register(RandomStuffExpansionModBlocks.DARK_LOG, CreativeModeTab.TAB_BUILDING_BLOCKS);
	public static final Item DARK_PLANKS = register(RandomStuffExpansionModBlocks.DARK_PLANKS, CreativeModeTab.TAB_BUILDING_BLOCKS);
	public static final Item DARK_LEAVES = register(RandomStuffExpansionModBlocks.DARK_LEAVES, CreativeModeTab.TAB_DECORATIONS);
	public static final Item DARK_STAIRS = register(RandomStuffExpansionModBlocks.DARK_STAIRS, CreativeModeTab.TAB_BUILDING_BLOCKS);
	public static final Item DARK_SLAB = register(RandomStuffExpansionModBlocks.DARK_SLAB, CreativeModeTab.TAB_BUILDING_BLOCKS);
	public static final Item DARK_FENCE = register(RandomStuffExpansionModBlocks.DARK_FENCE, CreativeModeTab.TAB_DECORATIONS);
	public static final Item DARK_FENCE_GATE = register(RandomStuffExpansionModBlocks.DARK_FENCE_GATE, CreativeModeTab.TAB_REDSTONE);
	public static final Item DARK_PRESSURE_PLATE = register(RandomStuffExpansionModBlocks.DARK_PRESSURE_PLATE, CreativeModeTab.TAB_REDSTONE);
	public static final Item DARK_BUTTON = register(RandomStuffExpansionModBlocks.DARK_BUTTON, CreativeModeTab.TAB_BUILDING_BLOCKS);
	public static final Item DREAM_CATCHER = register(new DreamCatcherItem());
	public static final Item SOUL_WARDEN = register(
			new SpawnEggItem(RandomStuffExpansionModEntities.SOUL_WARDEN, -16777216, -16711732, new Item.Properties().tab(CreativeModeTab.TAB_MISC))
					.setRegistryName("soul_warden_spawn_egg"));
	public static final Item MYSTIC = register(new MysticItem());
	public static final Item MYSTIC_ORE = register(RandomStuffExpansionModBlocks.MYSTIC_ORE, CreativeModeTab.TAB_BUILDING_BLOCKS);
	public static final Item MYSTIC_BLOCK = register(RandomStuffExpansionModBlocks.MYSTIC_BLOCK, CreativeModeTab.TAB_BUILDING_BLOCKS);
	public static final Item MYSTICAL_PICKAXE = register(new MysticalPickaxeItem());
	public static final Item MYSTICAL_AXE = register(new MysticalAxeItem());
	public static final Item MYSTICAL_SWORD = register(new MysticalSwordItem());
	public static final Item MYSTICAL_SHOVEL = register(new MysticalShovelItem());
	public static final Item MYSTICAL_HOE = register(new MysticalHoeItem());
	public static final Item SOUL_VINES = register(RandomStuffExpansionModBlocks.SOUL_VINES, CreativeModeTab.TAB_DECORATIONS);
	public static final Item MYSTICAL_ARMOR_HELMET = register(new MysticalArmorItem.Helmet());
	public static final Item MYSTICAL_ARMOR_CHESTPLATE = register(new MysticalArmorItem.Chestplate());
	public static final Item MYSTICAL_ARMOR_LEGGINGS = register(new MysticalArmorItem.Leggings());
	public static final Item MYSTICAL_ARMOR_BOOTS = register(new MysticalArmorItem.Boots());

	private static Item register(Item item) {
		REGISTRY.add(item);
		return item;
	}

	private static Item register(Block block, CreativeModeTab tab) {
		return register(new BlockItem(block, new Item.Properties().tab(tab)).setRegistryName(block.getRegistryName()));
	}

	@SubscribeEvent
	public static void registerItems(RegistryEvent.Register<Item> event) {
		event.getRegistry().registerAll(REGISTRY.toArray(new Item[0]));
	}
}
