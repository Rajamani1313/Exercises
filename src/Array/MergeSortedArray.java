package Array;

public class MergeSortedArray {
    public static void main(String[] args){
        int[] nums1 = {-2,0,4,5,0,0,0};
        int[] nums2 = {-1,1,6};

        merge(nums1,4, nums2,3);
        for (int i: nums1){
            System.out.println(i);
        }
    }
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        if (n == 0)
            return;
        while (m > 0 && n > 0){
            if (nums1[m-1] > nums2[n-1]){
                nums1[m+n-1] = nums1[m-1];
                m--;
            }
            else{
                nums1[m+n-1] = nums2[n-1];
                n--;
            }
        }
        if (m == 0){
            while (n > 0){
                nums1[n-1] = nums2[n-1];
                n--;
            }
        }
    }
}