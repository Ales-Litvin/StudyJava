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

package by_epam.introduction_to_java.tasks_6.task02.loader;

import by_epam.introduction_to_java.tasks_6.task01.view.View;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Load data from file and to file.
 *
 * @author Aliaksandr Rachko
 * @version 1.0
 */
public class DataLoader<T> {
    private final String filename;

    public DataLoader(String name) { filename = name; }

    public String getFilename() { return filename; }

    /**
     * Returns list of object from file.
     */
    public List<T> load() {
        List<T> t= new ArrayList<>();
        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
            t=((List<T>)ois.readObject());
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return t;
    }

    /**
     * Saves list of object in the file, serializing its.
     */
    public void store(List<T> t) {
        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            oos.writeObject(t);
            View.writeMessage("File has been written.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}