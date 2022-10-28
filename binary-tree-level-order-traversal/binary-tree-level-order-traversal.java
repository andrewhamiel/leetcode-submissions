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
    List<List<Integer>> result = new ArrayList();
    
    public List<List<Integer>> levelOrder(TreeNode root) {
        level(root, 0);
        return result;
    }
    
    private void level(TreeNode root, int level){
        if(root == null) return;
        if(result.size() == level) result.add(new ArrayList());
        result.get(level).add(root.val);
        level(root.left, level + 1);
        level(root.right, level + 1);
    }
}