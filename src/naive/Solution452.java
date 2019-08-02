package naive;
public class Solution452 {
	public ListNode removeElements(ListNode head, int val) {
		ListNode p = head,preP = null;
        while(p != null) {
        	if(preP == null) {
        		if(p.val == val) {
        			p = p.next;
        			head = head.next;
        			continue;
        		}else {
        			preP = p;
        			p = p.next;
        			continue;
        		}
        	}
        	
        	if(p.val == val) {
        		preP.next = p.next;
        		p = p.next;
        	}else {
        		preP = p;
        		p = p.next;
        	}
        }
		
		return head;
    }

	public static void main(String[] args) {
		Solution452 s = new Solution452();
		ListNode head = new ListNode(1);
		ListNode p = head;
		p.next = new ListNode(2);
		p = p.next;
		p.next = new ListNode(1);
		p = p.next;
		p.next = new ListNode(2);
		p = p.next;
		p.next = new ListNode(1);
		p = head;
		while(p != null) {
			System.out.print(p.val);
			p = p.next;
		}
		System.out.println();
		head = s.removeElements(head, 1);
		p = head;
		while(p != null) {
			System.out.println(p.val);
			p = p.next;
		}
	}

}

class ListNode {
	int val;
	ListNode next;
	ListNode(int x) {
		val = x;
		next = null;
	}
}