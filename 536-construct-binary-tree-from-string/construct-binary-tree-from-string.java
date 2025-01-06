class Solution {
    public TreeNode str2tree(String s) {
        final Deque<TreeNode> stack = new ArrayDeque<>();
        final StringBuilder sb = new StringBuilder();
        
        for (char c: s.toCharArray()) {
            //1. Parens
            if (c == '(' || c == ')') {
                //Add current value to stack
                if (sb.length() > 0) { 
                    stack.addFirst(new TreeNode(Integer.parseInt(sb.toString())));
                    sb.delete(0, sb.length());
                }
                //If close paren, start popping
                if (c == ')') { 
                    TreeNode top = stack.removeFirst();
                    if (stack.peekFirst().left == null) stack.peekFirst().left = top;
                    else stack.peekFirst().right = top;
                }
            } else sb.append(c); //2. Digit or sign
        }
        //3. Place unadded value on stack if present ie -> s = "4"
        if (sb.length() > 0) stack.addFirst(new TreeNode(Integer.parseInt(sb.toString())));
        
        return stack.isEmpty() ? null : stack.removeFirst();
    }
}