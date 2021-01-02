package by.epam.introduction_to_java.programming_with_classes_4.aggregation_and_composition.task05;

public enum TypeOfTour {
    REST("Отдых"),
    TOUR("Экскурсия"),
    THERAPY("Лечение"),
    SHOPPING("Шопинг"),
    CRUISE("Круиз");

    private String name;

    TypeOfTour(String name) { this.name = name; }

    @Override
    public String toString() {
        return name;
    }
}
