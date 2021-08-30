/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shopyfinal;

import com.toedter.calendar.JDateChooser;
import com.toedter.calendar.JTextFieldDateEditor;
import java.awt.AWTException;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import static java.lang.Float.compare;
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

/**
 *
 * @author Suthar
 */
public class Order_Book extends javax.swing.JFrame {

    /**
     * Creates new form Order_Book
     */
    String baseadd, logo, user, ITMadd, ndt, dt, lang = "English";
    String IDyear = "2020-2020", Syear = "01/01/2020", Eyear = "01/01/2020";

    public Order_Book(String base, String golo, String gh, String idy, String sy, String ey) {
        baseadd = base;
        logo = golo;
        IDyear = idy;
        Syear = sy;
        Eyear = ey;
        dt = gh;
        ndt = ShortFunction.NamingDate(dt);
        try {
            user = ShortFunction.GetLine(baseadd + "/Cuser.txt", 2);
        } catch (IOException ex) {
            JLabel label = new JLabel("Current user !!! Error0003");
            label.setFont(new Font("Arial", Font.BOLD, 18));
            JOptionPane.showMessageDialog(null, label, "ERROR", JOptionPane.WARNING_MESSAGE);

        }
        ITMadd = baseadd + "/" + user + "/" + IDyear + "/item";
        initComponents();
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        setBounds(50, 50, (int) dim.getWidth() / 2, (int) dim.getHeight() - 40);
        this.setLocationRelativeTo(null);
        try {
            this.setIconImage(ImageIO.read(new File(logo)));
        } catch (IOException ex) {
            JLabel label = new JLabel("Logo Problem !!! Error0001");
            label.setFont(new Font("Arial", Font.BOLD, 18));
            JOptionPane.showMessageDialog(null, label, "ERROR", JOptionPane.WARNING_MESSAGE);

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
            JLabel label = new JLabel("Language Setup Error !!");
            label.setFont(new Font("Arial", Font.BOLD, 18));
            JOptionPane.showMessageDialog(null, label, "ERROR", JOptionPane.WARNING_MESSAGE);
        }

        try {
            lang = ShortFunction.GetLine(baseadd + "/" + user + "/conf.txt", 1);
            System.out.println(lang);
        } catch (IOException ex) {
            JLabel label = new JLabel("Configuration Error !!! Error0003");
            label.setFont(new Font("Arial", Font.BOLD, 18));
            JOptionPane.showMessageDialog(null, label, "ERROR", JOptionPane.WARNING_MESSAGE);
        }
        if (lang.compareToIgnoreCase("English") != 0) {

        }

//##################################################################################################################################
        lacknesschecker();
    }

    public void lacknesschecker() {
        dtlbl.setText("Date : " + dt);
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        DefaultTableModel dm = (DefaultTableModel) table.getModel();
        dm.getDataVector().removeAllElements();
        dm.fireTableDataChanged();
        Scanner read;
        try {
            read = new Scanner(new File(ITMadd + "/item.txt"), "UTF-8");

            read.useDelimiter("\\n");
            while (read.hasNext()) // It's for Item ... equals to the number of item
            {
                float Exp = 0;
                float CStatus = (float) 000.00, TotalITM = (float) 000.00, TotalITMOnDS = (float) 000.00, TotalITMOnDB = (float) 000.00;
                String icode, iEname = null, iHname = "", str1 = "00";

                icode = read.nextLine();
                Scanner inread;
                File tmp = new File(ITMadd + "/" + icode + "/profile.txt");           // to get the name of item
                boolean fs = tmp.exists();
                if (fs) {
                    inread = new Scanner(new File(ITMadd + "/" + icode + "/profile.txt"), "UTF-8");
                    inread.useDelimiter("\\n");
                    inread.nextLine();                // name of item having code ccode
                    iEname = inread.nextLine();
                    iHname = inread.nextLine();
                    inread.nextLine();
                    inread.nextLine();
                    inread.nextLine();
                    inread.nextLine();
                    Exp = Float.valueOf(inread.nextLine());
                    inread.close();

                }
                int conter = 0;
                String tdt = dt;
                for (tdt = ShortFunction.NamingDate(tdt); conter < 60; conter++, tdt = ShortFunction.Date_minus(tdt)) {
                    tmp = new File(ITMadd + "/" + icode + "/Status/" + ShortFunction.NamingDateName(tdt) + ".txt");            // to get the name of item
                    fs = tmp.exists();
                    if (fs) {
                        break;
                    }
                }

                tmp = new File(ITMadd + "/" + icode + "/Status/" + ShortFunction.NamingDateName(tdt) + ".txt");            // to get the name of item
                fs = tmp.exists();
                if (fs) {
                    System.out.println(ITMadd + "/" + icode + "/Status/" + ShortFunction.NamingDateName(tdt) + ".txt");
                    inread = new Scanner(new File(ITMadd + "/" + icode + "/Status/" + ShortFunction.NamingDateName(tdt) + ".txt"), "UTF-8");
                    inread.useDelimiter(",|\\n");
                    CStatus = Float.valueOf(inread.nextLine());
                    inread.nextLine();
                    while (inread.hasNext()) {
                        String datee = inread.next();
                        if (ShortFunction.DateInBetween(tdt, datee, dt)) {

                            inread.next();
                            str1 = inread.next();                // name of item having code ccode
                            inread.nextLine();
                            TotalITM = TotalITM + Float.valueOf(str1);
                            if (datee.equals(dt)) {
                                if (Float.valueOf(str1) > 0) {
                                    TotalITMOnDB = TotalITMOnDB + Float.valueOf(str1);
                                } else {
                                    TotalITMOnDS = TotalITMOnDS + Float.valueOf(str1);
                                }
                            }

                        } else {
                            inread.nextLine();
                        }
                    }
                    inread.close();
                }

                CStatus = CStatus + TotalITM;
                if (compare(CStatus, Exp) < 0) {
                    String s1 = String.format("%.02f", CStatus);
                    if (lang.compareToIgnoreCase("English") != 0) {
                        model.addRow(new Object[]{table.getRowCount() + 1, icode, iHname, s1, Exp});
                    } else {
                        model.addRow(new Object[]{table.getRowCount() + 1, icode, iEname, s1, Exp});
                    }
                }
//TextIO.putln(ccode +"  ---> "+CStatus);
            }
            read.close();
        } catch (FileNotFoundException ex) {
            JLabel label = new JLabel("Item item. error !!! Error0015");
            label.setFont(new Font("Arial", Font.BOLD, 18));
            JOptionPane.showMessageDialog(null, label, "ERROR", JOptionPane.WARNING_MESSAGE);

        }
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
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        dtlbl = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Monospaced", 0, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Item order Book");

        jButton1.setFont(new java.awt.Font("Monospaced", 0, 18)); // NOI18N
        jButton1.setText("Print");

        jButton2.setFont(new java.awt.Font("Monospaced", 0, 18)); // NOI18N
        jButton2.setText("Close");

        dtlbl.setFont(new java.awt.Font("Monospaced", 0, 18)); // NOI18N
        dtlbl.setText("Date: 01/02/2020");
        dtlbl.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                dtlblMouseClicked(evt);
            }
        });

        table.setFont(new java.awt.Font("Monospaced", 0, 13)); // NOI18N
        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Serial No.", "Item Code", "Item Name", "Current Stock", "Minmum Stock Req."
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(table);
        if (table.getColumnModel().getColumnCount() > 0) {
            table.getColumnModel().getColumn(4).setMinWidth(150);
            table.getColumnModel().getColumn(4).setMaxWidth(300);
        }

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(dtlbl, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 120, Short.MAX_VALUE)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(77, 77, 77)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(49, 49, 49))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1)
                        .addGap(25, 25, 25))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 473, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2)
                    .addComponent(dtlbl))
                .addGap(37, 37, 37))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
public void setter() {
        this.setEnabled(true);
    }

    public void daty() {
        // public static void mainn(){
        this.setEnabled(false);
        final JFrame ID = new JFrame("Changing Date");
        JLabel hdlbl = new JLabel(": Select a Date :");
        JLabel lbl = new JLabel("Date :");
        JDateChooser chd = new JDateChooser();
        final JLabel err = new JLabel("");
        hdlbl.setBounds(120, 20, 100, 30);
        lbl.setBounds(50, 70, 100, 30);
        chd.setBounds(100, 70, 200, 30);
        chd.setDateFormatString("dd/MM/yyyy");
        chd.setFont(new java.awt.Font("Tahoma", 3, 22));
        JTextFieldDateEditor editor = (JTextFieldDateEditor) chd.getDateEditor();
        editor.setEditable(false);
        try {
            //Calender
            chd.setMinSelectableDate(new SimpleDateFormat("dd/MM/yyyy").parse(Syear));
            chd.setMaxSelectableDate(new SimpleDateFormat("dd/MM/yyyy").parse(Eyear));
        } catch (ParseException ex) {
            JLabel label = new JLabel("There is issue while setup calender bounds");
            label.setFont(new Font("Arial", Font.BOLD, 18));
            JOptionPane.showMessageDialog(this, label, "ERROR", JOptionPane.WARNING_MESSAGE);
            System.exit(1);
        }
        try {
            chd.setDate(new SimpleDateFormat("dd/MM/yyyy").parse(dt));
        } catch (ParseException ex) {
            chd.setDate(new Date());
        }
        JButton cancel = new JButton("Cancel");
        JButton confirm = new JButton("Confirm");
        cancel.setBounds(50, 150, 100, 30);
        confirm.setBounds(220, 150, 100, 30);
        ID.add(hdlbl);
        ID.add(lbl);
        ID.add(cancel);
        ID.add(confirm);
        ID.add(err);
        ID.setLocationRelativeTo(this);
        ID.add(chd);
        ID.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        ID.setSize(400, 300);
        ID.setLayout(null);
        ID.setAlwaysOnTop(true);
        ID.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent event) {
                setter();
                //code.requestFocus();
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
                dt = dateFormat.format(chd.getDate());
                dtlbl.setText("Date : " + dt);
                setter();
                lacknesschecker();
                ID.dispose();

            }
        });

        // Working of Confirm Button OVER
//######################################################################################3
    }
    private void dtlblMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dtlblMouseClicked
        daty();
    }//GEN-LAST:event_dtlblMouseClicked

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
            java.util.logging.Logger.getLogger(Order_Book.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Order_Book.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Order_Book.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Order_Book.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                // new Order_Book().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel dtlbl;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable table;
    // End of variables declaration//GEN-END:variables
}
