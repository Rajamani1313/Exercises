import java.util.ArrayList;
import java.util.List;

public class GenerateParanetheses {

    public static void main(String[] args)
    {
        System.out.println(generateParanthesis(3));
    }
    public static List<String> generateParanthesis(int n){
        List<String> result = new ArrayList<>();
        backtrack(result,n,0,0,"");
        return result;
    }

    private static void backtrack(List<String> result, int n, int open, int close, String str) {
        if (str.length() == 2 * n){
            result.add(str);
            return;
        }
        if (open < n)
            backtrack(result,n,open+1,close,str+"(");
        if (close < open)
            backtrack(result,n,open,close+1,str+")");
    }
}
