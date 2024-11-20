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
    public int largestBSTSubtree(TreeNode root) {
        return helper(root).maxSize;
    }

    private NodeValue helper(TreeNode root) {
        if(root == null) return new NodeValue(Integer.MAX_VALUE, Integer.MIN_VALUE, 0);

        NodeValue left = helper(root.left);
        NodeValue right = helper(root.right);

        if(left.maxValue < root.val && root.val < right.minValue) {
            return new NodeValue(Math.min(left.minValue, root.val), Math.max(root.val, right.maxValue), 1 + left.maxSize + right.maxSize);
        }
        return new NodeValue(Integer.MIN_VALUE, Integer.MAX_VALUE, Math.max(left.maxSize, right.maxSize));
    }

    class NodeValue {
        int minValue = 0;
        int maxValue = 0;
        int maxSize = 0;

        public NodeValue(int minValue, int maxValue, int maxSize) {
            this.minValue = minValue;
            this.maxValue = maxValue;
            this.maxSize = maxSize;
        }
    }
}