package Graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CourseSchedule {
    public static void main(String[] args) {
        int[][] pre = new int[][]{{1,0},{2,0},{3,1},{3,2}};
        System.out.println(Arrays.toString(findOrder(4,pre)));
    }
    static int index = 0;
    public static int[] findOrder(int numCourses, int[][] prerequisites) {
        List[] adj = new List[numCourses];
        //Build adj list
        for(int[] edge: prerequisites){
            if(adj[edge[0]] == null)
                adj[edge[0]] = new ArrayList<Integer>();
            adj[edge[0]].add(edge[1]);
        }

        int[] result = new int[numCourses];
        int[] visited = new int[numCourses];
        //Check each node dependency by dfs
        for(int i=0;i<numCourses;i++){
            if(!dfs(i,adj,visited,result))
                return new int[]{};
        }
        return result;
    }
    public static boolean dfs(int node,List<Integer>[] adj,int[] visited,int[] result){
        if(visited[node] == 1) return false;
        if (visited[node] == 2) return true;
        visited[node] = 1;
        visited[node] = 2;
        if(adj[node] != null) {
            for (int i : adj[node]) {
                if (!dfs(i, adj, visited, result))
                    return false;
            }
        }
        result[index++] = node;
        return true;
    }
}
