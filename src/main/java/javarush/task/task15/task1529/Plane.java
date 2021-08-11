package javarush.task.task15.task1529;

public class Plane implements CanFly {
    private int n_Person;
    public Plane(int i){
        this.n_Person = i;
        System.out.println("Fly fly fly ...");
    }
    public void fly(){
        System.out.println("Fly fly fly ...");
    }

}
