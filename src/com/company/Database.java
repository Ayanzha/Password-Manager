package com.company;


import java.sql.*;
import java.util.Scanner;
public class Database {
    public String a;
    public Connection con;
    public int id;
    public  String name,password;
    public  String  addresspass, email,description,file;


    public  Connection  connectData(){
        try {
             Class.forName("com.mysql.cj.jdbc.Driver");

            String url="jdbc:mysql://localhost:3306/datapassword?server=1&db=datapassword" ;

            String user="root" ;
            String pass="";
            this.con= DriverManager.getConnection(url,user,pass);
            if(con!=null){
                System.out.println("aya");
            }
    }catch (ClassNotFoundException | SQLException e){
            e.printStackTrace();
        }
return con;
    }
    public  String  querySelectname(String name,String password)throws SQLException {

        String query = "SELECT  name,password FROM usertable1 WHERE ' name = '"+name+"'AND password = '"+ password+"'";
        var statement = connectData().prepareStatement(query);
        ResultSet r = statement.executeQuery();

        while (r.next()) {
        this.id = r.getInt("id");
        this.name=r.getString("name");
        this.password=r.getString("password");

            //System.out.println("name:" + name + " ");
        }
        return this.id+";"+this.name+";"+this.password;

    }
    public  void  querinsertnewuser( String name,String password )throws SQLException {
       try{String query = "INSERT INTO usertable1 ( name, password)" +
               " VALUES ( '"+ name+"','" +password+"' )";
           PreparedStatement posted=con.prepareStatement(query);
           posted.executeUpdate();


    }catch (Exception e){
        e.printStackTrace();
    }
    }

    public  void  querInsertElementUser( String name,String addresspass,String email,String password,String description,String file )throws SQLException {

            try{String query =  "INSERT INTO `userelement1` (name, addresspass, email, password, description, file) " +
                        "VALUES ( '"+name+"','"+ addresspass+"','" +email+"','"+ password+"','"+description+"','"+file+"')";
            PreparedStatement posted=con.prepareStatement(query);
            posted.executeUpdate();


        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public  String  querySelectOldElementPassword(String name)throws SQLException {

       String query = "SELECT  name, addresspass, email, password, description, file FROM userelement1 WHERE  userelement.name ="+
        "(Select name From usertable1 Where name = '"+name+"')";
        var statement = connectData().prepareStatement(query);
        ResultSet r = statement.executeQuery();

        while (r.next()) {

            this.name=r.getString("name");
            this.addresspass=r.getString("addresspass");
            this.email=r.getString("email");
            this.password=r.getString("password");
            this.description=r.getString("description");
            this.file=r.getString("file");

            //System.out.println("name:" + name + " ");
        }
        return this.name+";"+this.addresspass+";"+this.email+";"+this.password+";"+this.description+";"+this.file;

    }




    public  void  queryUpdateOldElementPassword( String name,String addresspass,String email,String password,String description,String file )throws SQLException {

        String query = "UPDATE userelement1 SET addresspass = '"+addresspass+"',email='"+email+"',password='"+password+"',description='"+description+"',file = '"+file+"'"+
               " WHERE  userelement1.name =(Select name From usertable1 Where name = '"+name+"')";
        PreparedStatement posted=con.prepareStatement(query);
        posted.executeUpdate();


    }
//    public  void queryUpdatePassword (int id ,String password)
//    {
//        String query = "UPDATE userelement1 SET password = '"+password+"';
//    }
    public  void  queryDeletOldElementPassword( String name,String  addresspass )throws SQLException {

        String query = "DELETE userelement  WHERE name = 'alaa'"; //userelement.name =(Select name From usertable Where name = '"+name+"')";//AND addresspass= '"+addresspass+"'";
//        PreparedStatement posted=con.prepareStatement(query);
//        posted.executeUpdate();



    }
//DELETE Emp
//WHERE Empid = 1
}
