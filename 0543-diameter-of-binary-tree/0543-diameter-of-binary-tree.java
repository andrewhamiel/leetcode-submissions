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
    private int diameter = 0;
    
    public int diameterOfBinaryTree(TreeNode root) {
        dfs(root);
        return diameter;
    }
    
    private int dfs(TreeNode root){
        if(root == null) return 0;
        int leftPath = dfs(root.left);
        int rightPath = dfs(root.right);
        diameter = Math.max(diameter, leftPath + rightPath);
        return Math.max(leftPath, rightPath) + 1;
    }
}