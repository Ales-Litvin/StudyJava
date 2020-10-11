package by_epam.introduction_to_java.programming_with_classes_4.simplest_classes_and_objects.task03;

import java.security.SecureRandom;
import java.util.Random;

/**
 * This class helping create random student's surname and initials,
 * and array with random academic performance for class Student
 */
public class CreateHelper {
    /**
     * Returns a array with random students
     * @param amount amount fo students in a array
     * @return a array with random students
     */
    public static Student[] getStudents(int amount){
        Student[] students = new Student[amount];
        for (int i = 0; i < students.length; i++){
            students[i] = new Student(CreateHelper.getRandomName(),
                    (int) (Math.random() * 100),
                    CreateHelper.getAcademicPerformance(5, 10));

        }
        return students;
    }

    private static final String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

    /**
     * Returns random student's surname and initials
     * @return random student's surname and initials
     */
    public static String getRandomName(){
        StringBuilder sb = new StringBuilder();
        int length = 0;
        while (length < 4){
            length = (int) (Math.random() * 8);
        }
        return firstUpperCase(getRandomString(length).toLowerCase()) + " " +
                getRandomString(1).toUpperCase() + '.' +
                getRandomString(1).toUpperCase() + '.';
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

    /**
     * Returns array with random academic performance
     * @param length a length of array with academic performance
     * @param maxValue a max value
     * @return array with random academic performance
     */
    public static int[] getAcademicPerformance(int length, int maxValue){
        int[] academicPerformance = new int[length];
        for (int i = 0; i < academicPerformance.length; i++){
            academicPerformance[i] = (int) (Math.random() * maxValue);
        }
        return academicPerformance;
    }

}