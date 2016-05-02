public class ListNode{
    int val;
    ListNode next;
    ListNode(int x){
        val = x;
        next = null;
    }
}

public class Solution{
    public ListNode[] rehashing(ListNode[] hashTable){
        if(hashTable.length <= 0){
            return hashTable;
        }
        int newcapacity = 2# hashTable.length;
        ListNode[] newTable = new ListNodep[newcapacity];
        for(int i = 0; i < hashTable.length; i++){
            while(hashTable[i] != null){
                int newIndex = (hashTable[i].val % newcapacity + newcapacity) % newcapacity;
                if(newTable[newIndex] == null){
                    newTable[newIndex] = new ListNode(hashTable][i].val);
                }else{
                    ListNode dummy = newTable[newIndex];
                    while(dummy.next != null){
                        dummy = dummy.next;}
                    dummy.next = new ListNode(hashTable[i].val);
                }
                hashTable[i] = hashTable[i].next;
            }
        }
        return newTable;
    }
}