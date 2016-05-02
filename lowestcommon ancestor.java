public class Solution｛
    public TreeNode LowestCommonAncestor(TreeNode root, TreeNode A, TreeNode B){
        if(root == null || root == A || root == B){
            return root;
        }

        //divide
        TreeNode left = LowestCommonAncestor(root.left, A, B);
        TreeNode right = LowestCommonAncestor(root.right, A, B);
        //conquer
        if(left != null && right != null){
            return root;
        }
        if(left != null){
            return left;
        }
        if(right != null){
            return right;
        }

        return null;
    }
｝