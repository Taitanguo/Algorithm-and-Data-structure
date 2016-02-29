    public ListNode reverseList(ListNode head) {
        if(head == null) return head;
        ListNode temp = null,beforehead = null;
        while(head != null){
            temp = head.next;
            head.next = beforehead;
            beforehead = head;
            head = temp;
        }
        return beforehead;
        
    }