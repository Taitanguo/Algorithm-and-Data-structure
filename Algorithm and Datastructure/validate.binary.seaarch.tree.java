//defintion of tree node
public class TreeNode{
    public int val;
    public TreeNode left, right;
    public TreeNode(int val){
        this.left = null;
        this.right = null;
        this.val = val;
    }
}

public class ResultType{
    boolean is_bst;
    int min_value;
    int max_value;

    public ResultType{
        this.is_bst = is_bst;
        this.min_value = min_value;
        this.max_value = max_value;
    }
}

public class solution{
    public boolean validbst(TreeNode root){
         ResultType r = helper(root);
         return ResultType r.is_bst;
    }

    private ResultType helper(TreeNode root){
        //if root == null which means already to the the leaf of the tree, it's must be a bst
        if(root == null){
            return new ResultType(true, Integer.min_value, Integer.max_value)
        }
        //divide
        ResultType left = helper(root.left);
        ResultType right = helper(root.right);
        //conquer
        if(!left.is_bst || !right.is_bst){
            return new ResultType(false, 0, 0);
        }

        if(root.left != null && left.maxvalue >= root.val || root.right != null && right.min_value <= root.val){
            return new ResultType(false, 0 , 0);
        }

        return new ResultType(true,
                                math.Max(root.val, right.max_value),
                                math.Min(root.val, left.min_value));

    }
}