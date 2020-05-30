package Graph;

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
        int[][] nums={{1,0},{-2,-2}};
        System.out.println(kClosest(nums,1));
    }
    public static int[][] kClosest(int[][] points, int K) {
        PriorityQueue<Integer> pq = new PriorityQueue();
        for (int[] point: points){
            if(pq.size() < K)
                pq.offer(new Point(point));
            else{
                Point p = pq.peek();
                if ((p.x*p.x+p.y*p.y) > (point[0]*point[0]+point[1]*point[1])){
                    pq.poll();
                    pq.offer(new Point(point));
                }

            }
        }
        int[][] result = new int[K][2];
        for(int i=0;i<K;i++){
            Point p = pq.poll();
            result[i][0] = p.x;
            result[i][1] = p.y;
        }
        return result;

    }
}