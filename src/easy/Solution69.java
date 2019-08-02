package easy;

import java.util.ArrayList;
import java.util.List;
import easy.TreeNode;

public class Solution69 {
	int deep = -1;
	ArrayList<ArrayList<Integer>> treeNodes = new ArrayList<ArrayList<Integer>>();
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<List<Integer>> levelOrder(TreeNode root) {
		deep++;
		if(root != null) {
			if(treeNodes.size()-1 < deep)
				treeNodes.add(new ArrayList<Integer>());
			treeNodes.get(deep).add(root.val);
			levelOrder(root.left);
			levelOrder(root.right);
		}
		deep--;
        return (List)treeNodes;
    }

	public static void main(String[] args) {
		Solution69 s = new Solution69();
		TreeNode t0 = new TreeNode(0);
		TreeNode t1 = new TreeNode(1);
		TreeNode t2 = new TreeNode(2);
		t0.left = t1;
		t0.right = t2;
		List<List<Integer>> list = s.levelOrder(t0);
		for(int i=0;i<list.size();i++) {
			for(int j=0;j<list.get(i).size();j++) {
				System.out.print(list.get(i).get(j));
			}
			System.out.println();
		}
	}

}