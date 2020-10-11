package by_epam.introduction_to_java.strings_3.working_with_regular_expressions.task02.node;

import java.util.Objects;

public class Attribute {

    public String category;
    public String name;

    public Attribute(String nameAttribute, String value) {
        this.category = nameAttribute;
        this.name = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Attribute attribute = (Attribute) o;
        return Objects.equals(category, attribute.category) &&
                Objects.equals(name, attribute.name);
    }

    @Override
    public String toString() {
        if (category != null && name != null) {
            return ' ' + category + " = " +
                    '\"' + name + '\"';
        }
        return null;
    }
}
