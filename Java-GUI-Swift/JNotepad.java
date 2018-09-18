//
// Name:        Kim, Andrew
// Project:     #3
// Due:         03.12.2018
// Course:      CS-245-01-w18
//
// Description: A simple copy of the Windows notepad program.
//
//
 
import java.awt.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.filechooser.*;
import javax.swing.text.*;
import java.awt.event.*;
import java.util.*;
import java.io.*;
import java.text.*;
 
class JNotepad{

	JFrame jfrm;
	JTextArea jta;
	JFileChooser jf;
	Font font;
	Color color;
	boolean documentChanged;
 
    JNotepad() {
 
        jfrm = new JFrame("untitled");
        jfrm.setLayout(new BorderLayout());
        jfrm.setSize(800, 1000);
        jfrm.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        documentChanged = false;
 
        jf = new JFileChooser();
        
        jf.setFileFilter(new FileNameExtensionFilter("TEXT FILES", "txt", "text"));
        jf.setFileFilter(new FileNameExtensionFilter("JAVA FILES", "java"));
 
        JMenuBar jmb = new JMenuBar();

        KeyStroke ksNew = KeyStroke.getKeyStroke(KeyEvent.VK_N, KeyEvent.CTRL_DOWN_MASK);
        KeyStroke ksOpen = KeyStroke.getKeyStroke(KeyEvent.VK_O, KeyEvent.CTRL_DOWN_MASK);
        KeyStroke ksSave = KeyStroke.getKeyStroke(KeyEvent.VK_S, KeyEvent.CTRL_DOWN_MASK);
        KeyStroke ksPrint = KeyStroke.getKeyStroke(KeyEvent.VK_P, KeyEvent.CTRL_DOWN_MASK);
        KeyStroke ksCut = KeyStroke.getKeyStroke(KeyEvent.VK_X, KeyEvent.CTRL_DOWN_MASK);
        KeyStroke ksCopy = KeyStroke.getKeyStroke(KeyEvent.VK_C, KeyEvent.CTRL_DOWN_MASK);
        KeyStroke ksPaste = KeyStroke.getKeyStroke(KeyEvent.VK_V, KeyEvent.CTRL_DOWN_MASK);
        KeyStroke ksDelete = KeyStroke.getKeyStroke(KeyEvent.VK_DELETE, 0);
        KeyStroke ksFind = KeyStroke.getKeyStroke(KeyEvent.VK_F, KeyEvent.CTRL_DOWN_MASK);
        KeyStroke ksReplace = KeyStroke.getKeyStroke(KeyEvent.VK_H, KeyEvent.CTRL_DOWN_MASK);
        KeyStroke ksGoTo = KeyStroke.getKeyStroke(KeyEvent.VK_G, KeyEvent.CTRL_DOWN_MASK);
        KeyStroke ksSelectAll = KeyStroke.getKeyStroke(KeyEvent.VK_A, KeyEvent.CTRL_DOWN_MASK);
        KeyStroke ksTimeDate = KeyStroke.getKeyStroke(KeyEvent.VK_F5, 0);

        font = new Font("Courier", Font.PLAIN, 12);
        color = new Color(0xFF, 0xFF, 0xFF);
 
        JMenu jmFile = new JMenu("File");
        jmFile.setMnemonic(KeyEvent.VK_F);
        JMenu jmEdit = new JMenu("Edit");
        jmEdit.setMnemonic(KeyEvent.VK_E);
        JMenu jmFormat = new JMenu("Format");
        jmFormat.setMnemonic(KeyEvent.VK_O);
        JMenu jmView = new JMenu("View");
        jmView.setMnemonic(KeyEvent.VK_V);
        JMenu jmHelp = new JMenu("Help");
        jmHelp.setMnemonic(KeyEvent.VK_H);
 
        JMenuItem jmiNew = new JMenuItem("New", 'N');
        JMenuItem jmiOpen = new JMenuItem("Open...", 'O');
        JMenuItem jmiSave = new JMenuItem("Save", 'S');
        JMenuItem jmiSaveAs = new JMenuItem("Save As...", 'A');
        JMenuItem jmiPageSetup = new JMenuItem("Page Setup...", 'u');
        JMenuItem jmiPrint = new JMenuItem("Print", 'P');
        JMenuItem jmiExit = new JMenuItem("Exit", 'x');
 
        jmFile.add(jmiNew);
        jmFile.add(jmiOpen);
        jmFile.add(jmiSave);
        jmFile.add(jmiSaveAs);
        jmFile.addSeparator();
        jmFile.add(jmiPageSetup);
        jmFile.add(jmiPrint);
        jmFile.addSeparator();
        jmFile.add(jmiExit);
 
        JMenuItem jmiUndo = new JMenuItem("Undo");
        JMenuItem jmiCut = new JMenuItem("Cut");
        JMenuItem jmiCopy = new JMenuItem("Copy");
        JMenuItem jmiPaste = new JMenuItem("Paste");
        JMenuItem jmiDelete = new JMenuItem("Delete");
        JMenuItem jmiFind = new JMenuItem("Find...");
        JMenuItem jmiFindNext = new JMenuItem("Find Next");
        JMenuItem jmiReplace = new JMenuItem("Replace...");
        JMenuItem jmiGoTo = new JMenuItem("Go To...");
        JMenuItem jmiSelectAll = new JMenuItem("Select All");
        JMenuItem jmiTimeDate = new JMenuItem("Time/Date");
 
        jmEdit.add(jmiUndo);
        jmEdit.addSeparator();
        jmEdit.add(jmiCut);
        jmEdit.add(jmiCopy);
        jmEdit.add(jmiPaste);
        jmEdit.add(jmiDelete);
        jmEdit.addSeparator();
        jmEdit.add(jmiFind);
        jmEdit.add(jmiFindNext);
        jmEdit.add(jmiReplace);
        jmEdit.add(jmiGoTo);
        jmEdit.addSeparator();
        jmEdit.add(jmiSelectAll);
        jmEdit.add(jmiTimeDate);
 
        JMenuItem jmiWordWrap = new JMenuItem("Word Wrap    X", 'W');
        JMenuItem jmiFont = new JMenuItem("Font...", 'F');
 
        jmFormat.add(jmiWordWrap);
        jmFormat.add(jmiFont);
 
        JMenuItem jmiStatusBar = new JMenuItem("Status Bar", 'S');
 
        jmView.add(jmiStatusBar);
 
        JMenuItem jmiViewHelp = new JMenuItem("View Help", 'H');
        JMenuItem jmiAbout = new JMenuItem("About JNotepad");
 
        jmHelp.add(jmiViewHelp);
        jmHelp.addSeparator();
        jmHelp.add(jmiAbout);
 
        jmb.add(jmFile);
        jmb.add(jmEdit);
        jmb.add(jmFormat);
        jmb.add(jmView);
        jmb.add(jmHelp);

        jmiNew.setAccelerator(ksNew);
        jmiOpen.setAccelerator(ksOpen);
        jmiSave.setAccelerator(ksSave);
        jmiPrint.setAccelerator(ksPrint);
        jmiCut.setAccelerator(ksCut);
        jmiCopy.setAccelerator(ksCopy);
        jmiPaste.setAccelerator(ksPaste);
        jmiDelete.setAccelerator(ksDelete);
        jmiFind.setAccelerator(ksFind);
        jmiReplace.setAccelerator(ksReplace);
        jmiGoTo.setAccelerator(ksGoTo);
        jmiSelectAll.setAccelerator(ksSelectAll);
        jmiTimeDate.setAccelerator(ksTimeDate);

        // Action actions[] = jta.getActions();
        // Action cutAction = TextUtilities.findAction(actions, DefaultEditorKit.cutAction);
 
        jta = new JTextArea(40, 100);
		jta.getDocument().addDocumentListener(new DocumentListener() {
        	public void insertUpdate(DocumentEvent e) {
        		documentChanged = true;
        	}
        	public void removeUpdate(DocumentEvent e) {
        		documentChanged = true;
        	}
        	public void changedUpdate(DocumentEvent e) {
        		documentChanged = true;
        	}
        });

        Image icon = Toolkit.getDefaultToolkit().getImage("JNotepad.png");
        jfrm.setIconImage(icon);
        Highlighter highlighter = jta.getHighlighter();
        Highlighter.HighlightPainter painter = new DefaultHighlighter.DefaultHighlightPainter(Color.cyan);

        JScrollPane jsp = new JScrollPane(jta, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
                JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
 
        jmiWordWrap.setSelected(true);
        jta.setLineWrap(true);
 
        jmiNew.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent ae) {

                if(documentChanged == true) {
                	promptSave();

                } else if(documentChanged == false) {
                	jta.setText("");
                }

            }
        });
 
        jmiOpen.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                int input = jf.showOpenDialog(jfrm);
 
                if(input == JFileChooser.APPROVE_OPTION) {
                    File f = jf.getSelectedFile();
                    String filepath = f.getPath();
 
                    try {
                        BufferedReader br = new BufferedReader(new FileReader(filepath));
                        String readLine = "";
                        String texter = "";
 
                        while((readLine = br.readLine()) != null) {
                            texter += readLine + "\n";
                        }
 
                        jta.setText(texter);
                        br.close();
 
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }

                    String fileName = f.getName();
                    jfrm.setTitle(fileName);
 
                }
            }
        });
 
        jmiSave.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                //custom JDialog for ExitOnSave Option
            }
        });
 
        jmiSaveAs.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                int input = jf.showSaveDialog(jfrm);
 
                if(input == JFileChooser.APPROVE_OPTION) {
                    File f = jf.getSelectedFile();
 
                    try {
                        jta.write(new OutputStreamWriter(new FileOutputStream(f), "utf-8"));
 
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }

                    String fileName = f.getName();
                    jfrm.setTitle(fileName);
 
                }

            }
        });

        jmiExit.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent ae) {
        		if(documentChanged == false) {
        			System.exit(0);
        		} else {

        		}
        	}
        });

        jmiCut.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent ae) {
        		jta.cut();
        	}
        });

        jmiCopy.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent ae) {
        		jta.copy();
        	}
        });

        jmiPaste.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent ae) {
        		jta.paste();
        	}
        });

        jmiDelete.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent ae) {
        		jta.setText(jta.getText().replace(jta.getSelectedText(), ""));
        	}
        });

        jmiFind.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent ae) { 

        	}
        });

        jmiFindNext.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent ae) {

        	}
        });
 	
 		jmiSelectAll.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent ae) {
        		jta.selectAll();
        	}
        });

        jmiWordWrap.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                if(jmiWordWrap.isSelected()) {
                    jta.setLineWrap(false);
                    jmiWordWrap.setText("Word Wrap     ");
                    jmiWordWrap.setSelected(false);
                } else {
                    jta.setLineWrap(true);
                    jmiWordWrap.setSelected(true);
                    jmiWordWrap.setText("Word Wrap    X");
                }
            }
        });

        jmiFont.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent ae) {
        		JFontChooser jfontc = new JFontChooser();
        		
        		jfontc.setDefault(font);
        		jfontc.setDefault(color);

        		if(jfontc.showDialog(jfrm)) {
        			font = jfontc.getFont();
        			color = jfontc.getColor();
        		}

        		if(jta.getSelectedText() != null) {
        			jta.getSelectedText().setFont(font);
        			jta.getSelectedText().setForeground(color);
        		} else {
        			jta.setFont(font);
        			jta.setForeground(color);
        		}
        		
        	}
        });

        jmiTimeDate.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent ae) {
        		
        		Date date = new Date();
        		SimpleDateFormat sdf = new SimpleDateFormat("hh:mm a MM/dd/YYYY");

        		String temp = jta.getText();
        		jta.setText(temp + sdf.format(date));
        	}
        });

        jmiAbout.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent ae) {

        		JDialog jdlg = new JDialog(jfrm, "About this Notepad", true);
        		jdlg.setLayout(new FlowLayout());
        		jdlg.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        		JLabel jlab = new JLabel("(c) Andrew Kim 2018");
        		JButton jbtn = new JButton("OK");

        		jbtn.addActionListener(new ActionListener() {
        			public void actionPerformed(ActionEvent ae) {
        				jdlg.dispose();
        			}
        		});

        		jdlg.setSize(200, 100);

        		jdlg.add(jlab);
        		jdlg.add(jbtn);

        		jdlg.setLocationRelativeTo(jfrm);
        		jdlg.setVisible(true);

        	}
        });

        JPopupMenu jpm = new JPopupMenu();

        jpm.add(jmiCut);
        jpm.add(jmiCopy);
        jpm.addSeparator();
        jpm.add(jmiPaste);

        jta.setComponentPopupMenu(jpm);


        if(documentChanged == true) {
        	jfrm.addWindowListener(new WindowAdapter() {
        		public void windowClosing(WindowEvent we) {
        			promptClose();
        		}
        	});

        } else {
        	jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        }
        
        jfrm.setJMenuBar(jmb);
        jfrm.add(jsp);
        jfrm.pack();
        jfrm.setVisible(true);
    }

    public void promptClose() {
    	
		String ObjButtons[] = {"Cancel", "Don't Save", "Save"};
		int promptResult = JOptionPane.showOptionDialog(null, "Are you sure you want to exit?",
			"Online Examination System", JOptionPane.DEFAULT_OPTION, 
			JOptionPane.WARNING_MESSAGE, null, ObjButtons, ObjButtons[2]);

		if(promptResult == JOptionPane.YES_OPTION) {
			System.out.println("s");
		} else if(promptResult == JOptionPane.NO_OPTION) {
			System.exit(0);
		}

    }

    public void promptSave() {

		String ObjButtons[] = {"Cancel", "Don't Save", "Save"};

		int promptResult = JOptionPane.showOptionDialog(null, "Do you want to save changes to Untitled?",
		"Online Examination System", JOptionPane.DEFAULT_OPTION, 
		JOptionPane.WARNING_MESSAGE, null, ObjButtons, ObjButtons[2]);

		if(promptResult == JOptionPane.YES_OPTION) {
			int input = jf.showSaveDialog(jfrm);

		} else if(promptResult == JOptionPane.NO_OPTION) {
			jta.setText("");
		}


    }
    
 
 
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new JNotepad();
            }
        });
    }
 
}