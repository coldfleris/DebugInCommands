package gov.coldfleris.debugincommands;

import gov.coldfleris.debugincommands.commands.ToggleHitboxesCommand;
import net.fabricmc.fabric.api.registry.CommandRegistry;

@SuppressWarnings("deprecation")
public class ClientCommandRegistry {
    public static void registerClientCommands() {
        CommandRegistry.INSTANCE.register(false, ToggleHitboxesCommand::register);

    }
}
