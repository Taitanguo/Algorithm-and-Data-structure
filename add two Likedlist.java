//solution one

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
// public class Solution {
//     /**
//      * @param l1: the first list
//      * @param l2: the second list
//      * @return: the sum list of l1 and l2
//      */
//     public ListNode addLists(ListNode l1, ListNode l2) {
//         ListNode dummy = new ListNode(0);
//         dummy.next = l2;
//         //prejudge
//         if(l1 == null || l2 == null){
//             if(l1 == null){
//                 return l1;
//             }
//             return l2;
//         }
//         //while loop
//         while(l2 != null && l1 != null){
//             //consition which < 10, no carry bit needed
//             if(l2.val + l1.val < 10)
//             {l2.val += l1.val;}
//             //carry bit needed
//             else{
//                 //sum last two bits exceed 10, add a new node
//                 if(l2.next == null){
//                 l2.val = l1.val + l2.val - 10;
//                 ListNode a = new ListNode(1);
//                 l2.next = a;
//             }else{
//                 l2.val = l1.val + l2.val - 10;
//                 //l1 is not long enough, need carry bit to l2
//                 if(l1.next == null){
//                     l2.next.val += 1;
//                 }else{
//                     l1.next.val += 1;}
//                 }
//             }
//             //move to next Node
//             l1 = l1.next;
//             l2 = l2.next;
//         }
//         //return val
//         return dummy.next;
//     }
// // }
// solution: 2
public class Solution {
    public ListNode addLists(ListNode l1, ListNode l2) {
        if(l1 == null && l2 == null) {
            return null;
        }

        ListNode head = new ListNode(0);
        ListNode point = head;
        int carry = 0;
        //same length
        while(l1 != null && l2!=null){
            int sum = carry + l1.val + l2.val;
            point.next = new ListNode(sum % 10);
            carry = sum / 10;
            l1 = l1.next;
            l2 = l2.next;
            point = point.next;
        }
        //l1 longer
        while(l1 != null) {
            int sum =  carry + l1.val;
            point.next = new ListNode(sum % 10);
            carry = sum /10;
            l1 = l1.next;
            point = point.next;
        }
        //l2 longer
        while(l2 != null) {
            int sum =  carry + l2.val;
            point.next = new ListNode(sum % 10);
            carry = sum /10;
            l2 = l2.next;
            point = point.next;
        }
        //not long enough
        if (carry != 0) {
            point.next = new ListNode(carry);
        }
        return head.next;
    }
}