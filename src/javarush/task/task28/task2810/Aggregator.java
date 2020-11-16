package javarush.task.task28.task2810;

import javarush.task.task28.task2810.model.HHStrategy;
import javarush.task.task28.task2810.model.Model;
import javarush.task.task28.task2810.model.MoikrugStrategy;
import javarush.task.task28.task2810.model.Provider;
import javarush.task.task28.task2810.view.HtmlView;

public class Aggregator {
    public static void main(String[] args) {
        Provider HHProvider = new Provider(new HHStrategy());
        Provider MKProvider = new Provider(new MoikrugStrategy());


        HtmlView view = new HtmlView();
        Model model = new Model(view, HHProvider, MKProvider);
        Controller controller = new Controller(model);
        view.setController(controller);
        view.userCitySelectEmulationMethod();
    }
}
