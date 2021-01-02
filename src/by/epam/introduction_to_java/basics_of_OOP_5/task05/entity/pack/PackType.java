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

package by.epam.introduction_to_java.basics_of_OOP_5.task05.entity.pack;


/**
 * Enum for type of pack for flowers.
 * @author Aliaksandr Rachko
 */
public enum  PackType {
    BOX("BOX", 6.80),
    BASKET("BASKET", 5.50),
    PAPER("PAPER", 2.30);

    private String name;
    private double price;

    PackType(String name, double price) {
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
