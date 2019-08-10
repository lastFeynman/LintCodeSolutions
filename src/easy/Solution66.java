package easy;

import sun.reflect.generics.tree.Tree;

import java.util.*;

public class Solution66 {
/// width first
//    public List<Integer> preorderTraversal(TreeNode root) {
//        List list = new ArrayList();
//        if(root == null){
//            return list;
//        }
//
//        Queue<TreeNode> queue = new LinkedList<>();
//        queue.add(root);
//        while(!queue.isEmpty()){
//            TreeNode node = queue.poll();
//            list.add(node.val);
//            if(node.left!=null){
//                queue.add(node.left);
//            }
//            if (node.right != null){
//                queue.add(node.right);
//            }
//        }
//
//
//        return list;
//    }

// recursive
//    List<Integer> list = new ArrayList<>();
//    public List<Integer> preorderTraversal(TreeNode root) {
//        if(root==null)
//            return list;
//        list.add(root.val);
//        preorderTraversal(root.left);
//        preorderTraversal(root.right);
//        return list;
//    }

// stack
    public List<Integer> preorderTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> list = new ArrayList<>();
        if(root == null){
            return list;
        }
        stack.push(root);
        TreeNode p;
        while(!stack.isEmpty()){
            p = stack.pop();
            list.add(p.val);
            if(p.right!=null){
                stack.push(p.right);
            }
            if(p.left != null){
                stack.push(p.left);
            }
        }

        return list;
    }
}
