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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if(root == null){
            return res;
        }
        Stack<TreeNode> s1 = new Stack<TreeNode>();
        Stack<TreeNode> s2 = new Stack<TreeNode>();
        s1.push(root);
        while(!s1.isEmpty()){
            if(!s1.isEmpty()){
                List<Integer> list = new ArrayList<Integer>();
                while(!s1.isEmpty()){
                    TreeNode node = s1.pop();
                    list.add(node.val);
                    if(node.left != null){
                        s2.push(node.left);
                    }
                    if(node.right != null){
                        s2.push(node.right);
                    }
                }
                res.add(list);
            }
            if(!s2.isEmpty()){
                List<Integer> list = new ArrayList<Integer>();
                while(!s2.isEmpty()){
                    TreeNode node = s2.pop();
                    list.add(node.val);
                    if(node.right != null){
                        s1.push(node.right);
                    }
                    if(node.left != null){
                        s1.push(node.left);
                    }
                }
                res.add(list);
            }
        }
        return res;
    }
}