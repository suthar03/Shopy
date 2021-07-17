/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package shopyfinal;

import java.io.File;

/**
 *
 * @author Suthar
 */
public class dirCreate {
    public static void mainn(String address , String filename){
        String data = address;
        data  =data +  "/";
        data  =data + filename;
        File theDir = new File(data);
        
// if the directory does not exist, create it
if (!theDir.exists()) {
    //System.out.println("creating directory: " );
   boolean result = false;

    try{
        theDir.mkdir();
        //new File("C:/Users/Suthar/Desktop/directory").mkdir();
        result = true;
    }
    catch(SecurityException se){
        //handle it
    }
   
    
}

    //errmessage.mainn("File Already exist", 300, 200);
    //System.out.println("Already Exist");
    }

}
