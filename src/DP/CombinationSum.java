package DP;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum {
    public static void main(String[] args){
        int[] jeans = new int[]{2,3,4};
        int[] shoes = new int[]{4,5};
        int[] skirts = new int[]{2,3};
        int[] tops = new int[]{1,2};
        int money = 12;
        System.out.println(getSum(jeans,shoes,skirts,tops,money));
        /*
            2 4 2 1 = 9
            2 4 2 2 = 10
            2 4 3 1 = 10
            2 5 2 1 = 10
            3 4 2 1 = 10
         */
    }
    private static int getSum(int[] jeans, int[] shoes, int[] skirts, int[] tops, int money) {
        List<int[]> pList = new ArrayList<>();
        pList.add(jeans);
        pList.add(shoes);
        pList.add(skirts);
        pList.add(tops);
        int [][] memo = new int[4][13];
         int ans = helper(money,0,pList,memo);
        for(int[] m: memo)
         System.out.println(Arrays.toString(m));
         return ans;

    }

    private static int helper(int money, int pid, List<int[]> pList,int[][] memo) {
        if(money < 0) return 0;
        if(pid == 4) return 1;
        if(memo[pid][money] > 0) return memo[pid][money];
        int[] pArr = pList.get(pid);
        int ans = 0;
        for(int cost : pArr){
            ans += helper(money-cost,pid+1,pList,memo);
        }
        memo[pid][money] = ans;
        return ans;
    }
}
