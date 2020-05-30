package Array;

import java.util.*;

public class MergeIntervals {
    public static void main(String[] args){
        int[][] nums = {{1,4},{4,8},{2,4},{5,9}};
        System.out.println(Arrays.toString(merge(nums)));
    }

    private static int[][] merge(int[][] intervals) {
        ArrayList<int[]> result = new ArrayList<>();
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
//        Collections.Array.sort(Arrays.asList(nums),new IntervalComparator());
        for(int[] no: intervals)
            pq.offer(no);
        int [] a = pq.poll();
        while(!pq.isEmpty()){
            int[] b = pq.poll();
            if(a[1]>=b[0])
                a[1] = a[1]>b[1]?a[1]:b[1];
            else {
                result.add(a);
                a = b;
            }
        }
        result.add(a);
        return result.toArray(new int[result.size()][]);
    }
}
