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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        int level = 0;

        while(root != null){
            if(root.right != null){
                TreeNode successor = root.right;
                int backDepth = 1;
                while(successor.left != null && successor.left != root){
                    successor = successor.left;
                    backDepth++;
                }

                if(successor.left == null){
                    //Unexplored
                    if(level == result.size()) result.add(root.val);
                    level++;
                    successor.left = root;
                    root = root.right;
                }else{
                    //Already explored, need to unlink
                    level-= backDepth;
                    successor.left = null;
                    root = root.left;
                }
            }else{
                if(level == result.size()) result.add(root.val);
                level++;
                root = root.left;
            }
        }
        return result;
    }
}