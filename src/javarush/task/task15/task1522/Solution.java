package javarush.task.task15.task1522;

/*
Закрепляем паттерн Singleton
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) {

    }

    public static Planet thePlanet;
    static
    {
        try {
            readKeyFromConsoleAndInitPlanet();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //add static block here - добавьте статический блок тут

    public static void readKeyFromConsoleAndInitPlanet() throws IOException {
        // implement step #5 here - реализуйте задание №5 тут
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String string = reader.readLine();
        if (string.equals(Planet.SUN)){
            thePlanet = Sun.getInstance();
        }
        else if (string.equals(Planet.MOON)){
            thePlanet = Moon.getInstance();
        }
        else if (string.equals(Planet.EARTH)){
            thePlanet = Earth.getInstance();
        }
        else {
            thePlanet = null;
        }

    }
}