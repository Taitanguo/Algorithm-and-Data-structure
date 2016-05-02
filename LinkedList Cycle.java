/**
 * Definition for ListNode.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int val) {
 *         this.val = val;
 *         this.next = null;
 *     }
 * }
 */
//cycle one
public class Solution {
    /**
     * @param head: The first node of linked list.
     * @return: True if it has a cycle, or false
     */
    public boolean hasCycle(ListNode head) {
        if(head == null){
            return false;
        }

        ListNode slow = head, fast = head.next;

        while(fast != null && fast.next != null){
            if(slow.next == fast.next){
                return true;
            }
            slow = slow.next;
            fast = fast.next.next;
        }

        return false;

    }
}
//cycle two
public class Solution{
    public ListNode detectCycle(ListNode head){
        if(head == null || head.next == head ){
            return head;
        }

        ListNode fast = head.next, slow = head;

        while(fast != slow){
            if(fast == null || fast.next == null){
                return null;
            }

            slow = slow.next;
            fast = fast.next.next;
        }

        while(head != slow.next){
            head = head.next;
            slow = slow.next;
        }

        return head;
    }
}
