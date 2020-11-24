package javarush.task.task34.task3410.model;

import javarush.task.task34.task3410.controller.EventListener;

import java.net.URISyntaxException;
import java.nio.file.Paths;

public class Model implements EventListener {
    public static final int FIELD_CELL_SIZE = 20;

    private EventListener eventListener;

    private GameObjects gameObjects;

    private int currentLevel = 1;

    private LevelLoader levelLoader;

    {
        try {
            levelLoader = new LevelLoader(Paths.get(Model.class.getResource("../res/levels.txt").toURI()));
        } catch (URISyntaxException e) {
            levelLoader = null;
        }
    }

    public void setEventListener(EventListener eventListener){
        this.eventListener = eventListener;
    }

    public GameObjects getGameObjects(){ return gameObjects; }

    public void restartLevel(int level){
        gameObjects = levelLoader.getLevel(level);
    }

    @Override
    public void move(Direction direction) {

    }

    @Override
    public void restart(){ restartLevel(1); }

    @Override
    public void startNextLevel(){ restartLevel(currentLevel++); }

    @Override
    public void levelCompleted(int level) {

    }
}
