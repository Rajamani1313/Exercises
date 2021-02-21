package Array;

import java.util.ArrayList;
import java.util.List;

public class MinPeak {
    public static void main(String args[]){
        List<Integer> list = new ArrayList<>();
        list.add(2);
        list.add(7);
        list.add(8);
        list.add(5);
        list.add(1);
        list.add(6);
        list.add(3);
        list.add(9);
        list.add(4);
        peak(list).forEach(obj -> System.out.print(obj));


    }

    private static List<Integer> peak(List<Integer> list) {
        List<Integer> res = new ArrayList<>();
        int n = list.size();
        for(int i=0;i<n;i++){
            int min = Integer.MAX_VALUE;
            int index = -1;
            int size = list.size();

            if(size == 1) {
                res.add(list.get(0));
                break;
            }

            int prev=-1,curr=list.get(0);
            for(int j=1;j<=size;j++){
                int next = j==size?-1:list.get(j);
//                System.out.println("prev : "+prev);
//                System.out.println("curr : "+curr);
//                System.out.println("next : "+next);
                if(prev < curr && curr > next && curr < min){
                    min = curr;
                    index = j-1;
                }
                prev = curr;
                curr = next;
            }
//            System.out.println("min : "+min);

            res.add(min);
            list.remove(index);
//            System.out.println("size" + list.size() + "i"+i);
        }
        return res;
    }
}
