/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode swapPairs(ListNode head) {
        if ((head == null)||(head.next == null))
            return head;
        ListNode n = head.next;
        head.next = swapPairs(head.next.next);
        n.next = head;
        return n;
    }
}



public class Solution {
    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode h = new ListNode(0);
        h.next = head;
        ListNode p = h;
        
        while(p.next != null && p.next.next != null){
            ListNode q = p;
            p = p.next;
            q.next = p.next;
            
            ListNode t = p.next.next;
            p.next.next = p;
            p.next = t;
        }
        return h.next;
    }
}