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
    private int ans = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        dfs(root);
        return ans;    
    }

    private int dfs(TreeNode root){
        if(root == null) return 0;

        int left = dfs(root.left), right = dfs(root.right);
        ans = Math.max(ans, left + right);
        return 1 + Math.max(left, right);
    }
}