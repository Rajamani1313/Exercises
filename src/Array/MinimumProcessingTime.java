package Array;

import java.util.Arrays;

public class MinimumProcessingTime {
    public static void main(String[] args){
        System.out.println(minTime(2,new int[]{8,10},new int[]{2,2,3,1,8,7,4,5,9}));
    }

    private static int minTime(int n, int[] proc, int[] load) {
        Arrays.sort(load);
        Arrays.sort(proc);
        int ans = 0;
        for(int i=load.length-1,j=0;i>=0;i-=4,j++){ int temp = load[i]+proc[j];
            ans = Math.max(ans,temp);
        }
        return ans;
    }
}
