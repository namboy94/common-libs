/*
Copyright 2015-2017 Hermann Krumrey <hermann@krumreyh.com>

This file is part of krumrey-commons.

krumrey-commons is free software: you can redistribute it and/or modify
it under the terms of the GNU General Public License as published by
the Free Software Foundation, either version 3 of the License, or
(at your option) any later version.

krumrey-commons is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
GNU General Public License for more details.

You should have received a copy of the GNU General Public License
along with krumrey-commons.  If not, see <http://www.gnu.org/licenses/>.
*/

package com.krumreyh.java.krumrey.commons.gui.swing.components.subcomponents;

import com.krumreyh.java.krumrey.commons.gui.swing.components.DialogBox;
import com.krumreyh.java.krumrey.commons.gui.swing.templates.BasicGUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Class that implements a input dialog box which allows the user to enter a String
 * @author Hermann Krumrey (hermann@krumreyh.com)
 * @version 0.1-SNAPSHOT
 */
public class InputDialog extends DialogBox {

    private String userInput;
    private JTextField textField;

    /**
     * Constructs a new Input Dialogue
     * @param parent - the parent GUI process
     * @param message - the message shown to the user
     * @param title - the title of the window
     * @param xSize - the width of the window
     * @param ySize - the height of the window
     */
    public InputDialog(BasicGUI parent, String message, String title, int xSize, int ySize) {

        this.parent = parent;
        this.style = parent.getStyle();

        if (xSize < 0 || ySize < 0) {
            xSize = 500;
            ySize = 300;
        }

        this.setMessageBoxSettings(title, xSize, ySize);

        int border = ((xSize / 16) + (ySize / 16)) / 2;

        int labelX = xSize - 2 * border;
        int labelY = ySize / 3;
        int labelXPos = border;
        int labelYPos = border;

        int textX = labelX;
        int textY = border * 2;
        int textXPos = border;
        int textYPos = labelY + textY;

        int yesNoX = xSize / 4;
        int yesNoY = ySize / 4;
        int yesXPos = (xSize / 4) - (yesNoX / 2);
        int noXPos = yesXPos + (xSize / 2);
        int yesNoYPos = (ySize - border - yesNoY);

        this.addLabel(message, labelXPos, labelYPos, labelX, labelY);
        this.textField = this.addTextField("", textXPos, textYPos, textX, textY, new AnswerButton(true));
        this.addButton("Confirm", yesXPos, yesNoYPos, yesNoX, yesNoY, new AnswerButton(true));
        this.addButton("Cancel", noXPos, yesNoYPos, yesNoX, yesNoY, new AnswerButton(false));

        this.setVisible(true);
    }

    /**
     * Getter method to get the user's input once the confirm button was pressed.
     * If the Cancel Button was pressed, an empty string is returned
     * @return the user input
     */
    public String getUserInput() {
        return this.userInput;
    }

    /**
     * Implements the "Confirm" and "Cancel" Buttons
     */
    private class AnswerButton implements ActionListener {

        private boolean answer;

        /**
         * Constructor for the two different possible button types
         * @param answer - the answer given when the button is pressed ("Confirm" = false, "Cancel" = true)
         */
        public AnswerButton(boolean answer) {
            this.answer = answer;
        }

        /**
         * Sets the local variable for the answer and closes the prompt window
         * @param actionEvent - the button press event
         */
        public void actionPerformed(ActionEvent actionEvent) {
            if (answer) {
                InputDialog.this.userInput = InputDialog.this.textField.getText();
            } else {
                InputDialog.this.userInput = "";
            }
            InputDialog.this.dispose();
            InputDialog.this.parent.setEnabled(true); //Re-Enables the parent frame
        }
    }
}