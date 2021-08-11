package javarush.task.task24.task2411;


public class C implements JustAnInterface {
    public C(){
        System.out.println("C");
        B localB = B;
    }
}
