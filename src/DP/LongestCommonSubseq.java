package DP;

public class LongestCommonSubseq {
    public static void main(String[] args){
        System.out.println(longestCommonSubsequence("abcde","ace"));
    }
    public static int longestCommonSubsequence(String text1, String text2) {
        char[] t1 = text1.toCharArray();
        char[] t2 = text2.toCharArray();
        int[] dp = new int[t2.length+1];

        for (int i=1; i<=t1.length;i++) {
            int prev = 0;
            for (int j = 1; j <= t2.length; j++) {
                int temp = dp[j];
                if (t1[i - 1] == t2[j - 1])
                    dp[j] = prev + 1;
                else
                    dp[j] = Math.max(dp[j], dp[j - 1]);
                prev = temp;
            }
        }
        return dp[t2.length];
    }
}