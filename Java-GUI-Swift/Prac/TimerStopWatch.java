import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Calendar;

class TimerStopWatch implements ActionListener{
	
	JLabel jlab;
	JButton jbtnStart;
	JButton jbtnStop;
	long start;
	Timer swTimer;

	TimerStopWatch(){
		JFrame jfrm = new JFrame("Timer-based Stopwatch");
		jfrm.setLayout(new FlowLayout());

		jfrm.setSize(230, 90);

		jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		jlab = new JLabel("Press Start to begin Timing");

		jbtnStart = new JButton("Start");
		jbtnStop = new JButton("Stop");
		jbtnStop.setEnabled(false);

		ActionListener timerAL = new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				long temp = Calendar.getInstance().getTimeInMillis();
				jlab.setText("Elapsed time is " + (double)(temp - start)/1000);
			}
		};

		swTimer = new Timer(100, timerAL);

		jbtnStart.addActionListener(this);
		
		jbtnStop.addActionListener(this);

		jfrm.add(jbtnStart);
		jfrm.add(jbtnStop);
		jfrm.add(jlab);

		jfrm.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		if(ae.getActionCommand().equals("Stop")) {
			long stop = Calendar.getInstance().getTimeInMillis();

			jlab.setText("Elapsed time is " + (double)(stop - start)/1000);

			jbtnStart.setEnabled(true);
			jbtnStop.setEnabled(false);

			swTimer.stop();
		} else if (ae.getActionCommand().equals("Start")) {
			start = Calendar.getInstance().getTimeInMillis();

			jbtnStop.setEnabled(true);
			jbtnStart.setEnabled(false);

			swTimer.start();
		} 

		
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new TimerStopWatch();
			}
		});
	}
}