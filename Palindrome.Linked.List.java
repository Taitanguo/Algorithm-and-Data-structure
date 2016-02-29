/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public boolean isPalindrome(ListNode head) {
        if(head == null || head.next == null)
            return true;
        Stack<ListNode> s = new Stack();
        ListNode temp = head;
        while(head != null){
            s.push(head);
            head = head.next;
        }
        while(temp != null){
            ListNode value = s.peek();
            if(temp.val != value.val)
                return false;
            else
                temp = temp.next;
                s.pop();
        }
        return true;
    }
}