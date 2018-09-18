import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class InputDialogDemo {
	JLabel jlab;
	JButton jbtnShow;
	JFrame jfrm;

	InputDialogDemo() {
		jfrm = new JFrame("SSS");

		jfrm.setLayout(new FlowLayout());

		jfrm.setSize(400, 250);
		jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jlab = new JLabel();

		jbtnShow = new JButton("Show Dialog");

		jbtnShow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent le) {
				String response = JOptionPane.showInputDialog("Enter Name");

				if(response == null) {
					jlab.setText("Dialog cancelled or closed");

				} else if(response.length() == 0) {
					jlab.setText("No String entered");

				} else {
					jlab.setText("Hi there: " + response);
				}
			}
		});

		jfrm.add(jbtnShow);
		jfrm.add(jlab);
		jfrm.setVisible(true);
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new InputDialogDemo();
			}
		});
	}
}