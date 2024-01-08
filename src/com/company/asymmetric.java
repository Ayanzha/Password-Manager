package com.company;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import java.security.PrivateKey;
import java.security.PublicKey;

public class asymmetric {
    private static Cipher cipher = null;

    byte[] encrypt(byte[] plainTextByte, PublicKey secretKey)
            throws Exception {
        cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.ENCRYPT_MODE, secretKey);
        byte[] encryptedBytes = cipher.doFinal(plainTextByte);
        return encryptedBytes;
    }

    byte[] decrypt(byte[] encryptedBytes, PrivateKey secretKey)
            throws Exception {
        cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.DECRYPT_MODE, secretKey);
        byte[] decryptedBytes = cipher.doFinal(encryptedBytes);
        return decryptedBytes;
    }
}
