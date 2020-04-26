import java.util.*;

public class TopKElements {
    public static void main(String[] args){
        int[] nums = {5,5,7,6,6,7,5};
        System.out.println(topKFrequent(nums,2));
    }
    public static List<Integer> topKFrequent(int[] nums, int k) {
        // build hash map : character and how often it appears
        HashMap<Integer, Integer> count = new HashMap();
        for (int n: nums) {
            count.put(n, count.getOrDefault(n, 0) + 1);
        }

        // init heap 'the less frequent element first'
        PriorityQueue<Integer> heap =
                new PriorityQueue<Integer>(Comparator.comparingInt(count::get));
//        System.out.println(heap.peek());

        // keep k top frequent elements in the heap
        for (int n: count.keySet()) {
            System.out.print(heap.peek()+"n:"+n);
            heap.add(n);
            if (heap.size() > k)
                heap.poll();
            System.out.println("-"+heap.peek());
        }
        PriorityQueue<Integer> heap2 = heap;
        heap2.forEach((n)->System.out.println(n));
        // build output list
        List<Integer> top_k = new LinkedList();
        while (!heap.isEmpty())
            top_k.add(heap.poll());
        Collections.reverse(top_k);
        return top_k;
    }
}