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

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;

public class Library {
    private final List<Book> books;

    public Library() {
        this.books = new ArrayList<>();
    }

    // getter
    public List<Book> getBooks() { return books; }

    public void add(Book book){ books.add(book); }

    public boolean remove(Book book){ return books.remove(book); }

    /**
     * Removes book by id
     * @param id id of book
     * @return <tt>true</tt> if this list contained the specified element
     */
    public boolean remove(int id){
        Iterator<Book> itr = books.iterator();

        while (itr.hasNext()){
            if (itr.next().getId() == id){
                itr.remove();
                return true;
            }
        }
        return false;
    }

    /**
     * Returns books with a givens author
     * @param author author of book
     * @return books with a givens author
     */
    public List<Book> getBooksByAuthor(String author){
        List<Book> result = new ArrayList<>();

        for (Book book : books) {
            if (book.getAuthors().equals(author)){
                result.add(book);
            }
        }
        return result;
    }

    /**
     * Returns books with a givens publishing house
     * @param publishingHouse name of publishing house
     * @return books with a givens publishing house
     */
    public List<Book> getBooksByPublishingHouse(String publishingHouse){
        List<Book> result = new ArrayList<>();

        for (Book book : books) {
            if (book.getPublishingHouse().equals(publishingHouse)){
                result.add(book);
            }
        }
        return result;
    }

    /**
     * Returns books created after a givens date
     * @param calendar a year
     * @return books created after a givens date
     */
    public List<Book> getBooksFromYear(Calendar calendar){
        List<Book> result = new ArrayList<>();

        for (Book book : books) {
            if (book.getYearOfPublishing().after(calendar)){
                result.add(book);
            }
        }
        return result;
    }
}
