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

package by.epam.introduction_to_java.basics_of_OOP_5.task04.loader;

import by.epam.introduction_to_java.basics_of_OOP_5.task04.model.Treasure;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Load data about treasures from file.
 * @author Aliaksandr Rachko
 * @version 1.0
 */
public class DataLoader implements Loader{
    private String filename;

    public DataLoader(String name) { filename = name; }

    public String getFilename() { return filename; }

    public void setFilename(String filename) { this.filename = filename; }

    /**
     * Returns list of treasures form file.
     * In the file saved serialized list of treasures.
     */
    @Override
    public List<Treasure> getTreasures() {
        List<Treasure> treasures= new ArrayList<>();
        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
            treasures=((List<Treasure>)ois.readObject());
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return treasures;
    }

    /**
     * Saves list of treasures in the file, serializing its.
     */
    @Override
    public void store(List<Treasure> treasures) {
        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            oos.writeObject(treasures);
            System.out.println("File has been written.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}