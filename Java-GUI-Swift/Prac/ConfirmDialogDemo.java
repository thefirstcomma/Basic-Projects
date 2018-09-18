import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class ConfirmDialogDemo {
	JLabel jlab;
	JButton jbtnShow;
	JFrame jfrm;

	ConfirmDialogDemo() {
		jfrm = new JFrame("Heljwljwojwo");

		jfrm.setLayout(new FlowLayout());

		jfrm.setSize(400, 250);

		jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		jlab = new JLabel();

		jbtnShow = new JButton("Show Dialog");

		jbtnShow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				int response = JOptionPane.showConfirmDialog(jfrm, "Remove unused files?");

				switch(response) {
					case JOptionPane.YES_OPTION:
						jlab.setText("You answered YES");
						break;
					case JOptionPane.NO_OPTION:
						jlab.setText("You answered NO");
						break;
					case JOptionPane.CANCEL_OPTION:
						jlab.setText("Cancel pressed");
						break;
					case JOptionPane.CLOSED_OPTION:
						jlab.setText("Dialog closed w/o response");
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
				new ConfirmDialogDemo();
			}
		});
	}
}