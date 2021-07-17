/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package shopyfinal;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 *
 * @author Suthar
 */
public class ReplaceLineWN {
    //public static void main(String[] arg) throws IOException{
        public static void mainn(String baseadd , String filename , int non , String newstr) throws FileNotFoundException, IOException{
        int counter =0 ;

       
       File fl1 = new File(baseadd+"/tmp.txt");
       if(fl1.exists())
       fl1.delete();
 Scanner in = new Scanner(new File(baseadd+"/"+filename),"UTF-8");
System.out.println("Remove Line WN :"+baseadd+"/"+filename);
PrintWriter out = new PrintWriter(new OutputStreamWriter(new FileOutputStream(baseadd+"/tmp.txt"), "UTF-8"));//out = new PrintWriter(new BufferedWriter(new FileWriter(baseadd+"/tmp.txt")));
String str ;
/*try ( 
                              BufferedWriter writ = Files.newBufferedWriter(Paths.get(baseadd+"/tmp.txt"), StandardCharsets.UTF_8,StandardOpenOption.CREATE);
                              
        ) {*/
//#########################################################

    //  Start Start Start Start

 while(in.hasNext()){
     str=in.nextLine();
counter++;
//str=new String(str.getBytes(),"UTF-8");
if( counter!=non)     {
    out.println(str);
    //writ.append(str+"\n");
    }
else{
    System.out.println("replace line :"+newstr);
    out.println(newstr);
    //writ.append(newstr+"\n");
}
 }
 in.close();
 out.close();
//writ.flush();
//}
 //#######################################
//stream = new FileReader(baseadd +"/tmp.txt");
fl1 = new File(baseadd+"/"+filename);
       if(fl1.exists())
       fl1.delete();
in = new Scanner(new File(baseadd+"/tmp.txt"),"UTF-8");
out = new PrintWriter(new OutputStreamWriter(new FileOutputStream(baseadd+"/"+filename), "UTF-8"));
/*try ( 
                              BufferedWriter writ = Files.newBufferedWriter(Paths.get(baseadd+"/"+filename), StandardCharsets.UTF_8,StandardOpenOption.CREATE);
                              
        ) {*/
//#########################################################

   
 while(in.hasNext()){
     str=in.nextLine();
//counter++;
//str=new String(str.getBytes(),"UTF-8");
    out.println(str);
    //writ.append(str+"\n");
   
 }
 in.close();
 out.close();
 //writ.flush();
//}
fl1 = new File(baseadd+"/tmp.txt");
       if(fl1.exists())
       fl1.delete();
//out = new PrintWriter(new BufferedWriter ( new FileWriter(baseadd+"/"+filename)));






    
    
   
    }






}
