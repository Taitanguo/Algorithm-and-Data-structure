public class TreeNode{
    public TreeNode left;
    public TreeNode right;
    public int value;
    public TreeNode(int value){
        TreeNode this.left, this.right = null;
        int this.value = value;
    }
}

public class Solution{
    public Arraylist<ArrayList<Integer>> levelOeder(TreeNode root){
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        ArrayList<ArrayList<Integer>> result = ArrayList<ArrayList<Integer>>();
        if(root == null){
            return result;
        }

        queue.offer(root);

        while(!queue.isEmpty()){
            int length = queue.size();
            ArrayList<Integer> level = new ArrayList<Integer>();
            for(int i = 0; i < length; i++){
                TreeNode node = queue.poll();
                level.add(node.value);
                if(node.left != null){
                    queue.offer(node.left);
                }
                if(node.right != null){
                    queue.offer(node.right);
                }
            }
            result.add(level.value);
        }
        return result;
    }
}

// timecomplexity N  payattention to linkedlist offer and returntype  isEmpty