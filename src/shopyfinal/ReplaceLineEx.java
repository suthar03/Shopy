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
public class ReplaceLineEx {
   // public static void main(String[] arg) throws IOException{
        public static void mainn(String baseadd , String filename , String Str,String newstr , int feskpl ) throws FileNotFoundException, IOException{
        File fl=new File(baseadd+"/tmp.txt");
        if(fl.exists()){
            fl.delete();
        }
        int rs=0;
       Scanner in = new Scanner(new File(baseadd+"/"+filename),"UTF-8");

PrintWriter out = new PrintWriter(new OutputStreamWriter(new FileOutputStream(baseadd+"/tmp.txt"), "UTF-8"));

String str ;
int ct =0;
//#########################################################

    //  Start Start Start Start
//TextIO.putln("InREmove");
 while(in.hasNext()){
//TextIO.putln(Str.compareTo(str));
     str=in.nextLine();
     if(++ct<=feskpl){
         out.println(str);
        //writ.append(str+"\n");
      continue;
     }
//if((Str.compareTo(str)==1&&rs==0)||(Str.equals(str)&&rs==0))     {
     if((Str.equals(str)&&rs==0)){
    rs=1;
    System.out.println("Replced Line"+"\n Older :"+str+"\n Newer :"+newstr);
    out.println(newstr);
    //writ.append(newstr+"\n");
   
    }
else{
    out.println(str);
    
}
 }
 in.close();
 out.close();
 //writ.flush();
//}
fl=new File(baseadd+"/"+filename);
        if(fl.exists()){
            fl.delete();
        }
out = new PrintWriter(new OutputStreamWriter(new FileOutputStream(baseadd+"/"+filename), "UTF-8"));
in = new Scanner(new File(baseadd +"/tmp.txt"),"UTF-8");
/*try ( 
                              BufferedWriter writ = Files.newBufferedWriter(Paths.get(baseadd+"/"+filename), StandardCharsets.UTF_8,StandardOpenOption.CREATE);
                              
        ) {*/
while(in.hasNext()){
    
    str=in.nextLine();
    out.println(str);
    //writ.append(str+"\n");
}
in.close();
out.close();
//writ.flush();
//}

    }






}
