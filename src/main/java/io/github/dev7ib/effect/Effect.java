package io.github.dev7ib.effect;

import io.github.dev7ib.effect.commands.*;
import io.github.dev7ib.effect.utils.CC;
import io.github.dev7ib.effect.utils.Config;
import lombok.Getter;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * @author Dev7ib (dev7ib@fusiongames.dev)
 * 9/17/2021 / 2:00 PM
 * Effect / io.github.dev7ib.effect
 */

@Getter
public final class Effect extends JavaPlugin {

    @Getter
    private static Effect instance;
    public Config messages;

    @Override
    public void onEnable() {
        instance = this;
        messages = new Config(this, "message");
        registerCommands();
        Bukkit.getConsoleSender().sendMessage(CC.color("&7&l&m---------------------------------"));
        Bukkit.getConsoleSender().sendMessage(CC.color("&6&lEffects"));
        Bukkit.getConsoleSender().sendMessage(CC.color("&7"));
        Bukkit.getConsoleSender().sendMessage(CC.color("&7You are using the most recent version of &6&lEffects&7!"));
        Bukkit.getConsoleSender().sendMessage(CC.color("&7"));
        Bukkit.getConsoleSender().sendMessage(CC.color("&7Need support? Join our discord."));
        Bukkit.getConsoleSender().sendMessage(CC.color("&a&nhttps://discord.gg/9hvf8gYGuS"));
        Bukkit.getConsoleSender().sendMessage(CC.color("&7&l&m---------------------------------"));
    }

    private void registerCommands() {

        getCommand("fire").setExecutor(new
                FireCommand());
        getCommand("speed").setExecutor(new
                SpeedCommand());
        getCommand("invisibility").setExecutor(new
                InvisibilityCommand());
        getCommand("strength").setExecutor(new
                StrengthCommand());
        getCommand("waterbreathing").setExecutor(new
                WaterBreathingCommand());

    }

    @Override
    public void onDisable() {
        instance = null;
    }
}
