/*
Copyright 2015-2017 Hermann Krumrey <hermann@krumreyh.com>

This file is part of krumreylib.

krumreylib is free software: you can redistribute it and/or modify
it under the terms of the GNU General Public License as published by
the Free Software Foundation, either version 3 of the License, or
(at your option) any later version.

krumreylib is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
GNU General Public License for more details.

You should have received a copy of the GNU General Public License
along with krumreylib.  If not, see <http://www.gnu.org/licenses/>.
*/

package com.krumreyh.java.krumreylib.gui.swing.config;

import javax.swing.*;
import java.awt.*;

/**
 * Class that sets the GUI's Style, including Background Color, font size/style etc.
 * @author Hermann Krumrey (hermann@krumreyh.com)
 */
public class StyleConfig {

    public Color background;
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
    public Color dialogBoxBackground = new Color(0xeeeeee);
    public Color dropDownBackground;
    public Color dropDownForeground;

    public Color uiBase;
    public Color uiBlueGrey;
    public Color uiControl;
    public Color uiFocus;
    public Color uiSelectionBackground;

    public Font generalFont;
    public Font buttonFont;
    public Font labelFont;
    public Font checkBoxFont;
    public Font textFieldFont;
    public Font messageBoxFont;
    public Font dropDownFont;

    /**
     * Dummy default constructor
     */
    public StyleConfig() {
    }

    /**
     * Constructor that sets custom colors and fonts to create a Style
     * @param colors -              String Array of Hex Color Values used to determine the GUI's colors.
     *                              If the Array is null, the default colors are used
     *                              If any element in the array is null, it defaults to the default value
     *                              The Order is the Following:
     *                              (0)GUI Background, (1)Button Background, (2)Button Foreground, (3)Button Rollover, (4)Button Clicked.
     *                              (5)Label Background, (6)Label Foreground, (7)Checkbox Background, (8)Checkbox Foreground,
     *                              (9)Text Field Background, (10)Text Field Foreground, (11)Image Border Color, (12) Dialog Box Background,
     *                              (13)Drop Down Menu Background, (14)Drop Down Foreground
     * @param sysColors -           String array of Hex Color Values used to determine the GUI's base colors (replaces nimbus default values)
     *                              If the array is null, the default colors are used.
     *                              If any element in the array is null, it defaults to the default value
     *                              The order is the following:
     *                              (0)Base, (1)Blue/Grey, (2)Control, (3)Focus, (4)Selection Background
     * @param fonts -               Font array that determines the default fonts for various components of the GUI
     *                              If the array is null, the default fonts are used.
     *                              If any element in the array is null, it defaults to the default value
     *                              The Order is as Following:
     *                              (0)General Font, (1)Button Font, (2)Label Font, (3)Checkbox Font, (4)Text Field Font, (5)Message Box Font,
     *                              (6)Drop Down Menu Font
     */
    public StyleConfig(String[] colors, String[] sysColors, Font[] fonts) throws IllegalArgumentException {

        //Colors
        if (colors != null) {
            if (colors.length != 15) { //This need to be updated every time a colorc component is added
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
                this.checkBoxForeground = Color.decode("0x" + colors[8]);
            }
            if (this.checkHexColor(colors[9])) {
                this.textFieldBackground = Color.decode("0x" + colors[9]);
            }
            if (this.checkHexColor(colors[10])) {
                this.textFieldForeground = Color.decode("0x" + colors[10]);
            }
            if (this.checkHexColor(colors[11])) {
                this.imageBorderColor = Color.decode("0x" + colors[11]);
            }
            if (this.checkHexColor(colors[12])) {
                this.dialogBoxBackground = Color.decode("0x" + colors[12]);
            }
            if (this.checkHexColor(colors[13])) {
                this.dropDownBackground = Color.decode("0x" + colors[13]);
            }
            if (this.checkHexColor(colors[14])) {
                this.dropDownForeground = Color.decode("0x" + colors[14]);
            }
        }

        //System Colors
        if (sysColors != null) {
            if (sysColors.length != 5) { //This need to be updated every time a color component is added
                throw new IllegalArgumentException("Incorrect Amount of System Color Hex Values");
            }
            if (this.checkHexColor(sysColors[0])) {
                this.uiBase = Color.decode("0x" + sysColors[0]);
            }
            if (this.checkHexColor(sysColors[1])) {
                this.uiBlueGrey = Color.decode("0x" + sysColors[1]);
            }
            if (this.checkHexColor(sysColors[2])) {
                this.uiControl = Color.decode("0x" + sysColors[2]);
            }
            if (this.checkHexColor(sysColors[3])) {
                this.uiFocus = Color.decode("0x" + sysColors[3]);
            }
            if (this.checkHexColor(sysColors[4])) {
                this.uiSelectionBackground = Color.decode("0x" + sysColors[4]);
            }
        }

        //Fonts
        if (fonts != null) {
            if (fonts.length != 7) {
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
            if (fonts[5] != null) {
                this.dropDownFont = fonts[6];
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