/*
 * Copyright (c) 2020, Rachko and/or its affiliates. All rights reserved.
 * RACHKO PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 */

package by_epam.introduction_to_java.basics_of_OOP_5.task05.view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Class for output the message.
 * I can change this class and go the message everywhere.
 */
public class ConsoleHelper {
    private static final BufferedReader READER = new BufferedReader(new InputStreamReader(System.in));

    public static void writeMessage(String message) {
        System.out.println(message);
    }

    public static String readString() {
        String text = null;
        try {
            text = READER.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return text;
    }

    public static int readInt() {
        String text = readString();
        return Integer.parseInt(text.trim());
    }
}
