package String;

public class RansomNote {
    public static void main(String[] args){
        System.out.println(canConstruct("a",""));
    }
    public static boolean canConstruct(String ransomNote, String magazine) {
        int[] charArr = new int[26];
        char[] magArr = magazine.toCharArray();
        for (char c:magArr){
            charArr[c-'a']++;
        }
        char[] ransomArr = ransomNote.toCharArray();
        for (char c:ransomArr){
            if(charArr[c-'a'] == 0)
                return false;
            charArr[c-'a']--;
        }
        return true;
    }
}