/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package common;

import javax.swing.JOptionPane;
import dao.InverntoryUtils;
import java.io.File;

/**
 *
 * @author FAHAD FATEH
 */
public class openPdf {
    
    public static void openById(String id) {
    
    try {
        if((new File(InverntoryUtils.billPath + id + ".pdf")).exists()){
            Process p = Runtime.getRuntime().exec("rundll32 url.dll, FileProtocolHandler " + InverntoryUtils.billPath + "" + id + ".pdf");
    
        } else {
            JOptionPane.showMessageDialog(null, "File does not exist!");
        }
    }
    catch(Exception e){
        JOptionPane.showMessageDialog(null, e);
    }
    }
}
