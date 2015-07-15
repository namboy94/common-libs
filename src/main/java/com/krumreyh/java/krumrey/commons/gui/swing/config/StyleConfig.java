package com.krumreyh.java.krumrey.commons.gui.swing.config;

import javax.swing.*;
import java.awt.*;

/**
 * Class that sets the GUI's Style, including Background Color, font size/style etc.
 * @author Hermann Krumrey
 * @version 0.1-SNAPSHOT
 */
public class StyleConfig {

    public Color background = UIManager.getColor("Panel.background");
    public Font font = new JLabel().getFont();

    /**
     * Constructor that takes the most basic settings
     * @param colors -              String Array of Hex Color Values used to determine the GUI's colors.
     *                              If the Array is null, the default colors are used
     *                              The Order is the Following:
     *                              GUI Background.
     * @param font -                The default font to be used.
     *                              If it's null, the default font will be used
     */
    public StyleConfig(String[] colors, Font font) throws IllegalArgumentException {

        //Colors
        if (colors.length != 5) {
            throw new IllegalArgumentException("Incorrect Amount of Color Hex Values");
        }
        if (this.checkHexColor(colors[0])) {
            this.background = Color.decode("0x" + colors[0]);
        }

        //Fonts
        if (font != null) {
            this.font = font;
        } else {
            JLabel dummyLabel = new JLabel("Dummy");
            this.font = dummyLabel.getFont();
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
