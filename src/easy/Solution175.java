package easy;

import java.util.Stack;

public class Solution175 {
    //recursive
//    public void invertBinaryTree(TreeNode root) {
//        if(root == null){
//            return;
//        }
//        invertBinaryTree(root.left);
//        invertBinaryTree(root.right);
//        TreeNode t = root.left;
//        root.left = root.right;
//        root.right = t;
//    }
    // without recursive
    public void invertBinaryTree(TreeNode root) {
        if(root == null){
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        TreeNode p;
        while(!stack.isEmpty()){
            p = stack.pop();
            TreeNode t = p.left;
            p.left = p.right;
            p.right = t;
            if(p.right != null){
                stack.push(p.right);
            }
            if(p.left != null){
                stack.push(p.left);
            }
        }
    }
}
