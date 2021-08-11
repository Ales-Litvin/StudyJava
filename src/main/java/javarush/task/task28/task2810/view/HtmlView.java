package javarush.task.task28.task2810.view;

import javarush.task.task28.task2810.Controller;
import javarush.task.task28.task2810.vo.Vacancy;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class HtmlView implements View {
    private Controller controller;

    @Override
    public void update(List<Vacancy> vacancies) {
        System.out.println(vacancies.size());
        updateFile(getUpdatedFileContent(vacancies));
    }

    @Override
    public void setController(Controller controller) {
        this.controller = controller;
    }

    public void userCitySelectEmulationMethod(){
        controller.onCitySelect("Odessa");
    }

    private String getUpdatedFileContent(List<Vacancy> vacancies){
        Document doc = null;
        try {
            doc = getDocument();

            if (doc == null) return "Some exception occurred";

            Element elementTemplate = doc.getElementsByClass("template").first();
            Element elementPattern = elementTemplate.clone();
            elementPattern.removeClass("template").removeAttr("style");

            doc.getElementsByAttributeValue("class", "vacancy").remove();

            for (Vacancy vacancy : vacancies){
                Element element = elementPattern.clone();
                element.getElementsByClass("city").first().text(vacancy.getCity());
                element.getElementsByClass("companyName").first().text(vacancy.getCompanyName());
                element.getElementsByClass("salary").first().text(vacancy.getSalary());

                Element linkElement = element.getElementsByTag("a").first();
                linkElement.text(vacancy.getTitle());
                linkElement.attr("href", vacancy.getUrl());

                elementTemplate.before(element.outerHtml());
            }
        } catch (IOException e) {
            e.printStackTrace();
            return "Some exception occurred";
        }
        return doc.html();
    }

    protected Document getDocument() throws IOException {
        return Jsoup.parse(new File(filePath), "UTF-8");
    }

    private final String filePath =
            "./src/" +
            this.getClass().getPackage().getName().replace('.', '/') +
            "/vacancies.html";

    private void updateFile(String string){
        if (string == null) return;
        try (FileWriter writer = new FileWriter(filePath)) {
            writer.write(string);
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
