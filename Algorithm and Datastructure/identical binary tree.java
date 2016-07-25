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

//use recursion solve this problem
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
public class Solution{
    public boolean isIdentical(TreeNode a, TreeNode b){
        //reversive judgement 
        if(a == null && b == null){
            return true;
        }
        if(a == null || b == null){
            return false;
        }
        if(a.val != b.val){
            return false;
        }
        //reversive part
        if(isIdentical(a.left, b.left) && isIdentical(a.right, b.right)){
            return true;
        }
        
        return false;
    }
}