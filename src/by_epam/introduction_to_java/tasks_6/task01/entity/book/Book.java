/*
 * Copyright (c) 2020, Rachko and/or its affiliates. All rights reserved.
 * RACHKO PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 */

package by_epam.introduction_to_java.tasks_6.task01.entity.book;

import java.io.Serializable;
import java.util.Objects;

public class Book implements Serializable {
    private String name;

    private TypeBook type;

    public Book(String name, TypeBook type) {
        this.name = name;
        this.type = type;
    }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public TypeBook getType() { return type; }

    public void setType(TypeBook type) { this.type = type; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Book)) return false;
        Book book = (Book) o;
        return Objects.equals(getName(), book.getName()) &&
                getType() == book.getType();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getType());
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Book{");
        sb.append("name='").append(name).append('\'');
        sb.append(", type=").append(type);
        sb.append('}');
        return sb.toString();
    }
}
