import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class TwoTFDemo implements ActionListener {
	
	JTextField jtf1;
	JTextField jtf2;
	JLabel jlab;

	TwoTFDemo() {
		JFrame jfrm = new JFrame("TwoTFDemo demo");
		jfrm.setLayout(new FlowLayout());
		jfrm.setSize(240, 120);
		jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		jtf1 = new JTextField(10);
		jtf2 = new JTextField(10);

		jtf1.setActionCommand("One");
		jtf2.setActionCommand("Two");

		jtf1.addActionListener(this);
		jtf2.addActionListener(this);

		jlab1.setDisplayedMnemonic('e');
		jlab2.setDisplayedMnemonic('n');

		jfrm.add(jtf1);
		jfrm.add(jtf2);

		jlab = new JLabel("");
		jfrm.add(jlab);
		jfrm.setVisible(true);
	}

	public void actionPerformed(ActionEvent ae) {
		if(ae.getActionCommand().equals("One"))
			jlab.setText("Enter pressed in jtf1: " + jtf1.getText());
		else
			jlab.setText("Enter pressed in jtf2: " + jtf2.getText());
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new TwoTFDemo();
			}
		});
	}
}