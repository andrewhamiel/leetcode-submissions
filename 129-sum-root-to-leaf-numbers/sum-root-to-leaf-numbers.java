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
        int rootToLeaves = 0, currValue = 0;
        while(root != null){
            if(root.left != null){
                TreeNode predecessor = root.left;
                int steps = 1;
                while(predecessor.right != null && predecessor.right != root) {
                    steps++;
                    predecessor = predecessor.right;
                }

                if(predecessor.right == null){
                    //unexplored
                    currValue*= 10;
                    currValue+= root.val;
                    predecessor.right = root;
                    root = root.left;
                }else{
                    if(predecessor.left == null) rootToLeaves+= currValue;
                    for(int i = 0; i < steps; i++) currValue/= 10;
                    predecessor.right = null;
                    root = root.right;
                }
            }else{
                currValue*= 10;
                currValue+= root.val;
                if(root.left == null && root.right == null) rootToLeaves+= currValue;
                root = root.right;
            }
        }
        return rootToLeaves;
    }
}