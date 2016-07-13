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

//   1             1
//    / \           / \
//   2   3   and   3   2
//  /                   \
// 4                     4
public class Solution{
	public boolean isTweakedIdentical(TreeNode a, TreeNode b){
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
		if(isTweakedIdentical(a.left, b.left) && isTweakedIdentical(a.right, b.right)){
		    return true;
		}
		
		if(isTweakedIdentical(a.left, b.right) && isTweakedIdentical(a.right, b.left)){
		    return true;
		}
		
	    return false;
	}
}