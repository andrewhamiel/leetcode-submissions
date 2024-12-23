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
    private int k = 0, count = 0;

    public int pathSum(TreeNode root, int targetSum) {
        k = targetSum;
        preorder(root, 0);    
        return count;
    }

    private void preorder(TreeNode root, long currSum) {
        if(root == null) return;

        currSum+= root.val;
        if(currSum == k) count++;
        count+= map.getOrDefault(currSum - k, 0);

        map.put(currSum, map.getOrDefault(currSum, 0) + 1);

        preorder(root.left, currSum);
        preorder(root.right, currSum);

        map.put(currSum, map.getOrDefault(currSum, 0) - 1);
    }
}