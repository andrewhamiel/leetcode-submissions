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
            TreeNode node = p.getKey();
            int currSum = p.getValue();

            currSum*=10;
            currSum+= node.val;

            if(node.left == null && node.right == null) sum+= currSum; //leaf node
            if(node.left != null) q.add(new Pair<>(node.left, currSum));
            if(node.right != null) q.add(new Pair<>(node.right, currSum));
        }
        return sum;
    }
}