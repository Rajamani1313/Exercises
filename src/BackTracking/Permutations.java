package BackTracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Permutations {
    public static void main(String[] args) {
        int[] nums = {5, 6, 7,9};
        System.out.println(permute(nums));
    }

    private static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        backtrack(res, nums, 0);
        return res;
    }

    static void backtrack(List<List<Integer>> res, int[] nums,int index) {

        if (index == nums.length-1) {
            ArrayList<Integer> temp = new ArrayList<>();
            for (int n : nums)
                temp.add(n);
            res.add(temp);
            return;
        }
        for (int i=index;i<nums.length;i++){
            swap(nums,i,index);
            backtrack(res,nums,index+1);
            swap(nums,i,index);
        }
    }
    private static void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
