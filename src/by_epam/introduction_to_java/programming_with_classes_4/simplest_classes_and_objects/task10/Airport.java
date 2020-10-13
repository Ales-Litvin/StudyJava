package by_epam.introduction_to_java.programming_with_classes_4.simplest_classes_and_objects.task10;

/*
 * Условие задачи см. class
 * by_epam.introduction_to_java.programming_with_classes_4.simplest_classes_and_objects.task10.Airline;
 */
import by_epam.introduction_to_java.programming_with_classes_4.simplest_classes_and_objects.task06.Time;

import java.time.DayOfWeek;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Airport {
    private final List<Airline> airlines;

    public Airport() {
        this.airlines = new ArrayList<>();
    }

    // getter
    public List<Airline> getBooks() { return airlines; }

    public void add(Airline airline){ airlines.add(airline); }

    public boolean remove(Airline airline){ return airlines.remove(airline); }

    /**
     * Removes airline by flight number
     * @param flightNumber flight number
     * @return <tt>true</tt> if this list contained the specified element
     */
    public boolean remove(int flightNumber){
        Iterator<Airline> itr = airlines.iterator();
        while (itr.hasNext()){
            if (itr.next().getFlightNumber() == flightNumber){
                itr.remove();
                return true;
            }
        }
        return false;
    }

    /**
     * Returns airlines with a givens destination
     * @param destination author of book
     * @return airlines with a givens destination
     */
    public List<Airline> getAirlinesForDestination(String destination){
        List<Airline> result = new ArrayList<>();

        for (Airline airline : airlines) {
            if (airline.getDestination().equals(destination)){
                result.add(airline);
            }
        }
        return result;
    }

    /**
     * Returns airlines with a givens day of week
     * @param day day of week
     * @return airlines with a givens day of week
     */
    public List<Airline> getAirlinesForDay(DayOfWeek day){
        List<Airline> result = new ArrayList<>();

        for (Airline airline : airlines) {
            if (airline.getDayOfWeeks().contains(day)){
                result.add(airline);
            }
        }
        return result;
    }

    public List<Airline> getAirlinesForDayAndTime(DayOfWeek day, Time time){
        List<Airline> result = new ArrayList<>();

        for (Airline airline : airlines) {
            if (airline.getDayOfWeeks().contains(day) &&
                    airline.getTime().after(time)){
                result.add(airline);
            }
        }
        return result;
    }
}
