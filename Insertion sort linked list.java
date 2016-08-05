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
public class Solution {
    /**
     * @param head: The first node of linked list.
     * @return: The head of linked list.
     */
    public ListNode insertionSortList(ListNode head) {
        //construct a new node for insertion
        ListNode dummy = new ListNode(0);
        if(head == null){
            return head;
        }
        // always move head pointer
        //scan dummy list in order to insert
        while(head != null){
            ListNode node = dummy;
            //if the dummy val less than head.val just move to next loop
            while(node.next != null && node.next.val < head.val){
                //find the position
                node = node.next;
            }
            //find the point and insert head to dummy list
            ListNode temp = head.next;
            head.next = node.next;
            node.next = head;
            //move head pointer to next
            head = temp;
        }
        return dummy.next;


    }
}