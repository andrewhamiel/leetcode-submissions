/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    private TreeNode ans;
    
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        isSubtree(root, p, q);
        return ans;
    }
    
    private boolean isSubtree(TreeNode root, TreeNode p, TreeNode q){
        if(root == null) return false;
        
        int left = isSubtree(root.left, p, q) ? 1 : 0;
        int right = isSubtree(root.right, p, q) ? 1 : 0;
        int mid = (root == p || root == q) ? 1 : 0;
        if(left + right + mid >= 2) ans = root;
        return (left + right + mid) > 0;
    }
}