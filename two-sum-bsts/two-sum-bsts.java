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
    Map<Integer, Integer> map = new HashMap();
    public boolean twoSumBSTs(TreeNode root1, TreeNode root2, int target) {
        inHashSet(root1, target);
        return rootTwoPresent(root2);
    }
    
    private void inHashSet(TreeNode root, int target){
        if(root == null) return;
        inHashSet(root.left, target);
        map.put(target - root.val, root.val);
        inHashSet(root.right, target);
    }
    
    private boolean rootTwoPresent(TreeNode root){
        if(root == null) return false;
        return map.containsKey(root.val) || rootTwoPresent(root.left) || rootTwoPresent(root.right);
    }
}