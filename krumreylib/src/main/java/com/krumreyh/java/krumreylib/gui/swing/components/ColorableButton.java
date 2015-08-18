package com.krumreyh.java.krumreylib.gui.swing.components;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;

/**
 * Implementation of the JButton class that allows better customization of colors
 * @author Hermann Krumrey(hermann@krumreyh.com)
 */
public class ColorableButton extends JButton{

    private Color pressed;
    private Color rollover;
    private Color normal;

    /**
     * Contructor of the Class that defines the colors of the JButton
     * @param text - The text to be displayed by the button
     * @param normal - The background color that's normally shown
     * @param foreground - The foreground of the Button
     * @param rollover - The background color for when the button is selected by the mouse
     * @param pressed - The background color that's shown when the button is pressed
     * @param font - The font to be used in the text of the Button
     */
    public ColorableButton(String text, Color normal, Color foreground, Color rollover, Color pressed, Font font) {
        super(text);

        this.pressed = pressed;
        this.rollover = rollover;
        this.normal = normal;

        this.setBorderPainted(false);
        this.setFocusPainted(false);
        this.setContentAreaFilled(false);
        this.setOpaque(true);

        this.setBackground(normal);
        this.setForeground(foreground);
        this.setFont(font);
        this.setText(text);

        this.addChangeListener(new ColorChanger());
    }

    /**
     * private Class that handles the changing of Background colors for all possible situations
     */
    private class ColorChanger implements ChangeListener {

        public void stateChanged(ChangeEvent changeEvent) {
            if (ColorableButton.this.getModel().isPressed()) {
                setBackground(ColorableButton.this.pressed);
            } else if (ColorableButton.this.getModel().isRollover()) {
                setBackground(ColorableButton.this.rollover);
            } else {
                setBackground(ColorableButton.this.normal);
            }
        }
    }
}