class Solution {
    // Both left and right traversal pending for a node.
    // Indicates the nodes children are yet to be traversed.
    private static int BOTH_PENDING = 2;
    // Left traversal done.
    private static int LEFT_DONE = 1;
    // Both left and right traversal done for a node.
    // Indicates the node can be popped off the stack.
    private static int BOTH_DONE = 0;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        Stack<Pair<TreeNode, Integer>> stack = new Stack<Pair<TreeNode, Integer>>();
        stack.push(new Pair<TreeNode, Integer>(root, Solution.BOTH_PENDING));

        boolean one_node_found = false;
        TreeNode LCA = null, child_node = null;

        // We do a post order traversal of the binary tree using stack
        while (!stack.isEmpty()) {
            Pair<TreeNode, Integer> top = stack.peek();
            TreeNode parent_node = top.getKey();
            int parent_state = top.getValue();

            // If the parent_state is not equal to BOTH_DONE,
            // this means the parent_node can't be popped off yet.
            if (parent_state != Solution.BOTH_DONE) {
                if (parent_state == Solution.BOTH_PENDING) {
                    if (parent_node == p || parent_node == q) {
                        // If one_node_found was set already, this means we have found
                        // both the nodes.
                        if (one_node_found) return LCA;
                        else {
                            one_node_found = true;
                            // Save the current top element of stack as the LCA.
                            LCA = stack.peek().getKey();
                        }
                    }
                    // If both pending, traverse the left child first
                    child_node = parent_node.left;
                } else child_node = parent_node.right;
                // Update the node state at the top of the stack
                // Since we have visited one more child.
                stack.pop();
                stack.push(new Pair<TreeNode, Integer>(parent_node, parent_state - 1));

                // Add the child node to the stack for traversal.
                if (child_node != null) stack.push(new Pair<TreeNode, Integer>(child_node, Solution.BOTH_PENDING));
            } else {
                // If the parent_state of the node is both done,
                // the top node could be popped off the stack.
                // Update the LCA node to be the next top node.
                if (LCA == stack.pop().getKey()) LCA = stack.peek().getKey();
            }
        }
        return null;
    }
}