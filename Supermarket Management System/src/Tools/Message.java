/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Tools;
import javax.swing.JOptionPane;

/**
 *
 * @author FAHAD FATEH
 */
public abstract class Message {
     
    public static void show(Object message){
        JOptionPane.showConfirmDialog(null, message);
    }
}
