
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shopyfinal;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Suthar
 */
public class DataChanger {
    public static void main(String[] arg){
        File bs = new File("D:/Shopy/Shopy/baser.txt");
        String dg = "D:/Shopy/Shopy/dg.txt";
        Scanner inread;
        String cmcode , Amount;
         try {
        inread = new Scanner(bs,"UTF-8"); // to get the name of customer
        inread.useDelimiter(",|\\n");
      
      while(inread.hasNext()){
      cmcode = inread.next();
      Amount = inread.next();
      cmcode="0"+cmcode;
      System.out.println("code::"+cmcode+",Amount:"+Amount);
      int cdofere = Integer.valueOf(cmcode);
      System.out.println("cdoetw:"+cdofere);
      cmcode= String.format("%04d", Integer.valueOf(cmcode));
      Amount= String.format("%.2f", Float.valueOf(Amount));
       try {
                      
           PrintWriter out = new PrintWriter(new OutputStreamWriter(new FileOutputStream(dg, true),StandardCharsets.UTF_8));

                        out.print(cmcode+",");
                        out.println(Amount);
                        out.close();   
            } catch (IOException e) {
            e.printStackTrace();
           
        }
      
      }
       inread.close();   
    } catch (FileNotFoundException ex) {
        Logger.getLogger(DataChanger.class.getName()).log(Level.SEVERE, null, ex);
    }
    }
}
