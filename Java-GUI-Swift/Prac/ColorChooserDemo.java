import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

class ColorChooserDemo {
	
	JLabel jlab;
	JButton jbtnShow;

	ColorChooserDemo() {
		JFrame jfrm = new JFrame("SSSSS");

		jfrm.setLayout(new FlowLayout());
		jfrm.setSize(400, 200);

		jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		jlab = new JLabel();

		jbtnShow = new JButton("Show Color Chooser");

		jbtnShow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				Color color = JColorChooser.showDialog(null, "Choose color", Color.RED);
				if(color != null) {
					jlab.setText("Selected color is" + color.toString());
				} else {
					jlab.setText("Color selection was cancelled.");
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
				new ColorChooserDemo();
			}
		});
	}
}