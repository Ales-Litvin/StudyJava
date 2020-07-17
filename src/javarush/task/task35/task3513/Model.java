package javarush.task.task35.task3513;

import java.util.*;


public class Model {
    private static final int FIELD_WIDTH = 4;
    private Tile[][] gameTiles;

    public Model(){
        resetGameTiles();
        score = 0;
        maxTile = 2;
        previousStates = new Stack<>();
        previousScores = new Stack<>();
    }

    public Tile[][] getGameTiles() { return gameTiles; }

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
        if (isSaveNeeded){
            saveState(gameTiles);
        }
        boolean wasMoved = false;
        for (int i = 0; i < FIELD_WIDTH; i++){
            if (compressTiles(gameTiles[i]) | mergeTiles(gameTiles[i])){
                wasMoved = true;
            }
        }
        if (wasMoved) addTile();
        isSaveNeeded = true;
    }

    public void right(){
        saveState(gameTiles);
        turnClockwise();
        turnClockwise();
        left();
        turnClockwise();
        turnClockwise();
    }

    public void up(){
        saveState(gameTiles);
        turnClockwise();
        turnClockwise();
        turnClockwise();
        left();
        turnClockwise();
    }

    public void down(){
        saveState(gameTiles);
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

    public boolean canMove(){
        // Метод возвращающий true если возможно сделать ход так чтобы состояние поля изменилось
        for (int i = 0; i < FIELD_WIDTH - 1; i++) {
            for (int j = 0; j < FIELD_WIDTH - 1; j++){
                if (gameTiles[i][j].isEmpty()) return true;
                if (gameTiles[i][j].value == gameTiles[i][j + 1].value ||
                        gameTiles[i][j].value == gameTiles[i + 1][j].value) return true;
            }
        }
        for (int i = FIELD_WIDTH - 1; i > 1; i--) {
            for (int j = FIELD_WIDTH - 1; j > 1; j--){
                if (gameTiles[i][j].isEmpty()) return true;
                if (gameTiles[i][j].value == gameTiles[i][j - 1].value ||
                        gameTiles[i][j].value == gameTiles[i - 1][j].value) return true;
            }
        }
        return false;
    }

    private Stack<Tile[][]> previousStates;
    private Stack<Integer> previousScores;
    private boolean isSaveNeeded = true;

    private void saveState(Tile[][] tiles){
        Tile[][] tempTiles = new Tile[FIELD_WIDTH][FIELD_WIDTH];
        for (int i = 0; i < FIELD_WIDTH; i++) {
            for (int j = 0; j < FIELD_WIDTH; j++){
                tempTiles[i][j] = new Tile(gameTiles[i][j].value);
            }
        }
        Integer scoreTemp = new Integer(score);
        previousStates.push(tempTiles);
        previousScores.push(scoreTemp);
        isSaveNeeded = false;
    }

    public void rollback(){
        if (!previousStates.isEmpty() & !previousScores.isEmpty()){
            gameTiles = previousStates.pop();
            score = previousScores.pop();
        }
    }

    public void randomMove(){
        int n = ((int) (Math.random() * 100)) % 4;
        switch (n){
            case 0: left();
                break;
            case 1: right();
                break;
            case 2: up();
                break;
            case 3: down();
                break;
        }
    }

    private boolean hasBoardChanged(){
        for (int i = 0; i < FIELD_WIDTH; i++) {
            for (int j = 0; j < FIELD_WIDTH; j++){
                if (gameTiles[i][j].value != previousStates.peek()[i][j].value)
                    return true;
            }
        }
        return false;
    }

    private MoveEfficiency getMoveEfficiency(Move move){
        MoveEfficiency moveEfficiency = null;
        move.move();
        if (!hasBoardChanged()){
            moveEfficiency = new MoveEfficiency(-1, 0, move);
        } else {
            moveEfficiency = new MoveEfficiency(getEmptyTiles().size(), score, move);
        }
        rollback();

        return moveEfficiency;
    }

    void autoMove(){
        PriorityQueue<MoveEfficiency> moveEfficiencies = new PriorityQueue<>(4, Collections.reverseOrder());
        moveEfficiencies.add(getMoveEfficiency(this::left));
        moveEfficiencies.add(getMoveEfficiency(this::right));
        moveEfficiencies.add(getMoveEfficiency(this::up));
        moveEfficiencies.add(getMoveEfficiency(this::down));
        moveEfficiencies.peek().getMove().move();
    }

}

