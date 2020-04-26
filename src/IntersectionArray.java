import java.util.Arrays;

public class IntersectionArray {

    public static void main(String[] args) {
        int[] nums1 = {1,2,3};
        int[] nums2 = {4,5,3};
        System.out.println(Arrays.toString(intersect(nums1, nums2)));

    }

    public static int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int i=0,k =0, j=0;
        int[] result = new int[nums1.length];
        while(i<nums1.length && j < nums2.length){
//            System.out.println("First:" + nums1[i] + "Second:" + nums2[j]);
            if (nums1[i] == nums2[j]){
                result[k++] = nums1[i];
                j++;
                i++;
            }
            else if (nums1[i]>nums2[j])
                j++;
            else
                i++;
        }
        return Arrays.copyOf(result,k);
    }
}
