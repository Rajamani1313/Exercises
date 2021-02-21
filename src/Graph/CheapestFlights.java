package Graph;

import java.util.*;

public class CheapestFlights {
    public static void main(String[] args){
        int[][] edges = {{0,1,100},{0,2,500},{1,2,100},{1,3,500},{2,3,300}};
//        System.out.println(solve1(4,edges,0,3,2));
        Deque<int[]> stack = new ArrayDeque();
        Queue<Integer> queue = new ArrayDeque<>();
    }

    private static int solve(int n, int[][] edges, int src, int dest, int K) {
        int [][] adj = new int[n][n];
        for (int[] edge:edges)
            adj[edge[0]][edge[1]] = edge[2];
        PriorityQueue<int[]> heap = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));

        heap.offer(new int[]{0,src,K+1});
        while(!heap.isEmpty()){
            int[] curr = heap.poll();
            int cost = curr[0];
            int node = curr[1];
            int stop = curr[2];

            if (node == dest)
                return cost;
            if(stop>0){
                for (int i=0;i<n;i++){
                    if(adj[node][i]>0){
                        heap.offer(new int[]{cost+adj[node][i],i,stop-1});
                    }
                }
            }

        }
        return -1;
    }
    private static int solve1(int n, int[][] edges, int src, int dst, int K){
        int[] cost= new int[n];
        Arrays.fill(cost, Integer.MAX_VALUE);
        cost[src] = 0;
        for (int i=0; i<=K; i++){
            int[] tmp = Arrays.copyOf(cost, n);
            for (int[] a: edges){
                int cur = a[0], next=a[1], price=a[2];
                if (cost[cur]== Integer.MAX_VALUE)
                    continue;
                tmp[next] = Math.min(tmp[next], cost[cur]+price);
            }
            System.out.println(Arrays.toString(cost));
            System.out.println(Arrays.toString(tmp));
            cost = tmp;
        }
        return cost[dst] == Integer.MAX_VALUE? -1: cost[dst];
    }
}
