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
        if(root == null) return 0;

        Queue<Pair<TreeNode, Integer>> q = new LinkedList<>();
        q.add(new Pair<>(root, 0));

        int sum = 0;

        while(!q.isEmpty()) {
            int size = q.size();
            while(size-- > 0) {
                Pair<TreeNode, Integer> p = q.poll();
                TreeNode curr = p.getKey();
                int currSum = p.getValue();
                
                currSum*= 10;
                currSum+= curr.val;

                if(curr.left == null && curr.right == null) sum+= currSum;

                if(curr.left != null) q.add(new Pair<>(curr.left, currSum));
                if(curr.right != null) q.add(new Pair<>(curr.right, currSum));
            }
        }
        return sum;
    }
}