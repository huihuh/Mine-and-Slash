package com.robertx22.mine_and_slash.a_libraries.neat_mob_overlay;

import static net.minecraftforge.fml.relauncher.Side.CLIENT;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.Stack;

import org.lwjgl.opengl.GL11;

import com.robertx22.mine_and_slash.config.ModConfig;
import com.robertx22.mine_and_slash.saveclasses.Unit;
import com.robertx22.mine_and_slash.saveclasses.effects.StatusEffectData;
import com.robertx22.mine_and_slash.uncommon.capability.EntityCap;
import com.robertx22.mine_and_slash.uncommon.capability.EntityCap.UnitData;
import com.robertx22.mine_and_slash.uncommon.datasaving.Load;

import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.WorldClient;
import net.minecraft.client.renderer.BufferBuilder;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.culling.Frustum;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityList;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextFormatting;
import net.minecraftforge.client.event.RenderWorldLastEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.ObfuscationReflectionHelper;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod.EventBusSubscriber(value = CLIENT)
public class HealthBarRenderer {

	Minecraft mc = Minecraft.getMinecraft();

	List<EntityLivingBase> renderedEntities = new ArrayList();

	@SubscribeEvent
	public void onRenderWorldLast(RenderWorldLastEvent event) {

		if ((!Minecraft.isGuiEnabled() || !ModConfig.Client.RENDER_MOB_HEALTH_GUI))
			return;

		Entity cameraEntity = mc.getRenderViewEntity();

		BlockPos renderingVector = cameraEntity.getPosition();
		Frustum frustum = new Frustum();

		float partialTicks = event.getPartialTicks();
		double viewX = cameraEntity.lastTickPosX + (cameraEntity.posX - cameraEntity.lastTickPosX) * partialTicks;
		double viewY = cameraEntity.lastTickPosY + (cameraEntity.posY - cameraEntity.lastTickPosY) * partialTicks;
		double viewZ = cameraEntity.lastTickPosZ + (cameraEntity.posZ - cameraEntity.lastTickPosZ) * partialTicks;
		frustum.setPosition(viewX, viewY, viewZ);

		if (NeatConfig.showOnlyFocused) {
			Entity focused = HealthBarUtils.getEntityLookedAt(mc.player);
			if (focused != null && focused.hasCapability(EntityCap.Data, null) && focused.isEntityAlive())
				try {
					renderHealthBar((EntityLiving) focused, partialTicks, cameraEntity);
				} catch (Exception e) {
					e.printStackTrace();
				}
		} else {
			WorldClient client = mc.world;
			Set<Entity> entities = ObfuscationReflectionHelper.getPrivateValue(WorldClient.class, client,
					new String[] { "entityList", "field_73032_d", "J" });
			for (Entity entity : entities)
				if (entity != null && entity instanceof EntityLivingBase && entity != mc.player
						&& entity.isInRangeToRender3d(renderingVector.getX(), renderingVector.getY(),
								renderingVector.getZ())
						&& (entity.ignoreFrustumCheck || frustum.isBoundingBoxInFrustum(entity.getEntityBoundingBox()))
						&& entity.isEntityAlive() && entity.getRecursivePassengers().isEmpty())
					renderHealthBar((EntityLiving) entity, partialTicks, cameraEntity);
		}
	}

	public void renderHealthBar(EntityLiving passedEntity, float partialTicks, Entity viewPoint) {
		Stack<EntityLivingBase> ridingStack = new Stack();

		EntityLivingBase entity = passedEntity;
		ridingStack.push(entity);

		// UNIT LOADING
		UnitData data = Load.Unit(entity);
		if (data == null) {
			return;
		}

		Unit unit = data.getUnit();
		if (unit == null) {
			return;
		}
		// UNIT LOADING

		while (entity.getRidingEntity() != null && entity.getRidingEntity() instanceof EntityLivingBase) {
			entity = (EntityLivingBase) entity.getRidingEntity();
			ridingStack.push(entity);
		}

		float pastTranslate = 0F;
		while (!ridingStack.isEmpty()) {
			entity = ridingStack.pop();
			boolean boss = !entity.isNonBoss();

			String entityID = EntityList.getEntityString(entity);

			processing: {
				float distance = passedEntity.getDistance(viewPoint);
				if (distance > 50 || !passedEntity.canEntityBeSeen(viewPoint) || entity.isInvisible())
					break processing;

				double x = passedEntity.lastTickPosX + (passedEntity.posX - passedEntity.lastTickPosX) * partialTicks;
				double y = passedEntity.lastTickPosY + (passedEntity.posY - passedEntity.lastTickPosY) * partialTicks;
				double z = passedEntity.lastTickPosZ + (passedEntity.posZ - passedEntity.lastTickPosZ) * partialTicks;

				float scale = 0.026666672F;

				if (unit == null || unit.healthData() == null) {
					return;
				}
				float maxHealth = unit.healthData().Value;
				float health = unit.health().CurrentValue(entity, unit);

				if (maxHealth <= 0)
					break processing;

				float percent = (int) ((health / maxHealth) * 100F);
				RenderManager renderManager = Minecraft.getMinecraft().getRenderManager();

				GlStateManager.pushMatrix();
				GlStateManager.translate((float) (x - renderManager.viewerPosX),
						(float) (y - renderManager.viewerPosY + passedEntity.height + NeatConfig.heightAbove),
						(float) (z - renderManager.viewerPosZ));
				GL11.glNormal3f(0.0F, 1.0F, 0.0F);
				GlStateManager.rotate(-renderManager.playerViewY, 0.0F, 1.0F, 0.0F);
				GlStateManager.rotate(renderManager.playerViewX, 1.0F, 0.0F, 0.0F);
				GlStateManager.scale(-scale, -scale, scale);
				boolean lighting = GL11.glGetBoolean(GL11.GL_LIGHTING);
				GlStateManager.disableLighting();
				GlStateManager.depthMask(false);
				GlStateManager.disableDepth();
				GlStateManager.disableTexture2D();
				GlStateManager.enableBlend();
				GlStateManager.blendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
				Tessellator tessellator = Tessellator.getInstance();
				BufferBuilder buffer = tessellator.getBuffer();

				float padding = NeatConfig.backgroundPadding;
				int bgHeight = NeatConfig.backgroundHeight;
				int barHeight = NeatConfig.barHeight;
				float size = NeatConfig.plateSize;

				int r = 0;
				int g = 255;
				int b = 0;

				if (data.getRarity() > 4) {
					size = NeatConfig.plateSizeBoss;
					r = 128;
					g = 0;
					b = 128;
				}

				boolean useHue = !NeatConfig.colorByType;
				if (useHue) {
					float hue = Math.max(0F, (health / maxHealth) / 3F - 0.07F);
					Color color = Color.getHSBColor(hue, 1F, 1F);
					r = color.getRed();
					g = color.getGreen();
					b = color.getBlue();
				}

				GlStateManager.translate(0F, pastTranslate, 0F);

				float s = 0.5F;
				String name = I18n.format(data.getName(entity));

				float namel = mc.fontRenderer.getStringWidth(name) * s;
				if (namel + 20 > size * 2)
					size = namel / 2F + 10F;
				float healthSize = size * (health / maxHealth);

				// Background
				if (NeatConfig.drawBackground) {
					buffer.begin(7, DefaultVertexFormats.POSITION_COLOR);
					buffer.pos(-size - padding, -bgHeight, 0.0D).color(0, 0, 0, 64).endVertex();
					buffer.pos(-size - padding, barHeight + padding, 0.0D).color(0, 0, 0, 64).endVertex();
					buffer.pos(size + padding, barHeight + padding, 0.0D).color(0, 0, 0, 64).endVertex();
					buffer.pos(size + padding, -bgHeight, 0.0D).color(0, 0, 0, 64).endVertex();
					tessellator.draw();
				}

				// Gray Space
				buffer.begin(7, DefaultVertexFormats.POSITION_COLOR);
				buffer.pos(-size, 0, 0.0D).color(127, 127, 127, 127).endVertex();
				buffer.pos(-size, barHeight, 0.0D).color(127, 127, 127, 127).endVertex();
				buffer.pos(size, barHeight, 0.0D).color(127, 127, 127, 127).endVertex();
				buffer.pos(size, 0, 0.0D).color(127, 127, 127, 127).endVertex();
				tessellator.draw();

				// Health Bar
				buffer.begin(7, DefaultVertexFormats.POSITION_COLOR);
				buffer.pos(-size, 0, 0.0D).color(r, g, b, 127).endVertex();
				buffer.pos(-size, barHeight, 0.0D).color(r, g, b, 127).endVertex();
				buffer.pos(healthSize * 2 - size, barHeight, 0.0D).color(r, g, b, 127).endVertex();
				buffer.pos(healthSize * 2 - size, 0, 0.0D).color(r, g, b, 127).endVertex();
				tessellator.draw();

				GlStateManager.enableTexture2D();

				GlStateManager.pushMatrix();
				GlStateManager.translate(-size, -4.5F, 0F);
				GlStateManager.scale(s, s, s);
				mc.fontRenderer.drawString(name, 0, 0, 0xFFFFFF);

				GlStateManager.pushMatrix();
				float s1 = 0.75F;
				GlStateManager.scale(s1, s1, s1);

				int h = NeatConfig.hpTextHeight;
				String maxHpStr = TextFormatting.BOLD + "" + Math.round(maxHealth * 100.0) / 100.0;
				String hpStr = "" + Math.round(health * 100.0) / 100.0;
				String percStr = (int) percent + "%";

				if (maxHpStr.endsWith(".0"))
					maxHpStr = maxHpStr.substring(0, maxHpStr.length() - 2);
				if (hpStr.endsWith(".0"))
					hpStr = hpStr.substring(0, hpStr.length() - 2);

				if (NeatConfig.showCurrentHP)
					mc.fontRenderer.drawString(hpStr, 2, h, 0xFFFFFF);
				if (NeatConfig.showMaxHP)
					mc.fontRenderer.drawString(maxHpStr,
							(int) (size / (s * s1) * 2) - 2 - mc.fontRenderer.getStringWidth(maxHpStr), h, 0xFFFFFF);
				if (NeatConfig.showPercentage)
					mc.fontRenderer.drawString(percStr,
							(int) (size / (s * s1)) - mc.fontRenderer.getStringWidth(percStr) / 2, h, 0xFFFFFFFF);
				if (NeatConfig.enableDebugInfo && mc.gameSettings.showDebugInfo)
					mc.fontRenderer.drawString("ID: \"" + entityID + "\"", 0, h + 16, 0xFFFFFFFF);
				GlStateManager.popMatrix();

				GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
				int off = 0;

				s1 = 0.5F;
				GlStateManager.scale(s1, s1, s1);
				GlStateManager.translate(size / (s * s1) * 2 - 16, 0F, 0F);
				mc.renderEngine.bindTexture(TextureMap.LOCATION_BLOCKS_TEXTURE);

				for (StatusEffectData statusdata : unit.statusEffects.values()) {
					HealthBarUtils.renderIcon(off, 0, new ItemStack(statusdata.GetEffect().ItemModel()), 16, 16);
					off -= 16;
				}

				GlStateManager.popMatrix();

				GlStateManager.disableBlend();
				GlStateManager.enableDepth();
				GlStateManager.depthMask(true);
				if (lighting)
					GlStateManager.enableLighting();
				GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
				GlStateManager.popMatrix();

				pastTranslate -= bgHeight + barHeight + padding;
			}
		}
	}

}