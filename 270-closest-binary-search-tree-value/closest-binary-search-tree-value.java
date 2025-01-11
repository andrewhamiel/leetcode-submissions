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
        int closest = Integer.MAX_VALUE;
        while(root != null) {
            double closestDiff = Math.abs(target - closest), currDiff = Math.abs(target - root.val);
            if(currDiff < closestDiff || (currDiff == closestDiff && root.val < closest)) closest = root.val;
            root = root.val > target ? root.left : root.right;
        }
        return closest;
    }
}