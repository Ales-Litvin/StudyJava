package javarush.task.task35.task3513;

import java.util.ArrayList;
import java.util.List;

public class Model {
    private static final int FIELD_WIDTH = 4;
    private Tile[][] gameTiles;

    public Model(){ resetGameTiles(); }

    void resetGameTiles(){
        gameTiles = new Tile[FIELD_WIDTH][FIELD_WIDTH];
        for (int i = 0; i < FIELD_WIDTH; i++) {
            for (int j = 0; j < FIELD_WIDTH; j++){
                gameTiles[i][j] = new Tile();
            }
        }
        addTile();
        addTile();
    }

    private void addTile(){
        List<Tile> emptyTiles = getEmptyTiles();
        if (emptyTiles.size() > 0 && !emptyTiles.isEmpty()) {
            Tile randomTile = emptyTiles.get((int) (emptyTiles.size() * Math.random()));
            randomTile.value = (Math.random() < 0.9 ? 2 : 4);
        }
    }

    private List<Tile> getEmptyTiles(){
        List<Tile> emptyTiles = new ArrayList<Tile>();
        for (int i = 0; i < FIELD_WIDTH; i++) {
            for (int j = 0; j < FIELD_WIDTH; j++){
                if (gameTiles[i][j].isEmpty())
                    emptyTiles.add(gameTiles[i][j]);
            }
        }
        return emptyTiles;
    }
}