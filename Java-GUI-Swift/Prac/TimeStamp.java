
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

class TimeStamp implements ActionListener {
	
	JLabel jlab;
	JButton jbtn;

	TimeStamp() {

		JFrame jfrm = new JFrame("TimeStamp");
		jfrm.setSize(220, 90);
		jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		jbtn = new JButton("Stamp");
		jlab = new JLabel(" This is a sentence.");

		jfrm.add(jlab);
		jfrm.add(jbtn);

		jfrm.setVisible(true);



	}

	public void actionPerformed(ActionEvent ae) {
		Date d = new Date();

		if(ae.)

	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new TimeStamp();
			}
		});
	}
}