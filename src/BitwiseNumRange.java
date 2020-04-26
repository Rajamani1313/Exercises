public class BitwiseNumRange {
    public static void main(String[] args){
        System.out.println(rangeBitwiseAnd(8    ,15));
    }
    public static int rangeBitwiseAnd(int m, int n) {
        while(n>m)
            n = n & n-1;
        return n;
    }
    public static int rangeBitwiseAnd1(int m, int n) {
        int shift = 0;
        while(m < n){
            m >>= 1;
            n >>= 1;
            shift++;
        }
        return m << shift;
    }
}