package javarush.task.task34.task3410.model;

import java.nio.file.Path;
import java.util.HashSet;
import java.util.Set;

public class LevelLoader {


    public LevelLoader(Path levels) {

    }

    public GameObjects getLevel(int level){
        Set<Wall> walls = new HashSet<>();
        walls.add(new Wall(Model.FIELD_CELL_SIZE/2, 10*Model.FIELD_CELL_SIZE/2));
        walls.add(new Wall(Model.FIELD_CELL_SIZE/2, 11*Model.FIELD_CELL_SIZE/2));

        Set<Box> boxes = new HashSet<>();
        boxes.add(new Box(7*Model.FIELD_CELL_SIZE/2,5*Model.FIELD_CELL_SIZE/2));

        Set<Home> homes = new HashSet<>();
        homes.add(new Home(9*Model.FIELD_CELL_SIZE/2, 13*Model.FIELD_CELL_SIZE/2));

        Player player = new Player(3*Model.FIELD_CELL_SIZE/2, 3*Model.FIELD_CELL_SIZE/2);

        return new GameObjects(walls, boxes, homes, player);
    }
}
