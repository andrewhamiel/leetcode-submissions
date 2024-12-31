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
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root == null) return root;

        if(root.val < key) root.right = deleteNode(root.right, key);
        else if(root.val > key) root.left = deleteNode(root.left, key);
        else {
            //3 cases: leaf, left child present, only right child
            if(root.left == null && root.right == null) return null;
            else if(root.left != null) {
                root.val = predecessor(root);
                root.left = deleteNode(root.left, root.val);
            }else {
                root.val = inorderSuccessor(root);
                root.right = deleteNode(root.right, root.val);
            }
        }
        return root;
    }

    private int predecessor(TreeNode root) {
        TreeNode predecessor = root.left;
        while(predecessor.right != null) predecessor = predecessor.right;
        return predecessor.val;
    }

    private int inorderSuccessor(TreeNode root) {
        TreeNode curr = root.right;
        while(curr.left != null) curr = curr.left;
        return curr.val;
    }
}