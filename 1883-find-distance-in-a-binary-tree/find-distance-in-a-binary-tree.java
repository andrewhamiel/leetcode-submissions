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
    int minDistance = 10000;

    public int findDistance(TreeNode root, int p, int q) {
        //LCA
        TreeNode lca = lca(root, p, q);

        //Dist
        int h1 = depth(lca, p, 0);
        int h2 = depth(lca, q, 0);
        return h1 + h2;
    }

    private int depth(TreeNode root, int val, int index){
        if(root == null) return 0;
        if(root.val == val) return index;

        int depth = depth(root.left, val, index + 1);
        return depth != 0 ? depth : depth(root.right, val, index + 1);
    }

    private TreeNode lca(TreeNode root, int p, int q){
        if(root == null) return root;
        if(root.val == p || root.val == q) return root;

        TreeNode left = lca(root.left, p, q);

        TreeNode right = lca(root.right, p, q);
        if(left != null && right != null) return root;
        return left != null ? left : right;
    }
}