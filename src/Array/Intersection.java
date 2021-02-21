package Array;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Intersection {
// "static void main" must be defined in a public class.

    public static int maxFrequent(int[][] input){
/*
        Comparator<int[]> comp = new Comparator<int[]>(){
            @Override
            public int compare(int[] i1, int[] i2){
                if(i1[0]== i2[0]){
                    return i1[1] - i2[1];
                }
                return i1[0]-i2[0];
            }
        };
*/

/*
        Comparator<int[]> comp1 = new Comparator<int[]>(){
            @Override
            public int compare(int[] i1, int[] i2){
                if(i1[1]== i2[1]){
                    return i1[0] - i2[0];
                }
                return i1[1]-i2[1];
            }
        };
*/

        Arrays.sort(input, (a,b)->{
            if(a[0] == b[0])
                return a[1]-b[1];
            return a[0]-b[0];
        });

        int count = 0;
        int res = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->{
            if(a[1] == b[1])
                return a[0] - b[0];
            return a[1] - b[1];
        });
        for(int i =0; i < input.length; i++){
            if(!pq.isEmpty()){
                while(!pq.isEmpty() && pq.peek()[1] < input[i][0]){
                    pq.poll();
                }
            }
            pq.add(input[i]);
            if(count < pq.size()){
                count = pq.size();
                res = input[i][0];
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] input = new int[][]{{1,4},{3,5},{4,6}};
        System.out.println(maxFrequent(input));
    }
}