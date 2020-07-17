package javarush.task.task35.task3513;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {

        Model model = new Model();
        Controller controller = new Controller(model);
        JFrame game = new JFrame();

        game.setTitle("2048");
        game.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        game.setSize(450, 500);
        game.setResizable(false);

        game.add(controller.getView());

        game.setLocationRelativeTo(null);
        game.setVisible(true);

        // Код для тестирования
        /*
        Model model = new Model();
        model.gameTiles = new Tile[][]{
                {new Tile(4), new Tile(2), new Tile(8), new Tile(4)},
                {new Tile(8), new Tile(4), new Tile(2), new Tile(8)},
                {new Tile(4), new Tile(2), new Tile(8), new Tile(4)},
                {new Tile(2), new Tile(4), new Tile(2), new Tile(8)},
        };
        printTiles(model.gameTiles);
        System.out.println(model.canMove());
        printTiles(model.gameTiles);
    }

    private static void printTiles(Tile[][] tiles) {
        for (int i = 0; i < tiles.length; i++) {
            for (int j = 0; j < tiles.length; j++) {
                System.out.print(tiles[i][j].value + " ");
            }
            System.out.println();
        }
        System.out.println();
         */
    }
}
