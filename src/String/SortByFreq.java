package String;

import java.util.*;

public class SortByFreq {
    public static void main(String[] args){
        System.out.println(freq("test"));
    }

    private static String freq(String s) {
        if(s==null || s.isEmpty())
            return s;
        int[] ch = new int[128];
        for(char c: s.toCharArray()){
            ch[c]++;
        }
        List<Character> [] buckets = new ArrayList[s.length()+1];
        for (int i=0;i<128;i++){
            if(ch[i]!=0){
                if(buckets[ch[i]]==null)
                    buckets[ch[i]] = new ArrayList<>();
                buckets[ch[i]].add((char)i);
            }
        }
        StringBuilder str = new StringBuilder();
        for(int i = buckets.length-1;i>=0;i--){
            if(buckets[i]!=null){
                for (int j=0;j<buckets[i].size();j++){
                    char c = buckets[i].get(j);
                    for(int k=0;k<i;k++)
                        str.append(c);
                }
            }
        }
        return str.toString();



      /* HashMap<Character,Integer> map = new HashMap<>();
        for (char c: s.toCharArray())
            map.put(c,map.getOrDefault(c,0)+1);
            for(Map.Entry<Character,Integer> e: map.entrySet()){

            }
//        map.forEach((k,v)->System.out.println(k+"-"+v));
//        map.entrySet().forEach(e->System.out.println(e.getKey()+"-"+e.getValue()));
        PriorityQueue<Character> pq = new PriorityQueue<>();
        map.keySet().forEach(e->pq.offer(e));
//        StringBuilder str = new StringBuilder();
        while(!pq.isEmpty()){
            Character c = pq.poll();
            for (int i=0;i<map.get(c);i++)
                str.append(c);
        }
        return str.toString();*/

    }
}
