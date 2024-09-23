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
        int mod = 0;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while(!q.isEmpty()){
            int size = q.size();
            int prev = mod % 2 == 0 ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            while(size-- > 0){
                TreeNode curr = q.poll();
                if(mod % 2 == 0){
                    if(prev >= curr.val || curr.val % 2 == 0) return false;
                }else{
                    if(prev <= curr.val || curr.val % 2 != 0) return false;
                }
                prev = curr.val;
                if(curr.left != null) q.add(curr.left);
                if(curr.right != null) q.add(curr.right);
            }
            mod++;
        }
        return true;
    }
}