package easy;

import java.util.ArrayList;
import java.util.List;

public class Solution67 {
	public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>();
        if(root == null)
        	return list;
        
        TreeNode nodeP = root;
        ArrayList<TreeNode> stack = new ArrayList<TreeNode>();
        boolean flag = true;
        do {
        	if(flag) {
        		stack.add(nodeP);
        		if(nodeP.left != null) {
        			nodeP = nodeP.left;
        			continue;
        		}
        	}
    		list.add(stack.get(stack.size()-1).val);
    		stack.remove(stack.size()-1);
        	if(nodeP.right != null) {
        		flag = true;
        		nodeP = nodeP.right;
        		continue;
        	}
        	if(!stack.isEmpty())
        		nodeP = stack.get(stack.size()-1);
        	flag = false;
        }while(stack.size() != 0 || (stack.isEmpty() && flag == true));
        
        return list;
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
		
		Solution67 s = new Solution67();
		List<Integer> list = s.inorderTraversal(root);
		for(int i=0;i<list.size();i++) {
			System.out.print(list.get(i)+" ");
		}
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