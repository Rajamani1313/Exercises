package Tree;

import com.sun.source.tree.Tree;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

public class TreeSerialize {
    public static void main(String[] args){
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(2);
        root.right = new TreeNode(1);
        String text = serialize(root);
        HashSet<Integer> set = new HashSet<>();
        set.add(1);
        set.add(2);
        Random random = new Random();
        System.out.println(random.nextInt(set.size()));
//        System.out.println(deserialize(text));
    }

    public static String serialize(TreeNode root) {

        StringBuilder traverse = new StringBuilder("[");
        Queue<TreeNode> que = new LinkedList<>();
        que.offer(root);
        while(!que.isEmpty()){
            TreeNode temp = que.poll();
            if (temp == null)
                traverse.append("null");
            else {
                traverse.append(temp.val);
                que.offer(temp.left);
                que.offer(temp.right);
            }
            traverse.append(",");
        }
        traverse.deleteCharAt(traverse.length()-1);
        traverse.append("]");
        return traverse.toString();
    }

    // Decodes your encoded data to tree.
    public static TreeNode deserialize(String data) {
        if(data == null || data.isEmpty() || data.equals("[]")|| data.equals("[null]"))
            return null;
        StringBuilder sb = new StringBuilder(data);
        sb.deleteCharAt(0);
        sb.deleteCharAt(sb.length()-1);
        String[] token = sb.toString().split(",");
        TreeNode root = new TreeNode(Integer.parseInt(token[0]));
        Queue<TreeNode> que = new LinkedList<>();
        que.offer(root);
        int i= 1;
        while(!que.isEmpty()){
            TreeNode curr = que.poll();
            if (!token[i].equals("null")) {
                curr.left = new TreeNode(Integer.parseInt(token[i]));
                que.offer(curr.left);
            }
            i++;
            if(!token[i].equals("null")) {
                curr.right = new TreeNode(Integer.parseInt(token[i]));
                que.offer(curr.right);
            }
            i++;
        }
        return root;
    }
}
