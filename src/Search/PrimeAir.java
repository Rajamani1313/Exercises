package Search;

import java.util.*;

public class PrimeAir {
    public static void main(String[] args){
        int arr1[][] = { {1, 2000}, {2, 3000}, {3, 4000}, {4, 2000} };
        int arr2[][] = { { 1, 5000 }, {2, 3000} };
        List<int[]> res = getClosest(arr1,arr2, 5000);
        for(int[] row: res)
            System.out.println(row[0]+" "+row[1]);
    }

    private static List<int[]> getClosest(int[][] arr1, int[][] arr2,int target) {
        TreeMap<Integer,List<Integer>> treeMap = new TreeMap<>();
        for(int[] a: arr1){
            treeMap.putIfAbsent(a[1],new ArrayList<>());
            treeMap.get(a[1]).add(a[0]);
        }
        List<int[]> result = new ArrayList<>();
        int closest = 0;
        for(int[] b:arr2){
            int remaining = target - b[1];
            if(remaining <= 0) continue;
            if(treeMap.containsKey(remaining)){
                if(closest != target){
                    closest = target;
                    result = new ArrayList<>();
                }
                for(int id:treeMap.get(remaining))
                    result.add(new int[]{id,b[0]});
            }else{
                Integer floor = treeMap.floorKey(remaining);
                int curr = floor+b[1];
                if(closest <= curr){
                    if(closest != curr){
                        result = new ArrayList<>();
                        closest = curr;
                    }
                    for(int id:treeMap.get(floor))
                        result.add(new int[]{id,b[0]});
                }
            }
        }
        return result;
    }
}
