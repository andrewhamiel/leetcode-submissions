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
                //Add current value to stack
                if(sb.length() > 0) {
                    stack.addFirst(new TreeNode(Integer.parseInt(sb.toString())));
                    sb = new StringBuilder();
                }
                //If close parens, pop from stack
                if(c == ')') {
                    TreeNode removed = stack.removeFirst();
                    if(stack.peekFirst().left == null) stack.peekFirst().left = removed;
                    else stack.peekFirst().right = removed;
                }
            }else sb.append(c); //2. Digit or sign
        }
        //3. Add remaining value to stack if present
        if(sb.length() > 0) stack.addFirst(new TreeNode(Integer.parseInt(sb.toString())));

        return stack.isEmpty() ? null : stack.removeFirst();
    }
}