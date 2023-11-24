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
    public int maxLevelSum(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        int level = 1, minLevel = 1, maxLevelSum = Integer.MIN_VALUE;

        while(!q.isEmpty()){
            int size = q.size();
            int levelSum = 0;
            while(size-- > 0){
                TreeNode curr = q.poll();
                levelSum+= curr.val;

                if(curr.left != null) q.add(curr.left);
                if(curr.right != null) q.add(curr.right);
            }
            if(levelSum > maxLevelSum){
                minLevel = level;
                maxLevelSum = levelSum;
            }
            level++;
        }
        return minLevel;
    }
}