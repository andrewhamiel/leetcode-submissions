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
    public TreeNode pruneTree(TreeNode root) {
        //Base case
        if(root == null) return root;

        //Children 
        if(root.left != null) root.left = pruneTree(root.left);
        if(root.right != null) root.right = pruneTree(root.right);

        //Postorder -> Evaluate root
        return root.left == null && root.right == null && root.val != 1 ? null : root;
    }
}