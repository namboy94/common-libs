package com.krumreyh.java.krumrey.commons.gui.swing.demos;

import com.krumreyh.java.krumrey.commons.gui.swing.config.StyleConfig;
import com.krumreyh.java.krumrey.commons.gui.swing.templates.BasicGUI;

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
                "FF0000", //RED
                "005EFF", //BLUE
                "09FF00", //GREEN
                "FF9D00", //ORANGE
                "FFF700", //YELLOW
                "FF00F7", //PURPLE
                "000000" //BLACK
        };
        StyleConfig style = new StyleConfig(colors, null);

        this.setGUISettings("Demo", 500, 500, null, EXIT_ON_CLOSE, false, style);
        this.addButton("Button", 10, 10, 480, 200, null);
        this.addLabel("Label", 10, 220, 480, 200);
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
