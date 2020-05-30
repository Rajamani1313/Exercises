package Array;

import java.util.Arrays;

public class MoveZeroes {

    public static void main(String[] args){
        int[] nums = {1,2,0,3,4,0,5};
        System.out.println(Arrays.toString(moveZeroes(nums)));

    }

    private static int[] moveZeroes(int[] nums) {
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[j++] = nums[i];
            }
        }
        for (int i = j; i < nums.length; i++)
            nums[i] = 0;
        return nums;
    }
}
