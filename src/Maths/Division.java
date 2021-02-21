package Maths;

import java.nio.charset.IllegalCharsetNameException;
import java.nio.file.LinkOption;
import java.util.HashMap;
import java.util.spi.LocaleNameProvider;

public class Division {
    public static void main(String[] args){
        System.out.println(fractionToDecimal(-1,-2147483648));
        System.out.println(fractionToDecimal(1,-2147483648));
        System.out.println(fractionToDecimal(22,7));
    }

    private static String fractionToDecimal(int num, int den) {
        if (num == 0 || den == 0) return "0";

        StringBuilder sb = new StringBuilder();
        if (num<0 ^ den <0 )
            sb.append("-");

        long dividend = Math.abs((long)num);
        long divisor = Math.abs((long)den);
//        divisor = Math.abs(divisor);
        long remainder = dividend % divisor;
        sb.append(dividend/divisor);
        if (remainder==0) return sb.toString();
        sb.append(".");
        HashMap<Long,Integer> map = new HashMap<>();
        while (remainder!=0){
            System.out.println("re"+remainder);
            System.out.println("res"+sb.toString());
            if(map.containsKey(remainder)){
                sb.insert(map.get(remainder),"(");
                sb.append(")");
                break;
            }else{
                map.put(remainder,sb.length());
                remainder *=10;
                sb.append(remainder/divisor);
                remainder %= divisor;
            }
        }
        return sb.toString();
    }
}
