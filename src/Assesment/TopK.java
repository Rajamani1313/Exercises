package Assesment;

import java.util.*;

public class TopK {
    public static void main(String[] args) {
        int k = 2;

        String[] keywords = new String[]{"anacell", "betacellular", "cetracular", "deltacellular", "eurocell"};
        String[] reviews = new String[]{
                "I love anacell Best services; Best services provided by anacell",
                "betacellular has great services",
                "deltacellular provides much better services than betacellular",
                "cetracular is worse than anacell",
                "Betacellular is better than deltacellular.",
        };

        String [] res = topK(2,keywords,reviews);
        for(String str: res)
            System.out.println(str);

    }
        //O(L*N+FLogK)
    private static String[] topK(int k, String[] keywords, String[] reviews) {
        Map<String,Integer> map = new HashMap<>();
        //O(F)
        for(String key: keywords)
            map.put(key.toLowerCase(),0);
        //O(L*N)
        for(String text: reviews){
            Set<String> set = new HashSet<String>();
            for(String str: text.split("\\W+"))
                set.add(str.toLowerCase());
            for(String str: set)
                if(map.containsKey(str))
                    map.put(str,map.get(str)+1);
        }

        PriorityQueue<Map.Entry<String,Integer>> pq = new PriorityQueue<>((a,b)-> a.getValue() == b.getValue() ?
                b.getKey().compareTo(a.getKey()):a.getValue() - b.getValue());
        //O(FLogK)
        for(Map.Entry<String,Integer> e: map.entrySet()){
            System.out.println(e.getKey() + " : " + e.getValue());

            pq.offer(e);
            if(pq.size() > k)
                pq.poll();
        }
        String[] res = new String[k];
        //O(K)
        while(pq.size() > 0){
            res[pq.size()-1] = pq.peek().getKey();
            pq.poll();
        }
        return  res;
    }
}
