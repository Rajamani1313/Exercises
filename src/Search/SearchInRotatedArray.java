package Search;

public class SearchInRotatedArray {
    public static void main(String[] args){
        int[] nums = {3,1};
        System.out.println(search(nums,1));
    }
    public static int search(int[] nums, int target) {

        int left = 0;
        int right = nums.length -1;
        while(left <= right ){
            System.out.println("left"+left+"right"+right);
            int pivot = left+(right-left)/2;
            if (nums[pivot]==target)
                return pivot;
            if(nums[pivot]>=nums[left]){
                if(nums[left]<=target && nums[pivot]>=target){
                    right = pivot-1;
                }else{
                    left = pivot+1;
                }
            }
            else{
                if(nums[right]>=target && nums[pivot]<=target)
                    left=pivot+1;
                else
                    right = pivot-1;

            }
        }
            return -1;
    }
}