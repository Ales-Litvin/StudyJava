package javarush.task.task36.task3601;

public class View {
    private Controller controller;

    public View(){ this.controller = new Controller(); }

    public void fireShowDataEvent() {
        System.out.println(controller.onShowDataList());
    }

}