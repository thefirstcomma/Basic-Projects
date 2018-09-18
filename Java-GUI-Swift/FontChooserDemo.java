//
// Name:        Kim, Andrew
// Project:     #2
// Due:         03.07.2018
// Course:      CS-245-01-w18
//
// Description: A Java Swing class that opens up a Font Chooser.
//
//
 
import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;
 
public class FontChooserDemo {
 
    JFrame jfrm;
 
    FontChooserDemo() {
        jfrm = new JFrame("Demo for Font");
        jfrm.setLayout(new GridLayout(3, 1));
        jfrm.setSize(450, 250);
        jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 
        JButton jbtn = new JButton("Font Menu Button in NotePad");
 
 
        JFontChooser jfontc = new JFontChooser();
 
 		// Testing, don't need separate font object to make, but
		// does need it to pass as parameters for setDefault(Font font);
        Font f = new Font("Courier", 12, Font.PLAIN);
        Color col = new Color(0xFF, 0xFF, 0xFF);
        jfontc.setDefault(f);
		jfontc.setDefault(col);

		

        JLabel jlabFont = new JLabel("Value Returned for Font:");
        JLabel jlabColor = new JLabel("Value Returned for Color");
 

        jbtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                if(jfontc.showDialog(jfrm)) {
                	jlabFont.setText("Font returned is: " + jfontc.getFont().getFamily() 
                	+ "   Style: " +  jfontc.getFont().getStyle() +  "   Size: " + jfontc.getFont().getSize());
                	jlabColor.setText("Color returned is:  Red: " + jfontc.getColor().getRed() + 
                		" Green: " + jfontc.getColor().getGreen() + " Blue: " + jfontc.getColor().getBlue());

                	System.out.println(jfontc.getFont());
        			System.out.println(jfontc.getColor());
                }
            }
        });

        
 		jfrm.add(jlabFont);
 		jfrm.add(jlabColor);
        jfrm.add(jbtn);

        jfrm.setLocationRelativeTo(null);
        jfrm.setVisible(true);
    }
 
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new FontChooserDemo();
            }
        });
 
    }
 
}