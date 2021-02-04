/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Databases;
import javax.swing.JOptionPane;
import java.sql.*; 

/**
 *
 * @author maanaoui
 */
public class dbGeneration {
    private static String DB_DRIVER = "com.mysql.jdbc.Driver"; 
    private static String DB_HOST = "jdbc:mysql://localhost:3306/salledusport";
    private static String DB_PASS = "";
    private static String DB_USER = "root"; 
    
    // Connection into database
    public static Connection mysql_Connection() {
        try{
            Class.forName(DB_DRIVER); 
            Connection con = DriverManager.getConnection(DB_HOST,DB_USER,DB_PASS);
            return con; 
        } catch(Exception e) {
            JOptionPane.showConfirmDialog(null,e.getMessage()); 
            return null; 
        }
    }
   
    // CREATE THE DATABASE
    public static void createDB() {
        try {
            String url_database = "jdbc:mysql://localhost:3306/";
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Connecting into the database ... ");
            Connection con = DriverManager.getConnection(url_database,DB_USER,DB_PASS);
            String sql = "CREATE DATABASE salledusport";
            Statement stat = con.createStatement();
            stat.executeUpdate(sql);
            System.out.println("DataBase salledusport created successfully !");
            if(stat != null) {
                stat.close();
                if (con != null) {
                    con.close();
                }
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
    
    // Creer nos tables dans la base du donness javadata
    public static void createTables() {
        Connection connection = mysql_Connection();
        try{
            Statement stat = connection.createStatement();

            String query1 = "CREATE TABLE membre ("
                    + "id VARCHAR(50) NOT NULL,"
                    + "bankPIN VARCHAR(50) NOT NULL,"
                    + "nomPrenom VARCHAR(50) NOT NULL,"
                    + "numeroDeTelephone VARCHAR(50) NOT NULL,"
                    + "sexe VARCHAR(50) NOT NULL,"
                    + "pere varchar(50) NOT NULL,"
                    + "mere varchar(50) NOT NULL,"
                    + "CIN varchar(50) NOT NULL,"
                    + "age varchar(50) NOT NULL,"
                    + "gymTime varchar(50) NOT NULL,"
                    + "prix varchar(50) NOT NULL,"
                    + "checkPay boolean "
                    + "PRIMARY KEY (CIN))";

              String query2 = "CREATE TABLE bankAccount ("
                    + "CIN VARCHAR(50) NOT NULL,"
                    + "nomPrenom VARCHAR(255) NOT NULL,"
                    + "bankPIN VARCHAR(50) NOT NULL,"
                    + "balance FLOAT(50) NOT NULL"
                    + "PRIMARY KEY (CIN))";
          
            stat.executeUpdate(query1);
            System.out.println("Table membre cree avec success !!");
            stat.executeUpdate(query2);
            System.out.println("Table bankAccount cree avec success !!");
           
            stat.close();
            connection.close();
        } catch(Exception e) {
            System.out.println(e.getMessage());
        }
    }
   
     public static void main(String[] args) {
         createDB(); 
         createTables(); 
     } 
}
