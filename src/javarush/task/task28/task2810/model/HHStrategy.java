package javarush.task.task28.task2810.model;

import javarush.task.task28.task2810.vo.Vacancy;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

public class HHStrategy implements Strategy {
    private static final String USER_AGENT = "Mozilla/5.0 (jsoup)";
    private static final int timeout = 5 * 1000;

    private static final String URL_FORMAT
            = "http://hh.ua/search/vacancy?text=java+%s&page=%d";

    // http://hh.ru/search/vacancy?text=java+%s&page=%d -- это работает
    // http://hh.ua/search/vacancy?text=java+%s&page=%d


    @Override public List<Vacancy> getVacancies(String searchString) {
        Document doc = null;
        try {
            doc = Jsoup.connect("http://hh.ua/search/vacancy?text=java+%s&page=%d").get();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return Collections.EMPTY_LIST;
    }
}
