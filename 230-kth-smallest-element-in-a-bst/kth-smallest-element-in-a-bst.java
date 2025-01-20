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
    public int kthSmallest(TreeNode root, int k) {
        //Inorder Morris Traversal
        while(root != null) {
            if(root.left != null) {
                TreeNode predecessor = root.left;
                while(predecessor.right != null && predecessor.right != root) predecessor = predecessor.right;

                if(predecessor.right == null) {
                    //Unexplored
                    predecessor.right = root;
                    root = root.left;
                }else {
                    k--;
                    if(k == 0) return root.val;
                    predecessor.right = root;
                    root = root.right;
                }
            }else {
                k--;
                if(k == 0) return root.val;
                root = root.right;
            }
        }
        return -1;
    }
}