package javarush.task.task28.task2810.view;

import javarush.task.task28.task2810.Controller;
import javarush.task.task28.task2810.vo.Vacancy;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class HtmlView implements View {
    private Controller controller;

    @Override
    public void update(List<Vacancy> vacancies) {
        System.out.println(vacancies.size());
        System.out.println(filePath);
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
        return null;
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
