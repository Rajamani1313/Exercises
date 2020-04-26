import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ReverseInt {

    public static void main(String[] args) {
        int target1 = 663847412;
        System.out.println(reverse(target1));
      }

    private static int reverse(int x){
        int rev = 0;
        while (x !=0){
            int pop = x%10;
            x/= 10;
            if (rev > Integer.MAX_VALUE/10 || rev == Integer.MAX_VALUE && pop > 7)
                return 0;
            if (rev < Integer.MIN_VALUE/10 || rev == Integer.MIN_VALUE && pop < -8)
                return 0;
            rev = rev * 10 + pop;
        }
        System.out.println(Integer.MAX_VALUE);
        System.out.println(Integer.MIN_VALUE);
        return rev;
    }
}
