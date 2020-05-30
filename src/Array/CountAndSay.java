package Array;

public class CountAndSay {
    public static void main(String[] args) {
        System.out.println(countAndSay(10));
    }

    public static String countAndSay(int n) {
        StringBuilder str = new StringBuilder();
        str.append("1");
        for (int i = 0; i < n - 1; i++) {
            StringBuilder temp = new StringBuilder();
            int counter = 0;
            char c = str.charAt(0);
            for (int j = 0; j < str.length(); j++) {
                if (str.charAt(j) == c)
                    counter++;
                else {
                    temp.append(counter).append(c);
                    counter = 1;
                    c = str.charAt(j);
                }
            }
            str = temp.append(counter).append(c);
        }
        return str.toString();
    }
}
