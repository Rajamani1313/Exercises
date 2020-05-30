package BackTracking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Backtracking {
    public static void main(String[] args){
        System.out.println(letterCombinations("23"));
    }
    static HashMap<Integer, String> map = new HashMap<>();

    static List<String> result = new ArrayList<>();

    public static void backtrack(String str,String digits){
        if (digits.length() ==  0)
            result.add(str);
        else {
            String value = map.get((digits.charAt(0) - '0'));
            for (int i = 0; i < value.length(); i++) {
                backtrack(str + value.substring(i,i+1), digits.substring(1));
            }
        }
    }

    public static List<String> letterCombinations(String digits) {
        map.put(2,"abc");
        map.put(3,"def");
        map.put(4,"ghi");
        map.put(5,"jkl");
        map.put(6,"mno");
        map.put(7,"pqrs");
        map.put(8,"tuv");
        map.put(9,"wxyz");
        if (digits.length() != 0)
            backtrack("",digits);
        return result;
    }
}