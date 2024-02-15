class Solution {
  public TreeNode bstFromPreorder(int[] preorder) {
    int n = preorder.length;
    if (n == 0) return null;

    TreeNode root = new TreeNode(preorder[0]);
    Deque<TreeNode> stack = new ArrayDeque<TreeNode>();
    stack.addFirst(root);

    for (int i = 1; i < n; i++) {
      //Take the last element of the deque as a parent
      // and create a child from the next preorder element
      TreeNode node = stack.peekFirst();
      TreeNode child = new TreeNode(preorder[i]);
      //Adjust the parent 
      while (!stack.isEmpty() && stack.peekFirst().val < child.val)
        node = stack.pop();

      // follow BST logic to create a parent-child link
      if (node.val < child.val) node.right = child;
      else node.left = child;
      // add the child into deque
      stack.addFirst(child);
    }
    return root;
  }
}