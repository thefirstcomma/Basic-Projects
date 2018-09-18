import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class FileChooserDemo {
	
	JLabel jlab;
	JButton jbtnShow;
	JFileChooser jfc;

	FileChooserDemo () {
		JFrame jfrm = new JFrame("SSS");
		jfrm.setLayout(new FlowLayout());
		jfrm.setSize(400, 200);
		jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		jlab = new JLabel();

		jbtnShow = new JButton("Show File Chooser");

		jfc = new JFileChooser();

		jbtnShow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				int result = jfc.showOpenDialog(null);

				if(result == JFileChooser.APPROVE_OPTION) 
					jlab.setText("Selected file is: " + jfc.getSelectedFile());
				else
					jlab.setText("No file selected.");
			}
		});

		jfrm.add(jbtnShow);
		jfrm.add(jlab);

		jfrm.setVisible(true);
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new FileChooserDemo();
			}
		});
	}
}