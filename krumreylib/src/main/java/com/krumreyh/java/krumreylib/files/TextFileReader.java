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

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * Class that reads the Content of a text file
 * @author Hermann Krumrey (hermann@krumreyh.com)
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