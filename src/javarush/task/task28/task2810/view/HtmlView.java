package javarush.task.task28.task2810.view;

import javarush.task.task28.task2810.Controller;
import javarush.task.task28.task2810.vo.Vacancy;

import java.util.List;

public class HtmlView implements View {
    private Controller controller;

    @Override
    public void update(List<Vacancy> vacancies) {

    }

    @Override
    public void setController(Controller controller) {
        this.controller = controller;
    }
}
