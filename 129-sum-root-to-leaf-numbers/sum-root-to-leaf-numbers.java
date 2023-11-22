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
        int rootToLeaf = 0, currNumber = 0;

        while(root != null){
          if(root.left != null){
            TreeNode predecessor = root.left;
            int steps = 1;
            while(predecessor.right != null && predecessor.right != root) {
              predecessor = predecessor.right;
              steps++;
            }
            //unexplored
            if(predecessor.right == null){
              currNumber*= 10;
              currNumber+= root.val;
              predecessor.right = root;
              root = root.left;
            }else{
              //explored, need to unlink
              if(predecessor.left == null) rootToLeaf+= currNumber; //leaf node
              for(int i = 0; i < steps; i++){
                currNumber/= 10;
              }
              predecessor.right = null;
              root = root.right;
            }
          }else{
              //No left child
              currNumber*= 10;
              currNumber+= root.val;
              if(root.right == null) rootToLeaf+= currNumber;
              root = root.right;
          }
        }
        return rootToLeaf;
    }
}