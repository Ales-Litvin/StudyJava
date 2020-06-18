package javarush.task.task25.task2514;

/*
 * Обеспечь переуступку кванта времени (переход хода для текущей нити)
 * для последовательных выводов текста в консоль
 */

/*
Первый закон Финэйгла: если эксперимент удался, что-то здесь не так...
*/
public class Solution {
    public static class YieldRunnable implements Runnable {
        private int index;

        public YieldRunnable(int index) {
            this.index = index;
        }

        public void run() {
            System.out.println("begin-" + index);
            Thread.yield();
            System.out.println("end-" + index);
        }
    }

    public static void main(String[] args) {
        Thread thread = new Thread(new YieldRunnable(1));
        thread.start();
    }
}