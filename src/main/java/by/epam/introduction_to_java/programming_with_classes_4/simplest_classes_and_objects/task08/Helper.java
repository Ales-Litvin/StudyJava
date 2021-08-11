package by.epam.introduction_to_java.programming_with_classes_4.simplest_classes_and_objects.task08;

import java.security.SecureRandom;
import java.util.Random;

/**
 * This class created for generating data for Customer
 */
public class Helper {

    public static long generateRandomNumber(int n){
        StringBuilder randomNumString = new StringBuilder();

        Random r = new Random();

        //Generate the first digit from 1-9
        randomNumString.append(r.nextInt(9) + 1);

        //Generate the remaining digits between 0-9
        for(int x = 1; x < n; x++){
            randomNumString.append(r.nextInt(9));
        }

        //Parse and return
        return Long.parseLong(randomNumString.toString());
    }

    private static final String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

    /**
     * Returns random surname
     * @return random surname
     */
    public static String getRandomName(){
        StringBuilder sb = new StringBuilder();
        int length = 0;
        while (length < 4){
            length = (int) (Math.random() * 8);
        }
        return firstUpperCase(getRandomString(length).toLowerCase());
    }

    /**
     * Generates the string length of {@param length}
     * @param length the length of created the string
     * @return a random alphabetic string
     */
    public static String getRandomString(int length){
        Random random = new SecureRandom();
        if (length <= 0) {
            throw new IllegalArgumentException("String length must be a positive integer");
        }

        StringBuilder sb = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            sb.append(characters.charAt(random.nextInt(characters.length())));
        }

        return sb.toString();
    }

    /**
     * Returns the word with first upper case letter
     * @param word a string with the word
     * @return the word with first upper case letter
     */
    public static String firstUpperCase(String word){
        if(word == null || word.isEmpty()) return "";
        return word.substring(0, 1).toUpperCase() + word.substring(1);
    }
}
