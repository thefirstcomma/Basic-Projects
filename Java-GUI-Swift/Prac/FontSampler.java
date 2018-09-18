//
// Name:        Kim, Alex
// Homework:    2
// Due:         2.12.2018
// Course:      cs-245-01-w18
//
// Description:
//              A simple font viewer.
//

import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;

class FontSampler {

	JList jlst;
	JLabel jlabs;
	JTextField jtf;
	JScrollPane jscrlp;

	public FontSampler() {
		this(null);
	}

	public FontSampler(String sampleText) {


	   JFrame jfrm = new JFrame("Font Sampler");
	   jfrm.setLayout(new FlowLayout());
	   jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	   jfrm.setSize(240, 360);
	   String fonts[] = GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();
	   DefaultListModel lm = new DefaultListModel();

	   for(int i = 0; i < fonts.length; i++) {
	   		lm.addElement(fonts[i]);
	   }

	   jlst = new JList(lm);
	   jscrlp = new JScrollPane(jlst);
	   jscrlp.setPreferredSize(new Dimension(220, 90));
	   jtf = new JTextField(16);
	   JLabel jlabSample = new JLabel("Sample text: ");
	   JLabel jlabFont = new JLabel("Fonts: ");
	   jlabs = new JLabel(sampleText != null ? sampleText : "Andrew Kim");

	   jtf.setActionCommand("text");

	   jlst.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent le) {
				String str = "";
				Object values[] = jlst.getSelectedValues();

				for(int i = 0; i < values.length; i++) {
					str += values[i];
				}

				jlabs.setFont(new Font(str, Font.PLAIN, 32));
			}
		});

	   jtf.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {

			   if(ae.getActionCommand().equals("text")) {
			   		jlabs.setText(jtf.getText());
			   }
			}
		});

	   jlabs.setFont(new Font("Al Bayan", Font.PLAIN, 32));

	   jfrm.add(jlabSample);
	   jfrm.add(jtf);
	   jfrm.add(jlabFont);
	   jfrm.add(jscrlp);
	   jfrm.add(jlabs);

	   jfrm.setLocationRelativeTo(null);
	   jfrm.setVisible(true);

	}


	public static void main(String[] args) {
	   SwingUtilities.invokeLater(new Runnable() {
	       public void run() {
	           new FontSampler(args.length != 0 ? args[0] : null );
	       }
	   });
	}

}

