package Array;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Stream {
    public static void main(String[] args){
        int[] stream = {2,1,6,5};
        System.out.println(run(stream,13));
    }

    private static boolean run(int[] stream,int target) {
        boolean[] flags = new boolean[target+1];
        flags[0] = true;
        for(int i=0;i<stream.length;i++){
            if(stream[i]==target)
                return true;
            if(stream[i]>target)
                continue;
           if (check(stream[i],flags,target))
               return true;
        }
        return false;
    }

    private static boolean check(int curr, boolean[] flags,int target) {
        System.out.println("curr"+curr+" target"+target);
        for(int i=target;i>=curr;i--){
            flags[i] |= flags[i-curr];
            if(flags[target])
                return true;
//            System.out.println("curr"+curr);
        }
        System.out.println(Arrays.toString(flags));
        return flags[target];
    }
}
