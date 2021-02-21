package Array;

import java.util.*;

public class MergeIntervals {
    public static void main(String[] args) {
        String str = "deg";
        String str1 = "def";
        System.out.println(str.compareTo(str1));
        List<String> rawList = new ArrayList();
//        int[][] nums = {{1,4},{4,8},{2,4},{5,9}};
//        System.out.println(Arrays.toString(merge(nums)));
    }

    private static int[][] merge(int[][] intervals) {
        ArrayList<int[]> result = new ArrayList<>();
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
//        Collections.Array.sort(Arrays.asList(nums),new IntervalComparator());
        for (int[] no : intervals)
            pq.offer(no);
        int[] a = pq.poll();
        while (!pq.isEmpty()) {
            int[] b = pq.poll();
            if (a[1] >= b[0])
                a[1] = a[1] > b[1] ? a[1] : b[1];
            else {
                result.add(a);
                a = b;
            }
        }
        result.add(a);
        return result.toArray(new int[result.size()][]);

    }
    public int[] rearrangeBarcodes(int[] barcodes) {
        Map<Integer, Integer> cnt = new HashMap();
        for (int i : barcodes) cnt.put(i, cnt.getOrDefault(i, 0) + 1);

        List<Map.Entry<Integer, Integer>> list = new ArrayList<>(cnt.entrySet());
        Collections.sort(list, Map.Entry.<Integer, Integer>comparingByValue().reversed());
        int l = barcodes.length, i = 0;
        int[] res = new int[l];
        for (Map.Entry<Integer, Integer> e : list) {
            int time = e.getValue();
            while (time-- > 0) {
                res[i] = e.getKey();
                i += 2;
                if (i >= barcodes.length) i = 1;
            }
        }
        return res;
    }
}
