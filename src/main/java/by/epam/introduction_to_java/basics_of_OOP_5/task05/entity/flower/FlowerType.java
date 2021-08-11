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

package by.epam.introduction_to_java.basics_of_OOP_5.task05.entity.flower;

/**
 * Enum for type of flower.
 * @author Aliaksandr Rachko
 */
public enum FlowerType {
    ASTER("ASTER", 4.00),
    BLUEBELL("BLUEBELL", 3.20),
    CARNATION("CARNATION", 2.20),
    ROSE("ROSE", 5.50),
    ORCHID("ORCHID", 6.00),
    DAFFODIL("DAFFODIL", 4.50);

    private String name;
    private double price;


    FlowerType(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() { return name; }

    public double getPrice() { return price; }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("'").append(name).append("'");
        sb.append(" - ").append(price).append(" $");
        return sb.toString();
    }
}
