package com.habr.lambda.peopleexample;

import java.util.Objects;

public class People {
    private String name;
    private int age;
    private Sex sex;

    public People(String name, int age, Sex sex) {
        this.name = name;
        this.age = age;
        this.sex = sex;
    }

    public String getName() { return name; }

    public int getAge() { return age; }

    public Sex getSex() { return sex; }

    public void setName(String name) { this.name = name; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof People)) return false;
        People people = (People) o;
        return age == people.age &&
                Objects.equals(name, people.name) &&
                sex == people.sex;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age, sex);
    }

    @Override
    public String toString() {
        return "People{" + "name='" + name + '\'' +
                ", age=" + age +
                ", sex=" + sex + '}';
    }
}
