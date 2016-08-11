public class Solution{
    public boolean isBalanced(TreeNode root){
        //define -1 means not balanced
        return maxDepth(root) != -1;
    }

    private int maxDepth(TreeNode root){
        if(root == null){
            return 0;
        }

        //divide
        left = maxDepth(root.left);
        right = maxDepth(root.right);

        //conquer
        if(left == -1 || right == -1 || Math.abs(left - right) > 1){
            return -1;
        }
        //return depth of this subtree
        return Math.max(left, right) + 1;
    }
}
