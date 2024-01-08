package com.company;

import java.security.*;

public class generatekeys {
    private KeyPairGenerator keyGen;
    private KeyPair pair;
    private PrivateKey privateKey;
    private PublicKey publicKey;
public generatekeys () throws NoSuchAlgorithmException {
    this.keyGen = KeyPairGenerator.getInstance("RSA");
    this.keyGen.initialize(2048);
    createKeys();
}
    public void createKeys() {
        this.pair = this.keyGen.generateKeyPair();
        this.privateKey = pair.getPrivate();
        this.publicKey = pair.getPublic();
    }

    public PrivateKey getPrivateKey() {
        return this.privateKey;
    }

    public PublicKey getPublicKey() {
        return this.publicKey;
    }
}
