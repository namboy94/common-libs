package com.krumreyh.java.krumrey.commons.gui.swing.demos;

import com.krumreyh.java.krumrey.commons.gui.swing.components.ImageLabel;
import com.krumreyh.java.krumrey.commons.gui.swing.config.StyleConfig;
import com.krumreyh.java.krumrey.commons.gui.swing.templates.BasicGUI;

import javax.imageio.ImageIO;
import java.awt.*;
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

        String[] colors = new String[] {
                "FF0000",   //RED       (GUI Background)
                "005EFF",   //BLUE      (Button Background)
                "09FF00",   //GREEN     (Button Foreground)
                "FF9D00",   //ORANGE    (Button Rollover)
                "FFF700",   //YELLOW    (Button Clicked)
                "FF00F7",   //PURPLE    (Label Background)
                "000000",   //BLACK     (Label Foreground)
                "FFFFFF",   //WHITE     (Checkbox Background)
                "999999",   //GREY      (Checkbox Foreground)
                "00FFB3",   //TURQOISE  (Text Field Background)
                "001EFF",   //BLUE      (Text Field Foreground)
                "000000",   //BLACK     (Scaled Image Border)
        };

        Font[] fonts = new Font[] {
                null,   //General Font
                null,   //Button Font
                null,   //Label Font
                null,   //Checkbox Font
                null    //Text Field Font
        };
        StyleConfig style = new StyleConfig(colors, null);

        BufferedImage testImage = null;
        try {
            testImage = ImageIO.read(new File("src/main/resources/images/fcb.png"));
        } catch (IOException e) {
            //TODO Show Popup Dialogue
        }

        this.setGUISettings("Demo", 500, 900, null, EXIT_ON_CLOSE, false, style);
        this.addButton("Button", 10, 10, 480, 200, null);
        this.addLabel("Label", 10, 220, 480, 200);
        this.addCheckBox("CheckBox", 10, 460, 100, 20);
        this.addTextField("Text Field", 200, 460, 100, 20);
        this.addImageLabel(testImage, 100, 700, 100, 100, ImageLabel.ScaleMode.STRETCH);
        this.addImageLabel(testImage, 300, 700, 300, 200, ImageLabel.ScaleMode.STRETCH);
        this.setVisible(true);

    }

    /**
     * Main Method that starts the GUI
     * @param args - Command Line Parameters
     */
    public static void main(String[] args) {
        new BasicGUIDemo();
    }

}
