//
// Name:		Kim, Andrew
// Project:		#EXTRA 1
// Due:			03.12.2018
// Course: 		cs-245-01-w18
//
// Description: A slideshow application with java swing.
//
//
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class JSlideshow {

	
	JSlideshow() {
		JFrame jfrm = new JFrame("Slideshow");
		jfrm.setSize(800, 1000);
		jfrm.setLayout(new FlowLayout());
		jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JButton jbPlay = new JButton("Play");
		JButton jbPause = new JButton("Pause");

		JMenuBar jmb = new JMenuBar();
		JMenu jmFile = new JMenu("File");
		jmFile.setMnemonic('F');
		JMenu jmLoad = new JMenu("Load", 'L');
		JMenuItem jmiAbout = new JMenuItem("About", 'A');
		JMenuItem jmiExit = new JMenuItem("Exit", 'E');
		JMenuItem jmiFileName = new JMenuItem("Local File Name");
		JMenuItem jmiURL = new JMenuItem("URL");

		jmLoad.add(jmiFileName);
		jmLoad.add(jmiURL);

		Timer t = new Timer(500, new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int x = 0;
				ImageIcon icon = new ImageIcon(list[x]);
		        Image img = icon.getImage();
		        Image newImg = img.getScaledInstance(jlab.getWidth(), jlab.getHeight(), Image.SCALE_SMOOTH);
		        ImageIcon newImc = new ImageIcon(newImg);
		        jlab.setIcon(newImc);
		        x++;

		        if(x >= list.length) {
		        	x = 0;
		        }
			}
		});

		jbPlay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {

			}
		});

		jbPause.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				
			}
		});

		jmiFileName.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {

			}
		});

		jmiAbout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {

        		JDialog jdlg = new JDialog(jfrm, "About this JSlideshow", true);
        		jdlg.setLayout(new FlowLayout());
        		jdlg.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        		JLabel jlab = new JLabel("(c) Andrew Kim 2018");
        		JButton jbtn = new JButton("OK");

        		jbtn.addActionListener(new ActionListener() {
        			public void actionPerformed(ActionEvent ae) {
        				jdlg.dispose();
        			}
        		});

        		jdlg.setSize(200, 100);

        		jdlg.add(jlab);
        		jdlg.add(jbtn);

        		jdlg.setLocationRelativeTo(jfrm);
        		jdlg.setVisible(true);
			}
		});

		jmiExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				System.exit(0);
			}
		});

		jmFile.add(jmLoad);
		jmFile.addSeparator();
		jmFile.add(jmiAbout);
		jmFile.add(jmiExit);

		jmb.add(jmFile);

		JLabel jlab = new JLabel("Press File, Load to start the Slideshow");
		jlab.setBounds(40, 30, 700, 300);

		t.start();

		jfrm.add(jbPause);
		jfrm.add(jbPlay);
		jfrm.add(jlab);
		jfrm.setJMenuBar(jmb);
		jfrm.setVisible(true);
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new JSlideshow();
			}
		});
	}
}