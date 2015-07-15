package com.krumreyh.java.krumrey.commons.gui.swing.config;

import javax.swing.*;
import java.awt.*;

/**
 * Class that sets the GUI's Style, including Background Color, font size/style etc.
 * @author Hermann Krumrey (hermann@krumreyh.com)
 * @version 0.1-SNAPSHOT
 */
public class StyleConfig {

    public Color background = UIManager.getColor("Panel.background");
    public Color buttonBackground;
    public Color buttonForeground;
    public Color buttonRollover;
    public Color buttonClicked;
    public Color labelBackground;
    public Color labelForeground;
    public Font font = new JLabel().getFont();

    /**
     * Constructor that takes the most basic settings
     * @param colors -              String Array of Hex Color Values used to determine the GUI's colors.
     *                              If the Array is null, the default colors are used
     *                              The Order is the Following:
     *                              (0)GUI Background, (1)Button Background, (2)Button Foreground, (3)Button Rollover, (4)Button Clicked.
     *                              (5)Label Background, (6)Label Foreground
     * @param font -                The default font to be used.
     *                              If it's null, the default font will be used
     */
    public StyleConfig(String[] colors, Font font) throws IllegalArgumentException {

        //Colors
        if (colors.length != 7) { //This need to be updated every time a colorc component is added
            throw new IllegalArgumentException("Incorrect Amount of Color Hex Values");
        }
        if (this.checkHexColor(colors[0])) {
            this.background = Color.decode("0x" + colors[0]);
        }
        if (this.checkHexColor(colors[1])) {
            this.buttonBackground = Color.decode("0x" + colors[1]);
        }
        if (this.checkHexColor(colors[2])) {
            this.buttonForeground = Color.decode("0x" + colors[2]);
        }
        if (this.checkHexColor(colors[3])) {
            this.buttonRollover = Color.decode("0x" + colors[3]);
        }
        if (this.checkHexColor(colors[4])) {
            this.buttonClicked = Color.decode("0x" + colors[4]);
        }
        if (this.checkHexColor(colors[5])) {
            this.labelBackground = Color.decode("0x" + colors[5]);
        }
        if (this.checkHexColor(colors[6])) {
            this.labelForeground = Color.decode("0x" + colors[6]);
        }

        //Fonts
        if (font != null) {
            this.font = font;
        }
    }

    /**
     * Private Helper Method to check the validity of a Hex Color Value
     * @param color - the new color to be used (as Hex)
     * @throws IllegalArgumentException if the input String is not a valid Hex Color
     * @return true if the value is correct, false if the value is null.
     */
    private boolean checkHexColor(String color) throws IllegalArgumentException {
        if (color == null) {
            return false;
        } else if (!color.matches("[a-fA-F0-9]{6}")) {
            throw new IllegalArgumentException("Invalid Hex Color Code");
        } else {
            return true;
        }
    }
}
