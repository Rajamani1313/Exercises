package Array;

import java.util.*;

public class FirstUnique {
    HashSet<Integer> set ;
    Set<Integer> que;

    public FirstUnique(int[] nums) {
        set = new HashSet<Integer>();
        que = new LinkedHashSet<Integer>();
        for (int n: nums)
            add(n);
    }

    public int showFirstUnique() {
        return que.size()==0? -1:que.iterator().next();
    }

    public void add(int value) {
        if(!set.contains(value)){
            set.add(value);
            que.add(value);
        }else{
            que.remove(value);
        }
    }
    public static void main(String[] args){
        int[] nums = {1,2,3,7,7};
        FirstUnique firstUniqueNumber = new FirstUnique(nums);
        System.out.println(firstUniqueNumber.showFirstUnique());
        firstUniqueNumber.add(1);
        firstUniqueNumber.add(3);
        System.out.println(firstUniqueNumber.showFirstUnique());
        firstUniqueNumber.add(5);
        System.out.println(firstUniqueNumber.showFirstUnique());
        firstUniqueNumber.add(2);
        System.out.println(firstUniqueNumber.showFirstUnique());
    }
}

/**
 * Your Array.FirstUnique object will be instantiated and called as such:
 * Array.FirstUnique obj = new Array.FirstUnique(nums);
 * int param_1 = obj.showFirstUnique();
 * obj.add(value);
 */