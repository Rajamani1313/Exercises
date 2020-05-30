package Maths;

import java.util.Arrays;

public class PerfectSquare {
    public static void main(String[] args){
        System.out.println(isPerfectSquare(100));
    }
    // num = 256;
    public static boolean isPerfectSquare(int num) {
        int left=1;
        int right = num;
        while(left<=right){
            int mid = left + ((right - left)/2);
            int rem = num%mid;
            int quo = num/mid;
            System.out.println("left"+left+" right"+right+" mid"+mid+" rem"+rem+" quo"+quo);
            if (rem == 0 && quo == mid)
                return true;
            else if (quo<mid)
                right = mid-1;
            else
                left = mid+1;

        }
        return false;
    }

    static class CountPrime {
        public static void main(String[] args) {
    //        System.out.println(countPrimes1(100));
            System.out.println(countPrimes(10000));
        }

        static int countPrimes(int n) {
            if (n < 3) return 0;
            int count = n / 2;
            boolean[] notPrime = new boolean[n];
            for (int i = 3; i * i < n; i += 2) {
                if (notPrime[i]) continue;
                for (int j = i * i; j < n; j += 2 * i) {
                    if (!notPrime[j]) {
                        --count;
                        notPrime[j] = true;
                    }
                }
            }
            for (int i = 3; i < n; i += 2)
                System.out.println(i + "-" + notPrime[i]);
            return count;
        }

        public static int countPrimes1(int n) {
            if (n < 3)
                return 0;
            else if (n == 3)
                return 1;

            boolean[] primes = new boolean[n];
            Arrays.fill(primes, true);

            primes[0] = primes[1] = false;

            int i, j;
            for (i = 2; i * i < n; i++) {
                if (primes[i]) {
                    for (j = i + i; j < n; j = j + i) {
                        primes[j] = false;
                    }
                }
            }

            int count = 0;
            for (i = 0; i < n; i++) {
                if (primes[i])
                    ++count;
            }

            return count;
        }
    }
}