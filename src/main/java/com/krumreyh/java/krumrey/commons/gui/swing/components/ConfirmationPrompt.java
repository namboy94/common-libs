package com.krumreyh.java.krumrey.commons.gui.swing.components;

import com.krumreyh.java.krumrey.commons.gui.swing.templates.BasicGUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Class that implements a Confirmation prompt dialogue box
 */
public class ConfirmationPrompt extends MessageBox {

    private boolean state = false;
    private boolean prompting = true;

    /**
     * Constructor that defines the look of the confirmation prompt
     * @param parent - The parent JFrame of the confirmation prompt
     * @param message - the message to be displayed
     * @param title - the title of the window
     * @param xSize - the width of the confirmation prompt
     * @param ySize - the height of the confirmation prompt
     */
    public ConfirmationPrompt(BasicGUI parent, String message, String title, int xSize, int ySize) {

        this.parent = parent;
        this.style = parent.getStyle();

        if (xSize < 0 && ySize < 0) {
            xSize = 500;
            ySize = 200;
        }

        this.setMessageBoxSettings(title, xSize, ySize);

        int border = ((xSize / 16) + (ySize / 16)) / 2;

        int labelX = xSize - 2 * border;
        int labelY = ySize / 2;
        int labelXPos = border;
        int labelYPos = border;

        int yesNoX = xSize / 4;
        int yesNoY = ySize / 4;
        int yesXPos = (xSize / 4) - (yesNoX / 2);
        int noXPos = yesXPos + (xSize / 2);
        int yesNoYPos = (ySize - border - yesNoY);

        this.addLabel(message, labelXPos, labelYPos, labelX, labelY);
        this.addButton("Yes", yesXPos, yesNoYPos, yesNoX, yesNoY, new AnswerButton(true));
        this.addButton("No", noXPos, yesNoYPos, yesNoX, yesNoY, new AnswerButton(false));

        this.setVisible(true);

    }

    /**
     * Getter method to determine the user's answer
     * @return the user's answer as a boolean (Yes = True, No = False)
     */
    public boolean getAnswer() {
        return this.state;
    }

    /**
     * Method that tells if the confirmation prompt has received an answer yet
     * @return true, if the prompt has not been completed yet and false otherwise
     */
    public boolean getPrompting() {
        return this.prompting;
    }

    /**
     * Implements the "Yes" and "No" Buttons
     */
    private class AnswerButton implements ActionListener {

        private boolean answer;

        /**
         * Constructor for the two different possible button types
         * @param answer - the answer given when the button is pressed ("Yes" = false, "No" = true)
         */
        public AnswerButton(boolean answer) {
            this.answer = answer;
        }

        /**
         * Sets the local variable for the answer and closes the prompt window
         * @param actionEvent - the button press event
         */
        public void actionPerformed(ActionEvent actionEvent) {
            ConfirmationPrompt.this.state = this.answer;
            ConfirmationPrompt.this.dispose();
            ConfirmationPrompt.this.parent.setEnabled(true); //Re-Enables the parent frame
            ConfirmationPrompt.this.prompting = false;
        }
    }
}
