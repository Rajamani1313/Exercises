package String;

import java.util.Arrays;

public class StringCompare {
    public static void  main(String[] args){
        String[] logs = new String[]{"dig1 8 1 5 1", "let1 art can", "dig2 3 6", "let2 own kit dig", "let3 art zero"};
        System.out.println(Arrays.toString(reorder(logs)));

    }

    private static String[] reorder(String[] logs) {
        Arrays.sort(logs,(a,b)->{
            String[] str1 = a.split(" ",2);
            String[] str2 = b.split(" ",2);
            boolean isDigit1 = Character.isDigit(str1[1].charAt(0));
            boolean isDigit2 = Character.isDigit(str2[1].charAt(0));
            if(!isDigit1&&!isDigit2)
            {
                int cmp = str1[1].compareTo(str2[1]);
                if(cmp !=0) return cmp;
                return str1[0].compareTo(str2[0]);


            }else
                return isDigit1?(isDigit2?0:1):-1;
        });
        return logs;
    }
}
