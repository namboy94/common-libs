package com.krumreyh.java.krumrey.commons.gui.swing.templates;

import com.krumreyh.java.krumrey.commons.gui.swing.components.ColorableButton;
import com.krumreyh.java.krumrey.commons.gui.swing.components.ImageLabel;
import com.krumreyh.java.krumrey.commons.gui.swing.config.StyleConfig;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

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
        this.setFont(this.style.generalFont);
        this.pack();

        //Style
        this.getContentPane().setBackground(this.style.background);
    }

    /**
     * Method that adds a colored JButton to the GUI
     * @param text - The text shown on the button
     * @param xPos - The (initial) position in the GUI on the x-axis
     * @param yPos - The (initial) position in the GUI on the y-axis
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
     * Method that adds a JLabel to the GUI
     * @param text - The text shown on the button
     * @param xPos - The (initial) position in the GUI on the x-axis
     * @param yPos - The (initial) position in the GUI on the y-axis
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
     * Method that adds a Checkbox to the GUI
     * @param text - The text shown on the checkbox
     * @param xPos - The (initial) position in the GUI on the x-axis
     * @param yPos - The (initial) position in the GUI on the y-axis
     * @param xSize - The (initial) width of the checkbox
     * @param ySize - The (initial) height of the label
     * @return the newly generated JCheckBox object in case further modifications of the objects is needed.
     */
    protected JCheckBox addCheckBox(String text, int xPos, int yPos, int xSize, int ySize) {
        //Basics and Style
        JCheckBox box = new JCheckBox(text);
        box.setSize(xSize, ySize);
        box.setLocation(xPos, yPos);
        box.setBackground(this.style.checkBoxBackground);
        box.setForeground(this.style.checkBoxForeground);
        box.setFont(this.style.checkBoxFont);
        box.setFocusPainted(false);

        //Finalize
        this.add(box);
        return box;
    }

    /**
     * Method that adds a text field to the GUI
     * @param text - The text shown by default
     * @param xPos - The (initial) position in the GUI on the x-axis
     * @param yPos - The (initial) position in the GUI on the y-axis
     * @param xSize - The (initial) width of the text field
     * @param ySize - The (initial) height of the text field
     * @return the newly generated JTextField object in case further modifications of the objects is needed.
     */
    protected JTextField addTextField(String text, int xPos, int yPos, int xSize, int ySize) {
        //Basics and Style
        JTextField field = new JTextField(text);
        field.setSize(xSize, ySize);
        field.setLocation(xPos, yPos);
        field.setBackground(this.style.textFieldBackground);
        field.setForeground(this.style.textFieldForeground);
        field.setFont(this.style.textFieldFont);
        field.setBorder(null);

        //Finalize
        this.add(field);
        return field;
    }

    /**
     * Method that adds an image label to the GUI
     * @param image - The image to be displayed
     * @param xPos - The (initial) position in the GUI on the x-axis
     * @param yPos - The (initial) position in the GUI on the y-axis
     * @param xSize - The (initial) width of the image label
     * @param ySize - The (initial) height of the image label
     * @return the newly generated JLabel object in case further modification of the object is needed
     */
    protected JLabel addImageLabel(BufferedImage image, int xPos, int yPos, int xSize, int ySize, ImageLabel.ScaleMode scalemode) {
        //Basics & Style
        JLabel imageLabel = new ImageLabel(image, xSize, ySize, scalemode, this.style.imageBorderColor);
        imageLabel.setLocation(xPos, yPos);

        //Finalize
        this.add(imageLabel);
        return imageLabel;
    }

    protected void showMessageBox(String message) {
        JOptionPane.showMessageDialog(this, message);
    }
}
