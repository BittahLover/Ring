package main;

import classes.DigitalWatch;
import gui.MainWindow;

import javax.swing.*;

public class Driver {

    /**
     * @param args
     */
    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");

        }
        catch (Exception e) { }
        MainWindow window = new MainWindow();
        window.setVisible(true);
    }

}