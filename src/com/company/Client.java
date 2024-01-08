package com.company;
import javax.crypto.KeyGenerator;
import javax.crypto.Mac;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.io.*;
import java.io.IOException;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.security.*;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.X509EncodedKeySpec;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.Base64;
import java.util.Scanner;

public class Client  {
    public int id;
    symmetric s = new symmetric();
    asymmetric as = new asymmetric();

    public  String name,password, addresspass, email,description,file;
    public void set_id(int id){
        this.id= id;
    }
    public void set_name(String name){
        this.name= name;
    }
    public void set_password(String password){
        this.password= password;
    }
    public void set_addresspass(String addresspass){
        this.addresspass= addresspass;
    }

    public void set_email(String email){
        this.password= password;
    }
    public void set_description(String description){
        this.description= description;
    }
    public void set_file(String file){
        this.file= file;
    }
    public int get_id(){
        return this.id;
    }
    public String get_name(){
        return this.name;
    }
    public String get_password(){
        return this.password;
    }
    public String get_addresspass(){
        return this.addresspass;
    }
    public String get_email(){
        return this.email;
    }
    public String get_description(){
        return this.description;
    }
    public String get_file(){
        return this.file;
    }
    public String creatNewUser(){
        int a=1;
        Scanner scanner=new Scanner(System.in);
        System.out.println("if you want creat new account enter 0");
        a=scanner.nextInt();
        if(a==0) {

            System.out.println("enter your name");
           String name_ = scanner.next();
            System.out.println("enter your password");
           String password_ = scanner.next();

            set_name(name_);
            set_password(password_);

        }
        String account=get_name()+";"+get_password();
        return account;
    }

    public String creatOldUser(){
        int a=1;
        Scanner scanner=new Scanner(System.in);
        System.out.println("if you want see your account enter 0");
        a=scanner.nextInt();
        if(a==0) {

            System.out.println("enter your name");
            String name_ = scanner.next();
            System.out.println("enter your password");
            String password_ = scanner.next();
            set_name(name_);
            set_password(password_);


        }
        String account=get_name()+";"+get_password();
        return account;
    }
    public String insertElementNewPassword(){
        int a=1;
        Scanner scanner=new Scanner(System.in);
        System.out.println("if you want creat new account enter 0");
        a=scanner.nextInt();
        if(a==0) {
            System.out.println("enter your name");
            String name_ = scanner.next();
            System.out.println("enter your addresspass");
            String addresspass= scanner.next();
            System.out.println("enter your email");
            String email = scanner.next();
            System.out.println("enter your password");
            String password = scanner.next();
            System.out.println("enter your description");
            String description= scanner.next();
            System.out.println("enter your file");
            String file = scanner.next();
            set_name(name_);
            set_password(password);
            set_addresspass(addresspass);
            set_description(description);
            set_email(email);
            set_file(file);

        }
        String account=get_name()+";"+get_addresspass()+";"+get_email()+";"+get_password()+";"+get_description()+";"+get_file();
        return account;
    }
    public String ShowOldElementPassword(){
        int a=1;
        Scanner scanner=new Scanner(System.in);
        System.out.println("if you want see your old passwoed enter 0");
        a=scanner.nextInt();
        if(a==0) {

            System.out.println("enter your name");
            String name_ = scanner.next();
//            System.out.println("enter your password");
//            String password_ = scanner.next();
            set_name(name_);
           // set_password(password_);

        }
        String account=get_name();
        return account;
    }
      public static void main(String[] args)  {

    try {

        String name="";
        Client client=new Client();

        try( Socket socket = new Socket("127.0.0.1",11111)){

       //     Scanner scaner = new Scanner(System.in);


            ObjectInputStream in = new ObjectInputStream(socket.getInputStream());

         //  out.flush();

                System.out.println("ana bl client");
            PublicKey i=(PublicKey) in.readObject();
            System.out.println(i.getEncoded().toString());
            byte[]  enc1 = client.encryptgeneratAes(i , "1234578");
            System.out.println(enc1);
            ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
            System.out.println("alaaaaaaaa");
           // =out.writeObject(client.creatNewUser());
            out.flush();
            out.writeObject(enc1);
           // out.flush();

    } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

        }
        catch (Exception e)
        {
            System.out.println(e);
        }
   }
    public String UpdatElementOldPassword(){
        int a=1;
        Scanner scanner=new Scanner(System.in);
        System.out.println("if you want update  your element Old Password enter 0");
        a=scanner.nextInt();
        if(a==0) {
            System.out.println("enter your name");
            String name_ = scanner.next();
            System.out.println("update your addresspass");
            String addresspass= scanner.next();
            System.out.println("update your email");
            String email = scanner.next();
            System.out.println("update your password");
            String password = scanner.next();
            System.out.println("update your description");
            String description= scanner.next();
            System.out.println("update your file");
            String file = scanner.next();
            set_name(name_);
            set_password(password);
            set_addresspass(addresspass);
            set_description(description);
            set_email(email);
            set_file(file);

        }
        String account=get_name()+";"+get_addresspass()+";"+get_email()+";"+get_password()+";"+get_description()+";"+get_file();
        return account;
    }
    String padding (String pass , int lengthaes)
    {
        if ( pass.length() < lengthaes) {
            int i = lengthaes - pass.length();

            for (int j = 0; j < i; j++) {
                pass = pass + "0";
            }

        }
        else if (pass.length() > lengthaes)
        {
            pass = pass.substring(0,lengthaes);

        }
        return pass ;
    }
    byte[] encryptgeneratAes (PublicKey pub, String str) throws Exception {
        byte[] encrypt =as.encrypt(str.getBytes(),pub);
        return encrypt;

    }
    String pass () throws Exception {

        Scanner scanner=new Scanner(System.in);
        System.out.println("if you want update  your element Old Password enter 0");


            System.out.println("update your password");
            String password = scanner.next();
            String pad = padding(password,16);
            set_password(pad);

            String str = "aya";
            byte[] decodedKey = get_password().getBytes("UTF-8");
             System.out.println(decodedKey.length);
            SecretKey secretKey = new SecretKeySpec(decodedKey, 0, decodedKey.length, "AES");
            byte []x = s.encrypt(str.getBytes() , secretKey);

            System.out.println(x.toString());
            byte [] y = s.decrypt(x,secretKey);
            String b= new String(y, StandardCharsets.UTF_8);
            System.out.println(b);

        return b;
    }

}