package by.epam.introduction_to_java.programming_with_classes_4.aggregation_and_composition.task03;

/*
 * Условие задачи:
 * 3. Создать объект класса Государство, используя классы Область, Район, Город.
 *    Методы: вывести на консоль столицу, количество областей, площадь, областные центры.
 */

import java.util.ArrayList;
import java.util.List;

public class State {
    private String name;
    private City capital;

    private List<Region> regions;

    public State(String name, City capital, List<Region> regions) {
        this.name = name;
        this.capital = capital;
        this.regions = regions;
    }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public City getCapital() { return capital; }

    public void setCapital(City capital) { this.capital = capital; }

    public List<Region> getRegions() { return regions; }

    public void setRegions(List<Region> regions) { this.regions = regions; }

    /**
     * Prints name of the state.
     */
    public void printTheCapital(){
        System.out.printf("%s is the capital of %s\n", capital, name);
    }

    /**
     * Returns count of regions.
     * @return count of regions.
     */
    public int getCountOfRegions(){
        return regions.size();
    }

    /**
     * Counting sum area of regions
     * @return sum area of regions
     */
    public long getArea(){
        long result = 0L;
        for (Region region : regions){
            result += region.getArea();
        }
        return result;
    }

    /**
     * Returns all centres of regions
     * @return all centres of regions
     */
    public List<City> getRegionsCentres(){
        List<City> cities = new ArrayList<>();
        for (Region region : regions){
            cities.add(region.getRegionalCenter());
        }
        return cities;
    }
}
