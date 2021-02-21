package Array;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Stack;

public class MaxRating {
    public static void main(String[] args){
        int[] nums = {3,1,6,4,5,2};
//        maxSum(nums);
        System.out.println(maxSum(nums));
    }

    private static int maxSum(int[] a) {

        Deque<Integer> st = new ArrayDeque<Integer>();
        int[] left = new int[a.length];
        int[] right = new int[a.length];
        for (int i=0;i<a.length;i++) {
            while (!st.isEmpty() && a[st.peek()] >= a[i]) st.pop();
            if (!st.isEmpty()) {
                left[i] = st.peek()+1;
            } else {
                left[i] = 0;
            }
            st.push(i);
        }
        while(!st.isEmpty()) st.poll();
        for (int i=a.length-1;i>=0;i--){
            while (!st.isEmpty() && a[st.peek()] >= a[i]) st.pop();
            if (!st.isEmpty()) {
                right[i] = st.peek()-1;
            } else {
                right[i] = a.length-1;
            }
            st.push(i);
        }
        for(int i=0;i<a.length;i++){
            System.out.println("left"+left[i]+"-right"+right[i]);
        }
        int[] cum = new int[a.length+1];
        for(int i=1;i<=a.length;i++){
            cum[i] = cum[i-1] + a[i-1];
            System.out.println(cum[i]);
        }
        int max = 0;
        for(int i=0;i<a.length;i++){
            int temp = (cum[right[i]+1] - cum[left[i]]) * a[i];
            System.out.println(temp);
            max = Math.max(max,temp);
        }


        return max;
    }
}
