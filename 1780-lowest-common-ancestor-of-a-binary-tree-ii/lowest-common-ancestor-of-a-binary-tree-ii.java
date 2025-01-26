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
    private boolean nodesFound = false;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode result = lca(root, p, q);
        return nodesFound ? result : null;
    }

    private TreeNode lca(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null) return root;

        int conditions = 0;
        if(root == p || root == q) conditions++;
        TreeNode left = lca(root.left, p, q);
        TreeNode right = lca(root.right, p, q);

        if(left != null) conditions++;
        if(right != null) conditions++;

        if(conditions == 2) nodesFound = true;

        if(root == p || root == q || (left != null && right != null)) return root;
        return left != null ? left : right;
    }
}