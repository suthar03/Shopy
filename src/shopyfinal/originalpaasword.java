/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package shopyfinal;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author Suthar
 */
public class originalpaasword {
     public static String getpass(String base,String filename) throws IOException{
     String baseadd =base;
   Scanner in ;
   filename = baseadd+"/"+filename+"/"+filename+".txt";
   //TextIO.putln(filename);
try {
 in = new Scanner(new File(filename),"UTF-8");
String str = in.nextLine();
in.close();
 return str;
}
catch (Exception e) {
String tyru = null;
return tyru;
//return;
}
 

    }

}
