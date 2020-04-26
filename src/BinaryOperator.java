public class BinaryOperator {
    public static void main(String[] args){
        System.out.println(hammingWeight(-5));
    }
    public static int hammingWeight(int n) {
        int res = 0;
        while (n != 0){
            if ((n & 1) == 1)
                res++;
            n >>= 1;
        }
        return res;
    }
}
