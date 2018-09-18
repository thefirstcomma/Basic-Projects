//
// Name:        Kim, Andrew
// Project:     #2
// Due:         03.07.2018
// Course:      CS-245-01-w18
//
// Description: A Java Swing class that opens up a Font Chooser.
//
//
 
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.event.*;
import java.lang.*;
 
public class JFontChooser {
 
    JDialog jdlg;
    Font font;
    Color color;
 	boolean selected = false;
 	int size;
 	int style;
 	String str;
 	JLabel jlabDisplay;
 	JList jlstFont;
 	JList jlstStyle;
 	JList jlstSize;
 
    public void setDefault(Font defaultFont) {
 		font = (defaultFont);
    }
 
    public void setDefault(Color defaultColor) {
 		color = (defaultColor);
    }
 
    public Font getFont() {
        return font;
    }
 
    public Color getColor() {
        return color;
    }
 
 
    public boolean showDialog(JFrame parent) {
    	selected = true;

        jdlg = new JDialog(parent, "Font Chooser", true);
        jdlg.setLayout(new GridLayout(3,2));
        jdlg.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        
        DefaultListModel fontList = new DefaultListModel();
        String fonts[] = GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();
 		font = new Font("Courier", Font.PLAIN, 12);
 		JPanel jpFont = new JPanel();
 		jpFont.setBorder(BorderFactory.createEtchedBorder());
 		JPanel jpStyle = new JPanel();
 		jpStyle.setBorder(BorderFactory.createEtchedBorder());
 		JPanel jpSize = new JPanel();
 		jpSize.setBorder(BorderFactory.createEtchedBorder());
 		JPanel jpPreview = new JPanel();
 		jpPreview.setLayout(new GridLayout(3,1));
 		JPanel jpButton = new JPanel();
 		jpButton.setLayout(new BorderLayout());

        for(int i = 0; i < fonts.length; i++) {
            fontList.addElement(fonts[i]);
        }
        jlstFont = new JList(fontList);
        jlstFont.setSelectedValue((Object) getFont().getFamily(), true);
        JScrollPane jscrlpFont = new JScrollPane(jlstFont);
        jscrlpFont.setPreferredSize(new Dimension (220, 90));
 
        DefaultListModel styleList = new DefaultListModel();
        styleList.addElement("Plain");
        styleList.addElement("Bold");
        styleList.addElement("Italic");
        styleList.addElement("Bold Italic");
 
        jlstStyle = new JList(styleList);
        jlstStyle.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        //jlstStyle.setSelectedValue(0);
        JScrollPane jscrlpStyle = new JScrollPane(jlstStyle);
        jscrlpStyle.setPreferredSize(new Dimension(150, 80));
 
        DefaultListModel sizeList = new DefaultListModel();
        sizeList.addElement("8");
        sizeList.addElement("9");
        sizeList.addElement("10");
        sizeList.addElement("11");
        sizeList.addElement("12");
        sizeList.addElement("14");
        sizeList.addElement("16");
        sizeList.addElement("18");
        sizeList.addElement("20");
        sizeList.addElement("24");
        sizeList.addElement("26");
        sizeList.addElement("28");
        sizeList.addElement("32");
        sizeList.addElement("34");
        sizeList.addElement("36");
        sizeList.addElement("48");
        sizeList.addElement("72");
 
        jlstSize = new JList(sizeList);
        jlstSize.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        JScrollPane jscrlpSize = new JScrollPane(jlstSize);
        jscrlpSize.setPreferredSize(new Dimension(120, 88));
 
        JLabel jlabFont = new JLabel("Font");
        jlabFont.setDisplayedMnemonic('F');
        JLabel jlabSize = new JLabel("Size");
        jlabSize.setDisplayedMnemonic('S');
        JLabel jlabStyle = new JLabel("Style");
        jlabStyle.setDisplayedMnemonic('y');
        JLabel jlabColor = new JLabel("Color");
        JLabel jlabPreview = new JLabel("<html></br>Preview</br></html>");
        jlabDisplay = new JLabel("  AaBbYyZz  ");
        jlabDisplay.setBorder(BorderFactory.createEtchedBorder());
 
 
 		JButton jbtnColor = new JButton("Choose a Font Color");
        JButton jbtnOK = new JButton("OK");
        JButton jbtnCancel = new JButton("Cancel");

        jlstFont.addListSelectionListener(new ListSelectionListener() {
        	public void valueChanged(ListSelectionEvent le) {
        		str = "";
				Object values[] = jlstFont.getSelectedValues();

				for(int i = 0; i < values.length; i++) {
					str += values[i];
				}
        		jlabDisplay.setFont(cleaner());
        	}
        });

        jlstStyle.addListSelectionListener(new ListSelectionListener() {
        	public void valueChanged(ListSelectionEvent le) {
        		style = jlstStyle.getSelectedIndex();
        		jlabDisplay.setFont(cleaner());
        	}
        });

        jlstSize.addListSelectionListener(new ListSelectionListener() {
        	public void valueChanged(ListSelectionEvent le) {
        		size = Integer.parseInt((String)jlstSize.getSelectedValue());
        		jlabDisplay.setFont(cleaner());
        		
        	}
        });

        jbtnColor.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent ae) {
        		color = JColorChooser.showDialog(jdlg, "Font Color", Color.BLACK);
        		jlabDisplay.setForeground(color);
        	}
        });
 
        jbtnOK.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
            	font = cleaner();
                jdlg.setVisible(false);
                selected = true;
            }
        });
 
        jbtnCancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                jdlg.setVisible(false);
                selected = false;
            }
        });
 
        jdlg.setSize(550,450);
        jlstFont.ensureIndexIsVisible(jlstFont.getSelectedIndex());
        jlstSize.ensureIndexIsVisible(jlstSize.getSelectedIndex());
        jlstStyle.ensureIndexIsVisible(jlstStyle.getSelectedIndex());


 		jpFont.add(jlabFont);
 		jpFont.add(jscrlpFont);

 		jpStyle.add(jlabStyle);
 		jpStyle.add(jscrlpStyle);

 		jpSize.add(jlabSize);
 		jpSize.add(jscrlpSize);

 		jpPreview.add(jbtnColor);
 		jpPreview.add(jlabPreview);
 		jpPreview.add(jlabDisplay);


    	jpButton.add(jbtnOK, BorderLayout.WEST);
    	jpButton.add(jbtnCancel, BorderLayout.EAST);

        jdlg.add(jpFont);
        jdlg.add(jpStyle);
        jdlg.add(jpSize);
        jdlg.add(jpPreview);
        jdlg.add(jpButton);
 
 		jdlg.setLocationRelativeTo(parent);
        jdlg.setVisible(true);

        return selected;
    }

    public Font cleaner() {
		
		switch(style) {
			case 0:
				style = Font.PLAIN;
				break;
			case 1:
				style = Font.ITALIC;
				break;
			case 2:
				style = Font.BOLD;
				break;
			case 3:
				style = Font.BOLD + Font.ITALIC;
				break;
		}

		Font f = new Font(str, style, size);
		return f;
    }
}