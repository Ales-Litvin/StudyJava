package by_epam.introduction_to_java.basics_of_OOP_5.task04.controller;


import by_epam.introduction_to_java.basics_of_OOP_5.task04.loader.Loader;
import by_epam.introduction_to_java.basics_of_OOP_5.task04.model.Cave;
import by_epam.introduction_to_java.basics_of_OOP_5.task04.model.Treasure;
import by_epam.introduction_to_java.basics_of_OOP_5.task04.view.View;

import java.util.List;

public class Controller {
    private Cave cave;
    private View view;

    public Controller(Cave cave) {
        this.cave = cave; // здесь загрузчик и помести лист в Cave
        this.view = new View(this);
    }

    public List<Treasure> getTreasures(){ return cave.getTreasures(); }

    public double getTotalPrice(List<Treasure> treasures){
        return cave.getTotalPrice(treasures);
    }


}
