import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Example implements ActionListener{

	JLabel jlab;
	
	Example() {

		// This is the tile of the Java app.
		JFrame jfrm = new JFrame("Insert fancy title here.");
		// set Sizer of the Java app.
		jfrm.setSize(275, 100);

		//Specify FlowLayout
		jfrm.getContentPane().setLayout(new FlowLayout());

		// makes 2 buttons
		JButton jbtnFirst = new JButton("First");
		JButton jbtnSecond = new JButton("Second");

		// add action listeners to buttons
		jbtnFirst.addActionListener(this);
		jbtnSecond.addActionListener(this);

		// name the jlabel
		jlab = new JLabel(" Swing powers me");

		// Adds the jlabel/jButtons onto the content pane.
		jfrm.getContentPane().add(jlab);
		// ORDER MATTERS HERE
		jfrm.getContentPane().add(jbtnSecond);
		jfrm.getContentPane().add(jbtnFirst);

		

		// Truly Exit on Close
		jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// Set Visibility
		jfrm.setVisible(true);

	}

	public void actionPerformed(ActionEvent ae) {
		if(ae.getActionCommand().equals("First"))
			jlab.setText("First pressed");
		else
			jlab.setText("Second pressed");
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new Example();
			}
		});
	}
}