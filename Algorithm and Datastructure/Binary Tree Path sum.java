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

public class Solution{
	public List<List<Integer>> binaryTreePathSum(TreeNode root, int target){
		List<List<Integer>> result = new ArrayList<>();
		if(root == null){
			return result;
		}

		ArrayList<Integer> path = new ArrayList<Integer>();
		path.add(root.val);
		helper(root, path, root.val, target, result);
		return result;
	}

	private void helper(TreeNode root,
		ArrayList<Integer> path,
		int sum,
		int target,
		List<List<Integer>> result){
		//meet any leaf then terminate this recursive
		if(root.left == null && root.right == null){
			if(sum == target){
				result.add(new ArrayList<Integer>(path));
			}
			return;
		}

		//go left
		if(root.left != null){
			path.add(root.left.val);
			helper(root.left, path, sum + root.left.val, target, result);
			path.remove(path.size() - 1);
		}

		//go right
		if (root.right != null){
			path.add(root.right.val);
			helper(root.right, path, sum + root.right.val, target, result);
			path.remove(path.size() - 1);
		}
	}
}