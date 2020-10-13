package by_epam.introduction_to_java.programming_with_classes_4.simplest_classes_and_objects.task09;

/*
 * Условие задачи см. class
 * by_epam.introduction_to_java.programming_with_classes_4.simplest_classes_and_objects.task09.Book;
 */

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;

public class Library {
    private final List<Airline> airlines;

    public Library() {
        this.airlines = new ArrayList<>();
    }

    // getter
    public List<Airline> getBooks() { return airlines; }

    public void add(Airline airline){ airlines.add(airline); }

    public boolean remove(Airline airline){ return airlines.remove(airline); }

    /**
     * Removes book by id
     * @param id id of book
     * @return <tt>true</tt> if this list contained the specified element
     */
    public boolean remove(int id){
        Iterator<Airline> itr = airlines.iterator();

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
    public List<Airline> getBooksByAuthor(String author){
        List<Airline> result = new ArrayList<>();

        for (Airline airline : airlines) {
            if (airline.getAuthors().equals(author)){
                result.add(airline);
            }
        }
        return result;
    }

    /**
     * Returns books with a givens publishing house
     * @param publishingHouse name of publishing house
     * @return books with a givens publishing house
     */
    public List<Airline> getBooksByPublishingHouse(String publishingHouse){
        List<Airline> result = new ArrayList<>();

        for (Airline airline : airlines) {
            if (airline.getPublishingHouse().equals(publishingHouse)){
                result.add(airline);
            }
        }
        return result;
    }

    /**
     * Returns books created after a givens date
     * @param calendar a year
     * @return books created after a givens date
     */
    public List<Airline> getBooksFromYear(Calendar calendar){
        List<Airline> result = new ArrayList<>();

        for (Airline airline : airlines) {
            if (airline.getYearOfPublishing().after(calendar)){
                result.add(airline);
            }
        }
        return result;
    }
}
