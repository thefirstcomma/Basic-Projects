
import javax.swing.*;
import javax.swing.event.*;
import java.awt.event.*;
import java.awt.*;

public class Lion implements ActionListener{

	JLabel jlab;
	
	ImageIcon lionImage;
	ImageIcon dogImage;
	
	Lion() {

		JFrame jfrm = new JFrame("Swing Demo");
		
		jfrm.setLayout(new FlowLayout());
		lionImage = new ImageIcon("lion.jpg");
		dogImage = new ImageIcon("dog.jpg");

		jlab = new JLabel(lionImage);

		jfrm.setSize(500, 400);

		jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		KeyStroke keyStrokeChange = KeyStroke.getKeyStroke(KeyEvent.VK_F, KeyEvent.CTRL_DOWN_MASK);

		JMenuBar jmb = new JMenuBar();
		JMenu jmView = new JMenu("View");
		jmView.setMnemonic(KeyEvent.VK_V);
		JMenu jmAbout = new JMenu("About");
		jmAbout.setMnemonic(KeyEvent.VK_A);

		JMenuItem jmiChange = new JMenuItem("Change");
		JMenuItem jmiColors = new JMenuItem("Colors");
		jmView.add(jmiColors);
		jmView.addSeparator();
		jmView.add(jmiChange);
		jmiChange.setAccelerator(keyStrokeChange);


		JMenuItem jmiHelp = new JMenuItem("Help");
		JMenuItem jmiInfo = new JMenuItem("Info");
		jmAbout.add(jmiHelp);
		jmAbout.add(jmiInfo);

		jmiChange.addActionListener(this);
		jmiInfo.addActionListener(this);


		jmb.add(jmView);
		jmb.add(jmAbout);

		jfrm.add(jlab);
		jfrm.setJMenuBar(jmb);
		jfrm.setVisible(true);
		
	}

	public void actionPerformed(ActionEvent ae) {
		String menuInput = ae.getActionCommand();

		if(menuInput == "Change") {
			if(jlab.getIcon() == lionImage) {
				jlab.setIcon(dogImage);
			} else {
				jlab.setIcon(lionImage);
			}
		} else if(menuInput == "Info") {
			JOptionPane.showMessageDialog(null, "(c). Andrew Kim 2018", "Information", JOptionPane.QUESTION_MESSAGE, lionImage);
		}
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new Lion();
			}
		});
	}
}