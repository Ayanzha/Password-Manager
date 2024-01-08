package com.company;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.util.Arrays;
import java.util.Base64;
import java.util.Scanner;

public class Server {
static asymmetric as = new asymmetric();
private Socket socket ;
  static   generatekeys generat;

    static {
        try {
            generat = new generatekeys();
            System.out.println(Arrays.toString(generat.getPrivateKey().getEncoded()));
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }

    Database data = new Database();

    public static void main(String[] args) throws Exception {
     //   generatekeys generat = new generatekeys();
        KeyGenerator gen = KeyGenerator.getInstance("AES");
        gen.init(128);
        SecretKey secret = gen.generateKey();
        symmetric sym = new symmetric();
        Server server =new Server();

        try(ServerSocket listener = new ServerSocket(11111)){
            System.out.println("THe capitilizeMultiServer is running ....");

            try(Socket socket=listener.accept() ) {

                System.out.println("Connected :" + socket);

                ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
                System.out.println("ssdfs"
                );

//                String str=" ";

                    System.out.println("ana bl server");
                    out.writeObject(generat.getPublicKey());
                ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
                   byte[] i = (byte[]) in.readObject();
                System.out.println(i);
                    System.out.println("encrypt message");
                    System.out.println(i.length);

               byte[]b = as.decrypt(i,generat.getPrivateKey());
                System.out.println(new String(b));
//                    if (!i.equals("null;null")) {
//                        // System.out.println(i);
//                        server.privatekey(i);
//                    }

            }catch (Exception e)
            {
                System.out.println(e);
            }
        }

    }

    public String publickey () throws Exception {
        byte [] b = generat.getPublicKey().getEncoded();
        String a = Base64.getEncoder().encodeToString(b);
    //    System.out.println("after");

       System.out.println(a);
        return a;
    }
    public  String acceptCreatNewUser(String account){
        String[] parts;
        try {
            data.connectData();

             parts = account.split(";");
            data.querinsertnewuser( parts[0], parts[1]);
            System.out.println(parts[1]);
        }catch (Exception e)
        {

        }
        return  "True";
    }
    public  String acceptSeeOldUser(String account){
        String[] parts;String strings=" ";
        try {
            data.connectData();

            parts = account.split(";");
            strings= data.querySelectname(parts[0], parts[1]);

            System.out.println(parts[0]+" "+parts[1]);
        }catch (Exception e)
        {
        }
        if(strings.equals(account)){
            return  strings;
        }
        else
            return "False";


    }

    public  String acceptAddElementNewPassword(String account){
        String[] parts;
        try {
            data.connectData();

            parts = account.split(";");
            data.querInsertElementUser(parts[0], parts[1], parts[2],parts[3],parts[4],parts[5]);
            System.out.println(parts[1]);
        }catch (Exception e)
        {

        }
        return  "True";
    }
    public  String acceptSeeOldelementPassword(String account){
        String[] parts;String strings=" ";
        try {
            data.connectData();

            parts = account.split(";");
            System.out.println(parts[0]);
            strings=  data.querySelectOldElementPassword(parts[0]);
           // strings= data.querySelectname(parts[0], parts[1],);

            System.out.println(parts[0]+" "+parts[1]);
        }catch (Exception e)
        {
        }

            return  strings;
    }

    public  String acceptUpdateOldElementPassword(String account){
        String[] parts;
        try {
            data.connectData();

            parts = account.split(";");
            data.queryUpdateOldElementPassword(parts[0], parts[1], parts[2],parts[3],parts[4],parts[5]);
            System.out.println(parts[1]);
        }catch (Exception e)
        {

        }
        return  "True";
    }
}