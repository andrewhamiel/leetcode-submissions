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
    public int sumEvenGrandparent(TreeNode root) {
        Queue<TreeNode> children = new LinkedList<>(), q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            TreeNode curr = q.poll();
            if(curr.val % 2 == 0){
                if(curr.left != null) children.add(curr.left);
                if(curr.right != null) children.add(curr.right);
            }
            if(curr.left != null) q.add(curr.left);
            if(curr.right != null) q.add(curr.right);
        }

        int sum = 0;
        while(!children.isEmpty()){
            TreeNode child = children.poll();
            if(child.left != null) sum+= child.left.val;
            if(child.right != null) sum+= child.right.val;
        }
        return sum;
    }
}