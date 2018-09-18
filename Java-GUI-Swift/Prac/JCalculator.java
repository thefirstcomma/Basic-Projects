//
// Name:        Kim, Andrew
// Project:     1
// Due:         1.31.2018
// Course:      CS-245-01-w18
//
// Description:
//              A basic integer calculator.
//

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class JCalculator implements ActionListener, KeyListener{

    JButton[] jbtn = new JButton[16];
    JTextField jtf;
    JFrame jfrm;
    long temp, result;
    boolean cont, shift, equaled = false;
    int operation, counter = 1;

    JCalculator() {

        jfrm = new JFrame("Calculator");
        jtf = new JTextField(10);
        Font font1 = new Font("SansSerif", Font.BOLD, 30);
        jtf.setFont(font1);
        jtf.setHorizontalAlignment(SwingConstants.RIGHT);
        JPanel jbord = new JPanel(new BorderLayout());
		JPanel jgrid = new JPanel(new GridLayout(4,4));

		Dimension buttonSize = new Dimension(300, 270);
		jgrid.setPreferredSize(buttonSize);

        jbtn[0] = new JButton("7");
        jbtn[1] = new JButton("8");
        jbtn[2] = new JButton("9");
        jbtn[3] = new JButton("/");

        jbtn[4] = new JButton("4");
        jbtn[5] = new JButton("5");
        jbtn[6] = new JButton("6");
        jbtn[7] = new JButton("*");

        jbtn[8] = new JButton("1");
        jbtn[9] = new JButton("2");
        jbtn[10] = new JButton("3");
        jbtn[11] = new JButton("-");

        jbtn[12] = new JButton("C");
        jbtn[13] = new JButton("0");
        jbtn[14] = new JButton("=");
        jbtn[15] = new JButton("+");

        for (int i = 0; i < 16; i++) {
			jgrid.add(jbtn[i]);
			jbtn[i].addActionListener(this);
			jbtn[i].addKeyListener(this);
		}

		jfrm.addKeyListener(this);
		jbord.addKeyListener(this);
		jgrid.addKeyListener(this);

        jfrm.setSize(350, 450);

        jbord.add(jtf, BorderLayout.NORTH);
        jbord.add(jgrid, BorderLayout.SOUTH);
		jfrm.add(jbord, BorderLayout.CENTER);

        // default enter key is set to '='
        JRootPane rootPane = jfrm.getRootPane();
        rootPane.setDefaultButton(jbtn[14]);
        // adds icon as long as is inside directory
        Image icon = Toolkit.getDefaultToolkit().getImage("JCalculator.png");
        jfrm.setIconImage(icon);

        jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jfrm.setLocationRelativeTo(null);
        jfrm.setResizable(false);
        jfrm.setVisible(true);

    }


    public void actionPerformed(ActionEvent ae) {

    	if(equaled) {
    		jtf.setText("");
    		equaled = false;
    	}


    	if((jtf.getText().length() < 10)) {

    		if(ae.getActionCommand().equals("1"))
		        jtf.setText(jtf.getText().concat("1"));
		    if(ae.getActionCommand().equals("2"))
		        jtf.setText(jtf.getText().concat("2"));
		    if(ae.getActionCommand().equals("3"))
		        jtf.setText(jtf.getText().concat("3"));
		    if(ae.getActionCommand().equals("4"))
		        jtf.setText(jtf.getText().concat("4"));
		    if(ae.getActionCommand().equals("5"))
		        jtf.setText(jtf.getText().concat("5"));
		    if(ae.getActionCommand().equals("6"))
		        jtf.setText(jtf.getText().concat("6"));
		    if(ae.getActionCommand().equals("7"))
		        jtf.setText(jtf.getText().concat("7"));
		    if(ae.getActionCommand().equals("8"))
		        jtf.setText(jtf.getText().concat("8"));
		    if(ae.getActionCommand().equals("9"))
		        jtf.setText(jtf.getText().concat("9"));
		    if(ae.getActionCommand().equals("0"))
		        jtf.setText(jtf.getText().concat("0"));
    	}

        if(ae.getActionCommand().equals("+")) {
            temp = Long.parseLong(jtf.getText());
            operation = 1;
            jtf.setText("");
        }
        if(ae.getActionCommand().equals("/")) {
            temp = Long.parseLong(jtf.getText());
            operation = 2;
            jtf.setText("");
        }
        if(ae.getActionCommand().equals("-")) {
            temp = Long.parseLong(jtf.getText());
            operation = 3;
            jtf.setText("");
        }
        if(ae.getActionCommand().equals("*")) {
            temp = Long.parseLong(jtf.getText());
            operation = 4;
            jtf.setText("");
        }

        if(ae.getActionCommand().equals("C")) {
            jtf.setText("");
            able();

            if(cont && shift) {
            	jtf.setText("(c) 2018 Andrew Kim");
            	disable();
            }
        }

        if(ae.getActionCommand().equals("=")) {

        	equaled = true;
            // checks for div by 0 error
            if(operation == 2 && jtf.getText().equals("0")) {
                jtf.setText("Div by 0 Error");
                disable();
            }

            switch(operation) {
                case 1: result = temp + Long.parseLong(jtf.getText());
                        break;
                case 2: result = temp / Long.parseLong(jtf.getText());
                        break;
                case 3: result = temp - Long.parseLong(jtf.getText());
                        break;
                case 4: result = temp * Long.parseLong(jtf.getText());
                        break;
                default: jtf.setText("" + temp);
            }

            if(Long.toString(result).length() > 10) {
            	jtf.setText("Overflow");
        		disable();
        		temp = 0;
        		result = 0;
            } else {
            	jtf.setText("" + result);
        	}
        }
    }

    public void able() {

    	for(int i = 0; i < 16; i++) {
    		jbtn[i].setEnabled(true);
    	}

        jtf.setText("");
        temp = 0;
    }


    public void disable() {

        jbtn[0].setEnabled(false);
        jbtn[1].setEnabled(false);
        jbtn[2].setEnabled(false);
        jbtn[3].setEnabled(false);
        jbtn[4].setEnabled(false);
        jbtn[5].setEnabled(false);
        jbtn[6].setEnabled(false);
        jbtn[7].setEnabled(false);
        jbtn[8].setEnabled(false);
        jbtn[9].setEnabled(false);
        jbtn[10].setEnabled(false);
        jbtn[11].setEnabled(false);
        jbtn[13].setEnabled(false);
        jbtn[14].setEnabled(false);
        jbtn[15].setEnabled(false);
        jbtn[12].setEnabled(true);
    }

    public void keyPressed(KeyEvent ke) {
		if (ke.isControlDown()) {
			cont = true;
		}
		if (ke.isShiftDown()) {
			shift = true;
		}
		
	}

	public void keyReleased(KeyEvent ke) {
		if (!ke.isControlDown()) {
			cont = false;
		}
		if (!ke.isShiftDown()) {
			shift = false;
		}
		
	}

	public void keyTyped(KeyEvent e) {}

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new JCalculator();
            }
        });
    }
}