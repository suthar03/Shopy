/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shopyfinal;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Suthar
 */
public class NameChanger {
    public static void main(String[] arg){
        File bs = new File("D:/Shopy/Shopy/base.txt");
        //String dg = "D:/Shopy/Shopy/dg.txt";
        Scanner inread;
        String cmcode , Name , Mob;
         try {
        inread = new Scanner(bs,"UTF-8"); // to get the name of customer
        inread.useDelimiter(",|\\n");
      
      while(inread.hasNext()){
      cmcode = inread.next();
      Name = inread.next();
      Mob = inread.next();
      Mob = Mob.substring(0, Mob.length()-1);
      //inread.next();
      System.out.println(cmcode+"  "+Name+"  "+Mob);
      String dg = "D:\\Shopy\\Shopy\\1501\\Customer/"+cmcode;
      cmcode= String.format("%04d", Integer.valueOf(cmcode));
     // ReplaceLineWN.mainn(dg, "profile.txt", 3, Name);
      File fl = new File(dg);
      if(!Mob.isEmpty()&&fl.exists()){   try {
                ReplaceLineWN.mainn(dg, "profile.txt", 3, Name);
                ReplaceLineWN.mainn(dg, "profile.txt", 4, Mob);
            } catch (IOException ex) {
                Logger.getLogger(NameChanger.class.getName()).log(Level.SEVERE, null, ex);
            }
      }else{
                    System.out.println("Mob is empty::"+cmcode);
                    }
      
      }
       inread.close();   
    } catch (FileNotFoundException ex) {
        Logger.getLogger(NameChanger.class.getName()).log(Level.SEVERE, null, ex);
    }
    }
}
