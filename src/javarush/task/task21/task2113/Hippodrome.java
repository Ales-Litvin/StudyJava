package javarush.task.task21.task2113;

/*
* Решение задачи 21 уровня 16 лекции*
* 04.05.2020
 */

import java.util.ArrayList;
import java.util.List;

public class Hippodrome {

    private List<Horse> horses;
    public static Hippodrome game;
    public Hippodrome(List<Horse> horses){
        this.horses = horses;
    }

    public static void main(String[] args){
        List<Horse> horsesList = new ArrayList<>();
        horsesList.add(new Horse("Horse1", 3, 0));
        horsesList.add(new Horse("Horse2", 3, 0));
        horsesList.add(new Horse("Horse3", 3, 0));
        Hippodrome.game = new Hippodrome(horsesList);
        Hippodrome.game.run();
        Hippodrome.game.printWinner();
    }

    public List<Horse> getHorses(){
        return this.horses;
    }

    /*
     * Управляет всем этим
     */
    public void run(){
        for (int i = 0; i < 100; i++){
            move();
            print();
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    /*
     * Управляет движением всех лошадей
     */
    void move(){
        for (Horse horse : horses){
            horse.move();
        }
    }

    /*
     * Отрисовывает лошадей на экране
     */
    void print(){
        for (Horse horse : horses){
            horse.print();
        }
        for (int i = 0; i < 10; i++){
            System.out.println();
        }
    }

    /*
     * Возращает лошадь пробежавшую самую большую дистанцию
     */
    public Horse getWinner(){
        Horse winHorse = getHorses().get(0);
        for (Horse horse : getHorses()){
            if (horse.getDistance() > winHorse.getDistance()) winHorse = horse;
        }
        return winHorse;
    }

    /*
     * Выводи на экран имя победителя в виде:
     * Winner is <name>!
     */
    public void printWinner(){
        System.out.printf("Winner is %s!", getWinner().getName());
    }
}