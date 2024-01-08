package com.company;

import javax.crypto.KeyGenerator;
import javax.crypto.Mac;
import javax.crypto.SecretKey;
import java.security.*;

public class MacAlogrithm {
    public byte[] generateSessionKey() throws NoSuchAlgorithmException, NoSuchProviderException
    {
        KeyGenerator kgen = KeyGenerator.getInstance("AES","BC");
        kgen.init(256);
        SecretKey key = kgen.generateKey();
        byte[] symmKey = key.getEncoded();
        return symmKey;
    }




    public void macKey() throws NoSuchAlgorithmException, InvalidKeyException {
        //Creating a KeyGenerator object
        KeyGenerator keyGen = KeyGenerator.getInstance("DES");
        //Creating a SecureRandom object
        SecureRandom secRandom = new SecureRandom();
        //Initializing the KeyGenerator
        keyGen.init(secRandom);
        //Creating/Generating a key Key
        Key key = keyGen.generateKey();
        //Creating a Mac object
        Mac mac = Mac.getInstance("HmacSHA256");
        //Initializing the Mac object
        mac.init(key);
        //Computing the Mac
        String msg = new String("Hi how are you");
        byte[] bytes = msg.getBytes();
        byte[] macResult = mac.doFinal(bytes);
        System.out.println("Mac result:");
        System.out.println(new String(macResult));
    }

}
