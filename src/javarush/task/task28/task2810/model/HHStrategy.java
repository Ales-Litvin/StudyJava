package javarush.task.task28.task2810.model;

import javarush.task.task28.task2810.vo.Vacancy;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class HHStrategy implements Strategy {
    private static final String USER_AGENT = "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/86.0.4240.198 Safari/537.36";
    private static final String REFERRER = "strict-origin-when-cross-origin";
    private static final int timeout = 5 * 1000;

    private static final String URL_FORMAT
            = "http://hh.ua/search/vacancy?text=java+%s&page=%d";

    // http://hh.ru/search/vacancy?text=java+%s&page=%d -- это работает
    // http://hh.ua/search/vacancy?text=java+%s&page=%d


    @Override
    public List<Vacancy> getVacancies(String searchString) {
        List<Vacancy> vacancies = new ArrayList<>();
        Document doc = null;

        try {
            for (int page = 0; (doc = getDocument(searchString, page)) != null; page++) {
                //Elements elements = doc.select("[data-qa=vacancy-serp__vacancy]");
                //Elements elements = doc.select("[data-qa=\"vacancy-serp__vacancy\"]");
                Elements elements = doc.getElementsByAttributeValue("data-qa", "vacancy-serp__vacancy");

                if (elements.isEmpty()){ break; }

                for (Element element : elements) {
                    if (element == null) break;

                    Vacancy vacancy = new Vacancy();

                    vacancy.setTitle(element.getElementsByAttributeValue("data-qa", "vacancy-serp__vacancy-title").text());
                    vacancy.setSalary(element.getElementsByAttributeValue("data-qa", "vacancy-serp__vacancy-compensation").text());
                    vacancy.setCity(element.getElementsByAttributeValue("data-qa", "vacancy-serp__vacancy-address").text());
                    vacancy.setCompanyName(element.getElementsByAttributeValue("data-qa", "vacancy-serp__vacancy-employer").text());
                    vacancy.setSiteName(new URL(element.baseUri()).getHost());
                    vacancy.setUrl(element.baseUri());

                    vacancies.add(vacancy);
                }

            }
        } catch (IOException e){
            e.printStackTrace();
        }

        return vacancies;
    }

    protected Document getDocument(String searchString, int page) throws IOException {
        return Jsoup.connect(String.format(URL_FORMAT, searchString, page)).
                userAgent(USER_AGENT).referrer(REFERRER).get();
    }
}