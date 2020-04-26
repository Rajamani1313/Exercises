
public class MandN {
    public static void main( String[] args){
        int count = Integer.parseInt(args[0]);

        for (int i =0; i<=count; i+=2){
            int m=0,n=0;
            m = Integer.parseInt(args[i+1]);
            n = Integer.parseInt(args[i+2]);
            int nLength = String.valueOf(n).length();
            int rLength = String.valueOf(m+n).length();
            if (nLength == rLength)
                System.out.println(n);
            else
                System.out.println(m+n);

        }
    }
}
