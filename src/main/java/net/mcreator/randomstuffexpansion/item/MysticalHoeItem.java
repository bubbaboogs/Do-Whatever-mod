
package net.mcreator.randomstuffexpansion.item;

import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.HoeItem;
import net.minecraft.world.item.CreativeModeTab;

import net.mcreator.randomstuffexpansion.init.RandomStuffExpansionModItems;

public class MysticalHoeItem extends HoeItem {
	public MysticalHoeItem() {
		super(new Tier() {
			public int getUses() {
				return 1741;
			}

			public float getSpeed() {
				return 14f;
			}

			public float getAttackDamageBonus() {
				return 6f;
			}

			public int getLevel() {
				return 8;
			}

			public int getEnchantmentValue() {
				return 56;
			}

			public Ingredient getRepairIngredient() {
				return Ingredient.of(new ItemStack(RandomStuffExpansionModItems.MYSTIC));
			}
		}, 0, -3f, new Item.Properties().tab(CreativeModeTab.TAB_TOOLS));
		setRegistryName("mystical_hoe");
	}
}
