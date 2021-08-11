package javarush.task.task28.task2810.model;

import javarush.task.task28.task2810.vo.Vacancy;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MoikrugStrategy implements Strategy{
    private static final String URL_FORMAT = "https://moikrug.ru/vacancies?q=java+%s&page=%d";
    private static final String USER_AGENT = "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/86.0.4240.198 Safari/537.36";
    private static final String REFERRER = "https://career.habr.com/"; //"no-referrer-when-downgrade"

    @Override
    public List<Vacancy> getVacancies(String searchString) {
        List<Vacancy> vacancies = new ArrayList<>();

        Document doc;
        try {
            for (int page = 0; (doc = getDocument(searchString, page)) != null; page++){
                //Elements elements = doc.select("[data-qa=vacancy-serp__vacancy]");
                //Elements elements = doc.select("[data-qa=\"vacancy-serp__vacancy\"]");
                Elements elements = doc.getElementsByAttributeValue("class", "job");
                elements.addAll(doc.getElementsByAttributeValue("class", "job marked"));

                if (elements.size() == 0) { break; }

                for (Element element : elements) {
                    Vacancy vacancy = new Vacancy();
                    vacancy.setTitle(element.getElementsByAttributeValue("class", "title").text());
                    vacancy.setCity(element.getElementsByAttributeValue("class", "location").text());
                    vacancy.setCompanyName(element.getElementsByAttributeValue("class", "company_name").text());
                    vacancy.setSalary(element.getElementsByAttributeValue("class", "count").text());
                    vacancy.setSiteName("https://moikrug.ru"); // https://career.habr.com
                    vacancy.setUrl("https://moikrug.ru" + element.select("div[class=title]").first().getElementsByTag("a").attr("href"));
                    vacancies.add(vacancy);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return vacancies;
    }

    protected Document getDocument(String searchString, int page) throws IOException {
        return Jsoup.connect(String.format(URL_FORMAT, searchString, page)).userAgent(USER_AGENT).referrer(REFERRER).get();
    }
}
