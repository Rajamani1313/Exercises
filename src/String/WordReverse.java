package String;

public class WordReverse {
    public static void main(String[] args) throws InterruptedException {
        String stri = "Hello World";
        char[] str = stri.toCharArray();
        revWord(str);
        System.out.println(new String(str));
    }

    private static void revWord(char[] sentence) throws InterruptedException {
        int start = 0, end = sentence.length-1;
        reverse(sentence,start,end);
        start = 0;
        while(start<sentence.length){
            end = start+1;
            while(end < sentence.length && sentence[end]!= ' ')
                end++;
            // if(end == sentence.length) end++;
            reverse(sentence,start,end-1);
            start = end+1;
        }
    }

    private static void reverse(char[] str, int start, int end) {
        while(start < end){
            char temp = str[start];
            str[start++] = str[end];
            str[end--] = temp;
        }
    }
}
