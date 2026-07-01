package com.loginwit;

import org.bukkit.plugin.java.JavaPlugin;

public final class LoginWitPlugin extends JavaPlugin {

    @Override
    public void onEnable() {
        saveDefaultConfig();
        getLogger().info("LoginWit habilitado.");
    }

    @Override
    public void onDisable() {
        getLogger().info("LoginWit deshabilitado.");
    }
}
