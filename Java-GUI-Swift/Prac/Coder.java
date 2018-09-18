import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class Coder implements ActionListener {

	JTextField jtfPlaintext;
	JTextField jtfCiphertext;

	Coder() {

		JFrame jfrm = new JFrame("Coder app");
		jfrm.setLayout(new FlowLayout());
		jfrm.setSize(340, 120);

		jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JLabel jlabPlaintext = new JLabel("  Plain Text: ");
		JLabel jlabCiphertext = new JLabel(" Cipher Text: ");

		jtfPlaintext = new JTextField(20);
		jtfCiphertext = new JTextField(20);

		jtfPlaintext.setActionCommand("Encode");
		jtfCiphertext.setActionCommand("Decode");

		jtfPlaintext.addActionListener(this);
		jtfCiphertext.addActionListener(this);

		jfrm.add(jlabCiphertext);
		jfrm.add(jlabPlaintext);
		jfrm.add(jtfCiphertext);
		jfrm.add(jtfPlaintext);

		JButton jbtnEncode = new JButton("Encode");
		JButton jbtnDecode = new JButton("Decode");
		JButton jbtnReset = new JButton("Reset");

		jbtnEncode.addActionListener(this);
		jbtnDecode.addActionListener(this);
		jbtnReset.addActionListener(this);

		jfrm.add(jbtnEncode);
		jfrm.add(jbtnDecode);
		jfrm.add(jbtnReset);

		jfrm.setVisible(true);
	}

	public void actionPerformed(ActionEvent ae) {

		if(ae.getActionCommand().equals("Encode")) {

			StringBuilder str = new StringBuilder(jtfPlaintext.getText());

			for(int i = 0; i < str.length(); i++) {
				str.setCharAt(i, (char)(str.charAt(i) + 1));
			}

			jtfCiphertext.setText(str.toString());
		} else if(ae.getActionCommand().equals("Decode")) {

			StringBuilder str = new StringBuilder(jtfCiphertext.getText());

			for(int i = 0; i < str.length(); i++) {
				str.setCharAt(i, (char)(str.charAt(i) - 1));
			}

			jtfPlaintext.setText(str.toString());
		} else {
			jtfPlaintext.setText("");
			jtfCiphertext.setText("");
		}
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new Coder();
			}
		});
	}
}