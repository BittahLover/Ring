package gui;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.plaf.basic.BasicInternalFrameTitlePane;

import classes.Alarm;
import classes.DigitalWatch;
import classes.SoundFile;

public class TimerWindow extends JFrame {
    private String alarmName;
    /**
     *
     */
    private static final long serialVersionUID = 7317979646518789994L;
    public TimerWindow(String alarmName, int seconds){
        this.alarmName = alarmName;
        SoundFile soundFile = new SoundFile("Shit", "src/SoundFiles/Fantasy.wav");
        Alarm alarm = new Alarm(alarmName, seconds, soundFile);
        alarm.start();
        initUI();
    }

    public final void initUI() {

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBackground(Color.PINK);

        JLabel alarmNameLabel = new JLabel("Alarm name: "+alarmName);
        panel.add(alarmNameLabel);

        JLabel notificationLabel = new JLabel("Alarm is set and active");
        panel.add(notificationLabel);
        //The cancel button.
        JButton cancelButton = new JButton("Cancel/Turn Off Alarm");

        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                dispose();
            }
        });

        panel.add(cancelButton);
        //Adds the main panel.
        add(panel);

        pack();
        setTitle("Alarm");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
    }

}