package easy;

public class Solution466 {
    public int countNodes(ListNode head) {
        int count = 0;
        while(head != null){
            count++;
            head = head.next;
        }
        return count;
    }
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
          val = x;
          next = null;
        }
    }
}
