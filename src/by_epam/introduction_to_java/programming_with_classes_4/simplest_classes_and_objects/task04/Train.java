package by_epam.introduction_to_java.programming_with_classes_4.simplest_classes_and_objects.task04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Date;

/*
 * Уловие задачи:
 * 4. Создайте класс Train, содержащий поля: название пункта назначения, номер поезда, время отпраления.
 *    Создайте данные в массив из пяти элементов типа Train,
 *        добавте возможность сортировки элементов массива по номерам поездов.
 *    Добавте возможность вывода информации о поезде, номер которого введен пользователем.
 *    Добавте возможность сортировки массив по пункту назанчения,
 *        причем поезда с одинаковыми пунктами назначения должны быть упорядочены по времени отправления.
 */
public class Train {
    // method for testing
    public static void main(String[] args) {
        Train[] trains = new Train[5];
        trains[0] = new Train("Minsk", 40, "25-10-2020 at 12:00");
        trains[1] = new Train("Warsaw", 55, "10-10-2020 at 06:45");
        trains[2] = new Train("Lviv", 35, "15-12-2020 at 04:50");
        trains[3] = new Train("London", 1, new Date());
        trains[4] = new Train("Berlin", 12, "04-05-1945 at 04:00");

        // сортировка массива по номерам поездов
        sortByNumber(trains);
        System.out.println(Arrays.toString(trains));

        // вызов информации о поезде по номеру
        printByNumber(trains);

        // сортировка массива по пункту назанчения и времени
        sortByDestination(trains);
        System.out.println(Arrays.toString(trains));
    }

    /**
     * Point where the train arrives
     */
    private String destination;

    /**
     * Number of the train
     */
    private int trainNumber;

    /**
     * Time when the train leaves a station
     */
    private Date departureTime;

    /**
     * Format of departure time
     */
    public static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("dd-MM-yyyy 'at' HH:mm");

    public Train(String destination, int trainNumber, String departureTime) {
        this.destination = destination;
        this.trainNumber = trainNumber;
        try {
            this.departureTime = DATE_FORMAT.parse(departureTime);
        } catch (ParseException e) {
            System.out.println("Вермя отправление указанно в неверном форамте!");
            System.out.println("dd-MM-yyyy at HH:mm" + " - " + departureTime);
        }
    }

    public Train(String destination, int trainNumber, Date departureTime) {
        this.destination = destination;
        this.trainNumber = trainNumber;
        this.departureTime = departureTime;
    }

    // getters and setters
    public String getDestination() { return destination; }

    public void setDestination(String destination) { this.destination = destination; }

    public int getTrainNumber() { return trainNumber; }

    public void setTrainNumber(int trainNumber) { this.trainNumber = trainNumber; }

    public Date getDepartureTime() { return departureTime; }

    public void setDepartureTime(String departureTime) {
        try {
            this.departureTime = DATE_FORMAT.parse(departureTime);
        } catch (ParseException e) {
            System.out.println("Вермя отправление указанно в неверном форамте!");
            System.out.println("dd-MM-yyyy at HH:mm" + " - " + departureTime);
        }
    }

    public void setDepartureTime(Date departureTime) { this.departureTime = departureTime; }

    @Override
    public String toString() {
        return "Train N" + trainNumber +
                " to '" + destination + '\'' +
                " in " + DATE_FORMAT.format(departureTime);
    }

    /**
     * Sorting a arrays with trains by number of train.
     * @param trains a arrays with trains.
     */
    public static void sortByNumber(Train[] trains){
        Arrays.sort(trains, new Comparator<Train>() {
            @Override
            public int compare(Train o1, Train o2) {
                return o1.trainNumber - o2.trainNumber;
            }
        });
    }

    /**
     * Sorting a arrays with trains by destination and then departure time.
     * @param trains a arrays with trains.
     */
    public static void sortByDestination(Train[] trains){
        Arrays.sort(trains, new Comparator<Train>() {
            @Override
            public int compare(Train o1, Train o2) {
                return o1.destination.compareTo(o2.destination);
            }
        }.thenComparing(new Comparator<Train>() {
            @Override
            public int compare(Train o1, Train o2) {
                return o1.departureTime.compareTo(o2.departureTime);
            }
        }));
    }

    /**
     * Prints information about train with number {@param trainNumber}.
     * @param trains a arrays with trains.
     */
    public static void printByNumber(Train[] trains){
        System.out.println("Введите номер поезда для получения информации");

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int trainNumber = 0;

        try {
            trainNumber = Integer.parseInt(reader.readLine());
        } catch (NumberFormatException e) {
            System.out.println("Ведены некорректные данные.");
            return;
        } catch (IOException e) {
            e.printStackTrace();
        }

        for (Train t : trains){
            if (t.trainNumber == trainNumber){
                System.out.println(t);
            }
        }
    }


}
