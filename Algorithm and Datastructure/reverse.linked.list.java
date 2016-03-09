public class ListNode{
    int val;
    ListNode next;
    public ListNode(int val){
        this.val = val;
        this.next = null;
    }
}

//null recursion
public class Solution{
    public ListNode reverse(ListNode head){
        if(head == null){
            return head
    }
        ListNode pre = null;
        ListNode temp = null;
        while(head != null){
            temp = head.next;
            head.next = pre;
            pre = head;
            head = temp;
        }

        return head;

}
// O(N)
public class ReverseLinkedlist(ListNode L){
    public static ListNode Reverse{
        //1. check whether we need reverse or not in case L is empty or only has one element
        if(L == null || L.next == null){
            return L;
        }
        //2.now use the recursive way to find the end of this linkedlist
        ListNode remainingReverse = Reverse(L.next);

        //3. we find the tail of the remainingreverse and update this tail as our beginning element

        ListNode cur = remainingReverse;
        while(cur.next != null){
            cur = cur.next;
        }

        //now cur.next == null, this is the tail position
        cur.next = L; // reverse the tail to the previous ListNode

        //reverse the L.next == null;
        L.next = null;

        //laststep, return the linkedlist
        return remainingReverse;// always points at the head of reverse linkedlist

    }
}

//timecomplexity O(N) N to the 2 + N;
//recursion


public ListNode reverseKGroup(ListNode head, int k) {
    ListNode curr = head;
    int count = 0;
    while (curr != null && count != k) { // find the k+1 node
        curr = curr.next;
        count++;
    }
    if (count == k) { // if k+1 node is found
        curr = reverseKGroup(curr, k); // reverse list with k+1 node as head
        // head - head-pointer to direct part,
        // curr - head-pointer to reversed part;
        while (count-- > 0) { // reverse current k-group:
            ListNode tmp = head.next; // tmp - next head in direct part
            head.next = curr; // preappending "direct" head to the reversed list
            curr = head; // move head of reversed part to a new node
            head = tmp; // move "direct" head to the next node in direct part
        }
        head = curr;
    }
    return head;
}
