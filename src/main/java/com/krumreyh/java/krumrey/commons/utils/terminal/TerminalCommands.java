package com.krumreyh.java.krumrey.commons.utils.terminal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Class that offers more convenient methods for interacting with the console/terminal
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
