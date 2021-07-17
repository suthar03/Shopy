/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package shopyfinal;

import java.io.File;
import java.util.Scanner;


/**
 *
 * @author Suthar
 */
public class repeatationWOcase {
    //public static void main(String[] arg){
    public static int mainn(String fileaddress,String filename,String StrToCheck){
       // String fileaddress ="C:/Users/Suthar/desktop/Shopy";
       // String filename = "userID.txt";
       // String StrToCheck = "1";     //User Name
        int res = 0;
        String filedata = fileaddress +"/"+filename;
         Scanner in;
try {
    //  Start Start Start Start
in = new Scanner(new File(filedata),"UTF-8");
 String str;


 while(in.hasNext()){
     str=in.nextLine();
    //System.out.println(str);
    if(str.equalsIgnoreCase(StrToCheck))
    { res =1;
    break;}

 }


 in.close();

}
    // Over Over Over Over
catch (Exception e) {
    //System.out.println("Sorry, but an error occurred while trying to open the file:\n" + e);
//return;
}

//TextIO.putln(res);
return res;
         //TextIO.putln(res);
    }

}
