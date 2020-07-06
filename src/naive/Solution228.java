package naive;


public class Solution228 {
    public ListNode middleNode(ListNode head) {
        int count = 0;
        ListNode p = head;
        while(p != null){
            count++;
            p = p.next;
        }
        p = head;
        int mid = (count-1) / 2;
        for(int i=0;i<mid; i++){
            p = p.next;
        }
        return p;
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
