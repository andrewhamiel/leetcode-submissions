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
        if(root == null) return new ArrayList<>();

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        q.add(null);
        TreeNode curr = root, prev;
        List<Integer> rightside = new ArrayList<>();

        while(!q.isEmpty()){
            prev = curr;
            curr = q.poll();

            while(curr != null){
                if(curr.left != null) q.add(curr.left);
                if(curr.right != null) q.add(curr.right);

                prev = curr;
                curr = q.poll();
            }

            rightside.add(prev.val);
            if(!q.isEmpty()) q.offer(null);
        }
        return rightside;
    }
}