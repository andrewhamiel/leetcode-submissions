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
        int rootToLeaves = 0, currNum = 0;
        while(root != null){
            if(root.left != null){
                int steps = 1;
                TreeNode predecessor = root.left;
                while(predecessor.right != null && predecessor.right != root){
                    predecessor = predecessor.right;
                    steps++;
                }

                if(predecessor.right == null){
                    //unexplored
                    currNum*= 10;
                    currNum+= root.val;
                    predecessor.right = root;
                    root = root.left;
                }else{
                    if(predecessor.left == null) rootToLeaves+= currNum;
                    for(int i = 0; i < steps; i++) currNum/= 10;
                    predecessor.right = null;
                    root = root.right;
                }
            }else{
                currNum*= 10;
                currNum+= root.val;
                if(root.left == null && root.right == null) rootToLeaves+= currNum;
                root = root.right;
            }
        }
        return rootToLeaves;
    }
}