package Assesment;

import java.util.ArrayDeque;
import java.util.Deque;

public class TurnTile {
    public static void main(String args[]){
        int n = 4;
        int[] arrTime = {0, 1, 1, 3, 3};
        int[] direction = {0, 1, 0, 0, 1};


        int[] times = turnstile(n, arrTime, direction);

        for(int i = 0; i < times.length; i++)
            System.out.print(times[i]+" ");
        System.out.println();
    }

    private static int[] turnstile(int n, int[] arrTime, int[] direction) {
        Deque<int[]>[] qList = new Deque[2];
        qList[0]=new ArrayDeque<>();
        qList[1]=new ArrayDeque<>();

        for(int i=0;i<arrTime.length;i++){
            qList[direction[i]].offer(new int[]{arrTime[i],i});
        }
        int[] times = new int[arrTime.length];

        int cTime = 0, dir = 1;
        while(qList[0].size() > 0 ||qList[1].size() > 0){
//            System.out.println(qList[0].peek()[0] + " "+ qList[0].peek()[1]);
//            System.out.println(qList[1].peek()[0] + " "+ qList[1].peek()[1]);
            int enterTime = qList[0].size() == 0 ? Integer.MAX_VALUE :qList[0].peek()[0];
            int exitTime = qList[1].size() == 0 ? Integer.MAX_VALUE :qList[1].peek()[0];
            int curr = Math.min(enterTime,exitTime);

            if(curr > cTime+1)
                dir = 1;
            cTime = Math.max(curr,cTime);
            int comp = enterTime - exitTime;

            int q =(comp > 0 || (comp == 0 && dir == 1)) ?1:0;
            do{
                times[qList[q].poll()[1]] = cTime;
                cTime++;
            }while (qList[q].size()>0 && qList[q].peek()[0] <= cTime);

            dir = q;

        }
        return times;
    }
}
