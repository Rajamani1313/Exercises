package String;

import java.util.Stack;

public class RemoveKDigits {
    public static void main(String[] args){
        System.out.println(removeKdigits("1432219",3));
    }
    public static String removeKdigits(String num, int k) {
        if (k >= num.length())
            return "0";
        if (k==0)
            return num;
        Stack<Character> stk = new Stack<>();
        for (char c:num.toCharArray()){
            while(k>0&&!stk.isEmpty()&&stk.peek()>c){
                stk.pop();
                k--;
            }
            stk.push(c);
        }
        while (k-- > 0) stk.pop();
        StringBuilder sb = new StringBuilder();
        while(!stk.isEmpty())
            sb.append(stk.pop());
        sb.reverse();
        while(sb.length()>0 && sb.charAt(0)=='0'){
            sb.deleteCharAt(0);
        }
        if(sb.length() == 0)
            return "0";
        return sb.toString();

    }
}