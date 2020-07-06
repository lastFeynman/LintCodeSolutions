package easy;

public class Solution1664 {
    public int countNodesII(ListNode head) {
        ListNode p = head;
        int count = 0;
        while(p != null){
            if(p.val%2 == 1){
                count++;
            }
            p = p.next;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(-3%2);
    }
}
