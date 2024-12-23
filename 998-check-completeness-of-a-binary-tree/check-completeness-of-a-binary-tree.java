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
    public boolean isCompleteTree(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        boolean isNullFound = false;

        while(!q.isEmpty()) {
            int size = q.size();
            while(size-- > 0) {
                TreeNode curr = q.poll();
                if(curr == null) isNullFound = true;
                else {
                    if(isNullFound) return false;

                    q.add(curr.left);
                    q.add(curr.right);
                }
            }
        }
        return true;
    }
}