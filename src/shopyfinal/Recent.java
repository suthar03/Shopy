/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shopyfinal;

import java.awt.Font;
import java.awt.Rectangle;
import java.io.File;
import java.io.FileNotFoundException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;


public class Recent extends javax.swing.JFrame {

    String baseadd="D:/Shopy/Shopy",logo="src/Icons/logo.png",user="1501",ITMadd=baseadd+"/"+user+"/item",lang="English";
    String IDyear="2020-2020",Syear="01/01/2020",Eyear="01/01/2020";
    public Recent(String bs,String golo,String usr,String lng,String idy, String sy,String ey) {
        baseadd=bs;
        logo = golo;
        user = usr;
        lang = lng;
        IDyear = idy;
        Syear = sy;
        Eyear = ey;
        ITMadd=baseadd+"/"+user+"/"+IDyear+"/item";
        initComponents();
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        src.requestFocus();
        RecentThings();
        src.setBackground(UIManager.getColor("TextField.inactiveBackground"));
    }
    public void RecentThings(){
    
               DefaultTableModel model = (DefaultTableModel)table.getModel();
               DefaultTableModel dm = (DefaultTableModel)table.getModel();
dm.getDataVector().removeAllElements();
dm.fireTableDataChanged(); 
Date tmpdt = new Date();
SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
String dt = dateFormat.format(tmpdt);
System.out.println(dt);
Scanner read ;
        try {
            read = new Scanner(new File(ITMadd+"/item.txt"),"UTF-8");
        
            read.useDelimiter("\\n");
            while (read.hasNext())                    // It's for Item ... equals to the number of item
{

                float[] Sell={-1,-1,-1,-1,-1};float[] Buy={-1,-1,-1,-1,-1};
                String icode,iEname = null,iHname="";
                boolean b=false,s=false; //Done or not

               
      //read.nextLine();
      icode = read.nextLine();
      System.out.println(icode);
      Scanner inread ;
                File tmp = new File(ITMadd+"/"+icode+"/profile.txt");           // to get the name of item
                boolean fs = tmp.exists();
                if(fs){
                inread = new Scanner(new File(ITMadd+"/"+icode+"/profile.txt"),"UTF-8");          
                inread.useDelimiter("\\n");
                inread.nextLine();                // name of item having code ccode
                iEname = inread.nextLine();
                iHname = inread.nextLine();
                inread.close();

                }
                int conter =0;
                String tdt=dt;
                for(tdt=NamingDate.mainn(tdt);conter<60;conter++,tdt=datem15.mainn(tdt)){
       tmp = new File(ITMadd+"/"+icode+"/Status/"+NamingDateName.mainn(tdt)+".txt");            // to get the name of item
       fs = tmp.exists();
      if(fs){
      if(Sell[0]>0) s = true;
      if(Buy[0]>0) b = true;
      //System.out.println("s:"+s+"b:"+b);
          inread = new Scanner(new File(ITMadd+"/"+icode+"/Status/"+NamingDateName.mainn(tdt)+".txt"),"UTF-8");          
      inread.useDelimiter(",|\\n");
      inread.nextLine();
      inread.nextLine();
      while(inread.hasNext()){
      String dtt=inread.next();//System.out.println("1:"+inread.next());
      inread.next();//System.out.println("2:"+inread.next());
      String qty=inread.next();
      String rate=  inread.next();
      inread.next();//System.out.println("3:"+inread.next());
      inread.next();//System.out.println("4:"+inread.next());
      //inread.next();
      String SupCon =inread.next();
      SupCon=SupCon.substring(0, SupCon.length()-1);
      //System.out.println("Qty:"+qty+" rate:"+rate+" SupCon:"+SupCon);
      //System.out.println("SupCon:"+SupCon+" Party:"+SupCon.equalsIgnoreCase("Party")+" Customer:"+SupCon.equalsIgnoreCase("Customer"));
      if(SupCon.equalsIgnoreCase("Party")&&Float.valueOf(qty)>0){
          //System.out.println("Inside First ");
          if(!b) { //System.out.println("BRate:"+rate);
              Buy=insert(Buy,Float.valueOf(rate));
             
          }
          
      }else{
          //System.out.println("12 Inside Second ");
          if(SupCon.equalsIgnoreCase("Customer")&&Float.valueOf(qty)<0){
              //System.out.println("Inside Second ");
          if(!s)  {//System.out.println("SRate:"+rate);
          Sell=insert(Sell,Float.valueOf(rate));
          
          }
      }
          
      }
      
      }
      inread.close();
      }

     
      
           
//TextIO.putln(ccode +"  ---> "+CStatus);
        }
                System.out.println("Buy:"+avg(Buy)+"  Sell:"+avg(Sell));
                String pa=avg(Buy),pl="####",sa=avg(Sell),sl="####";
                 System.out.println("Buy:"+Buy[4]+" "+Buy[3]+" "+Buy[2]+" "+Buy[1]+" "+Buy[0]);
                System.out.println("Sell:"+Sell[4]+" "+Sell[3]+" "+Sell[2]+" "+Sell[1]+" "+Sell[0]);
                if(Buy[4]>0) pl=String.format("%.1f", Buy[4]);
                if(Sell[4]>0) sl=String.format("%.1f", Sell[4]);
                if(lang.compareToIgnoreCase("English")!=0){
                model.addRow(new Object[]{icode,iHname+" / "+iEname,pl,pa,sl,sa});
                }else{
                   model.addRow(new Object[]{icode,iEname+" / "+iHname,pl,pa,sl,sa}); 
                }
//break;        
}
read.close();
} catch (FileNotFoundException ex) {
            JLabel label = new JLabel("Item item. error !!! Error0015");
            label.setFont(new Font("Arial", Font.BOLD, 18));
            JOptionPane.showMessageDialog(null,label,"ERROR",JOptionPane.WARNING_MESSAGE);
       
        } 
}
    public float[] insert(float[] gt,float vlu){
      float[] res ={-1,-1,-1,-1,-1};
      for(int i=0;i<4;++i){
          res[i]=gt[i+1];
      }
      res[4]=vlu;
      return res;
    }
    public String avg(float[] values){
        float avgv =0;int count=0;
        for(int i=0;i<5;++i){
            if(values[i]>0){
              avgv+=values[i];  ++count;
            }
        }
        if(count!=0)
        avgv=avgv/count;
        String str = "####";
        if(avgv>0)
                str= String.format("%.1f", avgv);
        return str;
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        src = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Recent Transcation Item Summary");

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Recent Entries and there Values");

        table.setFont(new java.awt.Font("Monospaced", 0, 16)); // NOI18N
        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Code", "Name", "Purchased Last One", "Purchased Last 5's Avg.", "Selled Last One", "Selled Last 5's Avg."
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        table.setRowHeight(25);
        table.setRowMargin(2);
        jScrollPane1.setViewportView(table);

        src.setFont(new java.awt.Font("Monospaced", 0, 18)); // NOI18N
        src.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                srcKeyReleased(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Monospaced", 0, 18)); // NOI18N
        jLabel2.setText("Search:");

        jButton1.setFont(new java.awt.Font("Monospaced", 0, 18)); // NOI18N
        jButton1.setText("Refresh");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1116, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton1)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(src, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(src, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(jButton1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 731, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        RecentThings();
    }//GEN-LAST:event_jButton1ActionPerformed
int i=0;
    private void srcKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_srcKeyReleased
                final DefaultTableModel model = (DefaultTableModel)table.getModel();
        final TableModel tm = table.getModel();
           int t=table.getRowCount();
           
//table.scrollRectToVisible(null);
           //table.clearSelection();
           //System.out.println("RowCount:"+t);
                String tb;
                tb=src.getText();
                
                //top.setText("1"+tb);
                    if(!tb.isEmpty()){
                        int k=evt.getKeyCode();
                if(k==10){
                    i=table.getSelectedRow();
                    //System.out.println("Eneter is Pressed::"+i);
                    for( ++i;i<t;++i){
                        //System.out.println("i="+i);
                    //tb=src.getText();
                        //top.setText("3"+tb);
                    String n = (String)tm.getValueAt(i, 0);
                    n=n.toUpperCase();
                    tb=tb.toUpperCase();
                    //System.out.println("tb="+tb+"   n="+n);
                    if(n.contains(tb))
                    {
                        //System.out.println("yes:"+tb+":::"+i);
                        table.setRowSelectionInterval(i, i);
                             table.getSelectionModel().setSelectionInterval(i, i);
                             table.scrollRectToVisible(new Rectangle(table.getCellRect(i+5, 0, true)));
                        break;
                    //table.selectAll();
                    }else{
                        
                            String c = (String)tm.getValueAt(i, 1);
                        c=c.toUpperCase();
                            if(c.contains(tb)){       //mobile no
                             table.setRowSelectionInterval(i, i); 
                             table.getSelectionModel().setSelectionInterval(i, i);
                             table.scrollRectToVisible(new Rectangle(table.getCellRect(i+5, 0, true)));
                             break;
                            }
                            else{
                                
                                table.clearSelection();
                                
                            }
                        
                    }
                    
                    
                 
                    
                }
                    if(i==t){
                        table.setRowSelectionInterval(0, 0);
           table.getSelectionModel().setSelectionInterval(0, 0);
table.scrollRectToVisible(new Rectangle(table.getCellRect(0, 0, true)));
table.clearSelection();
                    }
                } 
                else{
                    table.setRowSelectionInterval(0, 0);
           table.getSelectionModel().setSelectionInterval(0, 0);
table.scrollRectToVisible(new Rectangle(table.getCellRect(0, 0, true)));
                    table.clearSelection();
                        
                        i=table.getSelectedRow();
                for( ++i;i<t;++i){
                     
                    String n = (String)tm.getValueAt(i, 0);
                    n=n.toUpperCase();
                    tb=tb.toUpperCase();
                     
                    if(n.contains(tb))
                    {
                         
                        table.setRowSelectionInterval(i, i);
                             table.getSelectionModel().setSelectionInterval(i, i);
                             table.scrollRectToVisible(new Rectangle(table.getCellRect(i+5, 0, true)));
                        break;
                    //table.selectAll();
                    }else{
                        
                            String c = (String)tm.getValueAt(i, 1);
                        c=c.toUpperCase();
                            if(c.contains(tb)){       //mobile no
                             table.setRowSelectionInterval(i, i);
                             table.getSelectionModel().setSelectionInterval(i, i);
                             table.scrollRectToVisible(new Rectangle(table.getCellRect(i+5, 0, true)));
                             break;
                            }
                            else{
                                table.clearSelection();
                                //System.out.println("nulli:"+table.getSelectedRow());
                                //src.requestFocus();
                                //table.setRowSelectionInterval(3, 3);
                            }
                       
                    }
                      
                } 
                if(i==t){
                        table.setRowSelectionInterval(0, 0);
           table.getSelectionModel().setSelectionInterval(0, 0);
table.scrollRectToVisible(new Rectangle(table.getCellRect(0, 0, true)));
table.clearSelection();
                    }
                    }
                 }
    }//GEN-LAST:event_srcKeyReleased

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Recent.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Recent.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Recent.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Recent.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Recent("D:/Shopy/Shopy","src/Icons/logo.png","1501","Hindi","20210101-20210628","01/01/2021","28/06/2021").setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField src;
    private javax.swing.JTable table;
    // End of variables declaration//GEN-END:variables
}
