package medium;

import java.util.*;

public class Solution11 {
    public List<Integer> searchRange(TreeNode root, int k1, int k2) {
        List<Integer> digits = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        if(root!=null)
            queue.add(root);
        while(!queue.isEmpty()){
            TreeNode node = queue.poll();
            if(node.val>=k1 && node.val<=k2)
                digits.add(node.val);
            if(node.left != null)
                queue.add(node.left);
            if(node.right != null)
                queue.add(node.right);
        }

        Collections.sort(digits);
        return digits;
    }

    public static void main(String[] args) {
    }
}
