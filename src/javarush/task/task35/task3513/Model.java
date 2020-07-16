package javarush.task.task35.task3513;

import java.util.ArrayList;
import java.util.List;

public class Model {
    private static final int FIELD_WIDTH = 4;
    private Tile[][] gameTiles;

    public Model(){
        resetGameTiles();
        score = 0;
        maxTile = 2;
    }

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
        if (emptyTiles.size() > 0) {
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

    int score;
    int maxTile;

    private boolean compressTiles(Tile[] tiles){
        boolean isCompressed = false;
        for (int i = 0; i < tiles.length; i++) {
            if (tiles[i].isEmpty()) {
                int j = i;
                while (tiles[j].isEmpty() && j < tiles.length - 1){
                    j++;
                }
                if (!tiles[j].isEmpty()) isCompressed = true;
                tiles[i] = tiles[j];
                tiles[j] = new Tile();
            }
        }
        return isCompressed;
    }

    boolean mergeTiles(Tile[] tiles){
        boolean isCompressed = false;
        for (int i = 0; i < tiles.length - 1; i++){
            if (tiles[i].value == tiles[i + 1].value && !tiles[i].isEmpty()){
                isCompressed = true;
                tiles[i].value *= 2;
                score += tiles[i].value;
                if (maxTile < tiles[i].value){
                    maxTile = tiles[i].value;
                }
                tiles[i + 1] = new Tile();
                compressTiles(tiles);
            }
        }
        return isCompressed;
    }

    public void left(){
        boolean wasMoved = false;
        for (int i = 0; i < FIELD_WIDTH; i++){
            if (compressTiles(gameTiles[i]) | mergeTiles(gameTiles[i])){
                wasMoved = true;
            }
        }
        if (wasMoved) addTile();
    }

    public void right(){
        turnClockwise();
        turnClockwise();
        left();
        turnClockwise();
        turnClockwise();
    }

    public void up(){
        turnClockwise();
        turnClockwise();
        turnClockwise();
        left();
        turnClockwise();

    }

    public void down(){
        turnClockwise();
        left();
        turnClockwise();
        turnClockwise();
        turnClockwise();
    }

    private void turnClockwise(){
        Tile[][] result = new Tile[FIELD_WIDTH][FIELD_WIDTH];
        for (int i = 0; i < FIELD_WIDTH; i++) {
            for (int j = 0; j < FIELD_WIDTH; j++){
                result[i][FIELD_WIDTH - 1 - j] = gameTiles[j][i];
            }
        }
        gameTiles = result;
    }
}