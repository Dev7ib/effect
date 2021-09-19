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
                player.sendMessage(Effect.getInstance().getMessages().getString("fireresistance.disable"));
            } else {
                player.sendMessage(Effect.getInstance().getMessages().getString("fireresistance.enabled"));
                player.addPotionEffect(new PotionEffect(PotionEffectType.FIRE_RESISTANCE, Integer.MAX_VALUE ,1));
            }
            return true;
        }
        if(args.length == 1) {
            Player target = Bukkit.getPlayer(args[0]);
            if(target == null) {
                Effect.getInstance().getMessages().getString("basic.player-offline");
                return true;
            }
            if(target.hasPotionEffect(PotionEffectType.FIRE_RESISTANCE)) {
                target.removePotionEffect(PotionEffectType.FIRE_RESISTANCE);
                target.sendMessage(Effect.getInstance().getMessages().getString("fireresistance.disable"));
                player.sendMessage(CC.color("&eYou've &cDisabled &6" + target.getName() + " &eFire Resistance"));
            } else {
                target.sendMessage(Effect.getInstance().getMessages().getString("fireresistance.enabled"));
                target.addPotionEffect(new PotionEffect(PotionEffectType.FIRE_RESISTANCE, Integer.MAX_VALUE ,1));
                player.sendMessage(CC.color("&eYou've &aEnabled &6" + target.getName() + " &eFire Resistance "));
            }
        }
        return true;
    }
}