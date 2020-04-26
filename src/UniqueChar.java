import java.util.HashMap;

public class UniqueChar {
    public static void main(String[] args){
        System.out.println(firstUniqueChar("eetcode"));
    }
    public static int firstUniqueChar(String s){
//        HashMap<Character,Integer> map = new HashMap<>();
//        s.toLowerCase();
//        for (int i=0; i<s.length();i++){
//            char c = s.charAt(i);
//            System.out.println(c);
//            map.put(c,map.getOrDefault(c,0)+1);
//        }
//        map.entrySet().forEach(e->System.out.println(e.getKey()+"-"+e.getValue()));
//        for (int i =0; i <s.length();i++){
//            if (map.get(s.charAt(i))==1)
//                return i;
//        }
//        return -1;
        s= s.toLowerCase();
        int index = s.length();
        for (char c ='a';c<='z';c++){
            int i = s.indexOf(c);
            if (i>=0&&s.lastIndexOf(c)==i)
                index =( i>index?index:i);
        }
        return index==s.length()?-1:index;
    }
}
