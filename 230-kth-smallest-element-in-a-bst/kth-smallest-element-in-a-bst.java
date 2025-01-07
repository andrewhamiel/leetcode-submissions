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
        Deque<TreeNode> stack = new ArrayDeque<>();
        //Inorder traversal
        while(true) {
            //Left
            while(root != null) {
                stack.addFirst(root);
                root = root.left;
            }
            //Root
            root = stack.removeFirst();
            k--;
            if(k == 0) return root.val;
            //Right
            root = root.right;
        }
    }
}