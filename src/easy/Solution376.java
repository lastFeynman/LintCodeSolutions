package easy;

import java.util.ArrayList;
import java.util.List;

public class Solution376 {
//    public List<List<Integer>> binaryTreePathSum(TreeNode root, int target) {
//        List<List<Integer>> paths = findPath(root);
//        int i=0;
//        while(i<paths.size()){
//            int sum = 0;
//            List<Integer> path = paths.get(i);
//            for(int j=0;j<path.size();j++){
//                sum += path.get(j);
//            }
//            if(sum != target)
//                paths.remove(i);
//            else
//                i++;
//        }
//        return paths;
//    }
//    public List<List<Integer>> findPath(TreeNode root){
//        List<List<Integer>> path = new ArrayList<>();
//        if(root == null){
//            return path;
//        }
//        if(root.left == null && root.right == null){
//            List<Integer> list = new ArrayList<>();
//            list.add(root.val);
//            path.add(list);
//            return path;
//        }
//        List<List<Integer>> left = findPath(root.left);
//        List<List<Integer>> right = findPath(root.right);
//        for(int i=0;i<left.size();i++){
//            left.get(i).add(0,root.val);
//        }
//        for(int i=0;i<right.size();i++){
//            right.get(i).add(0,root.val);
//        }
//        path.addAll(left);
//        path.addAll(right);
//        return path;
//    }

    public List<List<Integer>> binaryTreePathSum(TreeNode root, int target) {
        List<List<Integer>> paths = new ArrayList<>();
        if(root == null){
            return paths;
        }
        if(root.left == null && root.right == null && root.val == target){
            List<Integer> list = new ArrayList<>();
            list.add(root.val);
            paths.add(list);
            return paths;
        }
        List<List<Integer>> left = binaryTreePathSum(root.left, target-root.val);
        List<List<Integer>> right = binaryTreePathSum(root.right, target-root.val);
        for(int i=0;i<left.size();i++){
            left.get(i).add(0,root.val);
        }
        for(int i=0;i<right.size();i++){
            right.get(i).add(0,root.val);
        }
        paths.addAll(left);
        paths.addAll(right);
        return paths;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(0);
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(5);
        TreeNode n6 = new TreeNode(6);

        root.left = n1;
        root.right = n2;
        n1.left = n3;
        n1.right = n4;
        n2.left = n5;
        n2.right = n6;

        Solution376 solution376 = new Solution376();
        solution376.binaryTreePathSum(root, 6);
    }
}
