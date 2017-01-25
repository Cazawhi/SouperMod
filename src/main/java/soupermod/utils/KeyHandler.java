package soupermod.utils;

import soupermod.SouperMod;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ChatComponentText;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.InputEvent.KeyInputEvent;

public class KeyHandler {
	
	@SubscribeEvent
	public void onKeyPressed(KeyInputEvent event) {
		if(SouperMod.keyBindingSoup.isKeyDown()) {
			Minecraft mc = Minecraft.getMinecraft();
			for(int index = 0; index < 9; index++) {
				ItemStack ele = mc.thePlayer.inventory.getStackInSlot(index);
				if(ele != null) {
					if(ele.getItem() == Items.mushroom_stew) {
						mc.thePlayer.inventory.currentItem = index;
					}
				}
			}
		}
	}
}