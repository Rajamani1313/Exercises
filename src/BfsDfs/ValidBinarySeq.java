package BfsDfs;

import Tree.TreeNode;

public class ValidBinarySeq {
    public static void main(String[] args){
        TreeNode root = new TreeNode(0);
        root.left = new TreeNode(1);
        root.right = new TreeNode(0);
        root.left.left = new TreeNode(0);
        root.left.left.right = new TreeNode(1);
        root.left.right = new TreeNode(1);
        root.left.right.left = new TreeNode(0);
        root.left.right.right = new TreeNode(0);
        root.right.left = new TreeNode(0);
        int[] nums = {0,1,1};
        System.out.println(isValidSequence(root,nums));
    }
    public static boolean isValidSequence(TreeNode root, int[] arr) {
        return dfs(root,arr,0);
    }
    static boolean dfs(TreeNode root, int[] arr, int pos){
        System.out.println("po"+pos);
        if(root == null || pos == arr.length || root.val != arr[pos++])
            return false;
        else if (pos == arr.length && root.left == null && root.right == null)
            return true;
        else
            return dfs(root.left,arr,pos) || dfs(root.right,arr,pos);
    }
}