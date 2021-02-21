package DP;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class KP2 {
    public static void main(String[] args) {
        int[] inp1 = new int[]{15, 50, 20, 20, 20};
        System.out.println(Arrays.toString(organize(inp1)));

        inp1 = new int[]{1,2,5,8,4};
        System.out.println(Arrays.toString(organize(inp1)));

        inp1 = new int[]{5,3,2,4,1,2};
        System.out.println(Arrays.toString(organize(inp1)));

        inp1 = new int[]{10, 4, 4, 4, 3};
        System.out.println(Arrays.toString(organize(inp1)));

        inp1 = new int[]{1,2,5,8,4};
        System.out.println(Arrays.toString(organize(inp1)));

        inp1 = new int[]{5,3,2,4,1,2};
        System.out.println(Arrays.toString(organize(inp1)));

        inp1 = new int[]{10, 9, 9, 6, 5, 4, 3, 2, 1};
        System.out.println(Arrays.toString(organize(inp1)));

        inp1 = new int[]{2, 1, 1, 1};
        System.out.println(Arrays.toString(organize(inp1)));

        inp1 = new int[]{4, 4, 1, 1,8};
        System.out.println(Arrays.toString(organize(inp1)));
    }

    private static int[] organize(int[] inp1) {
        int sum = 0;
        for(int n: inp1)
            sum += n;
        Arrays.sort(inp1);
        List<Integer> list = kp(sum/2+1,0,0,0,inp1);
        int[] res = new int[list.size()];
        for(int i=0;i<list.size();i++){
            res[i] = list.get(i);
        }
        return res;
    }

    private static List<Integer> kp(int remWeight, int index, int weight, int count,int[] inp1) {
//        System.out.println("rem weight :"+remWeight);
//        System.out.println("index :"+index);
//        System.out.println("weight :" + weight);
//        System.out.println("count :" + count);
//        System.out.println("-----------");
        if(remWeight <=0){
            List<Integer> list = new ArrayList<>();
            while(count > 0) {
                list.add(weight);
                count--;
            }
            return list;
        }
        if(index == inp1.length)
            return null;
        int newWeight = inp1[index++];
        int newCount = 1;
        while(index < inp1.length && inp1[index] == inp1[index-1]) {
            newCount++;
            index++;
//            newWeight += inp1[index];
        }

        List<Integer> list1 = kp(remWeight-(newWeight*newCount),index,newWeight,newCount,inp1);
        List<Integer> list2 = kp(remWeight,index,0,0,inp1);
        list1 =  compareList(list1,list2);
        if(list1 == null || count == 0) return list1;

        while(count > 0) {
            list1.add(weight);
            count--;
        }
        return list1;

    }

    private static List<Integer> compareList(List<Integer> list1, List<Integer> list2) {
        if(list2 == null || list2.size() > list1.size()) return list1;
        if(list1 == null || list1.size() > list2.size()) return list2;
        int list1Sum=0,list2Sum=0;
        for(int i=0;i<list1.size();i++){
            list1Sum += list1.get(i);
            list2Sum += list2.get(i);
        }
        if(list1Sum > list2Sum) return list1;
        return list2;
    }
}
