package classes;

import javax.swing.*;
import java.awt.*;
import java.text.*;
import java.util.*;

public class DigitalWatch implements Runnable{
    JFrame f;
    Thread t;
    int hours=0, minutes=0, seconds=0;
    String timeString = "";
    JButton b;

    public DigitalWatch(){
        f=new JFrame();

        t = new Thread(this);
        t.start();

        b=new JButton();
        b.setBounds(0,0,184,61);

        f.add(b);
        f.setSize(200,100);
        f.setLayout(null);
        f.setVisible(true);
        f.setLocationRelativeTo(null);
    }

    public void run() {
        try {
            while (true) {

                Calendar cal = Calendar.getInstance();
                hours = cal.get( Calendar.HOUR );
                if ( hours > 12 ) hours -= 12;
                minutes = cal.get( Calendar.MINUTE );
                seconds = cal.get( Calendar.SECOND );

                SimpleDateFormat formatter = new SimpleDateFormat("H:mm:ss");
                Date date = cal.getTime();
                timeString = formatter.format(date);

                printTime();

                t.sleep( 1000 );  // interval given in milliseconds
            }
        }
        catch (Exception e) { }
    }

    public void printTime(){
        b.setText(timeString);
    }
}

