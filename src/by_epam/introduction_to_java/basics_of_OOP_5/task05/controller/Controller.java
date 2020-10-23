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

package by_epam.introduction_to_java.basics_of_OOP_5.task05.controller;

import by_epam.introduction_to_java.basics_of_OOP_5.task05.creator.CompositionCreator;
import by_epam.introduction_to_java.basics_of_OOP_5.task05.entity.Product;

/**
 * Controller processes client requests and returns the result.
 * @author Aliaksandr Rachko
 * @version 1.0
 */
public class Controller {
    private CompositionCreator compositionCreator;

    public Controller(CompositionCreator compositionCreator) {
        this.compositionCreator = compositionCreator;
    }

    public CompositionCreator getCompositionCreator() { return compositionCreator; }

    public void setCompositionCreator(CompositionCreator compositionCreator) {
        this.compositionCreator = compositionCreator;
    }

    public Product getProduct(String string){
        return compositionCreator.createProduct(string);
    }
}
