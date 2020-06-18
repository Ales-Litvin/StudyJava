package javarush.task.task25.task2502;


import java.util.ArrayList;
import java.util.List;

/*
Машину на СТО не повезем!
 */
public class Solution {
    public static enum Wheel {
        FRONT_LEFT,
        FRONT_RIGHT,
        BACK_LEFT,
        BACK_RIGHT
    }

    public static class Car{
        protected List<Wheel> wheels;

        public Car() throws IllegalArgumentException{
            // init wheels here
                wheels = new ArrayList<>();
                if (this.loadWheelNamesFormDB().length != 4) throw new IllegalArgumentException();
                for (String string : this.loadWheelNamesFormDB()) {
                    wheels.add(Wheel.valueOf(string));
                }
        }

        protected String [] loadWheelNamesFormDB() {
            // this method returns mock data
            return new String [] {"FRONT_LEFT", "FRONT_RIGHT", "BACK_LEFT", "BACK_RIGHT"};
        }

    }

    public static void main(String[] args) {
        Car sportCar = new Car();
    }
}
