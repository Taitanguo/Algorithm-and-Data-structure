class ResultType {
    public int depth;
    public boolean isFull, isComplete;
    ResultType(int depth, boolean isFull, boolean isComplete) {
        this.depth = depth;
        this.isFull = isFull;
        this.isComplete = isComplete;
    }
}

public class Solution {
    /**
     * @param root, the root of binary tree.
     * @return true if it is a complete binary tree, or false.
     */
    public boolean isComplete(TreeNode root) {
        ResultType result = helper(root);
        return result.isComplete;
    }
    
    private ResultType helper(TreeNode root) {
        if (root == null) {
            return new ResultType(0, true, true);
        }
        
        ResultType left = helper(root.left);
        ResultType right = helper(root.right);
        if (!left.isComplete) {
            return new ResultType(-1, false, false);
        }
        
        // depth is the same, left should be full and right should be complete
        if (left.depth == right.depth) {
            if (!left.isFull || !right.isComplete) {
                return new ResultType(-1, false, false);
            }
            return new ResultType(left.depth + 1, right.isFull, true);
        }
        
        // left.depth = right.depth + 1, left should be complete and right should be full
        if (left.depth == right.depth + 1) {
            if (!left.isComplete || !right.isFull) {
                return new ResultType(-1, false, false);
            }
            return new ResultType(left.depth + 1, false, true);
        }
        
        return new ResultType(-1, false, false);
    }
}