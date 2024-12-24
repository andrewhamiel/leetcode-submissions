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
        return postorder(root).maxSize;
    }

    private NodeValue postorder(TreeNode root) {
        if(root == null) return new NodeValue(Integer.MAX_VALUE, Integer.MIN_VALUE, 0);

        NodeValue left = postorder(root.left), right = postorder(root.right);

        if(left.maxVal < root.val && root.val < right.minVal) {
            return new NodeValue(Math.min(left.minVal, root.val), Math.max(root.val, right.maxVal), 1 + left.maxSize + right.maxSize);
        }
        return new NodeValue(Integer.MIN_VALUE, Integer.MAX_VALUE, Math.max(left.maxSize, right.maxSize));
    }

    class NodeValue {
        int minVal = 0;
        int maxVal = 0;
        int maxSize = 0;

        public NodeValue(int minVal, int maxVal, int maxSize) {
            this.minVal = minVal;
            this.maxVal = maxVal;
            this.maxSize = maxSize;
        }
    }
}