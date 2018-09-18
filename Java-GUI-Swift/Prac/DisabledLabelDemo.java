
import javax.swing.*;
import java.awt.*;
import javax.swing.border.*;

class DisabledLabelDemo {
	
	DisabledLabelDemo() {
		JFrame jfrm = new JFrame("Use Images in Labels");

		jfrm.setLayout(new GridLayout(3, 1));

		jfrm.setSize(240, 250);

		jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		ImageIcon myIcon = new ImageIcon("myIcon.gif");
		ImageIcon myDisIcon = new ImageIcon("myDisIcon.gif");

		JLabel jlabIconText = new JLabel("This label is enabled.", myIcon, SwingConstants.CENTER);
		JLabel jlab2 = new JLabel("This label is disabled", myDisIcon, SwingConstants.CENTER);

		jlab2.setEnabled(false);

		JLabel jlab3 = new JLabel("Use the disabled icon.", myIcon, SwingConstants.CENTER);
		jlab3.setDisabledIcon(myDisIcon);
		jlab3.setEnabled(false);

		jfrm.add(jlabIconText);
		jfrm.add(jlab2);
		jfrm.add(jlab3);

		jfrm.setVisible(true);
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new DisabledLabelDemo();
			}
		});
	}
}