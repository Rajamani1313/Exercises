
/**
 Let's assume we have data about start and end time of Uber trips, e.g.

 Trip 1: Start: 0, End: 5
 Trip 2: Start: 1, End: 2
 Trip 3: Start: 3, End: 7
 Based on this input we want to print number of trips in progress per time slot:

 OUTPUT:
 [0, 1] -> 1
 [1, 2] -> 2
 [2, 3] -> 1
 [3, 5] -> 2
 [5, 7] -> 1

 List = int[0,0]S:0,S;1,E:2,S;3,E;5,E;7
 Sum = 1,2,1,2,1

 1
 0 1  , 2 5
 0 5 - 1,2
 start = 1
 end =
 Trip = 1

 0 1 1

 Start = 0
 end = 2
 0  1 1

 O(T*N)
 0 1 2 3 4 5 6 7
 1 1 1 1 1 0
 0 1 0 0
 0 0 0 1 1 1 1 0

 */
package Array;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.*;


// Main class should be named 'Solution'
public class TripProgress {
    private static void tripProgress(int[][] trips){
        if(trips == null || trips.length == 0) return;
        List<int[]> list = new ArrayList<>();
        //Start = 0 end, =1
        for(int[] trip: trips){
            list.add(new int[]{trip[0],0});
            list.add(new int[]{trip[1],1});
            // list.forEach(a->System.out.println(a[0]+":"+a[1]));

        }
        Collections.sort(list,(a,b)-> a[0] - b[0]);
        int count = 0, prevCount = 0;
        int[] curr= list.get(0);
        int start = 0;
        // list.forEach(a->System.out.println(a[0]+":"+a[1]));
        //S:0,S;1,E:2,S;3,E;5,E;7
        for(int i=1;i<list.size();i++){

            // int[] curr = list.get(i); //7 1
            // System.out.println(curr[1]);
            int[] next = list.get(i);// 7 1
            if(curr[1] == 0) count++;// count =1
            else count--;
            if(count > 0){
                if(curr[1] == next[1]) {
//                    start = curr[0];
//                    end = next[0];
                }
                else {
                    System.out.println(start + "to " + next[0] + "Count = " + count);// 0 1 1 || 1 2 2 || 2 3 1 || 3 5 2 || 5 7 1
                }
                prevCount = count;
            }
            curr = next;
        }
    }
    private static int getIndex(List<int[]> list,int time) {
        int index = 0;
        if(list == null) return index;
        while(index < list.size() && list.get(index)[0] < time ){
            index++;
        }
        return index;
//        return index==0?0:index-1;
    }
    public static void main(String[] args) {

        // Trip 1: Start: 0, End: 1
        // Trip 2: Start: 1, End: 2
        // Trip 3: Start: 3, End: 7

        int[][] trips= new int[][]{
                {0,1},
                {1,2},
                {3,7}
        };
        tripProgress(trips);
    }
}

