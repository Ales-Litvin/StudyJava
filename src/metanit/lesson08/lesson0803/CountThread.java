package metanit.lesson08.lesson0803;

class CountThread implements Runnable{

    final CommonResource res;

    CountThread(CommonResource res){ this.res=res; }

    public void run(){

        synchronized (res) {
            res.x = 1;
            for (int i = 1; i < 5; i++) {
                System.out.printf("%s %d \n", Thread.currentThread().getName(), res.x);
                res.x++;

                try {
                    Thread.sleep(100);
                } catch (InterruptedException ignored) {
                    // do nothing
                }
            }
        }
    }

}
