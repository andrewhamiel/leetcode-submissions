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
            if(Math.abs(target - root.val) < Math.abs(target - closest)
                || (Math.abs(target - root.val) == Math.abs(target - closest) && root.val < closest)) closest = root.val;
            root = root.val > target ? root.left : root.right;
        }
        return closest;
    }
}