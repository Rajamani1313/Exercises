package Array;

import java.util.HashMap;
import java.util.Map;

public class SubArraySum {
    public static void main(String[] args){
        int[] nums={1,2,3,4,1,2,3,4,1,6};
        System.out.println(subarraySum(nums,3));
    }

    private static int subArraySum(int[] nums, int k) {
        int[] dp = new int[nums.length];
        int count =0;
        for(int i=0;i<nums.length;i++)
            for(int j=0;j<nums.length-i;j++){
                dp[j] += nums[i+j];
                System.out.println("i"+i+"j"+j+"="+dp[j]);
                if (dp[j]==k) {
                    count++;
                }
            }
        return count;
    }
    public static int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int count=0, sum=0;
        for(int i=0; i<nums.length; i++) {
            sum+=nums[i];
            if(map.containsKey(sum-k)) {
                count+=map.get(sum-k);
            }
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return count;
    }
}
