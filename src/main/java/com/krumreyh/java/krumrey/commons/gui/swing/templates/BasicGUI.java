package com.krumreyh.java.krumrey.commons.gui.swing.templates;

import com.krumreyh.java.krumrey.commons.gui.swing.config.StyleConfig;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * Class that models a simple GUI in Swing
 * @author Hermann Krumrey (hermann@krumreyh.com)
 * @version 0.1-SNAPSHOT
 */
public class BasicGUI extends JFrame {

    protected StyleConfig style;

    /**
     * Sets the basic settings of the GUI. The Window starts in the middle of the screen
     * @param title - The title of the GUI Window
     * @param xSize - The (initial) width of the window
     * @param ySize - The (initial) height of the window
     * @param layout - The Layout Manager to be used
     * @param closeOp - The default closing Operation
     * @param resizable - Defines if the window is resizeable, true if yes, false otherwise
     */
    protected void setGUISettings(String title, int xSize, int ySize, LayoutManager layout, int closeOp, boolean resizable, StyleConfig style) {
        //Calculations
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int xPos = (int)(screenSize.getWidth() / 2) - (xSize / 2);
        int yPos = (int)(screenSize.getHeight() / 2) - (ySize / 2);

        //Local Variable Initialization
        this.style = style;

        //Settings
        this.setTitle(title);
        this.setLocation(xPos, yPos);
        this.getContentPane().setPreferredSize(new Dimension(xSize, ySize));
        this.setLayout(layout);
        this.setDefaultCloseOperation(closeOp);
        this.setResizable(resizable);
        this.pack();

        //Style
        this.getContentPane().setBackground(this.style.background);
    }

}
