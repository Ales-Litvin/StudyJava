package metanit.lessons08.lesson0805;

// Класс Потребитель
class Consumer implements Runnable{

    Store store;

    Consumer(Store store){
        this.store=store;
    }

    @Override
    public void run(){
        for (int i = 1; i < 6; i++) {
            store.get();
        }
    }
}
