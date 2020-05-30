package String;

public class LongestCommonPrefix {
    public static void main (String[] args){
        String[] strings = {"flower","flow","flight"};
        System.out.println(longestCommonPrefix(strings));
        String[]  strings1 = {"aa","a"};
        System.out.println(longestCommonPrefix(strings1));
    }
    public static String longestCommonPrefix(String[] strs) {
        StringBuilder prefix = new StringBuilder();
        if (strs.length == 0)
            return prefix.toString();
        for (int i = 0; i<strs[0].length(); i++){
//            System.out.println(strs[0].charAt(i));
            for (int j = 1; j<strs.length; j++){
//                System.out.println(strs[j]);
                if (i >= strs[j].length() || strs[0].charAt(i) != strs[j].charAt(i))
                    return prefix.toString();
            }
            prefix.append(strs[0].charAt(i));
        }
        return prefix.toString();
    }
}
