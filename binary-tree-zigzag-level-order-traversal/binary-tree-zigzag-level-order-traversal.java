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
    
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        traverse(root, 0);
        for(int i = 0; i < result.size(); i++){
            if(i%2 != 0) Collections.reverse(result.get(i));
        }
        return result;
    }
    
    private void traverse(TreeNode root, int level){
        //if root null return
        if(root == null) return;
        //see if level has been visited yet
        if(level == result.size()) result.add(new ArrayList());
        result.get(level).add(root.val);
        traverse(root.left, level + 1);
        traverse(root.right, level + 1);
    }
}