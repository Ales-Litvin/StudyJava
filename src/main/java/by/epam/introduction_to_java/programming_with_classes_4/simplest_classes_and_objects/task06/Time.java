package by.epam.introduction_to_java.programming_with_classes_4.simplest_classes_and_objects.task06;

/*
 * Условие задачи:
 * 6. Составить описание класса для представления времени.
 *    Предусмотрите возможности установки времени и измения его отдельны полей
 *   (час, минута, секунда) с проверкой допустимсти вводимых значений. В случае
 *   недопустимых значений полей поле устанавливается в занчение 0. Создать
 *   методы изменения времени на заданное количество часов, минут и секунд.
 */
public class Time implements Comparable<Time>{
    // method for testing
    public static void main(String[] args) {
        Time time = new Time(12, 47, 18);

        System.out.println(time);
        time.setHours(60);
        time.setMinutes(100);
        time.setSeconds(10000);
        System.out.println(time);

        System.out.println(time.getTime());

        time.addHours(26);
        time.addMinutes(120);
        time.addSeconds(90);

        System.out.println(time);
    }

    private int hours;
    private int minutes;
    private int seconds;

    public Time(int hours, int minutes, int seconds) {
        this.hours = 0 <= hours & hours < 24 ? hours : 0;
        this.minutes = 0 <= minutes & minutes < 60 ? minutes : 0;
        this.seconds = 0 <= seconds & seconds < 60 ? seconds : 0;
    }

    // getters and setters
    public int getHours() { return hours; }

    public int getMinutes() { return minutes; }

    public int getSeconds() { return seconds; }

    public void setHours(int hours) { this.hours = 0 <= hours & hours < 24 ? hours : 0; }

    public void setMinutes(int minutes) { this.minutes = 0 <= minutes & minutes < 60 ? minutes : 0; }

    public void setSeconds(int seconds) { this.seconds = 0 <= seconds & seconds < 60 ? seconds : 0; }

    /**
     *  Returns the number of seconds.
     * @return the number of seconds.
     */
    private int getTime(){
        return (this.hours * 60 * 60) + (this.minutes * 60) + (this.seconds);
    }

    /**
     * Adds hours to the current time
     * @param hours a hours
     */
    public void addHours(int hours){
        initialization(getTime() + hours * 60 * 60);
    }

    /**
     * Adds minutes to the current time
     * @param minutes a minutes
     */
    public void addMinutes(int minutes){
        initialization(getTime() + minutes * 60);
    }

    /**
     * Adds seconds to the current time
     * @param seconds a seconds
     */
    public void addSeconds(int seconds){
        initialization(getTime() + seconds);
    }

    /**
     * Initializes this object with the given seconds.
     * @param seconds a seconds
     */
    private void initialization(int seconds){
        this.hours = (seconds / 3600) % 24;
        this.minutes = ((seconds - (this.hours * 60 * 60)) / 60) % 60;
        this.seconds = (seconds - (this.hours * 60 * 60) - (this.minutes * 60)) % 60;
    }

    @Override
    public String toString() {
        return "Time : " + hours + ':' + minutes + ':' + seconds;
    }

    @Override
    public int compareTo(Time o) {
        return Integer.compare(this.getTime(), o.getTime());
    }

    public boolean after(Time time){
        if(this.hours < time.hours){
            return false;
        } else if (this.minutes < time.minutes){
            return false;
        } else if (this.seconds < time.seconds){
            return false;
        }
        return true;
    }
}