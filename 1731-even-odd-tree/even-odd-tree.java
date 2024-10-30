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
    public boolean isEvenOddTree(TreeNode root) {
        int level = 0;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while(!q.isEmpty()){
            boolean isEvenLevel = level % 2 == 0;
            int size = q.size(), prev = isEvenLevel ? 0 : Integer.MAX_VALUE;
            while(size-- > 0) {
                TreeNode curr = q.poll();
                if(isEvenLevel && (curr.val % 2 == 0 || curr.val <= prev)) return false;
                else if(!isEvenLevel && (curr.val % 2 != 0 || curr.val >= prev)) return false;
                prev = curr.val;
                if(curr.left != null) q.add(curr.left);
                if(curr.right != null) q.add(curr.right);
            }
            level++;
        }
        return true;
    }
}