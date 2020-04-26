import com.sun.source.tree.Tree;

public class bstFromPreorder {
    public static void main(String[] args) {
        int[] nums = {8, 5, 1, 7, 10, 12};
        System.out.println(bst(nums).left.right.val);
    }


    private static TreeNode bst(int[] nums) {
        int i = 0;
        TreeNode root = new TreeNode(nums[i++]);
        TreeNode curr = root;

        while (i < nums.length) {

            if (curr.val > nums[i]) {
                if (curr.left == null) {
                    curr.left = new TreeNode(nums[i++]);
                    curr = root;
                }
                else
                    curr = curr.left;
            } else {
                if (curr.right == null) {
                    curr.right = new TreeNode(nums[i++]);
                    curr = root;
                }
                else
                    curr = curr.right;
            }
        }
        return root;
    }

}