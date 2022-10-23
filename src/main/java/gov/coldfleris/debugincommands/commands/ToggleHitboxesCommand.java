package gov.coldfleris.debugincommands.commands;

import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.context.CommandContext;
import net.minecraft.client.MinecraftClient;
import net.minecraft.server.command.ServerCommandSource;

import static net.minecraft.server.command.CommandManager.literal;

@SuppressWarnings("ALL")
public class ToggleHitboxesCommand {

    private static MinecraftClient mc = null;

    public ToggleHitboxesCommand() {

    }


    public static void register(CommandDispatcher<ServerCommandSource> dispatcher) {
        dispatcher.register(literal("togglehitboxes")
                .executes(ToggleHitboxesCommand::toggleTheHitboxes)
        );

    }

    public static int toggleTheHitboxes(CommandContext<ServerCommandSource> serverCommandSourceCommandContext) {
        boolean renderHitboxes = MinecraftClient.getInstance().getEntityRenderDispatcher().shouldRenderHitboxes();
        MinecraftClient.getInstance().getEntityRenderDispatcher().setRenderHitboxes (!renderHitboxes);
        return 0;
    }

}