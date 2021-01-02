package by.epam.introduction_to_java.programming_with_classes_4.simplest_classes_and_objects.task10;

/*
 * Условие задачи:
 * 10. Создать класс Airline, спецификация которого приведена ниже. Определить
 * конструкторы,  set- и get- методы и метод  toString(). Создать второй класс,
 * агрегирующий массив типа  Airline, с подходящими конструкторами и методами.
 * Задать критерии выбора данных и вывести эти данные на консоль.
 * Airline: пункт назначения, номер рейса, тип самолета, время вылета,
 * дни недели.
 * Найти и вывести:
 * a) список рейсов для заданного пункта назначения;
 * b) список рейсов для заданного дня недели;
 * c) список рейсов для заданного дня недели, время вылета для которых больше
 *    заданного.
 */

import by.epam.introduction_to_java.programming_with_classes_4.simplest_classes_and_objects.task06.Time;

import java.time.DayOfWeek;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Airline {
    private String destination;
    private int flightNumber;
    private AircraftType aircraftType;
    private Time time;
    private List<DayOfWeek> dayOfWeeks;

    public Airline(String destination, int flightNumber, AircraftType aircraftType, Time time, DayOfWeek dayOfWeek) {
        this.destination = destination;
        this.flightNumber = flightNumber;
        this.aircraftType = aircraftType;
        this.time = time;
        this.dayOfWeeks = new ArrayList<>();
        this.dayOfWeeks.add(dayOfWeek);
    }

    public Airline(String destination, int flightNumber, AircraftType aircraftType, Time time, DayOfWeek[] dayOfWeeks) {
        this.destination = destination;
        this.flightNumber = flightNumber;
        this.aircraftType = aircraftType;
        this.time = time;
        this.dayOfWeeks = new ArrayList<>();
        this.dayOfWeeks.addAll(Arrays.asList(dayOfWeeks));
    }

    // getters
    public String getDestination() { return destination; }

    public int getFlightNumber() { return flightNumber; }

    public AircraftType getAircraftType() { return aircraftType; }

    public Time getTime() { return time; }

    public List<DayOfWeek> getDayOfWeeks() { return dayOfWeeks; }

    // setters
    public void setDestination(String destination) { this.destination = destination; }

    public void setFlightNumber(int flightNumber) { this.flightNumber = flightNumber; }

    public void setAircraftType(AircraftType aircraftType) { this.aircraftType = aircraftType; }

    public void setTime(Time time) { this.time = time; }

    public void setDayOfWeeks(List<DayOfWeek> dayOfWeeks) { this.dayOfWeeks = dayOfWeeks; }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Airline{");
        sb.append("to '").append(destination).append('\'');
        sb.append(" (№").append(flightNumber).append("), ");
        sb.append("plain ").append(aircraftType.toString());
        sb.append(", in ").append(time.toString());
        sb.append(", ").append(dayOfWeeks);
        sb.append('}');
        return sb.toString();
    }
}
