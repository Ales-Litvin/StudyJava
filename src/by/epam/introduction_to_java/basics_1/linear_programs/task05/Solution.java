package by.epam.introduction_to_java.basics_1.linear_programs.task05;

/*
 * Условие задачи:
 * 5.  Дано  натуральное  число  Т,  которое  представляет  длительность
 *     прошедшего  времени  в  секундах.
 *     Вывести данное значение длительности в часах, минутах и секундах в
 *     следующей форме: ННч ММмин SSc.
 */
public class Solution {
    public static void main(String[] args) {
        secondToString(256510);
    }

    /**
     * Prints time in the format [ННч ММмин SSc].
     * @param t seconds.
     */
    public static void secondToString(long t){
        int hours = (int) t / (60 * 60);
        int minutes = (int) (t - hours * 60 * 60) / 60;
        int seconds =  (int) (t - minutes * 60 - hours * 60 * 60);

        System.out.printf("%dч %dмин %dс\n", hours, minutes, seconds);
    }
}
