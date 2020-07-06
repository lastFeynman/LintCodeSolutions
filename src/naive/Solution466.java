package naive;

public class Solution466 {
	public int countNodes(ListNode head) {
		int count = 0;
		ListNode p = head;
		while(p != null) {
			count++;
			p = p.next;
		}
		
        return count;
    }

	public static void main(String[] args) {

	}

}
