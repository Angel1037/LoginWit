package com.loginwit.util;

import org.mindrot.jbcrypt.BCrypt;

public final class PasswordUtil {

    private PasswordUtil() {
        // Evita crear instancias
    }

    /**
     * Genera un hash seguro de una contraseña usando BCrypt.
     */
    public static String hash(String password) {
        return BCrypt.hashpw(password, BCrypt.gensalt(12));
    }

    /**
     * Comprueba si una contraseña coincide con su hash.
     */
    public static boolean verify(String password, String hash) {
        return BCrypt.checkpw(password, hash);
    }
}
