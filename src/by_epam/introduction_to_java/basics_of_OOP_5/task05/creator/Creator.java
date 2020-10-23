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

package by_epam.introduction_to_java.basics_of_OOP_5.task05.creator;

import by_epam.introduction_to_java.basics_of_OOP_5.task05.entity.Product;

/**
 * Common interface for creators.
 * @author Aliaksandr Rachko
 */
public interface Creator {

    /**
     * Creates and returns product by name.
     */
    Product createProduct(String name);
}
