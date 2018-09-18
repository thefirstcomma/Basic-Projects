import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.util.*;

class SpinDates {
	JSpinner jspin;
	JLabel jlab;

	SpinDates() {
		JFrame jfrm = new JFrame("Spin Dates");
		jfrm.setLayout(new FlowLayout());
		jfrm.setSize(300, 120);

		jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		GregorianCalendar g = new GregorianCalendar();

		Date curDate = new Date();

		g.add(Calendar.MONTH, -1);
		Date begin = g.getTime();
		g.add(Calendar.MONTH, 2);
		Date end = g.getTime();

		SpinnerDateModel spm = new SpinnerDateModel(curDate, begin, end, Calendar.HOUR);
		jspin = new JSpinner(spm);

		jlab = new JLabel(" Selected date is: " + curDate);

		jspin.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent ce) {
				Date date = (Date) jspin.getValue();
				jlab.setText(" Selected date is: " + date);
			}
		});

		jfrm.add(jspin);
		jfrm.add(jlab);

		jfrm.setVisible(true);
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new SpinDates();
			}
		});
	}
}