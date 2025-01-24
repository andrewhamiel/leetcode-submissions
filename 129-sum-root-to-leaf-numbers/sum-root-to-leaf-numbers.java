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
        int result = 0, currNum = 0;
        //Inorder Morris Traversal
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
                    currNum*= 10;
                    currNum+= root.val;
                    predecessor.right = root;
                    root = root.left;
                }else {
                    if(predecessor.left == null) result+= currNum; //Leaf node
                    for(int i = steps; i > 0; i--) currNum/= 10;
                    predecessor.right = null;
                    root = root.right;
                }
            }else {
                currNum*= 10;
                currNum+= root.val;
                if(root.right == null) result+= currNum;
                root = root.right;
            }
        }
        return result;
    }
}