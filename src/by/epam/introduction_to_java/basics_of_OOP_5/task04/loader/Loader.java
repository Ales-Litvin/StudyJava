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

import java.util.List;

/**
 * A loader for getting and stores data from resource.
 * @see DataLoader
 *
 * @author Aliaksandr Rachko
 * @version 1.0
 */
public interface Loader {

    /**
     * Gets treasures from resource.
     * @return list of treasures.
     */
    List<Treasure> getTreasures();

    /**
     * Stores data about treasures.
     */
    void store(List<Treasure> treasures);
}
