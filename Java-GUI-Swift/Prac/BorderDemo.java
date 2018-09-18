import java.awt.*;
import javax.swing.*;

class BorderDemo {
	
	BorderDemo() {

		JFrame jfrm = new JFrame("Border Demo :D");
		jfrm.setSize(280, 90);

		jfrm.setLayout(new FlowLayout());

		jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JLabel jlab = new JLabel("This uses a line border");
		jlab.setBorder(BorderFactory.createLineBorder(Color.BLACK));

		JLabel jlab2 = new JLabel(" This uses an etched border. ");
		jlab2.setBorder(BorderFactory.createEtchedBorder());

		jfrm.add(jlab);
		jfrm.add(jlab2);

		jfrm.setVisible(true);
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new BorderDemo();
			}
		});
	}
}