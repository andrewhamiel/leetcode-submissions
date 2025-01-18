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
        //Key Intuition: String ordered in preorder fashion
        Deque<TreeNode> stack = new ArrayDeque<>();
        StringBuilder currNum = new StringBuilder();
        for(char c : s.toCharArray()) {
            //1. Parens or Digit/Sign
            if(c == '(' || c == ')') {
                //2. Push to stack if currNum not empty
                if(!currNum.isEmpty()) {
                    int val = Integer.parseInt(currNum.toString());
                    stack.addFirst(new TreeNode(val));
                    currNum = new StringBuilder();
                }

                //3. Right paren. Pop from stack and connect child to parent
                if(c == ')') {
                    TreeNode child = stack.removeFirst();
                    TreeNode parent = stack.peekFirst();
                    if(parent.left == null) parent.left = child;
                    else parent.right = child;
                }
            }else currNum.append(c);
        }

        //4. Add remaining num if present. ie "4"
        if(!currNum.isEmpty()) {
            int val = Integer.parseInt(currNum.toString());
            stack.addFirst(new TreeNode(val));
        }

        return stack.isEmpty() ? null : stack.removeFirst();
    }
}