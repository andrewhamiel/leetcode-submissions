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
    public TreeNode balanceBST(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if(root == null) return root;

        inorder(root, list);
        TreeNode ans = balance(0, list.size() - 1, list);
        return ans;
    }

    private void inorder(TreeNode root, List<Integer> list){
      if(root == null) return;
      inorder(root.left, list);
      list.add(root.val);
      inorder(root.right, list);
    }

    private TreeNode balance(int left, int right, List<Integer> list){
      if(left > right) return null;

      int mid = left + (right - left)/2;
      TreeNode root = new TreeNode(list.get(mid));
      root.left = balance(left, mid-1, list);
      root.right = balance(mid+1, right, list);
      return root;
    }
}