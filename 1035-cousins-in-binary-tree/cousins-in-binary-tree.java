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
    public boolean isCousins(TreeNode root, int x, int y) {
        Queue<TreeNode> q = new LinkedList<>();
        if(root.val == x || root.val == y) return false;
        q.add(root);
        Map<TreeNode, TreeNode> map = new HashMap<>();

        while(!q.isEmpty()){
            int size = q.size();
            boolean foundX = false, foundY = false;
            TreeNode left = null, right = null;
            while(size-- > 0){
                TreeNode curr = q.poll();
                if(curr.val == x) {
                    left = curr;
                }
                if(curr.val == y) {
                    right = curr;
                }
                if(left != null && right != null){
                    if(!map.containsKey(left) || !map.containsKey(right) || map.get(left) == map.get(right)) return false;
                    return true;
                }
                if(curr.left != null) {
                    map.put(curr.left, curr);
                    q.add(curr.left);
                }
                if(curr.right != null){
                    map.put(curr.right, curr);
                    q.add(curr.right);
                } 
            }
        }
        return false;
    }
}