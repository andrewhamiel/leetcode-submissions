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
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        int closest = root.val;

        while(!q.isEmpty()){
          TreeNode curr = q.poll();
          if(curr.val == target) return curr.val;
          if(Math.abs(target - curr.val) < Math.abs(target - closest)||
          (Math.abs(target - curr.val) == Math.abs(target - closest) && curr.val < closest)) closest = curr.val;

          if(curr.left != null) q.add(curr.left);
          if(curr.right != null) q.add(curr.right);
        }
        return closest;
    }
}