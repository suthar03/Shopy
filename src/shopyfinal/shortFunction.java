/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shopyfinal;

import java.awt.Font;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 *
 * @author Suthar
 */
public class shortFunction {
     private static final long MILLIS_IN_A_DAY = 1000 * 60 * 60 * 24;
     private static Date findNextDay(Date date){
        return new Date(date.getTime() + MILLIS_IN_A_DAY);
    }
     private static Date findPrevDay(Date date)
    {
        return new Date(date.getTime() - MILLIS_IN_A_DAY);
    }
    public static String stringl(String A,int sz){
    String B = null;
    int si = A.length();
    if(sz<si)
        B = A.substring(0, sz);
    else{
        B=A;
        for(int sp=0;sp<sz-si;++sp){
            B=B+" ";
        }
    }
     return B;
}
    public static String stringc(String A,int sz){
    String B ;
    int si = A.length();
    if(sz<si)
        B = A.substring(0, sz);
    else{
        B=A;
        for(int sp=0;sp<0.5*(sz-si);++sp){
            B=" "+B;
        }
    }
    //System.out.println("b:"+B+"/nA="+A);
    //System.out.println("Sz:"+sz+"/nsi="+si);
        return B;
}
public static String stringr(String A,int sz){
    String B ;
    int si = A.length();
    if(sz<si)
        B = A.substring(0, sz);
    else{
        B=A;
        for(int sp=0;sp<(sz-si);++sp){
            B=" "+B;
        }
    }
    //System.out.println("b:"+B+"/nA="+A);
    //System.out.println("Sz:"+sz+"/nsi="+si);
        return B;
}
public static boolean isnumeric(String tocheck){
    if(tocheck==null){
        return false;
    }
    try{
        double d =Double.parseDouble(tocheck);
    }catch(NumberFormatException nfe){
        return false;
    }
    return true;
}
public static String YearID(String A,String B){
    String res="";
    res = A.substring(6, 10);
    res = res+ A.substring(3, 5);
    res = res+ A.substring(0, 2);
    res = res+'-';
    res = res+ B.substring(6, 10);
    res = res+ B.substring(3, 5);
    res = res+ B.substring(0, 2);
    
        return res;
}

public static boolean isAlready(String A,String B,String AddY){
    File f = new File(AddY);
    System.out.println(A+" :: "+B+" "+AddY);
    if(f.exists()){
        Scanner inread;
        System.out.println(" File Already");
        try {
        inread = new Scanner(f,"UTF-8"); // to get the name of customer
        inread.useDelimiter(",|\\n");
      
      while(inread.hasNext()){
          inread.next();
          String str1 = inread.next();
          String str2 = inread.next();
      System.out.println("str1: "+str1);
      System.out.println("str2: "+str2.substring(0, str2.length()-1)+":");
      str2 = str2.substring(0, str2.length()-1);
      if(DateInBetween.mainn(str1, A, str2)||DateInBetween.mainn(str1, B, str2))
          return true;
      
      }
       inread.close();   
    } catch (FileNotFoundException ex) {
        System.out.println("We are facing some issue");
    }
        
    }
    return false;
}
public static boolean isYear_ID_Already(String A,String B){
    File f = new File(B);
    if(f.exists()){
        Scanner inread;
        System.out.println(" File Yearly");
        try {
        inread = new Scanner(new File(B),"UTF-8"); // to get the name of customer
        inread.useDelimiter(",|\\n");
      
      while(inread.hasNext()){
      String cmcode = inread.next();
      System.out.println(cmcode);
      boolean b = cmcode.equalsIgnoreCase(A);
      if(b)
          return true;
      inread.nextLine();
      }
       inread.close();   
    } catch (FileNotFoundException ex) {
        System.out.println("We are facing some issue");
    }
        
    }
    return false;
}
public static boolean YearSetup(String baseuser,String Yr_ID){
    
    File theDir = new File(baseuser+"/"+Yr_ID);
    if(theDir.exists()){
         JLabel label = new JLabel("This Year Directory already existing");
                        label.setFont(new Font("Arial", Font.BOLD, 18));
                        JOptionPane.showMessageDialog(null,label,"ERROR",JOptionPane.ERROR_MESSAGE);
        System.exit(0);
    }
                        dirCreate.mainn(baseuser,Yr_ID);
                         dirCreate.mainn(baseuser+"/"+Yr_ID,"Party");
                         dirCreate.mainn(baseuser+"/"+Yr_ID,"Customer");
                         dirCreate.mainn(baseuser+"/"+Yr_ID,"Item");
                         baseuser = baseuser+"/"+Yr_ID;
                         try {
                        PrintWriter out ;//= new PrintWriter(new BufferedWriter(new FileWriter(nbaseadd+"/setting.txt", true)));
                        out = new PrintWriter(new OutputStreamWriter(new FileOutputStream(baseuser+"/Customer/customer.txt", true), "UTF-8"));
                        out.close();
                        } catch (IOException p) {
                            JLabel label = new JLabel("Default Setting not added!!! Error0005"+p);
                        label.setFont(new Font("Arial", Font.BOLD, 18));
                        JOptionPane.showMessageDialog(null,label,"ERROR",JOptionPane.ERROR_MESSAGE);
                        }
                         try {
                        PrintWriter out ;//= new PrintWriter(new BufferedWriter(new FileWriter(nbaseadd+"/setting.txt", true)));
                        out = new PrintWriter(new OutputStreamWriter(new FileOutputStream(baseuser+"/Party/party.txt", true), "UTF-8"));
                        out.close();
                        } catch (IOException p) {
                            JLabel label = new JLabel("Default Setting not added!!! Error0005"+p);
                        label.setFont(new Font("Arial", Font.BOLD, 18));
                        JOptionPane.showMessageDialog(null,label,"ERROR",JOptionPane.ERROR_MESSAGE);
                        }
                         
                         try {
                        PrintWriter out ;//= new PrintWriter(new BufferedWriter(new FileWriter(nbaseadd+"/setting.txt", true)));
                        out = new PrintWriter(new OutputStreamWriter(new FileOutputStream(baseuser+"/Item/item.txt", true), "UTF-8"));
                        out.close();
                        } catch (IOException p) {
                            JLabel label = new JLabel("Default Setting not added!!! Error0005"+p);
                        label.setFont(new Font("Arial", Font.BOLD, 18));
                        JOptionPane.showMessageDialog(null,label,"ERROR",JOptionPane.ERROR_MESSAGE);
                        }
                         
                          try {
                        PrintWriter out ;//= new PrintWriter(new BufferedWriter(new FileWriter(nbaseadd+"/setting.txt", true)));
                        out = new PrintWriter(new OutputStreamWriter(new FileOutputStream(baseuser+"/Customer/setting.txt", true), "UTF-8"));
                        out.println("cash");
                        out.println("Cash Replaced");
                        out.println(1);
                        out.println("true");
                        out.println(0);
                        out.println(0);
                        out.println("Self");
                        out.println("true");
                        out.close();
                        } catch (IOException p) {
                            JLabel label = new JLabel("Default Setting not added!!! Error0005"+p);
                        label.setFont(new Font("Arial", Font.BOLD, 18));
                        JOptionPane.showMessageDialog(null,label,"ERROR",JOptionPane.ERROR_MESSAGE);
    //errmessage.mainn(, 400, 200);
}
                          
                           try {
                        PrintWriter out ;//= new PrintWriter(new BufferedWriter(new FileWriter(nbaseadd+"/setting.txt", true)));
                        out = new PrintWriter(new OutputStreamWriter(new FileOutputStream(baseuser+"/Party/setting.txt", true), "UTF-8"));
                        out.println("cash");
                        out.println("Cash Replaced");
                        out.println(1);
                        out.println("true");
                        out.println(0);
                        out.println(0);
                        out.println("Self");
                        out.println("true");
                        out.close();
                        } catch (IOException p) {
                            JLabel label = new JLabel("Default Setting not added!!! Error0005"+p);
                        label.setFont(new Font("Arial", Font.BOLD, 18));
                        JOptionPane.showMessageDialog(null,label,"ERROR",JOptionPane.ERROR_MESSAGE);
    //errmessage.mainn(, 400, 200);
}
                         
                           try {
                        PrintWriter out;// = new PrintWriter(new BufferedWriter(new FileWriter(nbaseadd+"/sdata.txt", true)));
                        out = new PrintWriter(new OutputStreamWriter(new FileOutputStream(baseuser+"/Item"+"/"+ "/itemmust.txt"), "UTF-8"));
                        out.println("false");
                        out.println("XYZ");
                        out.println(1);
                        out.close();
                        } catch (IOException p) {
                            JLabel label = new JLabel("Info of Shop is not Saved !!! Error0005"+p);
                        label.setFont(new Font("Arial", Font.BOLD, 18));
                        JOptionPane.showMessageDialog(null,label,"ERROR",JOptionPane.ERROR_MESSAGE);
    //errmessage.mainn(, 400, 200);
}
                           try {
                        PrintWriter out;// = new PrintWriter(new BufferedWriter(new FileWriter(nbaseadd+"/sdata.txt", true)));
                        out = new PrintWriter(new OutputStreamWriter(new FileOutputStream(baseuser+"/Item"+"/"+ "/itemp.txt"), "UTF-8"));
                        out.close();
                        } catch (IOException p) {
                            JLabel label = new JLabel("Info of Shop is not Saved !!! Error0005"+p);
                        label.setFont(new Font("Arial", Font.BOLD, 18));
                        JOptionPane.showMessageDialog(null,label,"ERROR",JOptionPane.ERROR_MESSAGE);
    //errmessage.mainn(, 400, 200);
}
    
    
    return true;
}
public static boolean YearSetupWhileCreating(String baseuser,String IDyear,String Syear,String Eyear,String Curr_IDyear){
    System.out.println("We have to impliment this");
    SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
    String Prev_Date="01/01/2019";
         try {
             Prev_Date = dateFormat.format(findPrevDay(new SimpleDateFormat("dd/MM/yyyy").parse(Syear)));
         } catch (ParseException ex) {
             System.out.println("There is Issue while movig to previous date");
             Logger.getLogger(shortFunction.class.getName()).log(Level.SEVERE, null, ex);
         }
   System.out.println("Syear: "+Syear);      
   System.out.println("Prev: "+Prev_Date);
   
        File theDir = new File(baseuser+"/"+IDyear);
    if(theDir.exists()){
         JLabel label = new JLabel("This Year Directory already existing");
                        label.setFont(new Font("Arial", Font.BOLD, 18));
                        JOptionPane.showMessageDialog(null,label,"ERROR",JOptionPane.ERROR_MESSAGE);
        System.exit(0);
    }
                        dirCreate.mainn(baseuser,IDyear);
                         dirCreate.mainn(baseuser+"/"+IDyear,"Party");
                         dirCreate.mainn(baseuser+"/"+IDyear,"Customer");
                         dirCreate.mainn(baseuser+"/"+IDyear,"Item");
                         String newBaseUser = baseuser+"/"+IDyear;
                         String oldBaseUser = baseuser+"/"+Curr_IDyear;
                         
                         Scanner Sc;
                         
                         File fl =  new File(oldBaseUser+"/Customer/customer.txt");
                         System.out.println(oldBaseUser+"/Customer/customer.txt  0");
                         if(fl.exists()){
                             System.out.println(newBaseUser+"/Customer/customer.txt  1");
                             try {
                        PrintWriter out ;
                        out = new PrintWriter(new OutputStreamWriter(new FileOutputStream(newBaseUser+"/Customer/customer.txt", true), "UTF-8"));
                        Sc = new Scanner(fl,"UTF-8");
                        while(Sc.hasNext()){
                            String str = Sc.nextLine();
                            out.println(str);
                            System.out.println("For Customer Called "+str);
                            //Update Profile for This Customer
                            if(ForCustomer(oldBaseUser+"/Customer",newBaseUser+"/Customer",str,Prev_Date,Syear)){
                                System.out.println(" We have done for Customer Successfully");
                            }else return false;
                        }
                        Sc.close();
                        out.close();
                        } catch (IOException p) {
                            JLabel label = new JLabel("Default Setting not added!!! Error0005"+p);
                        label.setFont(new Font("Arial", Font.BOLD, 18));
                        JOptionPane.showMessageDialog(null,label,"ERROR",JOptionPane.ERROR_MESSAGE);
                        }
                         }else{
                         
                         try {
                        PrintWriter out ;
                        out = new PrintWriter(new OutputStreamWriter(new FileOutputStream(newBaseUser+"/Customer/customer.txt", true), "UTF-8"));
                        out.close();
                        } catch (IOException p) {
                            JLabel label = new JLabel("Default Setting not added!!! Error0005"+p);
                        label.setFont(new Font("Arial", Font.BOLD, 18));
                        JOptionPane.showMessageDialog(null,label,"ERROR",JOptionPane.ERROR_MESSAGE);
                        }
                        }
                        
                        fl =  new File(oldBaseUser+"/Party/party.txt");
                         if(fl.exists()){
                             try {
                        PrintWriter out ;
                        out = new PrintWriter(new OutputStreamWriter(new FileOutputStream(newBaseUser+"/Party/party.txt", true), "UTF-8"));
                        Sc = new Scanner(fl,"UTF-8");
                        while(Sc.hasNext()){
                            String str = Sc.nextLine();
                            out.println(str);
                            //Update Profile for This Supplier
                            if(ForParty(oldBaseUser+"/Party",newBaseUser+"/Party",str,Prev_Date,Syear)){
                                System.out.println(" We have done for Suppliers Successfully");
                            }else return false;
                        }
                        Sc.close();
                        out.close();
                        } catch (IOException p) {
                            JLabel label = new JLabel("Default Setting not added!!! Error0005"+p);
                        label.setFont(new Font("Arial", Font.BOLD, 18));
                        JOptionPane.showMessageDialog(null,label,"ERROR",JOptionPane.ERROR_MESSAGE);
                        }
                         }else{
                         
                         try {
                        PrintWriter out ;//= new PrintWriter(new BufferedWriter(new FileWriter(nbaseadd+"/setting.txt", true)));
                        out = new PrintWriter(new OutputStreamWriter(new FileOutputStream(newBaseUser+"/Party/party.txt", true), "UTF-8"));
                        out.close();
                        } catch (IOException p) {
                            JLabel label = new JLabel("Default Setting not added!!! Error0005"+p);
                        label.setFont(new Font("Arial", Font.BOLD, 18));
                        JOptionPane.showMessageDialog(null,label,"ERROR",JOptionPane.ERROR_MESSAGE);
                        }
                        } 
                         
                        fl =  new File(oldBaseUser+"/Item/item.txt");
                        if(fl.exists()){
                             try {
                        PrintWriter out ;//= new PrintWriter(new BufferedWriter(new FileWriter(nbaseadd+"/setting.txt", true)));
                        out = new PrintWriter(new OutputStreamWriter(new FileOutputStream(newBaseUser+"/Item/item.txt", true), "UTF-8"));
                        Sc = new Scanner(fl,"UTF-8");
                        while(Sc.hasNext()){
                            String str = Sc.nextLine();
                            out.println(str);
                            //Update Profile for This Supplier
                            if(ForItem(oldBaseUser+"/Item",newBaseUser+"/Item",str,Prev_Date,Syear)){
                                System.out.println(" We have done for Suppliers Successfully");
                            }else return false;
                        }
                        Sc.close();
                        out.close();
                        } catch (IOException p) {
                            JLabel label = new JLabel("Default Setting not added!!! Error0005"+p);
                        label.setFont(new Font("Arial", Font.BOLD, 18));
                        JOptionPane.showMessageDialog(null,label,"ERROR",JOptionPane.ERROR_MESSAGE);
                        }
                         }else{
                         
                         try {
                        PrintWriter out ;//= new PrintWriter(new BufferedWriter(new FileWriter(nbaseadd+"/setting.txt", true)));
                        out = new PrintWriter(new OutputStreamWriter(new FileOutputStream(newBaseUser+"/Item/item.txt", true), "UTF-8"));
                        out.close();
                        } catch (IOException p) {
                            JLabel label = new JLabel("Default Setting not added!!! Error0005"+p);
                        label.setFont(new Font("Arial", Font.BOLD, 18));
                        JOptionPane.showMessageDialog(null,label,"ERROR",JOptionPane.ERROR_MESSAGE);
                        }
                        } 
                         
                        fl =  new File(oldBaseUser+"/Customer/setting.txt");
                        if(fl.exists()){
                             try {
                        PrintWriter out ;//= new PrintWriter(new BufferedWriter(new FileWriter(nbaseadd+"/setting.txt", true)));
                        out = new PrintWriter(new OutputStreamWriter(new FileOutputStream(newBaseUser+"/Customer/setting.txt", true), "UTF-8"));
                        Sc = new Scanner(fl,"UTF-8");
                        while(Sc.hasNext()){
                            String str = Sc.nextLine();
                            out.println(str);
                        }
                        Sc.close();
                        out.close();
                        } catch (IOException p) {
                            JLabel label = new JLabel("Default Setting not added!!! Error0005"+p);
                        label.setFont(new Font("Arial", Font.BOLD, 18));
                        JOptionPane.showMessageDialog(null,label,"ERROR",JOptionPane.ERROR_MESSAGE);
                        }
                         }else{
                         
                         try {
                        PrintWriter out ;//= new PrintWriter(new BufferedWriter(new FileWriter(nbaseadd+"/setting.txt", true)));
                        out = new PrintWriter(new OutputStreamWriter(new FileOutputStream(newBaseUser+"/Customer/setting.txt", true), "UTF-8"));
                        out.println("cash");
                        out.println("Cash Replaced");
                        out.println(1);
                        out.println("true");
                        out.println(0);
                        out.println(0);
                        out.println("Self");
                        out.println("false");
                        out.close();
                        } catch (IOException p) {
                            JLabel label = new JLabel("Default Setting not added!!! Error0005"+p);
                        label.setFont(new Font("Arial", Font.BOLD, 18));
                        JOptionPane.showMessageDialog(null,label,"ERROR",JOptionPane.ERROR_MESSAGE);
                        }
                        }
                         
                        fl =  new File(oldBaseUser+"/Party/setting.txt");
                        if(fl.exists()){
                             try {
                        PrintWriter out ;//= new PrintWriter(new BufferedWriter(new FileWriter(nbaseadd+"/setting.txt", true)));
                        out = new PrintWriter(new OutputStreamWriter(new FileOutputStream(newBaseUser+"/Party/setting.txt", true), "UTF-8"));
                        Sc = new Scanner(fl,"UTF-8");
                        while(Sc.hasNext()){
                            String str = Sc.nextLine();
                            out.println(str);
                        }
                        Sc.close();
                        out.close();
                        } catch (IOException p) {
                            JLabel label = new JLabel("Default Setting not added!!! Error0005"+p);
                        label.setFont(new Font("Arial", Font.BOLD, 18));
                        JOptionPane.showMessageDialog(null,label,"ERROR",JOptionPane.ERROR_MESSAGE);
                        }
                         }else{
                         
                         try {
                        PrintWriter out ;//= new PrintWriter(new BufferedWriter(new FileWriter(nbaseadd+"/setting.txt", true)));
                        out = new PrintWriter(new OutputStreamWriter(new FileOutputStream(newBaseUser+"/Party/setting.txt", true), "UTF-8"));
                        out.println("cash");
                        out.println("Cash Replaced");
                        out.println(1);
                        out.println("true");
                        out.println(0);
                        out.println(0);
                        out.println("Self");
                        out.println("false");
                        out.close();
                        } catch (IOException p) {
                            JLabel label = new JLabel("Default Setting not added!!! Error0005"+p);
                        label.setFont(new Font("Arial", Font.BOLD, 18));
                        JOptionPane.showMessageDialog(null,label,"ERROR",JOptionPane.ERROR_MESSAGE);
                        }
                        } 
                        
                        fl =  new File(oldBaseUser+"/Item/itemmust.txt");
                        if(fl.exists()){
                             try {
                        PrintWriter out ;//= new PrintWriter(new BufferedWriter(new FileWriter(nbaseadd+"/setting.txt", true)));
                        out = new PrintWriter(new OutputStreamWriter(new FileOutputStream(newBaseUser+"/Item/itemmust.txt", true), "UTF-8"));
                        Sc = new Scanner(fl,"UTF-8");
                        while(Sc.hasNext()){
                            String str = Sc.nextLine();
                            out.println(str);
                        }
                        Sc.close();
                        out.close();
                        } catch (IOException p) {
                            JLabel label = new JLabel("Default Setting not added!!! Error0005"+p);
                        label.setFont(new Font("Arial", Font.BOLD, 18));
                        JOptionPane.showMessageDialog(null,label,"ERROR",JOptionPane.ERROR_MESSAGE);
                        }
                        }else{
                         
                         try {
                        PrintWriter out ;//= new PrintWriter(new BufferedWriter(new FileWriter(nbaseadd+"/setting.txt", true)));
                        out = new PrintWriter(new OutputStreamWriter(new FileOutputStream(newBaseUser+"/Item/itemmust.txt", true), "UTF-8"));
                        out.println("false");
                        out.println("XYZ");
                        out.println(1);
                        out.close();
                        } catch (IOException p) {
                            JLabel label = new JLabel("Default Setting not added!!! Error0005"+p);
                        label.setFont(new Font("Arial", Font.BOLD, 18));
                        JOptionPane.showMessageDialog(null,label,"ERROR",JOptionPane.ERROR_MESSAGE);
                        } 
                        }
                        fl =  new File(oldBaseUser+"/Item/itemp.txt");
                        if(fl.exists()){
                             try {
                        PrintWriter out ;//= new PrintWriter(new BufferedWriter(new FileWriter(nbaseadd+"/setting.txt", true)));
                        out = new PrintWriter(new OutputStreamWriter(new FileOutputStream(newBaseUser+"/Item/itemp.txt", true), "UTF-8"));
                        Sc = new Scanner(fl,"UTF-8");
                        while(Sc.hasNext()){
                            String str = Sc.nextLine();
                            out.println(str);
                        }
                        Sc.close();
                        out.close();
                        } catch (IOException p) {
                            JLabel label = new JLabel("Default Setting not added!!! Error0005"+p);
                        label.setFont(new Font("Arial", Font.BOLD, 18));
                        JOptionPane.showMessageDialog(null,label,"ERROR",JOptionPane.ERROR_MESSAGE);
                        }
                        }else{
                         
                         try {
                        PrintWriter out ;//= new PrintWriter(new BufferedWriter(new FileWriter(nbaseadd+"/setting.txt", true)));
                        out = new PrintWriter(new OutputStreamWriter(new FileOutputStream(newBaseUser+"/Item/itemp.txt", true), "UTF-8"));
                        out.close();
                        } catch (IOException p) {
                            JLabel label = new JLabel("Default Setting not added!!! Error0005"+p);
                        label.setFont(new Font("Arial", Font.BOLD, 18));
                        JOptionPane.showMessageDialog(null,label,"ERROR",JOptionPane.ERROR_MESSAGE);
                        }  
                        }
    
    
    return true;
}

public static boolean ForCustomer(String CMRaddold,String CMRaddnew,String Code,String Prev_date,String Syr){
                         // Creating all required Directory
    System.out.println("CMRaddold "+CMRaddold);
    System.out.println("CMRaddnew "+CMRaddnew);
                         dirCreate.mainn(CMRaddnew,Code);
                         dirCreate.mainn(CMRaddnew+"/"+Code,"Cash");
                         dirCreate.mainn(CMRaddnew+"/"+Code,"Pending");
                         dirCreate.mainn(CMRaddnew+"/"+Code+"/Cash","Given");
                         dirCreate.mainn(CMRaddnew+"/"+Code+"/Cash","Taken");
                         dirCreate.mainn(CMRaddnew+"/"+Code+"/Pending","Given");
                         dirCreate.mainn(CMRaddnew+"/"+Code+"/Pending","Taken");
                         
                         String ProAddnew = CMRaddnew+"/"+Code;
                         String ProAddold = CMRaddold+"/"+Code;
                         
                         // Find Current status of Customer on Date Prev_Date
                         float csts = CurrentStatus(CMRaddold,Code,Prev_date);
                         System.out.println("csts :"+csts+" of code:"+Code);
                         // Now Create Profile file;
                         System.out.println("ProAddOld :"+ProAddold+"/profile.txt");
                         System.out.println("ProAddnew :"+ProAddnew+"/profile.txt");
                         File fl =  new File(ProAddold+"/profile.txt");
                         try {
                        PrintWriter out ;
                        out = new PrintWriter(new OutputStreamWriter(new FileOutputStream(ProAddnew+"/profile.txt", true), "UTF-8"));
                        Scanner Sc = new Scanner(fl,"UTF-8");
                        out.println((Sc.nextLine()));
                        out.println((Sc.nextLine()));
                        out.println((Sc.nextLine()));
                        out.println((Sc.nextLine()));
                        out.println((Sc.nextLine()));
                        out.println(String.valueOf(csts)); // Updating Status of Syr or upto Prev_date
                        out.println(Syr);
                        Sc.close();
                        out.close();
                        } catch (IOException p) {
                        JLabel label = new JLabel("Error While Creating new Profile of Code"+Code+"  "+p);
                        label.setFont(new Font("Arial", Font.BOLD, 18));
                        JOptionPane.showMessageDialog(null,label,"ERROR",JOptionPane.ERROR_MESSAGE);
                        }
                         try {
                        PrintWriter out ;//= new PrintWriter(new BufferedWriter(new FileWriter(nbaseadd+"/setting.txt", true)));
                        out = new PrintWriter(new OutputStreamWriter(new FileOutputStream(ProAddnew+"/Pending/Given/"+NamingDateName.mainn(Syr)+".txt", true), "UTF-8"));
                        out.println(String.valueOf(-1*csts));
                        out.println("0.0");
                        out.close();
                        } catch (IOException p) {
                        JLabel label = new JLabel("Error While Creating new Profile of Code"+Code+"  "+p);
                        label.setFont(new Font("Arial", Font.BOLD, 18));
                        JOptionPane.showMessageDialog(null,label,"ERROR",JOptionPane.ERROR_MESSAGE);
                        }
                        
                         
    return true;
}
public static boolean ForParty(String PRTaddold,String PRTaddnew,String Code,String Prev_date,String Syr){
                         // Creating all required Directory
    System.out.println("PRTaddold "+PRTaddold);
    System.out.println("PRTaddnew "+PRTaddnew);
                         dirCreate.mainn(PRTaddnew,Code);
                         dirCreate.mainn(PRTaddnew+"/"+Code,"Cash");
                         dirCreate.mainn(PRTaddnew+"/"+Code,"Pending");
                         dirCreate.mainn(PRTaddnew+"/"+Code+"/Cash","Given");
                         dirCreate.mainn(PRTaddnew+"/"+Code+"/Cash","Taken");
                         dirCreate.mainn(PRTaddnew+"/"+Code+"/Pending","Given");
                         dirCreate.mainn(PRTaddnew+"/"+Code+"/Pending","Taken");
                         
                         String ProAddnew = PRTaddnew+"/"+Code;
                         String ProAddold = PRTaddold+"/"+Code;
                         
                         // Find Current status of Customer on Date Prev_Date
                         float csts = CurrentStatus(PRTaddold,Code,Prev_date);
                         System.out.println("csts :"+csts+" of code:"+Code);
                         // Now Create Profile file;
                         System.out.println("ProAddOld :"+ProAddold+"/profile.txt");
                         System.out.println("ProAddnew :"+ProAddnew+"/profile.txt");
                         File fl =  new File(ProAddold+"/profile.txt");
                         try {
                        PrintWriter out ;
                        out = new PrintWriter(new OutputStreamWriter(new FileOutputStream(ProAddnew+"/profile.txt", true), "UTF-8"));
                        Scanner Sc = new Scanner(fl,"UTF-8");
                        out.println((Sc.nextLine()));
                        out.println((Sc.nextLine()));
                        out.println((Sc.nextLine()));
                        out.println((Sc.nextLine()));
                        out.println((Sc.nextLine()));
                        out.println(String.valueOf(csts)); // Updating Status of Syr or upto Prev_date
                        out.println(Syr);
                        Sc.close();
                        out.close();
                        } catch (IOException p) {
                        JLabel label = new JLabel("Error While Creating new Profile of Code"+Code+"  "+p);
                        label.setFont(new Font("Arial", Font.BOLD, 18));
                        JOptionPane.showMessageDialog(null,label,"ERROR",JOptionPane.ERROR_MESSAGE);
                        }
                         try {
                        PrintWriter out ;//= new PrintWriter(new BufferedWriter(new FileWriter(nbaseadd+"/setting.txt", true)));
                        out = new PrintWriter(new OutputStreamWriter(new FileOutputStream(ProAddnew+"/Pending/Given/"+NamingDateName.mainn(Syr)+".txt", true), "UTF-8"));
                        out.println(String.valueOf(-1*csts));
                        out.println("0.0");
                        out.close();
                        } catch (IOException p) {
                        JLabel label = new JLabel("Error While Creating new Profile of Code"+Code+"  "+p);
                        label.setFont(new Font("Arial", Font.BOLD, 18));
                        JOptionPane.showMessageDialog(null,label,"ERROR",JOptionPane.ERROR_MESSAGE);
                        }
                        
                         
    return true;
}
public static boolean ForItem(String ITMaddold,String ITMaddnew,String Code,String Prev_date,String Syr){
                         // Creating all required Directory
    System.out.println("ITMaddold "+ITMaddold);
    System.out.println("ITMaddnew "+ITMaddnew);
                         dirCreate.mainn(ITMaddnew,Code);
                         dirCreate.mainn(ITMaddnew+"/"+Code,"Status");
                         
                         String ProAddnew = ITMaddnew+"/"+Code;
                         String ProAddold = ITMaddold+"/"+Code;
                         
                         // Find Current status of Item on Date Prev_Date
                         float csts = CurrentItemStock(ITMaddold,Code,Prev_date);
                         System.out.println("csts :"+csts+" of code:"+Code);
                         // Now Create Profile file;
                         System.out.println("ProAddOld :"+ProAddold+"/profile.txt");
                         System.out.println("ProAddnew :"+ProAddnew+"/profile.txt");
                         File fl =  new File(ProAddold+"/profile.txt");
                         try {
                        PrintWriter out ;
                        out = new PrintWriter(new OutputStreamWriter(new FileOutputStream(ProAddnew+"/profile.txt", true), "UTF-8"));
                        Scanner Sc = new Scanner(fl,"UTF-8");
                        out.println((Sc.nextLine())); //icode
                        out.println((Sc.nextLine())); //E name
                        out.println((Sc.nextLine())); //Hname
                        out.println((Sc.nextLine())); //Rate
                        Sc.nextLine(); //Intial Stock Skiping
                        out.println(String.valueOf(csts)); // Updating Status of Syr or upto Prev_date
                        out.println((Sc.nextLine())); // bool
                        out.println(Syr); //Date
                        out.println((Sc.nextLine())); // Minimum Stock
                        Sc.close();
                        out.close();
                        } catch (IOException p) {
                        JLabel label = new JLabel("Error While Creating new Profile of Code"+Code+"  "+p);
                        label.setFont(new Font("Arial", Font.BOLD, 18));
                        JOptionPane.showMessageDialog(null,label,"ERROR",JOptionPane.ERROR_MESSAGE);
                        }
                         try {
                        PrintWriter out ;//= new PrintWriter(new BufferedWriter(new FileWriter(nbaseadd+"/setting.txt", true)));
                        out = new PrintWriter(new OutputStreamWriter(new FileOutputStream(ProAddnew+"/Status/"+NamingDateName.mainn(Syr)+".txt", true), "UTF-8"));
                        out.println(String.valueOf(csts));
                        out.println("0.0");
                        out.close();
                        } catch (IOException p) {
                        JLabel label = new JLabel("Error While Creating new Profile of Code"+Code+"  "+p);
                        label.setFont(new Font("Arial", Font.BOLD, 18));
                        JOptionPane.showMessageDialog(null,label,"ERROR",JOptionPane.ERROR_MESSAGE);
                        }
                        
                         
    return true;
}

public static float CurrentStatus(String CMRadd, String cd, String prevdt){
      float crnsts=0;
       String DtAdd="01/01/2020";
        String IntialS="0"; 
        System.out.println("Currenst Add : "+CMRadd+"/"+cd+"/profile.txt");
         try {
             DtAdd = GetLine.mainn(CMRadd+"/"+cd+"/"+"/profile.txt", 7);
             IntialS = GetLine.mainn(CMRadd+"/"+cd+"/profile.txt", 6);
          } catch (IOException ex) {
             Logger.getLogger(shortFunction.class.getName()).log(Level.SEVERE, null, ex);
         }   
//#########################################################################################################################################################        
         
        
        
        
        //    Scanner read ;
        try {
            

                float  CStatus = (float) 000.00;
                String pcode,PGstr1="000.00";
                float TotalG = (float) 000.00,TotalT = (float) 000.00;
                String CGstr1 = "000.00",CTstr1 = "000.00";
      
      pcode = String.format("%04d", Integer.valueOf(cd));
      Scanner inread ;
//#########################################################################################################################################################              
               
//#########################################################################################################################################################              
      
                File tmp;boolean fs=false;
      //int counter =0;

 boolean Cexist=false;
      String dsd = NamingDate.mainn(prevdt);
      String sd = prevdt;
for(;DateInBetween.mainn(DtAdd, dsd, sd);dsd =datem15.mainn(dsd)){                             //To find the earliest Existing file
       tmp = new File(CMRadd+"/"+pcode+"/Pending/Given/"+NamingDateName.mainn(dsd)+".txt");
      fs = tmp.exists();
      //TextIO.putln(CMRadd+"/"+pcode+"/Pendng/Given/"+NamingDateName.mainn(dsd)+".txt"+"\t"+fs);
      if(fs){
          Cexist=true;
      break;
      }
}
if(!Cexist){
    CStatus=(-1)*(Float.valueOf(IntialS));
}
//########################################################################################################
tmp = new File(CMRadd+"/"+pcode+"/Pending/Given/"+NamingDateName.mainn(dsd)+".txt");
      fs = tmp.exists();
               // TextIO.putln(CMRadd+"/"+pcode+"/Pendng/Given/"+NamingDateName.mainn(dsd)+".txt"+"\t"+fs);
      if(fs){

      inread = new Scanner(tmp,"UTF-8");          // to get the name of customer
      inread.useDelimiter(",|\\n");
      PGstr1=inread.nextLine();
      inread.nextLine();
      CStatus = Float.valueOf(PGstr1);
      while(inread.hasNext()){
      String datee1=inread.next();
      if(DateInBetween.mainn(NamingDate.mainn(dsd), datee1, sd)){
      inread.next();
      inread.next();
      inread.next();
      inread.next();
      CGstr1 = inread.next();  // name of customer having code pcode
      TotalG = TotalG + Float.valueOf(CGstr1);
      }
      else
          inread.nextLine();
      }
      inread.close();
      }


      
//########################################################################################################
for(String ttd=dsd;DateInBetween.mainn(NamingDate.mainn(dsd), ttd, sd);ttd =datep15.mainn(ttd)){                             //To find the earliest Existing file
       tmp = new File(CMRadd+"/"+pcode+"/Pending/Taken/"+NamingDateName.mainn(ttd)+".txt");
      fs = tmp.exists();
      if(fs){
     inread = new Scanner(tmp,"UTF-8");          // to get the name of customer
      inread.useDelimiter(",|\\n");
      inread.nextLine();
      //inread.nextLine();
      while(inread.hasNext()){
      String datee1=inread.next();
      if(DateInBetween.mainn(NamingDate.mainn(ttd), datee1, sd)){
      inread.next();
      inread.next();
      inread.next();
      inread.next();
      CTstr1 = inread.next();                // name of customer having code pcode
      TotalT = TotalT + Float.valueOf(CTstr1);
      }
      else
          inread.nextLine();
      }
      inread.close();
      }
}
      
//########################################################################################################

      crnsts = TotalT-CStatus-TotalG;
    
//########################################################################################################
       
} catch (FileNotFoundException ex) {
            JLabel label = new JLabel("not getting access to Customer member  !!! Error0007"+ex);
            label.setFont(new Font("Arial", Font.BOLD, 18));
            JOptionPane.showMessageDialog(null,label,"ERROR",JOptionPane.WARNING_MESSAGE);
       }

      return crnsts;
  }
public static float CurrentItemStock(String ITMadd, String icode, String prevdt){
    
               
            
        try {
                float  CStatus = (float) 000.00 , TotalITM = (float) 000.00,TotalITMOnDS = (float) 000.00,TotalITMOnDB = (float) 000.00;
        
      Scanner inread ;
                File tmp = new File(ITMadd+"/"+icode+"/profile.txt");           // to get the name of item
                boolean fs = tmp.exists();
                String dt = prevdt;String str1="0";
                String tdt=dt, DtAdd="01/01/2020";
            try {
                 DtAdd = GetLine.mainn(ITMadd+"/"+icode+"/profile.txt", 7);
            } catch (IOException ex) {
                Logger.getLogger(shortFunction.class.getName()).log(Level.SEVERE, null, ex);
            }
            DtAdd = NamingDate.mainn(DtAdd);
            
            for(tdt=NamingDate.mainn(tdt);DateInBetween.mainn(DtAdd, tdt, prevdt);tdt=datem15.mainn(tdt)){
             tmp = new File(ITMadd+"/"+icode+"/Status/"+NamingDateName.mainn(tdt)+".txt");            // to get the name of item
                fs = tmp.exists();
               if(fs) break; 
            }
      
       tmp = new File(ITMadd+"/"+icode+"/Status/"+NamingDateName.mainn(tdt)+".txt");            // to get the name of item
       fs = tmp.exists();
      if(fs){
      inread = new Scanner(new File(ITMadd+"/"+icode+"/Status/"+NamingDateName.mainn(tdt)+".txt"),"UTF-8");          
      inread.useDelimiter(",|\\n");
      CStatus = Float.valueOf(inread.nextLine());
      inread.nextLine();
      while(inread.hasNext()){
      String datee=inread.next();
      if(DateInBetween.mainn(tdt, datee, dt)){
          
      inread.next();
      str1 = inread.next();                // name of item having code ccode
      inread.nextLine();
      TotalITM = TotalITM + Float.valueOf(str1);
      if(datee.equals(dt)){
          if(Float.valueOf(str1)>0)
         TotalITMOnDB=TotalITMOnDB+Float.valueOf(str1);
          else
              TotalITMOnDS=TotalITMOnDS+Float.valueOf(str1);
      }

      }
      else
          inread.nextLine();
      }
      inread.close();
      }

      
      CStatus = CStatus + TotalITM;
      return CStatus;
      
} catch (FileNotFoundException ex) {
            JLabel label = new JLabel("Item item. error !!! Error0015");
            label.setFont(new Font("Arial", Font.BOLD, 18));
            JOptionPane.showMessageDialog(null,label,"ERROR",JOptionPane.WARNING_MESSAGE);
       
        } 
        return 0;
}

public static void main(String args[]){
isAlready("27/06/2021","27/06/2021","D:\\Shopy\\Shopy\\2023/Years.txt");
}
}
