package by_epam.introduction_to_java.basics_of_OOP_5.task01;

/*
 * Условие задачи:
 * Задача 1.
 * Создать объект класса Текстовый файл, используя классы Файл, Директория.
 * Методы: создать, переименовать, вывести на консоль содержимое, дополнить, удалить.
 */

import java.util.Objects;

public class TextFile extends File {
    private String content;

    public TextFile(String name, String content) {
        super(name);
        this.content = content;
    }

    public String getContent() { return content; }

    public void setContent(String content) { this.content = content; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TextFile)) return false;
        if (!super.equals(o)) return false;
        TextFile textFile = (TextFile) o;
        return Objects.equals(getContent(), textFile.getContent());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getContent());
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("TextFile{");
        sb.append("name='").append(super.getName()).append('\'');
        sb.append(", content='").append(content).append('\'');
        sb.append('}');
        return sb.toString();
    }
}