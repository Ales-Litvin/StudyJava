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

package by_epam.introduction_to_java.basics_of_OOP_5.task03;

/*
 * Условие задачи:
 * Задача 3.
 * Создать класс Календарь с внутренним классом,
 * с помощью объектов которого можно хранить информацию о выходных и праздничных днях.
 */

import java.util.*;

/**
 * This class stores information about events.
 * @author Aliaksandr Rachko
 * @version 1.0
 */
public class Calendar {
    private List<Event> events;

    /**
     * Creates the calendar uses list of events.
     */
    public Calendar(List<Event> events) { this.events = events; }

    /**
     * Creates this the calendar uses events from other calendar.
     */
    public Calendar(Calendar calendar) {
        this.events = new ArrayList<>();
        events.addAll(calendar.getEvents());
    }

    /**
     * Creates the empty calendar.
     */
    public Calendar() { this.events = new ArrayList<>(); }

    public List<Event> getEvents() { return events; }

    public void setEvents(List<Event> events) { this.events = events; }

    public void add(String name, String description, Date date){
        if (description == null || description.length() == 0){
            events.add(new Event(name, date));
        } else {
            events.add(new Event(name, description, date));
        }
    }

    public Event getEvent(String name){
        for (Event event : events){
            if (event.getName().equals(name)){
                return event;
            }
        }
        return null;
    }

   public Event getEvent(Date date){
       for (Event event : events){
           if (event.getDate().equals(date)){
               return event;
           }
       }
       return null;
   }

    /**
     * Removes event by name.
     */
    public void remove(String name){
        events.removeIf(event -> event.getName().equals(name));
    }

    /**
     * Removes event by date.
     */
    public void remove(Date date){
        events.removeIf(event -> event.getDate().equals(date));
    }

    /**
     * Sorts list of events by date.
     */
    private void sortByDate(){
        events.sort(new Comparator<Event>() {
            @Override
            public int compare(Event o1, Event o2) {
                return o1.getDate().compareTo(o2.getDate());
            }
        });
        GregorianCalendar gregorianCalendar = new GregorianCalendar();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Calendar)) return false;
        Calendar calendar = (Calendar) o;
        return Objects.equals(getEvents(), calendar.getEvents());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getEvents());
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Calendar{");
        sb.append(events);
        sb.append('}');
        return sb.toString();
    }

    /*
              Class whit stories data about event,
              with <b>name</b>, <b>description</b>, </b>date</b>.
             */
    static class Event{
        private String name;
        private String description;
        private Date date;

        public Event(String name, String description, Date date) {
            this.name = name;
            this.description = description;
            this.date = date;
        }

        public Event(String name, Date date) {
            this.name = name;
            this.description = "Описание события";
            this.date = date;
        }

        public String getName() { return name; }

        public void setName(String name) { this.name = name; }

        public String getDescription() { return description; }

        public void setDescription(String description) { this.description = description; }

        public Date getDate() { return date; }

        public void setDate(Date date) { this.date = date; }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Event)) return false;
            Event event = (Event) o;
            return Objects.equals(getName(), event.getName()) &&
                    Objects.equals(getDate(), event.getDate());
        }

        @Override
        public int hashCode() {
            return Objects.hash(getName(), getDate());
        }

        @Override
        public String toString() {
            final StringBuilder sb = new StringBuilder("Event{");
            sb.append("'").append(name).append('\'');
            sb.append(": ").append(date);
            sb.append(", '").append(description).append('\'');
            sb.append('}');
            return sb.toString();
        }
    }
}
