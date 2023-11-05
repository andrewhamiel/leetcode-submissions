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
        return getAllElementsWithMorrisLaw(root1, root2);
    }

    private List<Integer> getAllElementsWithMorrisLaw(TreeNode root1, TreeNode root2){
      TreeNode current1 = root1, current2 = root2;
      List<Integer> result = new ArrayList<>();

      while(current1 != null && current2 != null){
        //Leftmost
        while(current1.left != null){
          TreeNode leftmost = current1.left;
          while(leftmost.right != null && leftmost.right != current1){
            leftmost = leftmost.right;
          }
          if(leftmost.right == null){
            leftmost.right = current1;
            current1 = current1.left;
          }else break;
        }

        while(current2.left != null){
          TreeNode leftmost = current2.left;
          while(leftmost.right != null && leftmost.right != current2){
            leftmost = leftmost.right;
          }
          
          if(leftmost.right == null){
            leftmost.right = current2;
            current2 = current2.left;
          }else break;
        }

        //Both current1 and current2 have been conditioned, now compare
        if(current1.val <= current2.val){
          result.add(current1.val);
          current1 = current1.right;
        }else{
          result.add(current2.val);
          current2 = current2.right;
        }
      }
      //If there are remaining nodes in one tree
      inorderTraversalUsingMorris(current1, result);
      inorderTraversalUsingMorris(current2, result);

      return result;
    }

    private void inorderTraversalUsingMorris(TreeNode root, List<Integer> result){
      TreeNode current = root;
      while(current != null){
        if(current.left == null){
          result.add(current.val);
          current = current.right;
        }else{
          TreeNode leftmost = current.left;
          while(leftmost.right != null && leftmost.right != current){
            leftmost = leftmost.right;
          }

          if(leftmost.right == null){
            leftmost.right = current;
            current = current.left;
          }else{
            leftmost.right = null;
            result.add(current.val);
            current = current.right;
          }
        }
      }
    }
}