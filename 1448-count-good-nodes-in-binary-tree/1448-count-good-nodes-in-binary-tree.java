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
    public int goodNodes(TreeNode root) {
        return 1 + isGood(root.left, root.val) 
            + isGood(root.right, root.val);
    }
    
    private int isGood(TreeNode root, int max){
        if(root == null) return 0;
        int count = 0;
        if(max <= root.val) count++;
        max = Math.max(max, root.val);
        return count + isGood(root.left, max) + isGood(root.right, max);
    }
}