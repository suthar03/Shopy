/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shopyfinal;

import com.toedter.calendar.JTextFieldDateEditor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import java.awt.print.PageFormat;
import java.awt.print.Paper;
import java.awt.print.Printable;
import static java.awt.print.Printable.NO_SUCH_PAGE;
import static java.awt.print.Printable.PAGE_EXISTS;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
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

/**
 *
 * @author Suthar
 */
public class Supplier_Billing extends javax.swing.JFrame {

    String baseadd = "D:/Shopy/Shopy", logo = "src/Icons/logo.png", PRTadd, ITMadd, user, sd1, sd2, sd, cd, cd1, cd2, lang = "English";
    String Sname = "Unkonwn", ESname = "Unkonwn", HSname = "Unkonwn", Sno = "1234567890";       // Shop Name and CN
    String blbl = " Baki", jlbl = " Jama";
    Boolean imust = false, visiblity = true;
    String imustc = "";
    int kk = 0, tmp = 0, lastupdated = 0, pgtype = 1, extrasp = 65, extrach = 18;
    String othrlbl = "Other", gvnlbl = "Total GVN", tknlbl = "Total TKN";
    String preblbl = "Pre. Bal:", finblbl = "Final Bal:";
    String IDyear = "2020-2020", Syear = "01/01/2020", Eyear = "01/01/2020";

    /**
     * Creates new form BillingNew
     */
    public Supplier_Billing(String add, String golo, String idy, String sy, String ey) {
        baseadd = add;
        logo = golo;
        IDyear = idy;
        Syear = sy;
        Eyear = ey;
        initComponents();
        jScrollPane2.setVisible(false);
        Bprint.setVisible(false);

        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        setBounds(50, 50, 850, (int) dim.getHeight() - 50);
        this.setLocationRelativeTo(null);
        try {
            user = ShortFunction.GetLine(baseadd + "/Cuser.txt", 2);
        } catch (IOException ex) {
            JLabel label = new JLabel("Current user !!! Error0003" + ex);
            label.setFont(new Font("Arial", Font.BOLD, 18));
            JOptionPane.showMessageDialog(this, label, "ERROR", JOptionPane.WARNING_MESSAGE);
        }
        System.out.println(baseadd + "/Years.txt");

        PRTadd = baseadd + "/" + user + "/" + IDyear + "/party";
        ITMadd = baseadd + "/" + user + "/" + IDyear + "/item";

        try {
            this.setIconImage(ImageIO.read(new File(logo)));
        } catch (IOException ex) {
            JLabel label = new JLabel("Logo Problem !!! Error0001");
            label.setFont(new Font("Arial", Font.BOLD, 18));
            JOptionPane.showMessageDialog(this, label, "ERROR", JOptionPane.WARNING_MESSAGE);

        }
        //################################
        try {
            Scanner ot = new Scanner(new File(baseadd + "/" + user + "/sdata.txt"), "UTF-8");
            ESname = ot.nextLine();
            HSname = ot.nextLine();
            Sno = ot.nextLine();
            ot.close();
        } catch (FileNotFoundException ex) {
            JLabel label = new JLabel("Shop Data Error !!! Error0018");
            label.setFont(new Font("Arial", Font.BOLD, 18));
            JOptionPane.showMessageDialog(null, label, "ERROR", JOptionPane.WARNING_MESSAGE);
        }
        try {
            Scanner ot = new Scanner(new File(ITMadd + "/" + "/itemmust.txt"), "UTF-8");
            imust = Boolean.valueOf(ot.nextLine());
            imustc = ot.nextLine();
            pgtype = Integer.valueOf(ot.nextLine());
            ot.close();
        } catch (FileNotFoundException ex) {
            System.out.println("Nothing for must");
        }
        JTextFieldDateEditor editor = (JTextFieldDateEditor) d1.getDateEditor();
        editor.setEditable(false);
        editor = (JTextFieldDateEditor) d2.getDateEditor();
        editor.setEditable(false);
        try {
            //Calender
            d1.setMinSelectableDate(new SimpleDateFormat("dd/MM/yyyy").parse(Syear));
            d1.setMaxSelectableDate(new SimpleDateFormat("dd/MM/yyyy").parse(Eyear));
            d2.setMinSelectableDate(new SimpleDateFormat("dd/MM/yyyy").parse(Syear));
            d2.setMaxSelectableDate(new SimpleDateFormat("dd/MM/yyyy").parse(Eyear));
        } catch (ParseException ex) {
            JLabel label = new JLabel("There is issue while setup calender bounds");
            label.setFont(new Font("Arial", Font.BOLD, 18));
            JOptionPane.showMessageDialog(this, label, "ERROR", JOptionPane.WARNING_MESSAGE);
            System.exit(1);
        }
        Date datee = new Date();
        d1.setDate(datee);
        d2.setDate(datee);
        //Language setup
        try {
            lang = ShortFunction.GetLine(baseadd + "/" + user + "/conf.txt", 1);
            //System.out.println(lang);
        } catch (IOException ex) {
            JLabel label = new JLabel("Configuration Error !!! Error0003");
            label.setFont(new Font("Arial", Font.BOLD, 18));
            JOptionPane.showMessageDialog(null, label, "ERROR", JOptionPane.WARNING_MESSAGE);
        }
        if (lang.compareToIgnoreCase("English") != 0) {
            Sname = HSname;
            othrlbl = "अन्य सामान";
            gvnlbl = " कुल देन";
            tknlbl = " कुल लेन";
            preblbl = "पिछला :";
            finblbl = "     कुल :";
            blbl = " बाकी";
            jlbl = " जमा";
            dtflbl.setText("दिनाँक :- ");
            tolbl.setText("से :");
            tklbl.setText("तक ");
            cdflbl.setText("कोड :");
            cdtolbl.setText("से :");
            cdtklbl.setText("तक ");
            BShow.setText("देखे");

        } else {
            Sname = ESname;
        }
    }

    public void Biller() {
        //System.out.println("Nomi is called");

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        sd1 = dateFormat.format(d1.getDate());
        sd2 = dateFormat.format(d2.getDate());
        cd1 = c1.getText();
        cd2 = c2.getText();
        DefaultTableModel dm = (DefaultTableModel) table.getModel();
        dm.getDataVector().removeAllElements();
        dm.fireTableDataChanged(); // notifies the JTable that the model has changed

        try {

            DefaultTableModel model = (DefaultTableModel) table.getModel();

            float Ptotal, Gtotal, Ttotal, PGtotal, PTtotal;             // p= previous , G/T = Given/Taken
            float Balance;
            int i = 0, f, it = 0, reserved = 0;

            String pname, pEname, pHname, pcode, pdaate, pmobile, DtAdd;//DtAdd= Date Of Addition 
            cd = cd1;
            int prow = 0;
            float another = 0;
            while (Integer.valueOf(cd) <= Integer.valueOf(cd2)) // It's for user ... equals to the number of user
            {
                cd = String.format("%04d", Integer.valueOf(cd));
                //System.out.println(cd);
                if (ShortFunction.repeatation(PRTadd, "party.txt", cd) == 1) {
                    sd = sd1;                   // Assign Initial Values
                    Ptotal = 0;
                    PTtotal = 0;
                    PGtotal = 0;
                    Gtotal = 0;
                    Ttotal = 0;
                    Balance = 0;
                    another = 0;
                    f = 0;
                    it = 0;
                    reserved = table.getRowCount();
                    visiblity = true;
                    if (imust) {
                        visiblity = false;
                    }
                    String ocode, oitem, oqty, oamt, orate;
//#######################################################################################################################################
                    //pcode = read.nextLine();
                    pcode = String.format("%04d", Integer.valueOf(cd));
                    Scanner inread;
                    inread = new Scanner(new File(PRTadd + "/" + pcode + "/profile.txt"), "UTF-8");          // to get the name of party
                    inread.useDelimiter("\\n");
                    inread.nextLine();
                    pEname = inread.nextLine();                // name of party having code pcode
                    pHname = inread.nextLine();
                    pmobile = inread.nextLine();
                    inread.nextLine();
                    inread.nextLine();
                    DtAdd = inread.nextLine();
                    DtAdd = ShortFunction.NamingDate(DtAdd);
                    inread.close();
                    if (lang.compareToIgnoreCase("English") != 0) {
                        pname = pHname;
                    } else {
                        pname = pEname;
                    }
//#######################################################################################################################################
                    //int counter =0;
                    String dsd = ShortFunction.NamingDate(sd1);
                    File tmp1;
                    Scanner bal;
                    Boolean bg;
                    if (ShortFunction.DateInBetween(DtAdd, dsd, sd1)) {
                        for (; ShortFunction.DateInBetween(DtAdd, dsd, sd1); dsd = ShortFunction.Date_minus(dsd)) {
                            tmp1 = new File(PRTadd + "/" + pcode + "/Pending/Given/" + ShortFunction.NamingDateName(dsd) + ".txt");
                            bg = tmp1.exists();
                            if (bg) {
                                bal = new Scanner(tmp1, "UTF-8");
                                Ptotal = Float.valueOf(bal.nextLine());
                                break;
                            }
                        }
                    } else {
                        dsd = DtAdd;
                        tmp1 = new File(PRTadd + "/" + pcode + "/Pending/Given/" + ShortFunction.NamingDateName(dsd) + ".txt");
                        bg = tmp1.exists();
                        if (bg) {
                            bal = new Scanner(tmp1, "UTF-8");
                            Ptotal = Float.valueOf(bal.nextLine());

                        }
                    }

//#######################################################################################################################################
                    sd = dsd;
                    do {               // for indivisiuale party it read all possible Given Item files according to date intervals

                        String fname = ShortFunction.NamingDateName(sd);                // According to date what name of file should be perfact
                        File tempFile = new File(PRTadd + "/" + pcode + "/Pending/Given/" + fname + ".txt");

                        boolean exists = tempFile.exists();
                        if (exists) {
                            inread = new Scanner(new File(PRTadd + "/" + pcode + "/Pending/Given/" + fname + ".txt"), "UTF-8");
                            inread.useDelimiter(",|\\n");
                            inread.nextLine();
                            inread.nextLine();

                            while (inread.hasNext()) {
                                pdaate = inread.next();
                                ocode = inread.next();
                                oitem = inread.next();
                                oqty = inread.next();
                                orate = inread.next();
                                oamt = inread.next();
                                if (imust) {
                                    if (ocode.equalsIgnoreCase(imustc)) {
                                        visiblity = true;
                                    }
                                }

                                if (ShortFunction.DateInBetween(sd1, pdaate, sd2)) {
                                    Gtotal = Gtotal + Float.valueOf(oamt);
                                    if (f == 0) {
                                        f = 1;
                                        model.addRow(new Object[]{++i, pcode, pname, null, "Mobile No.:", pmobile, null});
                                        model.addRow(new Object[]{null, null, null, "From :", sd1, "To :", sd2});
                                        model.addRow(new Object[]{null, null, null, null, null, null, null});
                                    }
                                    if (ShortFunction.repeatation(ITMadd, "itemp.txt", ocode) == 1) {
                                        model.addRow(new Object[]{null, ++it, pdaate, oitem, oqty, orate, oamt});
                                    } else {
                                        another += Float.valueOf(oamt);
                                    }
                                } else {
                                    if (ShortFunction.DateInBetween(sd, pdaate, sd1)) {
                                        PGtotal = PGtotal + Float.valueOf(oamt);
                                    }
                                }
                            }
                            inread.close();
                        }
                        //TextIO.putln(sd);
                        sd = ShortFunction.Date_plus(sd);                 // Go for next Hafta
                    } while (ShortFunction.DateInBetween(dsd, sd, sd2));                 // Loop over

                    if (f != 0) {
                        if (another != 0) {
                            model.addRow(new Object[]{null, ++it, sd2, othrlbl, String.valueOf(another), "1.0", String.valueOf(another)});
                        }
                        model.addRow(new Object[]{null, null, null, null, null, finblbl, Gtotal});
                        prow = table.getRowCount();
                        System.out.println("1 Code:" + pcode + " prow:" + prow + " prelbl=" + String.valueOf(Ptotal) + " gvnlbl=" + Gtotal);
                        model.addRow(new Object[]{null, null, null, null, null, preblbl, String.valueOf(Ptotal)});
                        model.addRow(new Object[]{null, null, null, null, null, gvnlbl, Gtotal});
                        model.addRow(new Object[]{null, null, null, null, null, null, null});
                    }

//#######################################################################################################################################
//sd=sd1;             // So that it also read all files
                    sd = dsd;
                    another = 0;
                    do {               // for indivisiuale party it read all possible taken item files according to date intervals

                        String fname = ShortFunction.NamingDateName(sd);                // According to date what name of file should be perfact

                        File tempFile = new File(PRTadd + "/" + pcode + "/Pending/Taken/" + fname + ".txt");
                        boolean exists = tempFile.exists();
                        if (exists) {
                            inread = new Scanner(new File(PRTadd + "/" + pcode + "/Pending/Taken/" + fname + ".txt"), "UTF-8");
                            inread.useDelimiter(",|\\n");
                            inread.nextLine();

                            while (inread.hasNext()) {

                                pdaate = inread.next();
                                ocode = inread.next();
                                oitem = inread.next();
                                oqty = inread.next();
                                orate = inread.next();
                                oamt = inread.next();
                                if (ShortFunction.DateInBetween(sd1, pdaate, sd2)) {
                                    if (imust) {
                                        if (ocode.equalsIgnoreCase(imustc)) {
                                            visiblity = true;
                                        }
                                    }
                                    Ttotal = Ttotal + Float.valueOf(oamt);
                                    if (f == 0) {
                                        f = 1;
                                        model.addRow(new Object[]{++i, pcode, pname, null, "Mobile No.:", pmobile, null});
                                        model.addRow(new Object[]{null, null, null, "From :", sd1, "To :", sd2});
                                        model.addRow(new Object[]{null, null, null, null, null, null, null});
                                        model.addRow(new Object[]{null, null, null, null, null, finblbl, Gtotal});

                                        prow = table.getRowCount();
                                        System.out.println("2 Code:" + pcode + " prow:" + prow + " prelbl=" + String.valueOf(Ptotal) + " gvnlbl=" + Gtotal);
                                        model.addRow(new Object[]{null, null, null, null, null, preblbl, String.valueOf(Ptotal)});
                                        model.addRow(new Object[]{null, null, null, null, null, gvnlbl, Gtotal});
                                        model.addRow(new Object[]{null, null, null, null, null, null, null});
                                    }
                                    if (ShortFunction.repeatation(ITMadd, "itemp.txt", ocode) == 1) {
                                        model.addRow(new Object[]{null, ++it, pdaate, oitem, oqty, orate, oamt});
                                    } else {
                                        another += Float.valueOf(oamt);
                                    }
                                } else {
                                    if (ShortFunction.DateInBetween(sd, pdaate, sd1)) {
                                        PTtotal = PTtotal + Float.valueOf(oamt);
                                    }
                                }
                            }
                            inread.close();
                        }
                        sd = ShortFunction.Date_plus(sd);
                    } while (ShortFunction.DateInBetween(dsd, sd, sd2));                 // Loop over

                    if (f != 0) {
                        if (another != 0) {
                            model.addRow(new Object[]{null, ++it, sd2, othrlbl, String.valueOf(another), "1.0", String.valueOf(another)});
                        }
                        model.addRow(new Object[]{null, null, null, null, null, tknlbl, Ttotal});
                        model.addRow(new Object[]{null, null, null, null, null, null, null});
                    }
//#######################################################################################################################################

                    Ptotal = -Ptotal + PTtotal - PGtotal;                         //Previous balance;
                    Balance = Ptotal + Ttotal - Gtotal;
                    table.setShowGrid(false);
                    if (f != 0) {
                        //model.addRow(new Object[]{null,null,null,null,null,preblbl,String.valueOf(Ptotal)});
                        System.out.println("We are replacing :prow:" + prow + " " + table.getValueAt(prow, 5) + "::" + Ptotal);
                        table.setValueAt(String.valueOf(Ptotal), prow, 6);
                        System.out.println("We are replacing :prow+1:" + (prow + 1) + " " + table.getValueAt(prow + 1, 5) + "::" + Gtotal);
                        table.setValueAt(Gtotal - Ptotal, prow + 1, 6);
                        model.addRow(new Object[]{null, null, null, null, null, finblbl, String.valueOf(Balance) + " " + bnam(Balance)});
                        model.addRow(new Object[]{null, null, null, null, null, null, null});
                        model.addRow(new Object[]{null, null, null, null, null, null, null});
                        model.addRow(new Object[]{null, null, null, null, null, null, null});
                        model.addRow(new Object[]{null, null, null, null, null, null, null});

                    }
//#######################################################################################################################################

                    Ptotal = 0;
                }
                if (!visiblity) {
                    System.out.println("iit:" + i + "  reserved:" + reserved + "  dm.getRowCount()" + dm.getRowCount());
                    if (reserved != dm.getRowCount()) {
                        --i;
                    }
                    System.out.println("it:" + i);
                    for (int y = dm.getRowCount() - 1; y >= reserved; --y) {
                        dm.removeRow(y);
                    }
                }

                // All party readed successfully
                cd = String.valueOf(1 + Integer.valueOf(cd));
            }

        } catch (FileNotFoundException ex) {
            JLabel label = new JLabel("PRT profile. problem !!! Error0007");
            label.setFont(new Font("Arial", Font.BOLD, 18));
            JOptionPane.showMessageDialog(null, label, "ERROR", JOptionPane.WARNING_MESSAGE);

        }
    }

    public String bnam(float cs) {
        String rtn = null;
        if (cs < 0) {
            rtn = blbl;
        } else {
            if (cs > 0) {
                rtn = jlbl;
            } else {
                rtn = "     ";
            }
        }
        return (rtn);
    }

    public String repchar(String s, int repit) {
        String res = "";
        for (int u = 0; u <= repit; ++u) {
            res += s;
        }
        return res;
    }

    void createtable() {

        DefaultTableModel dm = (DefaultTableModel) btable.getModel();
        dm.getDataVector().removeAllElements();
        dm.fireTableDataChanged(); // notifies the JTable that the model has changed
        kk = 0;
        DefaultTableModel model = (DefaultTableModel) btable.getModel();

        TableModel tm = table.getModel();
        for (; kk < tm.getRowCount(); ++kk) {

            Object o = tm.getValueAt(kk, 0);
            if (o != null) {                        //New Party found
                o = tm.getValueAt(kk, 1);
                String ccode = (String) o;
                o = tm.getValueAt(kk, 2);
                String cname = (String) o;
                model.addRow(new Object[]{repchar("-", 34 + extrach), null, null, null});
                model.addRow(new Object[]{ShortFunction.stringc(Sname, 35 + extrach), null, null, null});
                model.addRow(new Object[]{ShortFunction.stringr("Mob.:" + Sno, 34 + extrach), null, null, null});
                model.addRow(new Object[]{repchar("-", 34 + extrach), null, null, null});
                model.addRow(new Object[]{ccode, cname, null, null});
                model.addRow(new Object[]{dtflbl.getText() + sd1 + tolbl.getText() + sd2 + tklbl.getText(), null, null, null});
                if (lang.compareToIgnoreCase("English") != 0) {
                    if (dtprnt.getState()) {
                        model.addRow(new Object[]{"दिनाँक          नाम                     ", "    मात्रा ", "     रेट  ", "  रकम "});
                    } else //10/10/2020
                    {
                        model.addRow(new Object[]{"नाम                     ", "  मात्रा ", "   रेट ", " रकम "});
                    }
                } else {
                    if (dtprnt.getState()) {
                        model.addRow(new Object[]{"Date         Name            ", "    Qty   ", "     Rate  ", "  T.Price"});
                    } else //10/10/2020
                    {
                        model.addRow(new Object[]{"Name            ", "Qty   ", "   Rate  ", " T.Price"});
                    }
                }
                model.addRow(new Object[]{repchar("-", 34 + extrach)});
            }
            kk += 3;       //Escaping Extra Lines
            o = tm.getValueAt(kk, 3);

            while (o != null) {             //Reading all itmem Given
                o = tm.getValueAt(kk, 2);
                String datestr = (String) o;
                o = tm.getValueAt(kk, 3);
                String Iname = (String) o;
                o = tm.getValueAt(kk, 4);
                String iqty = (String) o;
                float Iqty = Float.valueOf(iqty);
                o = tm.getValueAt(kk, 5);
                String irate = (String) o;
                float Irate = Float.valueOf(irate);
                o = tm.getValueAt(kk, 6);
                String iamt = (String) o;
                float Iamt = Float.valueOf(iamt);
                if (dtprnt.getState()) {
                    model.addRow(new Object[]{datestr + " " + Iname, String.format("%8.1f", Iqty), String.format("%8.2f", Irate), String.format("%1.0f", Iamt) + "  "});
                } else {
                    model.addRow(new Object[]{Iname, String.format("%6.1f", Iqty), String.format("%5.0f", Irate), String.format("%1.0f", Iamt) + "  "});
                }
                kk++;
                o = tm.getValueAt(kk, 3);
            }
            ++kk;
            o = tm.getValueAt(kk, 5);          //Priknting Previous Total =3461
            String pname = (String) o;
            o = tm.getValueAt(kk, 6);
            String pamt = (String) o;
            model.addRow(new Object[]{null, ShortFunction.stringc(pname + " = " + pamt + " " + bnam(Float.valueOf(pamt)), 36), null, null});
            //model.addRow(new Object[]{null,null,gname+" = "+String.valueOf(gamt)+"     ",null});
            //model.setValueAt(,reserved-1,1);
            //gamt = gamt-Float.valueOf(pamt);
            //model.setValueAt(,reserved,2); //g2d.drawString(ShortFunction.stringc(pname+" = "+pamt,36),10,y);y++;
            ++kk;
            o = tm.getValueAt(kk, 5);          //Priknting GVN Total =3461
            String gname = (String) o;
            o = tm.getValueAt(kk, 6);
            System.out.println(gname + "::" + o);
            float gamt = (float) o;
            model.addRow(new Object[]{null, null, gname + " = " + String.valueOf(gamt)});
            kk += 2;          //Escaping extra line

            o = tm.getValueAt(kk, 3);
            while (o != null) {             //Reading all itmem Given
                o = tm.getValueAt(kk, 2);
                String datestr = (String) o;
                o = tm.getValueAt(kk, 3);
                String Iname = (String) o;
                o = tm.getValueAt(kk, 4);
                String iqty = (String) o;
                float Iqty = Float.valueOf(iqty);
                o = tm.getValueAt(kk, 5);
                String irate = (String) o;
                float Irate = Float.valueOf(irate);
                o = tm.getValueAt(kk, 6);
                String iamt = (String) o;
                float Iamt = Float.valueOf(iamt);
                if (dtprnt.getState()) {
                    model.addRow(new Object[]{datestr + " " + Iname, String.format("%8.1f", Iqty), String.format("%8.2f", Irate), String.format("%1.0f", Iamt) + "  "});
                } else {
                    model.addRow(new Object[]{Iname, String.format("%6.1f", Iqty), String.format("%5.0f", Irate), String.format("%1.0f", Iamt) + "  "});
                }
                kk++;
                o = tm.getValueAt(kk, 3);
            }
            o = tm.getValueAt(kk, 5);          //Priknting TKN Total =3461
            String tname = (String) o;
            o = tm.getValueAt(kk, 6);
            float tamt = (float) o;
            model.addRow(new Object[]{null, null, tname + " = " + tamt});
            kk += 2;          //Escaping extra line

            o = tm.getValueAt(kk, 5);          //Printing grand Total =3461
            if (o != null) {
                String fname = (String) o;
                o = tm.getValueAt(kk, 6);
                String famt = (String) o;
                model.addRow(new Object[]{null, ShortFunction.stringc(fname + " = " + famt, 36)});
                kk += 4;
            }
            model.addRow(new Object[]{repchar("*", 34 + extrach)});
            model.addRow(new Object[]{"."});

        }

    }
//Graphics2D g3d = (Graphics2D) graphics;  

    public String trunct(String longstr, int maxlen) {
        String srt = longstr;
        System.out.println("Expected length" + g2d.getFontMetrics().stringWidth(srt));
        if (g2d.getFontMetrics().stringWidth(srt) > maxlen) {
            return trunct(srt.substring(0, srt.length() - 1), maxlen);

        } else {
            return srt;
        }

    }
    PrinterJob pj;
    Graphics2D g2d;

    public void printerr() {
        pj = PrinterJob.getPrinterJob();
        boolean ok = pj.printDialog();
        if (ok) {
            pj.setPrintable(new BillPrintable(), getPageFormat(pj));
            try {
                time = 1;
                lastupdated = 0;
                pj.print();

            } catch (PrinterException ex) {
                JLabel label = new JLabel("Printer Exception error !!! Error0019");
                label.setFont(new Font("Arial", Font.BOLD, 18));
                JOptionPane.showMessageDialog(null, label, "ERROR", JOptionPane.WARNING_MESSAGE);
            }
        }
    }
    int time = 1;

    public class BillPrintable implements Printable {

        public int print(Graphics graphics, PageFormat pageFormat, int pageIndex)
                throws PrinterException {
            g2d = (Graphics2D) graphics;
            pageFormat = getPageFormat(pj);

            g2d.translate((int) pageFormat.getImageableX(), (int) pageFormat.getImageableY());
            int my = 831;
            kk = lastupdated;
            System.out.println("kk=" + kk);
            try {
                int gtit = 0;
                int y = 10;
                int X = 10;
                int op = 0;
                int yShift = 10;
                int headerRectHeight = 10;
                y += headerRectHeight;
                System.out.println("Inside trry = " + kk);
                System.out.println("Object :" + btable.getValueAt(0, 0));

                TableModel tm = btable.getModel();
                if (pgtype == 0) {
                    for (int nj = 0; nj < 7; ++nj) {
                        Object o = tm.getValueAt(kk + nj, 0);
                        String ghj = String.valueOf(o);
                        if (ShortFunction.isnumeric(ghj) == true) {
                            gtit = 1;
                            kk = kk - 4 + nj;
                            break;
                        }
                    }
                    if (gtit == 0) {
                        for (; kk > 0; --kk) {
                            Object o = tm.getValueAt(kk, 0);
                            String ghj = String.valueOf(o);
                            if (ShortFunction.isnumeric(ghj) == true) {
                                kk = kk - 4;
                                break;

                            }
                        }
                    }
                }
                g2d.setFont(new Font("Monospaced", Font.PLAIN, 9));     //First time for printing
                for (; kk < tm.getRowCount(); ++kk) {
                    if (y < my) {
                        Object o1 = tm.getValueAt(kk, 0);
                        Object o2 = tm.getValueAt(kk, 1);
                        Object o3 = tm.getValueAt(kk, 2);
                        Object o4 = tm.getValueAt(kk, 3);
                        String ghj = String.valueOf(o1);
                        if (ShortFunction.isnumeric(ghj) == true) {
                            //System.out.println(ghj+"  op:"+op);
                            if (op < 2) {
                                ++op;
                            } else {
                                op = 0;
                            }
                        }

                        if (o3 == null && o4 == null) {   //Name Code Mobile Line
                            // System.out.println("o3==&&o4==");
                            if (o2 == null) {
                                System.out.println("Y:" + y + "  " + String.valueOf(o1));
                                g2d.drawString(String.valueOf(o1), X, y);
                                y += yShift;
                            } else {
                                if (o1 != null) {
                                    g2d.drawString(String.valueOf(o1) + "    " + trunct(String.valueOf(o2), 145), X, y);
                                    y += yShift;
                                } else {
                                    g2d.drawString(String.valueOf(o2), X, y);
                                    y += yShift;
                                }
                            }
                        } else {
                            if (o4 != null) {      //Items
                                g2d.drawString(trunct(String.valueOf(o1), 69 + extrasp), X, y);//y+=yShift;
                                g2d.drawString(String.format(String.valueOf(o2)) + " * " + String.format(String.valueOf(o3)) + " = " + String.format(String.valueOf(o4)) + "  ", X + extrasp + 69, y);
                                y += yShift;
                            } else {
                                if (o2 != null) {      //Prevous and Final
                                    g2d.drawString(ShortFunction.stringc(String.valueOf(o2), 36), X + extrasp, y);
                                    y += yShift;
                                } else {
                                    if (o3 != null) { //current Len Den Total
                                        g2d.drawString(String.valueOf(o3), X + 50 + extrasp, y);
                                        y += yShift;
                                    }
                                }
                            }
                        }
                    } else {

                        gtit = 0;
                        y = 10;
                        X = 208;
                        if (dtprnt.getState()) {
                            X = 315;
                        }
                        op = 0;
                        y += headerRectHeight;
                        if (pgtype == 0) {
                            for (int nj = 0; nj < 7; ++nj) {
                                Object o = tm.getValueAt(kk + nj, 0);
                                String ghj = String.valueOf(o);
                                if (ShortFunction.isnumeric(ghj) == true) {
                                    gtit = 1;
                                    kk = kk - 4 + nj;
                                    break;
                                }
                            }
                            if (gtit == 0) {
                                for (; kk > 0; --kk) {
                                    Object o = tm.getValueAt(kk, 0);
                                    String ghj = String.valueOf(o);
                                    if (ShortFunction.isnumeric(ghj) == true) {
                                        kk = kk - 4;
                                        break;

                                    }
                                }
                            }
                        } else {
                            y = 1100;
                        }
                        //Second time for printing
                        for (; kk < tm.getRowCount(); ++kk) {
                            if (y < my) {
                                Object o1 = tm.getValueAt(kk, 0);
                                Object o2 = tm.getValueAt(kk, 1);
                                Object o3 = tm.getValueAt(kk, 2);
                                Object o4 = tm.getValueAt(kk, 3);
                                String ghj = String.valueOf(o1);
                                if (ShortFunction.isnumeric(ghj) == true) {
                                    if (op < 2) {
                                        ++op;
                                    } else {
                                        op = 0;
                                    }
                                }

                                if (o3 == null && o4 == null) {   //Name Code Mobile Line
                                    if (o2 == null) {
                                        g2d.drawString(String.valueOf(o1), X, y);
                                        y += yShift;
                                    } else {
                                        if (o1 != null) {
                                            g2d.drawString(String.valueOf(o1) + "    " + trunct(String.valueOf(o2), 145), X, y);
                                            y += yShift;
                                        } else {
                                            g2d.drawString(String.valueOf(o2), X, y);
                                            y += yShift;
                                        }
                                    }
                                } else {
                                    if (o4 != null) {      //Items
                                        g2d.drawString(trunct(String.valueOf(o1), 69 + extrasp), X, y);//y+=yShift;
                                        g2d.drawString(String.format(String.valueOf(o2)) + " *" + String.format(String.valueOf(o3)) + " = " + String.format(String.valueOf(o4)) + "  ", X + extrasp + 69, y);
                                        y += yShift;
                                    } else {
                                        if (o2 != null) {      //Last wale Prevous and Finel
                                            g2d.drawString(ShortFunction.stringc(String.valueOf(o2), 36), X, y);
                                            y += yShift;
                                        } else {
                                            if (o3 != null) { //current Len Den Total
                                                g2d.drawString(String.valueOf(o3), X + 50, y);
                                                y += yShift;
                                            }
                                        }
                                    }
                                }
                            } else {

                                gtit = 0;
                                y = 10;
                                X = 404;
                                op = 0;
                                y += headerRectHeight;
                                if (pgtype == 0 && !dtprnt.getState()) {
                                    for (int nj = 0; nj < 7; ++nj) {
                                        Object o = tm.getValueAt(kk + nj, 0);
                                        String ghj = String.valueOf(o);
                                        if (ShortFunction.isnumeric(ghj) == true) {
                                            gtit = 1;
                                            kk = kk - 4 + nj;
                                            break;
                                        }
                                    }
                                    if (gtit == 0) {
                                        for (; kk > 0; --kk) {
                                            Object o = tm.getValueAt(kk, 0);
                                            String ghj = String.valueOf(o);
                                            if (ShortFunction.isnumeric(ghj) == true) {
                                                kk = kk - 4;
                                                break;

                                            }
                                        }
                                    }
                                } else {
                                    y = 1100;
                                }
                                //third time for printing
                                for (; kk < tm.getRowCount(); ++kk) {
                                    if (y < my) {
                                        Object o1 = tm.getValueAt(kk, 0);
                                        Object o2 = tm.getValueAt(kk, 1);
                                        Object o3 = tm.getValueAt(kk, 2);
                                        Object o4 = tm.getValueAt(kk, 3);
                                        String ghj = String.valueOf(o1);
                                        if (ShortFunction.isnumeric(ghj) == true) {
                                            //System.out.println(ghj+"  op:"+op);
                                            if (op < 2) {
                                                ++op;
                                            } else {
                                                op = 0;
                                            }
                                        }

                                        if (o3 == null && o4 == null) {   //Name Code Mobile Line
                                            // System.out.println("o3==&&o4==");
                                            if (o2 == null) {
                                                g2d.drawString(String.valueOf(o1), X, y);
                                                y += yShift;
                                            } else {
                                                if (o1 != null) {
                                                    g2d.drawString(String.valueOf(o1) + "    " + trunct(String.valueOf(o2), 145), X, y);
                                                    y += yShift; //int width = g2d.getFontMetrics().stringWidth(gh);
                                                } else {
                                                    g2d.drawString(String.valueOf(o2), X, y);
                                                    y += yShift;
                                                }
                                            }
                                        } else {
                                            if (o4 != null) {      //Items
                                                g2d.drawString(trunct(String.valueOf(o1), 69), X, y);//y+=yShift;
                                                g2d.drawString(String.format(String.valueOf(o2)) + " * " + String.format(String.valueOf(o3)) + " = " + String.format(String.valueOf(o4)) + "  ", X + 69, y);
                                                y += yShift;
                                            } else {
                                                if (o2 != null) {      //Last wale Prevous and Finel
                                                    g2d.drawString(ShortFunction.stringc(String.valueOf(o2), 36), X, y);
                                                    y += yShift;
                                                } else {
                                                    if (o3 != null) { //current Len Den Total
                                                        g2d.drawString(String.valueOf(o3), X + 50, y);
                                                        y += yShift;
                                                    }
                                                }
                                            }
                                        }
                                    } else {
                                        if (time == 1) {
                                            time = 2;
                                        } else {
                                            time = 1;
                                            lastupdated = kk;
                                        }
                                        return PAGE_EXISTS;
                                    }
                                }
                            }
                        }
                    }
                }
            } catch (Exception r) {
                System.out.println("Something");
                return NO_SUCH_PAGE;

            }

            if (time < 2) {
                ++time;
                return PAGE_EXISTS;
            }
            return NO_SUCH_PAGE;

        }

    }
    private static Paper paper;
    PageFormat pf;

    public PageFormat getPageFormat(PrinterJob pj) {

        pf = pj.defaultPage();
        paper = pf.getPaper();
        double width = 600;      //printer know only point per inch.default value is 72ppi
        double height = 1070;//11d * 72d;//middleHeight;//convert_CM_To_PPI(headerHeight+middleHeight+footerHeight); 
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

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        c1 = new javax.swing.JTextField();
        c2 = new javax.swing.JTextField();
        BShow = new javax.swing.JButton();
        d1 = new com.toedter.calendar.JDateChooser();
        d2 = new com.toedter.calendar.JDateChooser();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        btable = new javax.swing.JTable();
        creater = new javax.swing.JButton();
        dtflbl = new javax.swing.JLabel();
        tolbl = new javax.swing.JLabel();
        tklbl = new javax.swing.JLabel();
        Bprint = new javax.swing.JButton();
        cdflbl = new javax.swing.JLabel();
        cdtolbl = new javax.swing.JLabel();
        cdtklbl = new javax.swing.JLabel();
        setting = new javax.swing.JButton();
        dtprnt = new java.awt.Checkbox();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Billing for Supplier");

        c1.setText("1");
        c1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                c1FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                c1FocusLost(evt);
            }
        });
        c1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                c1KeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                c1KeyTyped(evt);
            }
        });

        c2.setText("1");
        c2.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                c2FocusGained(evt);
            }
        });
        c2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                c2KeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                c2KeyTyped(evt);
            }
        });

        BShow.setText("Show");
        BShow.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BShowActionPerformed(evt);
            }
        });
        BShow.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                BShowKeyPressed(evt);
            }
        });

        d1.setDateFormatString("dd/MM/yyyy");
        d1.setMaxSelectableDate(new java.util.Date(253370748712000L));
        d1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                d1KeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                d1KeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                d1KeyTyped(evt);
            }
        });

        d2.setDateFormatString("dd/MM/yyyy");

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Serial", "Code", "Name/Date", "Item", "Qty", "Rate", "Amt"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, true, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        table.setColumnSelectionAllowed(true);
        table.setRowHeight(20);
        jScrollPane1.setViewportView(table);
        table.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);

        btable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Serial", "Code", "Name/Date", "Item"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        btable.setSelectionBackground(new java.awt.Color(255, 255, 255));
        btable.setSelectionForeground(new java.awt.Color(0, 0, 0));
        jScrollPane2.setViewportView(btable);
        btable.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);

        creater.setText("Print");
        creater.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createrActionPerformed(evt);
            }
        });

        dtflbl.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        dtflbl.setText("Date from:");

        tolbl.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        tolbl.setText("To");

        Bprint.setText("Print");
        Bprint.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BprintActionPerformed(evt);
            }
        });

        cdflbl.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        cdflbl.setText("Date from:");

        cdtolbl.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        cdtolbl.setText("To");

        setting.setText("setting");
        setting.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                settingActionPerformed(evt);
            }
        });

        dtprnt.setLabel("Print Date");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane2)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(setting)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(Bprint)
                        .addGap(59, 59, 59)
                        .addComponent(creater)
                        .addGap(121, 121, 121))))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(78, 78, 78)
                        .addComponent(dtflbl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(69, 69, 69)
                        .addComponent(cdflbl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(d1, javax.swing.GroupLayout.DEFAULT_SIZE, 118, Short.MAX_VALUE)
                    .addComponent(c1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cdtolbl, javax.swing.GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
                    .addComponent(tolbl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(d2, javax.swing.GroupLayout.DEFAULT_SIZE, 121, Short.MAX_VALUE)
                    .addComponent(c2))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addComponent(tklbl, javax.swing.GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE)
                        .addGap(7, 7, 7))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cdtklbl, javax.swing.GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE)))
                .addGap(38, 38, 38)
                .addComponent(BShow, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(165, 165, 165)
                .addComponent(dtprnt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(dtprnt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(d1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(d2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(dtflbl)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(tklbl, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(tolbl, javax.swing.GroupLayout.Alignment.TRAILING))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(c1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(c2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(cdflbl)
                                .addComponent(cdtolbl))
                            .addComponent(cdtklbl, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(BShow, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(20, 20, 20)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 246, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 323, Short.MAX_VALUE)
                .addGap(4, 4, 4)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(creater)
                    .addComponent(Bprint)
                    .addComponent(setting))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BShowActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BShowActionPerformed
        try {
            Scanner ot = new Scanner(new File(ITMadd + "/" + "/itemmust.txt"), "UTF-8");
            imust = Boolean.valueOf(ot.nextLine());
            imustc = ot.nextLine();
            pgtype = Integer.valueOf(ot.nextLine());
            ot.close();
        } catch (FileNotFoundException ex) {
            //System.out.println("Nothing for must");
        }
        System.out.println("c1" + c1.getText() + " c2:" + c2.getText());
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        String sd1 = dateFormat.format(d1.getDate());
        String sd2 = dateFormat.format(d2.getDate());
        System.out.println("sd1:" + sd1 + " sd2:" + sd2);
        Biller();
    }//GEN-LAST:event_BShowActionPerformed

    private void createrActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createrActionPerformed
        try {
            Scanner ot = new Scanner(new File(ITMadd + "/" + "/itemmust.txt"), "UTF-8");
            ot.nextLine();
            ot.nextLine();
            pgtype = Integer.valueOf(ot.nextLine());
            ot.close();
        } catch (FileNotFoundException ex) {
            //System.out.println("Nothing for must");
        }

        if (dtprnt.getState()) {
            extrasp = 65;
            extrach = 18;
        } else {
            extrasp = 0;
            extrach = 0;
        }
        createtable();

        Bprint.doClick();
    }//GEN-LAST:event_createrActionPerformed

    private void BprintActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BprintActionPerformed
        lastupdated = 0;
        time = 1;
        System.out.println("\n\n\nAgain for printer");
        printerr();
    }//GEN-LAST:event_BprintActionPerformed

    private void settingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_settingActionPerformed
        Item_To_Print.main(baseadd, logo, IDyear, Syear, Eyear);
    }//GEN-LAST:event_settingActionPerformed

    private void c1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_c1FocusLost
        if (Integer.valueOf(c2.getText()) < Integer.valueOf(c1.getText())) {
            c2.setText(c1.getText());
        }
    }//GEN-LAST:event_c1FocusLost

    private void c1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_c1KeyTyped
        char c = evt.getKeyChar();
        if (!(Character.isDigit(c) || c == 10)) {    //
            getToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_c1KeyTyped

    private void c2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_c2KeyPressed
        if (evt.getKeyCode() == 10) {
            BShow.requestFocus();
        }
    }//GEN-LAST:event_c2KeyPressed

    private void c1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_c1KeyPressed
        if (evt.getKeyCode() == 10) {
            c2.requestFocus();
        }
    }//GEN-LAST:event_c1KeyPressed

    private void BShowKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_BShowKeyPressed
        if (evt.getKeyCode() == 10) {
            BShow.doClick();
        }
    }//GEN-LAST:event_BShowKeyPressed

    private void d1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_d1KeyReleased
        System.out.println("Key pressed " + evt.getKeyCode());
    }//GEN-LAST:event_d1KeyReleased

    private void d1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_d1KeyPressed
        System.out.println("Key pressed2 " + evt.getKeyCode());
    }//GEN-LAST:event_d1KeyPressed

    private void d1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_d1KeyTyped
        System.out.println("Key pressed3 " + evt.getKeyCode());
    }//GEN-LAST:event_d1KeyTyped

    private void c2FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_c2FocusGained
        c2.selectAll();
    }//GEN-LAST:event_c2FocusGained

    private void c1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_c1FocusGained
        c1.selectAll();
    }//GEN-LAST:event_c1FocusGained

    private void c2KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_c2KeyTyped
        char c = evt.getKeyChar();
        if (!(Character.isDigit(c) || c == 10)) {    //
            getToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_c2KeyTyped

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
            java.util.logging.Logger.getLogger(Supplier_Billing.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Supplier_Billing.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Supplier_Billing.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Supplier_Billing.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
                new Supplier_Billing("D:/Shopy/Shopy", "src/Icons/logo.png", "2020-2021", "10/01/2020", "31/12/2020").setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BShow;
    private javax.swing.JButton Bprint;
    private javax.swing.JTable btable;
    private javax.swing.JTextField c1;
    private javax.swing.JTextField c2;
    private javax.swing.JLabel cdflbl;
    private javax.swing.JLabel cdtklbl;
    private javax.swing.JLabel cdtolbl;
    private javax.swing.JButton creater;
    private com.toedter.calendar.JDateChooser d1;
    private com.toedter.calendar.JDateChooser d2;
    private javax.swing.JLabel dtflbl;
    private java.awt.Checkbox dtprnt;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton setting;
    private javax.swing.JTable table;
    private javax.swing.JLabel tklbl;
    private javax.swing.JLabel tolbl;
    // End of variables declaration//GEN-END:variables
}
