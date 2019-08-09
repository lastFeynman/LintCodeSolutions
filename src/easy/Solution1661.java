package easy;

public class Solution1661 {
    public ListNode deleteNode(ListNode head, int n, int m) {
        if(n == 0){
            for(int i=0;i<m+1;i++){
                head = head.next;
            }
            return head;
        }

        ListNode p = head;
        for(int i=0;i<n-1;i++){
            if(p!=null)
                p = p.next;
            else
                return head;
        }
        int count = m-n+1;
        int i=0;
        while(p.next != null && p != null && i < m-n+1){
            p.next = p.next.next;
            i++;
        }

        return head;
    }
}
