package by_epam.introduction_to_java.programming_with_classes_4.aggregation_and_composition.task05;

/*
 * 5. Туристические путевки.
 *    Сформировать набор предложений клиенту по выбору туристической путевки различного типа
 *    (отдых, экскурсии, лечение, шопинг, круиз и т. д.) для оптимального выбора.
 *    Учитывать возможность выбора транспорта, питания и числа дней. Реализовать выбор и сортировку путевок.
 */

import java.util.Objects;

public class Travel{
    private String name; // название путевки
    private String description; // описание
    private TypeOfTour type; // тип
    private Transport transport; // тип транспорта
    private int days; // количестов дней
    private Food food; // питание

    public Travel(String name, String description, TypeOfTour type, Transport transport, int days, Food food) {
        this.name = name;
        this.description = description;
        this.type = type;
        this.transport = transport;
        this.days = days;
        this.food = food;
    }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public String getDescription() { return description; }

    public void setDescription(String description) { this.description = description; }

    public TypeOfTour getType() { return type; }

    public void setType(TypeOfTour type) { this.type = type; }

    public Transport getTransport() { return transport; }

    public void setTransport(Transport transport) { this.transport = transport; }

    public int getDays() { return days; }

    public void setDays(int days) { this.days = days; }

    public Food getFood() { return food; }

    public void setFood(Food food) { this.food = food; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Travel)) return false;
        Travel travel = (Travel) o;
        return getType() == travel.getType() &&
                getTransport() == travel.getTransport() &&
                getFood() == travel.getFood();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getType(), getTransport(), getDays(), getFood());
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Travel{");
        sb.append("name='").append(name).append('\'');
        sb.append(", description='").append(description).append('\'');
        sb.append(", type=").append(type);
        sb.append(", transport=").append(transport);
        sb.append(", days=").append(days);
        sb.append('}');
        return sb.toString();
    }
}