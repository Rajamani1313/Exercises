package Graph;

import java.util.*;

public class UnionFind {
    public static void main(String[] args){
        List<int[]> list = new ArrayList<>();
        list.add(new int[]{1,2});
        list.add(new int[]{2,4});
        list.add(new int[]{6,9});
        list.add(new int[]{6,10});
        list.add(new int[]{8,10});
        System.out.println(unionFind(list));
    }
    static int totalSets = 0;
    private static int unionFind(List<int[]> list) {
        for(int[] pair: list){
            union(pair[0],pair[1]);
        }
        return totalSets;
    }
    static Map<Integer,Integer> parent = new HashMap<>();
    static Map<Integer,Integer> rank = new HashMap<>();
    private static void union(int a, int b) {
        int x = find(a);
        int y = find(b);
        if(x == y) return;
        if(rank.get(y) > rank.get(x)){
            int temp = x;
            y = x;
            x = temp;
        }
        parent.put(y,x);
        rank.put(x,rank.get(x)+rank.get(y));
        totalSets--;
    }

    private static int find(int a) {
        if(!parent.containsKey(a)){
            totalSets++;
            parent.put(a,a);
            rank.put(a,1);
            return a;
        }
        if(parent.get(a)!=a){
            int x = find(parent.get(a));
            parent.put(a,x);
            return x;
        }
        return a;
    }
}
