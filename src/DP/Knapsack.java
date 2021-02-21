package DP;

import java.util.*;

public class Knapsack {
    public static void main(String[] args){
        int[] inp1 = new int[]{15,50,20,20,20};
//        System.out.println(Arrays.toString(organize(inp1)));
//
//        inp1 = new int[]{1,2,5,8,4};
//        System.out.println(Arrays.toString(organize(inp1)));
//
//        inp1 = new int[]{5,3,2,4,1,2};
//        System.out.println(Arrays.toString(organize(inp1)));
//
//        inp1 = new int[]{10, 4, 4, 4, 3};
//        System.out.println(Arrays.toString(organize(inp1)));
//
//        inp1 = new int[]{1,2,5,8,4};
//        System.out.println(Arrays.toString(organize(inp1)));
//
//        inp1 = new int[]{5,3,2,4,1,2};
//        System.out.println(Arrays.toString(organize(inp1)));

        inp1 = new int[]{10, 9, 9, 6, 5, 4, 3, 2, 1};
        System.out.println(Arrays.toString(organize(inp1)));

        inp1 = new int[]{2, 1,1,1};
        System.out.println(Arrays.toString(organize(inp1)));
    }
    static int minCount, minWght;

    private static int[] organize(int[] inp1) {
        Map<Integer,Integer> map = new HashMap<>();
        int total = 0;
        for(int n: inp1){
            map.put(n,map.getOrDefault(n,0)+1);
            total += n;
        }
        List<Integer> wghtList = new ArrayList<>();
        List<Integer> countList = new ArrayList<>();
        for(int key:map.keySet()){
            wghtList.add(key*map.get(key));
            countList.add(map.get(key));
        }
        minCount = inp1.length;
        minWght = total/2+1;

        solve(minWght,0,0,wghtList,countList);
        int weight = total/2+1-minWght;
        Arrays.sort(inp1);
        int[] res = new int[minCount];
        for(int i=inp1.length-1;i>=0;i--){
//            System.out.println(minCount+":"+weight);
//            System.out.println(inp1[i]);
            if(map.get(inp1[i])*inp1[i] <= weight) {
                res[--minCount] = inp1[i];
                weight -= inp1[i];
                map.put(inp1[i],map.get(inp1[i])-1);
            }
        }
        return res;

    }

    private static void solve(int wght, int index, int count, List<Integer> wghtList, List<Integer> countList) {
        if(index == countList.size()+1) return;
//        System.out.println("weight: "+wght);
//        System.out.println("index: "+index);
//        System.out.println("count: "+count);
//        System.out.println("--------------");


        if(wght <=0){
            if(minCount > count){
                minCount = count;
                minWght = wght;
            }
            if(minCount == count)
                minWght = Math.min(minWght,wght);
            return;
        }
        if(index == countList.size()) return;

        solve(wght-wghtList.get(index),index+1,count+countList.get(index),wghtList,countList);
        solve(wght,index+1,count,wghtList,countList);
    }
}
