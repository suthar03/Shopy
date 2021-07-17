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
public class RemoveLineEx21 {
   // public static void main(String[] arg) throws IOException{
        public static void mainn(String baseadd , String filename , String Str,int feskpl ) throws FileNotFoundException, IOException{
        
        int rs=0;
      File fl=new File(baseadd+"/tmp.txt");
      if(fl.exists()){
          fl.delete();
      }
Scanner in = new Scanner(new File(baseadd+"/"+filename),"UTF-8");
PrintWriter out = new PrintWriter(new OutputStreamWriter(new FileOutputStream(baseadd+"/tmp.txt"), "UTF-8"));//out = new PrintWriter(new BufferedWriter(new FileWriter(baseadd+"/tmp.txt"),));
String str ;

int ct =0;
/*try ( 
                              //BufferedWriter writ = Files.newBufferedWriter(Paths.get(baseadd+"/tmp.txt"), StandardCharsets.UTF_8,StandardOpenOption.CREATE);
                              
        ) {*/
//#########################################################
    //  Start Start Start Start
//TextIO.putln("InREmove");
 while(in.hasNext()){
     str=in.nextLine();
     if(++ct<=feskpl){
     out.println(str);
         //writ.append(str+"\n");
         continue;
     }
     System.out.println();
System.out.println(Str.compareTo(str)+"----"+str);
if(rs==0&&Str.equalsIgnoreCase(str))     {
    rs=1;
    System.out.println("Deleted::: "+str);
    }
else{
    out.println(str);
    //writ.append(str+"\n");
          
    
    //break;
    //out.println(newstr);
}
 }
 in.close();
 out.close();
//writ.flush();
       // }
fl=new File(baseadd+"/"+filename);
      if(fl.exists()){
          fl.delete();
      }

in = new Scanner(new File(baseadd +"/tmp.txt"),"UTF-8");
//out = new PrintWriter(new BufferedWriter ( new FileWriter(baseadd+"/"+filename)));
out = new PrintWriter(new OutputStreamWriter(new FileOutputStream(baseadd+"/"+filename), "UTF-8"));
/*try ( 
                              //BufferedWriter writ = Files.newBufferedWriter(Paths.get(baseadd+"/"+filename), StandardCharsets.UTF_8,StandardOpenOption.CREATE);
                              
        ) {*/
while(in.hasNext()){
    //out.println(str);
    str=in.nextLine();
    //writ.append(str+"\n");
    out.println(str);
}
in.close();
out.close();
//writ.flush();

        }
   // }






}
