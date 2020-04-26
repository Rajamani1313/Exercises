public class Anagram {
    public static void main(String[] args){
        System.out.println(isAnagram("anagram","nagaram"));
    }

    public static boolean isAnagram(String s, String t) {
        if (s.length() != t.length())
            return false;
        int[] charArray = new int[26];

        for (char sc: s.toCharArray())
            charArray[sc - 'a']++;

        for (char tc: t.toCharArray())
            charArray[tc - 'a']--;

        for (int i=0; i<26;i++)
            if(charArray[i] != 0)
                return false;

        return true;
    }
}
