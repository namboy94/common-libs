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

package com.krumreyh.java.krumrey.commons.utility.terminal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Class that offers more convenient methods for interacting with the console/terminal
 * @author Hermann Krumrey (hermann@krumreyh.com)
 * @version 0.2-SNAPSHOT
 */
public class TerminalCommands {

    /**
     * Reads a line of input from the terminal by the user and turns it into a String
     * @return the user's input as string
     */
    public static String readLine() {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        try {
            return in.readLine();
        } catch (IOException e) {
            /*
             * rethrow unchecked (!) exception to prevent students from being forced to use Exceptions before they have
             * been introduced in the lecture.
             */
            throw new RuntimeException(e);
        }
    }

    /**
     * Prints a line to the console and adds a newline
     * @param text - the text to be printed
     */
    public static void println(String text) {
        System.out.println(text);
    }

    /**
     * Prints a line to the console without adding a newline
     * @param text - the text to be printed
     */
    public static void print(String text) {
        System.out.print(text);
    }
}
