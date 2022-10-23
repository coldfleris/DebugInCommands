package gov.coldfleris.debugincommands;

import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/* Please note that keybinds are NOT implemented into this mod. This is intended to be used in conjunction with Wynncraft for 1.18.2, and feel free to use Wynntils (Project Artemis) to implement keybinds using the Register Keybinds feature. */

public class Main implements ModInitializer {

	public static final String MOD_ID = "debugincommands";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);



	@Override
	public void onInitialize() {
		ClientCommandRegistry.registerClientCommands();

	}
}
