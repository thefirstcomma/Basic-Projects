// cpp/cos/cs/cs/245/01/w18 tvnguyen7

import java.awt.Color;
import java.awt.Font;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import javax.swing.*;

public class MyClock extends JFrame {
       
    public MyClock () {
        setTitle("My Clock");
        setIconImage(new ImageIcon("MyClock.png").getImage());  // set app icon
        setSize(350, 100);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        JLabel clock = new JLabel(new SimpleDateFormat("HH:mm:ss").format(new Date()), SwingConstants.CENTER);
        
        //xtra decoration
        clock.setFont(new Font(clock.getFont().getFontName(), clock.getFont().getStyle(), 80));
        getContentPane().setBackground(Color.YELLOW);
        clock.setForeground(Color.RED);
                  
        new Timer(1000, ae-> {
            Random rand = new Random();
            clock.setText(new SimpleDateFormat("HH:mm:ss").format(new Date()));
            clock.setForeground(new Color(rand.nextInt(256), rand.nextInt(256), rand.nextInt(256)));
            getContentPane().setBackground(new Color(rand.nextInt(256), rand.nextInt(256), rand.nextInt(256)));
        }).start();
        
        add(clock);
        pack();
        setLocationRelativeTo(null); // center clock
        setVisible(true);
    }

    public static void main(String args[]) {
        SwingUtilities.invokeLater(() -> {
            new MyClock();
        });
    }
}