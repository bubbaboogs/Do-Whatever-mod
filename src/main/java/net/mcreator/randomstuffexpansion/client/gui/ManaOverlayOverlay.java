
package net.mcreator.randomstuffexpansion.client.gui;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.client.Minecraft;

import net.mcreator.randomstuffexpansion.network.RandomStuffExpansionModVariables;

@Mod.EventBusSubscriber({Dist.CLIENT})
public class ManaOverlayOverlay {
	@SubscribeEvent(priority = EventPriority.NORMAL)
	public static void eventHandler(RenderGameOverlayEvent.Pre event) {
		if (event.getType() == RenderGameOverlayEvent.ElementType.ALL) {
			int w = event.getWindow().getGuiScaledWidth();
			int h = event.getWindow().getGuiScaledHeight();
			int posX = w / 2;
			int posY = h / 2;
			Level _world = null;
			double _x = 0;
			double _y = 0;
			double _z = 0;
			Player entity = Minecraft.getInstance().player;
			if (entity != null) {
				_world = entity.level;
				_x = entity.getX();
				_y = entity.getY();
				_z = entity.getZ();
			}
			Level world = _world;
			double x = _x;
			double y = _y;
			double z = _z;
			if (true) {
				Minecraft.getInstance().font
						.draw(event.getMatrixStack(),
								"" + (int) ((entity.getCapability(RandomStuffExpansionModVariables.PLAYER_VARIABLES_CAPABILITY, null)
										.orElse(new RandomStuffExpansionModVariables.PlayerVariables())).Mana) + "",
								posX + -212, posY + 91, -16777012);
				Minecraft.getInstance().font
						.draw(event.getMatrixStack(),
								"" + (int) ((entity.getCapability(RandomStuffExpansionModVariables.PLAYER_VARIABLES_CAPABILITY, null)
										.orElse(new RandomStuffExpansionModVariables.PlayerVariables())).MaxMana) + "",
								posX + -213, posY + 104, -16776961);
				Minecraft.getInstance().font.draw(event.getMatrixStack(), "/", posX + -113, posY + 92, -16776961);
			}
		}
	}
}
