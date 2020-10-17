package by_epam.introduction_to_java.programming_with_classes_4.simplest_classes_and_objects.task09;

/*
 * Условие задачи:
 * 9. Создать класс  Book, спецификация которого приведена ниже. Определить конструкторы,  set-  и  get-  методы и
 * метод   toString().  Создать  второй  класс,  агрегирующий  массив  типа  Book,  с  подходящими  конструкторами  и
 * методами. Задать критерии выбора данных и вывести эти данные на консоль.
 * Book: id, название, автор(ы), издательство, год издания, количество страниц, цена, тип переплета.
 *
 * Найти и вывести:
 * a) список книг заданного автора;
 * b) список книг, выпущенных заданным издательством;
 * c) список книг, выпущенных после заданного года.
 */

import java.util.Calendar;

public class Book {
    private long id;
    private String name;
    private String authors;
    private String publishingHouse;
    private Calendar yearOfPublishing;
    private int numberOfPages;
    private double price;
    private Binding binding; // тип переплета

    public Book(long id, String name, String authors, String publishingHouse, Calendar yearOfPublishing, int numberOfPages, double price, Binding binding) {
        this.id = id;
        this.name = name;
        this.authors = authors;
        this.publishingHouse = publishingHouse;
        this.yearOfPublishing = yearOfPublishing;
        this.numberOfPages = numberOfPages;
        this.price = price;
        this.binding = binding;
    }

    // getters
    public long getId() { return id; }

    public String getName() { return name; }

    public String getAuthors() { return authors; }

    public String getPublishingHouse() { return publishingHouse; }

    public Calendar getYearOfPublishing() { return yearOfPublishing; }

    public int getNumberOfPages() { return numberOfPages; }

    public double getPrice() { return price; }

    public Binding getBinding() { return binding; }

    // setters
    public void setId(long id) { this.id = id; }

    public void setName(String name) { this.name = name; }

    public void setAuthors(String authors) { this.authors = authors; }

    public void setPublishingHouse(String publishingHouse) { this.publishingHouse = publishingHouse; }

    public void setYearOfPublishing(Calendar yearOfPublishing) { this.yearOfPublishing = yearOfPublishing; }

    public void setNumberOfPages(int numberOfPages) { this.numberOfPages = numberOfPages; }

    public void setPrice(double price) { this.price = price; }

    public void setBinding(Binding binding) { this.binding = binding; }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Book{");
        sb.append("id=").append(id);
        sb.append(" '").append(name).append("' ");
        sb.append(authors).append(" ");
        String date = String.format("(%1$tY-%1$tm-%1$td)", yearOfPublishing);
        sb.append(date).append(" ");
        sb.append("p.").append(numberOfPages).append(" ");
        sb.append('}');
        return sb.toString();
    }
}
