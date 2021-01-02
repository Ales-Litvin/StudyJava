package by.epam.introduction_to_java.programming_with_classes_4.simplest_classes_and_objects.task09;

/**
 * Types of Binding (Типы переплета)
 */
public enum Binding {
    SADDLE("Saddle-stitching"),
    PERFECT("Perfect Binding"),
    SECTION("Section Sewn"),
    WIRE("Wire Binding"),
    SPIRAL("Spiral Binding"),
    PAMPHLET("Pamphlet Binding");

    private final String nameOfBinding;

    Binding(String s) {
        this.nameOfBinding = s;
    }

    public String getNameOfBinding() {
        return nameOfBinding;
    }

    @Override
    public String toString() {
        return nameOfBinding;
    }
}
