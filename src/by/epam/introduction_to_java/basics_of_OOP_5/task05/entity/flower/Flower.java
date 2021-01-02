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

import by.epam.introduction_to_java.basics_of_OOP_5.task05.entity.Product;

import java.util.Objects;

/**
 * Class Flower. Describes flower.
 * @author Aliaksandr Rachko
 */
public class Flower implements Product {
    private String name;

    private double price;

    public Flower(String name, double price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public String getName() { return name; }

    @Override
    public double getPrice() { return price; }

    public void setName(String name) { this.name = name; }

    public void setPrice(double price) { this.price = price; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Flower)) return false;
        Flower flower = (Flower) o;
        return Double.compare(flower.getPrice(), getPrice()) == 0 &&
                Objects.equals(getName(), flower.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getPrice());
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Flower{");
        sb.append("name='").append(name).append('\'');
        sb.append(", price=").append(price);
        sb.append('}');
        return sb.toString();
    }
}
