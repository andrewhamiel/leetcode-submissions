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
    private Map<Long, Integer> map = new HashMap<>();
    private int count = 0;
    private int k = 0;

    public int pathSum(TreeNode root, int targetSum) {
        k = targetSum;
        preorder(root, 0);
        return count;
    }

    private void preorder(TreeNode root, long sum) {
        if(root == null) return; 

        sum+= root.val;
        if(sum == k) count++;
        count+= map.getOrDefault(sum - k, 0);

        map.put(sum, map.getOrDefault(sum, 0) + 1);

        preorder(root.left, sum);
        preorder(root.right, sum);

        map.put(sum, map.getOrDefault(sum, 0) - 1);
    }
}