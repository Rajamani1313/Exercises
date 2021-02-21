package Graph;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

class Point implements Comparable<Point>{
    public int x, y;
    public Point(int[] p){
        x = p[0];
        y = p[1];
    }
    @Override
    public int compareTo(Point p){
        return (p.x*p.x+p.y*p.y)-(x*x+y*y);
    }
}
class KClosePoints {
    public static void main(String[] args){
        int[][] nums={{3,3},{5,1},{-2,4}};
        int[][] num1 = kClosest(nums,2);
        System.out.println(Arrays.toString(num1[1]));
    }
    public static int[][] kClosest(int[][] points, int K) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)-> (b[0]*b[0]+b[1]*b[1]) - (a[0]*a[0]+a[1]*a[1]));
        for (int[] point: points){
            if(pq.size() < K)
                pq.offer(point);
            else{
                int[] p = pq.peek();
                System.out.println(Arrays.toString(p));
                if ((p[0]*p[0]+p[1]*p[1]) > (point[0]*point[0]+point[1]*point[1])){
//                    System.out.println(pq.poll());
                    pq.offer(point);
                }

            }
        }
        int[][] result = new int[K][2];
        for(int i=0;i<K;i++){
            result[i] = pq.poll();
        }
        return result;

    }
}