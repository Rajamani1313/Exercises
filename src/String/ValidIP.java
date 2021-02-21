package String;

import java.util.Arrays;

public class ValidIP {
    public static void main(String[] args){
//        String IP = "2001:0db8:85a3:0:0:8A2E:0370:7334";
        String IP = "1.0.1.";
        System.out.println(Integer.toBinaryString(-2));
//        System.out.println(valid(IP));
    }

    private static String valid(String IP) {
        if (IP.chars().filter(c->c=='.').count() == 3 ) {
            for (String str : IP.split("[.]", -2)) {
                if (str.length() == 0 || str.length()>3 || (str.charAt(0) == '0') && str.length()!=1)
                    return "1Neither";
                for(char c:str.toCharArray())
                    if (!Character.isDigit(c))
                        return "2Neither";
                if (Integer.parseInt(str) > 255)
                    return "3Neither";
            }
            return "IPv4";
        }
        if (IP.chars().filter(c->c==':').count() == 7 ) {
            for(String str:IP.split(":",0)){
                if(str.length()==0 || str.length()>4)
                    return "4Neither";
                for(char c: str.toCharArray())
                    if(!(Character.isDigit(c)||(c>='a'&&c<='f')||(c>='A'&&c<='F'))) {
                        System.out.println("c"+c);
                        return "5Neither";
                    }
            }
            return "IPv6";
        }
        return "6Neither";
    }
}
