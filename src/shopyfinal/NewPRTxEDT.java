
package shopyfinal;

import com.toedter.calendar.JTextFieldDateEditor;
import java.awt.AWTException;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import javax.imageio.ImageIO;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

public class NewPRTxEDT extends javax.swing.JFrame {

   
    
    String dt1,dt2;boolean repper=false;
    String itemcode,itemname,itemqty,itemrate,itemamt,iirate,iiamt,iiqty;
    String COsavedform,IOsavedform,INsavedform,CNsavedform;
    String IDyear="2020-2020",Syear="01/01/2020",Eyear="01/01/2020";
    String lang="English";
String way ;float striAMT=0 , striQTY=0;
int editt,roww;
int amtd=0;int y=0;
    
    String baseadd,logo,PRTadd,ITMadd,user;
    
    public NewPRTxEDT(String base,String golo,String idy, String sy,String ey) {
         baseadd=base;
       logo=golo;
        IDyear = idy;
        Syear = sy;
        Eyear = ey;
        
        try {
            user= GetLine.mainn(baseadd+"/Cuser.txt", 2);
        } catch (IOException ex) {
            JLabel label = new JLabel("Current user !!! Error0003");
            label.setFont(new Font("Arial", Font.BOLD, 18));
            JOptionPane.showMessageDialog(null,label,"ERROR",JOptionPane.WARNING_MESSAGE);
        
        }
        PRTadd = baseadd+"/"+user+"/"+IDyear+"/party";
        ITMadd = baseadd+"/"+user+"/"+IDyear+"/item";
        System.out.println(PRTadd+"\n"+ITMadd);
        
        initComponents();
        tklbl.setText("");
        table.setRowSelectionAllowed(true);
table.setColumnSelectionAllowed(false);
//table.setCellSelectionAllowed(false);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
    setBounds(0, 50, 1030, (int) dim.getHeight()-40);
        this.setLocationRelativeTo(null);
        try {
            this.setIconImage(ImageIO.read(new File(logo)));
        } catch (IOException ex) {
            JLabel label = new JLabel("Logo Problem !!! Error0001");
            label.setFont(new Font("Arial", Font.BOLD, 18));
            JOptionPane.showMessageDialog(null,label,"ERROR",JOptionPane.WARNING_MESSAGE);
       
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
        JLabel label = new JLabel("Language Setup Error !!");        
        label.setFont(new Font("Arial", Font.BOLD, 18));        
        JOptionPane.showMessageDialog(null,label,"ERROR",JOptionPane.WARNING_MESSAGE);
    }
        
        
        try {
        lang = GetLine.mainn(baseadd+"/"+user+"/conf.txt", 1);
        
        } catch (IOException ex) {
        JLabel label = new JLabel("Configuration Error !!! Error0003");
        label.setFont(new Font("Arial", Font.BOLD, 18));
        JOptionPane.showMessageDialog(null,label,"ERROR",JOptionPane.WARNING_MESSAGE);
        }
        JTextFieldDateEditor editor = (JTextFieldDateEditor) dater1.getDateEditor();
        editor.setEditable(false);
        editor = (JTextFieldDateEditor) dater2.getDateEditor();
        editor.setEditable(false);
        try {
            //Calender
            dater1.setMinSelectableDate(new SimpleDateFormat("dd/MM/yyyy").parse(Syear));
            dater1.setMaxSelectableDate(new SimpleDateFormat("dd/MM/yyyy").parse(Eyear));
            dater2.setMinSelectableDate(new SimpleDateFormat("dd/MM/yyyy").parse(Syear));
            dater2.setMaxSelectableDate(new SimpleDateFormat("dd/MM/yyyy").parse(Eyear));
        } catch (ParseException ex) {
            JLabel label = new JLabel("There is issue while setup calender bounds");
        label.setFont(new Font("Arial", Font.BOLD, 18));
        JOptionPane.showMessageDialog(this,label,"ERROR",JOptionPane.WARNING_MESSAGE);
        System.exit(1);
        }
        
        if(lang.compareToIgnoreCase("English")!=0){
            hdlbl.setText("ग्राहक की प्रविष्टि(Entry) का सम्पादन");
            dtflbl.setText("दिनाँक :- ");
            tolbl.setText("से :");
            tklbl.setText(" तक");
            ccdlbl.setText("कोड :");
            cnmlbl.setText("नाम :");
            modelbl.setText("मोड :");
            Bsee.setText("देखे");
            icdlbl.setText("आइटम कोड :");
            inmlbl.setText("नाम :");
            rtlbl.setText("रेट :");
            qtylbl.setText("मात्रा :");
            amtlbl.setText("रकम :");
            Breplace.setText("बदले");
            tbllbl.setText("उस आइटम को चयनित करे जिससे संसोधित करना है|");
            Bclose.setText("बंद करे");
            Bcomplete.setText("सम्पन");
            
            
        }
Date datee = new Date();
dater1.setDate(datee);
dater2.setDate(datee);
        
    }
       
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        dtflbl = new javax.swing.JLabel();
        tolbl = new javax.swing.JLabel();
        dater1 = new com.toedter.calendar.JDateChooser();
        dater2 = new com.toedter.calendar.JDateChooser();
        ccdlbl = new javax.swing.JLabel();
        ccode = new javax.swing.JTextField();
        cnmlbl = new javax.swing.JLabel();
        cname = new javax.swing.JTextField();
        Bsee = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        icdlbl = new javax.swing.JLabel();
        icode = new javax.swing.JTextField();
        inmlbl = new javax.swing.JLabel();
        iname = new javax.swing.JTextField();
        rtlbl = new javax.swing.JLabel();
        irate = new javax.swing.JTextField();
        qtylbl = new javax.swing.JLabel();
        iqty = new javax.swing.JTextField();
        iamt = new javax.swing.JTextField();
        amtlbl = new javax.swing.JLabel();
        Breplace = new javax.swing.JButton();
        Bcomplete = new javax.swing.JButton();
        Bclose = new javax.swing.JButton();
        Lextra = new javax.swing.JLabel();
        tbllbl = new javax.swing.JLabel();
        Pmode = new javax.swing.JComboBox();
        modelbl = new javax.swing.JLabel();
        hdlbl = new javax.swing.JLabel();
        tklbl = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Edit Supplier's Transaction");

        dtflbl.setFont(new java.awt.Font("Monospaced", 1, 18)); // NOI18N
        dtflbl.setText("Date :- From :");

        tolbl.setFont(new java.awt.Font("Monospaced", 1, 18)); // NOI18N
        tolbl.setText("To :");

        dater1.setDateFormatString("dd/MM/yyyy");
        dater1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N

        dater2.setDateFormatString("dd/MM/yyyy");
        dater2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N

        ccdlbl.setFont(new java.awt.Font("Monospaced", 1, 14)); // NOI18N
        ccdlbl.setText("Code :");

        ccode.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        ccode.setText("0001");
        ccode.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                ccodeFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                ccodeFocusLost(evt);
            }
        });
        ccode.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                ccodeKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                ccodeKeyTyped(evt);
            }
        });

        cnmlbl.setFont(new java.awt.Font("Monospaced", 1, 14)); // NOI18N
        cnmlbl.setText("Name :");
        cnmlbl.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        cname.setEditable(false);
        cname.setFont(new java.awt.Font("Monospaced", 1, 24)); // NOI18N
        cname.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                cnameFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                cnameFocusLost(evt);
            }
        });

        Bsee.setFont(new java.awt.Font("Monospaced", 1, 24)); // NOI18N
        Bsee.setForeground(new java.awt.Color(0, 240, 0));
        Bsee.setText("See");
        Bsee.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BseeActionPerformed(evt);
            }
        });
        Bsee.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                BseeKeyPressed(evt);
            }
        });

        table.setFont(new java.awt.Font("Monospaced", 1, 14)); // NOI18N
        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Serial No.", "Date", "Given/Taken", "Code", "Item Name", "Qty", "Rate", "Amt"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        table.getTableHeader().setReorderingAllowed(false);
        table.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                tableFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                tableFocusLost(evt);
            }
        });
        table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tableMousePressed(evt);
            }
        });
        table.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tableKeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(table);
        if (table.getColumnModel().getColumnCount() > 0) {
            table.getColumnModel().getColumn(0).setResizable(false);
            table.getColumnModel().getColumn(0).setPreferredWidth(50);
        }

        icdlbl.setFont(new java.awt.Font("Monospaced", 1, 14)); // NOI18N
        icdlbl.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        icdlbl.setText("Item Code :");

        icode.setEditable(false);
        icode.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        icode.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        icode.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                icodeFocusGained(evt);
            }
        });
        icode.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                icodeKeyPressed(evt);
            }
        });

        inmlbl.setFont(new java.awt.Font("Monospaced", 1, 14)); // NOI18N
        inmlbl.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        inmlbl.setText("Name :");

        iname.setFont(new java.awt.Font("Monospaced", 1, 24)); // NOI18N
        iname.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                inameFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                inameFocusLost(evt);
            }
        });
        iname.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                inameKeyPressed(evt);
            }
        });

        rtlbl.setFont(new java.awt.Font("Monospaced", 1, 14)); // NOI18N
        rtlbl.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        rtlbl.setText("Rate :");

        irate.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        irate.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                irateFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                irateFocusLost(evt);
            }
        });
        irate.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                irateKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                irateKeyTyped(evt);
            }
        });

        qtylbl.setFont(new java.awt.Font("Monospaced", 1, 14)); // NOI18N
        qtylbl.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        qtylbl.setText("Qty :");

        iqty.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        iqty.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                iqtyFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                iqtyFocusLost(evt);
            }
        });
        iqty.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                iqtyActionPerformed(evt);
            }
        });
        iqty.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                iqtyKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                iqtyKeyTyped(evt);
            }
        });

        iamt.setEditable(false);
        iamt.setBackground(new java.awt.Color(240, 0, 0));
        iamt.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        iamt.setForeground(new java.awt.Color(0, 0, 240));
        iamt.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        iamt.setToolTipText("");

        amtlbl.setFont(new java.awt.Font("Monospaced", 1, 14)); // NOI18N
        amtlbl.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        amtlbl.setText("Amt :");

        Breplace.setFont(new java.awt.Font("Monospaced", 1, 24)); // NOI18N
        Breplace.setText("Replace");
        Breplace.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BreplaceActionPerformed(evt);
            }
        });
        Breplace.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                BreplaceKeyPressed(evt);
            }
        });

        Bcomplete.setFont(new java.awt.Font("Monospaced", 1, 18)); // NOI18N
        Bcomplete.setText("Complete");
        Bcomplete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BcompleteActionPerformed(evt);
            }
        });

        Bclose.setFont(new java.awt.Font("Monospaced", 1, 18)); // NOI18N
        Bclose.setText("Close");
        Bclose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BcloseActionPerformed(evt);
            }
        });

        Lextra.setText("            ");

        tbllbl.setFont(new java.awt.Font("Monospaced", 1, 13)); // NOI18N
        tbllbl.setText("Select out of these which you want to edit or delete");

        Pmode.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        Pmode.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Pending", "By Cash" }));

        modelbl.setFont(new java.awt.Font("Monospaced", 1, 18)); // NOI18N
        modelbl.setText("Mode :");

        hdlbl.setBackground(new java.awt.Color(240, 0, 240));
        hdlbl.setFont(new java.awt.Font("Monospaced", 2, 18)); // NOI18N
        hdlbl.setForeground(new java.awt.Color(0, 240, 0));
        hdlbl.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        hdlbl.setText("-:: Editing Supplier's Entry ::-");

        tklbl.setFont(new java.awt.Font("Monospaced", 1, 18)); // NOI18N
        tklbl.setText("To :");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(53, 53, 53)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(ccdlbl)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(ccode, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(cnmlbl, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(modelbl))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(Pmode, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(Bsee, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(cname, javax.swing.GroupLayout.PREFERRED_SIZE, 561, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(117, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(dtflbl)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(dater1, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(tolbl)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(dater2, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(tklbl))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(icdlbl)
                                        .addGap(19, 19, 19))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(rtlbl)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(icode, javax.swing.GroupLayout.DEFAULT_SIZE, 126, Short.MAX_VALUE)
                                    .addComponent(irate))
                                .addGap(115, 115, 115)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(inmlbl)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(3, 3, 3)
                                        .addComponent(qtylbl)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(iname)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(iqty, javax.swing.GroupLayout.DEFAULT_SIZE, 123, Short.MAX_VALUE)
                                        .addGap(37, 37, 37)
                                        .addComponent(amtlbl)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(iamt, javax.swing.GroupLayout.DEFAULT_SIZE, 102, Short.MAX_VALUE)))))
                        .addGap(65, 65, 65)
                        .addComponent(Breplace, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(43, 43, 43))))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(Lextra, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(tbllbl)))
                .addGap(118, 118, 118))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(Bclose, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Bcomplete, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41))
            .addComponent(hdlbl, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(hdlbl)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tolbl)
                    .addComponent(dater2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dater1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dtflbl)
                    .addComponent(tklbl))
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ccdlbl)
                    .addComponent(ccode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cnmlbl)
                    .addComponent(cname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(modelbl)
                    .addComponent(Pmode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Bsee, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(icdlbl)
                    .addComponent(icode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(inmlbl)
                    .addComponent(iname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(rtlbl, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(irate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(qtylbl)
                        .addComponent(iqty, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(amtlbl)
                        .addComponent(iamt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(Breplace, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(15, 15, 15)
                .addComponent(tbllbl)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 548, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Lextra)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Bcomplete)
                    .addComponent(Bclose))
                .addGap(20, 20, 20))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ccodeFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_ccodeFocusGained
ccode.selectAll();
    }//GEN-LAST:event_ccodeFocusGained

    public void rep(){
        
        
        repper=false;
                String STRaddT;
        String STRaddG;
        String mode=Pmode.getSelectedItem().toString();
        if(mode.equals("Pending")){
          STRaddT="/Pending/Taken";
          STRaddG="/Pending/Given";
        }
        else
        {
            STRaddT="/Cash/Taken";
          STRaddG="/Cash/Given";
            
        }
        
        String vtd = COsavedform.substring(0,10);        //(way);
        float tot = Float.valueOf(iamt.getText());
        //iamt.setText(String.valueOf(tot));
        
        
        if(way.equals("Taken")){
             CNsavedform = COsavedform.substring(0, 10)+","+icode.getText()+","+iname.getText()+","+iqty.getText()+","+irate.getText()+","+iamt.getText();
             INsavedform = COsavedform.substring(0, 10)+","+ccode.getText()+","+iqty.getText()+","+irate.getText()+","+iamt.getText()+","+mode+",Party";
              
             if(repeatation.mainn(PRTadd +"/" + ccode.getText()+ STRaddT+"/", NamingDateName.mainn(vtd)+".txt", COsavedform)==1&&repeatation.mainn(ITMadd+"/"+icode.getText()+"/Status", NamingDateName.mainn(vtd)+".txt",IOsavedform)==1){
             try {
            ReplaceLineEx.mainn(PRTadd +"/" + ccode.getText()+ STRaddT+"/", NamingDateName.mainn(vtd)+".txt", COsavedform,CNsavedform,1);
            Scanner in;
                            in = new Scanner(new File(PRTadd +"/" + ccode.getText()+ STRaddT+"/"+ NamingDateName.mainn(vtd)+".txt"),"UTF-8");
                            String pd = in.nextLine();
                            Float nd = Float.valueOf(pd)-striAMT+tot;
                            ReplaceLineWN.mainn(PRTadd+"/"+ccode.getText()+STRaddT, NamingDateName.mainn(vtd)+".txt", 1, String.valueOf(nd));
                            in.close();
                            String dsd =NamingDate.mainn(vtd);
                            
                            File tmp;
                            boolean bg;
                            for(dsd = datep15.mainn(dsd);DateInBetween.mainn(dsd, dsd, Eyear);dsd=datep15.mainn(dsd)){                               //Updating all file created or having date of early created
                                tmp = new File(PRTadd +"/" + ccode.getText()+ STRaddG+"/"+ NamingDateName.mainn(dsd)+".txt");
                                bg =tmp.exists();
                                if(bg){
                                 //  TextIO.putln(ITMadd+"/"+icode.getText()+"/Status/"+NamingDateName.mainn(dsd)+".txt");
                                 in = new Scanner(tmp,"UTF-8");
                            String pp = in.nextLine();
                            float balnc = Float.valueOf(pp) +striAMT-tot;
                            ReplaceLineWN.mainn(PRTadd +"/" + ccode.getText()+ STRaddG, NamingDateName.mainn(dsd)+".txt",1 , String.valueOf(balnc));
                            in.close();
                                }
                            }
                            
            ReplaceLineEx.mainn(ITMadd+"/"+icode.getText()+"/Status", NamingDateName.mainn(vtd)+".txt",IOsavedform, INsavedform,2);
            in = new Scanner(new File(ITMadd+"/"+icode.getText()+"/Status/"+NamingDateName.mainn(vtd)+".txt"),"UTF-8");
                            in.nextLine();
                            String p = in.nextLine();
                            float stck = Float.valueOf(p) - striQTY+Float.valueOf(iqty.getText());
                           // TextIO.putln("p:;"+p+"stck:"+stck);
                            ReplaceLineWN.mainn(ITMadd+"/"+icode.getText()+"/Status", NamingDateName.mainn(vtd)+".txt", 2, String.valueOf(stck));
                            in.close();
                            
                             
                            dsd =NamingDate.mainn(vtd);
                            for(dsd = datep15.mainn(dsd);DateInBetween.mainn(dsd, dsd, Eyear);dsd=datep15.mainn(dsd)){                               //Updating all file created or having date of early created
                                tmp = new File(ITMadd+"/"+icode.getText()+"/Status/"+NamingDateName.mainn(dsd)+".txt");
                                bg =tmp.exists();
                                if(bg){
                                 //  TextIO.putln(ITMadd+"/"+icode.getText()+"/Status/"+NamingDateName.mainn(dsd)+".txt");
                                 in = new Scanner(tmp,"UTF-8");
                            p = in.nextLine();
                            stck = Float.valueOf(p) - striQTY+Float.valueOf(iqty.getText());
                            ReplaceLineWN.mainn(ITMadd+"/"+icode.getText()+"/Status", NamingDateName.mainn(dsd)+".txt",1 ,String.valueOf(stck));
                            in.close();
                                }
                            }
                            
            table.setValueAt(icode.getText(), editt, 3);
            table.setValueAt(iname.getText(),editt,4);
            table.setValueAt(iqty.getText(),editt,5);
            table.setValueAt(irate.getText(),editt,6);
            table.setValueAt(iamt.getText(),editt,7);
            icode.setText("");
            iname.setText("");
            irate.setText("");
            iqty.setText("");
            iamt.setText("0.0");
            table.clearSelection();
        } catch (IOException ex) {
          JLabel label = new JLabel("Party data storing date. not found or opens !!! Error0011");
            label.setFont(new Font("Arial", Font.BOLD, 20));
            JOptionPane.showMessageDialog(null,label,"ERROR",JOptionPane.WARNING_MESSAGE);  
        }
        }else{//Not found repeatation
                JLabel label = new JLabel("Editing of this Entry Not Possible");
            label.setFont(new Font("Arial", Font.BOLD, 20));
            JOptionPane.showMessageDialog(null,label,"ERROR",JOptionPane.WARNING_MESSAGE); 
                }
        }
        else{           //Given
             CNsavedform = COsavedform.substring(0, 10)+","+icode.getText()+","+iname.getText()+","+iqty.getText()+","+irate.getText()+","+iamt.getText();
             INsavedform = COsavedform.substring(0, 10)+","+ccode.getText()+",-"+iqty.getText()+","+irate.getText()+","+iamt.getText()+","+mode+",Party";
             /* try {
             CNsavedform = new String(CNsavedform.getBytes(),"UTF-8");
             INsavedform = new String(INsavedform.getBytes(),"UTF-8");
             } catch (UnsupportedEncodingException ex) {
             Logger.getLogger(NewPRTxEDT.class.getName()).log(Level.SEVERE, null, ex);
             }*/
             
        if(repeatation.mainn(PRTadd +"/" + ccode.getText()+ STRaddG+"/", NamingDateName.mainn(vtd)+".txt", COsavedform)==1&&repeatation.mainn(ITMadd+"/"+icode.getText()+"/Status", NamingDateName.mainn(vtd)+".txt",IOsavedform)==1){
         try {
                Scanner in;
               //if(repeatationWOcase.mainn(PRTadd +"/" + ccode.getText()+ STRaddG,  NamingDateName.mainn(vtd)+".txt", COsavedform)==0&&repeatationWOcase.mainn(ITMadd+"/"+icode.getText()+"/Status", NamingDateName.mainn(vtd)+".txt", IOsavedform)==0)
                 //  System.out.println("You Can ..");
                ReplaceLineEx.mainn(PRTadd +"/" + ccode.getText()+ STRaddG+"/", NamingDateName.mainn(vtd)+".txt", COsavedform,CNsavedform,2);//NamingDateName.mainn(vtd)
                in = new Scanner(new File(PRTadd +"/" + ccode.getText()+ STRaddG+"/"+ NamingDateName.mainn(vtd)+".txt"),"UTF-8");
                            in.nextLine();
                            String pd = in.nextLine();
                            Float nd = Float.valueOf(pd)-striAMT+tot;
                            System.out.println("Updating Total");
                            ReplaceLineWN.mainn(PRTadd+"/"+ccode.getText()+STRaddG, NamingDateName.mainn(vtd)+".txt", 2, String.valueOf(nd));//NamingDateName.mainn(vtd)
                            in.close();
                            String dsd =NamingDate.mainn(vtd);
                            
                            File tmp;
                            boolean bg;
                            for(dsd = datep15.mainn(dsd);DateInBetween.mainn(dsd, dsd, Eyear);dsd=datep15.mainn(dsd)){                               //Updating all file created or having date of early created
                                tmp = new File(PRTadd +"/" + ccode.getText()+ STRaddG+"/"+ NamingDateName.mainn(dsd)+".txt");
                                bg =tmp.exists();
                                if(bg){
                                 //  TextIO.putln(ITMadd+"/"+icode.getText()+"/Status/"+NamingDateName.mainn(dsd)+".txt");
                                 in = new Scanner(tmp,"UTF-8");
                            String pp = in.nextLine();
                            float balnc = Float.valueOf(pp) -striAMT+tot;
                            ReplaceLineWN.mainn(PRTadd +"/" + ccode.getText()+ STRaddG, NamingDateName.mainn(dsd)+".txt",1 , String.valueOf(balnc));
                            in.close();
                                }
                            }
                            
            ReplaceLineEx.mainn(ITMadd+"/"+icode.getText()+"/Status", NamingDateName.mainn(vtd)+".txt",IOsavedform, INsavedform,2);
            
            in = new Scanner(new File(ITMadd+"/"+icode.getText()+"/Status/"+NamingDateName.mainn(vtd)+".txt"),"UTF-8");
                            in.nextLine();
                            String p = in.nextLine();
                            float stck = Float.valueOf(p) + striQTY-Float.valueOf(iqty.getText());
                            //System.out.println("p::"+p+"\nstriQTY::"+striQTY+"\niqty.getText()::"+iqty.getText()+"stck::"+stck);
                            ReplaceLineWN.mainn(ITMadd+"/"+icode.getText()+"/Status", NamingDateName.mainn(vtd)+".txt", 2, String.valueOf(stck));
                            in.close();
                            
                            
                            dsd =NamingDate.mainn(vtd);
                            for(dsd = datep15.mainn(dsd);DateInBetween.mainn(dsd, dsd, Eyear);dsd=datep15.mainn(dsd)){                               //Updating all file created or having date of early created
                                tmp = new File(ITMadd+"/"+icode.getText()+"/Status/"+NamingDateName.mainn(dsd)+".txt");
                                bg =tmp.exists();
                                if(bg){
                                 in = new Scanner(tmp,"UTF-8");
                            p = in.nextLine();
                            stck = Float.valueOf(p) - striQTY+Float.valueOf(iqty.getText());
                            ReplaceLineWN.mainn(ITMadd+"/"+icode.getText()+"/Status", NamingDateName.mainn(dsd)+".txt",1 ,String.valueOf(stck));
                            in.close();
                                }
                            }
                        
            table.setValueAt(icode.getText(), editt, 3);
            table.setValueAt(iname.getText(),editt,4);
            table.setValueAt(iqty.getText(),editt,5);
            table.setValueAt(irate.getText(),editt,6);
            table.setValueAt(iamt.getText(),editt,7);
            icode.setText("");
            iname.setText("");
            irate.setText("");
            iqty.setText("");
            iamt.setText("0.0");
            table.clearSelection();
        } catch (IOException ex) {
            JLabel label = new JLabel("Party data storing date. not found or opens !!! Error0011");
            label.setFont(new Font("Arial", Font.BOLD, 20));
            JOptionPane.showMessageDialog(null,label,"ERROR",JOptionPane.WARNING_MESSAGE);  
        }
        }else{
         JLabel label = new JLabel("This cannot edited");
            label.setFont(new Font("Arial", Font.BOLD, 20));
            JOptionPane.showMessageDialog(null,label,"ERROR",JOptionPane.WARNING_MESSAGE);       
        }
        }
    }
//###################################################################################################################################    
    public void PRTxName(){
        if(repeatation.mainn(PRTadd, "party.txt", ccode.getText())==1){          //Party's account exists or not  ####111
        File tmp = new File(PRTadd+"/"+ccode.getText()+"/profile.txt");
        boolean ex = tmp.exists();
        if(ex){                                                                 //Check for name of party
            Scanner read;
                    try {
                        read = new Scanner(new File(PRTadd + "/" + ccode.getText() + "/profile.txt"),"UTF-8");
                        read.nextLine();
                        cname.setText(read.nextLine());
                        read.close();
                    } catch (FileNotFoundException ex1) {
                        JLabel label = new JLabel("Party profile.not found !!! Error0017");
                        label.setFont(new Font("Arial", Font.BOLD, 20));
                        JOptionPane.showMessageDialog(null,label,"ERROR",JOptionPane.WARNING_MESSAGE); 
                    }
        }
        else{
            cname.setText("no name");
        }
        Bsee.requestFocus();
    }
    else{
        ccode.requestFocus();
        JLabel label = new JLabel("There is no party with this code  !!");
            label.setFont(new Font("Arial", Font.BOLD, 20));
            JOptionPane.showMessageDialog(null,label,"ERROR",JOptionPane.WARNING_MESSAGE);  
        
    }          
    }
    
    private void ccodeKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ccodeKeyPressed
int a = evt.getKeyCode();
        if (a == 10) {                     // for enter key
             try {
                         ccode.setText(String.format("%04d", Integer.valueOf(ccode.getText())));
            PRTxName();
             //icode.requestFocus();
        } catch (Exception e) {
            ccode.requestFocus();
            
        }
         
        }
    }//GEN-LAST:event_ccodeKeyPressed
//######################################################################################################################################3
    public void see(){
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
dt1 = dateFormat.format(dater1.getDate());
dt2 = dateFormat.format(dater2.getDate());
ccode.requestFocus();

       DefaultTableModel dm = (DefaultTableModel)table.getModel();             // To clear the table
        dm.getDataVector().removeAllElements();
        dm.fireTableDataChanged(); 
        
        String STRaddT;
        String STRaddG;
        String mode=Pmode.getSelectedItem().toString();
        if(mode.equals("Pending")){
          STRaddT="/Pending/Taken";
          STRaddG="/Pending/Given";
        }
        else
        {
            STRaddT="/Cash/Taken";
          STRaddG="/Cash/Given";
            
        }
        
        if(repeatation.mainn(PRTadd, "party.txt", ccode.getText())==1){          //Party's account exists or not  ####111
        File tmp = new File(PRTadd+"/"+ccode.getText()+"/profile.txt");
        boolean ex = tmp.exists();
        if(ex){                                                                 //Check for name of party
            Scanner read;
                    try {
                        read = new Scanner(new File(PRTadd + "/" + ccode.getText() + "/profile.txt"),"UTF-8");
                        read.nextLine();
                        if(lang.compareToIgnoreCase("English")!=0)
                            read.nextLine();
                        cname.setText(read.nextLine());
                        read.close();
                    } catch (FileNotFoundException ex1) {
                        JLabel label = new JLabel("Party profile.not found !!! Error0017");
                        label.setFont(new Font("Arial", Font.BOLD, 20));
                        JOptionPane.showMessageDialog(null,label,"ERROR",JOptionPane.WARNING_MESSAGE); 
                    }
        }
        else{
            cname.setText("no name");
        }
    }
    else{
        ccode.requestFocus();
        JLabel label = new JLabel("there is no party with this code");
                        label.setFont(new Font("Arial", Font.BOLD, 20));
                        JOptionPane.showMessageDialog(null,label,"ERROR",JOptionPane.WARNING_MESSAGE); 
       
    }                                                           //########11111111


        // Taking data of this date interval
        //check in Den
        String ndt = NamingDate.mainn(dt1);
        while(DateInBetween.mainn(NamingDate.mainn(dt1), ndt,NamingDate.mainn(dt2) )){

        Scanner read;
        DefaultTableModel model = (DefaultTableModel)table.getModel();
        String td;
        File tmp = new File(PRTadd+"/"+ccode.getText()+STRaddG+"/"+NamingDateName.mainn(ndt)+".txt");
        boolean ex = tmp.exists();
        if(ex){
            //System.out.println(PRTadd+"/"+ccode.getText()+STRaddG+"/"+NamingDateName.mainn(ndt)+".txt");
                try {
                    read = new Scanner(new File(PRTadd + "/" + ccode.getText() + STRaddG+"/" + NamingDateName.mainn(ndt) + ".txt"),"UTF-8");
                    read.useDelimiter(",|\\n");
                    read.nextLine();
                    read.nextLine();
                    while(read.hasNext()){
                    td = read.next();
                    if(DateInBetween.mainn(dt1, td, dt2)){
                    itemcode=read.next();
                    itemname = read.next();
                    itemqty=read.next();
                    itemrate=read.next();
                    itemamt=read.next();
                    if(itemamt.length()>1){
                        char ch = itemamt.charAt(itemamt.length()-1);
                    //System.out.println("char :"+ch);
                    if(ch!='0')
                    itemamt=itemamt.substring(0, itemamt.length()-1);
                    
                    model.addRow(new Object[]{table.getRowCount()+1,td,"Given",itemcode,itemname,itemqty,itemrate,itemamt});
                    }
                    }
                    else
                        read.nextLine();

                    }

                } catch (FileNotFoundException ex1) {
                    JLabel label = new JLabel("Party data storing date. not found or opens !!! Error0011");
            label.setFont(new Font("Arial", Font.BOLD, 20));
            JOptionPane.showMessageDialog(null,label,"ERROR",JOptionPane.WARNING_MESSAGE);  
                }
        }

        //ndt = NamingDate.mainn(dt1);
        tmp = new File(PRTadd+"/"+ccode.getText()+STRaddT+"/"+NamingDateName.mainn(ndt)+".txt");
        ex = tmp.exists();
        if(ex){
                try {
                    read = new Scanner(new File(PRTadd + "/" + ccode.getText() + STRaddT+"/" + NamingDateName.mainn(ndt) + ".txt"),"UTF-8");
                    read.useDelimiter(",|\\n");
                    read.nextLine();
                    while(read.hasNext()){
                    td = read.next();
                    if(DateInBetween.mainn(dt1, td, dt2)){
                    itemcode=read.next();
                    itemname = read.next();
                    itemqty=read.next();
                    itemrate=read.next();
                    itemamt=read.next();
                    if(itemamt.length()>1){
                    char ch = itemamt.charAt(itemamt.length()-1);
                    //System.out.println("char :"+ch);
                    if(ch!='0')
                    itemamt=itemamt.substring(0, itemamt.length()-1);
                    //System.out.println(":::"+itemamt+":::");
                    model.addRow(new Object[]{table.getRowCount()+1,td,"Taken",itemcode,itemname,itemqty,itemrate,itemamt});
                    }
                    }
                    else
                        read.nextLine();

                    }

                } catch (FileNotFoundException ex1) {
                    JLabel label = new JLabel("Party data storing date. not found or opens !!! Error0011");
            label.setFont(new Font("Arial", Font.BOLD, 20));
            JOptionPane.showMessageDialog(null,label,"ERROR",JOptionPane.WARNING_MESSAGE);  
                }
        }


            ndt = datep15.mainn(ndt);                                       // Updation in date interval
            //TextIO.putln(ndt+"  "+DateInBetween.mainn(NamingDate.mainn(dt1), ndt,NamingDate.mainn(dt2) ));
        }


Bcomplete.requestFocus();

    }
    
//######################################################################################################################################3
    
    private void BseeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BseeActionPerformed

        see();

}//GEN-LAST:event_BseeActionPerformed

    private void tableMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableMousePressed

    }//GEN-LAST:event_tableMousePressed

    private void tableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableMouseClicked

                          // Edition of Table Data
        
       
           
    }//GEN-LAST:event_tableMouseClicked

    private void tableKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tableKeyPressed
        // TODO add your handling code here:
        //System.out.println("KEy id pressed successoeugidhsjkhdbs ");
        String mode=Pmode.getSelectedItem().toString();                                                           //Already entered Editing or Deleting a Row
         
        final DefaultTableModel model = (DefaultTableModel)table.getModel();
        table.getSelectionModel().setSelectionInterval(table.getSelectedRow(), table.getSelectedRow());
        
        final TableModel tm = table.getModel();
                int b = evt.getKeyCode();
                if(table.getSelectedRow()>=0){
            if(b==69){      //For Edit  "e"
            editt = table.getSelectedRow();
         Object o ;
        o = tm.getValueAt(editt, 1);
        final String vtd = (String)o;
        o = tm.getValueAt(editt, 2);
        way = (String)o;
        o = tm.getValueAt(editt, 3);
        icode.setText((String)o);
        String stricode = (String)o;
        o = tm.getValueAt(editt, 4);
        iname.setText((String)o);
        String striname = (String)o;
        o = tm.getValueAt(editt, 5);
        //int intqty = (Integer)o;//Integer.parseInt(qty);
        iqty.setText((String)o);
        String striqty = (String)o;
        o = tm.getValueAt(editt, 6);
        irate.setText((String)o);
        String strirate = (String)o;
        o = tm.getValueAt(editt, 7);
        iamt.setText((String)o);
        String striamt = (String)o;
        COsavedform = vtd + "," + stricode + "," + striname+ "," + striqty + "," + strirate + "," + striamt;
        if(way.equals("Given")){
                IOsavedform = vtd+","+ccode.getText()+",-"+iqty.getText() + "," + irate.getText() + "," + iamt.getText()+","+mode+",Party";
                
        }
        else{
            
            IOsavedform = vtd+","+ccode.getText()+","+iqty.getText() + "," + irate.getText() + "," + iamt.getText()+","+mode+",Party";
        }
        //System.out.println(IOsavedform);
        striAMT = Float.valueOf(striamt);
                striQTY = Float.valueOf(striqty);
                repper=true;
            iname.requestFocus();
        
            
         }
    
    //#############################################################################################
            else{   
        if(b==68)           // For deleting that row "d'
        {       boolean det=false;
            int yon = JOptionPane.showConfirmDialog(null,"Do you want to Continue ??","Confirmation .......",JOptionPane.OK_OPTION);
        if(yon==0){//YES 
         editt = table.getSelectedRow();  
         int trr = table.getRowCount();   
          
         
         if(editt>=0){
            //TextIO.putln("Inside >0");
            roww = table.getSelectedRow();
            Object o;
        o = tm.getValueAt(roww, 1);
        final String vtd = (String)o;
        o = tm.getValueAt(roww, 2);
               way = (String)o;
        o = tm.getValueAt(roww, 3);
        String stricode = (String)o;
        o = tm.getValueAt(roww, 4);
        String striname = (String)o;
        o = tm.getValueAt(roww, 5);
        String striqty = (String)o;
        o = tm.getValueAt(roww, 6);
        String strirate = (String)o;
        o = tm.getValueAt(roww, 7);
        String striamt = (String)o;
            
                String Csavedform = vtd + "," + stricode + "," + striname+ "," + striqty + "," + strirate + "," + striamt;
                //System.out.println("Csaved:"+Csavedform);
                       if(way.equals("Given")){
                           try {
                               String STRaddT;
                                String STRaddG;
                                mode=Pmode.getSelectedItem().toString();
                                if(mode.equals("Pending")){
                                STRaddT="/Pending/Taken";
                                STRaddG="/Pending/Given";
                                }
                                else
                                {
                                STRaddT="/Cash/Taken";
                                STRaddG="/Cash/Given";
            
                                }
                               Scanner in;
//###############################################################################################################################################################3                              
                               //NamingDateName.mainn(vtd)
                               //System.out.println("NamingDateName.mainn(vtd): "+NamingDateName.mainn(vtd));
                               //System.out.println(PRTadd +"/" + ccode.getText()+ STRaddG+"/"+NamingDateName.mainn(vtd)+".txt\n"+Csavedform);
                               String st1=vtd + "," + ccode.getText() + ",-" + striqty + "," + strirate + "," + striamt;
                               String st2=","+mode+",Party";
                               String Isavedform=st1+st2;
                               if(repeatation.mainn(PRTadd +"/" + ccode.getText()+ STRaddG, NamingDateName.mainn(vtd)+".txt",Csavedform)==1&&repeatation.mainn(ITMadd+"/"+stricode+"/Status",NamingDateName.mainn(vtd)+".txt",Isavedform)==1){
                           det=true;
                                   RemoveLineEx.mainn(PRTadd +"/" + ccode.getText()+ STRaddG, NamingDateName.mainn(vtd)+".txt", Csavedform,2);
                            in = new Scanner(new File(PRTadd +"/" + ccode.getText()+ STRaddG+"/"+ NamingDateName.mainn(vtd)+".txt"),"UTF-8");
                            in.nextLine();
                            String pd = in.nextLine();
                            Float nd = Float.valueOf(pd)-Float.valueOf(striamt);
                            ReplaceLineWN.mainn(PRTadd+"/"+ccode.getText()+STRaddG, NamingDateName.mainn(vtd)+".txt", 2, String.valueOf(nd));//NamingDateName.mainn(vtd)
                            in.close();
                            
                            File tmp;
                            boolean bg;
                            String dsd =NamingDate.mainn(vtd);
                            for(dsd = datep15.mainn(dsd);DateInBetween.mainn(dsd, dsd, Eyear);dsd = datep15.mainn(dsd)){
                               tmp =  new File(PRTadd +"/" + ccode.getText()+ STRaddG+"/"+ NamingDateName.mainn(dsd)+".txt");
                               bg =tmp.exists();
                               if(bg){
                                in = new Scanner(new File(PRTadd +"/" + ccode.getText()+ STRaddG+"/"+ NamingDateName.mainn(dsd)+".txt"),"UTF-8");   
                                pd = in.nextLine();
                                nd = Float.valueOf(pd)-Float.valueOf(striamt);
                                ReplaceLineWN.mainn(PRTadd+"/"+ccode.getText()+STRaddG, NamingDateName.mainn(dsd)+".txt", 1, String.valueOf(nd));
                                in.close();
                               }
                            }
                            
//###################################################################################################################################################################
                            
                RemoveLineEx.mainn(ITMadd+"/"+stricode+"/Status",NamingDateName.mainn(vtd)+".txt",Isavedform,2);                      // Update current file of status
                            
                            tmp = new File(ITMadd+"/"+stricode+"/Status/"+NamingDateName.mainn(vtd)+".txt");
                                bg =tmp.exists();
                                if(bg){
                                    in = new Scanner(tmp,"UTF-8");
                                    in.nextLine();
                            String p = in.nextLine();
                            float stck = Float.valueOf(p) + Float.valueOf(striqty);
                            ReplaceLineWN.mainn(ITMadd+"/"+stricode+"/Status", NamingDateName.mainn(vtd)+".txt", 2, String.valueOf(stck));
                            in.close();
                                }
                            
                            
                            dsd =NamingDate.mainn(vtd);
                            for(dsd = datep15.mainn(dsd);DateInBetween.mainn(dsd, dsd, Eyear);dsd=datep15.mainn(dsd)){                               //Updating all file created or having date of early created
                                tmp = new File(ITMadd+"/"+stricode+"/Status/"+NamingDateName.mainn(dsd)+".txt");
                                bg =tmp.exists();
                                if(bg){
                                  // TextIO.putln(ITMadd+"/"+icode.getText()+"/Status/"+NamingDateName.mainn(dsd)+".txt");
                                 in = new Scanner(tmp,"UTF-8");
                            String p = in.nextLine();
                            float stck = Float.valueOf(p) + Float.valueOf(striqty);
                            ReplaceLineWN.mainn(ITMadd+"/"+stricode+"/Status", NamingDateName.mainn(dsd)+".txt",1 , String.valueOf(stck));
                            in.close();
                                }
                            }
                           }else{
                                   JLabel label = new JLabel("This cannot be deleted !!");
            label.setFont(new Font("Arial", Font.BOLD, 20));
            JOptionPane.showMessageDialog(null,label,"ERROR",JOptionPane.WARNING_MESSAGE);  
                                   }
//###############################################################################################################################################################3                                                          
                            
                        } catch (FileNotFoundException ex) {
                            JLabel label = new JLabel("Party data storing date. not found or opens !!! Error0011");
            label.setFont(new Font("Arial", Font.BOLD, 20));
            JOptionPane.showMessageDialog(null,label,"ERROR",JOptionPane.WARNING_MESSAGE);  
                            
                        } catch (IOException ex) {
                            JLabel label = new JLabel("Party data storing date. not found or opens.. some how !!! Error0011");
            label.setFont(new Font("Arial", Font.BOLD, 20));
            JOptionPane.showMessageDialog(null,label,"ERROR",JOptionPane.WARNING_MESSAGE);
                        }
                       }
                       else{// Way "Taken"
                           try {
                               String STRaddT;
                                String STRaddG;
                                mode=Pmode.getSelectedItem().toString();
                                if(mode.equals("Pending")){
                                  STRaddT="/Pending/Taken";
                                  STRaddG="/Pending/Given";
                                }
                                else
                                {
                                    STRaddT="/Cash/Taken";
                                  STRaddG="/Cash/Given";

                                }
//###################################################################################################################################################################
                                if(repeatation.mainn(PRTadd +"/" + ccode.getText()+ STRaddT, NamingDateName.mainn(vtd)+".txt", Csavedform)==1){
                            det=true;
                                    RemoveLineEx.mainn(PRTadd +"/" + ccode.getText()+ STRaddT, NamingDateName.mainn(vtd)+".txt", Csavedform,1);
                            Scanner in;
                            in = new Scanner(new File(PRTadd +"/" + ccode.getText()+ STRaddT+"/"+ NamingDateName.mainn(vtd)+".txt"),"UTF-8");
                            String pd = in.nextLine();
                            Float nd = Float.valueOf(pd)-Float.valueOf(striamt);
                            in.close();
                            ReplaceLineWN.mainn(PRTadd+"/"+ccode.getText()+STRaddT, NamingDateName.mainn(vtd)+".txt", 1, String.valueOf(nd));
                            
                            File tmp;
                            boolean bg;
                            String dsd =NamingDate.mainn(vtd);
                            for(dsd = datep15.mainn(dsd);DateInBetween.mainn(dsd, dsd, Eyear);dsd=datep15.mainn(dsd)){
                                tmp=new File(PRTadd +"/" + ccode.getText()+ STRaddG+"/"+ NamingDateName.mainn(dsd)+".txt");
                                bg=tmp.exists();
                                if(bg){
                                in = new Scanner(new File(PRTadd +"/" + ccode.getText()+ STRaddG+"/"+ NamingDateName.mainn(dsd)+".txt"),"UTF-8");   
                                pd = in.nextLine();
                                nd = Float.valueOf(pd)+Float.valueOf(striamt);
                                in.close();
                                ReplaceLineWN.mainn(PRTadd+"/"+ccode.getText()+STRaddG, NamingDateName.mainn(dsd)+".txt", 1, String.valueOf(nd));
                                }
                                
                            }
                            
//###################################################################################################################################################################                            
                            String st1=vtd + "," + ccode.getText()+","  + striqty + "," + strirate + "," + striamt;
                String st2=","+mode+",Party";
                String Isavedform=st1+st2;
                            RemoveLineEx.mainn(ITMadd+"/"+stricode+"/Status", NamingDateName.mainn(vtd)+".txt",Isavedform,2);         // Update current file of status
                            tmp = new File(ITMadd+"/"+stricode+"/Status/"+NamingDateName.mainn(vtd)+".txt");
                            in = new Scanner(tmp,"UTF-8");
                            in.nextLine();
                            String p = in.nextLine();
                            float stck = Float.valueOf(p) - Float.valueOf(striqty);
                            ReplaceLineWN.mainn(ITMadd+"/"+stricode+"/Status", NamingDateName.mainn(vtd)+".txt", 2, String.valueOf(stck));
                            in.close();
                            
                            dsd =NamingDate.mainn(vtd);
                            for(dsd = datep15.mainn(dsd);DateInBetween.mainn(dsd, dsd, Eyear);dsd=datep15.mainn(dsd)){                               //Updating all file created or having date of early created
                                tmp = new File(ITMadd+"/"+stricode+"/Status/"+NamingDateName.mainn(dsd)+".txt");
                                bg =tmp.exists();
                                if(bg){
                                  // TextIO.putln(ITMadd+"/"+icode.getText()+"/Status/"+NamingDateName.mainn(dsd)+".txt");
                                 in = new Scanner(tmp,"UTF-8");
                            p = in.nextLine();
                            stck = Float.valueOf(p) - Float.valueOf(striqty);
                            ReplaceLineWN.mainn(ITMadd+"/"+stricode+"/Status", NamingDateName.mainn(dsd)+".txt",1 , String.valueOf(stck));
                            in.close();
                                }
                            }
                                }else{
                                    JLabel label = new JLabel("Cannot deleted");
            label.setFont(new Font("Arial", Font.BOLD, 20));
            JOptionPane.showMessageDialog(null,label,"ERROR",JOptionPane.WARNING_MESSAGE);  
                                }
//###################################################################################################################################################################                            
                        } catch (FileNotFoundException ex) {
                            JLabel label = new JLabel("Party data storing date. not found or opens !!! Error0011");
            label.setFont(new Font("Arial", Font.BOLD, 20));
            JOptionPane.showMessageDialog(null,label,"ERROR",JOptionPane.WARNING_MESSAGE);  
                        } catch (IOException ex) {
                            JLabel label = new JLabel("Party data storing date. not found or opens !!! Error0011");
            label.setFont(new Font("Arial", Font.BOLD, 20));
            JOptionPane.showMessageDialog(null,label,"ERROR",JOptionPane.WARNING_MESSAGE);  
                        }
                       }
                       if(det){
            model.removeRow(editt);
             
             for(int l=roww;l<(trr-1);l++)
                tm.setValueAt(l+1,l, 0);
             roww =-2;
                       }
             table.clearSelection();
             Lextra.requestFocus();

        }
            else
             table.clearSelection();
                 }
        else
             table.clearSelection();
        }else
            table.clearSelection();
                }
    }
    }//GEN-LAST:event_tableKeyPressed

    private void BreplaceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BreplaceActionPerformed
if(repper){
        rep();

}
    }//GEN-LAST:event_BreplaceActionPerformed

    private void irateFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_irateFocusLost
        if(amtd==1)
    amtd=0;
        else{
        try{
            irate.setText(String.format("%.2f",Float.valueOf(irate.getText())));
            iamt.setText(String.format("%.0f", (Float.valueOf(irate.getText())*(Float.valueOf(iqty.getText())))));
        }
        catch(Exception e){
            irate.setText("0.0");
            iamt.setText(String.format("%.0f", (Float.valueOf(irate.getText())*(Float.valueOf(iqty.getText())))));
        }
        }
    }//GEN-LAST:event_irateFocusLost

    private void iqtyFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_iqtyFocusLost
if(amtd==1)
    amtd=0;
else{
    try{
        //iamt.setText(String.valueOf((Float.valueOf(irate.getText())*(Float.valueOf(iqty.getText())))));
        iqty.setText(String.format("%.2f",Float.valueOf(iqty.getText())));
        iamt.setText(String.format("%.0f", (Float.valueOf(irate.getText())*(Float.valueOf(iqty.getText())))));
    }               //String.format("%.3f", Float.valueOf(qtyy))
    catch(Exception e){
        iqty.setText("1.0");
        //iamt.setText(String.valueOf((Float.valueOf(irate.getText())*(Float.valueOf(iqty.getText())))));
        iamt.setText(String.format("%.0f", (Float.valueOf(irate.getText())*(Float.valueOf(iqty.getText())))));
    }
}
    }//GEN-LAST:event_iqtyFocusLost

    private void BcloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BcloseActionPerformed
        this.dispose();
    }//GEN-LAST:event_BcloseActionPerformed

    private void BcompleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BcompleteActionPerformed
        DefaultTableModel dm = (DefaultTableModel)table.getModel();
dm.getDataVector().removeAllElements();
dm.fireTableDataChanged(); 
cname.setText(null);
ccode.requestFocus();
    }//GEN-LAST:event_BcompleteActionPerformed

    private void irateFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_irateFocusGained
irate.selectAll();
    }//GEN-LAST:event_irateFocusGained

    private void iqtyFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_iqtyFocusGained
iqty.selectAll();
    }//GEN-LAST:event_iqtyFocusGained

    private void inameFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_inameFocusGained
//iname.selectAll();

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
        JLabel label = new JLabel("Language Setup Error !!");        
        label.setFont(new Font("Arial", Font.BOLD, 18));        
        JOptionPane.showMessageDialog(null,label,"ERROR",JOptionPane.WARNING_MESSAGE);
    }
        }
    }//GEN-LAST:event_inameFocusGained

    private void icodeFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_icodeFocusGained
icode.selectAll();
    }//GEN-LAST:event_icodeFocusGained

    private void irateKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_irateKeyTyped
 char c = evt.getKeyChar();
        if(!(Character.isDigit(c)|| (c=='.'||(c==10)||c==82 ))){    //
            getToolkit().beep();
            evt.consume();
        }   
    }//GEN-LAST:event_irateKeyTyped

    private void iqtyKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_iqtyKeyTyped
 char c = evt.getKeyChar();
        if(!(Character.isDigit(c)|| (c=='.'||(c==10)||c==82 ))){    //
            getToolkit().beep();
            evt.consume();
        } 
    }//GEN-LAST:event_iqtyKeyTyped

    private void ccodeKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ccodeKeyTyped
         char c = evt.getKeyChar();
        if(!(Character.isDigit(c)||c==10) ){    //
            getToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_ccodeKeyTyped

    private void ccodeFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_ccodeFocusLost
try{        
    ccode.setText(String.format("%04d", Integer.valueOf(ccode.getText())));
}
catch(Exception e){
    ccode.requestFocus();
}
    }//GEN-LAST:event_ccodeFocusLost

    private void irateKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_irateKeyPressed
int a = evt.getKeyCode();
        if (a == 10) {                     // for enter key
          if(y==1){
              float amtt = Float.valueOf(irate.getText());
              float qtyy = Float.valueOf(iqty.getText());
              float ratee = amtt/qtyy;
              irate.setText(String.format("%.2f", ratee));
              iamt.setText(String.format("%.0f",amtt));
              y=0;
              amtd=1;
          }
          if(irate.getText().isEmpty()){
              irate.setText("0.0");
              iqty.requestFocus();
          }else{
            iqty.requestFocus();
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
                                       iqty.requestFocus();
                                   }
                               } 
        }
        }
    }//GEN-LAST:event_irateKeyPressed

    private void BreplaceKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_BreplaceKeyPressed
        // TODO add your handling code here:
        int a=evt.getKeyCode();
        if(a==10)
            Breplace.doClick();
    }//GEN-LAST:event_BreplaceKeyPressed

    private void iqtyKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_iqtyKeyPressed
        int a = evt.getKeyCode();
        if (a == 10) {                     // for enter key
          if(y==1){
              float amtt = Float.valueOf(iqty.getText());
              float ratee = Float.valueOf(irate.getText());
              float qtyy = amtt/ratee;
              iqty.setText(String.format("%.2f", qtyy));
              iamt.setText(String.format("%.0f",amtt));
              y=0;
              amtd=1;
          }
          if(iqty.getText().isEmpty()){
              iqty.setText("1.0");
              Breplace.requestFocus();
          }else{
            Breplace.requestFocus();
          }
          
        }
        else{
            if(a==81){
                //System.out.println("There is r key preassed");
                 y=1; 
            }else{
            if(evt.isControlDown()&&evt.getKeyCode()==KeyEvent.VK_LEFT){
                                    irate.requestFocus();
                               }
                               else{
                                   if(evt.isControlDown()&&evt.getKeyCode()==KeyEvent.VK_RIGHT){
                                       Breplace.requestFocus();
                                   }
                               } 
        }
        }
    }//GEN-LAST:event_iqtyKeyPressed

    private void BseeKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_BseeKeyPressed
        // TODO add your handling code here:
        int a=evt.getKeyCode();
        if(a==10)
            see();
    }//GEN-LAST:event_BseeKeyPressed

    private void inameKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_inameKeyPressed
int a=evt.getKeyCode();
if(a==10)
    irate.requestFocus();
else{
            if(evt.isControlDown()&&evt.getKeyCode()==KeyEvent.VK_LEFT){
                                    iname.requestFocus();
                               }
                               else{
                                   if(evt.isControlDown()&&evt.getKeyCode()==KeyEvent.VK_RIGHT){
                                       irate.requestFocus();
                                   }
                               } 
        }
    }//GEN-LAST:event_inameKeyPressed

    private void icodeKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_icodeKeyPressed

        int a= evt.getKeyCode();
        if(a==10)
            iname.requestFocus();
    }//GEN-LAST:event_icodeKeyPressed

    private void iqtyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_iqtyActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_iqtyActionPerformed

    private void inameFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_inameFocusLost
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
        JLabel label = new JLabel("Language Setup Error !!");        
        label.setFont(new Font("Arial", Font.BOLD, 18));        
        JOptionPane.showMessageDialog(null,label,"ERROR",JOptionPane.WARNING_MESSAGE);
    }
        }
    }//GEN-LAST:event_inameFocusLost

    private void cnameFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_cnameFocusGained
        // TODO add your handling code here:
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
        JLabel label = new JLabel("Language Setup Error !!");        
        label.setFont(new Font("Arial", Font.BOLD, 18));        
        JOptionPane.showMessageDialog(null,label,"ERROR",JOptionPane.WARNING_MESSAGE);
    }
        }
    }//GEN-LAST:event_cnameFocusGained

    private void cnameFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_cnameFocusLost
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
        JLabel label = new JLabel("Language Setup Error !!");        
        label.setFont(new Font("Arial", Font.BOLD, 18));        
        JOptionPane.showMessageDialog(null,label,"ERROR",JOptionPane.WARNING_MESSAGE);
    }
        }
    }//GEN-LAST:event_cnameFocusLost

    private void tableFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tableFocusLost
        // TODO add your handling code here:
        
    }//GEN-LAST:event_tableFocusLost

    private void tableFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tableFocusGained
        // TODO add your handling code here:
         try {
        Robot r=new Robot();
        r.keyPress(KeyEvent.VK_ALT);
        r.keyPress(KeyEvent.VK_SHIFT);
        r.keyPress(KeyEvent.VK_0);
        r.keyRelease(KeyEvent.VK_0);
        r.keyRelease(KeyEvent.VK_SHIFT);
        r.keyRelease(KeyEvent.VK_ALT);
    } catch (AWTException ex) {
        JLabel label = new JLabel("Language Setup Error !!");        
        label.setFont(new Font("Arial", Font.BOLD, 18));        
        JOptionPane.showMessageDialog(null,label,"ERROR",JOptionPane.WARNING_MESSAGE);
    }
    }//GEN-LAST:event_tableFocusGained

    public static void main(String args[]) {
    //public static void mainn() {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                //new NewPRTxEDT().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Bclose;
    private javax.swing.JButton Bcomplete;
    private javax.swing.JButton Breplace;
    private javax.swing.JButton Bsee;
    private javax.swing.JLabel Lextra;
    private javax.swing.JComboBox Pmode;
    private javax.swing.JLabel amtlbl;
    private javax.swing.JLabel ccdlbl;
    private javax.swing.JTextField ccode;
    private javax.swing.JTextField cname;
    private javax.swing.JLabel cnmlbl;
    private com.toedter.calendar.JDateChooser dater1;
    private com.toedter.calendar.JDateChooser dater2;
    private javax.swing.JLabel dtflbl;
    private javax.swing.JLabel hdlbl;
    private javax.swing.JTextField iamt;
    private javax.swing.JLabel icdlbl;
    private javax.swing.JTextField icode;
    private javax.swing.JTextField iname;
    private javax.swing.JLabel inmlbl;
    private javax.swing.JTextField iqty;
    private javax.swing.JTextField irate;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel modelbl;
    private javax.swing.JLabel qtylbl;
    private javax.swing.JLabel rtlbl;
    private javax.swing.JTable table;
    private javax.swing.JLabel tbllbl;
    private javax.swing.JLabel tklbl;
    private javax.swing.JLabel tolbl;
    // End of variables declaration//GEN-END:variables

}
