/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shopyfinal;

import java.awt.AWTException;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author Suthar
 */
public class Item_To_Print extends javax.swing.JFrame {

    /**
     * Creates new form Item_To_Print
     */
    static void main(String baseadd, String logo, String idy, String sy, String ey) {

        new Item_To_Print(baseadd, logo, idy, sy, ey).setVisible(true);
//throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    //ublic Gsetting1(String base,String golo) {
    String baseadd, logo, user, ITMadd, lang = "English";
    String IDyear = "2020-2020", Syear = "01/01/2020", Eyear = "01/01/2020";

    public Item_To_Print(String base, String golo, String idy, String sy, String ey) {

        baseadd = base;
        logo = golo;
        IDyear = idy;
        Syear = sy;
        Eyear = ey;

        try {
            user = ShortFunction.GetLine(baseadd + "/Cuser.txt", 2);
        } catch (IOException ex) {
            JLabel label = new JLabel("Current user !!! Error0003" + ex);
            label.setFont(new Font("Arial", Font.BOLD, 18));
            JOptionPane.showMessageDialog(this, label, "ERROR", JOptionPane.WARNING_MESSAGE);

        }
        ITMadd = baseadd + "/" + user + "/" + IDyear + "/item";
        initComponents();
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        setBounds(50, 50, 550, (int) dim.getHeight() - 50);
        this.setLocationRelativeTo(null);

        try {
            this.setIconImage(ImageIO.read(new File(logo)));
        } catch (IOException ex) {
            JLabel label = new JLabel("Logo Problem !!! Error0001");
            label.setFont(new Font("Arial", Font.BOLD, 18));
            JOptionPane.showMessageDialog(this, label, "ERROR", JOptionPane.WARNING_MESSAGE);

        }

        try {
            Robot r = new Robot();
            r.keyPress(KeyEvent.VK_ALT);
            r.keyPress(KeyEvent.VK_SHIFT);
            r.keyPress(KeyEvent.VK_0);
            r.keyRelease(KeyEvent.VK_0);
            r.keyRelease(KeyEvent.VK_SHIFT);
            r.keyRelease(KeyEvent.VK_ALT);
        } catch (AWTException ex) {
            JLabel label = new JLabel("Language Setup Error !!" + ex);
            label.setFont(new Font("Arial", Font.BOLD, 18));
            JOptionPane.showMessageDialog(this, label, "ERROR", JOptionPane.WARNING_MESSAGE);
        }

        try {
            lang = ShortFunction.GetLine(baseadd + "/" + user + "/conf.txt", 1);
            System.out.println(lang);
        } catch (IOException ex) {
            JLabel label = new JLabel("Configuration Error !!! Error0003" + ex);
            label.setFont(new Font("Arial", Font.BOLD, 18));
            JOptionPane.showMessageDialog(this, label, "ERROR", JOptionPane.WARNING_MESSAGE);
        }
        try {
            String state1 = "false";
            state1 = ShortFunction.GetLine(ITMadd + "/" + "/itemmust.txt", 1);
            String icd = "XYZ";
            icd = ShortFunction.GetLine(ITMadd + "/" + "/itemmust.txt", 2);
            String pgty = "1";
            pgty = ShortFunction.GetLine(ITMadd + "/" + "/itemmust.txt", 3);
            chk.setState(Boolean.valueOf(state1));
            must.setText(icd);
            pgtype.setSelectedIndex(Integer.valueOf(pgty));

        } catch (IOException ex) {
            JLabel label = new JLabel("Must Contain Error Please go to setting and do required" + ex);
            label.setFont(new Font("Arial", Font.BOLD, 18));
            JOptionPane.showMessageDialog(this, label, "ERROR", JOptionPane.WARNING_MESSAGE);
        }
        if (lang.compareToIgnoreCase("English") != 0) {

            hdlbl.setText("उन सभी को टिक करें ,जिन्हें आप बिलों पर प्रिंट करना चाहते हैं");
            sub.setText("सेव करे");
            can.setText("रद्द करे");
            sel.setText("सभी का चयन करे");
        }

//#########################################################################################################################################3
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        Scanner read;
        try {
            read = new Scanner(new File(ITMadd + "/item.txt"), "UTF-8");
            read.useDelimiter("\\n");

            String code, Ename, Hname;
            while (read.hasNext()) {

                //TextIO.put(read.hasNext());
                String Pacc = read.nextLine();
                Scanner inread;
                try {
                    inread = new Scanner(new File(ITMadd + "/" + Pacc + "/profile.txt"), "UTF-8");
                    inread.useDelimiter("\\n");
                    code = inread.nextLine();
                    Ename = inread.nextLine();
                    Hname = inread.nextLine();
                    if (lang.compareToIgnoreCase("English") != 0) {
                        model.addRow(new Object[]{getsts(code), code, Hname});
                    } else {
                        model.addRow(new Object[]{getsts(code), code, Ename});
                    }
                    //TextIO.putln(i);
                    inread.close();
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(Item_To_Print.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
            read.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Item_To_Print.class.getName()).log(Level.SEVERE, null, ex);
        }
        table.setShowGrid(true);
        table.setGridColor(Color.YELLOW);
    }

    public boolean getsts(String pc) {
        boolean res = false;

        if (ShortFunction.repeatation(ITMadd, "itemp.txt", pc) == 1) {
            res = true;
        }
        return res;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        sub = new javax.swing.JButton();
        can = new javax.swing.JButton();
        hdlbl = new javax.swing.JLabel();
        sel = new javax.swing.JLabel();
        src = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        chk = new java.awt.Checkbox();
        must = new javax.swing.JTextField();
        pgtype = new javax.swing.JComboBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setAlwaysOnTop(true);

        table.setFont(new java.awt.Font("Monospaced", 0, 16)); // NOI18N
        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Print", "Code", "Name"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Boolean.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                true, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        table.setRowHeight(20);
        jScrollPane1.setViewportView(table);

        sub.setFont(new java.awt.Font("Monospaced", 1, 18)); // NOI18N
        sub.setText("Submit");
        sub.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                subActionPerformed(evt);
            }
        });

        can.setFont(new java.awt.Font("Monospaced", 1, 18)); // NOI18N
        can.setText("Cancel");
        can.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                canActionPerformed(evt);
            }
        });

        hdlbl.setFont(new java.awt.Font("Monospaced", 0, 18)); // NOI18N
        hdlbl.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        hdlbl.setText("Tick ​​all you want to print on bills");

        sel.setForeground(new java.awt.Color(0, 0, 240));
        sel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        sel.setText("Select All");
        sel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                selMouseClicked(evt);
            }
        });

        src.setFont(new java.awt.Font("Monospaced", 2, 18)); // NOI18N
        src.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                srcKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                srcKeyTyped(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); // NOI18N
        jLabel3.setText("Search :");

        chk.setLabel("Must Contain");
        chk.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                chkMouseClicked(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                chkMouseReleased(evt);
            }
        });

        pgtype.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "A4", "Roll" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 543, Short.MAX_VALUE)
                    .addComponent(hdlbl, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(can)
                                .addGap(56, 56, 56)
                                .addComponent(sel, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(sub))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(chk, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(must, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(pgtype, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(src, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(hdlbl)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(src, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel3))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(must, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(pgtype, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(chk, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 682, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(sub)
                    .addComponent(can)
                    .addComponent(sel))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void canActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_canActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_canActionPerformed

    private void subActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_subActionPerformed
        // TODO add your handling code here:

        if (chk.getState() && must.getText().isEmpty()) {
            JLabel label = new JLabel("Empty cannot be the item code for any item");
            label.setFont(new Font("Arial", Font.BOLD, 18));
            JOptionPane.showMessageDialog(this, label, "ERROR", JOptionPane.WARNING_MESSAGE);
        } else {
            try {                //set customer account to customer.txt

                //PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(ITMadd+"/"+ "/itemp.txt",true)));
                PrintWriter out = new PrintWriter(new OutputStreamWriter(new FileOutputStream(ITMadd + "/" + "/itemmust.txt"), "UTF-8"));
                out.println(chk.getState());
                out.println(must.getText());
                out.println(pgtype.getSelectedIndex());
                out.close();
            } catch (IOException ex) {
                JLabel label = new JLabel("itemp(rint).txt Problem !!! Error00071" + ex);
                label.setFont(new Font("Arial", Font.BOLD, 18));
                JOptionPane.showMessageDialog(this, label, "ERROR", JOptionPane.WARNING_MESSAGE);

            }

            int sz = table.getRowCount();
            File f = new File(ITMadd + "/" + "/itemp.txt");
            if (f.exists()) {
                f.delete();
            }

            for (int i = 0; i < sz; ++i) {
                Object o = table.getValueAt(i, 0);
                boolean ptb = Boolean.parseBoolean(String.valueOf(o));
                if (ptb == true) {
                    o = table.getValueAt(i, 1);
                    String icode = String.valueOf(o);
                    try {                //set customer account to customer.txt

                        //PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(ITMadd+"/"+ "/itemp.txt",true)));
                        PrintWriter out = new PrintWriter(new OutputStreamWriter(new FileOutputStream(ITMadd + "/" + "/itemp.txt", true), "UTF-8"));
                        out.println(icode);
                        out.close();
                    } catch (IOException ex) {
                        JLabel label = new JLabel("itemp(rint).txt Problem !!! Error00071" + ex);
                        label.setFont(new Font("Arial", Font.BOLD, 18));
                        JOptionPane.showMessageDialog(this, label, "ERROR", JOptionPane.WARNING_MESSAGE);

                    }
                }
            }

            this.dispose();
        }
    }//GEN-LAST:event_subActionPerformed
    int sta = 0;
    private void selMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_selMouseClicked
        // TODO add your handling code here:
        int sz = table.getRowCount();
        for (int i = 0; i < sz; ++i) {
            if (sta == 0) {
                table.setValueAt(true, i, 0);
            } else {
                table.setValueAt(false, i, 0);
            }

        }
        if (sta == 0) {
            sel.setText("सभी को अचिन्हिंत करे");
            sta = 1;
        } else {
            sta = 0;
            sel.setText("सभी का चयन करे");
        }
    }//GEN-LAST:event_selMouseClicked
    int i = 0;
    private void srcKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_srcKeyReleased
        // TODO add your handling code here:
        // TODO add your handling code here:
        //final DefaultTableModel model = (DefaultTableModel)table.getModel();
        final TableModel tm = table.getModel();
        int t = table.getRowCount();

        String tb;
        tb = src.getText();

        //top.setText("1"+tb);
        if (!tb.isEmpty()) {
            int k = evt.getKeyCode();
            if (k == 10) {
                i = table.getSelectedRow();
                //System.out.println("Eneter is Pressed::"+i);
                for (++i; i < t; ++i) {
                    //System.out.println("i="+i);
                    //tb=src.getText();
                    //top.setText("3"+tb);
                    String n = (String) tm.getValueAt(i, 2);
                    n = n.toUpperCase();
                    tb = tb.toUpperCase();
                    //System.out.println("tb="+tb+"   n="+n);
                    if (n.contains(tb)) {
                        //System.out.println("yes:"+tb+":::"+i);
                        table.setRowSelectionInterval(i, i);
                        table.getSelectionModel().setSelectionInterval(i, i);
                        table.scrollRectToVisible(new Rectangle(table.getCellRect(i + 5, 0, true)));
                        break;
                        //table.selectAll();
                    } else {
                        String m = (String) tm.getValueAt(i, 1);
                        m = m.toUpperCase();
                        if (m.contains(tb)) {       //code
                            table.setRowSelectionInterval(i, i);
                            table.getSelectionModel().setSelectionInterval(i, i);
                            table.scrollRectToVisible(new Rectangle(table.getCellRect(i + 5, 0, true)));
                            break;
                        } else {
                            table.clearSelection();
                        }
                    }

                }
                if (i == t) {
                    table.setRowSelectionInterval(0, 0);
                    table.getSelectionModel().setSelectionInterval(0, 0);
                    table.scrollRectToVisible(new Rectangle(table.getCellRect(0, 0, true)));
                    table.clearSelection();
                }
            } else {
                table.setRowSelectionInterval(0, 0);
                table.getSelectionModel().setSelectionInterval(0, 0);
                table.scrollRectToVisible(new Rectangle(table.getCellRect(0, 0, true)));
                table.clearSelection();
                //tb=src.getText();
                //top.setText("2"+tb);
                i = table.getSelectedRow();
                for (++i; i < t; ++i) {
                    //tb=src.getText();
                    //top.setText("3"+i);
                    String n = (String) tm.getValueAt(i, 2);
                    n = n.toUpperCase();
                    tb = tb.toUpperCase();
                    //System.out.println("tb="+tb+"   n="+n);
                    if (n.contains(tb)) {
                        //System.out.println("yes:"+tb+":::"+i);
                        table.setRowSelectionInterval(i, i);
                        table.getSelectionModel().setSelectionInterval(i, i);
                        table.scrollRectToVisible(new Rectangle(table.getCellRect(i + 5, 0, true)));
                        break;
                        //table.selectAll();
                    } else {
                        String m = (String) tm.getValueAt(i, 1);
                        m = m.toUpperCase();
                        if (m.contains(tb)) {       //code
                            table.setRowSelectionInterval(i, i);
                            table.getSelectionModel().setSelectionInterval(i, i);
                            table.scrollRectToVisible(new Rectangle(table.getCellRect(i + 5, 0, true)));
                            break;
                        } else {
                            table.clearSelection();
                        }
                    }

                }
                if (i == t) {
                    table.setRowSelectionInterval(0, 0);
                    table.getSelectionModel().setSelectionInterval(0, 0);
                    table.scrollRectToVisible(new Rectangle(table.getCellRect(0, 0, true)));
                    table.clearSelection();
                }
            }
        }
    }//GEN-LAST:event_srcKeyReleased

    private void srcKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_srcKeyTyped
        char c = evt.getKeyChar();
        if (c == 10) {    //
            //getToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_srcKeyTyped

    private void chkMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_chkMouseClicked

    }//GEN-LAST:event_chkMouseClicked

    private void chkMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_chkMouseReleased

    }//GEN-LAST:event_chkMouseReleased

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
            java.util.logging.Logger.getLogger(Item_To_Print.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Item_To_Print.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Item_To_Print.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Item_To_Print.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                //new Item_To_Print().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton can;
    private java.awt.Checkbox chk;
    private javax.swing.JLabel hdlbl;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField must;
    private javax.swing.JComboBox pgtype;
    private javax.swing.JLabel sel;
    private javax.swing.JTextField src;
    private javax.swing.JButton sub;
    private javax.swing.JTable table;
    // End of variables declaration//GEN-END:variables
}
