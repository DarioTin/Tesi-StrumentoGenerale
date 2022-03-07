package com.dariotintore.backend.Utils;

import org.springframework.security.crypto.bcrypt.BCrypt;

public class UserCheck {
    public static boolean isPasswordLongEnough(String password) {
        if (password.length() >= 6) {
            return true;
        } else {
            return false;
        }
    }

    public static String passwordEncrypter(String password) {
        String hash = BCrypt.hashpw(password, BCrypt.gensalt());
        return hash;
    }

    public static boolean checkPassword(String passwordInPlain, String passwordEncrypted) {
        if (BCrypt.checkpw(passwordInPlain, passwordEncrypted)) {
            return true;
        } else {
            return false;
        }
    }

}
