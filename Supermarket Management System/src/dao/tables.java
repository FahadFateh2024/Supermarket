/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.Connection;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author FAHAD FATEH
 */
public class tables {
    
    public static void main(String[] args) {
        Connection con = null;
        Statement st = null;
        
        try {
            con = ConnectionProvider.getCon();
            st = con.createStatement();
            //st.executeUpdate("create table appusers(appuser_pk int AUTO_INCREMENT primary key, userRole varchar(50), name varchar(200), mobileNumber varchar(50), email varchar(200), password varchar(50), address varchar(200), stutus varchar(50))");
            //st.executeUpdate("create table category(category_pk int AUTO_INCREMENT primary key, name varchar(200))");
            // st.executeUpdate("create table product(product_pk int AUTO_INCREMENT primary key, name varchar(200), quantity int, price int, description varchar(500), category_fk int)");
            //st.executeUpdate("create table customer(customer_pk int AUTO_INCREMENT primary key, name varchar(200), mobileNumber varchar(50), email varchar(200))");
            st.executeUpdate("create table orderDetail(order_pk int AUTO_INCREMENT primary key, orderId varchar(200), customer_fk int, orderDate varchar(200), totalPaid int)");
            JOptionPane.showMessageDialog(null, "table created successfully!");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        } finally {
            try {
                con.close();
                st.close();
            } catch (Exception e) {
                
            }
        }
    }
}
