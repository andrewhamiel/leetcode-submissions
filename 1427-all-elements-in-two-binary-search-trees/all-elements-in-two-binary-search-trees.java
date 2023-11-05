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
        Deque<TreeNode> stack1 = new ArrayDeque<>(), stack2 = new ArrayDeque<>();
        List<Integer> output = new ArrayList<>();

        while(root1 != null || root2 != null || !stack1.isEmpty() || !stack2.isEmpty()){
          while(root1 != null){
            stack1.addFirst(root1);
            root1 = root1.left;
          }
          while(root2 != null){
            stack2.addFirst(root2);
            root2 = root2.left;
          }
          if(stack2.isEmpty() || !stack1.isEmpty() && stack1.peekFirst().val <= stack2.peekFirst().val){
            root1 = stack1.removeFirst();
            output.add(root1.val);
            root1 = root1.right;
          }else{
            root2 = stack2.removeFirst();
            output.add(root2.val);
            root2 = root2.right;
          }
        }
        return output;
    }
}