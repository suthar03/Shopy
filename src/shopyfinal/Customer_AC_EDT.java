/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package shopyfinal;

import java.awt.AWTException;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import javax.imageio.ImageIO;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 *
 * @author Suthar
 */
public class Customer_AC_EDT extends javax.swing.JFrame {

    String baseadd, logo, user, CMRadd, pibal = "0.0", cibal = "0.0", strD;
    String lang = "English";
    String IDyear = "2020-2020", Syear = "01/01/2020", Eyear = "01/01/2020", SSyear = "01/01/2020";

    public Customer_AC_EDT(String base, String golo, String idy, String sy, String ey) {
        baseadd = base;
        logo = golo;
        IDyear = idy;
        Syear = sy;
        Eyear = ey;
        SSyear = ShortFunction.NamingDate(Syear);
        try {
            user = ShortFunction.GetLine(baseadd + "/Cuser.txt", 2);
        } catch (IOException ex) {
            JLabel label = new JLabel("Current user !!! Error0003");
            label.setFont(new Font("Arial", Font.BOLD, 18));
            JOptionPane.showMessageDialog(null, label, "ERROR", JOptionPane.WARNING_MESSAGE);

        }
        CMRadd = baseadd + "/" + user + "/" + IDyear + "/customer";
        initComponents();
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        setBounds(50, 50, 845, (int) dim.getHeight() - 45);
        this.setLocationRelativeTo(null);
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

            hdlbl.setText("ग्राहक के खाता का विवरण सम्पादन ");
            cdlbl.setText("कोड :");
            Bgo.setText("आगे जाए");
            hdlbl2.setText("नई विवरण की प्रविष्टी");
            Enmlbl.setText("नाम(अंग्रेजी में) :");
            Hnmlbl.setText("नाम(हिन्दी में) :");
            mbllbl.setText("मोबाईल नं. :");
            addlbl.setText("पता :");
            ballbl.setText("शुरुआती बैलन्स :");
            dtlbl.setText("जोड़ने की दिनाँक :");
            Bcancel.setText("रद्द करे");
            Bsave.setText("सेव");
            Bclose.setText("बंद");

        }

        //info.setText(null);
        Date datee = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        strD = Eyear;
        pcode.requestFocus();
    }

    public void GO() {
        System.out.println(CMRadd + "/" + pcode.getText() + "/profile.txt");
        if (ShortFunction.repeatation(CMRadd, "customer.txt", pcode.getText()) == 1) {          // Means customer exists
            Scanner read;
            try {
                read = new Scanner(new File(CMRadd + "/" + pcode.getText() + "/profile.txt"), "UTF-8");
                read.useDelimiter("\\n");
                read.nextLine();
                Ename.setText(read.nextLine());
                Hname.setText(read.nextLine());
                pmob.setText(read.nextLine());
                padd.setText(read.nextLine());
                ibal.setText(read.nextLine());
                dt.setText(read.nextLine());
                read.close();
                pibal = ibal.getText();
                pcode.setEditable(false);
                Ename.requestFocus();

            } catch (FileNotFoundException ex) {
                JLabel label = new JLabel("profil. not found !!! Error0007");
                label.setFont(new Font("Arial", Font.BOLD, 18));
                JOptionPane.showMessageDialog(null, label, "ERROR", JOptionPane.WARNING_MESSAGE);
            }

        } else {
            pcode.requestFocus();
            JLabel label = new JLabel("There is no Customer with this code");
            label.setFont(new Font("Arial", Font.BOLD, 18));
            JOptionPane.showMessageDialog(null, label, "ERROR", JOptionPane.WARNING_MESSAGE);
            //errmessage.mainn("There is no Customer for this code", 220, 150);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        cdlbl = new javax.swing.JLabel();
        Enmlbl = new javax.swing.JLabel();
        mbllbl = new javax.swing.JLabel();
        addlbl = new javax.swing.JLabel();
        pcode = new javax.swing.JTextField();
        Ename = new javax.swing.JTextField();
        pmob = new javax.swing.JTextField();
        padd = new javax.swing.JTextField();
        Bgo = new javax.swing.JButton();
        Bsave = new javax.swing.JButton();
        Bclose = new javax.swing.JButton();
        hdlbl = new javax.swing.JLabel();
        dtlbl = new javax.swing.JLabel();
        ibal = new javax.swing.JTextField();
        ballbl = new javax.swing.JLabel();
        dt = new javax.swing.JTextField();
        hdlbl2 = new javax.swing.JLabel();
        Hname = new javax.swing.JTextField();
        Hnmlbl = new javax.swing.JLabel();
        Bcancel = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Editing Details of Customer");

        cdlbl.setFont(new java.awt.Font("Monospaced", 1, 16)); // NOI18N
        cdlbl.setText("Code :");

        Enmlbl.setFont(new java.awt.Font("Monospaced", 1, 16)); // NOI18N
        Enmlbl.setText("  Name(in English) :");

        mbllbl.setFont(new java.awt.Font("Monospaced", 1, 16)); // NOI18N
        mbllbl.setText("Mobile No. :");

        addlbl.setFont(new java.awt.Font("Monospaced", 1, 16)); // NOI18N
        addlbl.setText("Address :");

        pcode.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        pcode.setText("0001");
        pcode.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                pcodeFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                pcodeFocusLost(evt);
            }
        });
        pcode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pcodeActionPerformed(evt);
            }
        });
        pcode.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                pcodeKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                pcodeKeyTyped(evt);
            }
        });

        Ename.setFont(new java.awt.Font("Monospaced", 1, 16)); // NOI18N
        Ename.setText("No Name");
        Ename.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                EnameFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                EnameFocusLost(evt);
            }
        });
        Ename.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EnameActionPerformed(evt);
            }
        });
        Ename.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                EnameKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                EnameKeyTyped(evt);
            }
        });

        pmob.setFont(new java.awt.Font("Monospaced", 1, 16)); // NOI18N
        pmob.setText("No Number");
        pmob.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                pmobFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                pmobFocusLost(evt);
            }
        });
        pmob.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                pmobKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                pmobKeyTyped(evt);
            }
        });

        padd.setFont(new java.awt.Font("Monospaced", 1, 16)); // NOI18N
        padd.setText("XYZ");
        padd.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                paddFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                paddFocusLost(evt);
            }
        });
        padd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                paddActionPerformed(evt);
            }
        });
        padd.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                paddKeyPressed(evt);
            }
        });

        Bgo.setFont(new java.awt.Font("Monospaced", 1, 24)); // NOI18N
        Bgo.setText("Go");
        Bgo.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                BgoFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                BgoFocusLost(evt);
            }
        });
        Bgo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BgoActionPerformed(evt);
            }
        });
        Bgo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                BgoKeyPressed(evt);
            }
        });

        Bsave.setFont(new java.awt.Font("Monospaced", 1, 24)); // NOI18N
        Bsave.setText("Save");
        Bsave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BsaveActionPerformed(evt);
            }
        });
        Bsave.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                BsaveKeyPressed(evt);
            }
        });

        Bclose.setFont(new java.awt.Font("Monospaced", 1, 24)); // NOI18N
        Bclose.setText("Close");
        Bclose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BcloseActionPerformed(evt);
            }
        });
        Bclose.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                BcloseKeyPressed(evt);
            }
        });

        hdlbl.setBackground(new java.awt.Color(0, 240, 0));
        hdlbl.setFont(new java.awt.Font("Monospaced", 1, 18)); // NOI18N
        hdlbl.setForeground(new java.awt.Color(0, 240, 0));
        hdlbl.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        hdlbl.setText("Editing Details Of Existing Customer Account");

        dtlbl.setFont(new java.awt.Font("Monospaced", 1, 16)); // NOI18N
        dtlbl.setText("Date of Addition :");

        ibal.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        ibal.setText("00.0");
        ibal.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                ibalFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                ibalFocusLost(evt);
            }
        });
        ibal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ibalActionPerformed(evt);
            }
        });
        ibal.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                ibalKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                ibalKeyTyped(evt);
            }
        });

        ballbl.setFont(new java.awt.Font("Monospaced", 1, 16)); // NOI18N
        ballbl.setText("Initial Balance :");

        dt.setEditable(false);
        dt.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        dt.setText("00.0");
        dt.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                dtFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                dtFocusLost(evt);
            }
        });
        dt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dtActionPerformed(evt);
            }
        });
        dt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                dtKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                dtKeyTyped(evt);
            }
        });

        hdlbl2.setBackground(new java.awt.Color(0, 240, 0));
        hdlbl2.setFont(new java.awt.Font("Monospaced", 3, 18)); // NOI18N
        hdlbl2.setForeground(new java.awt.Color(240, 0, 0));
        hdlbl2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        hdlbl2.setText("-:: Enter New Details ::-");

        Hname.setFont(new java.awt.Font("Monospaced", 1, 16)); // NOI18N
        Hname.setText("कोई नाम नहीं");
        Hname.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                HnameFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                HnameFocusLost(evt);
            }
        });
        Hname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                HnameActionPerformed(evt);
            }
        });
        Hname.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                HnameKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                HnameKeyTyped(evt);
            }
        });

        Hnmlbl.setFont(new java.awt.Font("Monospaced", 1, 16)); // NOI18N
        Hnmlbl.setText("  Name(in Hindi) :");

        Bcancel.setFont(new java.awt.Font("Monospaced", 1, 24)); // NOI18N
        Bcancel.setText("Cancel");
        Bcancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BcancelActionPerformed(evt);
            }
        });
        Bcancel.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                BcancelKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(hdlbl, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addContainerGap(141, Short.MAX_VALUE)
                        .addComponent(cdlbl)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pcode, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(288, 288, 288)
                        .addComponent(Bgo, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(75, 75, 75)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(Enmlbl)
                                    .addComponent(Hnmlbl)
                                    .addComponent(mbllbl))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(pmob)
                                    .addComponent(hdlbl2, javax.swing.GroupLayout.DEFAULT_SIZE, 469, Short.MAX_VALUE)
                                    .addComponent(Ename, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(Hname)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(addlbl)
                                    .addComponent(ballbl)
                                    .addComponent(dtlbl))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(ibal, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(padd, javax.swing.GroupLayout.PREFERRED_SIZE, 469, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(dt, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(98, 98, 98)
                                .addComponent(Bclose, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(91, 91, 91)
                                .addComponent(Bcancel, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(Bsave, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(83, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(hdlbl)
                .addGap(53, 53, 53)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cdlbl)
                    .addComponent(pcode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Bgo, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(65, 65, 65)
                .addComponent(hdlbl2, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Enmlbl)
                    .addComponent(Ename, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 44, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Hname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Hnmlbl))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(mbllbl)
                    .addComponent(pmob, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 42, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addlbl)
                    .addComponent(padd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ibal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ballbl))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(dtlbl)
                    .addComponent(dt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(45, 45, 45)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Bsave)
                    .addComponent(Bclose)
                    .addComponent(Bcancel))
                .addGap(57, 57, 57))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void pcodeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pcodeActionPerformed
        // TODO add your handling code here:
}//GEN-LAST:event_pcodeActionPerformed

    private void EnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EnameActionPerformed
        // TODO add your handling code here:
}//GEN-LAST:event_EnameActionPerformed

    private void pcodeKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_pcodeKeyPressed
        int a = evt.getKeyCode();
        if (a == 10) {
            try {
                Integer.valueOf(pcode.getText());
                Bgo.requestFocus();
                Bgo.doClick();
            } catch (Exception e) {
                pcode.requestFocus();
            }
        }
    }//GEN-LAST:event_pcodeKeyPressed

    private void BgoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_BgoFocusGained

    }//GEN-LAST:event_BgoFocusGained

    private void BgoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BgoActionPerformed
        GO();
    }//GEN-LAST:event_BgoActionPerformed

    private void BgoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_BgoKeyPressed
        int a = evt.getKeyCode();
        if (a == 10) {
            Bgo.doClick();
        }
    }//GEN-LAST:event_BgoKeyPressed

    private void EnameKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_EnameKeyPressed
        int a = evt.getKeyCode();
        if (a == 10) {
            Hname.requestFocus();
        }
    }//GEN-LAST:event_EnameKeyPressed

    private void pmobKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_pmobKeyPressed
        int a = evt.getKeyCode();
        if (a == 10) {
            padd.requestFocus();
        }
    }//GEN-LAST:event_pmobKeyPressed

    private void paddKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_paddKeyPressed
        int a = evt.getKeyCode();
        if (a == 10) {
            ibal.requestFocus();
        }
    }//GEN-LAST:event_paddKeyPressed

    private void pcodeFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_pcodeFocusGained
        pcode.selectAll();
        this.setAlwaysOnTop(true);
    }//GEN-LAST:event_pcodeFocusGained

    private void EnameFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_EnameFocusGained
        Ename.selectAll();
    }//GEN-LAST:event_EnameFocusGained

    private void pmobFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_pmobFocusGained
        pmob.selectAll();
    }//GEN-LAST:event_pmobFocusGained

    private void paddFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_paddFocusGained
        padd.selectAll();
        if (lang.compareToIgnoreCase("English") != 0) {
            try {
                Robot r = new Robot();
                r.keyPress(KeyEvent.VK_ALT);
                r.keyPress(KeyEvent.VK_SHIFT);
                r.keyPress(KeyEvent.VK_1);
                r.keyRelease(KeyEvent.VK_1);
                r.keyRelease(KeyEvent.VK_SHIFT);
                r.keyRelease(KeyEvent.VK_ALT);
            } catch (AWTException ex) {
                JLabel label = new JLabel("Language Setup Error !!");
                label.setFont(new Font("Arial", Font.BOLD, 18));
                JOptionPane.showMessageDialog(null, label, "ERROR", JOptionPane.WARNING_MESSAGE);
            }
        }
    }//GEN-LAST:event_paddFocusGained

    private void BcloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BcloseActionPerformed
        this.dispose();
    }//GEN-LAST:event_BcloseActionPerformed

    private void BcloseKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_BcloseKeyPressed
        int a = evt.getKeyCode();
        if (a == 10) {
            this.dispose();
        }
    }//GEN-LAST:event_BcloseKeyPressed

    private void BsaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BsaveActionPerformed
        this.setAlwaysOnTop(false);
        int yon = JOptionPane.showConfirmDialog(null, "Do you want to Save ??!", "Confirmation .......", JOptionPane.OK_OPTION);
        if (yon == 0) {//YES    }
            PrintWriter out;
            if (ShortFunction.repeatation(CMRadd, "customer.txt", pcode.getText()) != 0) {
                try {
                    //out = new PrintWriter(new BufferedWriter(new FileWriter(CMRadd + "/" + pcode.getText() + "/profile.txt")));
                    out = new PrintWriter(new OutputStreamWriter(new FileOutputStream(CMRadd + "/" + pcode.getText() + "/profile.txt"), "UTF-8"));
                    out.println(pcode.getText());
                    out.println(Ename.getText());
                    out.println(Hname.getText());
                    out.println(pmob.getText());
                    out.println(padd.getText());
                    out.println(ibal.getText());
                    out.println(dt.getText());
                    out.close();
                    cibal = ibal.getText();
                    //updating according to just enterd ibalance if this different that of older one

                    boolean cd = false;
                    String nstrk = "0.0", strk = "0.0", ddt = ShortFunction.NamingDate(dt.getText());

                    if (Float.compare(Float.valueOf(pibal), Float.valueOf(cibal)) != 0) {
                        cd = ShortFunction.DateInBetween(ShortFunction.NamingDate(dt.getText()), ddt, strD);

                        while (cd) {

                            Scanner in;

                            try {
                                in = new Scanner(new File(CMRadd + "/" + pcode.getText() + "/Pending/Given/" + ShortFunction.NamingDateName(ddt) + ".txt"), "UTF-8");

                                strk = in.nextLine();
                                in.close();

                                nstrk = String.valueOf(Float.valueOf(strk) + Float.valueOf(pibal) - Float.valueOf(cibal));
                                System.out.println("strk=" + strk + "pibal=" + pibal + "cibal=" + cibal + "nstrk=" + nstrk);
                                ShortFunction.ReplaceLineWN(CMRadd + "/" + pcode.getText() + "/Pending/Given", ShortFunction.NamingDateName(ddt) + ".txt", 1, nstrk);
                            } catch (IOException ex) {
                                System.out.println("File not exist for " + ex);
                            }

                            ddt = ShortFunction.Date_plus(ddt);
                            cd = ShortFunction.DateInBetween(ShortFunction.NamingDate(dt.getText()), ddt, strD);
                            //System.out.println("Working on :"+ShortFunction.NamingDate(dt.getText())+"<<<"+ddt+">>>>"+strD+"======"+cd);
                        }
                    }
                    // pcode.setText("0001");
                    Ename.setText("No Name");
                    Hname.setText("कोई नाम नहीं");
                    pmob.setText("No Number");
                    padd.setText("No Address");
                    ibal.setText("00.0");
                    dt.setText(null);
                    pcode.setEditable(true);
                    pcode.requestFocus();
                    JLabel label = new JLabel("Profile updated  !!! ");
                    label.setFont(new Font("Arial", Font.BOLD, 18));
                    JOptionPane.showMessageDialog(null, label, "Successful .. ", JOptionPane.INFORMATION_MESSAGE);

                } catch (IOException ex) {
                    JLabel label = new JLabel("Error Occurs while saving file");
                    label.setFont(new Font("Arial", Font.BOLD, 18));
                    JOptionPane.showMessageDialog(null, label, "ERROR", JOptionPane.ERROR_MESSAGE);
                    //errmessage.mainn("Error Occurs in saving file", 200, 150);
                }
            } else {
                this.setAlwaysOnTop(true);
                pcode.requestFocus();
                JLabel label = new JLabel("Profile updated  !!! ");
                label.setFont(new Font("Arial", Font.BOLD, 18));
                JOptionPane.showMessageDialog(null, label, "Successful .. ", JOptionPane.INFORMATION_MESSAGE);
                //errmessage.mainn("acoount code already exist try for other codes", 300, 200);
            }

        } else {//"NO
            this.setAlwaysOnTop(true);
            //System.out.println("ERROEEEQD");
            pcode.requestFocus();
        }
    }//GEN-LAST:event_BsaveActionPerformed

    private void BsaveKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_BsaveKeyPressed
        int a = evt.getKeyCode();
        if (a == 10) {
            Bsave.doClick();
        }
    }//GEN-LAST:event_BsaveKeyPressed

    private void paddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_paddActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_paddActionPerformed

    private void ibalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ibalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ibalActionPerformed

    private void ibalFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_ibalFocusGained
        // TODO add your handling code here:
        ibal.selectAll();
    }//GEN-LAST:event_ibalFocusGained

    private void ibalKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ibalKeyPressed
        int b = evt.getKeyCode();
        if (b == 10) {
            Bsave.requestFocus();
        }
    }//GEN-LAST:event_ibalKeyPressed

    private void pcodeKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_pcodeKeyTyped
        char c = evt.getKeyChar();
        if (!(Character.isDigit(c) || c == 10)) {    //
            getToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_pcodeKeyTyped

    private void pmobKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_pmobKeyTyped
        char c = evt.getKeyChar();
        if (!(Character.isDigit(c) || c == 10)) {    //
            getToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_pmobKeyTyped

    private void ibalKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ibalKeyTyped
        char c = evt.getKeyChar();
        if (!(Character.isDigit(c) || (c == 10 || c == 45))) {    //
            getToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_ibalKeyTyped

    private void EnameKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_EnameKeyTyped
        char c = evt.getKeyChar();
        if ((Character.isDigit(c))) {    //|| c == KeyEvent.VK_BACKSPACE || c== KeyEvent.VK_DELETE
            getToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_EnameKeyTyped

    private void pcodeFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_pcodeFocusLost
        try {
            pcode.setText(String.format("%04d", Integer.valueOf(pcode.getText())));
        } catch (Exception e) {
            pcode.requestFocus();
        }
//System.out.println("code lost");
    }//GEN-LAST:event_pcodeFocusLost

    private void EnameFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_EnameFocusLost
        // TODO add your handling code here:
        if (Ename.getText().isEmpty()) {
            Ename.setText("No Name");
        }


    }//GEN-LAST:event_EnameFocusLost

    private void pmobFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_pmobFocusLost
        // TODO add your handling code here:
        if (pmob.getText().isEmpty()) {
            pmob.setText("1234567890");
        }

    }//GEN-LAST:event_pmobFocusLost

    private void paddFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_paddFocusLost
        // TODO add your handling code here:
        if (padd.getText().isEmpty()) {
            padd.setText("Address");
        }
        if (lang.compareToIgnoreCase("English") != 0) {
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
        }
    }//GEN-LAST:event_paddFocusLost

    private void ibalFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_ibalFocusLost
        // TODO add your handling code here:
        try {
            Float.valueOf(ibal.getText());
        } catch (Exception e) {
            ibal.setText("0.0");
        }
    }//GEN-LAST:event_ibalFocusLost

    private void dtFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_dtFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_dtFocusGained

    private void dtFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_dtFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_dtFocusLost

    private void dtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_dtActionPerformed

    private void dtKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_dtKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_dtKeyPressed

    private void dtKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_dtKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_dtKeyTyped

    private void BgoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_BgoFocusLost
        // TODO add your handling code here:
        // System.out.println("F LOst");
    }//GEN-LAST:event_BgoFocusLost

    private void HnameFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_HnameFocusGained
        // TODO add your handling code here:
        Hname.selectAll();

        try {
            Robot r = new Robot();
            r.keyPress(KeyEvent.VK_ALT);
            r.keyPress(KeyEvent.VK_SHIFT);
            r.keyPress(KeyEvent.VK_1);
            r.keyRelease(KeyEvent.VK_1);
            r.keyRelease(KeyEvent.VK_SHIFT);
            r.keyRelease(KeyEvent.VK_ALT);
        } catch (AWTException ex) {
            JLabel label = new JLabel("Language Setup Error !!");
            label.setFont(new Font("Arial", Font.BOLD, 18));
            JOptionPane.showMessageDialog(null, label, "ERROR", JOptionPane.WARNING_MESSAGE);

        }
    }//GEN-LAST:event_HnameFocusGained

    private void HnameFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_HnameFocusLost
        // TODO add your handling code here:
        if (Hname.getText().isEmpty()) {
            Hname.setText("कोई नाम नहीं");
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

    }//GEN-LAST:event_HnameFocusLost

    private void HnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_HnameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_HnameActionPerformed

    private void HnameKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_HnameKeyPressed
        // TODO add your handling code here:
        int a = evt.getKeyCode();
        if (a == 10) {
            pmob.requestFocus();
        }
    }//GEN-LAST:event_HnameKeyPressed

    private void HnameKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_HnameKeyTyped
        // TODO add your handling code here:
        char c = evt.getKeyChar();
        if ((Character.isDigit(c))) {    //|| c == KeyEvent.VK_BACKSPACE || c== KeyEvent.VK_DELETE
            getToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_HnameKeyTyped

    private void BcancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BcancelActionPerformed
        pcode.setEditable(true);
        Ename.setText("No Name");
        Hname.setText("कोई नाम नहीं");
        pmob.setText("No Number");
        padd.setText("No Address");
        ibal.setText("00.0");
        dt.setText(null);
        pcode.requestFocus();
    }//GEN-LAST:event_BcancelActionPerformed

    private void BcancelKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_BcancelKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_BcancelKeyPressed

    /**
     */
    //public static void main(String args[]) {
    public static void mainn() {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                //new NewCMRxACxEDT().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Bcancel;
    private javax.swing.JButton Bclose;
    private javax.swing.JButton Bgo;
    private javax.swing.JButton Bsave;
    private javax.swing.JTextField Ename;
    private javax.swing.JLabel Enmlbl;
    private javax.swing.JTextField Hname;
    private javax.swing.JLabel Hnmlbl;
    private javax.swing.JLabel addlbl;
    private javax.swing.JLabel ballbl;
    private javax.swing.JLabel cdlbl;
    private javax.swing.JTextField dt;
    private javax.swing.JLabel dtlbl;
    private javax.swing.JLabel hdlbl;
    private javax.swing.JLabel hdlbl2;
    private javax.swing.JTextField ibal;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel mbllbl;
    private javax.swing.JTextField padd;
    private javax.swing.JTextField pcode;
    private javax.swing.JTextField pmob;
    // End of variables declaration//GEN-END:variables

}
