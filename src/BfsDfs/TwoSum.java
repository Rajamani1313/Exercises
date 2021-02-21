package BfsDfs;

import java.util.*;

import Tree.TreeNode;
import com.sun.source.tree.Tree;

/*Given a binary tree and an integer K, return two nodes which are at different level and their sum is equal to K.

        Constraints :

        Tree can have duplicate values.
        Incase more than one pair is available in the tree, then return any of the pair.
        I gave a solution based on DLL and HashMap, but it is not very optimised. This led to rejection :(

        Please let me know your thoughts on this.*/
public class TwoSum {
    public static void main(String[] args){
        TreeNode root = new TreeNode(7);
        root.left = new TreeNode(3);
        List<TreeNode> trees = twoSum(root,10);
        for(TreeNode node:trees)
            System.out.println(node.val);
    }

    public static List<TreeNode> twoSum(TreeNode root, int k) {
        if (root == null) return List.of();

        Map<Integer, TreeNode> visited = new HashMap<>();
        visited.put(root.val, root);
        Queue<TreeNode> q = new ArrayDeque<>();
        q.add(root);

        while (!q.isEmpty()) {
            Map<Integer, TreeNode> level = new HashMap<>();
            for (int size = q.size(); size > 0; size--) {
                TreeNode curr = q.poll();
                int complement = k - curr.val;

                if (visited.containsKey(complement)) {
                    return List.of(curr, visited.get(complement));
                }

                if (curr.left != null) q.add(curr.left);
                if (curr.right != null) q.add(curr.right);

                level.put(curr.val, curr);
            }
            visited.putAll(level);
        }

        return List.of();
    }
}
