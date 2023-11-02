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
    TreeNode ans;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        lca(root, p, q);
        return ans;
    }

    private boolean lca(TreeNode root, TreeNode p, TreeNode q){
        if(root == null) return false;

        int left = lca(root.left, p, q) ? 1 : 0;
        int mid = root.val == p.val || root.val == q.val ? 1 : 0;
        int right = lca(root.right, p, q) ? 1 : 0;
        if(left + right + mid >= 2) ans = root;
        return left + right + mid >= 1;
    }
}