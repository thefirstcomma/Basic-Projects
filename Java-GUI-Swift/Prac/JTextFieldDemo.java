import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class JTextFieldDemo implements ActionListener {
	
	JTextField jtf;
	JLabel jlab;

	JTextFieldDemo() {
		JFrame jfrm = new JFrame("Insert fancy title here");

		jfrm.setLayout(new FlowLayout());

		jfrm.setSize(240, 90);

		jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		jtf = new JTextField(10);

		jtf.addActionListener(this);

		jfrm.add(jtf);

		jlab = new JLabel("");

		jfrm.add(jlab);
		jfrm.setVisible(true);
	}

	public void actionPerformed(ActionEvent ae) {
		jlab.setText("Current contents: " + jtf.getText() );
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new JTextFieldDemo();
			}
		});
	}
}