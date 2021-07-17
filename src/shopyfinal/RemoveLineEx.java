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
public class RemoveLineEx {
   // public static void main(String[] arg) throws IOException{
        public static void mainn(String baseadd , String filename , String Str,int feskpl ) throws FileNotFoundException, IOException{
        
      

File fl1 = new File(baseadd+"/tmp.txt");
if(fl1.exists())
fl1.delete();
Scanner read ;
            read = new Scanner(new File(baseadd+"/"+filename),"UTF-8");
            read.useDelimiter("\\n");
            System.out.println("Removed Linev Add :"+baseadd+"/"+filename);
PrintWriter out = new PrintWriter(new OutputStreamWriter(new FileOutputStream(baseadd+"/tmp.txt"), "UTF-8"));
String str ;
int ct =0;
int rs=0;

//#########################################################
    
 while(read.hasNext()){
     //str= new String(str.getBytes(),"UTF-8");
     str=read.nextLine();
     if(++ct<=feskpl){
         out.println(str);
         continue;
     }
//System.out.println(str+"  : "+Str.compareTo(str));
if(rs==0&&Str.equalsIgnoreCase(str))     {
    rs=1;
    System.out.println("Line remved :"+str);
    }
else{
    out.println(str);
    //writ.append(str+"\n");
    
}
 }
 
 read.close();
 out.close();
 //writ.flush();

fl1 = new File(baseadd+"/"+filename);
if(fl1.exists())
    fl1.delete();

read = new Scanner(new File(baseadd+"/tmp.txt"),"UTF-8");
out = new PrintWriter(new OutputStreamWriter(new FileOutputStream(baseadd+"/"+filename), "UTF-8"));

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
System.out.println("Created Succeefully: "+baseadd+"/"+filename);
    }






}
