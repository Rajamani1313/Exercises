package DP;

import java.lang.reflect.Array;
import java.util.Arrays;

public class SumByK {
    public static void main(String[] args){
        System.out.println(sum(9,5));
    }

    private static int sum(int n, int k) {
        int[][] dp = new int[n+1][k+1];
        for(int i=1;i<=n;i++)
            for(int j=1;j<=k;j++){
                if(j ==1)
                    dp[i][j] =1;
                else if(j>i)
                    dp[i][j] = dp[i-1][j-1];
                else
                    dp[i][j] = dp[i-1][j-1]+dp[i-j][j];
            }
        System.out.println(Arrays.deepToString(dp));
        return dp[n][k];
    }
}
