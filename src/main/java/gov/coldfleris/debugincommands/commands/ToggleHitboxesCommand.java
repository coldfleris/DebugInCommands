package gov.coldfleris.debugincommands.commands;

import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.context.CommandContext;
import gov.coldfleris.debugincommands.Main;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.hud.ChatHud;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.text.TranslatableText;

import static net.minecraft.server.command.CommandManager.literal;


public class ToggleHitboxesCommand {
    public static void register(CommandDispatcher<ServerCommandSource> dispatcher) {
        dispatcher.register(literal("togglehitboxes")
                .executes(ToggleHitboxesCommand::toggleTheHitboxes)
        );

        //literal("hitboxes") is an alias to parent togglehitboxes
        dispatcher.register(literal("hitboxes")
                .executes(ToggleHitboxesCommand::toggleTheHitboxes)
        );

        //literal("th") is an alias to parent togglehitboxes
        dispatcher.register(literal("th")
                .executes(ToggleHitboxesCommand::toggleTheHitboxes)
        );

    }

    public static int toggleTheHitboxes(CommandContext<ServerCommandSource> serverCommandSourceCommandContext) {
        boolean renderHitboxes = MinecraftClient.getInstance().getEntityRenderDispatcher().shouldRenderHitboxes();
        MinecraftClient.getInstance().getEntityRenderDispatcher().setRenderHitboxes (!renderHitboxes);
        ChatHud chatHud = MinecraftClient.getInstance().inGameHud.getChatHud();

        //Announce in chat that the command was executed and the feature has been toggled.
        chatHud.addMessage(new TranslatableText(renderHitboxes ? "debug.show_hitboxes.off" : "debug.show_hitboxes.on"));

        //Note it in log - NOTE THAT THE WARN IS INTENDED BEHAVIOR.
        Main.LOGGER.warn("Take note: User has executed a debug command!");


        return 0;
    }

}