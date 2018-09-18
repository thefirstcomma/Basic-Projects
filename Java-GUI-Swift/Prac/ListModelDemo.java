import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;

class ListModelDemo {
	
	JList jlst;
	JLabel jlab;
	JScrollPane jscrlp;
	JButton jbtnBuy;
	JButton jbtnAddDel;

	ListModelDemo() {

		JFrame jfrm = new JFrame("JList ModelDemo");
		jfrm.setLayout(new FlowLayout());
		jfrm.setSize(180, 240);
		jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		DefaultListModel lm = new DefaultListModel();
		lm.addElement("Winesap");
		lm.addElement("Cortland");
		lm.addElement("Red Delicious");
		lm.addElement("Golden Delicious");
		lm.addElement("Gala");

		jlst = new JList(lm);

		jscrlp = new JScrollPane(jlst);
		jscrlp.setPreferredSize(new Dimension(120, 90));

		jlab = new JLabel("Please choose an apple");

		jlst.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent le) {
				String what = "";

				Object values[] = jlst.getSelectedValues();

				if(values.length == 0) {
					jlab.setText("Please choose an apple.");
					return;
				}

				for(int i = 0; i < values.length; i++) {
					what += values[i] + "<br>";
				}
				jlab.setText("<html>Current selection:<br>" + what);
			}
		});

		jbtnBuy = new JButton("Buy Apple");
		jbtnBuy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				String what = "";

				Object values[] = jlst.getSelectedValues();

				if(values.length == 0) {
					jlab.setText("NO apple has been selected.");
					return;
				}

				for(int i = 0; i < values.length; i++) {
					what += values[i] + "<br>";
				}
				jlab.setText("<html>Current selection:<br>" + what);
			}
		});

		jbtnAddDel = new JButton("Add More Varieties");
		jbtnAddDel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				DefaultListModel lm = (DefaultListModel) jlst.getModel();

				if(lm.getSize() > 5) {
					for(int i = 7; i > 4; i--) {
						lm.remove(i);
					}
					jbtnAddDel.setText("Add More Varieties");
				} else {
					lm.addElement("Fuji");
					lm.addElement("Granny Smith");
					lm.addElement("Jonathan");
					jbtnAddDel.setText("Remove Extra Varieties");
				}
			}
		});

		jfrm.add(jscrlp);
		jfrm.add(jbtnBuy);
		jfrm.add(jbtnAddDel);
		jfrm.add(jlab);

		jfrm.setVisible(true);

	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new ListModelDemo();
			}
		});
	}
}