package Graph;

import java.util.*;

public class ConnectedItems {
    public static void main(String[] args){
        List<int[]> list = new ArrayList<>();
        list.add(new int[]{1,2});
        list.add(new int[]{2,5});
        list.add(new int[]{3,4});
        list.add(new int[]{4,6});
        list.add(new int[]{6,8});
        list.add(new int[]{5,7});
        list.add(new int[]{5,2});
        list.add(new int[]{9,10});
        List<List<Integer>> res = getCategories(list);
        for(List<Integer> row : res) {
            row.forEach(System.out::print);
            System.out.println();
        }
    }

    private static List<List<Integer>> getCategories(List<int[]> list) {
        Map<Integer,List<Integer>> map = new HashMap<>();
        for(int[] row: list){
            map.putIfAbsent(row[0],new ArrayList<>());
            map.putIfAbsent(row[1],new ArrayList<>());
            map.get(row[0]).add(row[1]);
            map.get(row[1]).add(row[0]);
        }
        Set<Integer> visited = new HashSet<>();
        List<List<Integer>> res  = new ArrayList<>();
        for(int key: map.keySet()){
            if(!visited.contains(key)){
                List<Integer> row = new ArrayList<>();
                dfs(row,visited,key,map);
                res.add(row);
            }
        }
        return res;
    }

    private static void dfs(List<Integer> row, Set<Integer> visited, int key, Map<Integer, List<Integer>> map) {
        if(visited.contains(key)) return;
        visited.add(key);
        row.add(key);
        for(int value: map.get(key)){
            dfs(row,visited,value,map);
        }
    }
}
