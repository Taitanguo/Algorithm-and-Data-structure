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
    /**
     * @param head: the List
     * @param k: rotate to the right k places
     * @return: the list after rotation
     */
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || k == 0|| head.next == null){
            return head;
        }
                   
        ListNode start = new ListNode(0);
        ListNode dummy0 = head;
        ListNode dummy1 = head;
        start = head;
        int length = 0;
        //set the location of k 
        //in case k is longer than linkedlist
        for(int i = 0; i < k; i++){
            length++;
            if(dummy1.next == null){
                k= k % length;
                if(k == 0){// even times
                    return head;
                }
                break;
            }
            dummy1 = dummy1.next;
        }
        for(int i = 0; i < k; i++){//odd times or less than linkedlist length
            head = head.next;
        }
        //find start point and tail point
        while(head.next != null){
            head = head.next;
            start = start.next;
        }
        //rotate list
        ListNode dummy = start.next;
        start.next = null;
        head.next = dummy0;
        
        return dummy;
    }
}