package by.epam.introduction_to_java.programming_with_classes_4.aggregation_and_composition.task02;

/*
 * Условие задачи:
 * 2. Создать объект класса Автомобиль, используя классы Колесо, Двигатель.
 * Методы: ехать, заправляться, менять колесо, вывести на консоль марку
 * автомобиля.
 */

public class Car {
    private String model;
    private Wheel[] wheels;
    private Engine engine;

    public Car() {
        this.engine = new Engine();
        this.wheels = new Wheel[]{new Wheel(), new Wheel(), new Wheel(), new Wheel()};
        this.model = "LADA";
    }

    /**
     * Returns true if this car has a engine
     * @return true if this car has a engine
     */
    public boolean hasEngine(){
        return engine != null;
    }

    /**
     * Returns true if this car has four wheels
     * @return true if this car has four wheels
     */
    public boolean hasWheels(){
        if (wheels.length == 4){
            for (Wheel wheel : wheels){
                if (wheel == null){
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    /**
     * Car moves
     */
    public void go(){
        if (model != null && hasEngine() && hasWheels()){
            System.out.println("This car " + model + " moves straight on...");
        }
    }

    /**
     * Refilling the car
     */
    public void refuel(){
        System.out.print("Refilling the car, wait");
        for (int i = 0; i < 10; i++){
            System.out.print(".");
            try {
                Thread.sleep(250);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("It's OK, you can go!");
    }

    /**
     * Change wheels
     * @param wheels array of wheels
     */
    public void changeWheels(Wheel[] wheels) {
        this.wheels = wheels;
        System.out.println("Changing wheels, wait ");
        for (int i = 0; i < wheels.length; i++){
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(" It's OK, you can go!");
    }

    /**
     * Change a wheel
     * @param wheel a wheel
     */
    public void changeWheel(Wheel wheel){
        this.wheels[0] = wheel;
        System.out.print("Changing wheels, wait ");
        for (int i = 0; i < 10; i++){
            System.out.print(".");
            try {
                Thread.sleep(250);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(" It's OK, you can go!");
    }

    /**
     * Prints the model name
     */
    public void modelToString(){
        System.out.println("Model : " + model);
    }

}
