

package shopyfinal;

import com.toedter.calendar.JDateChooser;
import java.awt.AWTException;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.print.PageFormat;
import java.awt.print.Paper;
import java.awt.print.Printable;
import static java.awt.print.Printable.NO_SUCH_PAGE;
import static java.awt.print.Printable.PAGE_EXISTS;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;


public class PRTxCASHxGiven228EX2 extends javax.swing.JFrame {

String sd;
int yt=0;
 String baseadd,logo ,user,PRTadd,ITMadd;
 int amtd=0,nmlength=11,cnmlength=29;
 String Ecnam,Hcnam,DtAdd="01/01/2020",IntialS="0",lang="English";
 String blbl=" Baki",jlbl = " Jama";
    boolean prntrs=true;   
 String Sname="Unkonwn",ESname="Unkonwn",HSname="Unkonwn",Sno="1234567890";
String mode ,STRaddT,STRaddG;                   //Require for completion action
String repiname,repicode,repirate,Dway="0",Dmode="0",remm;
boolean nmedt=false;



public PRTxCASHxGiven228EX2(String base,String golo,String gh,String us) {
       baseadd=base;
       logo=golo;
        sd=gh;
        user =us;
          
        PRTadd = baseadd+"/"+user+"/party";
        ITMadd = baseadd+"/"+user+"/item";
        initComponents();
        datee.setText(sd);
        SCP.setVisible(false);
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.setLocationRelativeTo(null);
        try {
            this.setIconImage(ImageIO.read(new File(logo)));
        } catch (IOException ex) {
            JLabel label = new JLabel("Logo Problem !!! Error0001++72"+ex);
            label.setFont(new Font("Arial", Font.BOLD, 18));
            JOptionPane.showMessageDialog(this,label,"ERROR",JOptionPane.WARNING_MESSAGE);
       
        }
        
        try {
        Robot r=new Robot();
        r.keyPress(KeyEvent.VK_ALT);
        r.keyPress(KeyEvent.VK_SHIFT);
        r.keyPress(KeyEvent.VK_0);
        r.keyRelease(KeyEvent.VK_0);
        r.keyRelease(KeyEvent.VK_SHIFT);
        r.keyRelease(KeyEvent.VK_ALT);
    } catch (AWTException ex) {
        JLabel label = new JLabel("Language Setup Error !!87!!"+ex);        
        label.setFont(new Font("Arial", Font.BOLD, 18));        
        JOptionPane.showMessageDialog(this,label,"ERROR",JOptionPane.WARNING_MESSAGE);
    }
        
        
        // Getting Shop details of printer 
        
                    try {
           Scanner ot = new Scanner(new File(baseadd+"/"+user+"/sdata.txt"),"UTF-8");
                        ESname=ot.nextLine();
                        HSname=ot.nextLine();
                        Sno=ot.nextLine();
                        ot.close();
                    }
                    catch (FileNotFoundException ex) {
                        JLabel label = new JLabel("Shop Data Error !!! Error0018++103!!"+ex);
                        label.setFont(new Font("Arial", Font.BOLD, 18));
                        JOptionPane.showMessageDialog(this,label,"ERROR",JOptionPane.WARNING_MESSAGE);
                    }
        //################################
        //Language setup
        try {
        lang = GetLine.mainn(baseadd+"/"+user+"/conf.txt", 1);
        //System.out.println(lang);
        } catch (IOException ex) {
        JLabel label = new JLabel("Configuration Error !!! Error0003++113@@"+ex);
        label.setFont(new Font("Arial", Font.BOLD, 18));
        JOptionPane.showMessageDialog(this,label,"ERROR",JOptionPane.WARNING_MESSAGE);
        }
        if(lang.compareToIgnoreCase("English")!=0){
            nmlength=17;
            cnmlength=31;
            Sname=HSname;
            blbl=" बाकी";jlbl=" जमा";
              hdlbl.setText("ग्राहक लेन-देन मेन्यू");
              ccdlbl.setText("कोड :");
              cnmlbl.setText("नाम :");
              icdlbl.setText("आइटम कोड :");
              inmlbl.setText("आइटम नाम :");
              irtlbl.setText("रेट :");
              iqtylbl.setText("मात्रा :");
              iamtlbl.setText("रकम :");
              tbllbl.setText("Added आइटम लिस्टिड Below");
              add.setText("जोड़े");
              mdlbl.setText("मोड :");
              waylbl.setText("way :");
              remlbl.setText("रेमार्क :");
              cslbl.setText("वर्तमान स्थिति :");
              tamtlbl.setText("टोटल रकम :");
              dtlbl.setText("दिनांक :");
              sway.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "बेचा", "खरीदा" }));
            }else{
            Sname=ESname;
        }
        // Getting State of printer is on or off
        Scanner ot;
                    try {
                        ot = new Scanner(new File(PRTadd+"/setting.txt"),"UTF-8");
                        repicode=ot.nextLine();
                        repiname=ot.nextLine();
                        repirate=ot.nextLine();
                        prntrs = Boolean.valueOf(ot.nextLine());
                        Dway=ot.nextLine();
                        Dmode=ot.nextLine();
                        remm=ot.nextLine();
                        nmedt=Boolean.valueOf(ot.nextLine());
                        ot.close();
                        sway.setSelectedIndex(Integer.valueOf(Dway));
                        Pmode.setSelectedIndex(Integer.valueOf(Dmode));
                        rem.setText(remm);
                        name.setEditable(nmedt);
                        
                    }
                    catch (FileNotFoundException ex) {
                        JLabel label = new JLabel("Setting Error !!! Error0018++159!!!"+ex);
                        label.setFont(new Font("Arial", Font.BOLD, 18));
                        JOptionPane.showMessageDialog(this,label,"ERROR",JOptionPane.WARNING_MESSAGE);
                    }
        
code.requestFocus();
}
        public void PRTxName() throws FileNotFoundException {       // It find the name of party name with respect to Costmer code
           
        if(RepeatationIntCase.mainn(PRTadd,"party.txt" ,code.getText())==1){          //<<<<<<<<<<<<<<<<<<<Name field completion automatically
            
            Scanner read ;
            read = new Scanner(new File(PRTadd+"/"+code.getText()+"/profile.txt"),"UTF-8");
            read.useDelimiter("\\n");
            read.nextLine();
            Ecnam = read.nextLine();
            Hcnam = read.nextLine();
            if(lang.compareToIgnoreCase("English")!=0){
                name.setText(Hcnam);
            }
            else{
                name.setText(Ecnam);
            }
            read.nextLine();
            read.nextLine();
            IntialS=read.nextLine();
            DtAdd=read.nextLine();
            read.close();
            icode.requestFocus();
            float vlv=csts(code.getText());
            cnsts.setText(String.valueOf(vlv));

        }
        else{
            code.requestFocus();
         JLabel label = new JLabel("No Party with this Party Code");
                        label.setFont(new Font("Arial", Font.BOLD, 18));
                        JOptionPane.showMessageDialog(this,label,"ERROR",JOptionPane.WARNING_MESSAGE);   
        //errmessage.mainn("No Party with this Party Code", 300, 200);                                             //>>>>>>>>>>>>>>>>>>Over
        }
            
    }
        
    public boolean BPRTxName() throws FileNotFoundException {       // It find the name of party name with respect to Costmer code
            boolean re=false;
        if(RepeatationIntCase.mainn(PRTadd,"party.txt" ,code.getText())==1){          //<<<<<<<<<<<<<<<<<<<Name field completion automatically
            
            Scanner read ;
            read = new Scanner(new File(PRTadd+"/"+code.getText()+"/profile.txt"),"UTF-8");
            read.useDelimiter("\\n");
            read.nextLine();
            Ecnam = read.nextLine();
            Hcnam = read.nextLine();
            if(lang.compareToIgnoreCase("English")!=0){
                name.setText(Hcnam);
            }
            else{
                name.setText(Ecnam);
            }
            read.close();
            icode.requestFocus();
            float vlv=csts(code.getText());
            cnsts.setText(String.valueOf(vlv));
re=true;
        }
        
        return re;
            
    }

         public void close(){
        WindowEvent winClosingEvent = new WindowEvent(this , WindowEvent.WINDOW_CLOSING);
        Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(winClosingEvent);
    }
   //######################################################################################################
         public String remadder(String itmname){
             itmname+=" ";
             for(;itmname.length()<nmlength;){
                 itmname+=" ";
             }
             itmname+=rem.getText();//Iname = new String(Iname.getBytes(),"UTF-8");
             return itmname;
         }
         //################################################################################################################
          public void pcompG(){      //Pending Given
             TableModel tm = table.getModel();
        int ty=tm.getRowCount();
        if(ty>0){
    
            File tempFile = new File( PRTadd + "/" + code.getText() + STRaddG+"/" + NamingDateName.mainn(sd) + ".txt" );
            boolean exists = tempFile.exists();
            //System.out.println(exists+"____"+PRTadd + "/" + code.getText() + STRaddG+"/" + NamingDateName.mainn(sd) + ".txt");
            if(exists)              // File for that date exists then directly update the total and save data to the corresponding
            {
               //System.out.println("File is existing");
                try {
                    
                    
                   // PrintWriter out,statusout;                    // Detail stord in formate of name \n code \n add \n mob
                    // Detail stord in formate of name \n code \n add \n mob
                    ty=tm.getRowCount();
                    for (int k = 0; k < ty; k++) {
                        //out = new PrintWriter(new OutputStreamWriter(new FileOutputStream(PRTadd + "/" + code.getText() + STRaddG+"/" + NamingDateName.mainn(sd) + ".txt", true),StandardCharsets.UTF_8));
                        Object o = tm.getValueAt(k, 1);
                        String Icode = (String)o;
                        o = tm.getValueAt(k,2);
                        String  Iname = (String)o;
                        o = tm.getValueAt(k,3);
                        float Iqty = (Float)o;
                        o = tm.getValueAt(k, 4);
                        float Irate = (Float)o;
                        o = tm.getValueAt(k, 5);
                        float Iamt = (Float)o;
                        
                        
                        if(k==0)
                            Iname=remadder(Iname);
                        //Iname = new String(Iname.getBytes(),"UTF-8");
                        try {
                        /* out = new PrintWriter(new OutputStreamWriter(new FileOutputStream(PRTadd + "/" + code.getText() + STRaddG+"/" + NamingDateName.mainn(sd) + ".txt", true),StandardCharsets.UTF_8));
out.print(sd+",");
                        out.print(Icode+",");
                        out.print(Iname+",");
                        out.print(Iqty+",");
                        out.print(Irate+",");
                        out.println(Iamt);
                        out.close();   */                         

                            Path path = Paths.get(PRTadd + "/" + code.getText() + STRaddG+"/" + NamingDateName.mainn(sd) + ".txt");
      
                            BufferedWriter writer = Files.newBufferedWriter(path, StandardCharsets.UTF_8,StandardOpenOption.APPEND);
                            
                            writer.append(sd+",");
                            writer.append(Icode+",");
                            writer.append(Iname+",");
                            writer.append(Iqty+",");
                            writer.append(Irate+",");
                            writer.append(Iamt+"\n");
                            
                            writer.flush();
       
      //System.out.println("Data entered into the file");
            /*FileOutputStream outputStream = new FileOutputStream(PRTadd + "/" + code.getText() + STRaddG+"/" + NamingDateName.mainn(sd) + ".txt",true);
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream, "UTF-8");
            //FileWriter writer = new FileWriter(PRTadd + "/" + code.getText() + STRaddG+"/" + NamingDateName.mainn(sd) + ".txt",true);
            BufferedWriter bufferedWriter = new BufferedWriter(outputStreamWriter);
             
            bufferedWriter.write(sd+",");
            bufferedWriter.write(Icode+",");
            bufferedWriter.write(Iname+",");
            bufferedWriter.write(Iqty+",");
            bufferedWriter.write(Irate+",");
            bufferedWriter.write( String.valueOf(Iamt));
            bufferedWriter.newLine();
            //bufferedWriter.write("Hẹn gặp lại!");
             
            bufferedWriter.close();*/
        } catch (IOException e) {
            e.printStackTrace();
            JLabel label1 = new JLabel("File problem 308!!"+e);
                        label1.setFont(new Font("Arial", Font.BOLD, 18));
                        JOptionPane.showMessageDialog(this,label1,"ERROR",JOptionPane.WARNING_MESSAGE);   
        }
                        /*try ( 
                              BufferedWriter writ = Files.newBufferedWriter(Paths.get(PRTadd + "/" + code.getText() + STRaddG+"/" + NamingDateName.mainn(sd) + ".txt"), StandardCharsets.UTF_8,StandardOpenOption.APPEND);
                              
                   ) {
                          
                   writ.append(sd+","+Icode+",");writ.append(Iname);writ.append(","+Iqty+","+Irate+","+Iamt+"\n");
                   writ.flush();
                      }*/
                        
                        //TextIO.putln(sd+","+Icode+","+Iname+","+Iqty+","+Irate+","+Iamt);
                        /*out.print(sd+",");
                        out.print(Icode+",");
                        out.print(Iname+",");
                        out.print(Iqty+",");
                        out.print(Irate+",");
                        out.println(Iamt);
                        out.close();*/
                        //####################################################################################################
                        // Now updating stock in item of current
                        String pstck="000.0",ppstck="000.0";
                        File tmp = new File(ITMadd + "/" + Icode + "/status/" + NamingDateName.mainn(sd) + ".txt");
                        boolean bf  = tmp.exists();
                        //TextIO.putln("11111"+bf);
                        if(bf){
                         try (
                        BufferedWriter writ = Files.newBufferedWriter(Paths.get(ITMadd + "/" + Icode + "/status/" + NamingDateName.mainn(sd) + ".txt"), StandardCharsets.UTF_8,StandardOpenOption.APPEND,StandardOpenOption.CREATE);
                        
                        ) {
                        
                        writ.append(sd+","+code.getText()+","+"-"+Iqty+","+Irate+","+Iamt+","+mode+","+"Party"+"\n");
                        writ.flush();
                        }
 
                            Scanner read;
                            pstck="000.0";
                            read = new Scanner(new File(ITMadd + "/" + Icode + "/status/" + NamingDateName.mainn(sd) + ".txt"),"UTF-8");
                            read.nextLine();
                            pstck = read.nextLine();
                            read.close();
                            String nstck = "000.0";
                            nstck = String.valueOf(Float.parseFloat(pstck)-Iqty);
                            ReplaceLineWN.mainn(ITMadd + "/" + Icode + "/status",NamingDateName.mainn(sd) + ".txt", 2, String.valueOf(nstck));
                            }
                        else{
                            String dsd = NamingDate.mainn(sd);
                            int counter=0;
                            for(dsd=datem15.mainn(dsd);counter<60;dsd=datem15.mainn(dsd),counter++){
                                tmp = new File(ITMadd+"/"+Icode+"/status/"+NamingDateName.mainn(dsd)+".txt");
                                bf = tmp.exists();
                                if(bf == true)
                                    break;
                            }
                            //TextIO.putln(dsd);
                            Scanner read;
                            tmp = new File(ITMadd+"/"+Icode+"/status/"+NamingDateName.mainn(dsd)+".txt");
                            bf = tmp.exists();
                            if(bf){
                                read = new Scanner(new File(ITMadd+"/"+Icode+"/status/"+NamingDateName.mainn(dsd)+".txt"),"UTF-8");
                                ppstck= read.nextLine();
                                pstck = read.nextLine();
                                read.close();
                                }
                            else{
                                pstck = "000.0";
                                ppstck = "000.0";
                            }
                            ppstck = String.valueOf(Float.valueOf(ppstck)+Float.valueOf(pstck));
                            
                            pstck = String.valueOf(-Iqty);
                            //TextIO.putln("ppstck:"+ppstck+"   pstck:"+pstck);
                            ////TextIO.putln("Pstck    "+pstck);
                            try (
                            BufferedWriter writ = Files.newBufferedWriter(Paths.get(ITMadd + "/" + Icode + "/status/" + NamingDateName.mainn(sd) + ".txt"), StandardCharsets.UTF_8,StandardOpenOption.APPEND,StandardOpenOption.CREATE);
                            
                            ) {
                            writ.append(ppstck+"\n"+pstck+"\n");
                            writ.append(sd+","+code.getText()+","+"-"+Iqty+","+Irate+","+Iamt+","+mode+","+"Party"+"\n");
                            writ.flush();
                            //writ.flush();
                            }
                           
                        }
                        
                        
                        
                        //Over of updation of stock of item of current
                        System.out.println("Stock Updation");
//#########################################################################################################################
                        int counter =0;                     //Updating files exist after that date
                        boolean bg;
                        Scanner in ;
                        String p;
                        float stck;
                        String dsd =NamingDate.mainn(sd);
                        System.out.println("Dsd: "+dsd);
                        for(dsd = datep15.mainn(dsd);counter<60;dsd=datep15.mainn(dsd),counter++){                               //Updating all file created or having date of early created
                            System.out.println("Inside Loop");
                            tmp = new File(ITMadd+"/"+Icode+"/Status/"+NamingDateName.mainn(dsd)+".txt");
                            bg =tmp.exists();
                            if(bg){
                                //TextIO.putln(ITMadd+"/"+icode.getText()+"/Status/"+NamingDateName.mainn(dsd)+".txt");
                                in = new Scanner(tmp,"UTF-8");
                                p = in.nextLine();
                                in.close();
                                stck = Float.valueOf(p) - Iqty;
                                ReplaceLineWN.mainn(ITMadd+"/"+Icode+"/Status", NamingDateName.mainn(dsd)+".txt",1 , String.valueOf(stck));
                                System.out.println(ITMadd+"/"+Icode+"/Status/"+NamingDateName.mainn(dsd)+".txt");
                                }
                        }
//########################################################################################################################3
                    }
                    
//#########################################################################################################################3
                    //Updating totaling of that page
                    //BufferedReader in;
                    //FileReader stream = new FileReader(PRTadd + "/" + code.getText() + STRaddG+"/" + NamingDateName.mainn(sd) + ".txt");
                    Scanner in =new Scanner(new File(PRTadd + "/" + code.getText() + STRaddG+"/" + NamingDateName.mainn(sd) + ".txt"),"UTF-8"); //new BufferedReader( stream );
                    in.nextLine();
                    String str = in.nextLine();
                    in.close();
                    float ft = Float.valueOf(str);
                    itotal=Float.valueOf(total.getText());
                    ft = ft + itotal;
                    String Str = String.valueOf(ft);
                    ReplaceLineWN.mainn(PRTadd + "/" + code.getText() + STRaddG, NamingDateName.mainn(sd) + ".txt", 2,Str );
                    //Updating the exist after this date
                    int counter=0;
                    Scanner inn;
                    String pd;
                    float nd;
                    File tmp;
                    boolean bg;
                    String dsd =NamingDate.mainn(sd);
                    for(dsd = datep15.mainn(dsd);counter<60;dsd=datep15.mainn(dsd),counter++){
                        tmp=new File(PRTadd +"/" + code.getText()+ STRaddG+"/"+ NamingDateName.mainn(dsd)+".txt");
                        bg=tmp.exists();
                        if(bg){
                            inn = new Scanner(new File(PRTadd +"/" + code.getText()+ STRaddG+"/"+ NamingDateName.mainn(dsd)+".txt"),"UTF-8");
                            pd = inn.nextLine();
                            inn.close();
                            nd = Float.valueOf(pd)+itotal;
                            ReplaceLineWN.mainn(PRTadd+"/"+code.getText()+STRaddG, NamingDateName.mainn(dsd)+".txt", 1, String.valueOf(nd));
                            }
                        
                    }
                    //###########################################################################################################
                    if(prntrs){
                    printerr();
                }
                    
                   System.out.println("Here we goneeeeeeeee for printer"+prntrs);
//###########################################################################################################################3
                    DefaultTableModel dm = (DefaultTableModel)table.getModel();
                    for(int y =dm.getRowCount()-1 ;y>=0;--y)
                        dm.removeRow(y);
                    itotal = 0;
                    total.setText(String.valueOf(itotal));
                    name.setText(null);
                    i=1; 
                    rem.setText(remm);
                    sway.setSelectedIndex(Integer.valueOf(Dway));
                    Pmode.setSelectedIndex(Integer.valueOf(Dmode));
                    code.requestFocus();
                    code.selectAll();
                } catch (IOException ex) {
                    JLabel label = new JLabel("File Opening !!! Error0012++497!!"+ex);
            label.setFont(new Font("Arial", Font.BOLD, 18));
            JOptionPane.showMessageDialog(this,label,"ERROR",JOptionPane.WARNING_MESSAGE);
                }
                
            }       //if file exist then action over here
            else{                                           // file is not existing for the this date
                // File naming date or file name decider of pervious file
               // System.out.println("Here");
                String tsd=NamingDate.mainn(sd),gsd = NamingDate.mainn(sd),psd = datem15.mainn(NamingDate.mainn(sd));
                String Givenstrp="000.00" ,Givenstrc="000.00",totaldenstr = "000.00";              //str1 is total of that page, str2 is balance of previous page
                File tempFilee;
                boolean existss ;
                
                
                int counter=0;
                for(gsd = datem15.mainn(gsd);counter<60;gsd = datem15.mainn(gsd),counter++){                    //To get before existing file
                    tempFilee = new File(PRTadd + "/" + code.getText() + STRaddG+"/" + NamingDateName.mainn(gsd) + ".txt");
                    existss = tempFilee.exists();
                    if(existss==true)
                        break;
                }
                //System.out.println(counter+"----"+gsd);
                tsd=gsd;
                //System.out.println("tsd::"+tsd+"   gsd:"+gsd);
                for(;DateInBetween.mainn(NamingDate.mainn(tsd),tsd,NamingDate.mainn(psd));tsd = datep15.mainn(tsd)){
                tempFilee = new File(PRTadd + "/" + code.getText() + STRaddT+"/" + NamingDateName.mainn(tsd) + ".txt");
                existss = tempFilee.exists();
                //System.out.println("Here"+existss);
                if(existss){                                                            // If previous file exists then do ....
                    
                    Scanner intaken;
                    try {
                        intaken = new Scanner(new File(PRTadd + "/" + code.getText() + STRaddT+"/" + NamingDateName.mainn(tsd) + ".txt"),"UTF-8");
                        String tstr= intaken.nextLine();
                            totaldenstr = String.valueOf(Float.valueOf(totaldenstr)+Float.valueOf(tstr));
                        intaken.close();
                      
                    } catch (FileNotFoundException ex) {
                        JLabel label = new JLabel("File reading/closing problem !!! Error0000++536!!"+ex);
            label.setFont(new Font("Arial", Font.BOLD, 18));
            JOptionPane.showMessageDialog(this,label,"ERROR",JOptionPane.WARNING_MESSAGE);
                    }
                }
                
            }
                //System.out.println("Overrrrrrrrr   "+DateInBetween.mainn(NamingDate.mainn(tsd),tsd,NamingDate.mainn(psd))+"#####"+NamingDate.mainn(tsd)+"#####"+"#####"+tsd+NamingDate.mainn(psd));
                tempFilee = new File(PRTadd + "/" + code.getText() + STRaddG+"/" + NamingDateName.mainn(gsd) + ".txt");
                existss = tempFilee.exists();
                if(existss){                                                            // If previous file exists then do ....
                    Scanner ingiven;
                    
                    
                    try {
                        ingiven = new Scanner(new File(PRTadd + "/" + code.getText() + STRaddG+"/" +NamingDateName.mainn(gsd)+ ".txt"),"UTF-8");
                        Givenstrp = ingiven.nextLine();
                            Givenstrc = ingiven.nextLine();
                        ingiven.close();
                       
                      
                    } catch (FileNotFoundException ex) {
                        JLabel label = new JLabel("File reading problem !!! Error0000++558"+ex);
            label.setFont(new Font("Arial", Font.BOLD, 18));
            JOptionPane.showMessageDialog(this,label,"ERROR",JOptionPane.WARNING_MESSAGE);
                    }

                }
                //System.out.println("Givenstrp::"+Givenstrp+"   Givenstrc:::"+Givenstrc+"    totaldenstr::"+totaldenstr+"   Givenstrp::"+Givenstrp);
                Givenstrp = String.valueOf(Float.valueOf(Givenstrp)+Float.valueOf(Givenstrc) - Float.valueOf(totaldenstr));
                Givenstrc = "00.0";
                //errmessage.mainn(PRTadd + "/" + code.getText() + STRaddG+"/" + NamingDateName.mainn(sd) + ".txt",500, 200);
                try {
                    try (
                    BufferedWriter writ = Files.newBufferedWriter(Paths.get(PRTadd + "/" + code.getText() + STRaddG+"/" + NamingDateName.mainn(sd) + ".txt"), StandardCharsets.UTF_8,StandardOpenOption.APPEND,StandardOpenOption.CREATE);
                    
                    ) {
                    
                    writ.append(Givenstrp+"\n"+Givenstrc+"\n");
                    writ.flush();
                    }
                    /*PrintWriter out;
                    out = new PrintWriter(new OutputStreamWriter(new FileOutputStream(PRTadd + "/" + code.getText() + STRaddG+"/" + NamingDateName.mainn(sd) + ".txt"),"UTF-8"));
                    //TextIO.putln(Givenstrp+"...."+Givenstrc);
                    out.println(Givenstrp);
                    out.println(Givenstrc);
                    out.close();*/
                } catch (IOException ex) {
                    JLabel label = new JLabel("File reading problem !!! Error0000++584"+ex);
            label.setFont(new Font("Arial", Font.BOLD, 18));
            JOptionPane.showMessageDialog(this,label,"ERROR",JOptionPane.WARNING_MESSAGE);
                }
                
  //System.out.println("File is existing");
                try {
                    
                    
                    
                   // PrintWriter out,statusout;                    // Detail stord in formate of name \n code \n add \n mob
                    // Detail stord in formate of name \n code \n add \n mob
                    
                    for (int k = 0; k < tm.getRowCount(); k++) {
                        //out = new PrintWriter(new OutputStreamWriter(new FileOutputStream(PRTadd + "/" + code.getText() + STRaddG+"/" + NamingDateName.mainn(sd) + ".txt", true),"UTF-8"));
                        
                        Object o = tm.getValueAt(k, 1);
                        String Icode = (String)o;
                        o = tm.getValueAt(k,2);
                        String  Iname = (String)o;
                        o = tm.getValueAt(k,3);
                        float Iqty = (Float)o;
                        o = tm.getValueAt(k, 4);
                        float Irate = (Float)o;
                        o = tm.getValueAt(k, 5);
                        float Iamt = (Float)o;
                        
                        if(k==0){
                            Iname=remadder(Iname);
                        }
                        
                        /*out = new PrintWriter(new OutputStreamWriter(new FileOutputStream(PRTadd + "/" + code.getText() + STRaddG+"/" + NamingDateName.mainn(sd) + ".txt", true),"UTF-8"));
                        out.println(sd+","+Icode+","+Iname+","+Iqty+","+Irate+","+Iamt);
                        out.close();*/
                        try (
                        BufferedWriter writ = Files.newBufferedWriter(Paths.get(PRTadd + "/" + code.getText() + STRaddG+"/" + NamingDateName.mainn(sd) + ".txt"), StandardCharsets.UTF_8,StandardOpenOption.APPEND,StandardOpenOption.CREATE);
                        
                        ) {
                        
                        writ.append(sd+","+Icode+","+Iname+","+Iqty+","+Irate+","+Iamt+"\n");
                        writ.flush();
                        }
                        
                        //####################################################################################################
                        // Now updating stock in item of current
                        String pstck="000.0",ppstck="000.0";
                        File tmp = new File(ITMadd + "/" + Icode + "/status/" + NamingDateName.mainn(sd) + ".txt");
                        boolean bf  = tmp.exists();
                        //TextIO.putln("11111"+bf);
                        if(bf){
                            try (
                            BufferedWriter writ = Files.newBufferedWriter(Paths.get(ITMadd + "/" + Icode + "/status/" + NamingDateName.mainn(sd) + ".txt"), StandardCharsets.UTF_8,StandardOpenOption.APPEND,StandardOpenOption.CREATE);
                            
                            ) {
                            
                            writ.append(sd+","+code.getText()+","+"-"+Iqty+","+Irate+","+Iamt+","+mode+","+"Party"+"\n");
                            writ.flush();
                            }
                             /*statusout = new PrintWriter(new OutputStreamWriter(new FileOutputStream(ITMadd + "/" + Icode + "/status/" + NamingDateName.mainn(sd) + ".txt", true),"UTF-8"));
                             statusout.print(sd+",");
                             statusout.print(code.getText()+",");
                             statusout.print("-"+Iqty+",");
                             statusout.print(Irate+",");
                             statusout.print(Iamt+",");
                             statusout.print(mode+",");
                             statusout.println("Party");
                             statusout.close();*/
                            Scanner read;
                            pstck="000.0";
                            read = new Scanner(new File(ITMadd + "/" + Icode + "/status/" + NamingDateName.mainn(sd) + ".txt"),"UTF-8");
                            read.nextLine();
                            pstck = read.nextLine();
                            read.close();
                            String nstck = "000.0";
                            nstck = String.valueOf(Float.parseFloat(pstck)-Iqty);
                            ReplaceLineWN.mainn(ITMadd + "/" + Icode + "/status",NamingDateName.mainn(sd) + ".txt", 2, String.valueOf(nstck));
                        }
                        else{
                            String dsd = NamingDate.mainn(sd);
                            counter=0;
                            for(dsd=datem15.mainn(dsd);counter<60;dsd=datem15.mainn(dsd),counter++){
                                tmp = new File(ITMadd+"/"+Icode+"/status/"+NamingDateName.mainn(dsd)+".txt");
                                bf = tmp.exists();
                                if(bf == true)
                                    break;
                            }
                            //TextIO.putln(dsd);
                            Scanner read;
                            tmp = new File(ITMadd+"/"+Icode+"/status/"+NamingDateName.mainn(dsd)+".txt");
                            bf = tmp.exists();
                            if(bf){
                                read = new Scanner(new File(ITMadd+"/"+Icode+"/status/"+NamingDateName.mainn(dsd)+".txt"),"UTF-8");
                                ppstck= read.nextLine();
                                pstck = read.nextLine();
                                read.close();
                            }
                            else{
                                pstck = "000.0";
                                ppstck = "000.0";
                            }
                            ppstck = String.valueOf(Float.valueOf(ppstck)+Float.valueOf(pstck));
                            
                            pstck = String.valueOf(-Iqty);
                            //TextIO.putln("ppstck:"+ppstck+"   pstck:"+pstck);
                            ////TextIO.putln("Pstck    "+pstck);
                            try (
                            BufferedWriter writ = Files.newBufferedWriter(Paths.get(ITMadd + "/" + Icode + "/status/" + NamingDateName.mainn(sd) + ".txt"), StandardCharsets.UTF_8,StandardOpenOption.APPEND,StandardOpenOption.CREATE);
                            
                            ) {
                            
                            writ.append(ppstck+"\n"+pstck+"\n"+sd+","+code.getText()+","+"-"+Iqty+","+Irate+","+Iamt+","+mode+","+"Party"+"\n");
                            writ.flush();
                            }
                           /* statusout = new PrintWriter(new OutputStreamWriter(new FileOutputStream(ITMadd + "/" + Icode + "/status/" + NamingDateName.mainn(sd) + ".txt", true),"UTF-8"));
                            statusout.println(ppstck);
                            statusout.println(pstck);
                            statusout.print(sd+",");
                            statusout.print(code.getText()+",");
                            statusout.print("-"+Iqty+",");
                            statusout.print(Irate+",");
                            statusout.print(Iamt+",");
                            statusout.print(mode+",");
                            statusout.println("Party");
                            statusout.close();*/
                        }
                        
                        
                        
                        //Over of updation of stock of item of current
//#########################################################################################################################
                        counter =0;                     //Updating files exist after that date
                        boolean bg;
                        Scanner in ;
                        String p;
                        float stck;
                        String     dsd =NamingDate.mainn(sd);
                        for(dsd = datep15.mainn(dsd);counter<60;dsd=datep15.mainn(dsd),counter++){                               //Updating all file created or having date of early created
                            tmp = new File(ITMadd+"/"+Icode+"/Status/"+NamingDateName.mainn(dsd)+".txt");
                            bg =tmp.exists();
                            if(bg){
                                //TextIO.putln(ITMadd+"/"+icode.getText()+"/Status/"+NamingDateName.mainn(dsd)+".txt");
                                in = new Scanner(tmp,"UTF-8");
                                p = in.nextLine();
                                in.close();
                                stck = Float.valueOf(p) - Iqty;
                                ReplaceLineWN.mainn(ITMadd+"/"+Icode+"/Status", NamingDateName.mainn(dsd)+".txt",1 , String.valueOf(stck));
                                
                            }
                        }
//########################################################################################################################3
                    }
                    
//#########################################################################################################################3
                    //Updating totaling of that page
                    Scanner in;
                    in = new Scanner(new File(PRTadd + "/" + code.getText() + STRaddG+"/" + NamingDateName.mainn(sd) + ".txt"),"UTF-8");
                    in.nextLine();
                    String str = in.nextLine();
                    in.close();
                    
                    float ft = Float.valueOf(str);
                    itotal=Float.valueOf(total.getText());
                    ft = ft + itotal;
                    String Str = String.valueOf(ft);
                    ReplaceLineWN.mainn(PRTadd + "/" + code.getText() + STRaddG, NamingDateName.mainn(sd) + ".txt", 2,Str );
                    //Updating the exist after this date
                     counter=0;
                    Scanner inn;
                    String pd;
                    float nd;
                    File tmp;
                    boolean bg;
                    String dsd =NamingDate.mainn(sd);
                    for(dsd = datep15.mainn(dsd);counter<60;dsd=datep15.mainn(dsd),counter++){
                        tmp=new File(PRTadd +"/" + code.getText()+ STRaddG+"/"+ NamingDateName.mainn(dsd)+".txt");
                        bg=tmp.exists();
                        if(bg){
                            inn = new Scanner(new File(PRTadd +"/" + code.getText()+ STRaddG+"/"+ NamingDateName.mainn(dsd)+".txt"),"UTF-8");
                            pd = inn.nextLine();
                            nd = Float.valueOf(pd)+itotal;
                            inn.close();
                            ReplaceLineWN.mainn(PRTadd+"/"+code.getText()+STRaddG, NamingDateName.mainn(dsd)+".txt", 1, String.valueOf(nd));
                        }
                        
                    }
                    //###########################################################################################################
                    //########################################################################################################################3
                     //For pcomp();
                if(prntrs){
                    printerr();
                }
                //System.out.println("Here we gone for printer"+prntrs);
//########################################################################################################################3
  
                     
//###########################################################################################################################3
                    DefaultTableModel dm = (DefaultTableModel)table.getModel();
                    for(int y =dm.getRowCount()-1 ;y>=0;--y)
                        dm.removeRow(y);
                    itotal = 0;
                    total.setText(String.valueOf(itotal));
                    name.setText(null);
                    i=1; 
                    rem.setText(remm);
                    sway.setSelectedIndex(Integer.valueOf(Dway));
                    Pmode.setSelectedIndex(Integer.valueOf(Dmode));
                    code.requestFocus();
                    code.selectAll();
                } catch (IOException ex) {
                    JLabel label = new JLabel("File Opening !!! Error0012++789"+ex);
            label.setFont(new Font("Arial", Font.BOLD, 18));
            JOptionPane.showMessageDialog(this,label,"ERROR",JOptionPane.WARNING_MESSAGE);
                }
              
            }
    }
        else{
            code.requestFocus();
            JLabel label = new JLabel("There is Nothing To save !!++798");
            label.setFont(new Font("Arial", Font.BOLD, 18));
            JOptionPane.showMessageDialog(this,label,"ERROR",JOptionPane.WARNING_MESSAGE);  
        }
}
   //#################################################################################################################3
         public void pcompT(){
          
                     TableModel tm = table.getModel();
        int ty=tm.getRowCount();
if(ty>0){
    File tempFile = new File( PRTadd + "/" + code.getText() + STRaddT+"/" +NamingDateName.mainn(sd)+ ".txt" );
    boolean exists = tempFile.exists();
   
    if(exists){                             // File for that date is Exists then ....

                try { 
                    Scanner in ;
        //FileReader stream;
                    in = new Scanner(new File(PRTadd + "/" + code.getText() + STRaddT+"/" + NamingDateName.mainn(sd) + ".txt"),"UTF-8");
                    String str;
                    
                        str = in.nextLine();
                        in.close();
                    
float ft = Float.valueOf(str);
ft = ft + itotal;
String Str = String.valueOf(ft);
                    try {
                        ReplaceLineWN.mainn(PRTadd + "/" + code.getText() + STRaddT, NamingDateName.mainn(sd) + ".txt", 1, Str);
                    } catch (IOException ex) {
                        JLabel label = new JLabel("taken total updation problem !!! Error0014++828!!"+ex);
            label.setFont(new Font("Arial", Font.BOLD, 18));
            JOptionPane.showMessageDialog(this,label,"ERROR",JOptionPane.WARNING_MESSAGE);
                    }
                } catch (FileNotFoundException ex) {
                    JLabel label = new JLabel("PRT data Date. file not close/open !!! Error0012+++833!!"+ex);
            label.setFont(new Font("Arial", Font.BOLD, 18));
            JOptionPane.showMessageDialog(this,label,"ERROR",JOptionPane.WARNING_MESSAGE);
                }

    }
    else                        // If file for this date is not exists then
    {

                try {                       // Go to set file in required formate
                    try (
                    BufferedWriter writ = Files.newBufferedWriter(Paths.get(PRTadd + "/" + code.getText() + STRaddT+"/" + NamingDateName.mainn(sd) + ".txt"), StandardCharsets.UTF_8,StandardOpenOption.APPEND,StandardOpenOption.CREATE);
                    
                    ) {
                    
                    writ.append(String.valueOf(itotal)+"\n");
                    writ.flush();
                    }
                    /*PrintWriter out;
                    out = new PrintWriter(new OutputStreamWriter(new FileOutputStream(PRTadd + "/" + code.getText() + STRaddT+"/" + NamingDateName.mainn(sd)+ ".txt", true),"UTF-8"));
                    out.println(String.valueOf(itotal));
                    out.close();*/
                } catch (IOException ex) {
                    JLabel label = new JLabel("Total updation error !!! Error0013+856!!"+ex);
            label.setFont(new Font("Arial", Font.BOLD, 18));
            JOptionPane.showMessageDialog(this,label,"ERROR",JOptionPane.WARNING_MESSAGE);
        
                }


    }
    
//####################################################################################################################################################################
                            int counter=0;              // updating future given files                                                  // Updating given as we take something from CUmstomer
                            File tmp;
                            Scanner in;
                            String pd;
                            float nd;
                            boolean bg;
                            String dsd =NamingDate.mainn(sd);
                           try{ 
                               for(dsd = datep15.mainn(dsd);counter<60;dsd=datep15.mainn(dsd),counter++){
                                tmp=new File(PRTadd +"/" + code.getText()+ STRaddG+"/"+ NamingDateName.mainn(dsd)+".txt");
                                bg=tmp.exists();
                                if(bg){
                                in = new Scanner(new File(PRTadd +"/" + code.getText()+ STRaddG+"/"+ NamingDateName.mainn(dsd)+".txt"),"UTF-8");   
                                pd = in.nextLine();
                                nd = Float.valueOf(pd)-Float.valueOf(total.getText());
                                in.close();
                                ReplaceLineWN.mainn(PRTadd+"/"+code.getText()+STRaddG, NamingDateName.mainn(dsd)+".txt", 1, String.valueOf(nd));
                                }
                                
                            }
                           }catch (FileNotFoundException ex) {
                            JLabel label = new JLabel("PRT Given data Date. file not close/open !!! Error0012+887!!"+ex);
                            label.setFont(new Font("Arial", Font.BOLD, 18));
                            JOptionPane.showMessageDialog(this,label,"ERROR",JOptionPane.WARNING_MESSAGE);
                        }catch (IOException ex) {
                            JLabel label = new JLabel("PRT Given data Date. file not closes/opens !!! Error0012++890!!"+ex);
            label.setFont(new Font("Arial", Font.BOLD, 18));
            JOptionPane.showMessageDialog(this,label,"ERROR",JOptionPane.WARNING_MESSAGE);
                        }
                          
  
    
        try {                           // Set all item and item details to the permanent files
                //PrintWriter out,statusout;  // Detail stord in formate of name \n code \n add \n mob
                // Detail stord in formate of name \n code \n add \n mob
                
                for (int k = 0; k < tm.getRowCount(); k++) {
  //for (int j = 0; j < tm.getColumnCount(); j++) {
                   // out = new PrintWriter(new OutputStreamWriter(new FileOutputStream(PRTadd + "/" + code.getText() + STRaddT+"/" + NamingDateName.mainn(sd) + ".txt", true),"UTF-8"));
    Object o = tm.getValueAt(k, 1);
    String Icode = (String)o;
    o = tm.getValueAt(k,2);
    String Iname = (String)o;
    o = tm.getValueAt(k,3);
    float Iqty = (Float)o;
    o = tm.getValueAt(k, 4);
    float Irate = (Float)o;
    o = tm.getValueAt(k, 5);
    float Iamt = (Float)o;
   
    if(k==0)
        Iname=remadder(Iname);
    //Iname = new String(Iname.getBytes(),"UTF-8");
    //TextIO.putln(ph);
    //TextIO.putln(sd+","+Icode+","+Iname+","+Iqty+","+Irate+","+Iamt);
    try ( 
                              BufferedWriter writ = Files.newBufferedWriter(Paths.get(PRTadd + "/" + code.getText() + STRaddT+"/" + NamingDateName.mainn(sd) + ".txt"), StandardCharsets.UTF_8,StandardOpenOption.APPEND);
                              
                   ) {
                          
                   writ.append(sd+","+Icode+","+Iname+","+Iqty+","+Irate+","+Iamt+"\n");
                   writ.flush();
                      }
    /*out.print(sd+",");
    out.print(Icode+",");
    out.print(Iname+",");
    out.print(Iqty+",");
    out.print(Irate+",");
    out.println(Iamt);
    out.close();*/
   
                    //####################################################################################################
                    // Now updating statuts
                    String pstck="000.0",ppstck="000.0";
                    tmp = new File(ITMadd + "/" + Icode + "/status/" + NamingDateName.mainn(sd) + ".txt");
                    boolean bf  = tmp.exists();
                    //TextIO.putln("11111"+bf);
                    if(bf){
                         try ( 
                              BufferedWriter writ = Files.newBufferedWriter(Paths.get(ITMadd + "/" + Icode + "/status/" + NamingDateName.mainn(sd) + ".txt"), StandardCharsets.UTF_8,StandardOpenOption.APPEND,StandardOpenOption.CREATE);
                              
                   ) {
                          
                   writ.append(sd+","+code.getText()+","+Iqty+","+Irate+","+Iamt+","+mode+","+"Party"+"\n");
                   writ.flush();
                      }
                        
                         /* statusout = new PrintWriter(new OutputStreamWriter(new FileOutputStream(ITMadd + "/" + Icode + "/status/" + NamingDateName.mainn(sd) + ".txt", true),"UTF-8"));
                         statusout.print(sd+",");
                         statusout.print(code.getText()+",");
                         statusout.print(Iqty+",");
                         statusout.print(Irate+",");
                         statusout.print(Iamt+",");
                         statusout.print(mode+",");
                         statusout.println("Party");
                         statusout.close();*/
                    Scanner read;
                    pstck="000.0";
                    read = new Scanner(new File(ITMadd + "/" + Icode + "/status/" + NamingDateName.mainn(sd) + ".txt"),"UTF-8");
                    read.nextLine();
                    pstck = read.nextLine();
                    read.close();
                    String nstck = "000.0";
                    nstck = String.valueOf(Float.parseFloat(pstck)+Iqty);
                    ReplaceLineWN.mainn(ITMadd + "/" + Icode + "/status",NamingDateName.mainn(sd)+ ".txt", 2, String.valueOf(nstck));
                    }
                    else{
                        dsd = NamingDate.mainn(sd);
                        counter=0;
                        for(;counter<60;dsd=datem15.mainn(dsd),counter++){                           // To get previous existing file
                        tmp = new File(ITMadd+"/"+Icode+"/status/"+NamingDateName.mainn(dsd)+".txt");
                        //TextIO.putln(ITMadd+"/"+Icode+"/status/"+NamingDateName.mainn(dsd)+".txt");
                        bf = tmp.exists();
                        if(bf==true)
                            break;
                        }
                        tmp = new File(ITMadd+"/"+Icode+"/status/"+NamingDateName.mainn(dsd)+".txt");
                        bf = tmp.exists();
                        Scanner read;
                        if(bf){
                        read = new Scanner(new File(ITMadd+"/"+Icode+"/status/"+NamingDateName.mainn(dsd)+".txt"),"UTF-8");
                        ppstck = read.nextLine();
                        pstck = read.nextLine();
                        ppstck = String.valueOf(Float.valueOf(ppstck)+Float.valueOf(pstck));
                        read.close();
                        }
                        else{
                            pstck = "000.0";
                        }
                        pstck = String.valueOf(Iqty);
                        
                        ////TextIO.putln("Pstck    "+pstck);
try ( 
        BufferedWriter writ = Files.newBufferedWriter(Paths.get(ITMadd + "/" + Icode + "/status/" + NamingDateName.mainn(sd) + ".txt"), StandardCharsets.UTF_8,StandardOpenOption.APPEND,StandardOpenOption.CREATE);
                              
                   ) {
                          
                   writ.append(ppstck+"\n"+pstck+"\n"+sd+","+code.getText()+","+Iqty+","+Irate+","+Iamt+","+mode+","+"Party"+"\n");
                   writ.flush();
                      }

                    }





                             //Over of updation of status of current
//#########################################################################################################################
                    
                    counter =0;                 //Updating future files
                    String p;
                    float stck;
                    dsd =NamingDate.mainn(sd);
                            for(dsd = datep15.mainn(dsd);counter<60;dsd=datep15.mainn(dsd),counter++){  
                                System.out.println(ITMadd+"/"+Icode+"/Status/"+NamingDateName.mainn(dsd)+".txt");//Updating all file created or having date of early created
                                tmp = new File(ITMadd+"/"+Icode+"/Status/"+NamingDateName.mainn(dsd)+".txt");
                                bg =tmp.exists();
                                if(bg){
                                    
                                   //TextIO.putln(ITMadd+"/"+icode.getText()+"/Status/"+NamingDateName.mainn(dsd)+".txt");
                                 in = new Scanner(tmp,"UTF-8");
                            p = in.nextLine();
                            in.close();
                            stck = Float.valueOf(p) + Iqty;
                            ReplaceLineWN.mainn(ITMadd+"/"+Icode+"/Status", NamingDateName.mainn(dsd)+".txt",1 , String.valueOf(stck));
                            
                                }
                            }
                           
//########################################################################################################################3
                }
//########################################################################################################################3
                
                //System.out.println("Bcond::"+prntrs);
                if(prntrs){
                    printerr();
                }
                
//########################################################################################################################3
                    DefaultTableModel dm = (DefaultTableModel)table.getModel();
                    for(int y =dm.getRowCount()-1 ;y>=0;--y)
                    dm.removeRow(y);
                    itotal = 0;
                    total.setText(String.valueOf(itotal));
                    name.setText(null);
                    i=1;
                     rem.setText(remm);
                    sway.setSelectedIndex(Integer.valueOf(Dway));
                    Pmode.setSelectedIndex(Integer.valueOf(Dmode));
                    code.requestFocus();
                    code.selectAll();
                   
            } catch (IOException ex) {
            JLabel label = new JLabel("File opening problem !!! Error0012+1058!!"+ex);
            label.setFont(new Font("Arial", Font.BOLD, 18));
            JOptionPane.showMessageDialog(this,label,"ERROR",JOptionPane.WARNING_MESSAGE);    
            }

       //if file exist then here is over of action

 
    }
else{
    code.requestFocus();
          JLabel label = new JLabel("There is Nothing to Save+1070!!");
            label.setFont(new Font("Arial", Font.BOLD, 22));
            JOptionPane.showMessageDialog(this,label,"ERROR",JOptionPane.WARNING_MESSAGE);  
        }   
         }
   //#################################################################################################################3
   //#################################################################################################################3
         public void ccompT(){
          
                     TableModel tm = table.getModel();
        int ty=tm.getRowCount();
if(ty>0){
    File tempFile = new File( PRTadd + "/" + code.getText() + STRaddT+"/" +NamingDateName.mainn(sd)+ ".txt" );
    boolean exists = tempFile.exists();
    if(exists){                             // File for that date is Exists then ....

                try { 
                    Scanner in ;
        //FileReader stream;
                    in = new Scanner(new File(PRTadd + "/" + code.getText() + STRaddT+"/" + NamingDateName.mainn(sd) + ".txt"),"UTF-8");
                    String str;
                    
                        str = in.nextLine();
                        in.close();
                    
float ft = Float.valueOf(str);
ft = ft + itotal;
String Str = String.valueOf(ft);
                    try {
                        ReplaceLineWN.mainn(PRTadd + "/" + code.getText() + STRaddT, NamingDateName.mainn(sd) + ".txt", 1, Str);
                    } catch (IOException ex) {
                        JLabel label = new JLabel("taken total updation problem !!! Error0014++828!!"+ex);
            label.setFont(new Font("Arial", Font.BOLD, 18));
            JOptionPane.showMessageDialog(this,label,"ERROR",JOptionPane.WARNING_MESSAGE);
                    }
                } catch (FileNotFoundException ex) {
                    JLabel label = new JLabel("PRT data Date. file not close/open !!! Error0012+++833!!"+ex);
            label.setFont(new Font("Arial", Font.BOLD, 18));
            JOptionPane.showMessageDialog(this,label,"ERROR",JOptionPane.WARNING_MESSAGE);
                }

    }
    else                        // If file for this date is not exists then
    {

                try {                       // Go to set file in required formate
                    try (
                    BufferedWriter writ = Files.newBufferedWriter(Paths.get(PRTadd + "/" + code.getText() + STRaddT+"/" + NamingDateName.mainn(sd) + ".txt"), StandardCharsets.UTF_8,StandardOpenOption.APPEND,StandardOpenOption.CREATE);
                    
                    ) {
                    
                    writ.append(String.valueOf(itotal)+"\n");
                    writ.flush();
                    }
                    } catch (IOException ex) {
                    JLabel label = new JLabel("Total updation error !!! Error0013+856!!"+ex);
            label.setFont(new Font("Arial", Font.BOLD, 18));
            JOptionPane.showMessageDialog(this,label,"ERROR",JOptionPane.WARNING_MESSAGE);
        
                }


    }
    
//####################################################################################################################################################################
                            int counter=0;              // updating future given files                                                  // Updating given as we take something from CUmstomer
                            File tmp;
                            Scanner in;
                            String pd;
                            float nd;
                            boolean bg;
                            String dsd =NamingDate.mainn(sd);
                           try{ 
                               for(dsd = datep15.mainn(dsd);counter<60;dsd=datep15.mainn(dsd),counter++){
                                tmp=new File(PRTadd +"/" + code.getText()+ STRaddG+"/"+ NamingDateName.mainn(dsd)+".txt");
                                bg=tmp.exists();
                                if(bg){
                                in = new Scanner(new File(PRTadd +"/" + code.getText()+ STRaddG+"/"+ NamingDateName.mainn(dsd)+".txt"),"UTF-8");   
                                pd = in.nextLine();
                                nd = Float.valueOf(pd)-Float.valueOf(total.getText());
                                in.close();
                                ReplaceLineWN.mainn(PRTadd+"/"+code.getText()+STRaddG, NamingDateName.mainn(dsd)+".txt", 1, String.valueOf(nd));
                                }
                                
                            }
                           }catch (FileNotFoundException ex) {
                            JLabel label = new JLabel("PRT Given data Date. file not close/open !!! Error0012+887!!"+ex);
                            label.setFont(new Font("Arial", Font.BOLD, 18));
                            JOptionPane.showMessageDialog(this,label,"ERROR",JOptionPane.WARNING_MESSAGE);
                        }catch (IOException ex) {
                            JLabel label = new JLabel("PRT Given data Date. file not closes/opens !!! Error0012++890!!"+ex);
            label.setFont(new Font("Arial", Font.BOLD, 18));
            JOptionPane.showMessageDialog(this,label,"ERROR",JOptionPane.WARNING_MESSAGE);
                        }
                          
  
    
        try {                           // Set all item and item details to the permanent files
                //PrintWriter out,statusout;  // Detail stord in formate of name \n code \n add \n mob
                // Detail stord in formate of name \n code \n add \n mob
                
                for (int k = 0; k < tm.getRowCount(); k++) {
    Object o = tm.getValueAt(k, 1);
    String Icode = (String)o;
    o = tm.getValueAt(k,2);
    String Iname = (String)o;
    o = tm.getValueAt(k,3);
    float Iqty = (Float)o;
    o = tm.getValueAt(k, 4);
    float Irate = (Float)o;
    o = tm.getValueAt(k, 5);
    float Iamt = (Float)o;
    
    if(k==0)
        Iname=remadder(Iname);
    try ( 
                              BufferedWriter writ = Files.newBufferedWriter(Paths.get(PRTadd + "/" + code.getText() + STRaddT+"/" + NamingDateName.mainn(sd) + ".txt"), StandardCharsets.UTF_8,StandardOpenOption.APPEND);
                              
                   ) {
                          
                   writ.append(sd+","+Icode+","+Iname+","+Iqty+","+Irate+","+Iamt+"\n");
                   writ.flush();
                      }
                //####################################################################################################
                    // Now updating statuts
                    String pstck="000.0",ppstck="000.0";
                    tmp = new File(ITMadd + "/" + Icode + "/status/" + NamingDateName.mainn(sd) + ".txt");
                    boolean bf  = tmp.exists();
                    //TextIO.putln("11111"+bf);
                    if(bf){
                         try ( 
                              BufferedWriter writ = Files.newBufferedWriter(Paths.get(ITMadd + "/" + Icode + "/status/" + NamingDateName.mainn(sd) + ".txt"), StandardCharsets.UTF_8,StandardOpenOption.APPEND,StandardOpenOption.CREATE);
                              
                   ) {
                          
                   writ.append(sd+","+code.getText()+","+Iqty+","+Irate+","+Iamt+","+mode+","+"Party"+"\n");
                   writ.flush();
                      }
                        
                    Scanner read;
                    pstck="000.0";
                    read = new Scanner(new File(ITMadd + "/" + Icode + "/status/" + NamingDateName.mainn(sd) + ".txt"),"UTF-8");
                    read.nextLine();
                    pstck = read.nextLine();
                    read.close();
                    String nstck = "000.0";
                    nstck = String.valueOf(Float.parseFloat(pstck)+Iqty);
                    ReplaceLineWN.mainn(ITMadd + "/" + Icode + "/status",NamingDateName.mainn(sd)+ ".txt", 2, String.valueOf(nstck));
                    }
                    else{
                        dsd = NamingDate.mainn(sd);
                        counter=0;
                        for(;counter<60;dsd=datem15.mainn(dsd),counter++){                           // To get previous existing file
                        tmp = new File(ITMadd+"/"+Icode+"/status/"+NamingDateName.mainn(dsd)+".txt");
                        //TextIO.putln(ITMadd+"/"+Icode+"/status/"+NamingDateName.mainn(dsd)+".txt");
                        bf = tmp.exists();
                        if(bf==true)
                            break;
                        }
                        tmp = new File(ITMadd+"/"+Icode+"/status/"+NamingDateName.mainn(dsd)+".txt");
                        bf = tmp.exists();
                        Scanner read;
                        if(bf){
                        read = new Scanner(new File(ITMadd+"/"+Icode+"/status/"+NamingDateName.mainn(dsd)+".txt"),"UTF-8");
                        ppstck = read.nextLine();
                        pstck = read.nextLine();
                        ppstck = String.valueOf(Float.valueOf(ppstck)+Float.valueOf(pstck));
                        read.close();
                        }
                        else{
                            pstck = "000.0";
                        }
                        pstck = String.valueOf(Iqty);
                        ////TextIO.putln("Pstck    "+pstck);
try ( 
        BufferedWriter writ = Files.newBufferedWriter(Paths.get(ITMadd + "/" + Icode + "/status/" + NamingDateName.mainn(sd) + ".txt"), StandardCharsets.UTF_8,StandardOpenOption.APPEND,StandardOpenOption.CREATE);
                              
                   ) {
                          
                   writ.append(ppstck+"\n"+pstck+"\n"+sd+","+code.getText()+","+Iqty+","+Irate+","+Iamt+","+mode+","+"Party"+"\n");
                   writ.flush();
                      }
                    }

                             //Over of updation of status of current
//#########################################################################################################################
                    counter =0;                 //Updating future files
                    String p;
                    float stck;
                    dsd =NamingDate.mainn(sd);
                            for(dsd = datep15.mainn(dsd);counter<60;dsd=datep15.mainn(dsd),counter++){  
                                System.out.println(ITMadd+"/"+Icode+"/Status/"+NamingDateName.mainn(dsd)+".txt");//Updating all file created or having date of early created
                                tmp = new File(ITMadd+"/"+Icode+"/Status/"+NamingDateName.mainn(dsd)+".txt");
                                bg =tmp.exists();
                                if(bg){
                                    
                                   //TextIO.putln(ITMadd+"/"+icode.getText()+"/Status/"+NamingDateName.mainn(dsd)+".txt");
                                 in = new Scanner(tmp,"UTF-8");
                            p = in.nextLine();
                            in.close();
                            stck = Float.valueOf(p) + Iqty;
                            ReplaceLineWN.mainn(ITMadd+"/"+Icode+"/Status", NamingDateName.mainn(dsd)+".txt",1 , String.valueOf(stck));
                            
                                }
                            }
//########################################################################################################################3
                }
//########################################################################################################################3
//Going for Replacement as curruncy
                 tempFile = new File( PRTadd + "/" + code.getText() + STRaddG+"/" +NamingDateName.mainn(sd)+ ".txt" );
    exists = tempFile.exists();
    if(exists){                             // File for that date is Exists then ....

         System.out.println("It's Already There!");       

    }
    else                        // If file for this date is not exists then
    {
                                           // file is not existing for the this date
                // File naming date or file name decider of pervious file
               // System.out.println("Here");
                String tsd=NamingDate.mainn(sd),gsd = NamingDate.mainn(sd),psd = datem15.mainn(NamingDate.mainn(sd));
                String Givenstrp="000.00" ,Givenstrc="000.00",totaldenstr = "000.00";              //str1 is total of that page, str2 is balance of previous page
                File tempFilee;
                boolean existss ;
                
                
                counter=0;
                for(gsd = datem15.mainn(gsd);counter<60;gsd = datem15.mainn(gsd),counter++){                    //To get before existing file
                    tempFilee = new File(PRTadd + "/" + code.getText() + STRaddG+"/" + NamingDateName.mainn(gsd) + ".txt");
                    existss = tempFilee.exists();
                    if(existss==true)
                        break;
                }
                tsd=gsd;
                for(;DateInBetween.mainn(NamingDate.mainn(tsd),tsd,NamingDate.mainn(psd));tsd = datep15.mainn(tsd)){
                tempFilee = new File(PRTadd + "/" + code.getText() + STRaddT+"/" + NamingDateName.mainn(tsd) + ".txt");
                existss = tempFilee.exists();
                if(existss){                                                            // If previous file exists then do ....
                    
                    Scanner intaken;
                    try {
                        intaken = new Scanner(new File(PRTadd + "/" + code.getText() + STRaddT+"/" + NamingDateName.mainn(tsd) + ".txt"),"UTF-8");
                        String tstr= intaken.nextLine();
                            totaldenstr = String.valueOf(Float.valueOf(totaldenstr)+Float.valueOf(tstr));
                        intaken.close();
                      
                    } catch (FileNotFoundException ex) {
                        JLabel label = new JLabel("File reading/closing problem !!! Error0000++536!!"+ex);
            label.setFont(new Font("Arial", Font.BOLD, 18));
            JOptionPane.showMessageDialog(this,label,"ERROR",JOptionPane.WARNING_MESSAGE);
                    }
                }
                
            }
                tempFilee = new File(PRTadd + "/" + code.getText() + STRaddG+"/" + NamingDateName.mainn(gsd) + ".txt");
                existss = tempFilee.exists();
                if(existss){                                                            // If previous file exists then do ....
                    Scanner ingiven;
                   try {
                        ingiven = new Scanner(new File(PRTadd + "/" + code.getText() + STRaddG+"/" +NamingDateName.mainn(gsd)+ ".txt"),"UTF-8");
                        Givenstrp = ingiven.nextLine();
                            Givenstrc = ingiven.nextLine();
                        ingiven.close();
                    } catch (FileNotFoundException ex) {
                        JLabel label = new JLabel("File reading problem !!! Error0000++558"+ex);
            label.setFont(new Font("Arial", Font.BOLD, 18));
            JOptionPane.showMessageDialog(this,label,"ERROR",JOptionPane.WARNING_MESSAGE);
                    }

                }
                Givenstrp = String.valueOf(Float.valueOf(Givenstrp)+Float.valueOf(Givenstrc) - Float.valueOf(totaldenstr));
                Givenstrc = "00.0";
                try {
                    try (
                    BufferedWriter writ = Files.newBufferedWriter(Paths.get(PRTadd + "/" + code.getText() + STRaddG+"/" + NamingDateName.mainn(sd) + ".txt"), StandardCharsets.UTF_8,StandardOpenOption.APPEND,StandardOpenOption.CREATE);
                    ) {
                    writ.append(Givenstrp+"\n"+Givenstrc+"\n");
                    writ.flush();
                    }
                    } catch (IOException ex) {
                    JLabel label = new JLabel("File reading problem !!! Error0000++584"+ex);
            label.setFont(new Font("Arial", Font.BOLD, 18));
            JOptionPane.showMessageDialog(this,label,"ERROR",JOptionPane.WARNING_MESSAGE);
                }

    }   // Just current file is created if doesn't exists already
    // We move like current file is there do the rest thing 
    
    tempFile = new File( PRTadd + "/" + code.getText() + STRaddG+"/" + NamingDateName.mainn(sd) + ".txt" );
    exists = tempFile.exists();
            
            if(exists)              // File for that date exists then directly update the total and save data to the corresponding
            {
                try {
                  // PrintWriter out,statusout;                    // Detail stord in formate of name \n code \n add \n mob
                  // Detail stord in formate of name \n code \n add \n mob
                    
                    ty=tm.getRowCount();
                    for (int k = 0; k < ty; k++) {
                        Object o;
                        String Icode = repicode;
                        o = tm.getValueAt(k,2);
                        String  Iname =repiname+" "+ (String)o;
                        float Irate = Float.valueOf(repirate);
                        o = tm.getValueAt(k, 5);
                        float Iamt = (Float)o;
                        float Iqty = Iamt/Irate;;
                        
                        
                        
                        if(k==0)
                            Iname=remadder(Iname);
                        //Iname = new String(Iname.getBytes(),"UTF-8");
                        try {
                                       

                            Path path = Paths.get(PRTadd + "/" + code.getText() + STRaddG+"/" + NamingDateName.mainn(sd) + ".txt");
      
                            BufferedWriter writer = Files.newBufferedWriter(path, StandardCharsets.UTF_8,StandardOpenOption.APPEND);
                            
                            writer.append(sd+",");
                            writer.append(Icode+",");
                            writer.append(Iname+",");
                            writer.append(Iqty+",");
                            writer.append(Irate+",");
                            writer.append(Iamt+"\n");
                            
                            writer.flush();
       
        } catch (IOException e) {
            e.printStackTrace();
            JLabel label1 = new JLabel("File problem 308!!"+e);
                        label1.setFont(new Font("Arial", Font.BOLD, 18));
                        JOptionPane.showMessageDialog(this,label1,"ERROR",JOptionPane.WARNING_MESSAGE);   
        }
                        
                        //####################################################################################################
                        // Now updating stock in item of current
                        String pstck="000.0",ppstck="000.0";
                        tmp = new File(ITMadd + "/" + Icode + "/status/" + NamingDateName.mainn(sd) + ".txt");
                        boolean bf  = tmp.exists();
                        //TextIO.putln("11111"+bf);
                        if(bf){
                         try (
                        BufferedWriter writ = Files.newBufferedWriter(Paths.get(ITMadd + "/" + Icode + "/status/" + NamingDateName.mainn(sd) + ".txt"), StandardCharsets.UTF_8,StandardOpenOption.APPEND,StandardOpenOption.CREATE);
                        
                        ) {
                        
                        writ.append(sd+","+code.getText()+","+"-"+Iqty+","+Irate+","+Iamt+","+mode+","+"Party"+"\n");
                        writ.flush();
                        }
 
                            Scanner read;
                            pstck="000.0";
                            read = new Scanner(new File(ITMadd + "/" + Icode + "/status/" + NamingDateName.mainn(sd) + ".txt"),"UTF-8");
                            read.nextLine();
                            pstck = read.nextLine();
                            read.close();
                            String nstck = "000.0";
                            nstck = String.valueOf(Float.parseFloat(pstck)-Iqty);
                            ReplaceLineWN.mainn(ITMadd + "/" + Icode + "/status",NamingDateName.mainn(sd) + ".txt", 2, String.valueOf(nstck));
                            }
                        else{
                            dsd = NamingDate.mainn(sd);
                            counter=0;
                            for(dsd=datem15.mainn(dsd);counter<60;dsd=datem15.mainn(dsd),counter++){
                                tmp = new File(ITMadd+"/"+Icode+"/status/"+NamingDateName.mainn(dsd)+".txt");
                                bf = tmp.exists();
                                if(bf == true)
                                    break;
                            }
                            //TextIO.putln(dsd);
                            Scanner read;
                            tmp = new File(ITMadd+"/"+Icode+"/status/"+NamingDateName.mainn(dsd)+".txt");
                            bf = tmp.exists();
                            if(bf){
                                read = new Scanner(new File(ITMadd+"/"+Icode+"/status/"+NamingDateName.mainn(dsd)+".txt"),"UTF-8");
                                ppstck= read.nextLine();
                                pstck = read.nextLine();
                                read.close();
                                }
                            else{
                                pstck = "000.0";
                                ppstck = "000.0";
                            }
                            ppstck = String.valueOf(Float.valueOf(ppstck)+Float.valueOf(pstck));
                            
                            pstck = String.valueOf(-Iqty);
                            try (
                            BufferedWriter writ = Files.newBufferedWriter(Paths.get(ITMadd + "/" + Icode + "/status/" + NamingDateName.mainn(sd) + ".txt"), StandardCharsets.UTF_8,StandardOpenOption.APPEND,StandardOpenOption.CREATE);
                            
                            ) {
                            writ.append(ppstck+"\n"+pstck+"\n");
                            writ.append(sd+","+code.getText()+","+"-"+Iqty+","+Irate+","+Iamt+","+mode+","+"Party"+"\n");
                            writ.flush();
                            //writ.flush();
                            }
                           
                        }
                        
                        
//#########################################################################################################################
                        counter =0;                     //Updating files exist after that date
                        String p;
                        float stck;
                        dsd =NamingDate.mainn(sd);
                        System.out.println("Dsd: "+dsd);
                        for(dsd = datep15.mainn(dsd);counter<60;dsd=datep15.mainn(dsd),counter++){                               //Updating all file created or having date of early created
                            System.out.println("Inside Loop");
                            tmp = new File(ITMadd+"/"+Icode+"/Status/"+NamingDateName.mainn(dsd)+".txt");
                            bg =tmp.exists();
                            if(bg){
                                //TextIO.putln(ITMadd+"/"+icode.getText()+"/Status/"+NamingDateName.mainn(dsd)+".txt");
                                in = new Scanner(tmp,"UTF-8");
                                p = in.nextLine();
                                in.close();
                                stck = Float.valueOf(p) - Iqty;
                                ReplaceLineWN.mainn(ITMadd+"/"+Icode+"/Status", NamingDateName.mainn(dsd)+".txt",1 , String.valueOf(stck));
                                System.out.println(ITMadd+"/"+Icode+"/Status/"+NamingDateName.mainn(dsd)+".txt");
                                }
                        }
//########################################################################################################################3
                    }
                    
//#########################################################################################################################3
                    //Updating totaling of that page
                    //BufferedReader in;
                    in =new Scanner(new File(PRTadd + "/" + code.getText() + STRaddG+"/" + NamingDateName.mainn(sd) + ".txt"),"UTF-8"); //new BufferedReader( stream );
                    in.nextLine();
                    String str = in.nextLine();
                    in.close();
                    float ft = Float.valueOf(str);
                    itotal=Float.valueOf(total.getText());
                    ft = ft + itotal;
                    String Str = String.valueOf(ft);
                    ReplaceLineWN.mainn(PRTadd + "/" + code.getText() + STRaddG, NamingDateName.mainn(sd) + ".txt", 2,Str );
                    //Updating the exist after this date
                     counter=0;
                    Scanner inn;
                    dsd =NamingDate.mainn(sd);
                    for(dsd = datep15.mainn(dsd);counter<60;dsd=datep15.mainn(dsd),counter++){
                        tmp=new File(PRTadd +"/" + code.getText()+ STRaddG+"/"+ NamingDateName.mainn(dsd)+".txt");
                        bg=tmp.exists();
                        if(bg){
                            inn = new Scanner(new File(PRTadd +"/" + code.getText()+ STRaddG+"/"+ NamingDateName.mainn(dsd)+".txt"),"UTF-8");
                            pd = inn.nextLine();
                            inn.close();
                            nd = Float.valueOf(pd)+itotal;
                            ReplaceLineWN.mainn(PRTadd+"/"+code.getText()+STRaddG, NamingDateName.mainn(dsd)+".txt", 1, String.valueOf(nd));
                            }
                        
                    }
                    //###########################################################################################################
                   
                    
                   //System.out.println("Here we goneeeeeeeee for printer"+prntrs);
//###########################################################################################################################3
                    
                   
                } catch (IOException ex) {
                    JLabel label = new JLabel("File Opening !!! Error0012++497!!"+ex);
            label.setFont(new Font("Arial", Font.BOLD, 18));
            JOptionPane.showMessageDialog(this,label,"ERROR",JOptionPane.WARNING_MESSAGE);
                }
                
            } 

//########################################################################################################################3
                if(prntrs){
                    printerr();
                }
//########################################################################################################################3
                    DefaultTableModel dm = (DefaultTableModel)table.getModel();
                    for(int y =dm.getRowCount()-1 ;y>=0;--y)
                    dm.removeRow(y);
                    itotal = 0;
                    total.setText(String.valueOf(itotal));
                    name.setText(null);
                    i=1;
                     rem.setText(remm);
                    sway.setSelectedIndex(Integer.valueOf(Dway));
                    Pmode.setSelectedIndex(Integer.valueOf(Dmode));
                    code.requestFocus();
                    code.selectAll();
            } catch (IOException ex) {
            JLabel label = new JLabel("File opening problem !!! Error0012+1058!!"+ex);
            label.setFont(new Font("Arial", Font.BOLD, 18));
            JOptionPane.showMessageDialog(this,label,"ERROR",JOptionPane.WARNING_MESSAGE);    
            }

       
    }
else{
    code.requestFocus();
          JLabel label = new JLabel("There is Nothing to Save+1070!!");
            label.setFont(new Font("Arial", Font.BOLD, 22));
            JOptionPane.showMessageDialog(this,label,"ERROR",JOptionPane.WARNING_MESSAGE);  
        }   
         }
   //#################################################################################################################3
   //#################################################################################################################3
      
         public void ccompG(){      //Pending Given
             TableModel tm = table.getModel();
        int ty=tm.getRowCount();
        if(ty>0){
    
                 File tempFile = new File( PRTadd + "/" + code.getText() + STRaddG+"/" +NamingDateName.mainn(sd)+ ".txt" );
                 boolean exists = tempFile.exists();
    if(exists){                             // File for that date is Exists then ....

         System.out.println("It's Already There!");       

    }
    else                        // If file for this date is not exists then
    {
                                           // file is not existing for the this date
                // File naming date or file name decider of pervious file
               // System.out.println("Here");
                String tsd=NamingDate.mainn(sd),gsd = NamingDate.mainn(sd),psd = datem15.mainn(NamingDate.mainn(sd));
                String Givenstrp="000.00" ,Givenstrc="000.00",totaldenstr = "000.00";              //str1 is total of that page, str2 is balance of previous page
                File tempFilee;
                boolean existss ;
                
                
                int counter=0;
                for(gsd = datem15.mainn(gsd);counter<60;gsd = datem15.mainn(gsd),counter++){                    //To get before existing file
                    tempFilee = new File(PRTadd + "/" + code.getText() + STRaddG+"/" + NamingDateName.mainn(gsd) + ".txt");
                    existss = tempFilee.exists();
                    if(existss==true)
                        break;
                }
                tsd=gsd;
                for(;DateInBetween.mainn(NamingDate.mainn(tsd),tsd,NamingDate.mainn(psd));tsd = datep15.mainn(tsd)){
                tempFilee = new File(PRTadd + "/" + code.getText() + STRaddT+"/" + NamingDateName.mainn(tsd) + ".txt");
                existss = tempFilee.exists();
                if(existss){                                                            // If previous file exists then do ....
                    
                    Scanner intaken;
                    try {
                        intaken = new Scanner(new File(PRTadd + "/" + code.getText() + STRaddT+"/" + NamingDateName.mainn(tsd) + ".txt"),"UTF-8");
                        String tstr= intaken.nextLine();
                            totaldenstr = String.valueOf(Float.valueOf(totaldenstr)+Float.valueOf(tstr));
                        intaken.close();
                      
                    } catch (FileNotFoundException ex) {
                        JLabel label = new JLabel("File reading/closing problem !!! Error0000++536!!"+ex);
            label.setFont(new Font("Arial", Font.BOLD, 18));
            JOptionPane.showMessageDialog(this,label,"ERROR",JOptionPane.WARNING_MESSAGE);
                    }
                }
                
            }
                tempFilee = new File(PRTadd + "/" + code.getText() + STRaddG+"/" + NamingDateName.mainn(gsd) + ".txt");
                existss = tempFilee.exists();
                if(existss){                                                            // If previous file exists then do ....
                    Scanner ingiven;
                   try {
                        ingiven = new Scanner(new File(PRTadd + "/" + code.getText() + STRaddG+"/" +NamingDateName.mainn(gsd)+ ".txt"),"UTF-8");
                        Givenstrp = ingiven.nextLine();
                            Givenstrc = ingiven.nextLine();
                        ingiven.close();
                    } catch (FileNotFoundException ex) {
                        JLabel label = new JLabel("File reading problem !!! Error0000++558"+ex);
            label.setFont(new Font("Arial", Font.BOLD, 18));
            JOptionPane.showMessageDialog(this,label,"ERROR",JOptionPane.WARNING_MESSAGE);
                    }

                }
                Givenstrp = String.valueOf(Float.valueOf(Givenstrp)+Float.valueOf(Givenstrc) - Float.valueOf(totaldenstr));
                Givenstrc = "00.0";
                try {
                    try (
                    BufferedWriter writ = Files.newBufferedWriter(Paths.get(PRTadd + "/" + code.getText() + STRaddG+"/" + NamingDateName.mainn(sd) + ".txt"), StandardCharsets.UTF_8,StandardOpenOption.APPEND,StandardOpenOption.CREATE);
                    ) {
                    writ.append(Givenstrp+"\n"+Givenstrc+"\n");
                    writ.flush();
                    }
                    } catch (IOException ex) {
                    JLabel label = new JLabel("File reading problem !!! Error0000++584"+ex);
            label.setFont(new Font("Arial", Font.BOLD, 18));
            JOptionPane.showMessageDialog(this,label,"ERROR",JOptionPane.WARNING_MESSAGE);
                }

    }   // Just current file is created if doesn't exists already
    // We move like current file is there do the rest thing 
    
    tempFile = new File( PRTadd + "/" + code.getText() + STRaddG+"/" + NamingDateName.mainn(sd) + ".txt" );
    exists = tempFile.exists();
            
            if(exists)              // File for that date exists then directly update the total and save data to the corresponding
            {
                try {
                  // PrintWriter out,statusout;                    // Detail stord in formate of name \n code \n add \n mob
                  // Detail stord in formate of name \n code \n add \n mob
                    
                    ty=tm.getRowCount();
                    String dsd;
                    int counter;
                    for (int k = 0; k < ty; k++) {
                        Object o = tm.getValueAt(k, 1);
                        String Icode = (String)o;
                        o = tm.getValueAt(k,2);
                        String  Iname = (String)o;
                        o = tm.getValueAt(k,3);
                        float Iqty = (Float)o;
                        o = tm.getValueAt(k, 4);
                        float Irate = (Float)o;
                        o = tm.getValueAt(k, 5);
                        float Iamt = (Float)o;
                        
                        
                        if(k==0)
                            Iname=remadder(Iname);
                        //Iname = new String(Iname.getBytes(),"UTF-8");
                        try {
                                       

                            Path path = Paths.get(PRTadd + "/" + code.getText() + STRaddG+"/" + NamingDateName.mainn(sd) + ".txt");
      
                            BufferedWriter writer = Files.newBufferedWriter(path, StandardCharsets.UTF_8,StandardOpenOption.APPEND);
                            
                            writer.append(sd+",");
                            writer.append(Icode+",");
                            writer.append(Iname+",");
                            writer.append(Iqty+",");
                            writer.append(Irate+",");
                            writer.append(Iamt+"\n");
                            
                            writer.flush();
       
        } catch (IOException e) {
            e.printStackTrace();
            JLabel label1 = new JLabel("File problem 308!!"+e);
                        label1.setFont(new Font("Arial", Font.BOLD, 18));
                        JOptionPane.showMessageDialog(this,label1,"ERROR",JOptionPane.WARNING_MESSAGE);   
        }
                        
                        //####################################################################################################
                        // Now updating stock in item of current
                        String pstck="000.0",ppstck="000.0";
                        File tmp = new File(ITMadd + "/" + Icode + "/status/" + NamingDateName.mainn(sd) + ".txt");
                        boolean bf  = tmp.exists();
                        //TextIO.putln("11111"+bf);
                        if(bf){
                         try (
                        BufferedWriter writ = Files.newBufferedWriter(Paths.get(ITMadd + "/" + Icode + "/status/" + NamingDateName.mainn(sd) + ".txt"), StandardCharsets.UTF_8,StandardOpenOption.APPEND,StandardOpenOption.CREATE);
                        
                        ) {
                        
                        writ.append(sd+","+code.getText()+","+"-"+Iqty+","+Irate+","+Iamt+","+mode+","+"Party"+"\n");
                        writ.flush();
                        }
 
                            Scanner read;
                            pstck="000.0";
                            read = new Scanner(new File(ITMadd + "/" + Icode + "/status/" + NamingDateName.mainn(sd) + ".txt"),"UTF-8");
                            read.nextLine();
                            pstck = read.nextLine();
                            read.close();
                            String nstck = "000.0";
                            nstck = String.valueOf(Float.parseFloat(pstck)-Iqty);
                            ReplaceLineWN.mainn(ITMadd + "/" + Icode + "/status",NamingDateName.mainn(sd) + ".txt", 2, String.valueOf(nstck));
                            }
                        else{
                            dsd = NamingDate.mainn(sd);
                            counter=0;
                            for(dsd=datem15.mainn(dsd);counter<60;dsd=datem15.mainn(dsd),counter++){
                                tmp = new File(ITMadd+"/"+Icode+"/status/"+NamingDateName.mainn(dsd)+".txt");
                                bf = tmp.exists();
                                if(bf == true)
                                    break;
                            }
                            //TextIO.putln(dsd);
                            Scanner read;
                            tmp = new File(ITMadd+"/"+Icode+"/status/"+NamingDateName.mainn(dsd)+".txt");
                            bf = tmp.exists();
                            if(bf){
                                read = new Scanner(new File(ITMadd+"/"+Icode+"/status/"+NamingDateName.mainn(dsd)+".txt"),"UTF-8");
                                ppstck= read.nextLine();
                                pstck = read.nextLine();
                                read.close();
                                }
                            else{
                                pstck = "000.0";
                                ppstck = "000.0";
                            }
                            ppstck = String.valueOf(Float.valueOf(ppstck)+Float.valueOf(pstck));
                            
                            pstck = String.valueOf(-Iqty);
                            try (
                            BufferedWriter writ = Files.newBufferedWriter(Paths.get(ITMadd + "/" + Icode + "/status/" + NamingDateName.mainn(sd) + ".txt"), StandardCharsets.UTF_8,StandardOpenOption.APPEND,StandardOpenOption.CREATE);
                            
                            ) {
                            writ.append(ppstck+"\n"+pstck+"\n");
                            writ.append(sd+","+code.getText()+","+"-"+Iqty+","+Irate+","+Iamt+","+mode+","+"Party"+"\n");
                            writ.flush();
                            //writ.flush();
                            }
                           
                        }
                        
                        
//#########################################################################################################################
                        counter =0;                     //Updating files exist after that date
                        String p;
                        float stck;
                        dsd =NamingDate.mainn(sd);
                        System.out.println("Dsd: "+dsd);
                        for(dsd = datep15.mainn(dsd);counter<60;dsd=datep15.mainn(dsd),counter++){                               //Updating all file created or having date of early created
                            System.out.println("Inside Loop");
                            tmp = new File(ITMadd+"/"+Icode+"/Status/"+NamingDateName.mainn(dsd)+".txt");
                            boolean bg = tmp.exists();
                            if(bg){
                                //TextIO.putln(ITMadd+"/"+icode.getText()+"/Status/"+NamingDateName.mainn(dsd)+".txt");
                                Scanner in = new Scanner(tmp,"UTF-8");
                                p = in.nextLine();
                                in.close();
                                stck = Float.valueOf(p) - Iqty;
                                ReplaceLineWN.mainn(ITMadd+"/"+Icode+"/Status", NamingDateName.mainn(dsd)+".txt",1 , String.valueOf(stck));
                                System.out.println(ITMadd+"/"+Icode+"/Status/"+NamingDateName.mainn(dsd)+".txt");
                                }
                        }
//########################################################################################################################3
                    }
                    
//#########################################################################################################################3
                    //Updating totaling of that page
                    //BufferedReader in;
                    Scanner in = new Scanner(new File(PRTadd + "/" + code.getText() + STRaddG+"/" + NamingDateName.mainn(sd) + ".txt"),"UTF-8"); //new BufferedReader( stream );
                    in.nextLine();
                    String str = in.nextLine();
                    in.close();
                    float ft = Float.valueOf(str);
                    itotal=Float.valueOf(total.getText());
                    ft = ft + itotal;
                    String Str = String.valueOf(ft);
                    ReplaceLineWN.mainn(PRTadd + "/" + code.getText() + STRaddG, NamingDateName.mainn(sd) + ".txt", 2,Str );
                    //Updating the exist after this date
                     counter=0;
                    Scanner inn;
                    dsd =NamingDate.mainn(sd);
                    for(dsd = datep15.mainn(dsd);counter<60;dsd=datep15.mainn(dsd),counter++){
                        File tmp = new File(PRTadd +"/" + code.getText()+ STRaddG+"/"+ NamingDateName.mainn(dsd)+".txt");
                        boolean bg = tmp.exists();
                        if(bg){
                            inn = new Scanner(new File(PRTadd +"/" + code.getText()+ STRaddG+"/"+ NamingDateName.mainn(dsd)+".txt"),"UTF-8");
                            String pd = inn.nextLine();
                            inn.close();
                            float nd = Float.valueOf(pd)+itotal;
                            ReplaceLineWN.mainn(PRTadd+"/"+code.getText()+STRaddG, NamingDateName.mainn(dsd)+".txt", 1, String.valueOf(nd));
                            }
                        
                    }
                    //###########################################################################################################
                   
                    
                   //System.out.println("Here we goneeeeeeeee for printer"+prntrs);
//###########################################################################################################################3
                    
                   
                } catch (IOException ex) {
                    JLabel label = new JLabel("File Opening !!! Error0012++497!!"+ex);
            label.setFont(new Font("Arial", Font.BOLD, 18));
            JOptionPane.showMessageDialog(this,label,"ERROR",JOptionPane.WARNING_MESSAGE);
                }
                
            }else{
                JLabel label = new JLabel("There is problem inside code ");
            label.setFont(new Font("Arial", Font.BOLD, 18));
            JOptionPane.showMessageDialog(this,label,"ERROR",JOptionPane.WARNING_MESSAGE);
            }
//########################################################################################################################3
//Going for Replacement as curruncy
       
            
    tempFile = new File( PRTadd + "/" + code.getText() + STRaddT+"/" +NamingDateName.mainn(sd)+ ".txt" );
    exists = tempFile.exists();
    if(exists){                             // File for that date is Exists then ....

                try { 
                    Scanner in ;
        //FileReader stream;
                    in = new Scanner(new File(PRTadd + "/" + code.getText() + STRaddT+"/" + NamingDateName.mainn(sd) + ".txt"),"UTF-8");
                    String str;
                    
                        str = in.nextLine();
                        in.close();
                    
float ft = Float.valueOf(str);
ft = ft + itotal;
String Str = String.valueOf(ft);
                    try {
                        ReplaceLineWN.mainn(PRTadd + "/" + code.getText() + STRaddT, NamingDateName.mainn(sd) + ".txt", 1, Str);
                    } catch (IOException ex) {
                        JLabel label = new JLabel("taken total updation problem !!! Error0014++828!!"+ex);
            label.setFont(new Font("Arial", Font.BOLD, 18));
            JOptionPane.showMessageDialog(this,label,"ERROR",JOptionPane.WARNING_MESSAGE);
                    }
                } catch (FileNotFoundException ex) {
                    JLabel label = new JLabel("PRT data Date. file not close/open !!! Error0012+++833!!"+ex);
            label.setFont(new Font("Arial", Font.BOLD, 18));
            JOptionPane.showMessageDialog(this,label,"ERROR",JOptionPane.WARNING_MESSAGE);
                }

    }
    else                        // If file for this date is not exists then
    {

                try {                       // Go to set file in required formate
                    try (
                    BufferedWriter writ = Files.newBufferedWriter(Paths.get(PRTadd + "/" + code.getText() + STRaddT+"/" + NamingDateName.mainn(sd) + ".txt"), StandardCharsets.UTF_8,StandardOpenOption.APPEND,StandardOpenOption.CREATE);
                    
                    ) {
                    
                    writ.append(String.valueOf(itotal)+"\n");
                    writ.flush();
                    }
                    } catch (IOException ex) {
                    JLabel label = new JLabel("Total updation error !!! Error0013+856!!"+ex);
            label.setFont(new Font("Arial", Font.BOLD, 18));
            JOptionPane.showMessageDialog(this,label,"ERROR",JOptionPane.WARNING_MESSAGE);
        
                }


    }
    
//####################################################################################################################################################################
                            int counter=0;              // updating future given files                                                  // Updating given as we take something from CUmstomer
                            File tmp;
                            Scanner in;
                            String pd;
                            float nd;
                            boolean bg;
                            String dsd =NamingDate.mainn(sd);
                           try{ 
                               for(dsd = datep15.mainn(dsd);counter<60;dsd=datep15.mainn(dsd),counter++){
                                tmp=new File(PRTadd +"/" + code.getText()+ STRaddG+"/"+ NamingDateName.mainn(dsd)+".txt");
                                bg=tmp.exists();
                                if(bg){
                                in = new Scanner(new File(PRTadd +"/" + code.getText()+ STRaddG+"/"+ NamingDateName.mainn(dsd)+".txt"),"UTF-8");   
                                pd = in.nextLine();
                                nd = Float.valueOf(pd)-Float.valueOf(total.getText());
                                in.close();
                                ReplaceLineWN.mainn(PRTadd+"/"+code.getText()+STRaddG, NamingDateName.mainn(dsd)+".txt", 1, String.valueOf(nd));
                                }
                                
                            }
                           }catch (FileNotFoundException ex) {
                            JLabel label = new JLabel("PRT Given data Date. file not close/open !!! Error0012+887!!"+ex);
                            label.setFont(new Font("Arial", Font.BOLD, 18));
                            JOptionPane.showMessageDialog(this,label,"ERROR",JOptionPane.WARNING_MESSAGE);
                        }catch (IOException ex) {
                            JLabel label = new JLabel("PRT Given data Date. file not closes/opens !!! Error0012++890!!"+ex);
            label.setFont(new Font("Arial", Font.BOLD, 18));
            JOptionPane.showMessageDialog(this,label,"ERROR",JOptionPane.WARNING_MESSAGE);
                        }
                          
  
    
        try {                           // Set all item and item details to the permanent files
                //PrintWriter out,statusout;  // Detail stord in formate of name \n code \n add \n mob
                // Detail stord in formate of name \n code \n add \n mob
                
                for (int k = 0; k < tm.getRowCount(); k++) {
    Object o;
                        String Icode = repicode;
                        o = tm.getValueAt(k,2);
                        String  Iname =repiname+" "+ (String)o;
                        float Irate = Float.valueOf(repirate);
                        o = tm.getValueAt(k, 5);
                        float Iamt = (Float)o;
                        float Iqty = Iamt/Irate;;
                        
    if(k==0)
        Iname=remadder(Iname);
    try ( 
                              BufferedWriter writ = Files.newBufferedWriter(Paths.get(PRTadd + "/" + code.getText() + STRaddT+"/" + NamingDateName.mainn(sd) + ".txt"), StandardCharsets.UTF_8,StandardOpenOption.APPEND);
                              
                   ) {
                          
                   writ.append(sd+","+Icode+","+Iname+","+Iqty+","+Irate+","+Iamt+"\n");
                   writ.flush();
                      }
                    //####################################################################################################
                    // Now updating statuts
                    String pstck="000.0",ppstck="000.0";
                    tmp = new File(ITMadd + "/" + Icode + "/status/" + NamingDateName.mainn(sd) + ".txt");
                    boolean bf  = tmp.exists();
                    //TextIO.putln("11111"+bf);
                    if(bf){
                         try ( 
                              BufferedWriter writ = Files.newBufferedWriter(Paths.get(ITMadd + "/" + Icode + "/status/" + NamingDateName.mainn(sd) + ".txt"), StandardCharsets.UTF_8,StandardOpenOption.APPEND,StandardOpenOption.CREATE);
                              
                   ) {
                          
                   writ.append(sd+","+code.getText()+","+Iqty+","+Irate+","+Iamt+","+mode+","+"Party"+"\n");
                   writ.flush();
                      }
                    Scanner read;
                    pstck="000.0";
                    read = new Scanner(new File(ITMadd + "/" + Icode + "/status/" + NamingDateName.mainn(sd) + ".txt"),"UTF-8");
                    read.nextLine();
                    pstck = read.nextLine();
                    read.close();
                    String nstck = "000.0";
                    nstck = String.valueOf(Float.parseFloat(pstck)+Iqty);
                    ReplaceLineWN.mainn(ITMadd + "/" + Icode + "/status",NamingDateName.mainn(sd)+ ".txt", 2, String.valueOf(nstck));
                    }
                    else{
                        dsd = NamingDate.mainn(sd);
                        counter=0;
                        for(;counter<60;dsd=datem15.mainn(dsd),counter++){                           // To get previous existing file
                        tmp = new File(ITMadd+"/"+Icode+"/status/"+NamingDateName.mainn(dsd)+".txt");
                        //TextIO.putln(ITMadd+"/"+Icode+"/status/"+NamingDateName.mainn(dsd)+".txt");
                        bf = tmp.exists();
                        if(bf==true)
                            break;
                        }
                        tmp = new File(ITMadd+"/"+Icode+"/status/"+NamingDateName.mainn(dsd)+".txt");
                        bf = tmp.exists();
                        Scanner read;
                        if(bf){
                        read = new Scanner(new File(ITMadd+"/"+Icode+"/status/"+NamingDateName.mainn(dsd)+".txt"),"UTF-8");
                        ppstck = read.nextLine();
                        pstck = read.nextLine();
                        ppstck = String.valueOf(Float.valueOf(ppstck)+Float.valueOf(pstck));
                        read.close();
                        }
                        else{
                            pstck = "000.0";
                        }
                        pstck = String.valueOf(Iqty);
                        ////TextIO.putln("Pstck    "+pstck);
try ( 
        BufferedWriter writ = Files.newBufferedWriter(Paths.get(ITMadd + "/" + Icode + "/status/" + NamingDateName.mainn(sd) + ".txt"), StandardCharsets.UTF_8,StandardOpenOption.APPEND,StandardOpenOption.CREATE);
                              
                   ) {
                          
                   writ.append(ppstck+"\n"+pstck+"\n"+sd+","+code.getText()+","+Iqty+","+Irate+","+Iamt+","+mode+","+"Party"+"\n");
                   writ.flush();
                      }
                    }
                             //Over of updation of status of current
//#########################################################################################################################
                    counter =0;                 //Updating future files
                    String p;
                    float stck;
                    dsd =NamingDate.mainn(sd);
                            for(dsd = datep15.mainn(dsd);counter<60;dsd=datep15.mainn(dsd),counter++){  
                                System.out.println(ITMadd+"/"+Icode+"/Status/"+NamingDateName.mainn(dsd)+".txt");//Updating all file created or having date of early created
                                tmp = new File(ITMadd+"/"+Icode+"/Status/"+NamingDateName.mainn(dsd)+".txt");
                                bg =tmp.exists();
                                if(bg){
                                    
                                   //TextIO.putln(ITMadd+"/"+icode.getText()+"/Status/"+NamingDateName.mainn(dsd)+".txt");
                                 in = new Scanner(tmp,"UTF-8");
                            p = in.nextLine();
                            in.close();
                            stck = Float.valueOf(p) + Iqty;
                            ReplaceLineWN.mainn(ITMadd+"/"+Icode+"/Status", NamingDateName.mainn(dsd)+".txt",1 , String.valueOf(stck));
                            
                                }
                            }
//########################################################################################################################3
                }
//########################################################################################################################3
                //System.out.println("Bcond::"+prntrs);
                if(prntrs){
                    printerr();
                }
//########################################################################################################################3
                    DefaultTableModel dm = (DefaultTableModel)table.getModel();
                    for(int y =dm.getRowCount()-1 ;y>=0;--y)
                    dm.removeRow(y);
                    itotal = 0;
                    total.setText(String.valueOf(itotal));
                    name.setText(null);
                    i=1;
                     rem.setText(remm);
                    sway.setSelectedIndex(Integer.valueOf(Dway));
                    Pmode.setSelectedIndex(Integer.valueOf(Dmode));
                    code.requestFocus();
                    code.selectAll();
            } catch (IOException ex) {
            JLabel label = new JLabel("File opening problem !!! Error0012+1058!!"+ex);
            label.setFont(new Font("Arial", Font.BOLD, 18));
            JOptionPane.showMessageDialog(this,label,"ERROR",JOptionPane.WARNING_MESSAGE);    
            }

             
            
    }
        else{
            code.requestFocus();
            JLabel label = new JLabel("There is Nothing To save !!++798");
            label.setFont(new Font("Arial", Font.BOLD, 18));
            JOptionPane.showMessageDialog(this,label,"ERROR",JOptionPane.WARNING_MESSAGE);  
        }
}
         
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        name = new javax.swing.JTextField();
        code = new javax.swing.JTextField();
        icode = new javax.swing.JTextField();
        iname = new javax.swing.JTextField();
        rate = new javax.swing.JTextField();
        qty = new javax.swing.JTextField();
        add = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        iqtylbl = new javax.swing.JLabel();
        irtlbl = new javax.swing.JLabel();
        tamtlbl = new javax.swing.JLabel();
        total = new javax.swing.JTextField();
        Bcloser = new javax.swing.JButton();
        dtlbl = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        datee = new javax.swing.JLabel();
        Bcompleted = new javax.swing.JButton();
        Bclear = new javax.swing.JButton();
        Pmode = new javax.swing.JComboBox();
        mdlbl = new javax.swing.JLabel();
        hdlbl = new javax.swing.JLabel();
        tbllbl = new javax.swing.JLabel();
        amt = new javax.swing.JTextField();
        iamtlbl = new javax.swing.JLabel();
        SCP = new javax.swing.JScrollPane();
        newtb = new javax.swing.JTable();
        button1 = new java.awt.Button();
        rem = new javax.swing.JTextField();
        waylbl = new javax.swing.JLabel();
        sway = new javax.swing.JComboBox();
        remlbl = new javax.swing.JLabel();
        cslbl = new javax.swing.JLabel();
        cnsts = new javax.swing.JTextField();
        inmlbl = new javax.swing.JLabel();
        icdlbl = new javax.swing.JLabel();
        cnmlbl = new javax.swing.JLabel();
        ccdlbl = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Supplier Transaction Menu");

        name.setEditable(false);
        name.setFont(new java.awt.Font("Monospaced", 1, 36)); // NOI18N
        name.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                nameFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                nameFocusLost(evt);
            }
        });
        name.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nameActionPerformed(evt);
            }
        });
        name.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                nameKeyPressed(evt);
            }
        });

        code.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        code.setText("0001");
        code.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                codeFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                codeFocusLost(evt);
            }
        });
        code.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                codeActionPerformed(evt);
            }
        });
        code.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                codeKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                codeKeyTyped(evt);
            }
        });

        icode.setFont(new java.awt.Font("Monospaced", 1, 36)); // NOI18N
        icode.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                icodeFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                icodeFocusLost(evt);
            }
        });
        icode.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                icodeKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                icodeKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                icodeKeyTyped(evt);
            }
        });

        iname.setFont(new java.awt.Font("Monospaced", 1, 36)); // NOI18N
        iname.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                inameFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                inameFocusLost(evt);
            }
        });
        iname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inameActionPerformed(evt);
            }
        });
        iname.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                inameKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                inameKeyTyped(evt);
            }
        });

        rate.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        rate.setText("0");
        rate.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                rateFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                rateFocusLost(evt);
            }
        });
        rate.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                rateKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                rateKeyTyped(evt);
            }
        });

        qty.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        qty.setText("1");
        qty.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                qtyFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                qtyFocusLost(evt);
            }
        });
        qty.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                qtyKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                qtyKeyTyped(evt);
            }
        });

        add.setFont(new java.awt.Font("Monospaced", 1, 24)); // NOI18N
        add.setText("Add");
        add.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                addItemStateChanged(evt);
            }
        });
        add.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                addFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                addFocusLost(evt);
            }
        });
        add.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                addMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                addMouseExited(evt);
            }
        });
        add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addActionPerformed(evt);
            }
        });
        add.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                addKeyPressed(evt);
            }
        });

        table.setFont(new java.awt.Font("Monospaced", 1, 14)); // NOI18N
        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Serial No.", "Item Code", "Item Name", "Quantity", "Rate", "Amount"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Float.class, java.lang.Float.class, java.lang.Float.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        table.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        table.setRowHeight(20);
        table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableMouseClicked(evt);
            }
        });
        table.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tableKeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(table);
        if (table.getColumnModel().getColumnCount() > 0) {
            table.getColumnModel().getColumn(0).setMinWidth(50);
            table.getColumnModel().getColumn(0).setPreferredWidth(80);
            table.getColumnModel().getColumn(0).setMaxWidth(100);
            table.getColumnModel().getColumn(1).setMinWidth(0);
            table.getColumnModel().getColumn(1).setPreferredWidth(100);
            table.getColumnModel().getColumn(2).setMinWidth(0);
            table.getColumnModel().getColumn(3).setMinWidth(0);
            table.getColumnModel().getColumn(4).setMinWidth(0);
            table.getColumnModel().getColumn(5).setMinWidth(0);
        }

        iqtylbl.setFont(new java.awt.Font("Monospaced", 1, 12)); // NOI18N
        iqtylbl.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        iqtylbl.setText("Quantity :");

        irtlbl.setFont(new java.awt.Font("Monospaced", 1, 14)); // NOI18N
        irtlbl.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        irtlbl.setText("Rate :");

        tamtlbl.setFont(new java.awt.Font("Monospaced", 1, 15)); // NOI18N
        tamtlbl.setText("Total Amount :");

        total.setEditable(false);
        total.setBackground(new java.awt.Color(240, 240, 0));
        total.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        total.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                totalActionPerformed(evt);
            }
        });

        Bcloser.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        Bcloser.setText("Close");
        Bcloser.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                BcloserFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                BcloserFocusLost(evt);
            }
        });
        Bcloser.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                BcloserMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                BcloserMouseExited(evt);
            }
        });
        Bcloser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BcloserActionPerformed(evt);
            }
        });

        dtlbl.setFont(new java.awt.Font("Monospaced", 1, 13)); // NOI18N
        dtlbl.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        dtlbl.setText("Date :");

        datee.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        datee.setText("Date");
        datee.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                dateeMouseClicked(evt);
            }
        });

        Bcompleted.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        Bcompleted.setText("Complete");
        Bcompleted.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                BcompletedFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                BcompletedFocusLost(evt);
            }
        });
        Bcompleted.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                BcompletedMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                BcompletedMouseExited(evt);
            }
        });
        Bcompleted.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BcompletedActionPerformed(evt);
            }
        });
        Bcompleted.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                BcompletedKeyPressed(evt);
            }
        });

        Bclear.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        Bclear.setText("Clear");
        Bclear.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                BclearFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                BclearFocusLost(evt);
            }
        });
        Bclear.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                BclearMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                BclearMouseExited(evt);
            }
        });
        Bclear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BclearActionPerformed(evt);
            }
        });

        Pmode.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        Pmode.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Pending", "By Cash" }));
        Pmode.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                PmodeKeyPressed(evt);
            }
        });

        mdlbl.setFont(new java.awt.Font("Monospaced", 1, 16)); // NOI18N
        mdlbl.setText("Mode :");

        hdlbl.setFont(new java.awt.Font("Monospaced", 1, 20)); // NOI18N
        hdlbl.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        hdlbl.setText("!! Supplier TRASACTION MENU  !!");
        hdlbl.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        tbllbl.setFont(new java.awt.Font("Monospaced", 1, 13)); // NOI18N
        tbllbl.setText("Added items are below ");
        tbllbl.setRequestFocusEnabled(false);

        amt.setEditable(false);
        amt.setBackground(new java.awt.Color(240, 0, 0));
        amt.setFont(new java.awt.Font("Tahoma", 1, 40)); // NOI18N
        amt.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        amt.setText("0");
        amt.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                amtFocusGained(evt);
            }
        });
        amt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                amtKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                amtKeyTyped(evt);
            }
        });

        iamtlbl.setFont(new java.awt.Font("Monospaced", 1, 12)); // NOI18N
        iamtlbl.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        iamtlbl.setText("Amount:");

        SCP.setViewportBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        SCP.setEnabled(false);
        SCP.setFocusCycleRoot(true);
        SCP.setRequestFocusEnabled(false);
        SCP.setVerifyInputWhenFocusTarget(false);

        newtb.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Code", "Name", "Rate"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        SCP.setViewportView(newtb);

        button1.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        button1.setLabel("Setting");
        button1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                button1FocusLost(evt);
            }
        });
        button1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button1ActionPerformed(evt);
            }
        });

        rem.setFont(new java.awt.Font("Monospaced", 0, 13)); // NOI18N
        rem.setText("Self");
        rem.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                remFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                remFocusLost(evt);
            }
        });
        rem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                remActionPerformed(evt);
            }
        });
        rem.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                remKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                remKeyTyped(evt);
            }
        });

        waylbl.setFont(new java.awt.Font("Monospaced", 1, 16)); // NOI18N
        waylbl.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        waylbl.setText("Way :");

        sway.setFont(new java.awt.Font("Monospaced", 1, 16)); // NOI18N
        sway.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Becha", "Kharida" }));
        sway.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                swayKeyPressed(evt);
            }
        });

        remlbl.setFont(new java.awt.Font("Monospaced", 1, 13)); // NOI18N
        remlbl.setText("Remark:");

        cslbl.setFont(new java.awt.Font("Monospaced", 1, 14)); // NOI18N
        cslbl.setText("CStatus :");

        cnsts.setEditable(false);
        cnsts.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        cnsts.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        cnsts.setText("0.0");

        inmlbl.setFont(new java.awt.Font("Monospaced", 1, 14)); // NOI18N
        inmlbl.setText("Item Name :");

        icdlbl.setFont(new java.awt.Font("Monospaced", 1, 14)); // NOI18N
        icdlbl.setText("Item Code :");

        cnmlbl.setFont(new java.awt.Font("Monospaced", 1, 14)); // NOI18N
        cnmlbl.setText("Name :");

        ccdlbl.setFont(new java.awt.Font("Monospaced", 1, 14)); // NOI18N
        ccdlbl.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        ccdlbl.setText("Code :");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addComponent(mdlbl, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(5, 5, 5)
                        .addComponent(Pmode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(waylbl, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addComponent(sway, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(remlbl)
                        .addGap(5, 5, 5)
                        .addComponent(rem, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(cslbl)
                        .addGap(12, 12, 12)
                        .addComponent(cnsts, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(tamtlbl)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(total, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(dtlbl)
                                .addGap(7, 7, 7)
                                .addComponent(datee, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(button1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(31, 31, 31)
                        .addComponent(SCP, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(457, 457, 457)
                        .addComponent(Bcloser, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(52, 52, 52)
                        .addComponent(Bclear, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(34, 34, 34)
                        .addComponent(Bcompleted, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(10, 10, 10))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1)
                        .addGap(7, 7, 7))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(34, 34, 34)
                                .addComponent(ccdlbl, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(12, 12, 12)
                                .addComponent(code, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(166, 166, 166)
                                .addComponent(cnmlbl, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10)
                                .addComponent(name))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addContainerGap()
                                        .addComponent(irtlbl, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(rate, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(34, 34, 34)
                                        .addComponent(icdlbl)
                                        .addGap(12, 12, 12)
                                        .addComponent(icode, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(131, 131, 131)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(inmlbl)
                                        .addGap(12, 12, 12)
                                        .addComponent(iname))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(iqtylbl, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(12, 12, 12)
                                        .addComponent(qty)
                                        .addGap(45, 45, 45)
                                        .addComponent(iamtlbl, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(12, 12, 12)
                                        .addComponent(amt)
                                        .addGap(29, 29, 29)
                                        .addComponent(add, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                        .addGap(3, 3, 3))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addComponent(hdlbl, javax.swing.GroupLayout.PREFERRED_SIZE, 1302, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(60, 60, 60)
                                .addComponent(jLabel8)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(9, 9, 9))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tbllbl, javax.swing.GroupLayout.PREFERRED_SIZE, 1295, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(hdlbl, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 43, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(ccdlbl, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(code, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addComponent(cnmlbl, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(name, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(icdlbl))
                    .addComponent(icode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(inmlbl))
                    .addComponent(iname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(rate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(irtlbl, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addComponent(iqtylbl, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(qty, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addComponent(iamtlbl, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(amt, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(add, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addComponent(tbllbl)
                .addGap(7, 7, 7)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 523, Short.MAX_VALUE)
                .addGap(7, 7, 7)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(mdlbl))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(Pmode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(waylbl))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(7, 7, 7)
                        .addComponent(sway, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addComponent(remlbl))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(rem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(cslbl))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(cnsts, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(total, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(tamtlbl, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(7, 7, 7)
                .addComponent(jLabel8)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(5, 5, 5)
                                .addComponent(dtlbl))
                            .addComponent(datee, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(10, 10, 10)
                        .addComponent(button1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(61, 61, 61)
                        .addComponent(SCP, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(Bcloser, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Bclear, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Bcompleted, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
int i=1;
int editt =-2 ;
float ptotal=0;
float amtdiff = 0;
float itotal=0;

//###################################################################################################################

    private void addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addActionPerformed
                                                                                // Add a row to Table
                                                                            // Add a row to Table
                                                                // This will adding the row to the table with detail as required for  table completion
                    // for Action
                       DefaultTableModel model = (DefaultTableModel)table.getModel();
                       //System.out.println(icode.getText().compareTo(""));
                       //System.out.println(icode.getText().isEmpty());
                       //System.out.println("::::"+Integer.valueOf(icode.getText())+"::::");
                       if(icode.getText().compareTo("")!=0){
Float iqty;
iqty = Float.parseFloat(qty.getText());
float irate =  Float.parseFloat(rate.getText());
float iamt =  Float.valueOf(amt.getText());
itotal=itotal+iamt;


                   if(editt>=0){                    // If this process going on if we are editing the existing or enetered detail but that are preasent in Table
                       int rowww =editt;
                       itotal = ptotal+iamt;
                       amtdiff = 0;
                       model.setValueAt(icode.getText(), rowww,1);
                       model.setValueAt(iname.getText(), rowww, 2);
                       model.setValueAt(irate, rowww,4);
                       model.setValueAt(iqty, rowww, 3);
                       model.setValueAt(iamt, rowww, 5);
                       total.setText(String.valueOf(itotal));
                       editt=-2;
                       table.clearSelection();
                       
                   }
                   else                         //This adding fresh itemor new entry and their details to the tabke
                   {
              model.addRow(new Object[]{i++,icode.getText(),iname.getText(),iqty,irate,iamt});
                   total.setText(String.valueOf(itotal));
                   
          
                   }
                   yt=0;
                   qty.setText("1.0");
                   rate.setText("0.0");
                   amt.setText("0.0");
                   iname.setText(null);
                   icode.setText(null);
          icode.requestFocus();
    }else{
                           icode.requestFocus();
                           JLabel label = new JLabel("This item code does not exist !!! ");
        label.setFont(new Font("Arial", Font.BOLD, 18));
        JOptionPane.showMessageDialog(this,label,"Warning !!",JOptionPane.WARNING_MESSAGE);
                       }

}//GEN-LAST:event_addActionPerformed

    //###################################################################################################################

    private void totalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_totalActionPerformed
        // TODO add your handling code here:
}//GEN-LAST:event_totalActionPerformed

    private void BcloserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BcloserActionPerformed
//JOptionPane.showConfirmDialog(rootPane, baseadd)
        int yon = JOptionPane.showConfirmDialog(this,"Do you want to Close ??\n !!!The data you just entered will not be saved !!!","Confirmation .......",JOptionPane.OK_OPTION);
        if(yon==0){//YES    }
            this.dispose();                       // Finally Disposing the Jframe
        }else{
            icode.requestFocus();
        }

}//GEN-LAST:event_BcloserActionPerformed

    private void nameFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_nameFocusGained
if(lang.compareToIgnoreCase("English")!=0){
    try {
        Robot r=new Robot();
        r.keyPress(KeyEvent.VK_ALT);
        r.keyPress(KeyEvent.VK_SHIFT);
        r.keyPress(KeyEvent.VK_1);
        r.keyRelease(KeyEvent.VK_1);
        r.keyRelease(KeyEvent.VK_SHIFT);
        r.keyRelease(KeyEvent.VK_ALT);
    } catch (AWTException ex) {
        JLabel label = new JLabel("Languae Setup Error!!!"+ex);
        label.setFont(new Font("Arial", Font.BOLD, 18));
        JOptionPane.showMessageDialog(this,label,"ERROR",JOptionPane.WARNING_MESSAGE);
    }
        }
    }//GEN-LAST:event_nameFocusGained

    private void icodeKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_icodeKeyPressed
if(evt.isControlDown()&&evt.getKeyCode()==KeyEvent.VK_C)
    Bcompleted.doClick();
else{
    if(evt.isControlDown()&&evt.getKeyCode()==KeyEvent.VK_R)
        rem.requestFocus();
    else{
        if(evt.isControlDown()&&evt.getKeyCode()==KeyEvent.VK_W)
        sway.requestFocus();
    else{
        if(evt.isControlDown()&&evt.getKeyCode()==KeyEvent.VK_D)
        Bclear.doClick();
    else{
        if(evt.isControlDown()&&evt.getKeyCode()==KeyEvent.VK_M)
        Pmode.requestFocus();
      else{
            if(evt.isControlDown()&&evt.getKeyCode()==KeyEvent.VK_LEFT){
                                   code.requestFocus();
                               }
                               else{
                                   if(evt.isControlDown()&&evt.getKeyCode()==KeyEvent.VK_RIGHT){
                                       iname.requestFocus();
                                   }
                               }
        }  
    }
    }
    }
}
    }//GEN-LAST:event_icodeKeyPressed

    private void addKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_addKeyPressed
                                                                                // Add a row to Table
                                                             // This will adding the row to the table with detail as required for  table completion
        int a = evt.getKeyCode();
    
                   if (a == 10) {                     // for enter key
                       add.doClick();
                   }else{
            if(evt.isControlDown()&&evt.getKeyCode()==KeyEvent.VK_LEFT){
                                    qty.requestFocus();
                               }
                               else{
                                   if(evt.isControlDown()&&evt.getKeyCode()==KeyEvent.VK_RIGHT){
                                       add.requestFocus();
                                   }
                               } 
        }
                       
    
    }//GEN-LAST:event_addKeyPressed
int y=0;
    private void rateKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_rateKeyPressed

        int a = evt.getKeyCode();
        if (a == 10) {                     // for enter key
          if(y==1){
              float amtt = Float.valueOf(rate.getText());
              float qtyy = Float.valueOf(qty.getText());
              float ratee = amtt/qtyy;
              rate.setText(String.format("%.2f", ratee));
              amt.setText(String.format("%.0f",amtt));
              y=0;
              amtd=1;
          }
          if(rate.getText().isEmpty()){
              rate.setText("0.0");
              qty.requestFocus();
          }else{
            qty.requestFocus();
          }
          
        }
        else{
            if(a==82){
                 y=1; 
            }else{
            if(evt.isControlDown()&&evt.getKeyCode()==KeyEvent.VK_LEFT){
                                    iname.requestFocus();
                               }
                               else{
                                   if(evt.isControlDown()&&evt.getKeyCode()==KeyEvent.VK_RIGHT){
                                       qty.requestFocus();
                                   }
                               } 
        }
        }
    }//GEN-LAST:event_rateKeyPressed

    private void qtyKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_qtyKeyPressed
        int a = evt.getKeyCode();
        if (a == 10) {                     // for enter key
          if(y==1){
              float amtt = Float.valueOf(qty.getText());
              float ratee = Float.valueOf(rate.getText());
              float qtyy = amtt/ratee;
              qty.setText(String.format("%.2f", qtyy));
              amt.setText(String.format("%.0f",amtt));
              y=0;
              amtd=1;
          }
          if(qty.getText().isEmpty()){
              qty.setText("1.0");
              add.requestFocus();
          }else{
            add.requestFocus();
          }
          
        }
        else{
            if(a==81){
                //System.out.println("There is r key preassed");
                 y=1; 
            }else{
            if(evt.isControlDown()&&evt.getKeyCode()==KeyEvent.VK_LEFT){
                                    rate.requestFocus();
                               }
                               else{
                                   if(evt.isControlDown()&&evt.getKeyCode()==KeyEvent.VK_RIGHT){
                                       add.requestFocus();
                                   }
                               } 
        }  
        }
    }//GEN-LAST:event_qtyKeyPressed

    //#########################################################################################################
    private void tableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableMouseClicked
                                                                 
         
    }//GEN-LAST:event_tableMouseClicked
  public float csts(String cd){
      float crnsts=0;
      
         
        
        
//#########################################################################################################################################################        
        
        
        
        //    Scanner read ;
        try {
            

                float  CStatus = (float) 000.00;
                String pcode,PGstr1="000.00",PGstr2="000.00",PTstr1 = "000.00";
                float TotalG = (float) 000.00,TotalT = (float) 000.00;
                String CGstr1 = "000.00",CTstr1 = "000.00";
      
      pcode = String.format("%04d", Integer.valueOf(code.getText()));
      Scanner inread ;
//#########################################################################################################################################################              
               
//#########################################################################################################################################################              
      
                File tmp;boolean fs=false;
      //int counter =0;

 boolean Cexist=false;
      String dsd = NamingDate.mainn(sd);
for(;DateInBetween.mainn(DtAdd, dsd, sd);dsd =datem15.mainn(dsd)){                             //To find the earliest Existing file
       tmp = new File(PRTadd+"/"+pcode+"/Pending/Given/"+NamingDateName.mainn(dsd)+".txt");
      fs = tmp.exists();
      //TextIO.putln(PRTadd+"/"+pcode+"/Pendng/Given/"+NamingDateName.mainn(dsd)+".txt"+"\t"+fs);
      if(fs){
          Cexist=true;
      break;
      }
}
if(!Cexist){
    CStatus=(-1)*(Float.valueOf(IntialS));
}
//########################################################################################################
tmp = new File(PRTadd+"/"+pcode+"/Pending/Given/"+NamingDateName.mainn(dsd)+".txt");
      fs = tmp.exists();
               // TextIO.putln(PRTadd+"/"+pcode+"/Pendng/Given/"+NamingDateName.mainn(dsd)+".txt"+"\t"+fs);
      if(fs){

      inread = new Scanner(tmp,"UTF-8");          // to get the name of party
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
      CGstr1 = inread.next();  // name of party having code pcode
      TotalG = TotalG + Float.valueOf(CGstr1);
      }
      else
          inread.nextLine();
      }
      inread.close();
      }


      
//########################################################################################################
for(String ttd=dsd;DateInBetween.mainn(NamingDate.mainn(dsd), ttd, sd);ttd =datep15.mainn(ttd)){                             //To find the earliest Existing file
       tmp = new File(PRTadd+"/"+pcode+"/Pending/Taken/"+NamingDateName.mainn(ttd)+".txt");
      fs = tmp.exists();
      if(fs){
     inread = new Scanner(tmp,"UTF-8");          // to get the name of party
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
      CTstr1 = inread.next();                // name of party having code pcode
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
            JLabel label = new JLabel("not getting access to Party member  !!! Error0007"+ex);
            label.setFont(new Font("Arial", Font.BOLD, 18));
            JOptionPane.showMessageDialog(this,label,"ERROR",JOptionPane.WARNING_MESSAGE);
       }

      return crnsts;
  }
    public String bnam(float cs){
       String rtn=null;
       if(cs<0){
           rtn=blbl;
       }
       else{
           if(cs>0)
           rtn= jlbl;
           else
               rtn="     ";
       }
       return(rtn);
   }

int lastpi=0;    
public void printerr(){  PrinterJob pj = PrinterJob.getPrinterJob(); 

        pj.setPrintable(new BillPrintable(),getPageFormat(pj));
        try {
             pj.print();
          
        }
         catch (PrinterException ex) {
                 ex.printStackTrace();
        }
}
//#########################################################################################################
public String stringl(String A,int sz){
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
public String stringc(String A,int sz){
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
        return B;
}
public String stringr(String A,int sz){
    String B ;
    
    int si = A.length();
    //System.out.println(A+"  "+si);
    if(sz<si)
        B = A.substring(0, sz);
    else{
        B=A;
        for(int sp=0;sp<(sz-si);++sp){
            B=" "+B;
        }
    }
        return B;
}
//###################################################################################################################
public class BillPrintable implements Printable {
    
   
    
    
  public int print(Graphics graphics, PageFormat pageFormat,int pageIndex) 
  throws PrinterException 
  {    
      int result = NO_SUCH_PAGE; 
                
      if(sway.getSelectedIndex()==0){
         
        if (pageIndex == 0) {                    
        
            Graphics2D g2d = (Graphics2D) graphics;                    

           
            g2d.translate((int) pageFormat.getImageableX(),(int) pageFormat.getImageableY()); 

            //#########################################################################################################################################################              
      
                
      
      
//########################################################################################################

      float CStatus = Float.valueOf(cnsts.getText());
            
            
            
            
              
        try{
            /*Draw Header*/
            int y=1;
            int yShift = 10;
            int headerRectHeight=15;
           
              TableModel tm = table.getModel();  
             g2d.setFont(new Font("Monospaced",Font.PLAIN,9));
            g2d.drawString("-------------------------------------",10,y);y+=yShift;
            g2d.setFont(new Font("Monospaced",Font.PLAIN,9));
            g2d.drawString(stringc(Sname,35),12,y);y+=yShift;
            g2d.setFont(new Font("Monospaced",Font.PLAIN,9));
            g2d.drawString(stringr("Mob.:"+Sno,36),10,y);y+=yShift;
            g2d.drawString("-------------------------------------",10,y);y+=yShift;
            g2d.setFont(new Font("Monospaced",Font.BOLD,9));
            //System.out.println(name.getText());
            g2d.drawString(code.getText()+"    "+stringr(name.getText(),cnmlength),10,y);y+=yShift;
            g2d.setFont(new Font("Monospaced",Font.PLAIN,9));
            g2d.drawString(dtlbl.getText()+sd+"   "+stringr(mdlbl.getText()+mode,18),10,y);y+=headerRectHeight;
            if(lang.compareToIgnoreCase("English")!=0){
               //g2d.drawString("Name           Qty *   Rate = T.Price",10,y);
               g2d.drawString("नाम             मात्रा *   रेट    =  रकम ", 10, y);y+=yShift;
            }else{
             g2d.drawString("Name           Qty *   Rate = T.Price",10,y);y+=yShift;   
            }
            
            g2d.drawString("-------------------------------------",10,y);y+=yShift;
            for (int k = 0; k < tm.getRowCount(); k++) {
                Object o= tm.getValueAt(k,2);
                        String  Iname = (String)o;
                        o = tm.getValueAt(k,3);
                        float Iqty = (Float)o;
                        o = tm.getValueAt(k, 4);
                        float Irate = (Float)o;
                        o = tm.getValueAt(k, 5);
                        float Iamt = (Float)o;
              //g2d.drawString(stringl(Iname,10)+String.format("%8.1f",Iqty)+" * "+String.format("%6.1f",Irate)+" = "+String.format("%1.1f",Iamt)+"  ",10,y);y+=yShift;
                        g2d.drawString(stringl(Iname,nmlength),10,y);//y+=yShift;
                        g2d.drawString(String.format("%8.1f",Iqty)+" * "+String.format("%6.1f",Irate)+" = "+String.format("%1.0f",Iamt)+"  ",64,y);y+=yShift;
            }
            g2d.drawString("-------------------------------------",10,y);y+=yShift;
            
            g2d.drawString(stringl(rem.getText(),10),10,y);
            g2d.setFont(new Font("Monospaced",Font.PLAIN,10));
            if(lang.compareToIgnoreCase("English")!=0){
               
            g2d.drawString("                  कुल रकम = "+String.valueOf(total.getText()+" Dr"),10,y);y+=yShift;
            g2d.setFont(new Font("Monospaced",Font.PLAIN,9));
            g2d.drawString(stringr(" पिछला टोटल ="+String.valueOf(CStatus)+bnam(CStatus),38),10,y);y+=yShift;
            g2d.setFont(new Font("Monospaced",Font.BOLD,9));
            g2d.drawString(stringr("  कुल ="+String.valueOf(CStatus-Float.valueOf(total.getText()))+bnam(CStatus-Float.valueOf(total.getText())),37),10,y);y+=yShift;
            }else{
                g2d.setFont(new Font("Monospaced",Font.BOLD,10));
            g2d.drawString("            Total Amount = "+String.valueOf(total.getText()+" Dr"),10,y);y+=yShift;
            g2d.setFont(new Font("Monospaced",Font.PLAIN,9));
            g2d.drawString(stringr("P.Total ="+String.valueOf(CStatus)+bnam(CStatus),36),10,y);y+=yShift;
            g2d.setFont(new Font("Monospaced",Font.BOLD,9));
            g2d.drawString(stringr("  Total ="+String.valueOf(CStatus-Float.valueOf(total.getText()))+bnam(CStatus-Float.valueOf(total.getText())),36),10,y);y+=yShift;
             }
            
            
            g2d.setFont(new Font("Monospaced",Font.PLAIN,9));
            g2d.drawString("-------------------------------------",10,y);y+=yShift;
            g2d.drawString("*************************************",10,y);y+=yShift;
            g2d.drawString(stringc(GetLine.mainn(baseadd+"/"+user+"/conf.txt", 2),35),10,y);y+=yShift;
            g2d.drawString("*************************************",10,y);y+=yShift;
            
           
            
    }
    catch(Exception r){
      JLabel label = new JLabel("r.printStackTrace  !!! Error0019"+r);
            label.setFont(new Font("Arial", Font.BOLD, 18));
            JOptionPane.showMessageDialog(null,label,"ERROR",JOptionPane.WARNING_MESSAGE);  
    //r.printStackTrace();
    }

              result = PAGE_EXISTS;    
          }    
  }
  else{
          
   
        if (pageIndex == 0) {                    
        
            Graphics2D g2d = (Graphics2D) graphics;                    

            //double width = pageFormat.getImageableWidth();                    
           
            g2d.translate((int) pageFormat.getImageableX(),(int) pageFormat.getImageableY()); 
 //#########################################################################################################################################################              
      
    
      
//########################################################################################################

      float CStatus = Float.valueOf(cnsts.getText());
            
            
             
              
         try{
            /*Draw Header*/
            int y=1;
            int yShift = 10;
            int headerRectHeight=15;
           
           
              TableModel tm = table.getModel();  
             g2d.setFont(new Font("Monospaced",Font.PLAIN,9));
            g2d.drawString("-------------------------------------",10,y);y+=yShift;
            g2d.setFont(new Font("Monospaced",Font.BOLD,9));
            g2d.drawString(stringc(Sname,35),12,y);y+=yShift;
            g2d.setFont(new Font("Monospaced",Font.PLAIN,9));
            g2d.drawString(stringr("Mob.:"+Sno,36),10,y);y+=yShift;
            g2d.drawString("-------------------------------------",10,y);y+=yShift;
            g2d.setFont(new Font("Monospaced",Font.BOLD,9));
            g2d.drawString(code.getText()+"    "+stringr(name.getText(),cnmlength),10,y);y+=yShift;
            g2d.setFont(new Font("Monospaced",Font.PLAIN,9));
            g2d.drawString(dtlbl.getText()+sd+"   "+stringr(mdlbl.getText()+mode,18),10,y);y+=headerRectHeight;
            if(lang.compareToIgnoreCase("English")!=0){
               //g2d.drawString("Name           Qty *   Rate = T.Price",10,y);
             g2d.drawString("नाम             मात्रा *   रेट    =  रकम ", 10, y);y+=yShift;
            }else{
             g2d.drawString("Name           Qty *   Rate = T.Price",10,y);y+=yShift;   
            }
            g2d.drawString("-------------------------------------",10,y);y+=yShift;
            for (int k = 0; k < tm.getRowCount(); k++) {
                Object o= tm.getValueAt(k,2);
                        String  Iname = (String)o;
                        o = tm.getValueAt(k,3);
                        float Iqty = (Float)o;
                        o = tm.getValueAt(k, 4);
                        float Irate = (Float)o;
                        o = tm.getValueAt(k, 5);
                        float Iamt = (Float)o;
              //g2d.drawString(stringl(Iname,10)+String.format("%8.1f",Iqty)+" * "+String.format("%6.1f",Irate)+" = "+String.format("%1.1f",Iamt)+"  ",10,y);y+=yShift;
                        g2d.drawString(stringl(Iname,nmlength),10,y);//y+=yShift;
                        g2d.drawString(String.format("%8.1f",Iqty)+" * "+String.format("%6.1f",Irate)+" = "+String.format("%1.0f",Iamt)+"  ",64,y);y+=yShift;
            }
            g2d.drawString("-------------------------------------",10,y);y+=yShift;
            g2d.setFont(new Font("Monospaced",Font.PLAIN,10));
            if(lang.compareToIgnoreCase("English")!=0){
               //g2d.drawString("Name           Qty *   Rate = T.Price",10,y);
             g2d.drawString("                  कुल रकम = "+String.valueOf(total.getText()+" Cr"),10,y);y+=yShift;
             g2d.setFont(new Font("Monospaced",Font.PLAIN,9));
            g2d.drawString(stringr(" पिछला टोटल ="+String.valueOf(CStatus)+bnam(CStatus),38),10,y);y+=yShift;
            g2d.setFont(new Font("Monospaced",Font.BOLD,9));
            g2d.drawString(stringr("  कुल ="+String.valueOf(CStatus+Float.valueOf(total.getText()))+bnam(CStatus+Float.valueOf(total.getText())),37),10,y);y+=yShift;
            }else{
             g2d.drawString("            Total Amount = "+String.valueOf(total.getText()+" Cr"),10,y);y+=yShift;
           
            
            //g2d.drawString("      Pichhla Baki = "+String.valueOf(CStatus-Float.valueOf(total.getText()))+"               ",10,y);y+=yShift;
            //g2d.drawString("        Total Baki = "+String.valueOf(CStatus)+"               ",10,y);y+=yShift;
            g2d.setFont(new Font("Monospaced",Font.PLAIN,9));
            g2d.drawString(stringr("P.Total = "+String.valueOf(CStatus)+bnam(CStatus),36),10,y);y+=yShift;
            g2d.setFont(new Font("Monospaced",Font.BOLD,9));
            g2d.drawString(stringr("  Total ="+String.valueOf(CStatus+Float.valueOf(total.getText()))+bnam(CStatus+Float.valueOf(total.getText())),36),10,y);y+=yShift;
             }
            g2d.setFont(new Font("Monospaced",Font.PLAIN,9));
            g2d.drawString("-------------------------------------",10,y);y+=yShift;
            g2d.drawString("*************************************",10,y);y+=yShift;
            g2d.drawString(GetLine.mainn(baseadd+"/"+user+"/conf.txt", 2),10,y);y+=yShift;
            g2d.drawString("*************************************",10,y);y+=yShift;
                   
           
            
    }
    catch(Exception r){
      JLabel label = new JLabel("r.printStackTrace  !!! Error0019"+r);
            label.setFont(new Font("Arial", Font.BOLD, 18));
            JOptionPane.showMessageDialog(null,label,"ERROR",JOptionPane.WARNING_MESSAGE);  
    //r.printStackTrace();
    }

              result = PAGE_EXISTS;    
          }    
            
     
          
          
}
          return result;    
      }
   }
    //########################################################################################################
public PageFormat getPageFormat(PrinterJob pj)
{
    
    PageFormat pf = pj.defaultPage();
    Paper paper = pf.getPaper();    

    int tt = table.getRowCount();
    double middleHeight =10*(tt);
                     
    double width = convert_CM_To_PPI(8);      //printer know only point per inch.default value is 72ppi
    //double height = convert_CM_To_PPI(headerHeight+middleHeight+footerHeight); 
    double height =85+71+middleHeight;
    //System.out.println(height);
    paper.setSize(width, height);
    paper.setImageableArea(                    
        0,
        0,
        width,            
        height// - convert_CM_To_PPI(1)
    );   //define boarder size    after that print area width is about 180 points
            
    pf.setOrientation(PageFormat.PORTRAIT);           //select orientation portrait or landscape but for this time portrait
    pf.setPaper(paper);    

    return pf;
}
//########################################################################################################
protected static double convert_CM_To_PPI(double cm) {            
	        return toPPI(cm * 0.393600787);            
}
 
protected static double toPPI(double inch) {            
	        return inch * 72d;            
}



//########################################################################################################
    private void BcompletedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BcompletedActionPerformed
    try {
        //System.out.println("Inside Complete");
        if(BPRTxName()==false){         //Costomer Code Not Enter or Not Valid
        
            JLabel label = new JLabel("Please...Enter the Valid Party Code First !!!");
            label.setFont(new Font("Arial", Font.BOLD, 18));
            JOptionPane.showMessageDialog(this,label,"ERROR",JOptionPane.WARNING_MESSAGE); 
            code.requestFocus();
        }
        else{           // it save the all data to the permanent files and close the menu
            if(DateInBetween.mainn(DtAdd, sd, sd)){
            mode=Pmode.getSelectedItem().toString();         //Deciding wether cash or Pending
            if(mode.equals("Pending")){
                if(sway.getSelectedIndex()==0){     //Given
                    STRaddT="/Pending/Taken";
                    STRaddG="/Pending/Given";
                    pcompG();
                }else{                              //Taken
                    STRaddT="/Pending/Taken";
                    STRaddG="/Pending/Given";
                    pcompT(); 
                }
                
                
            }
            else
            {
                if(sway.getSelectedIndex()==0){
                    STRaddT="/Cash/Taken";
                    STRaddG="/Cash/Given";
                    ccompG();
                }else{
                    STRaddT="/Cash/Taken";
                    STRaddG="/Cash/Given";
                    ccompT();
                }
                
            }
        }
            else{
                JLabel label = new JLabel("This Entry Cannot be Done. As You Added this Party on "+DtAdd);
            label.setFont(new Font("Arial", Font.BOLD, 18));
            JOptionPane.showMessageDialog(this,label,"ERROR",JOptionPane.WARNING_MESSAGE); 
            code.requestFocus();
            }
        }
    } catch (FileNotFoundException ex) {
        JLabel label = new JLabel(" Party Code ERROR !!!"+ex);
            label.setFont(new Font("Arial", Font.BOLD, 18));
            JOptionPane.showMessageDialog(this,label,"ERROR",JOptionPane.WARNING_MESSAGE); 
            code.requestFocus();
    }


    }//GEN-LAST:event_BcompletedActionPerformed

    //########################################################################################################
    private void icodeFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_icodeFocusGained
    yt=0;
    //table.set
        icode.selectAll();
                //
           DefaultTableModel model = (DefaultTableModel)newtb.getModel();
        SCP.setBounds(139, 241, 225, 300);
        model.setRowCount(0);
        String tb,dtb;
        
        tb=icode.getText();
        
        if(!tb.isEmpty()){
        tb=icode.getText();
        SCP.setVisible(true);
        
        newtb.setVisible(true);
        
        Scanner read ;
        String icode,Einame = "Null",Hiname = "Null",iname="",irate,dcode,dEname,dHname;
        try {
        read = new Scanner(new File(ITMadd+"/item.txt"),"UTF-8");
        
        read.useDelimiter("\\n");
        while(read.hasNext()){
        icode = read.nextLine();
        Scanner inner;
        //System.out.println("Inner"+tb);
        
        try {
        inner = new Scanner(new File(ITMadd+"/"+icode+"/profile.txt"),"UTF-8");
        icode=inner.nextLine();
        Einame=inner.nextLine();
        Hiname=inner.nextLine();
        irate=inner.nextLine();
        dcode = icode.toUpperCase();
        dEname = Einame.toUpperCase();
        dHname = Hiname.toUpperCase();
        dtb= tb.toUpperCase();
        inner.close();
        
        if(lang.compareToIgnoreCase("English")!=0)
            iname=Hiname;
        else
            iname=Einame;
        
        if(dcode.contains(dtb)){
        
        model.insertRow(newtb.getRowCount(),new Object[]{icode,iname,irate});
        
        }
        else{
        if(dEname.contains(dtb)){
        model.insertRow(newtb.getRowCount(),new Object[]{icode,iname,irate});
        
        }
        if(dHname.contains(dtb)){
        model.insertRow(newtb.getRowCount(),new Object[]{icode,iname,irate});
        
        }
        }
        } catch (FileNotFoundException ex) {
        JLabel label = new JLabel("Item Profile Error !!! Error0013"+ex);
            label.setFont(new Font("Arial", Font.BOLD, 18));
            JOptionPane.showMessageDialog(this,label,"ERROR",JOptionPane.WARNING_MESSAGE);
        }
        
        
        }
        read.close();
        } catch (FileNotFoundException ex) {
        JLabel label = new JLabel("Item .Item !!! Error0015"+ex);
            label.setFont(new Font("Arial", Font.BOLD, 18));
            JOptionPane.showMessageDialog(this,label,"ERROR",JOptionPane.WARNING_MESSAGE);
        }
        if(newtb.getRowCount()>0)
        newtb.setRowSelectionInterval(0, 0);
        else
        newtb.clearSelection();
         
        }
        else{           // Nothing is entered in icode
         
        SCP.setVisible(true);
         
        newtb.setVisible(true);
         
        Scanner read ;
        String icode,Einame = "Null",Hiname = "Null",iname = "Null",irate,dcode,dname;
        try {
        read = new Scanner(new File(ITMadd+"/item.txt"),"UTF-8");
        
        read.useDelimiter("\\n");
        while(read.hasNext()){
        icode = read.nextLine();
        Scanner inner;
         
        
        try {
        inner = new Scanner(new File(ITMadd+"/"+icode+"/profile.txt"),"UTF-8");
        icode=inner.nextLine();
        Einame=inner.nextLine();
        Hiname=inner.nextLine();
        irate=inner.nextLine();
        
        if(lang.compareToIgnoreCase("English")!=0)
            iname=Hiname;
        else
            iname=Einame;
        
        inner.close();
        model.insertRow(newtb.getRowCount(),new Object[]{icode,iname,irate});
        
        
        
        } catch (FileNotFoundException ex) {
        JLabel label = new JLabel("Item Profile !!! Error0013"+ex);
            label.setFont(new Font("Arial", Font.BOLD, 18));
            JOptionPane.showMessageDialog(this,label,"ERROR",JOptionPane.WARNING_MESSAGE);
        }
        
        
        }
        read.close();
        } catch (FileNotFoundException ex) {
        JLabel label = new JLabel("Item .item !!! Error0015"+ex);
            label.setFont(new Font("Arial", Font.BOLD, 18));
            JOptionPane.showMessageDialog(this,label,"ERROR",JOptionPane.WARNING_MESSAGE);
        }
        if(newtb.getRowCount()>0)
        newtb.setRowSelectionInterval(0, 0);
        else
        newtb.clearSelection();
         
        }
    }//GEN-LAST:event_icodeFocusGained

    private void rateFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_rateFocusGained
rate.selectAll();
    }//GEN-LAST:event_rateFocusGained

    private void qtyFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_qtyFocusGained
qty.selectAll();
    }//GEN-LAST:event_qtyFocusGained

    private void BclearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BclearActionPerformed
DefaultTableModel dm = (DefaultTableModel)table.getModel();
                    for(int z =dm.getRowCount()-1 ;z>=0;--z)
                        dm.removeRow(z);
                    itotal = 0;
                    total.setText(String.valueOf(itotal));
                    i=1;
                    amt.setText("0.0");
                    code.requestFocus();
                    
    }//GEN-LAST:event_BclearActionPerformed

    private void codeKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_codeKeyPressed

 
        
        int a = evt.getKeyCode();
        if (a == 10) {                     // for enter key
             try {
                         code.setText(String.format("%04d", Integer.valueOf(code.getText())));
            PRTxName();
              
        } catch (Exception e) {
            if(code.getText().isEmpty()) {
            icode.requestFocus();
    } else {
        code.requestFocus();
    }
            
        }
         
        }else{
            if(evt.isControlDown()&&evt.getKeyCode()==KeyEvent.VK_LEFT){
                                System.out.println("Detected+shift");
                                   code.requestFocus();
                               }
                               else{
                                   if(evt.isControlDown()&&evt.getKeyCode()==KeyEvent.VK_RIGHT){
                                       System.out.println("Detected-shift");
                                       icode.requestFocus();
                                   }
                               }
        }  
    }//GEN-LAST:event_codeKeyPressed

    private void codeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_codeActionPerformed

    }//GEN-LAST:event_codeActionPerformed

    private void codeFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_codeFocusLost
        try{        
    code.setText(String.format("%04d", Integer.valueOf(code.getText())));
}
catch(Exception e){
    if(code.getText().isEmpty()) {
        icode.requestFocus();
    } else {
        code.requestFocus();
    }
}
    }//GEN-LAST:event_codeFocusLost

    private void codeFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_codeFocusGained
code.selectAll();
    }//GEN-LAST:event_codeFocusGained

    private void inameFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_inameFocusGained
        System.out.println("Focus Losted");
        if(lang.compareToIgnoreCase("English")!=0){
    try {
        Robot r=new Robot();
        r.keyPress(KeyEvent.VK_ALT);
        r.keyPress(KeyEvent.VK_SHIFT);
        r.keyPress(KeyEvent.VK_1);
        r.keyRelease(KeyEvent.VK_1);
        r.keyRelease(KeyEvent.VK_SHIFT);
        r.keyRelease(KeyEvent.VK_ALT);
    } catch (AWTException ex) {
        JLabel label = new JLabel("Languae Setup Error!!!"+ex);
        label.setFont(new Font("Arial", Font.BOLD, 18));
        JOptionPane.showMessageDialog(this,label,"ERROR",JOptionPane.WARNING_MESSAGE);
    }
        }
        
    }//GEN-LAST:event_inameFocusGained

    private void inameKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_inameKeyPressed
        System.out.println("Key Preseed");
        int a=evt.getKeyCode();
        if(a==10)
            rate.requestFocus();
         else{
            if(evt.isControlDown()&&evt.getKeyCode()==KeyEvent.VK_LEFT){
                                    icode.requestFocus();
                               }
                               else{
                                   if(evt.isControlDown()&&evt.getKeyCode()==KeyEvent.VK_RIGHT){
                                       rate.requestFocus();
                                   }
                               }
        }  
    }//GEN-LAST:event_inameKeyPressed

    private void codeKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_codeKeyTyped
       char c = evt.getKeyChar();
        if(!(Character.isDigit(c)||c==10) ){    //
            getToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_codeKeyTyped

    private void rateKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_rateKeyTyped
        char c = evt.getKeyChar();
        if(!(Character.isDigit(c)|| (c=='.'||(c==10)||c==82 ))){    //
            getToolkit().beep();
            evt.consume();
        }   
    }//GEN-LAST:event_rateKeyTyped

    private void qtyKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_qtyKeyTyped
        char c = evt.getKeyChar();
        if(!(Character.isDigit(c)|| (c=='.'||(c==10)||c==81 ))){    //
            getToolkit().beep();
            evt.consume();
        }   
    }//GEN-LAST:event_qtyKeyTyped

    private void amtFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_amtFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_amtFocusGained

    private void amtKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_amtKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_amtKeyPressed

    private void amtKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_amtKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_amtKeyTyped

    private void rateFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_rateFocusLost
        if(amtd==1)
    amtd=0;
        else{
        try{
            rate.setText(String.format("%.2f",Float.valueOf(rate.getText())));
            amt.setText(String.format("%.0f", (Float.valueOf(rate.getText())*(Float.valueOf(qty.getText())))));
        }
        catch(Exception e){
            rate.setText("0.0");
            amt.setText(String.format("%.0f", (Float.valueOf(rate.getText())*(Float.valueOf(qty.getText())))));
        }
        }
    }//GEN-LAST:event_rateFocusLost

    private void qtyFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_qtyFocusLost
if(amtd==1)
    amtd=0;
else{
    try{
        qty.setText(String.format("%.2f",Float.valueOf(qty.getText())));
            amt.setText(String.format("%.0f", (Float.valueOf(rate.getText())*(Float.valueOf(qty.getText())))));
    }
    catch(Exception e){
        qty.setText("1.0");
       amt.setText(String.format("%.0f", (Float.valueOf(rate.getText())*(Float.valueOf(qty.getText())))));
    }
}
    }//GEN-LAST:event_qtyFocusLost

    private void icodeKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_icodeKeyTyped
        // TODO add your handling code here:
        int a= evt.getKeyChar();
        if(a==10){
            evt.consume();
        }else{
            
if(a==43){
    evt.consume();
    Bcompleted.doClick();
}else{
    if(a==45){
     evt.consume();
        rem.requestFocus();
    }
}
        }
    }//GEN-LAST:event_icodeKeyTyped

    private void inameKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_inameKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_inameKeyTyped

    private void inameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_inameActionPerformed

    private void icodeKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_icodeKeyReleased
    // TODO add your handling code here:
        
                DefaultTableModel model = (DefaultTableModel)newtb.getModel();
        SCP.setBounds(141, 241, 225, 300);
        
        if(evt.getKeyCode()==40){
        if(newtb.getSelectedRow()<(newtb.getRowCount()-1)){
        newtb.setRowSelectionInterval(1+newtb.getSelectedRow(), 1+newtb.getSelectedRow());
        newtb.scrollRectToVisible(new Rectangle(newtb.getCellRect(newtb.getSelectedRow(), 0, true)));
        }
        }else{
        if(evt.getKeyCode()==38){
        if(newtb.getSelectedRow()>0){
        newtb.setRowSelectionInterval(-1+newtb.getSelectedRow(), -1+newtb.getSelectedRow());
        newtb.scrollRectToVisible(new Rectangle(newtb.getCellRect(newtb.getSelectedRow(), 0, true)));
        }
        }
        
        else{
        if(evt.getKeyCode()==10){
                ++yt;
                if(yt>1){
            if(newtb.getSelectedRow()>=0){
        Object o = newtb.getValueAt(newtb.getSelectedRow(), 0);
        String cd =    String.valueOf(o);
        icode.setText(cd);
        SCP.setVisible(false);
        String itm = icode.getText();
        if(repeatationWOcase.mainn(ITMadd, "item.txt", itm)==1){                // If we get Item code is existing the do ....
        
        Scanner read ;
        try {
         read = new Scanner(new File(ITMadd + "/" + itm + "/profile.txt"),"UTF-8");
        read.useDelimiter("\\n");
        read.nextLine();
        String Enam = read.nextLine();
        String Hnam = read.nextLine();
        String sprice = read.nextLine(); 
        read.nextLine();
        boolean redt=Boolean.valueOf(read.nextLine());
        String adate = read.nextLine();
        read.close();
        
        if(DateInBetween.mainn(adate,adate,sd)){
        if(lang.compareToIgnoreCase("English")!=0)
            iname.setText(Hnam);
        else
        iname.setText(Enam);
        
        
        rate.setText(sprice);
        
       
        rate.setEditable(redt);
         amt.setText(String.format("%.0f", (Float.valueOf(rate.getText())*(Float.valueOf(qty.getText())))));
        
        iname.requestFocus();
        }else{
        JLabel label = new JLabel("Item added on "+adate);
        label.setFont(new Font("Arial", Font.BOLD, 18));
        JOptionPane.showMessageDialog(this,label,"ERROR",JOptionPane.WARNING_MESSAGE);
        }
        } catch (FileNotFoundException ex) {
        JLabel label = new JLabel("Item profile file is not opening !!! Error0013"+ex);
        label.setFont(new Font("Arial", Font.BOLD, 18));
        JOptionPane.showMessageDialog(this,label,"ERROR",JOptionPane.WARNING_MESSAGE);
        
        }
        
        }
        else                            // If Icode is not Matching to any of Icode the showing error
        {
        icode.requestFocus();
        JLabel label = new JLabel("This item code does not exist !!! ");
        label.setFont(new Font("Arial", Font.BOLD, 18));
        JOptionPane.showMessageDialog(this,label,"Warning !!",JOptionPane.WARNING_MESSAGE);
        
        }
        
        }else{
        icode.requestFocus();
        JLabel label = new JLabel("This item code does not exist !!! ");
        label.setFont(new Font("Arial", Font.BOLD, 18));
        JOptionPane.showMessageDialog(this,label,"Warning !!",JOptionPane.WARNING_MESSAGE);
            }
            }
            else{
                icode.requestFocus();
            }
        }
        else{
        
        
        //
        model.setRowCount(0);
        String tb,dtb;
        
        tb=icode.getText();
        if(!tb.isEmpty()){
        tb=icode.getText();
        SCP.setVisible(true);
        newtb.setVisible(true);
        Scanner read ;
        String icode,Einame = "Null",Hiname = "Null",iname = "Null",irate,dcode,dEname,dHname;
        try {
        read = new Scanner(new File(ITMadd+"/item.txt"),"UTF-8");
        
        read.useDelimiter("\\n");
        while(read.hasNext()){
        icode = read.nextLine();
        Scanner inner;
        //System.out.println("Inner"+tb);
        
        try {
        inner = new Scanner(new File(ITMadd+"/"+icode+"/profile.txt"),"UTF-8");
        icode=inner.nextLine();
        Einame=inner.nextLine();
        Hiname=inner.nextLine();
        irate=inner.nextLine();
        dcode = icode.toUpperCase();
        dEname = Einame.toUpperCase();
        dHname = Hiname.toUpperCase();
        dtb= tb.toUpperCase();
        inner.close();
        
        if(lang.compareToIgnoreCase("English")!=0)
            iname=Hiname;
        else
        iname=Einame;
        
        
        if(dcode.contains(dtb)){
        
        model.insertRow(newtb.getRowCount(),new Object[]{icode,iname,irate});
        
        }
        else{
        if(dEname.contains(dtb)){
        model.insertRow(newtb.getRowCount(),new Object[]{icode,iname,irate});
        
        }
        if(dHname.contains(dtb)){
        model.insertRow(newtb.getRowCount(),new Object[]{icode,iname,irate});
        
        }
        
        }
        } catch (FileNotFoundException ex) {
        JLabel label = new JLabel("Item profile.txt error !!! Error0013"+ex);
            label.setFont(new Font("Arial", Font.BOLD, 18));
            JOptionPane.showMessageDialog(this,label,"ERROR",JOptionPane.WARNING_MESSAGE);
        }
        
        
        }
        read.close();
        } catch (FileNotFoundException ex) {
        JLabel label = new JLabel("Item.item.txt error !!! Error0015"+ex);
            label.setFont(new Font("Arial", Font.BOLD, 18));
            JOptionPane.showMessageDialog(this,label,"ERROR",JOptionPane.WARNING_MESSAGE);
        }
        if(newtb.getRowCount()>0)
        newtb.setRowSelectionInterval(0, 0);
        else
        newtb.clearSelection();
        //newtb.setRowSelectionInterval(0, 0);
        }
        else{           // Nothing is entered in icode
        //tb=icode.getText();
        SCP.setVisible(true);
         
        newtb.setVisible(true);
         
        Scanner read ;
        String icode,iname = "Null",irate,dcode,dname;
        try {
        read = new Scanner(new File(ITMadd+"/item.txt"),"UTF-8");
        
        read.useDelimiter("\\n");
        while(read.hasNext()){
        icode = read.nextLine();
        Scanner inner;
         
        try {
        inner = new Scanner(new File(ITMadd+"/"+icode+"/profile.txt"),"UTF-8");
        icode=inner.nextLine();
        iname=inner.nextLine();
        irate=inner.nextLine();
        inner.close();
        
        model.insertRow(newtb.getRowCount(),new Object[]{icode,iname,irate});
        
        
        
        } catch (FileNotFoundException ex) {
        JLabel label = new JLabel("Item profile.txt error !!! Error0013"+ex);
            label.setFont(new Font("Arial", Font.BOLD, 18));
            JOptionPane.showMessageDialog(this,label,"ERROR",JOptionPane.WARNING_MESSAGE);
        }
        
        
        }
        read.close();
        } catch (FileNotFoundException ex) {
        JLabel label = new JLabel("Item.item.txt error !!! Error0015"+ex);
            label.setFont(new Font("Arial", Font.BOLD, 18));
            JOptionPane.showMessageDialog(this,label,"ERROR",JOptionPane.WARNING_MESSAGE);
        }
        if(newtb.getRowCount()>0)
        newtb.setRowSelectionInterval(0, 0);
        else
        newtb.clearSelection();
         
        }
        
        }
        }
        }
        
            
        
    }//GEN-LAST:event_icodeKeyReleased

    private void icodeFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_icodeFocusLost
         
        SCP.setVisible(false);
    }//GEN-LAST:event_icodeFocusLost

    private void addItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_addItemStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_addItemStateChanged

    private void inameFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_inameFocusLost
        // TODO add your handling code here:
        if(iname.getText().isEmpty())
        {
            if(lang.compareToIgnoreCase("English")!=0){
                iname.setText("कोई नाम नहीं");
            }
            else{
                iname.setText("No Name");
            }
        }
        try {
        Robot r=new Robot();
        r.keyPress(KeyEvent.VK_ALT);
        r.keyPress(KeyEvent.VK_SHIFT);
        r.keyPress(KeyEvent.VK_0);
        r.keyRelease(KeyEvent.VK_0);
        r.keyRelease(KeyEvent.VK_SHIFT);
        r.keyRelease(KeyEvent.VK_ALT);
    } catch (AWTException ex) {
        JLabel label = new JLabel("Languae Setup Error!!!"+ex);
        label.setFont(new Font("Arial", Font.BOLD, 18));
        JOptionPane.showMessageDialog(this,label,"ERROR",JOptionPane.WARNING_MESSAGE);
    }
    }//GEN-LAST:event_inameFocusLost

    private void button1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button1ActionPerformed
Gsetting.main(baseadd,logo,PRTadd);        // TODO add your handling code here:
    }//GEN-LAST:event_button1ActionPerformed

    private void button1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_button1FocusLost
Scanner ot;
                    try {
                        ot = new Scanner(new File(PRTadd+"/setting.txt"),"UTF-8");
                        repicode=ot.nextLine();
                        repiname=ot.nextLine();
                        repirate=ot.nextLine();
                        prntrs = Boolean.valueOf(ot.nextLine());
                        Dway=ot.nextLine();
                        Dmode=ot.nextLine();
                        remm=ot.nextLine();
                        nmedt=Boolean.valueOf(ot.nextLine());
                        ot.close();
                        sway.setSelectedIndex(Integer.valueOf(Dway));
                        Pmode.setSelectedIndex(Integer.valueOf(Dmode));
                        rem.setText(remm);
                        name.setEditable(nmedt);
                        
                    }
                    catch (FileNotFoundException ex) {
                        JLabel label = new JLabel("Setting. Error !!! Error0018"+ex);
                        label.setFont(new Font("Arial", Font.BOLD, 18));
                        JOptionPane.showMessageDialog(this,label,"ERROR",JOptionPane.WARNING_MESSAGE);
                    }
                    
                     
    }//GEN-LAST:event_button1FocusLost

    private void remFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_remFocusGained
rem.selectAll();        // TODO add your handling code here:
if(lang.compareToIgnoreCase("English")!=0){
    try {
        Robot r=new Robot();
        r.keyPress(KeyEvent.VK_ALT);
        r.keyPress(KeyEvent.VK_SHIFT);
        r.keyPress(KeyEvent.VK_1);
        r.keyRelease(KeyEvent.VK_1);
        r.keyRelease(KeyEvent.VK_SHIFT);
        r.keyRelease(KeyEvent.VK_ALT);
    } catch (AWTException ex) {
        JLabel label = new JLabel("Languae Setup Error!!!"+ex);
        label.setFont(new Font("Arial", Font.BOLD, 18));
        JOptionPane.showMessageDialog(this,label,"ERROR",JOptionPane.WARNING_MESSAGE);
    }
        }
    }//GEN-LAST:event_remFocusGained

    private void remKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_remKeyPressed
if(evt.getKeyCode()==KeyEvent.VK_PLUS)
            Bcompleted.doClick();
        else{
            if(evt.getKeyCode()==KeyEvent.VK_ENTER)
        Bcompleted.requestFocus();
        else{
       if((evt.isControlDown()&&evt.getKeyCode()==KeyEvent.VK_C))
    Bcompleted.doClick();
else{
    if(evt.isControlDown()&&evt.getKeyCode()==KeyEvent.VK_R)
        rem.requestFocus();
    else{
        if(evt.isControlDown()&&evt.getKeyCode()==KeyEvent.VK_W)
        sway.requestFocus();
    else{
        if(evt.isControlDown()&&evt.getKeyCode()==KeyEvent.VK_D)
        Bclear.doClick();
    else{
        if(evt.isControlDown()&&evt.getKeyCode()==KeyEvent.VK_M)
        Pmode.requestFocus();
      //else{
        
    //}
    }
    }
    }
}
}
    }
    }//GEN-LAST:event_remKeyPressed

    private void remKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_remKeyTyped
        // TODO add your handling code here:
        int a = evt.getKeyCode();        // TODO add your handling code here:
if(a==10||a==43){
 evt.consume();
    Bcompleted.doClick();
}
    }//GEN-LAST:event_remKeyTyped

    private void swayKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_swayKeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode()==KeyEvent.VK_PLUS)
            Bcompleted.doClick();
        else{
            if(evt.getKeyCode()==KeyEvent.VK_ENTER)
        rem.requestFocus();
        else{
       if((evt.isControlDown()&&evt.getKeyCode()==KeyEvent.VK_C))
    Bcompleted.doClick();
else{
    if(evt.isControlDown()&&evt.getKeyCode()==KeyEvent.VK_R)
        rem.requestFocus();
    else{
        if(evt.isControlDown()&&evt.getKeyCode()==KeyEvent.VK_W)
        sway.requestFocus();
    else{
        if(evt.isControlDown()&&evt.getKeyCode()==KeyEvent.VK_D)
        Bclear.doClick();
    else{
        if(evt.isControlDown()&&evt.getKeyCode()==KeyEvent.VK_M)
        Pmode.requestFocus();
      //else{
        
    //}
    }
    }
    }
}
}
    }
    }//GEN-LAST:event_swayKeyPressed

    private void PmodeKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_PmodeKeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode()==KeyEvent.VK_PLUS)
            Bcompleted.doClick();
        else{
            if(evt.getKeyCode()==KeyEvent.VK_ENTER)
        Pmode.requestFocus();
        else{
       if((evt.isControlDown()&&evt.getKeyCode()==KeyEvent.VK_C))
    Bcompleted.doClick();
else{
    if(evt.isControlDown()&&evt.getKeyCode()==KeyEvent.VK_R)
        rem.requestFocus();
    else{
        if(evt.isControlDown()&&evt.getKeyCode()==KeyEvent.VK_W)
        sway.requestFocus();
    else{
        if(evt.isControlDown()&&evt.getKeyCode()==KeyEvent.VK_D)
        Bclear.doClick();
    else{
        if(evt.isControlDown()&&evt.getKeyCode()==KeyEvent.VK_M)
        Pmode.requestFocus();
      //else{
        
    //}
    }
    }
    }
}
}
    }
    }//GEN-LAST:event_PmodeKeyPressed

    private void nameKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nameKeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode()==KeyEvent.VK_ENTER)
            icode.requestFocus();
    }//GEN-LAST:event_nameKeyPressed

    private void BcompletedKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_BcompletedKeyPressed
        // TODO add your handling code here:
        int a = evt.getKeyCode();
        if(a==10)
            Bcompleted.doClick();
    }//GEN-LAST:event_BcompletedKeyPressed

    private void BcompletedMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BcompletedMouseEntered
        Bcompleted.setBackground(Color.WHITE);
    }//GEN-LAST:event_BcompletedMouseEntered

    private void BcompletedMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BcompletedMouseExited
         Bcompleted.setBackground(new java.awt.Color(240, 240, 240));
    }//GEN-LAST:event_BcompletedMouseExited

    private void BclearMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BclearMouseEntered
Bclear.setBackground(Color.WHITE);
    }//GEN-LAST:event_BclearMouseEntered

    private void BclearMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BclearMouseExited
        Bclear.setBackground(new java.awt.Color(240,240,240));
    }//GEN-LAST:event_BclearMouseExited

    private void BcloserMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BcloserMouseEntered
        Bcloser.setBackground(Color.white);
    }//GEN-LAST:event_BcloserMouseEntered

    private void BcloserMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BcloserMouseExited
        Bcloser.setBackground(new java.awt.Color(240,240,240));
    }//GEN-LAST:event_BcloserMouseExited

    private void addMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addMouseEntered
        add.setBackground(Color.white);
    }//GEN-LAST:event_addMouseEntered

    private void addMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addMouseExited
        add.setBackground(new java.awt.Color(240,240,240));
    }//GEN-LAST:event_addMouseExited

    private void addFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_addFocusGained
        add.setBackground(Color.white);
    }//GEN-LAST:event_addFocusGained

    private void addFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_addFocusLost
        add.setBackground(new java.awt.Color(240,240,240));
    }//GEN-LAST:event_addFocusLost

    private void BcloserFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_BcloserFocusGained
        Bcloser.setBackground(Color.white);
    }//GEN-LAST:event_BcloserFocusGained

    private void BcloserFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_BcloserFocusLost
        Bcloser.setBackground(new java.awt.Color(240,240,240));
    }//GEN-LAST:event_BcloserFocusLost

    private void BclearFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_BclearFocusGained
        Bclear.setBackground(Color.white);
    }//GEN-LAST:event_BclearFocusGained

    private void BclearFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_BclearFocusLost
        Bclear.setBackground(new java.awt.Color(240,240,240));
    }//GEN-LAST:event_BclearFocusLost

    private void BcompletedFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_BcompletedFocusGained
         Bcompleted.setBackground(Color.white);
    }//GEN-LAST:event_BcompletedFocusGained

    private void BcompletedFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_BcompletedFocusLost
        Bcompleted.setBackground(new java.awt.Color(240,240,240));
    }//GEN-LAST:event_BcompletedFocusLost

    private void tableKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tableKeyPressed

        final DefaultTableModel model = (DefaultTableModel)table.getModel();
        final TableModel tm = table.getModel();
        //out.setText("Pressed");
        if(table.getSelectedRow()>=0){
        int b = evt.getKeyCode();
        if(b==69){      //For Edit  "e"
            editt = table.getSelectedRow();
            
        String c = (String)tm.getValueAt(editt, 1);
        icode.setText(c);
        String n = (String)tm.getValueAt(editt, 2);
        iname.setText(n);
        float q = (Float)tm.getValueAt(editt, 3);
        qty.setText(String.valueOf(q) );
        float r = (Float)tm.getValueAt(editt, 4);
        rate.setText(String.valueOf(r) );
        float A = (Float)tm.getValueAt(editt, 5);
        amt.setText(String.valueOf(A));
        float totol = Float.valueOf(total.getText());
        ptotal=totol-A;
        iname.requestFocus();
        }
        else{if(b==68){  // For Delete "d"
            //System.out.println("heloo"+editt);
            int yon = JOptionPane.showConfirmDialog(this,"Do you want to Deleted Entry ??","Confirmation .......",JOptionPane.OK_OPTION);
        if(yon==0){//YES 
          editt = table.getSelectedRow(); 
        float A = (Float)tm.getValueAt(editt, 5);
        float totol = Float.valueOf(total.getText());
        ptotal=totol-A;
        total.setText(String.valueOf(ptotal));
        itotal=ptotal;
        --i;
         
        for(int j=editt +1;j<i;++j){
         table.setValueAt(j, j, 0);
        }
        
        model.removeRow(editt);     //Deleting that row
        table.clearSelection();
        editt = -2;
        icode.requestFocus();
        }
        }else{
            ;//table.clearSelection();
        }
        }
        }
    }//GEN-LAST:event_tableKeyPressed

    private void remFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_remFocusLost
if(lang.compareToIgnoreCase("English")!=0){
    try {
        Robot r=new Robot();
        r.keyPress(KeyEvent.VK_ALT);
        r.keyPress(KeyEvent.VK_SHIFT);
        r.keyPress(KeyEvent.VK_0);
        r.keyRelease(KeyEvent.VK_0);
        r.keyRelease(KeyEvent.VK_SHIFT);
        r.keyRelease(KeyEvent.VK_ALT);
    } catch (AWTException ex) {
        JLabel label = new JLabel("Languae Setup Error!!!"+ex);
        label.setFont(new Font("Arial", Font.BOLD, 18));
        JOptionPane.showMessageDialog(this,label,"ERROR",JOptionPane.WARNING_MESSAGE);
    }
        }     
    }//GEN-LAST:event_remFocusLost

    private void remActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_remActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_remActionPerformed

    private void nameFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_nameFocusLost
        // TODO add your handling code here:
        if(lang.compareToIgnoreCase("English")!=0){
    try {
        Robot r=new Robot();
        r.keyPress(KeyEvent.VK_ALT);
        r.keyPress(KeyEvent.VK_SHIFT);
        r.keyPress(KeyEvent.VK_0);
        r.keyRelease(KeyEvent.VK_0);
        r.keyRelease(KeyEvent.VK_SHIFT);
        r.keyRelease(KeyEvent.VK_ALT);
    } catch (AWTException ex) {
        JLabel label = new JLabel("Languae Setup Error!!!"+ex);
        label.setFont(new Font("Arial", Font.BOLD, 18));
        JOptionPane.showMessageDialog(this,label,"ERROR",JOptionPane.WARNING_MESSAGE);
    }
        }
    }//GEN-LAST:event_nameFocusLost

    private void nameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nameActionPerformed
 public void setter(){
          this.setEnabled(true);
      }
    public  void daty(){
        // public static void mainn(){
        this.setEnabled(false);
                  final JFrame ID = new JFrame("Changing Date");
                 JLabel hdlbl = new JLabel(": Select a Date :");
                 JLabel lbl = new JLabel("Date :");
                 JDateChooser chd = new JDateChooser();
                 final JLabel err = new JLabel("");
                 hdlbl.setBounds(120,20, 100, 30);
                 lbl.setBounds(50,70,100,30);
                 chd.setBounds(100, 70, 200, 30);
                 chd.setDateFormatString("dd/MM/yyyy");
                 chd.setFont(new java.awt.Font("Tahoma", 3, 22));
    try {
        chd.setDate(new SimpleDateFormat("dd/MM/yyyy").parse(sd));
    } catch (ParseException ex) {
        chd.setDate(new Date());
    }
                JButton cancel = new JButton("Cancel");
                JButton confirm = new JButton("Confirm");
                cancel.setBounds(50,150,100,30);
                confirm.setBounds(220,150,100,30);
                ID.add(hdlbl);
                ID.add(lbl);
                ID.add(cancel);
                ID.add(confirm);
                ID.add(err);
                ID.setLocationRelativeTo(this);
                ID.add(chd);
                ID.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
                ID.setSize(400,300);
                ID.setLayout(null);
                ID.setAlwaysOnTop(true);
                ID.addWindowListener(new WindowAdapter() {
    public void windowClosing(WindowEvent event) {
        setter();
        code.requestFocus();
ID.dispose();
    }
});
                //ID.setModalityExclusionType(Dialog.ModalExclusionType.APPLICATION_EXCLUDE);
                ID.setVisible(true);
                ID.setLocationRelativeTo(null);
//##########################################################################
                // Working of Cancel Button STRAT
                cancel.addActionListener(new ActionListener() {
//this.setEnabled(false);
                public void actionPerformed(ActionEvent e) {
                    setter();
                    code.requestFocus();                            
                     ID.dispose();
                
                }
                });
                // Working of Cancel Button OVER

//#######################################################################33
                // Working of Confirm Button STRAT
                confirm.addActionListener(new ActionListener() {

                public void actionPerformed(ActionEvent e) {
                   System.out.println("Action should be taken");
                    SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
sd = dateFormat.format(chd.getDate());
datee.setText(sd);
setter();
code.requestFocus();
ID.dispose();

                }
                });



                // Working of Confirm Button OVER
//######################################################################################3

         }
    
    private void dateeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dateeMouseClicked
 daty();
    }//GEN-LAST:event_dateeMouseClicked

    
  
    public static void main(String args[]) {
        //public static void mainn(){
       
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                
                    //new takenLen().setVisible(true);
                

            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Bclear;
    private javax.swing.JButton Bcloser;
    private javax.swing.JButton Bcompleted;
    private javax.swing.JComboBox Pmode;
    private javax.swing.JScrollPane SCP;
    private javax.swing.JButton add;
    private javax.swing.JTextField amt;
    private java.awt.Button button1;
    private javax.swing.JLabel ccdlbl;
    private javax.swing.JLabel cnmlbl;
    private javax.swing.JTextField cnsts;
    private javax.swing.JTextField code;
    private javax.swing.JLabel cslbl;
    private javax.swing.JLabel datee;
    private javax.swing.JLabel dtlbl;
    private javax.swing.JLabel hdlbl;
    private javax.swing.JLabel iamtlbl;
    private javax.swing.JLabel icdlbl;
    private javax.swing.JTextField icode;
    private javax.swing.JTextField iname;
    private javax.swing.JLabel inmlbl;
    private javax.swing.JLabel iqtylbl;
    private javax.swing.JLabel irtlbl;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel mdlbl;
    private javax.swing.JTextField name;
    private javax.swing.JTable newtb;
    private javax.swing.JTextField qty;
    private javax.swing.JTextField rate;
    private javax.swing.JTextField rem;
    private javax.swing.JLabel remlbl;
    private javax.swing.JComboBox sway;
    private javax.swing.JTable table;
    private javax.swing.JLabel tamtlbl;
    private javax.swing.JLabel tbllbl;
    private javax.swing.JTextField total;
    private javax.swing.JLabel waylbl;
    // End of variables declaration//GEN-END:variables

}
