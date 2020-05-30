package Array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSumArray {
    public static void main (String[] args){
        int[] nums = {50,40,60,30,20,10};
        System.out.println(Arrays.toString(twoSum(nums,90)));
    }

    public static int[] twoSum ( int[] nums, int target){
        Map<Integer, Integer> tempMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int val = target - nums[i];
            if (tempMap.containsKey(val)) {
                return new int[]{tempMap.get(val), i};
            }
            tempMap.put(nums[i], i);
        }

        return new int[]{};
    }
}
