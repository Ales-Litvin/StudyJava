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
 *
 */

package by_epam.introduction_to_java.basics_of_OOP_5.task04.resources;

import by_epam.introduction_to_java.basics_of_OOP_5.task04.loader.DataLoader;
import by_epam.introduction_to_java.basics_of_OOP_5.task04.model.Treasure;

import java.util.ArrayList;
import java.util.List;

/**
 * Helps creates resources.
 * Loads list of treasures in the file
 */
public class Helper {
    public static void main(String[] args) {
        List<Treasure> list = new ArrayList<>();
        list.add(new Treasure("The Amber Room", 10000));
        list.add(new Treasure("Sarcophagus of Menkaure", 20000));
        list.add(new Treasure("Ark of the Covenant", 15000));
        list.add(new Treasure("Honjo Masamune Sword", 35000));
        list.add(new Treasure("Lost Library of the Moscow Tsars", 80000));
        list.add(new Treasure("Crown jewels of Ireland", 90000));
        list.add(new Treasure("Sappho's lost poems", 15000));
        list.add(new Treasure("Efrosinya's of Polotsk cross", 100000000));
        list.add(new Treasure("Dead Bishop's Treasure Stolen by Pirates", 15000));
        list.add(new Treasure("The Just Judges", 50000));
        list.add(new Treasure("The Florentine Diamond", 60000));
        list.add(new Treasure("Q Source", 5000));

        DataLoader loader = new DataLoader("G:\\Programming\\Work\\StudyJava\\src\\by_epam\\introduction_to_java\\basics_of_OOP_5\\task04\\resources\\treasures.txt");
        loader.store(list);
    }
}
