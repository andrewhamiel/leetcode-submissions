/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    List<List<Integer>> ans = new ArrayList();
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        traversePath(root, targetSum, new ArrayList());
        return ans;
    }
    
    private void traversePath(TreeNode root, int targetSum, List<Integer> currentPath){
        if(root == null || Math.abs(targetSum - root.val) < 0) return;
        currentPath.add(root.val);
        targetSum-=root.val;
        if(targetSum == 0 && root.left == null && root.right == null){
            ans.add(currentPath);
            return;
        }
        if(root.left != null) traversePath(root.left, targetSum, new ArrayList(currentPath));
        if(root.right != null) traversePath(root.right, targetSum, new ArrayList(currentPath));
    }
}