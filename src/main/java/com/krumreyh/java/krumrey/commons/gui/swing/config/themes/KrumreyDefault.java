package com.krumreyh.java.krumrey.commons.gui.swing.config.themes;

import com.krumreyh.java.krumrey.commons.gui.swing.config.StyleConfig;

import javax.swing.*;
import java.awt.*;

/**
 * The Default Style Theme of this lybrary
 * @author Hermann Krumrey (hermann@krumreyh.com)
 * @version 0.1-SNAPSHOT
 */
public class KrumreyDefault extends StyleConfig{

    /**
     * Constructor that sets the theme
     */
    public KrumreyDefault() {

        this.background = new Color(0xEEEEEE);
        this.buttonBackground = new Color(0xD9D9D9);
        this.buttonForeground = new Color(0x000000);
        this.buttonRollover = new Color(0xE0E0E0);
        this.buttonClicked = new Color(0x9C9C9C);
        this.labelBackground = new Color(0xD9D9D9);
        this.labelForeground = new Color(0x000000);
        this.checkBoxBackground = new Color(0x000000);
        this.checkBoxForeground = new Color(0x000000);
        this.textFieldBackground = new Color(0xFFFFFF);
        this.textFieldForeground = new Color(0x000000);
        this.imageBorderColor = new Color(0x000000);
        this.dialogBoxBackground = new Color(0xEEEEEE);
        this.dropDownBackground = new Color(0xD9D9D9);
        this.dropDownForeground = new Color(0x000000);

        this.uiBase = new Color(0xBABABA);
        this.uiBlueGrey = new Color(0xBABABA);
        this.uiControl = new Color(0xBABABA);
        this.uiFocus = new Color(0xB8B8B8);
        this.uiSelectionBackground = new Color(0xB8B8B8);

        this.generalFont = new Font("Verdana", Font.PLAIN, 10);
        this.buttonFont = new Font("Verdana", Font.PLAIN, 10);
        this.labelFont = new Font("Verdana", Font.PLAIN, 10);
        this.checkBoxFont = new Font("Verdana", Font.PLAIN, 10);
        this.textFieldFont = new Font("Verdana", Font.PLAIN, 10);
        this.messageBoxFont = new Font("Verdana", Font.PLAIN, 10);
        this.dropDownFont = new Font("Verdana", Font.PLAIN, 10);

    }

    /**
     * Constructor that enables customization of individual colors and fonts
     * @param colors - refer to parent class StyleConfig
     * @param sysColors - refer to parent class StyleConfig
     * @param fonts - refer to parent class StyleConfig
     * @throws IllegalArgumentException
     */
    public KrumreyDefault(String[] colors, String[] sysColors, Font[] fonts) throws IllegalArgumentException {
        super();
    }

}
