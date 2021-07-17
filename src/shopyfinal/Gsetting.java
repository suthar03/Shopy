/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shopyfinal;

import java.awt.AWTException;
import java.awt.Font;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;
import javax.imageio.ImageIO;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 *
 * @author Suthar
 */
public class Gsetting extends javax.swing.JFrame {

    static void main(String baseadd, String logo, String Add) {
        
new Gsetting(baseadd,logo,Add).setVisible(true);        
//throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    

    /**
     * Creates new form 
     */
    String sd;
int yt=0;
 String baseadd,logo,Address ,user,CMRadd,ITMadd,lang="English";;
 int amtd=0;
    public Gsetting(String base,String golo,String Add) {
        baseadd=base;
       logo=golo;
       Address = Add;
        try {
            user = GetLine.mainn(baseadd+"/Cuser.txt", 2);
        } catch (IOException ex) {
            JLabel label = new JLabel("Current user !!! Error0003");
            label.setFont(new Font("Arial", Font.BOLD, 18));
            JOptionPane.showMessageDialog(this,label,"ERROR",JOptionPane.WARNING_MESSAGE);
        
        }
        CMRadd = baseadd+"/"+user+"/customer";
        ITMadd = baseadd+"/"+user+"/item";
        initComponents();
        
      //  Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
    //setBounds(50, 50, 903, (int) dim.getHeight()-40);
        this.setLocationRelativeTo(null);
        try {
            this.setIconImage(ImageIO.read(new File(logo)));
        } catch (IOException ex) {
            JLabel label = new JLabel("Logo Problem !!! Error0001");
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
        JLabel label = new JLabel("Language Setup Error !!"+ex);        
        label.setFont(new Font("Arial", Font.BOLD, 18));        
        JOptionPane.showMessageDialog(this,label,"ERROR",JOptionPane.WARNING_MESSAGE);
    }
        //Language setup
        try {
        lang = GetLine.mainn(baseadd+"/"+user+"/conf.txt", 1);
        //System.out.println(lang);
        } catch (IOException ex) {
        JLabel label = new JLabel("Configuration Error !!! Error0003");
        label.setFont(new Font("Arial", Font.BOLD, 18));
        JOptionPane.showMessageDialog(this,label,"ERROR",JOptionPane.WARNING_MESSAGE);
        }
        if(lang.compareToIgnoreCase("English")!=0){
            hdl.setText(":: सेटिंग ::");
            cslbl.setText("कैश इस रूप मे लिया जाएगा :");
            nmlbl.setText("नाम :");
            rtlbl.setText("रेट :");
            //prnt.setLabel(" प्रिंटर ");
            dwaylbl.setText("डिफ़ॉल्ट way :");
            dmodelbl.setText("डिफ़ॉल्ट Mode :");
            dremlbl.setText("डिफ़ॉल्ट रेमार्क :");
            //nmedt.setLabel(" ग्राहक पार्टी का नाम संपादन");
            cnc.setText("बंद करे");
            cnf.setText("कन्फर्म");
            
        }
        
        Scanner ot;
                    //System.out.println("Inner"+tb);

                    try {
                        ot = new Scanner(new File(Address+"/setting.txt"),"UTF-8");
                        icode.setText(ot.nextLine());
                        iname.setText(ot.nextLine());
                        rate.setText(ot.nextLine());
                        prnt.setState(Boolean.valueOf(ot.nextLine()));
                        sway.setSelectedIndex(Integer.valueOf(ot.nextLine()));
                        smode.setSelectedIndex(Integer.valueOf(ot.nextLine()));
                        rem.setText(ot.nextLine());
                        nmedt.setState(Boolean.valueOf(ot.nextLine()));
                        ot.close();
                    }
                    catch (FileNotFoundException ex) {
                        JLabel label = new JLabel("Item Profile Error !!! Error0013");
                        label.setFont(new Font("Arial", Font.BOLD, 18));
                        JOptionPane.showMessageDialog(this,label,"ERROR",JOptionPane.WARNING_MESSAGE);
                    }
        
dmodelbl.requestFocus();
    }

    private Gsetting() {
        System.out.println("Gsetting void parameter called");
    }

    /* Gsetting(String baseadd, String logo) {
    System.out.println("Gsetting  parameter called");//throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }*/

    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel3 = new javax.swing.JLabel();
        dmodelbl = new javax.swing.JLabel();
        nmlbl = new javax.swing.JLabel();
        rtlbl = new javax.swing.JLabel();
        iname = new javax.swing.JTextField();
        rate = new javax.swing.JTextField();
        icode = new javax.swing.JTextField();
        cnc = new javax.swing.JButton();
        cnf = new javax.swing.JButton();
        hdl = new javax.swing.JLabel();
        cslbl = new javax.swing.JLabel();
        smode = new javax.swing.JComboBox();
        dremlbl = new javax.swing.JLabel();
        rem = new javax.swing.JTextField();
        prnt = new java.awt.Checkbox();
        nmedt = new java.awt.Checkbox();
        dwaylbl = new javax.swing.JLabel();
        sway = new javax.swing.JComboBox();

        jLabel3.setText("jLabel3");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("General Setting");
        setAlwaysOnTop(true);

        dmodelbl.setFont(new java.awt.Font("Monospaced", 0, 24)); // NOI18N
        dmodelbl.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        dmodelbl.setText("Default Mode : ");

        nmlbl.setFont(new java.awt.Font("Monospaced", 0, 24)); // NOI18N
        nmlbl.setText("Name :");

        rtlbl.setFont(new java.awt.Font("Monospaced", 0, 24)); // NOI18N
        rtlbl.setText("Rate :");

        iname.setFont(new java.awt.Font("Monospaced", 0, 24)); // NOI18N
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

        rate.setEditable(false);
        rate.setFont(new java.awt.Font("Monospaced", 3, 24)); // NOI18N
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

        icode.setEditable(false);
        icode.setFont(new java.awt.Font("Monospaced", 0, 24)); // NOI18N
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

        cnc.setFont(new java.awt.Font("Monospaced", 0, 24)); // NOI18N
        cnc.setText("Close");
        cnc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cncActionPerformed(evt);
            }
        });

        cnf.setFont(new java.awt.Font("Monospaced", 0, 24)); // NOI18N
        cnf.setText("Confirm");
        cnf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cnfActionPerformed(evt);
            }
        });
        cnf.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                cnfKeyPressed(evt);
            }
        });

        hdl.setFont(new java.awt.Font("Monospaced", 0, 24)); // NOI18N
        hdl.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        hdl.setText(":: Setting ::");

        cslbl.setFont(new java.awt.Font("Monospaced", 0, 24)); // NOI18N
        cslbl.setText("Cash Value Taken As :");

        smode.setFont(new java.awt.Font("Monospaced", 0, 24)); // NOI18N
        smode.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Pending", "By Cash" }));

        dremlbl.setFont(new java.awt.Font("Monospaced", 0, 24)); // NOI18N
        dremlbl.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        dremlbl.setText("Default Remark :");

        rem.setFont(new java.awt.Font("Monospaced", 0, 24)); // NOI18N
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

        prnt.setFont(new java.awt.Font("Monospaced", 0, 24)); // NOI18N
        prnt.setLabel("Printer");

        nmedt.setFont(new java.awt.Font("Monospaced", 0, 24)); // NOI18N
        nmedt.setLabel("Customer/Party Name Editability");

        dwaylbl.setFont(new java.awt.Font("Monospaced", 0, 24)); // NOI18N
        dwaylbl.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        dwaylbl.setText("Default way : ");

        sway.setFont(new java.awt.Font("Monospaced", 0, 24)); // NOI18N
        sway.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Becha", "Kharida" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(175, 175, 175)
                .addComponent(cnc, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(cnf, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(64, 64, 64))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(hdl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(prnt, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(470, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(nmlbl)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(iname, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(cslbl))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(icode)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(rtlbl)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(rate, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(110, 110, 110))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(nmedt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 5, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(dremlbl, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(rem))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(dwaylbl, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(sway, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(0, 0, Short.MAX_VALUE))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(dmodelbl, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(smode, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 198, Short.MAX_VALUE))))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(hdl)
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(icode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cslbl, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(43, 43, 43)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(iname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nmlbl)
                    .addComponent(rate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rtlbl))
                .addGap(36, 36, 36)
                .addComponent(prnt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(dwaylbl, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(smode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(dmodelbl, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(30, 30, 30)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(dremlbl, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(rem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(28, 28, 28)
                        .addComponent(nmedt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(58, 58, 58)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cnc)
                            .addComponent(cnf))
                        .addGap(21, 21, 21))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(sway, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void inameFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_inameFocusGained
        iname.selectAll();
    }//GEN-LAST:event_inameFocusGained

    private void inameFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_inameFocusLost
        // TODO add your handling code here:
        if(iname.getText().isEmpty())
        iname.setText("No Name");
    }//GEN-LAST:event_inameFocusLost

    private void inameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_inameActionPerformed

    private void inameKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_inameKeyPressed
        int a=evt.getKeyCode();
        if(a==10)
        rate.requestFocus();
    }//GEN-LAST:event_inameKeyPressed

    private void inameKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_inameKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_inameKeyTyped

    private void rateFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_rateFocusGained
        rate.selectAll();
    }//GEN-LAST:event_rateFocusGained

    private void rateFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_rateFocusLost
        
            try{
                Float.valueOf(rate.getText());
            }
            catch(Exception e){
            rate.setText("0.0");
            }
    }//GEN-LAST:event_rateFocusLost

    private void rateKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_rateKeyPressed

        int a = evt.getKeyCode();
        if (a == 10) {                     // for enter key
            cnf.requestFocus();
        }
    }//GEN-LAST:event_rateKeyPressed

    private void rateKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_rateKeyTyped
        char c = evt.getKeyChar();
        if(!(Character.isDigit(c)|| (c=='.'||(c==10)||c==82 ))){    //
            getToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_rateKeyTyped

    private void icodeFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_icodeFocusGained
       
    }//GEN-LAST:event_icodeFocusGained

    private void icodeFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_icodeFocusLost
        // TODO add your handling code here:
       
    }//GEN-LAST:event_icodeFocusLost

    private void icodeKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_icodeKeyPressed
        
    }//GEN-LAST:event_icodeKeyPressed

    private void icodeKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_icodeKeyReleased
        // TODO add your handling code here:

    }//GEN-LAST:event_icodeKeyReleased

    private void icodeKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_icodeKeyTyped
        // TODO add your handling code here:
        int a= evt.getKeyCode();
        if(a==10){
            evt.consume();
        }
    }//GEN-LAST:event_icodeKeyTyped

    private void cncActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cncActionPerformed
this.dispose();
    }//GEN-LAST:event_cncActionPerformed

    private void cnfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cnfActionPerformed
this.setAlwaysOnTop(false);
        int yon = JOptionPane.showConfirmDialog(null,"Do you want to Continue ??","Confirmation .......",JOptionPane.OK_OPTION);
        if(yon==0){
            //YES
            
                      try {                try ( //set customer account to customer.txt
                              
                              
                              BufferedWriter writ = Files.newBufferedWriter(Paths.get(Address+"/setting.txt"), StandardCharsets.UTF_8);
                              
                   ) {
                          
                   writ.append(icode.getText()+"\n"+iname.getText()+"\n"+rate.getText()+"\n"+prnt.getState()+"\n"+sway.getSelectedIndex()+"\n"+smode.getSelectedIndex()+"\n"+rem.getText()+"\n"+nmedt.getState()+"\n");
                   writ.flush();
                   this.dispose();
                      }
                    
                } catch (IOException ex) {
                    JLabel label = new JLabel("Customer Profile not opens !!! Error0008");
            label.setFont(new Font("Arial", Font.BOLD, 18));
            JOptionPane.showMessageDialog(null,label,"ERROR",JOptionPane.WARNING_MESSAGE);
       
                }
                      /* PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(baseadd+"/"+user+"/setting.txt"),"UTF-8")); // Stroing setting to the parmenent file
                      out.println(icode.getText());
                      out.println(new String(iname.getText().getBytes(),"UTF-8"));
                      out.println(rate.getText());
                      out.println(prnt.getState());
                      out.println(sway.getSelectedIndex());
                      out.println(new String(rem.getText().getBytes(),"UTF-8"));
                      out.println(nmedt.getState());
                      out.close();
                      JLabel label = new JLabel("Updated Successfully");
                      label.setFont(new Font("Arial", Font.BOLD, 18));
                      JOptionPane.showMessageDialog(this,label,"Successful ",JOptionPane.WARNING_MESSAGE);
                      this.dispose();*/
                      /*} catch (IOException ex) {
                      JLabel label = new JLabel("Problem in Current user setting !!! Error0020");
                      label.setFont(new Font("Arial", Font.BOLD, 18));
                      JOptionPane.showMessageDialog(this,label,"ERROR  !!",JOptionPane.WARNING_MESSAGE);
                      }*/
                    
        }
        else{
            this.setAlwaysOnTop(true);
dmodelbl.requestFocus();
        }
    }//GEN-LAST:event_cnfActionPerformed

    private void cnfKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cnfKeyPressed
int a=evt.getKeyCode();
if(a==10){
   cnf.doClick();
}
    }//GEN-LAST:event_cnfKeyPressed

    private void remFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_remFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_remFocusGained

    private void remFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_remFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_remFocusLost

    private void remActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_remActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_remActionPerformed

    private void remKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_remKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_remKeyPressed

    private void remKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_remKeyTyped
        // TODO add your handling code here:
        int a = evt.getKeyCode();
        if(a==10)
            cnf.requestFocus();
    }//GEN-LAST:event_remKeyTyped

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Gsetting().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cnc;
    private javax.swing.JButton cnf;
    private javax.swing.JLabel cslbl;
    private javax.swing.JLabel dmodelbl;
    private javax.swing.JLabel dremlbl;
    private javax.swing.JLabel dwaylbl;
    private javax.swing.JLabel hdl;
    private javax.swing.JTextField icode;
    private javax.swing.JTextField iname;
    private javax.swing.JLabel jLabel3;
    private java.awt.Checkbox nmedt;
    private javax.swing.JLabel nmlbl;
    private java.awt.Checkbox prnt;
    private javax.swing.JTextField rate;
    private javax.swing.JTextField rem;
    private javax.swing.JLabel rtlbl;
    private javax.swing.JComboBox smode;
    private javax.swing.JComboBox sway;
    // End of variables declaration//GEN-END:variables
}
