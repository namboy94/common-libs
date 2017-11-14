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

package com.krumreyh.java.krumreylib.gui.swing.components.subcomponents;

import com.krumreyh.java.krumreylib.gui.swing.components.DialogBox;
import com.krumreyh.java.krumreylib.gui.swing.templates.BasicGUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Class that models a simple Message Box
 * @author Hermann Krumrey (hermann@krumreyh.com)
 */
public class MessageBox extends DialogBox {

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
        JButton confirmButton = this.addButton("OK", confirmXPos, confirmYPos, confirmX, confirmY, new ConfirmButton());

        this.getRootPane().setDefaultButton(confirmButton);

        this.setVisible(true);
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