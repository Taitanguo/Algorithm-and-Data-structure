/**
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
public class Solution {
    /**
     * @param root, the root of binary tree.
     * @return true if it is a mirror of itself, or false.
     */
    public boolean isSymmetric(TreeNode root) {
        if(root == null){
            return true;
        }
        return isSymmetric(root.left, root.right);
    }
    
    public boolean isSymmetric(TreeNode a, TreeNode b){
        //recursive terminate
        if(a == null && b == null){
            return true;
        }
        
        if(a == null || b == null){
            return false;
        }
        
        if(a.val != b.val){
            return false;
        }
        
        //recursive
        if(isSymmetric(a.left, b.right) && isSymmetric(a.right, b.left)){
            return true;
        }
        
        return false;
        
    }
}