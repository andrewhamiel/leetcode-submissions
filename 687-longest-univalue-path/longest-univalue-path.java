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

    public int longestUnivaluePath(TreeNode root) {
        solve(root, -1);
        return ans;
    }

    private int solve(TreeNode root, int parent){
        if(root == null) return 0;

        int left = solve(root.left, root.val);
        int right = solve(root.right, root.val);

        ans = Math.max(ans, left + right);
        return root.val == parent ? 1 + Math.max(left, right) : 0;
    }
}