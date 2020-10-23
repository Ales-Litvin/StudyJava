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

package by_epam.introduction_to_java.basics_of_OOP_5.task05.entity;

import by_epam.introduction_to_java.basics_of_OOP_5.task05.entity.flower.Flower;
import by_epam.introduction_to_java.basics_of_OOP_5.task05.entity.pack.Pack;

import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

/**
 * Class describes flower composition in the pack.
 * @author Aliaksandr Rachko
 */
public class FlowerComposition implements Product {
    private List<Flower> flowers;
    private Pack pack;

    public FlowerComposition(List<Flower> flowers, Pack pack) {
        this.flowers = flowers;
        this.pack = pack;
    }

    /**
     * Returns describes of flower composition.
     */
    @Override
    public String getName() {
        Set<Flower> set = new HashSet<>(flowers);

        StringBuilder sb = new StringBuilder();
        sb.append("Composition : ");

        sb.append('\'').append(pack.getName()).append("' ,");

        for (Flower flower : set){
            if (flower == null) continue;
            sb.append('\'').append(flower.getName()).append('\'');
            sb.append(" - ").append(getCount(flower)).append(" pcs., ");
        }

        sb.append("price ").append(String.format("%.2f", getPrice()));
        sb.append(" $.");
        return sb.toString();
    }

    /**
     * Returns total price of flower composition.
     */
    @Override
    public double getPrice() {
        double totalPrice = pack.getPrice();
        for (Flower flower : flowers){
            if (flower == null) continue;
            totalPrice += flower.getPrice();
        }
        return totalPrice;
    }

    /**
     * Returns count of flower,
     * equals passed as a parameter.
     */
    private int getCount(Flower flower){
        int count = 0;
        for (Flower f : flowers) {
            if (flower.equals(f)) count++;
        }
        return count;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof FlowerComposition)) return false;
        FlowerComposition that = (FlowerComposition) o;
        return Objects.equals(flowers, that.flowers) &&
                Objects.equals(pack, that.pack);
    }

    @Override
    public int hashCode() {
        return Objects.hash(flowers, pack);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("FlowerComposition{");
        sb.append("flowers=").append(flowers);
        sb.append(", pack=").append(pack);
        sb.append('}');
        return sb.toString();
    }
}
