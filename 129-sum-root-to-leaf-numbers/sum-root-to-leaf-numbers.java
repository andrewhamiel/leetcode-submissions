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
        int rootToLeaf = 0, curr = 0;
        Deque<Pair<TreeNode, Integer>> stack = new ArrayDeque<>();
        stack.addFirst(new Pair(root, 0));

        while(!stack.isEmpty()){
            Pair<TreeNode, Integer> p = stack.removeFirst();
            root = p.getKey();
            curr = p.getValue();

            if(root != null){
                curr*= 10;
                curr+= root.val;
                if(root.left == null && root.right == null) rootToLeaf+= curr; //Leaf node
                else{
                    stack.addFirst(new Pair(root.right, curr));
                    stack.addFirst(new Pair(root.left, curr));
                }
            }
        }
        return rootToLeaf;
    }
}