/**
 * Definition for ListNode
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */

// hashset is easier actually
public class Solution {
    /**
     * @param head: The first node of linked list.
     * @return: head node
     */
    public ListNode removeDuplicates(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        head = dummy;

        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

        while(head.next != null){
            if(map.get(head.next.val) != null){
                head.next = head.next.next;
            }else{
                map.put(head.next.val, 1);
                head = head.next;

            }
            }
            return dummy.next;
        }
    }