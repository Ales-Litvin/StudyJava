package javarush.task.task28.task2810.model;

import javarush.task.task28.task2810.vo.Vacancy;

import java.util.List;

public class Provider {
    private Strategy strategy;

    public Provider(Strategy strategy) { this.strategy = strategy; }

    public void setStrategy(Strategy strategy) { this.strategy = strategy; }

    public List<Vacancy> getJavaVacancies(String searchString){
        return null;
    }
}
