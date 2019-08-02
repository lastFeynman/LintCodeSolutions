package naive;

public class Solution632 {
	int max = Integer.MIN_VALUE;
	TreeNode maxNode;
	public TreeNode maxNode(TreeNode root) {
        if(root != null) {
        	if(root.val > max) {
        		max = root.val;
        		maxNode = root;
        	}
        	maxNode(root.left);
        	maxNode(root.right);
        }
        return maxNode;
    }
}

class TreeNode{
	public int val;
	public TreeNode left, right;
	public TreeNode(int val) {
		this.val = val;
		this.left = this.right = null;
	}
}