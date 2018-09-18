import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;

class IconLabelDemo {
	
	IconLabelDemo() {
		JFrame jfrm = new JFrame("Use Images in Labels");

		jfrm.getContentPane().setLayout(new GridLayout(4, 1));

		jfrm.setSize(250, 300);

		jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		ImageIcon myIcon = new ImageIcon("myIcon.gif");

		JLabel jlabIcon = new JLabel(myIcon);

		JLabel jlabIconTxt = new JLabel("Default Icon and Text Position", myIcon, SwingConstants.CENTER);
		JLabel jlabIconTxt2 = new JLabel("Text Left of Icon", myIcon, SwingConstants.CENTER);
		jlabIconTxt2.setHorizontalTextPosition(SwingConstants.LEFT);

		JLabel jlabIconTxt3 = new JLabel("Text Over Icon", myIcon, SwingConstants.CENTER);
		jlabIconTxt3.setVerticalTextPosition(SwingConstants.TOP);
		jlabIconTxt3.setHorizontalTextPosition(SwingConstants.CENTER);

		jfrm.add(jlabIcon);
		jfrm.add(jlabIconTxt);
		jfrm.add(jlabIconTxt2);
		jfrm.add(jlabIconTxt3);

		jfrm.setVisible(true);
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new IconLabelDemo();
			}
		});
	}
}