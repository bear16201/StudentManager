/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package comon;

/**
 *
 * @author PC PHUC
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBContext {
     public Connection getConnection()throws Exception {
        String url = "jdbc:mysql://"+serverName+":"+portNumber +"/"+dbName+"?useSSL=false";
        Class.forName("com.mysql.cj.jdbc.Driver");
        return DriverManager.getConnection(url, userID, password);
    }

    /*Insert your other code right after this comment*/

    /*Change/update information of your database connection, DO NOT change name of instance variables in this class*/
    private final String serverName = "localhost";
    private final String dbName = "spm_database";
    private final String portNumber = "3307";
    private final String userID = "root";
    private final String password = "123456";
    
     

    
    public static void main(String[] args) {
        try{
            DBContext db = new DBContext() ;
            if (db.getConnection() != null)
            {
                    System.out.println("ket noi thanh cong");
            }else
            {
                System.out.println("Ket noi that bai");
            }

        }catch(Exception e ) {
            System.out.println(e);
        }
    }
}