package metanit.lessons08.lesson0805;

// класс Производитель
class Producer implements Runnable{

    Store store;

    Producer(Store store){
        this.store=store;
    }

    @Override
    public void run(){
        for (int i = 1; i < 6; i++) {
            store.put();
        }
    }
}
