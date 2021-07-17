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
public class RemoveLine {
   // public static void main(String[] arg) throws IOException{
        public static void mainn(String baseadd , String filename , String Str ) throws FileNotFoundException, IOException{
        
      

File fl1 = new File(baseadd+"/temp.txt");
if(fl1.exists())
fl1.delete();
Scanner read ;
            read = new Scanner(new File(baseadd+"/"+filename),"UTF-8");
            read.useDelimiter("\\n");
            PrintWriter out = new PrintWriter(new OutputStreamWriter(new FileOutputStream(baseadd+"/temp.txt"), "UTF-8"));
//PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(baseadd+"/tmp.txt")));
String str ;
int rs=0;
/*try ( 
                              BufferedWriter writ = Files.newBufferedWriter(Paths.get(baseadd+"/tmp.txt"), StandardCharsets.UTF_8,StandardOpenOption.CREATE);
                              
        ) {*/
    
//#########################################################
    
 while(read.hasNext()){
     str=read.nextLine();
     //str= new String(str.getBytes(),"UTF-8");
        //out.println(str);
         //writ.append(str+"\n");
        
System.out.println(str+"  : "+Str.compareTo(str)+" EQUALS :"+Str.equals(str));
if(rs==0&&Str.equals(str))     {
    rs=1;
    System.out.println("Deleted:"+str);
    }
else{
    out.println(str);
    
}
 }
 
 read.close();
 out.close();
 //writ.flush();
//}
fl1 = new File(baseadd+"/"+filename);
if(fl1.exists())
fl1.delete();
read = new Scanner(new File(baseadd+"/temp.txt"),"UTF-8");
out = new PrintWriter(new OutputStreamWriter(new FileOutputStream(baseadd+"/"+filename), "UTF-8"));
//PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(baseadd+"/tmp.txt")));

/*try ( 
                              BufferedWriter writ = Files.newBufferedWriter(Paths.get(baseadd+"/"+filename), StandardCharsets.UTF_8,StandardOpenOption.CREATE);
                              
        ) {*/
//#########################################################

    //  Start Start Start Start

 while(read.hasNext()){
str=read.nextLine();
    out.println(str);
    //writ.append(str+"\n");
    
 }
 read.close();
 out.close();
 //writ.flush();
//}

    }






}
