package BackTracking;

import java.util.HashMap;
import java.util.Map;

public class dice {
    private static int M = 1000000007;
    public static void main(String[] args) {
        System.out.println("Hello World!");
        int n =3;
//        int[] rollMax={1,2,1,2,1,2};
         int[] rollMax={1,1,1,1,1,1};

        System.out.println(dieSimulator(n, rollMax));
    }
    private static Map<Integer, Integer> map = new HashMap<>();
    private static int dieSimulator( int n , int[] dice) {
        if( n == 0 )
            return 1;
        int result = 0;
        for( int i =0; i < 6; i++) {
            if( dice[i] == 0 )
                continue;
            dice[i] -= 1;
            result += dieSimulator(n-1, dice);
            dice[i] += 1;
            result %= M;
        }
        return result;
    }
}
