public class Solution {
    /**
     * @param root: The root of the tree
     * @param A, B: Two node in the tree
     * @return: The lowest common ancestor of A and B
     */
    public ParentTreeNode lowestCommonAncestorII(ParentTreeNode root,
                                                 ParentTreeNode A,
                                                 ParentTreeNode B) {
        // Write your code here
        if (root == null) {
            return null;
        }
        if (root == A || root == B) {
            return root;
        }

        ParentTreeNode left = lowestCommonAncestorII(root.left, A, B);
        ParentTreeNode right = lowestCommonAncestorII(root.right, A, B);
        if (left != null && right != null) {
            return root;
        } else if (left != null) {
            return left;
        } else if (right != null) {
            return right;
        } else {
            return null;
        }        
    }
}