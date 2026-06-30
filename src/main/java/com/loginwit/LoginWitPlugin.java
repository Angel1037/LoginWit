package com.loginwit;

import org.bukkit.plugin.java.JavaPlugin;

public final class LoginWitPlugin extends JavaPlugin {

    @Override
    public void onEnable() {
        getLogger().info("LoginWit ha sido habilitado.");
    }

    @Override
    public void onDisable() {
        getLogger().info("LoginWit ha sido deshabilitado.");
    }
}
