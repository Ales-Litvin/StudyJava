package javarush.task.task21.lesson2113.Reflection;

public class Cat extends Animal{
    private static final String ANIMAL_FAMILY = "Семейство кошачьих";

    public Cat (){
    }

    public Cat (String name, int age){
        super(name, age);
    }

    private void sayMeow() {
        System.out.println("Meow!");
    }

}
