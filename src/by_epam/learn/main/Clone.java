package by_epam.learn.main;

import java.util.Objects;

public class Clone implements Cloneable, Comparable<Clone>{
    public static void main(String[] args) throws CloneNotSupportedException {
        Clone clone = new Clone("Clone 1", 2);
        Clone clone1 = (Clone) clone.clone();

        System.out.println(clone);
        System.out.println(clone1);
    }


    private String name;
    private int age;

    public Clone(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Clone{");
        sb.append("name='").append(name).append('\'');
        sb.append(", age=").append(age);
        sb.append('}');
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Clone)) return false;
        Clone clone = (Clone) o;
        return age == clone.age &&
                Objects.equals(name, clone.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }

    @Override
    public int compareTo(Clone o) {
        return this.name.compareTo(o.name);
    }
}
