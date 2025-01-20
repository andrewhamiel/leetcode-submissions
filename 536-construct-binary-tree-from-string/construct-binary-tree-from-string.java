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
        StringBuilder currNum = new StringBuilder();
        for(char c : s.toCharArray()) {
            //1. Left or Right Paren
            //2. Digit or Sign
            if(c == '(' || c == ')') {
                //If value is present, add to stack
                if(!currNum.isEmpty()) {
                    int val = Integer.parseInt(currNum.toString());
                    stack.addFirst(new TreeNode(val));
                    currNum = new StringBuilder();
                }

                //If right paren, pop from stack and connect to parent
                if(c == ')') {
                    TreeNode child = stack.removeFirst();
                    TreeNode parent = stack.peekFirst();
                    if(parent.left == null) parent.left = child;
                    else parent.right = child;
                }
            }else currNum.append(c);
        }

        //3. Add remaining num to stack if present. ie "4"
        if(!currNum.isEmpty()) {
            int val = Integer.parseInt(currNum.toString());
            stack.addFirst(new TreeNode(val));
        }
        return stack.isEmpty() ? null : stack.removeFirst();
    }
}