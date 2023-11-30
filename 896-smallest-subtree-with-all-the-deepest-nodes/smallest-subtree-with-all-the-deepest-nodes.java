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
    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        TreeNode first = null, last = null;

        while(!q.isEmpty()){
            int size = q.size();
            for(int i = 0; i < size; i++){
                TreeNode curr = q.poll();
                if(i == 0) first = curr;
                if(i == size - 1) last = curr;

                if(curr.left != null) q.add(curr.left);
                if(curr.right != null) q.add(curr.right);
            }
        }

        return lca(root, first, last);
    }

    private TreeNode lca(TreeNode root, TreeNode p, TreeNode q){
        if(root == null) return root;

        if(root == p || root == q) return root;

        TreeNode left = lca(root.left, p, q);
        TreeNode right = lca(root.right, p, q);

        if(left != null && right != null) return root;

        return left != null ? left : right;
    }
}