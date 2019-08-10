package easy;

import java.util.LinkedList;
import java.util.Queue;

public class Solution1759 {
    public int getAns(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        int count = 0;
        if(root == null){
            return count;
        }
        queue.add(root);
        TreeNode p;
        while(!queue.isEmpty()){
            p = queue.poll();
            if(p.left != null)
                queue.add(p.left);
            if(p.right != null)
                queue.add(p.right);
            count++;
        }

        return count;
    }
}
