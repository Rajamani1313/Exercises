import java.util.*;

public class PlusOne {
    public static void main(String[] args) {
        int[] nums = {9,9,9,9,9};
        System.out.println(Arrays.toString(plusOne(nums)));
    }
    public static int[] plusOne (int[] digits){
        int carry = 1;
        for (int i = digits.length - 1; i >= 0; i--) {
            digits[i] = (digits[i] + carry);
            carry = digits[i] / 10;
            digits[i] = digits[i] % 10;
        }
        if (carry == 1) {
            int[] res = new int[digits.length + 1];
            res[0] = carry;
            System.arraycopy(digits, 0, res, 1, digits.length);
            return res;
        }
        return digits;
    }
}

