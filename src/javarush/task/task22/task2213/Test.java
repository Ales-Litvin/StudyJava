package javarush.task.task22.task2213;

public class Test {
    public static void main(String[] args) {
        int[][] filed =    {{0, 0, 0, 0, 0, 0, 0, 0, 0},
                            {0, 0, 0, 0, 0, 0, 0, 0, 0},
                            {0, 0, 0, 0, 0, 0, 0, 0, 0},
                            {1, 1, 1, 1, 1, 1, 1, 1, 1},
                            {1, 1, 1, 1, 0, 1, 1, 1, 1},
                            {1, 1, 1, 1, 0, 1, 1, 1, 1},
                            {1, 1, 1, 1, 1, 1, 1, 1, 1},
                            {1, 0, 1, 1, 1, 1, 1, 1, 1},
                            {0, 0, 0, 0, 1, 1, 1, 1, 1}};

        Field test = new Field(9, 9, filed);

        print(test.getMatrix());

        test.removeFullLines();

        print(test.getMatrix());
    }

    public static void print(int[][] matrix){
        for (int i = 0; i < matrix.length; i++){
            for (int j = 0; j < matrix[0].length; j++){
                char c = '.';
                if (matrix[i][j] == 1) c = 'X';
                System.out.print(c);
            }
            System.out.println("");
        }
        System.out.println("==============================================");
    }
}
