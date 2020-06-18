package javarush.task.task16.task1617;

/*
Отсчет на гонках
*/

public class Solution {
    public static volatile int numSeconds = 4;

    public static void main(String[] args) {
        RacingClock clock = new RacingClock();
        //add your code here - добавь код тут
        try {
            Thread.sleep(3500);
            clock.interrupt();
        } catch (InterruptedException e) {
            System.out.println("Прервано!");
        }

    }

    public static class RacingClock extends Thread {
        public RacingClock() {
            start();
        }

        public void run() {
            //add your code here - добавь код тут
            try {
                while (numSeconds != 0) {
                    System.out.print(numSeconds-- + " ");
                    Thread.sleep(1000);
                }
                System.out.print("Марш!");
            }
            catch (InterruptedException e) {
                System.out.println("Прервано!");
            }
        }
    }
}