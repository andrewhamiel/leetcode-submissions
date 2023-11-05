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
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        TreeNode current1 = root1, current2 = root2;
        List<Integer> result = new ArrayList<>();

        while(current1 != null && current2 != null){
          //Get predecessor for current1 and current2
          while(current1.left != null){
            TreeNode predecessor = current1.left;
            while(predecessor.right != null && predecessor.right != current1) predecessor = predecessor.right;

            if(predecessor.right == null){
              predecessor.right = current1;
              current1 = current1.left;
            }else break;
          }
          while(current2.left != null){
            TreeNode predecessor = current2.left;
            while(predecessor.right != null && predecessor.right != current2) predecessor = predecessor.right;

            if(predecessor.right == null){
              predecessor.right = current2;
              current2 = current2.left;
            }else break;
          }

          //Compare
          if(current1.val <= current2.val){
            result.add(current1.val);
            current1 = current1.right;
          }else{
            result.add(current2.val);
            current2 = current2.right;
          }
        }

        //Handle any remaining nodes if one not null
        inorderTraversalUsingMorris(current1, result);
        inorderTraversalUsingMorris(current2, result);

        return result;
    }

    private void inorderTraversalUsingMorris(TreeNode root, List<Integer> result){
      TreeNode current = root;
      while(current != null){
        //Find predecessor
        if(current.left != null){
          TreeNode predecessor = current.left;
          while(predecessor.right != null && predecessor.right != current) predecessor = predecessor.right;

          if(predecessor.right == null){
            predecessor.right = current;
            current = current.left;
          }else{
            predecessor.right = null;
            result.add(current.val);
            current = current.right;
          }
        }else{
          result.add(current.val);
          current = current.right;
        }
      }
    }
}