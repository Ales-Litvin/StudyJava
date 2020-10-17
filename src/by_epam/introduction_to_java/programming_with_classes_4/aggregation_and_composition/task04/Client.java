package by_epam.introduction_to_java.programming_with_classes_4.aggregation_and_composition.task04;

import java.util.Objects;

/**
 * This class is customer and stores customer's data.
 */
public class Client {
    private String name;

    public Client(String name) { this.name = name; }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Client)) return false;
        Client client = (Client) o;
        return Objects.equals(getName(), client.getName());
    }

    @Override
    public int hashCode() { return Objects.hash(getName()); }

    @Override
    public String toString() {
        return "Client: " + name;
    }
}
