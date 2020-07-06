package medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution7 {
    public String serialize(TreeNode root) {
        StringBuffer str = new StringBuffer();
        str.append("{");
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while(!queue.isEmpty()){
            TreeNode node = queue.poll();
            if(node == null){
                str.append("#,");
                continue;
            }
            str.append(node.val).append(",");
            queue.add(node.left);
            queue.add(node.right);
        }
        str.replace(str.length()-1, str.length(),"}");
        return new String(str);
    }

    public TreeNode deserialize(String data) {
        if(data.length() <= 2 || data.charAt(1) == '#'){
            return null;
        }

        Pattern pattern = Pattern.compile("([0-9#]+)");
        Matcher matcher = pattern.matcher(data);
        List<String> nodes = new ArrayList<>();
        while(matcher.find())
            nodes.add(matcher.group(1));
        TreeNode root = new TreeNode(Integer.parseInt(nodes.get(0)));
        List<TreeNode> all = new ArrayList<>();
        all.add(root);

        int i = 1;
        int j = 0;
        while(i<nodes.size()){
            String val = nodes.get(i);
            if("#".equals(val)){
                i++;
                j++;
                continue;
            }
            TreeNode node = new TreeNode(Integer.parseInt(val));
            TreeNode parent = all.get(j/2);
            all.add(node);
            if(j%2==0){
                parent.left = node;
            }else{
                parent.right = node;
            }
            j++;
            i++;
        }
        return root;
    }

    public static void main(String[] args) {

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