package BfsDfs;

import java.util.*;

public class FindMinFibonacci {
    public static void main(String[] args){
        System.out.println(Arrays.toString(findMinFibonacciNumbers(19)));
    }
    static List<Integer> ans;
    public static int[] findMinFibonacciNumbers(int k) {
        Stack <Integer> fib = new Stack<>();
        fib.add(1);
        fib.add(2);
        int curr = 2;
        int prev = 1;
        while (curr <= k) {
            int temp = curr+ prev;
            prev = curr;
            curr = temp;
            fib.add(curr);
            System.out.println(curr);
        }
        ans = new ArrayList<>();
        dfs(fib,k);
        int[] res=new int[ans.size()];
        for(int i=0;i<ans.size();i++)
            res[i] = ans.get(i);
        return res;
    }

    private static void dfs(Stack<Integer> fib,int k) {
        if(fib.contains(k)){
            ans.add(k);
            return;
        }
        while(fib.peek()>k)
            fib.pop();
        k -= fib.peek();
//        System.out.println(fib.pop());
        ans.add(fib.peek());
        dfs(fib,k);
    }
}