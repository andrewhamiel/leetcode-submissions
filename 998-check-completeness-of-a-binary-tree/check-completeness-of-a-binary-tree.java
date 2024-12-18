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
        
        boolean isNull = false;
        while(!q.isEmpty()) {
            int size = q.size();
            while(size-- > 0) {
                TreeNode curr = q.poll();

                if(isNull && (curr.left != null || curr.right != null)) return false;

                if(curr.left == null || curr.right == null) {
                    if(curr.left == null && curr.right != null) return false;
                    else isNull = true;
                }

                if(curr.left != null) q.add(curr.left);
                if(curr.right != null) q.add(curr.right);
            }
        }
        return true;
    }
}