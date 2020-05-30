package BackTracking;

import java.util.ArrayList;
import java.util.List;

public class Subsets {
    public static void main(String[] args){
        int[] nums = {5,6,7};
//        System.out.println(subset(nums));
        System.out.println(subset1(nums));
    }

    private static List<List<Integer>>  subset1(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        int n = nums.length;
        for(int i=(int)Math.pow(2,n);i<(int)Math.pow(2,n+1);i++){
            String bitmask = Integer.toBinaryString(i).substring(1);
            List<Integer> row = new ArrayList<>();
            for (int j=0; j<n;j++){
                if (bitmask.charAt(j)== '1')
                    row.add(nums[j]);
            }
            list.add(row);
        }
        return list;
    }

    static List<List<Integer>> list = new ArrayList<>();
    static int k ;
    private static List<List<Integer>> subset(int[] nums) {
        for (k=0; k<=nums.length;k++)
            backtrack(0,new ArrayList<Integer>(),nums);
        return list;
    }

    private static void backtrack(int start, ArrayList<Integer> currList, int[] nums) {
        if (currList.size() == k)
            list.add(new ArrayList<>(currList));
        for (int i=start;i<nums.length;i++){
            currList.add(nums[i]);
            backtrack(i+1,currList,nums);
            currList.remove(currList.size()-1);
        }

    }
}
