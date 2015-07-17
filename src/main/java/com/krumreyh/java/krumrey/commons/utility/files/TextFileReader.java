package com.krumreyh.java.krumrey.commons.utility.files;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * Class that reads the Content of a text file
 * @author Hermann Krumrey (hermann@krumreyh.com)
 * @version 0.2-SNAPSHOT
 */
public class TextFileReader {

    /**
     * Method that reads the content of a file and returns it as a String array
     * @param file - the file to be read
     * @return - the file's content as a String array
     */
    public static String[] readFile(File file) throws IOException {

        StringBuilder builder = new StringBuilder();
        FileReader in = new FileReader(file);

        BufferedReader reader = new BufferedReader(in);

        try {
            String line = reader.readLine();
            while (line != null) {
                builder.append(line);
                line = reader.readLine();
                if (line != null) {
                    builder.append("\n");
                }
            }

        } catch (IOException e) {
            throw new IOException("Failed Reading Text File");
        } finally {
            reader.close();
        }

        return builder.toString().split("\n");
    }

    /**
     * Method that reads the content of a file and returns it as a String array
     * @param file - the file to be read
     * @return - the file's content as a String array
     */
    public static String[] readFile(String file) throws IOException {
        return readFile(new File(file));
    }

}
