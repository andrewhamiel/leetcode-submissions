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
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
          TreeNode curr = q.poll();
          if(curr.val == target) return curr.val;
          
          if(Math.abs(target - curr.val) < Math.abs(target - closest) || (Math.abs(target - curr.val) == Math.abs(target - closest) && curr.val < closest)){
            closest = curr.val;
          }

          if(curr.val > target && curr.left != null) q.add(curr.left);
          else if(curr.val < target && curr.right != null) q.add(curr.right);
        }
        return closest;
    }
}