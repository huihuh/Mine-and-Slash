package com.robertx22.blocks.gear_factory_station;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import com.robertx22.mmorpg.Ref;
import com.robertx22.uncommon.CLOC;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class GuiGearFactory extends GuiContainer {

    // This is the resource location for the background image
    private static final ResourceLocation texture = new ResourceLocation(Ref.MODID,
	    "textures/gui/gear_factory_station.png");
    private TileGearFactory tileEntity;

    public GuiGearFactory(InventoryPlayer invPlayer, TileGearFactory tileInventoryFurnace) {
	super(new ContainerGearFactory(invPlayer, tileInventoryFurnace));

	// Set the width and height of the gui
	xSize = 176;
	ySize = 207;

	this.tileEntity = tileInventoryFurnace;
    }

    // some [x,y] coordinates of graphical elements
    final int COOK_BAR_XPOS = 49;
    final int COOK_BAR_YPOS = 60;
    final int COOK_BAR_ICON_U = 0; // texture position of white arrow icon
    final int COOK_BAR_ICON_V = 207;
    final int COOK_BAR_WIDTH = 80;
    final int COOK_BAR_HEIGHT = 17;

    final int FLAME_XPOS = 81;// 54;
    final int FLAME_YPOS = 80;
    final int FLAME_ICON_U = 176; // texture position of flame icon
    final int FLAME_ICON_V = 0;
    final int FLAME_WIDTH = 14;
    final int FLAME_HEIGHT = 14;
    final int FLAME_X_SPACING = 18;

    public void drawScreen(int mouseX, int mouseY, float partialTicks) {
	super.drawScreen(mouseX, mouseY, partialTicks);
	super.renderHoveredToolTip(mouseX, mouseY);
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(float partialTicks, int x, int y) {

	// Bind the image texture
	Minecraft.getMinecraft().getTextureManager().bindTexture(texture);
	// Draw the image
	GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
	drawTexturedModalRect(guiLeft, guiTop, 0, 0, xSize, ySize);

	// get cook progress as a double between 0 and 1
	double cookProgress = tileEntity.fractionOfCookTimeComplete();
	// draw the cook progress bar
	drawTexturedModalRect(guiLeft + COOK_BAR_XPOS, guiTop + COOK_BAR_YPOS, COOK_BAR_ICON_U, COOK_BAR_ICON_V,
		(int) (cookProgress * COOK_BAR_WIDTH), COOK_BAR_HEIGHT);

	// draw the fuel remaining bar for each fuel slot flame
	for (int i = 0; i < tileEntity.FUEL_SLOTS_COUNT; ++i) {
	    double burnRemaining = tileEntity.fractionOfFuelRemaining(i);
	    int yOffset = (int) ((1.0 - burnRemaining) * FLAME_HEIGHT);
	    drawTexturedModalRect(guiLeft + FLAME_XPOS + FLAME_X_SPACING * i, guiTop + FLAME_YPOS + yOffset,
		    FLAME_ICON_U, FLAME_ICON_V + yOffset, FLAME_WIDTH, FLAME_HEIGHT - yOffset);
	}

	// renderHoveredToolTip(x, y);

    }

    @Override
    protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY) {
	super.drawGuiContainerForegroundLayer(mouseX, mouseY);

	final int LABEL_XPOS = 5;
	final int LABEL_YPOS = 5;
	fontRenderer.drawString(tileEntity.getDisplayName().getUnformattedText(), LABEL_XPOS, LABEL_YPOS,
		Color.darkGray.getRGB());

	List<String> hoveringText = new ArrayList<String>();

	// If the mouse is over the progress bar add the progress bar hovering text
	if (isInRect(guiLeft + COOK_BAR_XPOS, guiTop + COOK_BAR_YPOS, COOK_BAR_WIDTH, COOK_BAR_HEIGHT, mouseX,
		mouseY)) {
	    hoveringText.add(CLOC.word("progress") + ": ");
	    int cookPercentage = (int) (tileEntity.fractionOfCookTimeComplete() * 100);
	    hoveringText.add(cookPercentage + "%");
	}

	// If the mouse is over one of the burn time indicator add the burn time
	// indicator hovering text
	for (int i = 0; i < tileEntity.FUEL_SLOTS_COUNT; ++i) {
	    if (isInRect(guiLeft + FLAME_XPOS + FLAME_X_SPACING * i, guiTop + FLAME_YPOS, FLAME_WIDTH, FLAME_HEIGHT,
		    mouseX, mouseY)) {
		// hoveringText.add("Fuel Time:");
		hoveringText.add(CLOC.word("fuel") + ": " + tileEntity.secondsOfFuelRemaining(i));
	    }
	}
	// If hoveringText is not empty draw the hovering text
	if (!hoveringText.isEmpty()) {
	    drawHoveringText(hoveringText, mouseX - guiLeft, mouseY - guiTop, fontRenderer);
	}

    }

    // Returns true if the given x,y coordinates are within the given rectangle
    public static boolean isInRect(int x, int y, int xSize, int ySize, int mouseX, int mouseY) {
	return ((mouseX >= x && mouseX <= x + xSize) && (mouseY >= y && mouseY <= y + ySize));
    }
}