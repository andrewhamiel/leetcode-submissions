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
    private int rootToLeaf = 0;

    public int sumNumbers(TreeNode root) {
        preorder(root, 0);
        return rootToLeaf;
    }

    private void preorder(TreeNode root, int curr){
        if(root == null) return;
        curr*= 10;
        curr+= root.val;

        //leaf node
        if(root.left == null && root.right == null) rootToLeaf+= curr;
        
        preorder(root.left, curr);
        preorder(root.right, curr);
    }
}