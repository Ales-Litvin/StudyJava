package javarush.task.task16.task1632;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static List<Thread> threads = new ArrayList<>(5);

    static {
        threads.add(new ThreadOne());
        threads.add(new ThreadTwo());
        threads.add(new ThreadThree());
        threads.add(new ThreadFour());
        threads.add(new ThreadFive());
        threads.get(0).start();
        System.out.println(threads.get(3).isAlive());
        threads.get(0).interrupt();
        System.out.println(threads.get(3).isAlive());
    }

    public static void main(String[] args) {
    }

    public static class ThreadOne extends Thread{
        public void run() {
            while (true) { }
        }
    }

    public static class ThreadTwo extends Thread{
        public void run() {
            while (true) {
                try {
                    Thread.sleep(5);
                } catch (InterruptedException e) {
                    System.out.println("InterruptedException");
                }
            }
        }
    }

    public static class ThreadThree extends Thread{
        public void run() {
            while (!isInterrupted()) {
                try {
                    System.out.println("Ура");
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.getMessage();
                }
            }
        }
    }

    public static class ThreadFour extends Thread implements Message{
        private boolean selector = true;

        public void run() {
                while (selector) {
                }
        }

        @Override
        public void showWarning() {
            selector = false;
        }
    }

    public static class ThreadFive extends Thread{
        public void run() {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            int sum = 0;
            String string;
            try {
                while (!(string = reader.readLine()).equals("N")) {
                    sum += Integer.parseInt(string);
                }
                System.out.println(sum);
            }
            catch (IOException e){
                e.getMessage();
            }
        }

    }
}