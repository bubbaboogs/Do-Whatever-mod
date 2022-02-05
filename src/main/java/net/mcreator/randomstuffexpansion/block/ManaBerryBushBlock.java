
package net.mcreator.randomstuffexpansion.block;

import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.FlowerBlock;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.core.Direction;
import net.minecraft.core.BlockPos;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.ItemBlockRenderTypes;

import net.mcreator.randomstuffexpansion.init.RandomStuffExpansionModItems;
import net.mcreator.randomstuffexpansion.init.RandomStuffExpansionModBlocks;

import java.util.List;
import java.util.Collections;

public class ManaBerryBushBlock extends FlowerBlock {
	public ManaBerryBushBlock() {
		super(MobEffects.NIGHT_VISION, 100, BlockBehaviour.Properties.of(Material.PLANT).noCollission().sound(SoundType.GRASS).instabreak());
		setRegistryName("mana_berry_bush");
	}

	@Override
	public int getEffectDuration() {
		return 100;
	}

	@Override
	public int getFireSpreadSpeed(BlockState state, BlockGetter world, BlockPos pos, Direction face) {
		return 60;
	}

	@Override
	public List<ItemStack> getDrops(BlockState state, LootContext.Builder builder) {
		List<ItemStack> dropsOriginal = super.getDrops(state, builder);
		if (!dropsOriginal.isEmpty())
			return dropsOriginal;
		return Collections.singletonList(new ItemStack(RandomStuffExpansionModItems.MANA_BERRY));
	}

	@OnlyIn(Dist.CLIENT)
	public static void registerRenderLayer() {
		ItemBlockRenderTypes.setRenderLayer(RandomStuffExpansionModBlocks.MANA_BERRY_BUSH, renderType -> renderType == RenderType.cutout());
	}
}
