package com.loginwit.database;

import com.loginwit.LoginWitPlugin;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseManager {

    private final LoginWitPlugin plugin;
    private Connection connection;

    public DatabaseManager(LoginWitPlugin plugin) {
        this.plugin = plugin;
    }

    public void connect() {
        try {
            File databaseFile = new File(plugin.getDataFolder(), "loginwit.db");

            if (!plugin.getDataFolder().exists()) {
                plugin.getDataFolder().mkdirs();
            }

            connection = DriverManager.getConnection("jdbc:sqlite:" + databaseFile.getAbsolutePath());

            createTables();

            plugin.getLogger().info("Conectado a SQLite.");
        } catch (SQLException e) {
            plugin.getLogger().severe("No se pudo conectar a SQLite.");
            e.printStackTrace();
        }
    }

    private void createTables() {
        String sql = """
                CREATE TABLE IF NOT EXISTS accounts (
                    uuid TEXT PRIMARY KEY,
                    username TEXT NOT NULL,
                    password TEXT NOT NULL,
                    premium INTEGER NOT NULL DEFAULT 0,
                    registered INTEGER NOT NULL DEFAULT 0,
                    last_login INTEGER NOT NULL DEFAULT 0,
                    ip TEXT
                );
                """;

        try (Statement statement = connection.createStatement()) {
            statement.execute(sql);
        } catch (SQLException e) {
            plugin.getLogger().severe("No se pudo crear la tabla accounts.");
            e.printStackTrace();
        }
    }

    public Connection getConnection() {
        return connection;
    }

    public void disconnect() {
        if (connection == null) return;

        try {
            connection.close();
            plugin.getLogger().info("SQLite desconectado.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
          }
