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
    public int sumNumbers(TreeNode root) {
        int result = 0, currDigit = 0;
        //Morris Inorder traversal
        while(root != null) {
            if(root.left != null) {
                TreeNode predecessor = root.left;
                int steps = 1;
                while(predecessor.right != null && predecessor.right != root) {
                    predecessor = predecessor.right;
                    steps++;
                }

                if(predecessor.right == null) {
                    //Unexplored
                    currDigit*= 10;
                    currDigit+= root.val;
                    predecessor.right = root;
                    root = root.left;
                }else {                   
                    if(predecessor.left == null) result+= currDigit; //Leaf node
                    for(int i = steps; i > 0; i--) currDigit/= 10;
                    predecessor.right = null;
                    root = root.right;
                }
            }else {
                currDigit*= 10;
                currDigit+= root.val;
                if(root.right == null) result+= currDigit; //Leaf node
                root = root.right;
            }
        }
        return result;
    }
}