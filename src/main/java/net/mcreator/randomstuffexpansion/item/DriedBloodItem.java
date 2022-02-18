
package net.mcreator.randomstuffexpansion.item;

import net.minecraft.world.level.Level;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.entity.player.Player;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.network.chat.Component;

import net.mcreator.randomstuffexpansion.procedures.DriedBloodItemIsDroppedByPlayerProcedure;

import java.util.List;

public class DriedBloodItem extends Item {
	public DriedBloodItem() {
		super(new Item.Properties().tab(CreativeModeTab.TAB_MISC).stacksTo(64).rarity(Rarity.COMMON));
		setRegistryName("dried_blood");
	}

	@Override
	public int getUseDuration(ItemStack itemstack) {
		return 0;
	}

	@Override
	public void appendHoverText(ItemStack itemstack, Level world, List<Component> list, TooltipFlag flag) {
		super.appendHoverText(itemstack, world, list, flag);
		list.add(new TextComponent("Dried within seconds..."));
	}

	@Override
	public boolean onDroppedByPlayer(ItemStack itemstack, Player entity) {
		DriedBloodItemIsDroppedByPlayerProcedure.execute(entity.level, entity.getX(), entity.getY(), entity.getZ(), entity);
		return true;
	}
}
