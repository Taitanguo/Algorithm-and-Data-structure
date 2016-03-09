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
 * Definition of TreeNode:
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left, right;
 *     public TreeNode(int val) {
 *         this.val = val;
 *         this.left = this.right = null;
 *     }
 * }
 */

//solution one convert the LinkedList to a ArrayList, Consequently, we can use middle find to solve this question
public class Solution {
    /**
     * @param head: The first node of linked list.
     * @return: a tree node
     */
    public TreeNode sortedListToBST(ListNode head) {
        if(head == null){
            return null;
        }

        ArrayList<Integer> num = new ArrayList<Integer>();
        while(head != null){
            num.add(head.val);
            head = head.next;
        }

        return buildTree(num, 0, num.size() - 1);
    }

    private TreeNode buildTree(ArrayList<Integer> num, int start, int end){
        if(start > end){
            return null;
        }

        TreeNode node = new TreeNode(num.get((start + end)/2));
        node.left = buildTree(num, start, (start + end)/2 - 1);
        node.right = buildTree(num, (start + end)/2 + 1, end);
        return node;
    }
}
//time complexity O(n)
//solution two

public class Solution{
    private ListNode current;
    public TreeNode sortedListToBST(ListNode head){
        int size;
        current = head;
        size = getListLength(head);

        return sortedListToBSTHelper(size);

    }

    public TreeNode sortedListToBSTHelper(int size){
        if(size < 0){
            return null;
        }

        TreeNode left = sortedListToBSTHelper(size / 2);
        TreeNode root = new TreeNode(current.val);
        current = current.next;
        TreeNode right = sortedListToBSTHelper(size - 1 - size/2);

        root.left = left;
        root.right = right;

        return root;
    }
}

// time complexity O(N)
//inorder traversal can output the sorted array from bst
//inoder recursion of LinkedList can output bst