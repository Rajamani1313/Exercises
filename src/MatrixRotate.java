import java.util.Arrays;

public class MatrixRotate {
    public static void main(String[] args) {
//        int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
        int[][] matrix = {{1, 2, 3, 4, 5, 1, 0, 7}, {6, 7, 8, 9, 10, 2, 0, 7}, {11, 12, 13, 14, 15, 3, 0, 7}, {16, 17, 18, 19, 20, 4, 0, 7}, {21, 22, 23, 24, 25, 5, 0, 7}, {9, 9, 9, 9, 9, 9, 0, 7}, {0, 0, 0, 0, 0, 0, 0, 7}, {8, 8, 8, 8, 8, 8, 8, 8}};
//        int[][] matrix = {{1,2},{8,9}};
        /*rotate*/
        for (int[] num : matrix)
            System.out.println(Arrays.toString(num));
        rotate1(matrix);
        for (int[] num : matrix)
            System.out.println(Arrays.toString(num));

    }
    public static void rotate1(int[][] matrix) {
        int size = matrix.length;
        int n = size - 1;
        System.out.println("size " + size);
        System.out.println("move " + n);
        for (int j = 0; j < n; j++) {
            for (int i = j; i < n; i++) {
                int k = 0;
                if (j > 1)
                    k = j - 1;
                int temp = matrix[j][n - i + k];
                matrix[j][n - i + k] = matrix[i + j - k][j];
                matrix[i + j - k][j] = matrix[n][i + j - k];
                matrix[n][i + j - k] = matrix[n - i + k][n];
                matrix[n - i + k][n] = temp;
                System.out.println("Inner n" + n);

            }
            System.out.println("n" + n);
            n--;
        }
    }

    public static void rotate2(int[][] matrix) {
        if (matrix == null) return;
        for (int i = 0; i < (matrix.length/2); i++) {
            helper(matrix, i, matrix.length - (i * 2));
        }
    }
    public static void helper ( int[][] matrix, int start, int n){
        for (int i = 0; i < n - 1; i++) {

            int temp = matrix[start][start + i];
            matrix[start][start + i] = matrix[start + n - 1 - i][start];
            matrix[start + n - 1 - i][start] = matrix[start + n - 1][start + n - 1 - i];
            matrix[start + n - 1][start + n - 1 - i] = matrix[start + i][start + n - 1];
            matrix[start + i][start + n - 1] = temp;


        }

    }
    public static void rotate3 ( int[][] matrix){
        int n = matrix.length, moves;
        int[][] movement = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        for (int i = 0; i < ((n + 1) / 2); i++) {
            moves = (n - 1 - (2 * i));
            if (moves < 1)
                continue;
            int[][] ptr = {{i, i}, {i, n - 1 - i}, {n - 1 - i, n - 1 - i}, {n - 1 - i, i}};
            for (int m = 0; m < moves; m++) {
                int temp = matrix[ptr[3][0]][ptr[3][1]];
                matrix[ptr[3][0]][ptr[3][1]] = matrix[ptr[2][0]][ptr[2][1]];
                matrix[ptr[2][0]][ptr[2][1]] = matrix[ptr[1][0]][ptr[1][1]];
                matrix[ptr[1][0]][ptr[1][1]] = matrix[ptr[0][0]][ptr[0][1]];
                matrix[ptr[0][0]][ptr[0][1]] = temp;

                for (int j = 0; j < 4; j++) {
                    ptr[j][0] += movement[j][0];
                    ptr[j][1] += movement[j][1];
                }
            }
        }
    }

}