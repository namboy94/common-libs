package com.krumreyh.java.krumrey.commons.gui.swing.components;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * Class that creates a JLabel with an Image as an Icon.
 * @author Hermann Krumrey (hermann@krumreyh.com)
 * @version 0.1-SNAPHOT
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
            case COLOREDBARS:       scaled = coloredBarScale(image, xSize, ySize);
                                    this.setBackground(background);
                                    break;
            case TRANSPARENTBARS:   scaled = transparentBarsScale(image, xSize, ySize);
                                    break;
            default:
        }

        this.setSize(xSize, ySize);
        this.setIcon(new ImageIcon(scaled));

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
     * Scales a BufferedImage to a set dimension and add colored bars to maintain aspect ratio
     * @param image - the image to be scaled
     * @param xSize - the new width of the image
     * @param ySize - the new height of the image
     * @return the scaled image
     */
    private BufferedImage coloredBarScale(BufferedImage image, int xSize, int ySize) {
        return null;
    }

    /**
     * Stretches a BufferedImage to a set dimension while maintaining aspect ratio, without creating colored bars.
     * @param image - the image to be scaled
     * @param xSize - the new width of the image
     * @param ySize - the new height of the image
     * @return the scaled image
     */
    private BufferedImage transparentBarsScale(BufferedImage image, int xSize, int ySize) {
        return null;
    }

    /**
     * Enum that defines wether to stretch the image to size, leave transparent Bars or black Bars.
     */
    public enum ScaleMode {
        STRETCH, COLOREDBARS, TRANSPARENTBARS
    }
}