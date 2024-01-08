package com.company;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.io.ObjectOutputStream;
import java.nio.charset.StandardCharsets;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Base64;

public class Main {

    public static void main(String[] args) throws NoSuchAlgorithmException {
//        KeyGenerator key = KeyGenerator.getInstance("AES");
//        key.init(128);
//        SecretKey secret = key.generateKey();'


        Client client = new Client();
        try {
            client.pass();

        Database data = new Database();

        }catch ( SQLException e){
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    }


