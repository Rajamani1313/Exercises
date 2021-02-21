package String;

import java.util.HashMap;

public class RabinKarp {

    public static void main(String[] args){
        System.out.println(longestDupSubstring("banana"));
    }
    static int[] power;
    static int prime = 10000001;
    public static String rabinKarp(String s,int len){
        if (len == 0)
            return "";
        int n = s.length();
        int curr = 0;
        HashMap<Integer,int[]> map = new HashMap<>();

        for(int i=0;i<len;i++){
            curr = (curr*26+(s.charAt(i)-'a'))%prime;
        }
        map.put(curr,new int[]{0});
        for(int i=len;i<n;i++){
            curr =((curr-power[len-1]*(s.charAt(i-len)-'a'))%prime+prime)%prime;
            curr = (curr*26+(s.charAt(i)-'a'))%prime;

            if(map.containsKey(curr)){
                String str = s.substring(i-len+1,i+1);
                for(int index:map.get(curr)){
                    if(s.substring(index,len) == str)
                        return s.substring(index,len);
                }
            }else{
                map.put(curr,new int[]{i-len+1});
            }
        }
        return "";
    }
    public static String longestDupSubstring(String S) {
        int n = S.length();
        int l =0, r=n-1;
        power = new int[n];
        power[0] = 1;

        for(int i=1;i<n;i++){
            power[i] = (power[i-1]*26) % prime;
        }
        String res = new String();
        while(l<=r){
            int mid = l+(r-l)/2;
            String curr = rabinKarp(S,mid);
            if(curr.length() > res.length()){
                res = curr;
                l = mid+1;
            }
            r = mid -1;
        }
        return res;
    }
}