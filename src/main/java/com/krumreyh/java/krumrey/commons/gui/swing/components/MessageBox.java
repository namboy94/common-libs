package com.krumreyh.java.krumrey.commons.gui.swing.components;

import com.krumreyh.java.krumrey.commons.gui.swing.config.StyleConfig;
import com.krumreyh.java.krumrey.commons.gui.swing.templates.BasicGUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Class that models a simple Message Box
 * @author Hermann Krumrey (hermann@krumreyh.com)
 * @version 0.1-SNAPSHOT
 */
public class MessageBox extends JDialog {

    protected JFrame parent;
    protected StyleConfig style;

    /**
     * Dummy Default Constructor
     */
    public MessageBox() {;
    }

    /**
     * Constructor that calculates the look of the Message Box based on the input values
     * @param parent - the parent JFrame process
     * @param message - the message to be displayed
     * @param title - the title to be displayed
     * @param xSize - the width of the message box. Defaults to 500 if the entered value is negative
     * @param ySize - the height of the message box. Defaults to 200 if the entered value is negative
     */
    public MessageBox(BasicGUI parent, String message, String title, int xSize, int ySize) {

        this.style = parent.getStyle();
        this.parent = parent;

        if (xSize < 0 || ySize < 0) {
            xSize = 500;
            ySize = 200;
        }

        this.setMessageBoxSettings(title, xSize, ySize);

        int border = ((xSize / 16) + (ySize / 16)) / 2;

        int labelX = xSize - 2 * border;
        int labelY = ySize / 2;
        int labelXPos = border;
        int labelYPos = border;

        int confirmX = xSize / 4;
        int confirmY = ySize / 6;
        int confirmXPos = (xSize / 2) - (confirmX / 2);
        int confirmYPos = (ySize - border - confirmY);

        this.addLabel(message, labelXPos, labelYPos, labelX, labelY);
        this.addButton("OK", confirmXPos, confirmYPos, confirmX, confirmY, new ConfirmButton());

        this.setVisible(true);
    }

    /**
     * Helper method that sets the overall settings of the message box frame and its components
     * @param title - the title to be displayed
     * @param xSize - the width of the frame
     * @param ySize - the height of the frame
     */
    protected void setMessageBoxSettings(String title, int xSize, int ySize) {
        //Calculations
        int xPos = parent.getX();
        int yPos = parent.getY();

        parent.setEnabled(false); //Disables the Parent Frame

        //Settings
        this.setTitle(title);
        this.setLocation(xPos, yPos);
        this.getContentPane().setPreferredSize(new Dimension(xSize, ySize));
        this.setLayout(null);
        this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        this.setResizable(false);
        this.setFont(this.style.messageBoxFont);
        this.pack();
        this.getContentPane().setBackground(this.style.messageBoxBackground);
        this.setModal(true);

        //Override Fonts
        this.style.buttonFont = this.style.messageBoxFont;
        this.style.labelFont = this.style.messageBoxFont;
    }

    /**
     * Method that adds a colored JButton to the Dialog
     * @param text - The text shown on the button
     * @param xPos - The (initial) position in the Dialog on the x-axis
     * @param yPos - The (initial) position in the Dialog on the y-axis
     * @param xSize - The (initial) width of the button
     * @param ySize - The (initial) height of the button
     * @param action - The action to be executed when the Button is pressed
     * @return the generated JButton object in case further modification of the button is needed
     */
    protected JButton addButton(String text, int xPos, int yPos, int xSize, int ySize, ActionListener action) {
        //Basics & Style
        Color back = this.style.buttonBackground;
        Color fore = this.style.buttonForeground;
        Color roll = this.style.buttonRollover;
        Color click = this.style.buttonClicked;
        JButton button = new ColorableButton(text, back, fore, roll, click, this.style.buttonFont);
        button.setSize(xSize, ySize);
        button.setLocation(xPos, yPos);
        button.addActionListener(action);

        //Finalize
        this.add(button);
        return button;
    }

    /**
     * Method that adds a JLabel to the Dialog
     * @param text - The text shown on the button
     * @param xPos - The (initial) position in the Dialog on the x-axis
     * @param yPos - The (initial) position in the Dialog on the y-axis
     * @param xSize - The (initial) width of the label
     * @param ySize - The (initial) height of the label
     * @return the newly generated JLabel object in case further modifications of the objects is needed.
     */
    protected JLabel addLabel(String text, int xPos, int yPos, int xSize, int ySize) {
        //Basics and Style
        JLabel label = new JLabel(text, SwingConstants.CENTER);
        label.setSize(xSize, ySize);
        label.setLocation(xPos, yPos);
        label.setBackground(this.style.labelBackground);
        label.setForeground(this.style.labelForeground);
        label.setOpaque(true);
        label.setFont(this.style.labelFont);

        //Finalize
        this.add(label);
        return label;
    }

    /**
     * Class that Implements the "OK" Button that ends the message box
     */
    private class ConfirmButton implements ActionListener {

        /**
         * Closes the Message box and re-enables the parent frame
         * @param actionEvent - the button press event
         */
        public void actionPerformed(ActionEvent actionEvent) {
            MessageBox.this.dispose();
            MessageBox.this.parent.setEnabled(true); //Re-Enables the parent frame
        }
    }
}
