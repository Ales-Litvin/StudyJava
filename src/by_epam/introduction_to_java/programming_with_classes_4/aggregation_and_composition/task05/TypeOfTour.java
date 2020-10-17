package by_epam.introduction_to_java.programming_with_classes_4.aggregation_and_composition.task05;
/*
 * Условие задачи см. class
 * by_epam.introduction_to_java.programming_with_classes_4.aggregation_and_composition.task05.Solution;
 */
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
