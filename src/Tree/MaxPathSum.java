package Tree;

import Tree.TreeNode;

public class MaxPathSum {
    public static void main(String[] args){
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(-2);
        root.left.left = new TreeNode(1);
        root.left.left.left = new TreeNode(-1);
        root.left.right = new TreeNode(3);
        root.right = new TreeNode(-3);
        root.right.left = new TreeNode(-2);
//        root.right.left = new Tree.TreeNode(-15);
//        root.right.right = new Tree.TreeNode(7);
        System.out.println("In"+Integer.MIN_VALUE);
        System.out.println(maxPathSum(root));
    }
    static int result = Integer.MIN_VALUE;
    public static int maxPathSum(TreeNode root) {
        maxPath(root);
        return result;
//        if(root == null)
//            return Integer.MIN_VALUE;
//        int left = maxPathSum(root.left);
//        int right = maxPathSum(root.right);
//        System.out.println("left"+left+"right"+right);
//        int value = root.val;
//        value = Math.max(((left == Integer.MIN_VALUE ? 0 : left )+root.val),value);
//        value = Math.max(((right == Integer.MIN_VALUE ? 0 : right )+root.val),value);
//        value = Math.max(((left == Integer.MIN_VALUE ? 0 : left )+ (right == Integer.MIN_VALUE ? 0 : right ) + root.val),value);
//        System.out.println(value);
//        return  Math.max(value,Math.max(left,right));
    }
    public static int maxPath(TreeNode root){
        if (root == null)
            return 0;
        int left = Math.max(maxPath(root.left),0);
        int right = Math.max(maxPath(root.right),0);
        result = Math.max(result,root.val+left+right);
        System.out.println("left"+left+"right"+right);
        System.out.println("result"+result);
        System.out.println("retn"+root.val+Math.max(left,right));

        return root.val+Math.max(left,right);
    }
}