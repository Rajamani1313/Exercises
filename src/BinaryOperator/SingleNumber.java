package BinaryOperator;

import java.util.Arrays;

public class SingleNumber {
    public static void main(String[] args){
//        int [] nums = {1,2,3,1,2,1,2,1,2,1,2};
        int[] nums= {1,2,3,4,5,1,2,3};
        System.out.println(Arrays.toString(singleNumber3(nums)));
//        System.out.println(Integer.toBinaryString(-1));
//        System.out.println(single(nums));
    }

    private static int single(int[] nums) {
        int once =0,twice=0,thrice=0;
        for(int n: nums){
            twice ^= (once & n);
            once ^= n;
            thrice = (once&twice);
            thrice = ~thrice;
            twice &= thrice;
            once &= thrice;
            System.out.println("once"+Integer.toBinaryString(once)+" twice"+ Integer.toBinaryString(twice)+" thrice"+Integer.toBinaryString(thrice));
        }
        return once;
    }
    private static int[] singleNumber3(int[] nums){
        int diff=0;
        for(int n: nums) {
            diff ^= n;
        }
        diff &= -diff;
        System.out.println(Integer.toBinaryString(diff));
        int[] res = new int[2];
        for(int n: nums){
            if((n&diff)==0)
                res[0] ^= n;
            else
                res[1] ^= n;
        }
        return res;
    }
}
