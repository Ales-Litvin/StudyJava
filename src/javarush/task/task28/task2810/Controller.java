package javarush.task.task28.task2810;

import javarush.task.task28.task2810.model.Provider;
import javarush.task.task28.task2810.vo.Vacancy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Controller {

    private Provider[] providers;

    public Controller(Provider... providers) {
        if (providers == null || providers.length == 0){
            throw new IllegalArgumentException();
        }
        this.providers = providers;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Controller{");
        sb.append("providers=").append(Arrays.toString(providers));
        sb.append('}');
        return sb.toString();
    }

    public void scan() {
        List<Vacancy> vacancies = new ArrayList<>();
        try {
            for (Provider provider : providers) {
                vacancies.addAll(provider.getJavaVacancies("Kiev"));
            }
            System.out.println(vacancies.size());
        } catch (NullPointerException e){
            System.out.println("NPE");
        }
    }
}
