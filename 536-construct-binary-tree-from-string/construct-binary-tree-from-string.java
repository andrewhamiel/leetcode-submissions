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
 currNum: 1 
 stack: {4}
 4.left = 2
 4.right = 3
 */
class Solution {
    public TreeNode str2tree(String s) {
        //Preorder traversal
        Deque<TreeNode> stack = new ArrayDeque<>();
        StringBuilder currNum = new StringBuilder();
        for(char c : s.toCharArray()) {
            //1. Parens or Digit/sign
            if(c == '(' || c == ')') {
                //2. Add num to stack
                if(!currNum.isEmpty()) {
                    int val = Integer.parseInt(currNum.toString());
                    stack.addFirst(new TreeNode(val));
                    currNum = new StringBuilder();
                }
                //3. If right paren, pop from stack and link to parent             
                if(c == ')') {
                    TreeNode child = stack.removeFirst();
                    TreeNode parent = stack.peekFirst();
                    if(parent.left == null) parent.left = child;
                    else parent.right = child;
                }
            }else currNum.append(c);
        }

        //4. Add remaining number to stack if present
        if(!currNum.isEmpty()) {
            int val = Integer.parseInt(currNum.toString());
            stack.addFirst(new TreeNode(val));
        }

        return stack.isEmpty() ? null : stack.removeFirst();
    }
}