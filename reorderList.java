public class Solution{
    public void reorderList(ListNode head){
        if(head == null || head.next == null){
            return;}

        ListNode mid = findMiddle(head);
        ListNode tail = reverse(mid);
        mid.next = null;

        merge(head, tail);

    }

    private ListNode findMiddle(ListNode head){
        ListNode slow = head;
        ListNode fast = head.next;
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    private ListNode reverse(ListNode head){
        ListNode newhead = null;
        while(head != null){
            ListNode temp = head.next;
                     head.next = newhead;
                     newhead = head;
                     head = temp;
                    }
            return newhead;
    }

    private void merge(ListNode head1, ListNode head2){
        int index = 0;
        ListNode dummy = new ListNode(0);
        while(head1 != null && head2 != null){
            if(index%2 == 0){
                dummy.next = head1;
                head1 = head1.next;
            }else{
                dummy.next = head2;
                head2 = head2.next;
            }
            dummy = dummy.next;
            index++;
        }
        if(head1 != null){
            dummy.next = head1;
        }else {
            dummy.next = head2;
        }
    }
}