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
        Queue<Pair<TreeNode, Integer>> q = new LinkedList<>();
        q.add(new Pair<>(root, 0));
        int sum = 0;

        while(!q.isEmpty()){
            Pair<TreeNode, Integer> p = q.poll();
            TreeNode curr = p.getKey();
            int levelSum = p.getValue();
            levelSum*= 10;
            levelSum+= curr.val;
            if(curr.left == null && curr.right == null){
                sum+= levelSum;
                continue;
            }
            if(curr.left != null) q.add(new Pair<>(curr.left, levelSum));
            if(curr.right != null) q.add(new Pair<>(curr.right, levelSum));
        }
        return sum;
    }
}