/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package shopyfinal;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class success {
/**
* The main program creates a window containing a HelloWorldDisplay
* and a button that will end the program when the user clicks it.
*/
public static void mainn(final String args, int x, int y) {
   int op=0;
JPanel displayPanel = new JPanel() {
// An anonymous subclass of JPanel that displays "Hello World!".
public void paintComponent(Graphics g) {
super.paintComponent(g);
g.drawString( args, 20, 30 );
}
};

JPanel content = new JPanel();
JButton okButton = new JButton("OK");
content.setLayout(new BorderLayout());
content.add(displayPanel, BorderLayout.CENTER);
content.add(okButton, BorderLayout.SOUTH);
final JFrame window = new JFrame("Successful !!");
window.setContentPane(content);
window.setSize(x,y);
window.setAlwaysOnTop(true);
window.setLocationRelativeTo(null);
/*try {
window.setIconImage(ImageIO.read(new File("C:\\Users\\Suthar\\Documents\\NetBeansProjects\\Positive\\src\\positive\\logo.jpg")));
} catch (IOException ex) {
Logger.getLogger(NewMenu.class.getName()).log(Level.SEVERE, null, ex);
}*/
window.setVisible(true);

okButton.addActionListener( new ActionListener() {      // ACTION OF OKAY BUTTON
public void actionPerformed(ActionEvent e) {
    window.dispose();
}
} );

}
}
