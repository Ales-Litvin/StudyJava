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

import by_epam.introduction_to_java.basics_of_OOP_5.task05.view.ConsoleHelper;
import by_epam.introduction_to_java.basics_of_OOP_5.task05.entity.Product;
import by_epam.introduction_to_java.basics_of_OOP_5.task05.entity.pack.Pack;
import by_epam.introduction_to_java.basics_of_OOP_5.task05.entity.pack.PackType;

/**
 * The base class of the pack factory.
 * @see Pack
 * @see PackType
 * @see Creator
 * @author Aliaksandr Rachko
 */
public class PackCreator implements Creator{

    /**
     * Returns product class of {@link Pack}.
     * If name equals null or
     * <b\>enum<b\> {@link PackType} don't has need type.
     * @param name pack type in the <b\>enum<b\> {@link PackType}.
     */
    @Override
    public Product createProduct(String name) {
        PackType type;

        try {
            type = PackType.valueOf(name);
            return new Pack(type.getName(), type.getPrice());
        } catch (IllegalArgumentException e){
            ConsoleHelper.writeMessage("The product type '" + name + "' can't be create.");
        } catch (NullPointerException e1) {
            e1.printStackTrace();
        }

        return null;
    }
}
