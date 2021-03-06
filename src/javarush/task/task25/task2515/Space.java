package javarush.task.task25.task2515;

import java.util.ArrayList;
import java.util.List;

public class Space {
    private int width;
    private int height;
    private SpaceShip ship;
    private List<Ufo> ufos;
    private List<Rocket> rockets;
    private List<Bomb> bombs;

    public Space(int width, int height) {
        this.width = width;
        this.height = height;
        this.ufos = new ArrayList<>();
        this.rockets = new ArrayList<>();
        this.bombs = new ArrayList<>();
    }

    public static void main(String[] args) {

    }

    public void run(){ }

    public void draw(){ }

    public void sleep(int ms){ }

    //getters and setters
    public int getWidth() { return width; }

    public int getHeight() { return height; }

    public List<Ufo> getUfos() { return ufos; }

    public List<Rocket> getRockets() { return rockets; }

    public List<Bomb> getBombs() { return bombs; }

    public SpaceShip getShip() { return ship; }

    public void setShip(SpaceShip ship) { this.ship = ship; }
}