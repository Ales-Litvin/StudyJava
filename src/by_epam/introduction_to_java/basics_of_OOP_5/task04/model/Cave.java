package by_epam.introduction_to_java.basics_of_OOP_5.task04.model;

import java.util.*;

/**
 * Class for process data about treasures.
 */
public class Cave {
    private List<Treasure> treasures;

    public Cave(List<Treasure> treasures) { this.treasures = treasures; }

    public List<Treasure> getTreasures() { return treasures; }

    public void setTreasures(List<Treasure> treasures) { this.treasures = treasures; }

    /**
     * Sorts list of treasures by price.
     */
    public void sortByPrice(){
        treasures.sort(new Comparator<Treasure>() {
            @Override
            public int compare(Treasure o1, Treasure o2) {
                return Double.compare(o1.getPrice(), o2.getPrice());
            }
        });
    }

    /**
     * Sorts list of treasures by name.
     */
    public void sortByName(){
        treasures.sort(new Comparator<Treasure>() {
            @Override
            public int compare(Treasure o1, Treasure o2) {
                return o1.getName().compareTo(o2.getName());
            }
        });
    }

    /**
     * Counts amount all treasures.
     */
    public double getTotalPrice(List<Treasure> treasures){
        double result = 0;
        for (Treasure treasure : treasures){
            result += treasure.getPrice();
        }
        return result;
    }

    /**
     * Returns the most expensive treasure in the cave.
     */
    public Treasure getTheMostExpensive(){
        sortByPrice();
        return treasures.get(0);
    }

    /**
     * Returns random treasures for a given price.
     */
    public List<Treasure> getTreasuresForPrice(double price){
        List<Treasure> result = new ArrayList<>();

        Collections.shuffle(treasures, new Random());

        double sum = 0;

        for (Treasure treasure : treasures) {
            if (treasure.getPrice() + sum <= price) {
                result.add(treasure);
                sum += treasure.getPrice();
            }
        }
        return result;
    }
}
