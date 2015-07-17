package com.krumreyh.java.krumrey.commons.gui.swing.demos;

import com.krumreyh.java.krumrey.commons.gui.swing.components.ImageLabel;
import com.krumreyh.java.krumrey.commons.gui.swing.config.StyleConfig;
import com.krumreyh.java.krumrey.commons.gui.swing.config.themes.KrumreyDefault;
import com.krumreyh.java.krumrey.commons.gui.swing.templates.BasicGUI;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.Buffer;

/**
 * Class that shows off the capabilities of the BasicGUI class
 * @author Hermann Krumrey
 * @version 0.1-SNAPSHOT
 */
public class BasicGUIDemo extends BasicGUI{

    /**
     * Constructor that defines the GUI's appearance and content
     */
    public BasicGUIDemo() {

        //Setting Style
        String[] colors = new String[] {
                null,   //(UI Background
                null,   //Button Background
                null,   //Button Foreground
                null,   //Button Rollover
                null,   //Button Clicked
                null,   //Label Background
                null,   //Label Foreground
                null,   //Checkbox Background
                null,   //Checkbox Foreground
                null,   //Text Field Background
                null,   //Text Field Foreground
                null,   //Scaled Image Border
                null,   //Message Box Background
                null,   //Dropdown Menu Background
                null    //Dropdown Menu Foreground
        };

        String[] sysColors = new String[] {
                null,   //Base
                null,   //Blue/Grey
                null,   //Control
                null,   //Focus
                null    //Selection Background
        };

        Font[] fonts = new Font[] {
                null,   //General Font
                null,   //Button Font
                null,   //Label Font
                null,   //Checkbox Font
                null,   //Text Field Font
                null,   //Message Box Font
                null    //Drop Down Menu Fonts
        };

        StyleConfig style = new KrumreyDefault(colors, sysColors, fonts);

        //Resource Loading
        BufferedImage testImage1 = null;
        BufferedImage testImage2 = null;
        try {
            testImage1 = ImageIO.read(new File("src/main/resources/images/fcb.png"));
            testImage2 = ImageIO.read(new File("src/main/resources/images/ente.jpg"));
        } catch (IOException e) {
            this.showMessageBox("Error loading image resources.", "Image I/O Error", -1, -1);
        }

        //Defining List/Menu Elements
        String[] popUps = new String[] {
                "Test1",
                "Test2",
                "Test3"
        };

        ActionListener[] popUpCommands = new ActionListener[] {
                new PopUpButton(),
                new AskUser(),
                new AskUserText()
        };

        String[] drops = new String[] {
                "drop1",
                "drop2",
                "drop3"
        };

        //Defining GUI
        this.setGUISettings("Demo", 900, 900, null, EXIT_ON_CLOSE, false, new KrumreyDefault());
        JButton buttonTest = this.addButton("Button", 10, 10, 480, 200, new PopUpButton());
        this.addLabel("Label", 10, 220, 480, 200);
        this.addCheckBox("CheckBox", 10, 460, 100, 20);
        this.addTextField("Text Field", 200, 460, 100, 20, null);
        this.addImageLabel(testImage1, 100, 700, 100, 100, ImageLabel.ScaleMode.STRETCH);
        this.addImageLabel(testImage1, 300, 700, 300, 200, ImageLabel.ScaleMode.TRANSPARENTBARS);
        this.addImageLabel(testImage2, 200, 550, 100, 200, ImageLabel.ScaleMode.COLOREDBARS);
        this.addRightClickPopUpMenu(popUps, popUpCommands, 0, 900, 0, 900);
        this.addDropDownMenu(drops, 600, 200, 250, 400);

        this.setVisible(true);

    }

    /**
     * Main Method that starts the GUI
     * @param args - Command Line Parameters
     */
    public static void main(String[] args) {
        new BasicGUIDemo();
    }

    /**
     * Class that implements an Actionlistener that just shows a message box.
     */
    private class PopUpButton implements ActionListener {

        /**
         * Shows a simple message box
         * @param actionEvent - the button press event
         */
        public void actionPerformed(ActionEvent actionEvent) {
            BasicGUIDemo.this.showMessageBox("Message", "Message Box", -1, -1);
        }
    }

    /**
     * Class that implements an Actionlistener that starts a confirmation prompt
     */
    private class AskUser implements ActionListener {

        /**
         * Starts the prompt and shows a message box afterwards
         * @param actionEvent - the button press event
         */
        public void actionPerformed(ActionEvent actionEvent) {
            if (BasicGUIDemo.this.showConfirmationPrompt("Hello! Click on Yes", "Confirmation Prompt", -1, -1)) {
                BasicGUIDemo.this.showMessageBox("Great Success!", "Message Box", 700, 300);
            } else {
                BasicGUIDemo.this.showMessageBox("Epic Fail!", "Message Box", 300, 700);
            }
        }
    }

    /**
     * Class that implements an Actionlistener that starts an input dialog
     */
    private class AskUserText implements ActionListener {

        /**
         * Starts the prompt and shows a message box afterwards
         * @param actionEvent - the button press event
         */
        public void actionPerformed(ActionEvent actionEvent) {
            if (BasicGUIDemo.this.showInputDialog("Hello! Ente: Hello!", "Input Dialog", -1, -1).equals("Hello!")) {
                BasicGUIDemo.this.showMessageBox("Great Success!", "Message Box", 700, 300);
            } else {
                BasicGUIDemo.this.showMessageBox("Epic Fail!", "Message Box", 300, 700);
            }
        }
    }
}
