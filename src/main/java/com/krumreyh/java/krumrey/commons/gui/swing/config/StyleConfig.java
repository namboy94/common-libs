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
    public Color checkBoxBackground;
    public Color checkBoxForeground;
    public Color textFieldBackground;
    public Color textFieldForeground;
    public Color imageBorderColor = new Color(0x000000);
    public Color messageBoxBackground;

    public Font generalFont = new JLabel().getFont();
    public Font buttonFont = new JLabel().getFont();
    public Font labelFont = new JLabel().getFont();
    public Font checkBoxFont = new JLabel().getFont();
    public Font textFieldFont = new JLabel().getFont();
    public Font messageBoxFont = new JLabel().getFont();

    /**
     * Constructor that takes the most basic settings
     * @param colors -              String Array of Hex Color Values used to determine the GUI's colors.
     *                              If the Array is null, the default colors are used
     *                              The Order is the Following:
     *                              (0)GUI Background, (1)Button Background, (2)Button Foreground, (3)Button Rollover, (4)Button Clicked.
     *                              (5)Label Background, (6)Label Foreground, (7)Checkbox Background, (8)Checkbox Foreground,
     *                              (9)Text Field Background, (10)Text Field Foreground, (11)Image Border Color, (12) Message Box Background
     * @param fonts -               Font array that determines the default fonts for various components of the GUI
     *                              The Order is as Following:
     *                              (0)General Font, (1)Button Font, (2)Label Font, (3)Checkbox Font, (4)Text Field Font, (5)Message Box Font
     */
    public StyleConfig(String[] colors, Font[] fonts) throws IllegalArgumentException {

        //Colors
        if (colors.length != 13) { //This need to be updated every time a colorc component is added
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
        if (this.checkHexColor(colors[7])) {
            this.checkBoxBackground = Color.decode("0x" + colors[7]);
        }
        if (this.checkHexColor(colors[8])) {
            this.checkBoxForeground= Color.decode("0x" + colors[8]);
        }
        if (this.checkHexColor(colors[9])) {
            this.textFieldBackground = Color.decode("0x" + colors[9]);
        }
        if (this.checkHexColor(colors[10])) {
            this.textFieldForeground = Color.decode("0x" + colors[10]);
        }
        if (this.checkHexColor(colors[11])) {
            this.imageBorderColor= Color.decode("0x" + colors[11]);
        }
        if (this.checkHexColor(colors[12])) {
            this.messageBoxBackground= Color.decode("0x" + colors[12]);
        }

        //Fonts
        if (fonts != null) {
            if (fonts.length != 4) {
                throw new IllegalArgumentException("Illegal Amount of Fonts");
            }
            if (fonts[0] != null) {
                this.generalFont = fonts[0];
            }
            if (fonts[1] != null) {
                this.buttonFont = fonts[1];
            }
            if (fonts[2] != null) {
                this.labelFont = fonts[2];
            }
            if (fonts[3] != null) {
                this.checkBoxFont = fonts[3];
            }
            if (fonts[4] != null) {
                this.textFieldFont = fonts[4];
            }
            if (fonts[5] != null) {
                this.messageBoxFont = fonts[5];
            }
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
