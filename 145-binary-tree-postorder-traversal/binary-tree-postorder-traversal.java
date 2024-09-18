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
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        while(root != null) {
            if(root.right != null) {
                TreeNode successor = root.right;
                while(successor.left != null && successor.left != root) successor = successor.left;

                if(successor.left == null) {
                    // unexplored
                    result.add(root.val);
                    successor.left = root;
                    root = root.right;
                }else{
                    successor.left = null;
                    root = root.left;
                }
            }else{
                result.add(root.val);
                root = root.left;
            }
        }

        Collections.reverse(result);
        return result;
    }
}