package Tree;

public class Cousins {
    public static void main(String[] args){
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(4);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(3);

        System.out.println(isCousins(root,4,5));
    }
    static int firstlevel = -1;
    static int secondlevel = -1;
    static TreeNode firstParent, secondParent,parent;
    public static boolean isCousins(TreeNode root, int x, int y) {
        matchingParent(root,x,y,0);
        System.out.println("first"+firstlevel + "second" + secondlevel);
        System.out.println("first"+firstParent.val + "second" + secondParent.val);
        return firstlevel == secondlevel && firstParent != secondParent;
    }

    static void matchingParent(TreeNode root, int first,int second,int depth){
        if (root == null)
            return;
        if (root.val == first){
            firstParent = parent;
            firstlevel = depth;
            return;
        }else if (root.val == second){
            secondParent = parent;
            secondlevel = depth;
            return;
        }
        parent = root;
        matchingParent(root.left,first,second,depth+1);
        matchingParent(root.right,first,second,depth+1);
    }
}