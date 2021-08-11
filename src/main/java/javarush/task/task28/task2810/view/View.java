package javarush.task.task28.task2810.view;

import javarush.task.task28.task2810.Controller;
import javarush.task.task28.task2810.vo.Vacancy;

import java.util.List;

public interface View {
    void update(List<Vacancy> vacancies);

    void setController(Controller controller);
}
