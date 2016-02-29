/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    //function of finding the length of the ListNode
    private int ListN_length(ListNode head){
        int len = 0;
        while(head != null){
            head = head.next;
            len++;
        }
        return len;
    }
    
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
    //find the two linkedlists' length
    //move head to make them the same length;
    //compare and move together until find the intersection or null
    int lenA = ListN_length(headA), lenB = ListN_length(headB);
    while(lenA > lenB){
        headA = headA.next;
        lenA--;
    }
    while(lenB > lenA){
    headB = headB.next;
    lenB--;
    }
    while(headA != headB){
        headA = headA.next;
        headB = headB.next;
    }
    return headA;  //this contains the case that if the two linkedlists do not have the intersection, and the headA becomes null
    }
}