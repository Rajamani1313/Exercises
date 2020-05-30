package String;

public class PalindromeString {
    public static void main(String[] args){
        System.out.println(isPlaindrome(".,"));
    }
    public static boolean isPlaindrome(String s) {
        if (s.length() <= 1)
            return true;
        int l = 0;
        int r = s.length() - 1;
        while (l < r) {
            while (nonAlpha(s.charAt(l))) {
                l++;
                if (l == r)
                    return  true;
            }
            while (nonAlpha(s.charAt(r))){
                r--;
                if (l==r)
                    return true;
            }
            System.out.println(Character.toLowerCase(s.charAt(l))+"-"+Character.toLowerCase(s.charAt(r)));
            if (Character.toLowerCase(s.charAt(l))!=Character.toLowerCase(s.charAt(r))){

                return false;
            }
            l++;
            r--;
        }
        return true;
    }
    public static boolean nonAlpha(char c) {
        if ((c >= 'a' && c <='z') ||
                (c >= 'A' && c <='Z') ||
                (c >= '0' && c <='9'))
            return false;
        return true;
    }
}
