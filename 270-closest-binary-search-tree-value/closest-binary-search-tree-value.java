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
    public int closestValue(TreeNode root, double target) {
        if(root == null) return Integer.MAX_VALUE;

        int closest = root.val;
        int left = closestValue(root.left, target);
        int right = closestValue(root.right, target);

        if(Math.abs(target - left) <= Math.abs(target - closest)) closest = left;
        if(Math.abs(target - right) < Math.abs(target - closest)) closest = right;
        return closest;
    }
}