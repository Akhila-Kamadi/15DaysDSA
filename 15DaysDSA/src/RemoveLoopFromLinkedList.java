public class RemoveLoopFromLinkedList {
    class ListNode {
        public int val;
        public ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    ListNode meetNode = null;
    private boolean checkCycle(ListNode A){
        ListNode slow = A, fast = A;
        while(fast!=null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast){
                meetNode = slow;
                return true;
            }
        }
        return false;
    }
    public ListNode solve(ListNode A) {
        ListNode slow1 = A, slow2 = null;
        if (checkCycle(A)){
            slow2 = meetNode;
            while (slow1.next != slow2.next){
                slow1 = slow1.next;
                slow2 = slow2.next;
            }
            slow1 = slow1.next;
            slow2.next = null;
        }
        return A;
    }
}
