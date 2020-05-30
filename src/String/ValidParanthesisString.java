package String;

public class ValidParanthesisString {
    public static void main(String[] args){
        System.out.println(checkValidString("((*)*)(*)"));
        System.out.println(checkValidString("(*()"));
        System.out.println(checkValidString("((*)"));
    }
    public static boolean checkValidString(String s) {
        int low = 0, high = 0;
        for(char c : s.toCharArray()){
            if (c == '(')
                low++;
            else
                low = Math.max(low-1,0);
            if (c != ')')
                high++;
            else
                high--;
            System.out.println("low"+low);
            System.out.println("high"+high);
            System.out.println();
            if (high<0)
                break;

        }
        return low==0;
    }
}