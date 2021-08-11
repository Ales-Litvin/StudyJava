package javarush.task.task35.task3513;
import java.util.Comparator;

public class MoveEfficiency implements Comparable<MoveEfficiency>{
    private int numberOfEmptyTiles;
    private int score;
    private Move move;

    public MoveEfficiency(int numberOfEmptyTiles, int score, Move move){
        this.numberOfEmptyTiles = numberOfEmptyTiles;
        this.score = score;
        this.move = move;
    }

    public Move getMove(){
        return move;
    }

    @Override
    public int compareTo(MoveEfficiency o) {
        return new Comparator<MoveEfficiency>(){
            @Override
            public int compare(MoveEfficiency o1, MoveEfficiency o2){
                return Integer.compare(o1.numberOfEmptyTiles, o2.numberOfEmptyTiles);
            }
        }.thenComparing(new Comparator<MoveEfficiency>(){
            @Override
            public int compare(MoveEfficiency o1, MoveEfficiency o2){
                return Integer.compare(o1.score, o2.score);
            }
        }).compare(this, o);
    }

}