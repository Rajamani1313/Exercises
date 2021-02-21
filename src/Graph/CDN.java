package Graph;

import java.util.*;

public class CDN {
    public static void main(String[] args){
        String[] edges = new String[]{"1 2","1 3","3 5", "3 4","7 8","5 6","9 10"};
        System.out.println(connectedSum(10,edges));

    }
    public static int connectedSum(int n,String[] edges){
        List<Integer>[] adj = new ArrayList[n];
//        Map<Integer,List<Integer>> map = new HashMap<>();
        for(String e : edges){
            String[] nodes = e.split("\\s+");
            int first = Integer.valueOf(nodes[0])-1;
            int second = Integer.valueOf(nodes[1])-1;
            if(adj[first] == null)
                adj[first] = new ArrayList<>();
            if(adj[second] == null)
                adj[second] = new ArrayList<>();
            adj[first].add(second);
            adj[second].add(first);
//            map.putIfAbsent(first,new ArrayList<Integer>());
//            map.putIfAbsent(second,new ArrayList<Integer>());
//            map.get(first).add(second);
//            map.get(second).add(first);
        }
        boolean[] visited = new boolean[n];
        int res= 0;
        for(int i=0;i<n;i++){
            if(!visited[i]){
                int count = dfs(adj,i,visited);
                if(count == 1)
                    res++;
                else
                    res += Math.ceil(Math.sqrt(count));
            }
        }
        return res;
    }
    public static int dfs(List<Integer>[] adj, int node, boolean[] v){
        v[node] = true;
        int count = 1;

        if(adj[node] != null){
            for (Integer n : adj[node]) {
                if (!v[n])
                    count += dfs(adj, n, v);
            }
        }
        return count;
    }
}
