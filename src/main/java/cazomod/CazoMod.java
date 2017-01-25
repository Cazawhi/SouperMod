package cazomod;

import org.lwjgl.input.Keyboard;

import cazomod.utils.Events;
import cazomod.utils.KeyHandler;
import net.minecraft.client.Minecraft;
import net.minecraft.client.settings.KeyBinding;
import net.minecraft.util.EnumChatFormatting;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.ModMetadata;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

@Mod(modid = CazoMod.MODID)
public class CazoMod {
	public static final String MODID = "cazomod";
	
	@Instance
	public static CazoMod instance;
	
	/* Key-Bindings */
	public static KeyBinding keyBindingSoup = new KeyBinding("SouperSlot", Keyboard.KEY_R, "SouperMod");
	
	@EventHandler
	public void preInit (FMLPreInitializationEvent event) {
		
		/* Mod-Info */
		ModMetadata data = event.getModMetadata();
		data.autogenerated = false;
		data.name = EnumChatFormatting.BOLD + "" + EnumChatFormatting.GOLD + "Der S(o)uperMod";
		data.description = EnumChatFormatting.DARK_PURPLE + "Der SouperMod ist ein Mod, der das " + EnumChatFormatting.BOLD + "Soupen " + EnumChatFormatting.RESET + EnumChatFormatting.DARK_PURPLE + "grundlegend vereinfacht.";
		data.credits = EnumChatFormatting.AQUA + "Cazawhi";
		data.logoFile = "assets/cazomod/textures/logo/soupermod.png";
		data.url = "https://github.com/cazawhi/cazagit/";
		
	}
	
	@EventHandler
	public void Init (FMLInitializationEvent event) {
		
		/*Welcome-Message */
		System.out.println("Starting SouperMod...");
		
		/* Event-Registry */
		MinecraftForge.EVENT_BUS.register(new Events());
		
		/* Key-Binding-Registry */
		ClientRegistry.registerKeyBinding(keyBindingSoup);
		FMLCommonHandler.instance().bus().register(new KeyHandler());
	}
	
	@EventHandler
	public void PostInit (FMLPostInitializationEvent event) {
		
	}
}