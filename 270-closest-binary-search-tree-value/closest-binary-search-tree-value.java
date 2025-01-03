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
        int closest = root.val;
        while(root != null) {
            int curr = root.val;
            if(Math.abs(target - curr) < Math.abs(target - closest)
                || (Math.abs(target - curr) == Math.abs(target - closest) && curr < closest)) closest = curr;
            root = curr < target ? root.right : root.left;
        }
        return closest;
    }
}