package Graph;

import java.util.*;

public class SelectionSwap {

    public static void main(String[] args){

        int[] arr = new int[]{5,4,1,2};
        System.out.println(swapSort(arr));
        arr = new int[]{101, 758, 315, 730, 472,
        619, 460, 479};
        System.out.println(swapSort(arr));
        arr = new int[]{1,5,4,3,2};
        System.out.println(swapSort(arr));

    }

    private static int swapSort(int[] arr) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<arr.length;i++){
            map.put(arr[i],i);
        }
        int[] temp = Arrays.copyOf(arr,arr.length);
        Arrays.sort(temp);
        int ans = 0;
        for(int i=0;i<arr.length;i++){
            if(i == map.get(temp[i]))
                continue;
            int j = map.get(temp[i]);
            map.put(temp[i],i);
            map.put(arr[i],j);
            swap(arr,i,j);
            ans++;
        }
        return ans;
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
