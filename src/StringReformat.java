import java.util.Arrays;

public class StringReformat {
    public static void main(String[] args){
        System.out.println(reformat("a0b1c2")+"******");
        System.out.println(reformat("leetcode")+"******");
        System.out.println(reformat("1229857369")+"******");
        System.out.println(reformat("covid2019")+"******");
        System.out.println(reformat("ab123")+"******");
    }
    public static String reformat(String s) {
        int len = (s.length()+1)/2;
        int[] num = new int[len];
        int[] alpha = new int[len];
        int a=0,n=0;
        for (int i=0; i<s.length();i++){
            System.out.println("a"+a);
            System.out.println("length"+len);
            if (s.charAt(i) >= 'a' && s.charAt(i) <='z'&& a < len)
                alpha[a++] = i;
            else if (s.charAt(i) >= '0' && s.charAt(i) <='9'&& n < len)
                num[n++] = i;
            else
                return "";
        }
        System.out.println(Arrays.toString(alpha));
        System.out.println(Arrays.toString(num));
        StringBuilder str = new StringBuilder();
        boolean flag;
        if (a>n)
            flag= true;
        else
            flag = false;
        while(a >0 || n >0){
            if (flag) {
                str.append(s.charAt(alpha[--a]));
                flag = false;
            }
            else {
                str.append(s.charAt(num[--n]));
                flag = true;
            }
        }
        return str.toString();

    }
}