package io.github.dev7ib.effect;

import io.github.dev7ib.effect.commands.FireCommand;
import io.github.dev7ib.effect.utils.Config;
import lombok.Getter;
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
    public Config settings;

    @Override
    public void onEnable() {
        instance = this;
        messages = new Config(this, "message");
        settings = new Config(this, "settings");
        registerCommands();
    }

    private void registerCommands() {

        getCommand("fire").setExecutor(new
                FireCommand());

    }

    @Override
    public void onDisable() {
        instance = null;
    }
}
