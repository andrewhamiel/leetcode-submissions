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
    public TreeNode str2tree(String s) {
        Deque<TreeNode> stack = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();

        for(char c : s.toCharArray()) {
            //1. Parens
            if(c == '(' || c == ')') {
                //Add curr val to stack
                if(!sb.isEmpty()) {
                    stack.addFirst(new TreeNode(Integer.parseInt(sb.toString())));
                    sb = new StringBuilder();
                }
                //If right paren, pop from stack and set as child node
                if(c == ')') {
                    TreeNode child = stack.removeFirst();
                    if(stack.peekFirst().left == null) stack.peekFirst().left = child;
                    else stack.peekFirst().right = child;
                }
            }else sb.append(c); //2. Digit or sign
        }
        //3. Add remaining val to stack if present -> ie s = "4"
        if(!sb.isEmpty()) stack.addFirst(new TreeNode(Integer.parseInt(sb.toString())));

        return stack.isEmpty() ? null : stack.removeFirst();
    }
}