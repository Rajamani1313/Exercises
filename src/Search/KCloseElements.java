package Search;

import java.util.ArrayList;
import java.util.List;

public class KCloseElements {
    public static void main(String[] args){
        int nums[] = {1,2,3,4,5,6,7,8};
        System.out.println(findClosestElements(nums,3,5))   ;
    }
    public static List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> list = new ArrayList<>();
        if (k == 0) {
            return list;
        }
        int low = 0, high = arr.length - 1;

        // check if the search element is behind the first element:
        // eg arr = {1,2,3,4} and x = -1 then we return k elements from the beginning of the arr.
        if (x <= arr[low]) {
            int addIdx = 0;
            while (k > 0) {
                list.add(arr[addIdx++]);
                k--;
            }
            return list;
        }

        // check if the search element is after the last element:
        // eg arr = {1,2,3,4} and x = 5 then we return k elements from the behind of arr.
        if (x >= arr[high]) {
            while (k > 0) {
                list.add(arr[high - k + 1]);
                k--;
            }
            return list;
        }

        // logic to find the element (if present) or store the prev and next pointers
        // of the element to find
        int foundIdx = -1;
        while (low + 1 < high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] == x) {
                foundIdx = mid;
                break;
            }
            if (arr[mid] > x) {
                high = mid;
            } else {
                low = mid;
            }
        }

        // element found and store the correct prev and next pointers.
        // note: The above loop might terminate with low = 0 and high = arr.len - 1
        // and with the first mid element found. Hence the precautionary measure below.
        if (foundIdx != -1) {
            low = foundIdx - 1;
            high = foundIdx + 1;
            k--; // for the foundIdx itself
        }
        int n = arr.length;
        while (k > 0) {
            // once we are cross the first or last index then we don't have to loop the rest of the elements till k.
            if (low < 0) {
                high += k;
                break;
            } else if (high >= arr.length) {
                low -= k;
                break;
            }
            // '<=' because we want to give smaller elements the priority
            if (x - arr[low] <= arr[high] - x) {
                low--;
            } else {
                high++;
            }
            k--;
        }
        // store all the elements between the two pointers to the resultant list
        while (++low < high) {
            list.add(arr[low]);
        }
        return list;
    }
}
