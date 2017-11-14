/*
Copyright 2015-2017 Hermann Krumrey

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

package com.krumreyh.java.krumrey.commons.gui.swing.listeners;

import com.krumreyh.java.krumrey.commons.gui.swing.components.PopUpMenu;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.IllegalFormatCodePointException;

/**
 * Class to be used in a GUI to enable right clicking on a GUI to pop up a menu with String entries,
 * which execute a predefined action when clicked
 */
public class RightClickPopUpMenu extends MouseAdapter {

    private PopUpMenu menu;
    private int xStart;
    private int xEnd;
    private int yStart;
    private int yEnd;

    /**
     * Constructor for the Mouse Listener that defines what menu is used
     * @param menu - The menu to be displayed
     * @param xStart - the first point in x direction to be listened to
     * @param xEnd - the last point in x direction to be listened to
     * @param yStart - the first point in y direction to be listened to
     * @param yEnd - the last point in y direction to be listened to
     */
    public RightClickPopUpMenu(PopUpMenu menu, int xStart, int xEnd, int yStart, int yEnd) {

        this.menu = menu;
        this.xStart = xStart;
        this.xEnd = xEnd;
        this.yStart = yStart;
        this.yEnd = yEnd;

    }

    /**
     * listens for a right mouse button being pressed
     * @param e - mouse event (right click)
     */
    public void mousePressed(MouseEvent e) {
        if (e.isPopupTrigger()) {
            doPop(e);
        }
    }

    /**
     * listens for a right mouse button being released
     * @param e - mouse event (right click)
     */
    public void mouseReleased(MouseEvent e) {
        if (e.isPopupTrigger()) {
            doPop(e);
        }
    }

    /**
     * Action taken on right mouse click - opens the popup menu
     * @param e - the mouse click event
     */
    private void doPop(MouseEvent e) {
        if (e.getX() >= this.xStart && e.getX() <= this.xEnd) {
            if (e.getY() >= this.yStart && e.getY() <= this.yEnd) {
                this.menu.show(e.getComponent(), e.getX(), e.getY());
            }
        }
    }
}
