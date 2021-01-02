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

package by.epam.introduction_to_java.basics_of_OOP_5.task04.controller;

import by.epam.introduction_to_java.basics_of_OOP_5.task04.model.Cave;
import by.epam.introduction_to_java.basics_of_OOP_5.task04.model.Treasure;

import java.util.List;

/**
 * Controller processes client requests and returns the result.
 * @author Aliaksandr Rachko
 * @version 1.0
 */
public class Controller {
    private Cave cave;

    public Controller(Cave cave) {
        this.cave = cave;
    }

    public List<Treasure> getTreasures(){ return cave.getTreasures(); }

    public double getTotalPrice(List<Treasure> treasures){
        return cave.getTotalPrice(treasures);
    }

    public Treasure getTheMostExpensive(){ return cave.getTheMostExpensive(); }

    public List<Treasure> getTreasuresForPrice(double price){
        return cave.getTreasuresForPrice(price);
    }

    public void sortTreasuresByPrice(){ cave.sortByPrice(); }

    public void sortTreasuresByName() { cave.sortByName(); }
}
