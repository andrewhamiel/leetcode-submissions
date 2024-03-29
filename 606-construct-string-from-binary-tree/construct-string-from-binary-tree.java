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
    public String tree2str(TreeNode root) {
        StringBuilder result = new StringBuilder();
        dfs(root, result);
        return result.toString();
    }

    private void dfs(TreeNode root, StringBuilder result){
        if(root == null) return;
        result.append(root.val);
        
        if(root.left != null || root.right != null){
            result.append("(");
            dfs(root.left, result);
            result.append(")");
        }
        
        if(root.right != null) {
            result.append("(");
            dfs(root.right, result);
            result.append(")");
        }
    }
}