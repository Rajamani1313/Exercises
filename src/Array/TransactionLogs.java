package Array;

import java.util.Arrays;
import java.util.*;

public class TransactionLogs {
    public static void main(String args[]){
        String[] logs = new String[]{"345366 89921 45",
"029323 38239 23",
"38239 345366 15",
"029323 38239 77",
"345366 38239 23",
"029323 345366 13",
"38239 38239 23"};
        System.out.println(Arrays.toString(getResult(logs, 3)));
    }

    private static String[] getResult(String[] logs, int t) {
        Map<String,Integer> map = new TreeMap<>((a,b)-> Integer.valueOf(b)-Integer.valueOf(a));
        for(String log: logs){
            String[] row = log.split("\\s");
            Set<String> set = new HashSet<>();
            for(int i=0;i<row.length-1;i++){
                set.add(row[i]);
            }
            for(String str: set){
                map.put(str,map.getOrDefault(str,0)+1);
            }
        }
        List<String> list = new ArrayList<>();
        for(Map.Entry<String,Integer> e: map.entrySet()){
            if(e.getValue()>=t){
                list.add(e.getKey());
            }
        }
        String[] res = new String[list.size()];
        return list.toArray(res);
    }
}
