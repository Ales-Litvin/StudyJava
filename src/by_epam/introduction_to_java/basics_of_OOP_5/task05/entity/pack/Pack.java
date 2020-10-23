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

package by_epam.introduction_to_java.basics_of_OOP_5.task05.entity.pack;

import by_epam.introduction_to_java.basics_of_OOP_5.task05.entity.Product;

import java.util.Objects;

/**
 * Class Pack. Describes pack.
 * @author Aliaksandr Rachko
 */
public class Pack implements Product {
    private String name;
    private double price;

    public Pack(String name, double price) {
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
        if (!(o instanceof Pack)) return false;
        Pack pack = (Pack) o;
        return Double.compare(pack.getPrice(), getPrice()) == 0 &&
                Objects.equals(getName(), pack.getName());
    }

    @Override
    public int hashCode() { return Objects.hash(getName(), getPrice()); }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Pack{");
        sb.append("name='").append(name).append('\'');
        sb.append(", price=").append(price);
        sb.append('}');
        return sb.toString();
    }
}
