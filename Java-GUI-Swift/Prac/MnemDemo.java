import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class MnemDemo {
	
	MnemDemo() {
		JFrame jfrm = new JFrame("Demo of Mnem");

		jfrm.setLayout(new FlowLayout());

		jfrm.setSize(260, 140);

		jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JLabel jlab1 = new JLabel("E-mail Address");
		JLabel jlab2 = new JLabel("Name");

		jlab1.setDisplayedMnemonic('e');
		jlab2.setDisplayedMnemonic('n');

		JTextField jtf1 = new JTextField(20);
		JTextField jtf2 = new JTextField(20);

		jlab1.setLabelFor(jtf1);
		jlab2.setLabelFor(jtf2);

		jtf1.setActionCommand("jtf1");
		jtf2.setActionCommand("jtf2");

		jfrm.add(jlab1);
		jfrm.add(jtf1);
		jfrm.add(jlab2);
		jfrm.add(jtf2);

		jfrm.setVisible(true);

	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new MnemDemo();
			}
		});
	}
}