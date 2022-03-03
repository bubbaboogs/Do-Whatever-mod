package net.mcreator.randomstuffexpansion.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.layers.EyesLayer;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.RenderType;

import net.mcreator.randomstuffexpansion.entity.SoulWardenEntity;
import net.mcreator.randomstuffexpansion.client.model.Modelcustom_model;

public class SoulWardenRenderer extends MobRenderer<SoulWardenEntity, Modelcustom_model<SoulWardenEntity>> {
	public SoulWardenRenderer(EntityRendererProvider.Context context) {
		super(context, new Modelcustom_model(context.bakeLayer(Modelcustom_model.LAYER_LOCATION)), 0.5f);
		this.addLayer(new EyesLayer<SoulWardenEntity, Modelcustom_model<SoulWardenEntity>>(this) {
			@Override
			public RenderType renderType() {
				return RenderType.eyes(new ResourceLocation("random_stuff_expansion:textures/soul_warden.png"));
			}
		});
	}

	@Override
	public ResourceLocation getTextureLocation(SoulWardenEntity entity) {
		return new ResourceLocation("random_stuff_expansion:textures/soul_warden.png");
	}
}
