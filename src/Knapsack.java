import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Stack;

public class Knapsack {
    public static void main (String[] args){
        int val[] = new int[]{60, 100, 120};
        int wt[] = new int[]{10, 20, 30};
        int  W = 50;
        int n = val.length;
        System.out.println(knapSack(W, wt, val, n));
    }
//    static int knapSack(int W, int wt[], int val[], int n)
//    {
//        int i, w;
//        int K[][] = new int[n+1][W+1];
//
//        // Build table K[][] in bottom up manner
//        for (i = 0; i <= n; i++)
//        {
//            for (w = 0; w <= W; w++)
//            {
//                if (i==0 || w==0)
//                    K[i][w] = 0;
//                else if (wt[i-1] <= w)
//                    K[i][w] = Math.max(val[i-1] + K[i-1][w-wt[i-1]],  K[i-1][w]);
//                else
//                    K[i][w] = K[i-1][w];
//            }
//        }
//        for (i = 0; i < K.length; i++ ) {
//            for (int j = 0; j < K[i].length; j++)
//                System.out.println("[" + i + "][" + j + "] " + K[i][j]);
//            System.out.println();
//        }
//        return K[n][W];
//    }

    private static int knapSack(int capacity, int[] wt, int[] val, int size) {
        int[][] k = new int[size+1][capacity+1];
        for (int i =0; i <=size; i++){
            for (int w=0; w<=capacity; w++){
                if ( i ==0 || w == 0)
                    k[i][w]=0;
                else if (wt[i-1] <= w) {
                    k[i][w] = Math.max(val[i - 1] + k[i - 1][w - wt[i - 1]], k[i - 1][w]);
                    System.out.println("[" + i + "][" + w + "] " + k[i][w] + "= Max "+ k[i-1][w] +"-"+k[i - 1][w - wt[i - 1]]);
                }
                else
                    k[i][w] = k[i-1][w];
            }
        }

        for (int i = 0; i < k.length; i++ ) {
            for (int j = 0; j < k[i].length; j++)
                System.out.println("[" + i + "][" + j + "] " + k[i][j]);
            System.out.println();
        }
        return k[size][capacity];
    }
}
