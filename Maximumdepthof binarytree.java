public class Solution{
    //depth is used for record the largest depth
    private int depth = 0;
    public int maxDepth(TreeNode root){
        helper(root, 1);
        return depth;
    }

    private void helper(TreeNode root, int curDepth){
        //recursion stop condition
        if(root == null){
            return;
        }

        if(curDepth > depth){
            depth = curDepth;
        }
        //traverse
        helper(root.left, curDepth + 1);
        helper(root.right, curDepth + 1);

    }

}