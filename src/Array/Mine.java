package Array;

import java.util.Random;

public class Mine {
    public static void main(String[] args) {
        char[][] grid = gen(5, 3, 2);
        for (char[] row : grid){
            for (char c : row)
                System.out.print(c);
            System.out.println();
        }
    }

    private static char[][] gen(int W, int H, int M) {
        char[][] grid = new char[H][W];
        Random random = new Random();
        int mine = 0;
        while(mine < M){
            int rand = random.nextInt(W*H);
            int row = rand/W;
            int col = rand%W;
            if(!(grid[row][col] == 'X')){
                grid[row][col] = 'X';
                mine++;
            }
        }
        return grid;
    }
}
