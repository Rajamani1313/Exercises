package Search;

public class KthLargestNumber {
    public static void main(String[] args){
        int[] nums = {3,2,3,1,2,4,5,5,6};
        System.out.println(findKthLargest(nums,5));
    }

/*
    private static int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> heap =
                new PriorityQueue<Integer>(nums.length, Collections.reverseOrder());
        for(int n: nums)
            heap.add(n);
        for (int i=k;i>1;i-- )
            heap.poll();
        return heap.poll();
    }
*/
    public static int findKthLargest(int[] nums, int k) {
        return quickselect(nums,0,nums.length-1,k);
    }
    public static int quickselect(int[] nums, int start, int end,int k){
        if(start==end)
            return nums[start];
        int pivot= nums[k-1];
        int l= start;
        int r=end;
        while(l<=r){

            while(l<=r && nums[l]>pivot)
                l++;
            while(l<=r && nums[r]<pivot)
                r--;
            if(l<=r){
                int temp= nums[l];
                nums[l]=nums[r];
                nums[r]=temp;
                l++;
                r--;
            }
            for(int n: nums)
                System.out.print(n+"|");
            System.out.println();
        }
        for(int n: nums)
            System.out.print(n+" ");
        System.out.println("--"+pivot+"start"+start+"end"+end);
        System.out.println("--"+"left"+l+"right"+r);

        if(k-1<=r)
            return quickselect(nums,start,r,k);
        if(k-1>=l)
            return quickselect(nums,l,end,k);

        return nums[k-1];
    }
}
