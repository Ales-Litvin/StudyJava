package by_epam.basics_1.linearPrograms.task0105;

public class Solution {
    public static void main(String[] args) {
        long t = 256510;

        int hours = (int) t / (60 * 60);
        int minutes = (int) (t - hours * 60 * 60) / 60;
        int seconds =  (int) (t - minutes * 60 - hours * 60 * 60);

        System.out.printf("%dч %dмин %dс\n", hours, minutes, seconds);
    }
}
