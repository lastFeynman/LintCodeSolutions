package easy;

import easy.TreeNode;

public class Solution900 {
	public int closestValue(TreeNode root, double target) {
		double minDiff = Math.abs(root.val - target);
		int minNode = root.val,node;
		TreeNode p = root;
		
		
		if(p.left != null)
			if(Math.abs((node=closestValue(p.left, target))-target) < minDiff) {
				minDiff = Math.abs(node-target);
				minNode = node;
			}
		if(p.right != null)
			if(Math.abs((node=closestValue(p.right, target))-target) < minDiff) {
				minDiff = Math.abs(node-target);
				minNode = node;
			}
		
		
		return minNode;
    }

	public static void main(String[] args) {
		TreeNode n1 = new TreeNode(1);
		TreeNode n2 = new TreeNode(2);
		TreeNode n3 = new TreeNode(3);
		TreeNode n4 = new TreeNode(4);
		TreeNode n5 = new TreeNode(5);
		
		n1.left = n2;
		n1.right = n3;
		n2.left = n4;
		n2.right = n5;
		
		Solution900 s = new Solution900();
		
		System.out.println(s.closestValue(n1, 5.1));
	}

}