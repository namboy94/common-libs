package com.krumreyh.java.krumrey.commons.gui.swing.components;

import com.krumreyh.java.krumrey.commons.gui.swing.config.StyleConfig;
import com.krumreyh.java.krumrey.commons.gui.swing.templates.BasicGUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Class that models JDialog to be more customizable
 * @author Hermann Krumrey (hermann@krumreyh.com)
 * @version 0.1-SNAPSHOT
 */
public abstract class DialogBox extends JDialog {

    protected JFrame parent;
    protected StyleConfig style;

    /**
     * Dummy Default Constructor
     */
    public DialogBox() {
    }

    /**
     * Helper method that sets the overall settings of the message box frame and its components
     * @param title - the title to be displayed
     * @param xSize - the width of the frame
     * @param ySize - the height of the frame
     */
    protected void setMessageBoxSettings(String title, int xSize, int ySize) {
        //Calculations
        int xPos = this.parent.getX();
        int yPos = this.parent.getY();

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
        this.getContentPane().setBackground(this.style.dialogBoxBackground);
        this.getContentPane().setForeground(this.style.dialogBoxBackground);
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
     * Method that adds a text field to the Dialog
     * @param text - The text shown by default
     * @param xPos - The (initial) position in the Dialog on the x-axis
     * @param yPos - The (initial) position in the Dialog on the y-axis
     * @param xSize - The (initial) width of the text field
     * @param ySize - The (initial) height of the text field
     * @param enterAction - the action taken when the TextField has focus and enter/return is pressed
     * @return the newly generated JTextField object in case further modifications of the objects is needed.
     */
    protected JTextField addTextField(String text, int xPos, int yPos, int xSize, int ySize, ActionListener enterAction) {
        //Basics and Style
        JTextField field = new JTextField(text);
        field.setSize(xSize, ySize);
        field.setLocation(xPos, yPos);
        field.setBackground(this.style.textFieldBackground);
        field.setForeground(this.style.textFieldForeground);
        field.setFont(this.style.textFieldFont);
        field.setBorder(null);
        field.addActionListener(enterAction);

        //Finalize
        this.add(field);
        return field;
    }
}