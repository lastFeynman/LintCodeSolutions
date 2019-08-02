package easy;
import java.util.ArrayList;
import java.util.List;
public class Solution822 {
	public List<Integer> reverseStore(ListNode head) {
        List<Integer> list = new ArrayList<>();
        ListNode p = head;
        while(p!=null) {
        	list.add(0,p.val);
        	p=p.next;
        }
        return list;
    }
}

class ListNode{
	int val;
	ListNode next;
}