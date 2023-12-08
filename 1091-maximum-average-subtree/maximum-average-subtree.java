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
    private double max = Double.MIN_VALUE;
    Map<TreeNode, Integer> map = new HashMap<>();

    public double maximumAverageSubtree(TreeNode root) {
        dfs(root);
        return max;
    }

    private int dfs(TreeNode root){
        if(root == null) return 0;
        if(map.containsKey(root)) return map.get(root);

        int left = dfs(root.left), right = dfs(root.right);

        int leftNodes = map.getOrDefault(root.left, 0);
        int rightNodes = map.getOrDefault(root.right, 0);

        int sum = left + right + root.val;

        double avg = (double)sum/(leftNodes + rightNodes + 1);
        max = Math.max(max, avg);

        map.put(root, leftNodes + rightNodes + 1);
        return sum;
    }
}