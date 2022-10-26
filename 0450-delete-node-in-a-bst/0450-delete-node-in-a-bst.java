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
    // 1. Binary Search Tree, we can find if the node exists either recursively or iteratively
    // 1. Time complexity does not change for either, it's O(h) or O(log(n))
    // 2. If it is found, we have to delete. To delete, need to replace in a balanced way
    // a. if it is a leaf node, value becomes null
    // b. if its right child is not null, replace with its in-order successor
    // c. else if left child is not null, replace with its predecessor
    public TreeNode deleteNode(TreeNode root, int key) {
        //base case
        if(root == null) return null;
        //1. search for node to remove
        //if root's value is < key, we need to search the right right side of BST
        if(root.val < key) root.right = deleteNode(root.right, key);
        else if(root.val > key) root.left = deleteNode(root.left, key);
        //if it is equal, we've found it and need to delete node
        else if(root.val == key){
            //2. if node is found, delete node
            //a. leaf node: no right or left child
            if(root.left == null && root.right == null) root = null;
            else if(root.right != null){
                //find inorder successor to replace the node
                root.val = inorderSuccessor(root);
                //clean up rest of tree
                root.right = deleteNode(root.right, root.val);
            }else if(root.left != null){
                //find the predecessor to replace the node
                root.val = predecessor(root);
                //clean up old node
                root.left = deleteNode(root.left, root.val);
            }
        }
        return root;
    }
    
    /*
    * we go right then always left (min > than root.val)
    */
    private int inorderSuccessor(TreeNode root){
        TreeNode leftmost = root.right;
        while(leftmost.left != null) leftmost = leftmost.left;
        return leftmost.val;
    }
    
    /*
    * we go left, then always right (max < root.val)
    */
    private int predecessor(TreeNode root){
        TreeNode rightmost = root.left;
        while(rightmost.right != null) rightmost = rightmost.right;
        return rightmost.val;
    }
}