package easy;

import java.util.ArrayList;
import java.util.List;

public class Solution480 {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> list = new ArrayList<>();
        if(root == null){
            return list;
        }
        if(root.left == null && root.right == null){
            list.add(root.val+"");
            return list;
        }

        List<String> left = binaryTreePaths(root.left);
        List<String> right = binaryTreePaths(root.right);
        for(int i=0;i<left.size();i++){
            left.set(i, root.val+"->"+left.get(i));
        }
        for(int i=0;i<right.size();i++){
            right.set(i, root.val+"->"+right.get(i));
        }
        list.addAll(left);
        list.addAll(right);
        return list;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(0);
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(5);

        root.left = n1;
        root.right = n2;
        n1.left = n3;
        n1.right = n4;
        n2.left = n5;

        Solution480 solution480 = new Solution480();

        System.out.println(solution480.binaryTreePaths(null));
        System.out.println(solution480.binaryTreePaths(root));
    }
}
