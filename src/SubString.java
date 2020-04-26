public class SubString {
    public static void main(String[] args){
//        System.out.println(strStr("","ll"));
//        System.out.println(strStr("hello","ll"));
//        System.out.println(strStr("helo","ll"));
//        System.out.println(strStr("hello",""));
//        System.out.println(strStr("hello","lla"));
//        System.out.println(strStr("mississippi","issip"));
        System.out.println(strStr3("mississippi","pi"));
    }
/*
    public static int strStr(String haystack, String needle) {
        int result = -1;
        int j = 0 , first = 0;
        if (needle.length()==0)
            return 0;
        for (int i =0; i<haystack.length(); i++){
            if (haystack.charAt(i) == needle.charAt(j)) {
                if (j == 0)
                    result = i;
                j++;
                if (j == needle.length())
                    return result;
            } else if (j > 0) {
                j = 0;
                i = result;
//                result = -1;
            }
        }
        return  -1;
    }
*/
    public static int strStr2(String haystack, String needle) {
        if (needle == null || needle.isEmpty()) {
            return 0;
        }

        int n = haystack.length();
        int l = needle.length();
        for (int start = 0; start <= n - l ;  start++) {
            if (haystack.substring(start, start + l).equals(needle)) {
                return start;
            }
        }
        return -1;

    }

    public static int strStr3(String haystack, String needle) {
        int m = haystack.length(), n = needle.length();
        for (int i = 0, j; i <= m - n; i++) {
            for (j = 0; j < n; j++) {
                if (haystack.charAt(i + j) != needle.charAt(j)) break;
            }
            if (j == n) return i;
        }
        return -1;
    }
}
