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

package com.krumreyh.java.krumreylib.files;

import java.io.File;
import java.util.Arrays;

/**
 * Class that extends the standard Java File class and enhances it with various helpful methods
 * @author Hermann Krumrey (hermann@krumreyh.com)
 */
public class AdvancedFile extends File {

    /**
     * Implements the parent class constructor
     * @param pathname - the file's path
     */
    public AdvancedFile(String pathname) {
        super(pathname);
        this.renameTo(this.getPureName());

    }

    /**
     * Turns a regular file into an AdvancedFile
     * @param file - the file to be turned into an AdvancedFile
     * @return the newly created AdvancedFile
     */
    public static AdvancedFile turnIntoAdvancedFile(File file) {
        String pathname = file.getAbsolutePath();
        pathname += new AdvancedFile(pathname).getDivider();
        pathname += file.getName();
        return new AdvancedFile(pathname);
    }

    /**
     * Santizes a file name so that it can be used on Windows as well as UNIX systems without any problems
     * @param fileName - the current file name
     * @return the sanitized file name
     */
    public static String sanitizeFileName(String fileName) {
        String newFileName = fileName;
        char[] illegalCharacters = {'<', '>', ':', '\"', '/', '\\', '|', '?', '*'};
        for (int i = 0; i < illegalCharacters.length; i++) {
            if (fileName.indexOf(illegalCharacters[i]) != -1) {
                newFileName = newFileName.replace("" + illegalCharacters[i], "");
            }
        }
        return newFileName;
    }

    /**
     * Method that gives information about wether this object is a File
     * @return - true if the file exists and is a file
     */
    public boolean isFile() {
        return (this.exists() && this.isFile());
    }

    /**
     * Method that gives information about wether this object is a directory
     * @return true if the file exists and is a directory
     */
    public boolean isDirectory() {
        return (this.exists() && this.isDirectory());
    }

    /**
     * Establishes the file extension of the File
     * @return the file's file extension
     */
    public String getExtension() {
        if (this.isFile()) {
            String file = this.getName();
            return file.substring(file.lastIndexOf(".") + 1);
        } else {
            return "";
        }
    }

    /**
     * Returns the file system divider
      * @return \ on Windows, / on UNIX-based systems.
     */
    public String getDivider() {
        if (this.getAbsolutePath().contains("/")) {
            return "/";
        } else {
            return "\\";
        }
    }

    /**
     * Renames a file, sanitizing the new file name beforehand
     * @param newName - The new name of the file
     */
    public boolean renameTo(String newName) {
        String sanitized = sanitizeFileName(newName);
        String extension = this.getExtension();
        String path = this.getParentFile().getAbsolutePath() + this.getDivider();
        if (this.isFile()) {
            return this.renameTo(new File(path + sanitized + "." + extension));
        } else {
            return this.renameTo(new File(path + sanitized));
        }
    }

    /**
     * Gets the pure filename of the file
     * @return - the pure filename - no extensions or paths.
     */
    public String getPureName() {
        if (this.isDirectory()) {
            return this.getName();
        }
        String pureName = "";
        String[] split = pureName.split("." + this.getExtension());

        for (int i = 0; i < (split.length - 1); i++) {
            pureName += split[i];
        }
        return pureName;
    }

    /**
     * Getter-Method that returns all child items of a directory
     * @return - the children as AdvancedFile objects
     */
    public AdvancedFile[] getChildren() {
        if (!this.isDirectory()) {
            return null;
        } else {
            File[] children = this.listFiles();
            if (children != null) {
                Arrays.sort(children);
                AdvancedFile[] advancedChildren = new AdvancedFile[children.length];
                for (int i = 0; i < children.length; i++) {
                    advancedChildren[i] = turnIntoAdvancedFile(children[i]);
                }
                return advancedChildren;
            } else {
                return new AdvancedFile[0];
            }
        }
    }

    /**
     * Getter-Method that returns all child directories of a directory
     * @return the directories as an AdvancedFile array
     */
    public AdvancedFile[] getChildDirectories() {
        AdvancedFile[] children = this.getChildren();
        int amountOfDirectories = 0;
        for (int i = 0; i < children.length; i++) {
            if (children[i].isDirectory()) {
                amountOfDirectories++;
            }
        }
        AdvancedFile[] directoryChildren = new AdvancedFile[amountOfDirectories];
        int j = 0;
        for (int i = 0; i < amountOfDirectories; i++) {
            if (children[i].isDirectory()) {
                directoryChildren[j] = children[i];
                j++;
            }
        }
        return directoryChildren;
    }

    /**
     * Getter-Method that returns all child files of a directory
     * @return the files as an AdvancedFile array
     */
    public AdvancedFile[] getChildFiles() {
        AdvancedFile[] children = this.getChildren();
        int amountOfFiles = 0;
        for (int i = 0; i < children.length; i++) {
            if (children[i].isDirectory()) {
                amountOfFiles++;
            }
        }
        AdvancedFile[] fileChildren = new AdvancedFile[amountOfFiles];
        int j = 0;
        for (int i = 0; i < amountOfFiles; i++) {
            if (children[i].isFile()) {
                fileChildren[j] = children[i];
                j++;
            }
        }
        return fileChildren;
    }

    /**
     * Determines if a directory has any children
     * @return true if children files/directories were found, false otherwise.
     */
    public boolean hasChildren() {
        File[] children = this.listFiles();
        if (children == null) {
            return false;
        } else {
            return !(this.listFiles().length == 0);
        }
    }

}