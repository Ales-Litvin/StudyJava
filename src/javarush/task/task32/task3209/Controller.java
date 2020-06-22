package javarush.task.task32.task3209;

import javax.swing.text.html.HTMLDocument;
import java.io.File;

public class Controller {
    public static void main(String[] args) {
        View view = new View();
        Controller controller = new Controller(view);
        view.setController(controller);
        view.init();
        controller.init();
    }

    private HTMLDocument document;
    private File currentFile;

    private View view;

    public Controller(View view) {
        this.view = view;
    }

    public void init() { }

    public void exit() { System.exit(0); }
}
