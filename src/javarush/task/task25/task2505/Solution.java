package javarush.task.task25.task2505;

/*
Без дураков
*/
public class Solution {

    public static void main(String[] args) {
        MyThread myThread = new Solution().new MyThread("super secret key");
        myThread.start();
    }

    public class MyThread extends Thread {
        private String secretKey;

        public MyThread(String secretKey) {
            this.secretKey = secretKey;
            /*
             * метод инсталирующий обработчик для всех неперехваченных исключений
             * в текущий поток (this)
             */
            setUncaughtExceptionHandler(new MyUncaughtExceptionHandler());
            /*
             * Если в программе все обычные нити завершили работу,
             * но остались только нити-демоны — Java-машина завершит программу
             */
            setDaemon(false);
        }

        @Override
        public void run() {
            throw new NullPointerException("it's an example");
        }

        private class MyUncaughtExceptionHandler implements UncaughtExceptionHandler{
            public MyUncaughtExceptionHandler(){
            }

            @Override
            public void uncaughtException(Thread t, Throwable e) {
                try {
                    Thread.sleep(500);
                    System.out.println(String.format("%s, %s, %s",
                        secretKey,
                        t.getName(),
                        e.getMessage()));
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
            }
        }
    }
}