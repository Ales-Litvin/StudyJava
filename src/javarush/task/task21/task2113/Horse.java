package javarush.task.task21.task2113;

public class Horse {
    private String name;
    private double speed;
    private double distance;

    public Horse(String name, double speed, double distance) {
        this.name = name;
        this.speed = speed;
        this.distance = distance;
    }

    public String getName(){
        return this.name;
    }

    public double getSpeed(){
        return this.speed;
    }

    public double getDistance(){
        return this.distance;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setSpeed(double speed){
        this.speed = speed;
    }

    public void setDistance(double distance){
        this.distance = distance;
    }

    /*
     * Вычисляет дистанцию пройденную лошадью
     */
    public void move(){
        distance += speed * Math.random();
    }

    /*
     * Отрисовывает лошадь в виде
     * ......<name>
     */
    public void print(){
        for (int i = 0; i < (int) distance; i++){
            System.out.print(".");
        }
        System.out.println(getName());
    }
}