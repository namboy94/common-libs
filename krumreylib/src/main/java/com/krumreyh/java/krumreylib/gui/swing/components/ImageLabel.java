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

package com.krumreyh.java.krumreylib.gui.swing.components;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * Class that creates a JLabel with an Image as an Icon.
 * @author Hermann Krumrey (hermann@krumreyh.com)
 */
public class ImageLabel extends JLabel {

    /**
     * Constructor that defineds the Image Label
     * @param image - the image to be used
     * @param xSize - the width of the image label
     * @param ySize - the height of the image label
     * @param scaleMode - the scaling mode to be used:
     *                      STRETCH: stretches the image without regards to it's original proportions
     *                      COLOREDBARS: scales the image while maintaining aspect ratios, but adding colored bars
     *                      TRANSPARENTBARS: scales the image while maintaining aspect ratios without adding colored bars
     * @param background
     */
    public ImageLabel(BufferedImage image, int xSize, int ySize, ScaleMode scaleMode, Color background) {

        BufferedImage scaled = null;

        switch (scaleMode) {
            case STRETCH:           scaled = stretchScale(image, xSize, ySize);
                                    break;
            case COLOREDBARS:       scaled = aspectRatioScale(image, xSize, ySize);
                                    this.setBackground(background);
                                    this.setOpaque(true);
                                    break;
            case TRANSPARENTBARS:   scaled = aspectRatioScale(image, xSize, ySize);
                                    break;
            default:
        }

        this.setSize(xSize, ySize);
        this.setIcon(new ImageIcon(scaled));
        this.setHorizontalAlignment(JLabel.CENTER);
        this.setVerticalAlignment(JLabel.CENTER);

    }

    /**
     * Stretches a BufferedImage to a set dimension.
     * @param image - the image to be scaled
     * @param xSize - the new width of the image
     * @param ySize - the new height of the image
     * @return the scaled image
     */
    private BufferedImage stretchScale(BufferedImage image, int xSize, int ySize) {
        BufferedImage scaledImage = new BufferedImage(xSize, ySize, image.getType());
        Image tempImage = image.getScaledInstance(xSize, ySize, Image.SCALE_SMOOTH);
        Graphics graphic = scaledImage.getGraphics();
        graphic.drawImage(tempImage, 0, 0, null);
        graphic.dispose();
        return scaledImage;
    }

    /**
     * Stretches a BufferedImage to a set dimension while maintaining aspect ratio
     * @param image - the image to be scaled
     * @param xSize - the new width of the image
     * @param ySize - the new height of the image
     * @return the scaled image
     */
    private BufferedImage aspectRatioScale(BufferedImage image, int xSize, int ySize) {
        int newX = 0;
        int newY = 0;

        int currentX = image.getHeight();
        int currentY = image.getWidth();

        int ratio = currentX / currentY;

        if (xSize < ySize) {
            newX = xSize;
            newY = xSize / ratio;
        } else if (xSize > ySize) {
            newY = ySize;
            newX = ySize * ratio;
        } else {
            newX = xSize;
            newY = ySize;
        }

        return stretchScale(image, newX, newY);
    }

    /**
     * Enum that defines wether to stretch the image to size, leave transparent Bars or black Bars.
     */
    public enum ScaleMode {
        STRETCH, COLOREDBARS, TRANSPARENTBARS
    }
}