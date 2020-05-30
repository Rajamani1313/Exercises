package Tree;

public class TreeConstruct {
    private static int inIndex;
    private static int preIndex;

    public static void main(String[] args){
        int[] pre = {1,2};
        int[] ino = {1,2};
        System.out.println(buildTree(pre,ino).val);
    }
    private static TreeNode buildTree(int[] pre, int[] ino) {
        if (pre == null || pre.length == 0)
            return null;
        preIndex = 0;
        inIndex = 0;

        return dfs(pre,ino,null);

    }

    private static TreeNode dfs(int[] pre, int[] ino, TreeNode end) {
        if (preIndex >= pre.length || inIndex >= ino.length)
            return null;
        TreeNode root = new TreeNode(pre[preIndex++]);

        if (root.val != ino[inIndex]){
            root.left = dfs(pre,ino,root);
        }
        inIndex++;
        if(end == null || ino[inIndex] != end.val){
            root.right = dfs(pre,ino,end);
        }
        return root;
    }
/*
    public static Tree.TreeNode buildTree(int[] preorder, int[] inorder) {
        int i=0,j = 0;
        Tree.TreeNode temp = new Tree.TreeNode(preorder[i]);
        Tree.TreeNode root = temp;

        Stack<Tree.TreeNode> stack = new Stack<Tree.TreeNode>();

        for (i=1; i<preorder.length; i++){
            System.out.println("Entry"+preorder[i]);
            if (temp.val == inorder[j] ){
                j++;
                while (!stack.isEmpty() && stack.peek().val == inorder[j]){
                    j++;
                    temp = stack.pop();
                    System.out.println("pop"+temp.val);
                }
                temp.right = new Tree.TreeNode(preorder[i]);
                temp = temp.right;
            }else {
                stack.add(temp);
                System.out.println("push"+temp.val);
                temp.left = new Tree.TreeNode(preorder[i]);
                temp = temp.left;
            }
        }
        return root;
    }
*/
}
