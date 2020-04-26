import java.util.Arrays;

public class sort {
    public static void main(String[] args){
        int[] nums = {1,2,0};
        sortColors(nums);
        System.out.println(Arrays.toString(nums));
    }
    public static void sortColors(int[] nums) {
        int first = 0;
        int last = nums.length - 1;
        int curr = 0;
        while (curr <= last) {
            if (nums[curr] == 0) {
                int temp = nums[curr];
                nums[curr] = nums[first];
                nums[first++] = temp;
                curr++;
            }
            else if (nums[curr] == 2) {
                int temp = nums[curr];
                nums[curr] = nums[last];
                nums[last--] = temp;
            }
            else
                curr++;
            System.out.println(Arrays.toString(nums));
        }
    }
}