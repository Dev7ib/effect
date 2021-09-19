package io.github.dev7ib.effect.commands;

import io.github.dev7ib.effect.Effect;
import io.github.dev7ib.effect.utils.CC;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

/**
 * @author Dev7ib (dev7ib@fusiongames.dev)
 * 9/18/2021 / 7:21 PM
 * effect / io.github.dev7ib.effect.commands
 */
public class SpeedCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(!(sender instanceof Player)) {
            sender.sendMessage(CC.color(Effect.getInstance().getMessages().getString("basic.only-players")));
            return true;
        }

        Player player = (Player) sender;
        if(!player.hasPermission("effect.command.speed")) {
            sender.sendMessage(CC.color(Effect.getInstance().getMessages().getString("basic.no-permission")));
            return true;
        }
        if(args.length == 0) {
            if(player.hasPotionEffect(PotionEffectType.SPEED)) {
                player.removePotionEffect(PotionEffectType.SPEED);
                player.sendMessage(Effect.getInstance().getMessages().getString("speed.disable"));
            } else {
                player.sendMessage(Effect.getInstance().getMessages().getString("speed.enabled"));
                player.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, Integer.MAX_VALUE ,1));
            }
            return true;
        }
        if(args.length == 1) {
            Player target = Bukkit.getPlayer(args[0]);
            if(target == null) {
                Effect.getInstance().getMessages().getStringList("basic.players-offline");
                return true;
            }
            if(target.hasPotionEffect(PotionEffectType.SPEED)) {
                target.removePotionEffect(PotionEffectType.SPEED);
                target.sendMessage(Effect.getInstance().getMessages().getString("speed.disable"));
                player.sendMessage(CC.color("&eYou've &cDisabled &6" + target.getName() + " &eSpeed 2"));
            } else {
                target.sendMessage(Effect.getInstance().getMessages().getString("speed.enabled"));
                target.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, Integer.MAX_VALUE ,1));
                player.sendMessage(CC.color("&eYou've &aEnabled &6" + target.getName() + " &eSpeed 2"));
            }
        }
        return true;
    }
}
