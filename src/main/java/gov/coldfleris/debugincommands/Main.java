package gov.coldfleris.debugincommands;

import net.fabricmc.api.ModInitializer;

/* Please note that keybinds are NOT implemented into this mod. This is intended to be used in conjunction with Wynncraft for 1.18.2, and feel free to use Wynntils (Project Artemis) to implement keybinds using the Register Keybinds feature. */

public class Main implements ModInitializer {


	@Override
	public void onInitialize() {
		ClientCommandRegistry.registerClientCommands();

	}
}
