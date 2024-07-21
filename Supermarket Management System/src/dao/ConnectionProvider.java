/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

/**
 *
 * @author FAHAD FATEH
 */

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionProvider {

    public static void main(String args []) {
        getCon();
    }

    public static Connection getCon() {
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/supermarket?useSSL=false","root","");
            System.out.println("conneced successfully!");
            return con;
        }catch(Exception e){
            System.out.println("Sorry failed to connect! " + e);
            return null;
        }
    }
}
