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
    private int sum = 0;

    public int sumNumbers(TreeNode root) {
        dfs(root, 0);   
        return sum; 
    }

    private void dfs(TreeNode root, int currSum) {
        if(root == null) return;

        currSum*= 10;
        currSum+= root.val;
        if(root.left == null && root.right == null) sum+= currSum;
        else {
            dfs(root.left, currSum);
            dfs(root.right, currSum);
        }
    }
}