package javarush.task.task34.task3410.controller;

import javarush.task.task34.task3410.model.Direction;
import javarush.task.task34.task3410.model.Model;
import javarush.task.task34.task3410.view.View;

public class Controller implements EventListener{
    private View view;

    private Model model;

    public Controller() {
        this.view = new View(this);
        this.model = new Model();
        this.view.init();
    }

    public static void main(String[] args) {

    }

    @Override
    public void move(Direction direction) {

    }

    @Override
    public void restart() {

    }

    @Override
    public void startNextLevel() {

    }

    @Override
    public void levelCompleted(int level) {

    }
}
