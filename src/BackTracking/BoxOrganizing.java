package BackTracking;

import java.util.*;

public class BoxOrganizing {
    public static void main(String[] args){
        int[] inp1 = new int[]{20,15,20,50,20};
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

        inp1 = new int[]{2, 1,1,1};
        System.out.println(Arrays.toString(organize(inp1)));

    }

    private static int[] organize(int[] inp1) {
        Map<Integer,Integer> map = new HashMap<>();
        int sumRemain= 0;
        for(int n: inp1) {
            map.put(n, map.getOrDefault(n, 0) + 1);
            sumRemain +=n;
        }
        Set<Integer> set = map.keySet();
        List<Integer> list = new ArrayList<>(set);
//        list.forEach(n -> System.out.print(n+" "));
        System.out.println();
        Collections.sort(list,(a,b)->b-a);
        int runningSum = 0;
        List<Integer> Alist = new ArrayList<>();
        for(int n: list){
            int sum = map.get(n)*n;
            if(runningSum +sum < sumRemain){
                runningSum += sum;
                sumRemain -= sum;
                for(int i=0;i<map.get(n);i++){
                    Alist.add(n);
                }
            }
            if(runningSum > sumRemain)
                break;
        }
        Collections.sort(Alist);
//        Alist.forEach(n -> System.out.print(n+" "));
        System.out.println();
        int[] A = new int[Alist.size()];
        for(int i=0;i<A.length;i++) {
            A[i] = Alist.get(i);
//            System.out.println(A[i]+":"+Alist.get(i));
        }
        return A;

    }
}
