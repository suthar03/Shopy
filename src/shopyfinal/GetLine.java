/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
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
public class GetLine {
    public static String mainn(String filename,int n) throws IOException{
 
   Scanner in ;
    
try {
in = new Scanner(new File(filename),"UTF-8");
for(int i=1;i<n;++i){
in.nextLine();
}
String str = in.nextLine();//new String(in.readLine().getBytes(),"UTF-8");
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
