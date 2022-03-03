package net.mcreator.randomstuffexpansion.client.model;

import net.minecraft.world.entity.Entity;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.EntityModel;

import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.blaze3d.vertex.PoseStack;

// Made with Blockbench 4.1.5
// Exported for Minecraft version 1.17 with Mojang mappings
// Paste this class into your mod and generate all required imports
public class Modelcustom_model<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in
	// the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(
			new ResourceLocation("random_stuff_expansion", "modelcustom_model"), "main");
	public final ModelPart bone;
	public final ModelPart Arms;
	public final ModelPart Ear1;
	public final ModelPart Ear2;
	public final ModelPart Legs;
	public final ModelPart bb_main;

	public Modelcustom_model(ModelPart root) {
		this.bone = root.getChild("bone");
		this.Arms = root.getChild("Arms");
		this.Ear1 = root.getChild("Ear1");
		this.Ear2 = root.getChild("Ear2");
		this.Legs = root.getChild("Legs");
		this.bb_main = root.getChild("bb_main");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();
		PartDefinition bone = partdefinition.addOrReplaceChild("bone",
				CubeListBuilder.create().texOffs(0, 26).addBox(-1.0F, -13.0F, -1.0F, 2.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)).texOffs(18, 7)
						.addBox(1.0F, -13.0F, -1.0F, 3.0F, 4.0F, 3.0F, new CubeDeformation(0.0F)).texOffs(22, 0)
						.addBox(-4.0F, -13.0F, -1.0F, 3.0F, 4.0F, 3.0F, new CubeDeformation(0.0F)).texOffs(0, 0)
						.addBox(-4.0F, -9.0F, -1.0F, 8.0F, 4.0F, 3.0F, new CubeDeformation(0.0F)),
				PartPose.offset(0.0F, 24.0F, 0.0F));
		PartDefinition Arms = partdefinition.addOrReplaceChild(
				"Arms", CubeListBuilder.create().texOffs(12, 15).addBox(4.0F, -13.0F, -1.0F, 3.0F, 8.0F, 3.0F, new CubeDeformation(0.0F))
						.texOffs(0, 15).addBox(-7.0F, -13.0F, -1.0F, 3.0F, 8.0F, 3.0F, new CubeDeformation(0.0F)),
				PartPose.offset(0.0F, 24.0F, 0.0F));
		PartDefinition Ear1 = partdefinition
				.addOrReplaceChild("Ear1",
						CubeListBuilder.create().texOffs(21, 14).addBox(-6.0F, -18.0F, 0.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
								.texOffs(9, 15).addBox(-5.0F, -17.0F, 0.0F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)),
						PartPose.offset(0.0F, 24.0F, 0.0F));
		PartDefinition Ear2 = partdefinition
				.addOrReplaceChild(
						"Ear2", CubeListBuilder.create().texOffs(15, 7).addBox(3.0F, -17.0F, 0.0F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
								.texOffs(19, 0).addBox(5.0F, -18.0F, 0.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)),
						PartPose.offset(0.0F, 24.0F, 0.0F));
		PartDefinition Legs = partdefinition.addOrReplaceChild(
				"Legs", CubeListBuilder.create().texOffs(24, 14).addBox(1.0F, -5.0F, -1.0F, 3.0F, 5.0F, 2.0F, new CubeDeformation(0.0F))
						.texOffs(24, 21).addBox(-4.0F, -5.0F, -1.0F, 3.0F, 5.0F, 2.0F, new CubeDeformation(0.0F)),
				PartPose.offset(0.0F, 24.0F, 0.0F));
		PartDefinition bb_main = partdefinition
				.addOrReplaceChild("bb_main",
						CubeListBuilder.create().texOffs(10, 26).addBox(-1.0F, -11.0F, -1.0F, 2.0F, 2.0F, 3.0F, new CubeDeformation(0.0F))
								.texOffs(0, 7).addBox(-3.0F, -18.0F, -1.0F, 6.0F, 5.0F, 3.0F, new CubeDeformation(0.0F)),
						PartPose.offset(0.0F, 24.0F, 0.0F));
		return LayerDefinition.create(meshdefinition, 64, 64);
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer buffer, int packedLight, int packedOverlay, float red, float green, float blue,
			float alpha) {
		bone.render(poseStack, buffer, packedLight, packedOverlay);
		Arms.render(poseStack, buffer, packedLight, packedOverlay);
		Ear1.render(poseStack, buffer, packedLight, packedOverlay);
		Ear2.render(poseStack, buffer, packedLight, packedOverlay);
		Legs.render(poseStack, buffer, packedLight, packedOverlay);
		bb_main.render(poseStack, buffer, packedLight, packedOverlay);
	}
}
