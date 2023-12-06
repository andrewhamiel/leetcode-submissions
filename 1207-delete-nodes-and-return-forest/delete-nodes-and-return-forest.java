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
  Set<Integer> nodes = new HashSet<>();

  public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
    for(int val : to_delete) nodes.add(val);

    List<TreeNode> result = new ArrayList<>();
    if(!delete(root, result)) result.add(root);
    return result;      
  }

  private boolean delete(TreeNode root, List<TreeNode> list){
    if(root == null) return true;

    if(nodes.contains(root.val)){
      if(!delete(root.left, list)) list.add(root.left);
      if(!delete(root.right, list)) list.add(root.right);

      return true;
    }else{
      if(delete(root.left, list)) root.left = null;
      if(delete(root.right, list)) root.right = null;

      return false;
    }
  }
}