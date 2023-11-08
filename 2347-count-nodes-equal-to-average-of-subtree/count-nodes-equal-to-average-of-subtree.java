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
    private int count = 0;

    public int averageOfSubtree(TreeNode root) {
        postorder(root);
        return count;    
    }

    private Pair<Integer, Integer> postorder(TreeNode root){
        if(root == null) return new Pair<>(0, 0);

        Pair<Integer, Integer> left = postorder(root.left), right = postorder(root.right);

        int sum = left.getKey() + right.getKey() + root.val;
        int numNodes = left.getValue() + right.getValue() + 1;

        if(root.val == sum/numNodes) count++;
        return new Pair<>(sum, numNodes);
    }
}