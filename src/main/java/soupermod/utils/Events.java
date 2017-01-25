package soupermod.utils;

import soupermod.SouperMod;
import net.minecraft.client.Minecraft;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.client.event.RenderGameOverlayEvent.ElementType;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.InputEvent.KeyInputEvent;


public class Events {
	
	/* Overlay-Slots */
	@SubscribeEvent
	public void onRenderGameOverlay (RenderGameOverlayEvent event) {
		if(!event.isCancelable() && event.type == ElementType.EXPERIENCE) {
			Minecraft mc = Minecraft.getMinecraft();
			ItemStack Soup = new ItemStack(Items.mushroom_stew);
			ItemStack Bowl = new ItemStack(Items.bowl);
			if(!mc.thePlayer.capabilities.isCreativeMode && mc.thePlayer.inventory.hasItemStack(Soup)) {
				
				/* Rahmen */
				mc.renderEngine.bindTexture(new ResourceLocation("soupermod:textures/gui/soupermod_icons.png"));
				int posX_rahmen = event.resolution.getScaledWidth() / 2 + 100;
				int posY_rahmen = event.resolution.getScaledHeight() -20;
				mc.ingameGUI.drawTexturedModalRect(posX_rahmen, posY_rahmen, 0, 0, 77, 37);
				
				/* Zahlen */
				
				/* Soups */
				int Suppenzahl = 0;
				for(int index = 0; index < 9; index++) {
					ItemStack ele = mc.thePlayer.inventory.getStackInSlot(index);
					if(ele != null) {
						if(ele.getItem() == Items.mushroom_stew) {
							Suppenzahl++;
						}
					}
				}
				mc.renderEngine.bindTexture(new ResourceLocation("soupermod:textures/gui/" + Suppenzahl + ".png"));
				mc.ingameGUI.drawTexturedModalRect(posX_rahmen + 5, posY_rahmen - 3, 0, 0, 77, 37);
				
				/* Bowls */
				int Schusselzahl = 0;
				for(int zahl = 0; zahl < 9; zahl++) {
					ItemStack ele2 = mc.thePlayer.inventory.getStackInSlot(zahl);
					if(ele2 != null) {
						if(ele2.getItem() == Items.bowl) {
							Schusselzahl++;
						}
					} 
				}

				mc.renderEngine.bindTexture(new ResourceLocation("soupermod:textures/gui/" + Schusselzahl + ".png"));
				mc.ingameGUI.drawTexturedModalRect(posX_rahmen + 25, posY_rahmen - 3, 0, 0, 77, 37); 
			}
		}
	}	
} 
