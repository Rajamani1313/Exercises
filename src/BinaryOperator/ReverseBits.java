package BinaryOperator;

public class ReverseBits {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        boolean isNegative = n < 0;
        if (isNegative) n = ~n;
        int sum = 0;
        int reversePos = 31;
        while (reversePos >= 0) {
            sum *= 2;
            sum += n % 2;
            n /= 2;
            reversePos--;
        }
        return isNegative ? ~sum : sum;
    }
}