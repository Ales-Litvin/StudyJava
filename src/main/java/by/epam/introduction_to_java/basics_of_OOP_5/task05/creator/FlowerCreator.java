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

package by.epam.introduction_to_java.basics_of_OOP_5.task05.creator;

import by.epam.introduction_to_java.basics_of_OOP_5.task05.view.ConsoleHelper;
import by.epam.introduction_to_java.basics_of_OOP_5.task05.entity.Product;
import by.epam.introduction_to_java.basics_of_OOP_5.task05.entity.flower.Flower;
import by.epam.introduction_to_java.basics_of_OOP_5.task05.entity.flower.FlowerType;

/**
 * The base class of the flower factory.
 * @see Flower
 * @see FlowerType
 * @see Creator
 * @author Aliaksandr Rachko
 */
public class FlowerCreator implements Creator{

    /**
     * Returns product class of {@link Flower}.
     * If name equals null or
     * <b\>enum<b\> {@link FlowerType} don't has need type.
     * @param name flower type in the <b\>enum<b\> {@link FlowerType}.
     */
    @Override
    public Product createProduct(String name) {
        FlowerType type;

        try {
            type = FlowerType.valueOf(name);
            return new Flower(type.getName(), type.getPrice());
        } catch (IllegalArgumentException e){
            ConsoleHelper.writeMessage("The product type '" + name + "' can't be create.");
        } catch (NullPointerException e1) {
            e1.printStackTrace();
        }

        return null;
    }
}