package io.github.dev7ib.effect.commands;

import io.github.dev7ib.effect.Effect;
import io.github.dev7ib.effect.utils.CC;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

/**
 * @author Dev7ib (dev7ib@fusiongames.dev)
 * 9/18/2021 / 8:49 PM
 * effect / io.github.dev7ib.effect.commands
 */
public class EffectCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if(!(sender instanceof Player)) {
            sender.sendMessage(CC.color(Effect.getInstance().getMessages().getString("basic.only-players")));
            return true;
        }
        Player player = (Player) sender;
        player.sendMessage(CC.color("&7&m------------------------------------"));
        player.sendMessage(CC.color("&6Effects "));
        player.sendMessage(CC.color(""));
        player.sendMessage(CC.color("&fPlugins version: &a " + Effect.getInstance().getDescription().getVersion()));
        player.sendMessage(CC.color("&fPlugins authors: &a " + Effect.getInstance().getDescription().getAuthors()));
        player.sendMessage(CC.color("&fPlugins discord: &a " + Effect.getInstance().getDescription().getWebsite()));
        player.sendMessage(CC.color("&7&m------------------------------------"));
        return true;
    }
}
