/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(q==null&&p==null){
            return true;
        }
        else if(q==null&&p!=null){
            return false;
        }
        else if(q!=null&&p==null){
            return false;
        }
        if(p.val!=q.val){
            return false;
        }
        if(!isSameTree(p.left,q.left)){
            return false;
        }
        if(!isSameTree(p.right,q.right)){
            return false;
        }
        return true;
        }
    }
}