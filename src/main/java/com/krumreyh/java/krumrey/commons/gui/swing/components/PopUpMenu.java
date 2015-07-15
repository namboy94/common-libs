package com.krumreyh.java.krumrey.commons.gui.swing.components;

import javax.swing.*;
import java.awt.event.ActionListener;

/**
 * Class that implements a PopUpMenu using Strings. Each String has its own command.
 * @author Hermann Krumrey (hermann@krumreyh.com)
 * @version 0.1-SNAPSHOT
 */
public class PopUpMenu extends JPopupMenu {

    /**
     * Constructs a new PopUpMenu Object containing various commands.
     * @param entries - the entries of the Menu as a String array. Sorted from top to bottom
     * @param commands - the command to every menu entry as ActionListeners.
     *                   Every Command's index must be equal to its menu entry's index.
     */
    public PopUpMenu(String[] entries, ActionListener[] commands) {
        if (entries.length != commands.length) {
            throw new IllegalArgumentException("Illegal amount of commands(" + commands.length
                                             + ") for this amount of menu entries(" + entries.length + ")");
        }
        for (int i = 0; i < entries.length; i++) {
            this.addMenuItem(entries[i], commands[i]);
        }
    }

    /**
     * Adds a Menu Item to the Popup Menu
     * @param name - the name of the entry
     * @param command - the command to be executed when the entry is selected
     */
    private void addMenuItem(String name, ActionListener command) {
        JMenuItem menuItem = new JMenuItem(name);
        menuItem.addActionListener(command);
        this.add(menuItem);

    }
}