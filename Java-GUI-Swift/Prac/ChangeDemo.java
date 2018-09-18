import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

class ChangeDemo {
	
	JButton jbtn;
	JLabel jlab;

	ChangeDemo() {
		JFrame jfrm = new JFrame("Button Change Events");

		jfrm.setLayout(new FlowLayout());

		jfrm.setSize(250, 160);
		jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		jlab = new JLabel();
		jbtn = new JButton("Press for Change Event Test");

		jbtn.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent ce) {
				ButtonModel mod = jbtn.getModel();

				String what = "";

				if(mod.isEnabled())
					what += "Enabled<br>";
				if(mod.isRollover())
					what += "Rollover<br>";
				if(mod.isArmed())
					what += "Armed<br>";
				if(mod.isPressed())
					what += "Pressed<br>";

				jlab.setText("<html>Current state:<br>" + what);
			}
		});

		jfrm.add(jbtn);
		jfrm.add(jlab);
		jfrm.setVisible(true);
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new ChangeDemo();
			}
		});
	}
}