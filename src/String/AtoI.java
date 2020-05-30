package String;

public class AtoI {
    public static void main(String[] args) {
        String str = "0-1";
        System.out.println(myAtoi(str));
//        str = "+";
//        System.out.println(myAtoi(str));
//        str = " 0000 ";
//        System.out.println(myAtoi(str));
//        str = "www 42";
//        System.out.println(myAtoi(str));
//        str = "  42 when ";
//        System.out.println(myAtoi(str));
//        str = "++";
//        System.out.println(myAtoi(str));
//        str = " -42 -";
//        System.out.println(myAtoi(str));
//        str = "";
//        System.out.println(myAtoi(str));
//        str = "-2147483649";
//        System.out.println(myAtoi(str));
//        str = "2147483649";
//        System.out.println(myAtoi(str));
//        str = "2147483647";
//        System.out.println(myAtoi(str));
//        str = "2147483646";
//        System.out.println(myAtoi(str));
    }

/*
    public static int myAtoi(String str) {
        int res = 0;
        boolean wasNumOrSign = false;
        boolean wasMinusSign = false;
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c == ' ' && !wasNumOrSign) {
            } else if (c == '+' && !wasNumOrSign) {
                wasNumOrSign = true;
            } else if (c == '-' && !wasNumOrSign) {
                wasNumOrSign = true;
                wasMinusSign = true;
            } else if (c >= '0' && c <= '9') {
                wasNumOrSign = true;
                int nextNum = c - '0';
                if (wasMinusSign) {
                    if ((Integer.MIN_VALUE + nextNum) / 10 > (res * -1)) {
                        return Integer.MIN_VALUE;
                    }
                } else {
                    if ((Integer.MAX_VALUE - nextNum) / 10 < res) {
                        return Integer.MAX_VALUE;
                    }
                }
                res = res * 10 + nextNum;
            } else {
                break;
            }
        }
        return wasMinusSign ? res * -1 : res;
    }
*/

    public static int myAtoi(String str) {
        // str = "2147483648";
//            int sign = 1;
        int num = 0;
        boolean sign = false, valid = false;
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c == ' ' && !valid) {
            } else if (c == '-' && !valid) {
                sign = true;
                valid = true;
            } else if (c == '+' && !valid)
                valid = true;
            else if (c >= '0' && c <= '9') {
                valid = true;
                if ((num > Integer.MAX_VALUE / 10) ||
                        (num == (Integer.MAX_VALUE / 10) && str.charAt(i) > '7')) {
                    if (sign)
                        return Integer.MIN_VALUE;
                    else
                        return Integer.MAX_VALUE;
                }
                num *= 10;
                num += (int) (c - '0');
            }
            else
                break;;
        }
        return sign ? num * -1 : num;
    }
}
