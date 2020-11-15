package javarush.task.task28.task2810.model;

import javarush.task.task28.task2810.vo.Vacancy;

import java.util.ArrayList;
import java.util.List;

public class HHStrategy implements Strategy {

    private static final String URL_FORMAT
            = "http://hh.ua/search/vacancy?text=java+%s&page=%d";

    // http://hh.ru/search/vacancy?text=java+%s&page=%d -- это работает
    // http://hh.ua/search/vacancy?text=java+%s&page=%d


    @Override
    public List<Vacancy> getVacancies(String searchString) {
        return new ArrayList<>();
    }
}
