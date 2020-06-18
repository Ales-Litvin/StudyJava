package javarush.task.task05.task0510;

public class Cat {
    // напишите тут ваш код
    String name;
    int weight;
    int age;
    String color;
    String address;

    public void initialize(String name){
        this.name = name;
        this.weight = 2;
        this.age = 3;
        this.color = "red";
        this.address = "Ul. Kukuevo";
    }

    public void initialize(String name, int weight, int age){
        this.name = name;
        this.weight = weight;
        this.age = age;
        this.color = "red";
        this.address = "Ul. Kukuevo";
    }

    public void initialize(String name, int age){
        this.name = name;
        this.weight = 2;
        this.age = age;
        this.color = "red";
        this.address = "Ul. Kukuevo";
    }

    public void initialize(int weight, String color){
        this.name = null;
        this.weight = weight;
        this.color = color;
        this.age = 3;
        this.address = "Ul. Kukuevo";
    }

    public void initialize(int weight, String color, String address){
        this.name = null;
        this.weight = weight;
        this.color = color;
        this.age = 3;
        this.address = address;
    }

    public static void main(String[] args) {
    }
}
