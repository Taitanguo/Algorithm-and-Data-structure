//merge sort
public class Solution {
    private ListNode findMiddle(ListNode head) {
        ListNode slow = head, fast = head.next;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    private ListNode merge(ListNode head1, ListNode head2) {
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;
        while (head1 != null && head2 != null) {
            if (head1.val < head2.val) {
                tail.next = head1;
                head1 = head1.next;
            } else {
                tail.next = head2;
                head2 = head2.next;
            }
            tail = tail.next;
        }
        if (head1 != null) {
            tail.next = head1;
        } else {
            tail.next = head2;
        }

        return dummy.next;
    }

    public ListNode sortList(ListNode head) {
        //base case, which exist in every recursion
        if (head == null || head.next == null) {
            return head;
        }
        //find the mid
        ListNode mid = findMiddle(head);
        //divide
        ListNode right = sortList(mid.next);
        mid.next = null;
        ListNode left = sortList(head);
        //conquer
        return merge(left, right);
    }
}
//O(Nlog(N)) since divide into unique element need log(N) time like the  depth of tree, and each level takes N to compare
//quick sort 1
public class Solution{
public ListNode sortList(ListNode head){
    if(head == null || head.next == null){
    return}
    ListNode mid = findMidian(head); //O(N)

    ListNode leftDummy = new ListNode(0), leftTail = leftDummy;
    ListNode rightDummy = new ListNode(0), rightTail = rightDummy;
    ListNode middleDummy = new ListNode(0), middleTail = middleDummy;

    while(head != null){   //O(1)
        if(head.val < mid.val){
            leftTail.next = head;
            leftTail = leftTail.next;
        }else if(head.val > mid.val){
            rightTail.next = head;
            rightTail = rightTail.next;
        }else{
            middleTail.next = head;
            middleTail = middleTail.next;
        }
        head = head.next;
    }

    leftTail.next = null;
    rightTail.next = null;
    middleTail,next = null;

    ListNode left = sortList(leftDummy.next);
    ListNode right = sortList(rightDummy.next);

    return concat(left, middleDummy.next, right); //O(N)
    }

    private ListNode findMidian(listNode head){  //O(N)
        ListNode slow = head, fast = head.next;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }


    private ListNode concat(ListNode left, listNode middle, listNode right){ //O(N)
        ListNode dummy = new  listNode(0), tail = dummy;

        tail.next = left; tail = getTail(tail);
        tail.next = middle; tail = getTail(tail);
        tail.next = right; tail = getTail(tail);
        return dummy.next;
    }

    private ListNode getTail(ListNode head){ //O(N)
        if(head == null){
            return null;
        }

        while(head.next != null){
            head = head.next;
        }

        return head;
    }
}

//Timecomplexity = O(N * N)