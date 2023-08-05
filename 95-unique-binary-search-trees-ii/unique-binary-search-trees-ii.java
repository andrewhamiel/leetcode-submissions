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
    public List<TreeNode> generateTrees(int n) {
        if(n == 0) return new LinkedList();
        return generate_trees(1, n);
    }
    
    private List<TreeNode> generate_trees(int start, int end){
        List<TreeNode> allTrees = new LinkedList();
        if(start > end){
            allTrees.add(null);
            return allTrees;
        }
        
        for(int i = start; i <= end; i++){
            List<TreeNode> leftTrees = generate_trees(start, i-1);
            List<TreeNode> rightTrees = generate_trees(i+1, end);
            for(TreeNode left : leftTrees){
                for(TreeNode right : rightTrees){
                    TreeNode curr = new TreeNode(i);
                    curr.left = left;
                    curr.right = right;
                    allTrees.add(curr);
                }
            }
        }
        return allTrees;
    }
}