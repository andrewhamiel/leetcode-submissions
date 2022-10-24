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
        if(root == null) return null;
        if(root.val < key) root.right = deleteNode(root.right, key);
        else if(root.val > key) root.left = deleteNode(root.left, key);
        else{
            //Case 1: No children
            if(root.left == null && root.right == null) root = null;
            else if(root.right != null){
                root.val = inorderSuccessor(root);
                root.right = deleteNode(root.right, root.val);
            }else{
                root.val = predecessor(root);
                root.left = deleteNode(root.left, root.val);
            }
        }
        return root;
    }
    
    //Right then always left
    private int inorderSuccessor(TreeNode root){
        TreeNode leftmost = root.right;
        while(leftmost.left != null) leftmost = leftmost.left;
        return leftmost.val;
    }
    
    //Left then always right
    private int predecessor(TreeNode root){
        TreeNode rightmost = root.left;
        while(rightmost.right != null) rightmost = rightmost.right;
        return rightmost.val;
    }
}