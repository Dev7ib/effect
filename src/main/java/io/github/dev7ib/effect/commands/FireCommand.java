package io.github.dev7ib.effect.commands;

import io.github.dev7ib.effect.Effect;
import io.github.dev7ib.effect.utils.CC;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

/**
 * @author Dev7ib (dev7ib@fusiongames.dev)
 * 9/17/2021 / 1.56 PM
 * Effect / io.github.dev7ib.effect.commands
 */
public class FireCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(!(sender instanceof Player)) {
            sender.sendMessage(CC.color(Effect.getInstance().getMessages().getString("basic.only-players")));
            return true;
        }

        Player player = (Player) sender;
        if(!player.hasPermission("effect.command.fire")) {
            sender.sendMessage(CC.color(Effect.getInstance().getMessages().getString("basic.no-permission")));
            return true;
        }
        if(args.length == 0) {
            if(player.hasPotionEffect(PotionEffectType.FIRE_RESISTANCE)) {
                player.removePotionEffect(PotionEffectType.FIRE_RESISTANCE);
                player.sendMessage(CC.color("&cYou no longer have fire resistance"));
            } else {
                player.sendMessage(CC.color("&aYou have fire resistance 2"));
                player.addPotionEffect(new PotionEffect(PotionEffectType.FIRE_RESISTANCE, Integer.MAX_VALUE ,1));
            }
            return true;
        }
        if(args.length == 1) {
            Player target = Bukkit.getPlayer(args[0]);
            if(target == null) {
                for (String playerNull : Effect.getInstance().getMessages().getStringList("PlayerNull")) {
                    player.sendMessage(CC.color(playerNull));
                }
                return true;
            }
            if(target.hasPotionEffect(PotionEffectType.FIRE_RESISTANCE)) {
                target.removePotionEffect(PotionEffectType.FIRE_RESISTANCE);
                target.sendMessage(CC.color("&cYou no longer have fire resistance"));
                player.sendMessage(CC.color("&cYou've removed " + target.getName() + " &afire resistance"));
            } else {
                target.sendMessage(CC.color("&aYou have been given fire resistance 2 by " + player.getName()));
                target.addPotionEffect(new PotionEffect(PotionEffectType.FIRE_RESISTANCE, Integer.MAX_VALUE ,1));
                player.sendMessage(CC.color("&cYou've given " + target.getName() + " &afire resistance 2"));
            }
        }
        return true;
    }
}
