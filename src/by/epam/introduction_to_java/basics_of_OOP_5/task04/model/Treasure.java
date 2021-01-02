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

package by.epam.introduction_to_java.basics_of_OOP_5.task04.model;

import java.io.Serializable;
import java.util.Objects;

/**
 * Treasure.
 * @author Aliaksandr Rachko
 * @version 1.0
 */
public class Treasure implements Serializable {
    private String name;
    private double price;

    public Treasure(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public double getPrice() { return price; }

    public void setPrice(double price) { this.price = price; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Treasure)) return false;
        Treasure treasure = (Treasure) o;
        return Double.compare(treasure.getPrice(), getPrice()) == 0 &&
                Objects.equals(getName(), treasure.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getPrice());
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Treasure{");
        sb.append("'").append(name).append('\'');
        sb.append(": ").append(price);
        sb.append(" unit");
        sb.append('}');
        return sb.toString();
    }
}
