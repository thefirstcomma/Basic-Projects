import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

class OptionDialogDemo {
	
	JLabel jlab;
	JButton jbtnShow;
	JFrame jfrm;

	OptionDialogDemo() {
		jfrm = new JFrame("SSSS");

		jfrm.setLayout(new FlowLayout());

		jfrm.setSize(400, 250);

		jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		jlab = new JLabel();

		jbtnShow = new JButton("Show Dialog");

		jbtnShow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				String[] connect = {"Modem", "Wireless", "Satellite", "Cable"};
				int response = JOptionPane.showOptionDialog(jfrm, "Choose One", "Connection Type", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, connect, "Wireless");

				switch(response) {
					case 0:
						jlab.setText("Connect via modem.");
						break;
					case 1:
						jlab.setText("Connect via wireless.");
						break;
					case 2:
						jlab.setText("Connect via satellite.");
						break;
					case 3:
						jlab.setText("Connect via cable.");
						break;
					case JOptionPane.CLOSED_OPTION:
						jlab.setText("Dialog Cancelled.");
						break;
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
				new OptionDialogDemo();
			}
		});
	}
}