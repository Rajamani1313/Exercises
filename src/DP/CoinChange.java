package DP;

import java.util.Arrays;

public class CoinChange {
    public static void main(String[] args){
        int[] coins = {2,5};
        System.out.println(coinChange(coins,11));
    }
    public static int coinChange(int[] coins, int amount) {
        int max = amount + 1;
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, max);
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int j = 0; j < coins.length; j++) {
                if (coins[j] <= i) {
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                    System.out.println(dp[i] + "-"+i);
                }
                System.out.println("break");

            }
        }
        System.out.println(Arrays.toString(dp ));
        return dp[amount] > amount ? -1 : dp[amount];
    }
}