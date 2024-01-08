package com.company;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;

public class symmetric {
    private static Cipher cipher = null;

     byte[] encrypt(byte[] plainTextByte, SecretKey secretKey)
            throws Exception {
        cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.ENCRYPT_MODE, secretKey);
        byte[] encryptedBytes = cipher.doFinal(plainTextByte);
        return encryptedBytes;
    }

     byte[] decrypt(byte[] encryptedBytes, SecretKey secretKey)
            throws Exception {
        cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.DECRYPT_MODE, secretKey);
        byte[] decryptedBytes = cipher.doFinal(encryptedBytes);
        return decryptedBytes;
    }
}
