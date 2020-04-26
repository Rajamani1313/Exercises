import java.util.HashMap;

public class RomanToInt {
    public static void main(String args[]) {
    }

    public int romanToInt(String s) {
        HashMap map = new HashMap<Character, Integer>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
        int res = 0, prev = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            int temp = (int) map.get(s.charAt(i));
            res = res > temp ? res - temp : res + temp;
        }
        return res;
    }
}
