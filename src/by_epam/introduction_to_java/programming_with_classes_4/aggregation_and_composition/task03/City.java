package by_epam.introduction_to_java.programming_with_classes_4.aggregation_and_composition.task03;

public class City {
    /**
     * Name of the city
     */
    private String name;

    public City(String name) { this.name = name; }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    @Override
    public String toString() {
        return name;
    }
}
