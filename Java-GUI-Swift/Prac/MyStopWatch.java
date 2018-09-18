import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class MyStopWatch implements ActionListener{
	
	JLabel jlab;
	JButton jbtn;
	long start;

	MyStopWatch() {
		JFrame jfrm = new JFrame("My stopwatch");
		jfrm.setLayout(new FlowLayout());
		jfrm.setSize(230, 90);

		jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		jbtn = new JButton("Start");
		jbtn.addActionListener(this);

		jlab = new JLabel("Start/Stop toggle");

		jfrm.add(jlab);
		jfrm.add(jbtn);
		jfrm.setVisible(true);

	}

	public void actionPerformed(ActionEvent ae) {
		Calendar cal = Calendar.getInstance();

		if(ae.getActionCommand().equals("Start")) {
			start = cal.getTimeInMillis();
			jbtn.setText("Stop");
		} else if(ae.getActionCommand().equals("Stop")) {
			jlab.setText("Elapsed time is " + (double) (cal.getTimeInMillis() - start) / 1000);
			jbtn.setText("Start");
			start = 0;
		}

	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new MyStopWatch();
			}
		});
	}
}