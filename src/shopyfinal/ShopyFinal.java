/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shopyfinal;

import java.awt.Font;
import java.io.File;
import java.io.IOException;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 *
 * @author Suthar
 */
public class ShopyFinal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String baseadd ="D:/Shopy/Shopy";
        String logo = "src/Icons/logo.png";
        
        try {
            
            baseadd=GetLine.mainn("src/data/base.txt",1);
            File nf = new File(baseadd);
            if(!nf.exists()){
                //int yon;
               int yon = JOptionPane.showConfirmDialog(null,"Are you here for first time ?","Confirmation ....",JOptionPane.OK_OPTION);
        if(yon==0){//YES 
            //Create a baseadd directory
            File nf1 = nf.getParentFile();
            File nf2 = nf1.getParentFile();
            if(!nf2.exists()){nf2.mkdir(); }
            if(!nf1.exists()){nf1.mkdir(); }
            if(!nf.exists()){nf.mkdir(); }
        }else{
             JLabel label1 = new JLabel("There Is Problem of base Directory");        
        label1.setFont(new Font("Arial", Font.BOLD, 18));        
        JOptionPane.showMessageDialog(null,label1,"ERROR",JOptionPane.WARNING_MESSAGE);
        }
        }
            
    
            new NewPassword1(baseadd,logo).setVisible(true);
        } catch (IOException ex) {
            JLabel label1 = new JLabel("There Is Problem At Initial"+ex);        
        label1.setFont(new Font("Arial", Font.BOLD, 18));        
        JOptionPane.showMessageDialog(null,label1,"ERROR",JOptionPane.WARNING_MESSAGE);
        }
    }
    
}
